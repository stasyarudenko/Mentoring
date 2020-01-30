package com.mentoring.ui.kieskeurig;

import com.mentoring.ui.pages.kieskeurig.BasePage;
import com.mentoring.ui.BaseTest;
import com.mentoring.ui.pages.kieskeurig.MainPage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.mentoring.ui.core.ConciseAPI.visit;
import static com.mentoring.ui.core.Configuration.EMAIL;
import static com.mentoring.ui.core.Configuration.LOGIN;
import static com.mentoring.ui.core.Configuration.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VerifyUIElementsTest extends BaseTest {

    @Test
    public void testVerifyUIElementsOnMainPage() {

        MainPage loginPage = new MainPage();

        visit("https://www.kieskeurig.nl/");
        loginPage.acceptCookies();
        loginPage.clickLoginButton();
        loginPage.openLoginTabOnModal();
        loginPage.setLoginEmailAddress(EMAIL);
        loginPage.setLoginPassword(PASSWORD);
        loginPage.clickLoginButtonOnModal();

        assertTrue(loginPage.getLogoElement().isDisplayed(), "Logo is not displayed on the main page");
        assertEquals(LOGIN, loginPage.getUserName(), "User name is displayed incorrectly");

        List<String> actualNavMenuItems = loginPage.getNavigationMenuItemsList();
        List<String> expectedNavMenuItems = loginPage.getExpectedNavMenuItemsList();
        assertTrue(expectedNavMenuItems.containsAll(actualNavMenuItems), "Not all of navigation menu items are displayed");

        List<String> actualPopularProductGroups = loginPage.getPopularProductGroupsList();
        List<String> categoriesList = loginPage.getCategoriesList();
        assertEquals(10, actualPopularProductGroups.size(), "The number of popular product groups should be equal to 10");
        assertTrue(categoriesList.containsAll(actualPopularProductGroups), "Not all of popular product groups are displayed");

        loginPage.verifySearchInputIsDisplayed();
        loginPage.verifySubmitButtonIsDisplayed();

        loginPage.verifySocialMediaLinkIsDisplayed("Kieskeurig op Facebook");
        loginPage.verifySocialMediaLinkIsDisplayed("Kieskeurig op Youtube");
        loginPage.verifySocialMediaLinkIsDisplayed("Kieskeurig op Twitter");

        loginPage.verifyLinkInLinkBlockIsDisplayed("Vragen?");
        loginPage.verifyLinkInLinkBlockIsDisplayed("Contact");
        loginPage.verifyLinkInLinkBlockIsDisplayed("Over Kieskeurig.nl");
        loginPage.verifyLinkInLinkBlockIsDisplayed("Partners");

        loginPage.verifyFooterLinkIsDisplayed("Privacy- en Cookiebeleid");
        loginPage.verifyFooterLinkIsDisplayed("Copyright");
        loginPage.verifyFooterLinkIsDisplayed("Disclaimer");
    }
}
