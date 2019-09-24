package com.mentoring.pages.google;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;


public class ResultsPage extends BasePage {

    private static final By URL = By.cssSelector(".srg .iUh30");

    public long getNumberOfSearchResults() {

//        By searchResult = By.cssSelector(".bkWMgd .srg a .LC20lb");
        By searchResult = By.cssSelector("a .LC20lb");
        return waitForAllElementsToBeDisplayed(searchResult).size();
    }

    public String getFirstSourceUrl() {
        return waitForElementToBeDisplayed(URL).getText();
    }

    public String openFirstSourceAndGetTitle() {

        waitForElementToBeDisplayed(URL).click();
        waitForElementToDisappear(URL);
        return getDriver().getTitle();
    }
}
