package com.mentoring.pages.kieskeurig;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.getJsExecutor;
import static com.mentoring.core.ConciseAPI.waitFor;

public class BasePage {

    private static By catalogItem = By.cssSelector(".js-product-lists .product-tile");

    public void clickLoginButton() {

        waitFor(ExpectedConditions.titleContains("Kieskeurig.nl"));

        By loginButton = By.cssSelector(".site-header__content .js-show-login");
        clickOnElementLocated(loginButton);
    }

    public void enterDisplayName(String login) {

        By loginInput = By.cssSelector("[name=account_displayname]");
        fillInputWithText(loginInput, login);
    }

    public void enterEmail(String email) {

        By emailInput = By.cssSelector("[name=user-register] [name=account_email]");
        fillInputWithText(emailInput, email);
    }

    public void enterPassword(String password) {

        By passwordInput = By.cssSelector("[name=user-register] [name=password]");
        fillInputWithText(passwordInput, password);
    }

    public void confirmPassword(String password) {

        By confirmPasswordInput = By.cssSelector("[name=user-register] [name=password-verify]");
        fillInputWithText(confirmPasswordInput, password);
    }

    public void enterFirstName(String firstName) {

        By firstNameField = By.cssSelector("[name=account_first_name]");
        fillInputWithText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {

        By lastNameField = By.cssSelector("[name=account_last_name]");
        fillInputWithText(lastNameField, lastName);
    }

    public void clickRegisterButton() {

        By registerButton = By.cssSelector("[name=user-register] .btn--blue--inline");
        clickOnElementLocated(registerButton);

        By messageVerification = By.cssSelector(".modal-login__right .msg");
        waitFor(ExpectedConditions.visibilityOfElementLocated(messageVerification));
    }

    public void acceptCookies() {

        By acceptCookiesButton = By.cssSelector(".modal-consent__right .js-consent-accept");
        if (getDriver().findElement(acceptCookiesButton).isDisplayed()) {
            clickOnElementLocated(acceptCookiesButton);
        }
    }

    public void openLoginTabOnModal() {

        By loginTab = By.cssSelector(".js-user-login--login-toggle");
        clickOnElementLocated(loginTab);
    }

    public void setLoginEmailAddress(String email) {

        By emailAddressInput = By.cssSelector("[name=user-login] [name=username]");
        fillInputWithText(emailAddressInput, email);
    }

    public void setLoginPassword(String password) {

        By passwordInput = By.cssSelector("[name=user-login] [name=password]");
        fillInputWithText(passwordInput, password);
    }

    public void clickLoginButtonOnModal() {

        By loginButton = By.cssSelector("[name=user-login] .btn--blue--inline");
        clickOnElementLocated(loginButton);
    }

    public String getUserName() {

        By userName = By.cssSelector(".site-header__usp .js-username");
        return waitFor(ExpectedConditions.visibilityOfElementLocated(userName)).getText();
    }

    public void openSmartphonesCatalog() {

        By smartphonesLink = By.cssSelector(".cat-tile a[href='/smartphone']");
        clickOnElementLocated(smartphonesLink);
    }

    public void expandFilters() {

        By filtersLink = By.cssSelector(".sidebar .product-sorting");
        clickOnElementLocated(filtersLink);
    }

    public void chooseSortingBy(String sortingType) {

        By filterOption = By.cssSelector(".sidebar .product-sorting label");
        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(filterOption)).stream()
                .filter(p -> p.getText().equalsIgnoreCase(sortingType))
                .findFirst()
                .orElseThrow(NoSuchElementException::new).click();
    }

    public void waitForResultsToLoad() {
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem));
    }

    public void loadFullCatalog() {

//        int totalResults = getTotalNumberOfResults();
//        int numberOfLoadedResults = 0;

        By loadingIndicator = By.cssSelector(".pagination__loading");

        getJsExecutor().executeScript("arguments[0].scrollIntoView();", waitFor(ExpectedConditions.visibilityOfElementLocated(loadingIndicator)));
        waitFor(ExpectedConditions.invisibilityOfElementLocated(loadingIndicator));
//
//        int finalNumberOfLoadedResults = numberOfLoadedResults;
//        ExpectedCondition<Boolean> newResultsAreLoaded = new ExpectedCondition<Boolean>() {
//
//            public Boolean apply(WebDriver driver) {
//                return (finalNumberOfLoadedResults != waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size());
//            }
//
//            @Override
//            public String toString() {
//                return "New results are not uploaded yet";
//            }
//        };
//
//        while (numberOfLoadedResults <= totalResults) {
//            js.executeScript("arguments[0].scrollIntoView();", waitFor(ExpectedConditions.visibilityOfElementLocated(loadingIndicator)));
//            waitFor(newResultsAreLoaded);
//            numberOfLoadedResults = waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size();
//            System.out.println(String.format("%s >> Number of loaded results is %s of total %s", LocalTime.now(), numberOfLoadedResults, totalResults));
//        }
//        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size();
//        System.out.println(String.format(">> LOADED %s results of total %s", numberOfLoadedResults, totalResults));
    }

