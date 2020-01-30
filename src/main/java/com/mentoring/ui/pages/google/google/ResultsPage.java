package com.mentoring.ui.pages.google.google;

import com.mentoring.ui.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.ui.core.ConciseAPI.waitFor;


public class ResultsPage {

    private static final By RESULT_LINK = By.cssSelector(".srg .iUh30");

    public long getNumberOfSearchResults() {

        By searchResults = By.cssSelector("a .LC20lb");
        return ConciseAPI.waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults)).size();
    }

    public String getFirstResultLink() {
        return ConciseAPI.waitFor(ExpectedConditions.visibilityOfElementLocated(RESULT_LINK)).getText();
    }

    public void openFirstResultLink() {

        ConciseAPI.waitFor(ExpectedConditions.visibilityOfElementLocated(RESULT_LINK)).click();
        ConciseAPI.waitFor(ExpectedConditions.invisibilityOfElementLocated(RESULT_LINK));
    }
}
