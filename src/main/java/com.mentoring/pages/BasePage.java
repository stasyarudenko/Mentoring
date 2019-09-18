package com.mentoring.pages;

import com.mentoring.core.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        getDriver().get(url);
    }

    public static WebElement waitForElementToBeDisplayed(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Configuration.TIMEOUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator);
        } catch (StaleElementReferenceException e) {
            throw new NoSuchElementException("No element was found");
        }
    }

    public static List<WebElement> waitForAllElementsToBeDisplayed(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Configuration.TIMEOUT);
        List<WebElement> elements = driver.findElements(locator);

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (StaleElementReferenceException e) {
            throw new NoSuchElementException("No elements were found");
        }
    }

    public static void waitForElementToDisappear(By locator) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Configuration.TIMEOUT);
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (StaleElementReferenceException e) {
            throw new TimeoutException("The element should disappear");
        }
    }
}
