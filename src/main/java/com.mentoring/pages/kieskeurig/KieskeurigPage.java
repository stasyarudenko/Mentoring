package com.mentoring.pages.kieskeurig;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class KieskeurigPage extends BasePage {

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
        clickOnElementLocated(acceptCookiesButton);
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

    public void chooseSortingByPriceDescendingAndWaitForResultsToLoad() {

        By filterOption = By.cssSelector(".sidebar .product-sorting label");
        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(filterOption)).stream()
                .filter(p -> p.getAttribute("for").equalsIgnoreCase("sort_option_6"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new).click();
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem));
    }

    public void loadFullCatalog() {

//        int totalResults = getTotalNumberOfResults();
        int totalResults = 500;
        int numberOfLoadedResults = 0;

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        By loadingIndicator = By.cssSelector(".pagination__loading");

        int finalNumberOfLoadedResults = numberOfLoadedResults;
        ExpectedCondition<Boolean> newResultsAreLoaded = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return (finalNumberOfLoadedResults != waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size());
            }

            @Override
            public String toString() {
                return "New results are not uploaded yet";
            }
        };

        while (numberOfLoadedResults <= totalResults) {
            js.executeScript("arguments[0].scrollIntoView();", waitFor(ExpectedConditions.visibilityOfElementLocated(loadingIndicator)));
            waitFor(newResultsAreLoaded);
            numberOfLoadedResults = waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size();
            System.out.println(String.format("%s >> Number of loaded results is %s of total %s", LocalTime.now(), numberOfLoadedResults, totalResults));
        }
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem)).size();
        System.out.println(String.format(">> LOADED %s results of total %s", numberOfLoadedResults, totalResults));
    }

    private int getTotalNumberOfResults() {

        By totalResults = By.cssSelector(".js-total-results");
        return Integer.parseInt(waitFor(ExpectedConditions.visibilityOfElementLocated(totalResults))
                .getText().replaceAll("\\s(\\w)+", ""));
    }

    public List<Double> getListOfProductPricesFromCatalog() {

        By price = By.cssSelector(".page-content .product-tile__price strong");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(price)).stream()
                .map(p -> Double.parseDouble(p.getText().replaceAll("\\s|€|\\.", "").replaceAll(",", ".")))
                .collect(Collectors.toList());
    }

    public void openWashingMachinesCatalog() {

        By washingMachinesLink = By.cssSelector(".cat-tile a[href='/wasmachine']");
        clickOnElementLocated(washingMachinesLink);
    }

    public void chooseSortingMostWatchedAndWaitForResultsToLoad() {

        By filterOption = By.cssSelector(".sidebar .product-sorting label");
        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(filterOption)).stream()
                .filter(p -> p.getAttribute("for").equalsIgnoreCase("sort_option_3"))
                .findFirst()
                .orElseThrow(NoSuchElementException::new).click();
        waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(catalogItem));
    }

    public List<Double> getListOfProductReviewScores() {

        By reviewScore = By.cssSelector(".page-content .product-tile__rating.rating-orange .label");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(reviewScore)).stream()
                .map(p -> Double.parseDouble(p.getText().replaceAll(",", ".")))
                .collect(Collectors.toList());
    }
}
