package com.mentoring.ui.kieskeurig;

import com.mentoring.pages.kieskeurig.KieskeurigPage;
import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static com.mentoring.core.Configuration.PASSWORD;
import static com.mentoring.pages.BasePage.visit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortingAtKieskeurigTest extends BaseTest {


    @Test
    public void testSortTelephonesByPriceDescendingOrder() {

        visit("https://www.kieskeurig.nl/");
        KieskeurigPage kieskeurigPage = new KieskeurigPage();

        kieskeurigPage.acceptCookies();
        kieskeurigPage.clickLoginButton();
        kieskeurigPage.openLoginTabOnModal();
        kieskeurigPage.setLoginEmailAddress("anrud.user+1@gmail.com");
        kieskeurigPage.setLoginPassword(PASSWORD);
        kieskeurigPage.clickLoginButtonOnModal();

        kieskeurigPage.openSmartphonesCatalog();
        kieskeurigPage.expandFilters();
        kieskeurigPage.chooseSortingByPriceDescending();
//        kieskeurigPage.loadFullCatalog();

        List<Double> actualPriceList = kieskeurigPage.getListOfProductPricesFromCatalog();
        List<Double> sortedByDescendingList = kieskeurigPage.getListOfProductPricesFromCatalog();
        sortedByDescendingList.sort(Comparator.reverseOrder());

        assertEquals(sortedByDescendingList, actualPriceList, "The prices are not sorted by descending order");
    }

    @Test
    public void testSortWashingMachinesByReviewScoresDescendingOrder() {

        visit("https://www.kieskeurig.nl/");
        KieskeurigPage kieskeurigPage = new KieskeurigPage();

        kieskeurigPage.acceptCookies();
        kieskeurigPage.openWashingMachinesCatalog();
        kieskeurigPage.expandFilters();
        kieskeurigPage.chooseSortingMostWatched();
        kieskeurigPage.loadFullCatalog();

        List<Double> actualReviewScoreList = kieskeurigPage.getListOfProductReviewScores();
        List<Double> sortedByDescendingList = kieskeurigPage.getListOfProductReviewScores();
        sortedByDescendingList.sort(Comparator.reverseOrder());

        assertEquals(sortedByDescendingList, actualReviewScoreList, "The washing machines are not sorted by review score in descending order");
    }
}
