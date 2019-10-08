package com.mentoring.pages;

import com.mentoring.core.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class BasePage {

    private static WebDriver driver;

    private By ONE_GOOGLE_MENU = By.cssSelector("a.gb_B[aria-expanded]");

    private Actions actions = new Actions(getDriver());

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        getDriver().get(url);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public static <T> T waitFor(ExpectedCondition<T> condition) {
        return waitFor(condition, Configuration.TIMEOUT, Configuration.POLLING);
    }

    public static <T> T waitFor(ExpectedCondition<T> condition, Duration timeout, Duration pulling) {

        return new FluentWait<>(getDriver())
                .withTimeout(timeout.getSeconds(), TimeUnit.SECONDS)
                .pollingEvery(pulling.getSeconds(), TimeUnit.SECONDS)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class)
                .until(condition);
    }

    public void clickSignInButton() {

        By signInButton = By.cssSelector("div.gb_mg");
        clickOnElementLocated(signInButton);
    }

    public void setLogin(String login) {

        By emailOrPhoneInput = By.cssSelector("input[type='email']");
        By nextButton = By.cssSelector("div[id='identifierNext']");

        fillInputWithText(emailOrPhoneInput, login);
        clickOnElementLocated(nextButton);
    }

    public void setPassword(String password) {

        By enterYourPasswordInput = By.cssSelector("input[type='password']");
        By nextButton = By.cssSelector("div[id='passwordNext']");

        fillInputWithText(enterYourPasswordInput, password);
        clickOnElementLocated(nextButton);
    }

    public void openOneGoogle() {

        clickOnElementLocated(ONE_GOOGLE_MENU);
        waitFor(ExpectedConditions.attributeToBe(ONE_GOOGLE_MENU, "aria-expanded", "true"));
    }

    public void navigateTo(String menuToSelect) {

        By navMenuItem = By.className("gb_d");
        By navMenuItemLabel = By.cssSelector("span.gb_r");

        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(navMenuItem)).stream()
                .filter(p -> p.findElement(navMenuItemLabel).getText().equalsIgnoreCase(menuToSelect))
                .findFirst()
                .orElseThrow(NoSuchElementException::new).click();
    }

    public void fillInputWithText(By locator, String text) {
        actions.click(waitFor(ExpectedConditions.visibilityOfElementLocated(locator))).sendKeys(text).perform();
    }

    public void clickOnElementLocated(By locator) {
        actions.click(waitFor(ExpectedConditions.elementToBeClickable(locator))).perform();
    }

    public static void navigateToTab(int tab) {

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        getDriver().switchTo().window(tabs.get(tab));
    }

}
