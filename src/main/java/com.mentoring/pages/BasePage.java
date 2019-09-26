package com.mentoring.pages;

import com.mentoring.core.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


public class BasePage {

    private static WebDriver driver;

    private By ONE_GOOGLE_MENU = By.cssSelector("a.gb_B[aria-expanded]");

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

    protected static <T> T waitFor(ExpectedCondition<T> condition) {

        return new FluentWait<>(getDriver())
                .withTimeout(Configuration.TIMEOUT.getSeconds(), TimeUnit.SECONDS)
                .pollingEvery(Configuration.POLLING.getSeconds(), TimeUnit.MICROSECONDS)
                .ignoring(WebDriverException.class, IndexOutOfBoundsException.class)
                .until(condition);
    }

    public void clickSignInButton() {

        By signInButton = By.cssSelector("div.gb_mg");
        waitFor(ExpectedConditions.visibilityOfElementLocated(signInButton)).click();
    }

    public void setLogin(String login) {

        WebElement emailOrPhoneInput = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        WebElement nextButton = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='identifierNext']")));

        emailOrPhoneInput.click();
        emailOrPhoneInput.sendKeys(login);
        nextButton.click();
    }

    public void setPassword(String password) {

        WebElement enterYourPasswordInput = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        WebElement nextButton = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='passwordNext']")));

        enterYourPasswordInput.click();
        enterYourPasswordInput.sendKeys(password);
        nextButton.click();
    }

    public void openOneGoogle() {

        waitFor(ExpectedConditions.visibilityOfElementLocated(ONE_GOOGLE_MENU)).click();
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

}
