package com.mentoring.pages.google.google;

import com.mentoring.pages.google.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.core.ConciseAPI.getDriver;
import static com.mentoring.core.ConciseAPI.waitFor;


public class SearchPage extends BasePage {

    public void searchFor(String searchCriteria) {

        By searchField = By.cssSelector(".gLFyf.gsfi");

        waitFor(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchCriteria);
        getDriver().findElement(searchField).submit();
    }
}
