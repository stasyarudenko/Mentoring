package com.mentoring.ui;

import com.mentoring.pages.google.ResultsPage;
import com.mentoring.pages.google.SearchPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.pages.BasePage.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchForSeleniumAndVerifyResultsTest extends BaseTest {


    @Test
    public void testVerifySearchResultsForSelenium() {

        SearchPage searchPage = new SearchPage();
        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        assertEquals(9, resultsPage.getNumberOfSearchResults(),
                "The number of search results should be equal to 10");
        assertEquals("https://www.seleniumhq.org", resultsPage.getFirstSourceUrl(),
                "The URL for first link is not as expected");
    }

    @Test
    public void testVerifyTitleForFirstSearchResult() {

        SearchPage searchPage = new SearchPage();
        visit("https://google.com");
        searchPage.searchFor("Selenium");

        ResultsPage resultsPage = new ResultsPage();
        resultsPage.openFirstSource();
        assertEquals("Selenium - Web Browser Automation", resultsPage.getTitle(),
                "The title of first source page is not as expected");
    }
}
