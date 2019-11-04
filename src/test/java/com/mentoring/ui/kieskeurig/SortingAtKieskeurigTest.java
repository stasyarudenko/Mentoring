package com.mentoring.ui.kieskeurig;

import com.mentoring.pages.kieskeurig.BasePage;
import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static com.mentoring.core.ConciseAPI.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAtKieskeurigTest extends BaseTest {


    @Test
    public void testSortTelephonesByPriceDescendingOrder() {

        visit("https://www.kieskeurig.nl/");
        BasePage kieskeurigPage = new BasePage();

        kieskeurigPage.acceptCookies();
        kieskeurigPage.openSmartphonesCatalog();
        kieskeurigPage.expandFilters();
        kieskeurigPage.chooseSortingBy("Prijs - Aflopend");
        kieskeurigPage.chooseFilteringByPriceFromMinToMax("10", "30");
        kieskeurigPage.waitForResultsToLoad();
//        kieskeurigPage.loadFullCatalog();

        List<Double> actualPriceList = kieskeurigPage.getListOfProductsPrices();
        List<Double> sortedByDescendingList = kieskeurigPage.getListOfProductsPrices();
        sortedByDescendingList.sort(Comparator.reverseOrder());

        assertEquals(sortedByDescendingList, actualPriceList, "The prices are not sorted by descending order");
    }

    @Test
    public void testSortWashingMachinesByReviewScoreDescendingOrder() {

        visit("https://www.kieskeurig.nl/");
        BasePage kieskeurigPage = new BasePage();

        kieskeurigPage.acceptCookies();
        kieskeurigPage.openWashingMachinesCatalog();
        kieskeurigPage.expandFilters();
        kieskeurigPage.chooseSortingBy("Reviewscore");
        kieskeurigPage.chooseFilteringByPriceFromMinToMax("500", "550");
        kieskeurigPage.waitForResultsToLoad();
//        kieskeurigPage.loadFullCatalog();

        List<Double> actualReviewScoreList = kieskeurigPage.getListOfProductsReviewScores();
        List<Double> sortedByDescendingList = kieskeurigPage.getListOfProductsReviewScores();
        sortedByDescendingList.sort(Comparator.reverseOrder());

        assertEquals(sortedByDescendingList, actualReviewScoreList, "The washing machines are not sorted by review score in descending order");
    }
}
