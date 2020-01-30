package com.mentoring.ui.google;

import com.mentoring.ui.pages.google.google.ResultsPage;
import com.mentoring.ui.pages.google.google.SearchPage;
import com.mentoring.ui.BaseTest;
import com.mentoring.ui.core.ConciseAPI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.mentoring.ui.core.ConciseAPI.getTitle;
import static com.mentoring.ui.core.ConciseAPI.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchForSeleniumAndVerifyResultsTest extends BaseTest {


    private SearchPage searchPage = new SearchPage();

    @Test
    public void testVerifySearchResultsForSelenium() {

        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        String expectedURL = (resultsPage.getNumberOfSearchResults()==10) ? "https://ru.wikipedia.org › wiki › Selenium" :  "https://www.seleniumhq.org";
        assertEquals(10, resultsPage.getNumberOfSearchResults(),
                "The number of search results should be equal to 10");
        assertEquals(expectedURL, resultsPage.getFirstResultLink(),
                "The URL for first link is not as expected");
    }

    @Test
    public void testVerifyTitleForFirstSearchResult() {

        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        String expectedTitle = (resultsPage.getNumberOfSearchResults()==10) ? "Selenium — Википедия" : "Selenium - Web Browser Automation";
        resultsPage.openFirstResultLink();
        Assertions.assertEquals(expectedTitle, getTitle(),
                "The title of first source page is not as expected");
    }
}
