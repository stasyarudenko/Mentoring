package com.mentoring.pages.google.google;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;



public class ResultsPage extends BasePage {

    private static final By RESULT_LINK = By.cssSelector(".srg .iUh30");

    public long getNumberOfSearchResults() {

        By searchResults = By.cssSelector("a .LC20lb");
        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults)).size();
    }

    public String getFirstResultLink() {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(RESULT_LINK)).getText();
    }

    public void openFirstResultLink() {

        waitFor(ExpectedConditions.visibilityOfElementLocated(RESULT_LINK)).click();
        waitFor(ExpectedConditions.invisibilityOfElementLocated(RESULT_LINK));
    }
}
