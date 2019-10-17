package com.mentoring.ui.google;

import com.mentoring.pages.google.google.ResultsPage;
import com.mentoring.pages.google.google.SearchPage;
import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import static com.mentoring.pages.BasePage.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchForSeleniumAndVerifyResultsTest extends BaseTest {


    private SearchPage searchPage = new SearchPage();

    @Test
    public void testVerifySearchResultsForSelenium() {

        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        assertEquals(9, resultsPage.getNumberOfSearchResults(),
                "The number of search results should be equal to 10");
        assertEquals("https://www.seleniumhq.org", resultsPage.getFirstResultLink(),
                "The URL for first link is not as expected");
    }

    @Test
    public void testVerifyTitleForFirstSearchResult() {

        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        resultsPage.openFirstResultLink();
        assertEquals("Selenium - Web Browser Automation", resultsPage.getTitle(),
                "The title of first source page is not as expected");
    }
}
