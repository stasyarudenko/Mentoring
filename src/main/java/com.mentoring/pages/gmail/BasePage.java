package com.mentoring.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {

    public static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static WebElement waitForElementToBeDisplayed(By locator) {

    WebDriverWait wait = new WebDriverWait(driver, 100);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator);
        } catch (StaleElementReferenceException e) {
            throw new NoSuchElementException("No element was found");
        }
    }

    public static List<WebElement> waitForAllElementsToBeDisplayed(By locator) {

    WebDriverWait wait = new WebDriverWait(driver, 100);
        List<WebElement> elements = driver.findElements(locator);

        try {
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
            return elements;
        } catch (StaleElementReferenceException e) {
            throw new NoSuchElementException("No elements were found");
        }
    }
}