//    private int getTotalNumberOfResults() {
//
//        By totalResults = By.cssSelector(".js-total-results");
//        return Integer.parseInt(waitFor(ExpectedConditions.visibilityOfElementLocated(totalResults))
//                .getText().replaceAll("\\s(\\w)+", ""));
//    }

    public List<Double> getListOfProductsPrices() {

        By price = By.cssSelector(".page-content .product-tile__price strong");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(price)).stream()
                .map(p -> Double.parseDouble(p.getText().replaceAll("\\s|€|\\.", "").replaceAll(",", ".")))
                .collect(Collectors.toList());
    }

    public void openWashingMachinesCatalog() {

        By washingMachinesLink = By.cssSelector(".cat-tile a[href='/wasmachine']");
        clickOnElementLocated(washingMachinesLink);
    }

    public List<Double> getListOfProductsReviewScores() {

        By reviewScore = By.cssSelector(".page-content .product-tile__rating.rating-orange .label");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(reviewScore)).stream()
                .map(p -> Double.parseDouble(p.getText().replaceAll(",", ".")))
                .collect(Collectors.toList());
    }

    private void fillInputWithText(By locator, String... text) {

        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void clickOnElementLocated(By locator) {
        waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void chooseFilteringByPriceFromMinToMax(String minPrice, String maxPrice) {

        By minPriceInput = By.cssSelector("#filter_price_min");
        By maxPriceInput = By.cssSelector("#filter_price_max");

        fillInputWithText(minPriceInput, minPrice);
        fillInputWithText(maxPriceInput, maxPrice + Keys.ENTER);
    }

    public WebElement getLogoElement() {

        By logo = By.cssSelector(".logo");
        return waitFor(ExpectedConditions.presenceOfElementLocated(logo));
    }

    public List<String> getNavigationMenuItemsList() {

        By globalNavMenuItem = By.cssSelector(".global-nav.js-menu .level-0 span.js-ga-tracking");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(globalNavMenuItem)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getExpectedNavMenuItemsList() {

        String[] expectedNavMenuItemsList = {"ELEKTRONICA", "HUIS", "AUTO & FIETS", "SPEELGOED & KIDS", "TUIN & KLUSSEN", "VERZORGING", "SPORTEN", "BESPAREN"};
        return Arrays.asList(expectedNavMenuItemsList);
    }

    public List<String> getPopularProductGroupsList() {

        By popularCatalogItem = By.cssSelector(".js-krux-suggest-disabled .cat-tile");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(popularCatalogItem)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getCategoriesList() {

        By categoriesList = By.cssSelector(".cat-tile--collapsible-category .cat-tile a.js-ga-tracking");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(categoriesList)).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public void verifySearchInputIsDisplayed() {

        By searchInput = By.cssSelector(".search input");
        waitFor(ExpectedConditions.visibilityOfElementLocated(searchInput));
    }

    public void verifySubmitButtonIsDisplayed() {

        By submitButton = By.cssSelector(".search button[type='submit']");
        waitFor(ExpectedConditions.visibilityOfElementLocated(submitButton));
    }

    public void verifySocialMediaLinkIsDisplayed(String socialLinkName) {

        By socialLink = By.xpath(String.format("//ul[@class='social-links']//a[text()='%s']", socialLinkName));
        waitFor(ExpectedConditions.visibilityOfElementLocated(socialLink));
    }

    public void verifyFooterLinkIsDisplayed(String linkName) {

        By footerLink = By.xpath(String.format("//div[@class='site-footer__legal-inner']//a[text()='%s']", linkName));
        waitFor(ExpectedConditions.visibilityOfElementLocated(footerLink));
    }

    public void verifyLinkInLinkBlockIsDisplayed(String linkName) {

        By linkInLinkBlock = By.xpath(String.format("//div[@class='link-block js-accordion']//a[text()='%s']", linkName));
        waitFor(ExpectedConditions.visibilityOfElementLocated(linkInLinkBlock));
    }
}

