package com.mentoring.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public final class ConciseAPI {

    private static WebDriver driver;

    public static JavascriptExecutor getJsExecutor() {
        return (JavascriptExecutor) getDriver();
    }

    public static void setDriver(WebDriver driver) {
        ConciseAPI.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void visit(String url) {
        getDriver().get(url);
    }

    public static String getTitle() {
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

    public static void navigateToTab(int tab) {

        ArrayList<String> tabs = new ArrayList<> (getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tab));
    }
}
