package com.mentoring.pages;

import com.mentoring.core.Configuration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


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

    protected static <T> T waitFor(ExpectedCondition<T> condition) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Configuration.TIMEOUT);
        return wait.until(condition);
    }
}
