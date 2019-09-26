package com.mentoring.pages.google;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SearchPage extends BasePage {

    public void searchFor(String searchCriteria) {

        By searchField = By.cssSelector(".gLFyf.gsfi");

        waitFor(ExpectedConditions.visibilityOfElementLocated(searchField)).sendKeys(searchCriteria);
        getDriver().findElement(searchField).submit();
    }
}
