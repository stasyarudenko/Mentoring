package com.mentoring.pages.google;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;


public class SearchPage extends BasePage {

    public void searchFor(String searchCriteria) {

        By searchField = By.cssSelector(".gLFyf.gsfi");

        waitForElementToBeDisplayed(searchField).sendKeys(searchCriteria);
        getDriver().findElement(searchField).submit();
    }
}
