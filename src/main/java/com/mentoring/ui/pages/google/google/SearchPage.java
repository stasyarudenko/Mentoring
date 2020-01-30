package com.mentoring.ui.pages.google.google;

import com.mentoring.ui.pages.google.BasePage;
import com.mentoring.ui.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.ui.core.ConciseAPI.waitFor;


public class SearchPage extends BasePage {

    public void searchFor(String searchCriteria) {

        By searchField = By.cssSelector(".gLFyf.gsfi");

        ConciseAPI.waitFor(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchCriteria);
        ConciseAPI.getDriver().findElement(searchField).submit();
    }
}
