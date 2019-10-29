package com.mentoring.pages.google.google;

import com.mentoring.pages.google.GoogleBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage extends GoogleBasePage {

    public void searchFor(String searchCriteria) {

        By searchField = By.cssSelector(".gLFyf.gsfi");

        waitFor(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchCriteria);
        getDriver().findElement(searchField).submit();
    }
}
