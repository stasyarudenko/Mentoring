package com.mentoring.ui.kieskeurig;

import com.mentoring.pages.kieskeurig.BasePage;
import com.mentoring.ui.BaseTest;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.ConciseAPI.visit;
import static com.mentoring.core.Configuration.EMAIL;
import static com.mentoring.core.Configuration.LOGIN;
import static com.mentoring.core.Configuration.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class VerifyMainElementsTest extends BaseTest {

    @Test
    public void testVerifyMainElementsOnMainPage() {

        BasePage loginPage = new BasePage();

        visit("https://www.kieskeurig.nl/");
        loginPage.acceptCookies();
        loginPage.clickLoginButton();
        loginPage.openLoginTabOnModal();
        loginPage.setLoginEmailAddress(EMAIL);
        loginPage.setLoginPassword(PASSWORD);
        loginPage.clickLoginButtonOnModal();

        assertTrue(loginPage.getLogoElement().isDisplayed(), "Logo is not displayed on the main page");
        assertEquals(LOGIN, loginPage.getUserName(), "User name is displayed incorrectly");
        assertTrue(loginPage.getNavigationMenuPanel().isDisplayed(), "Navigation panel is not displayed");
        loginPage.getListOFCatalogItems().forEach(element -> assertTrue(element.isDisplayed(), "Not all of catalog items are displayed"));
    }
}
