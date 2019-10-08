package com.mentoring.ui;

import com.mentoring.core.Configuration;
import com.mentoring.pages.gmail.InboxPage;
import com.mentoring.pages.google.SearchPage;
import com.mentoring.pages.kieskeurig.KieskeurigPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.core.Configuration.*;
import static com.mentoring.pages.BasePage.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterAtKieskeurigTest extends BaseTest {


    @Test
    public void testRegisterUserOnKieskeurig() {

        KieskeurigPage registrationPage = new KieskeurigPage();
        String email = Configuration.getEmailWithAlias();
        String displayName = Configuration.getLoginWithAlias();

        visit("https://www.kieskeurig.nl/");
        registrationPage.acceptCookies();
        registrationPage.clickLoginButton();
        registrationPage.enterDisplayName(displayName);
        registrationPage.enterFirstName(FIRST_NAME);
        registrationPage.enterLastName(LAST_NAME);
        registrationPage.enterEmail(email);
        registrationPage.enterPassword(PASSWORD);
        registrationPage.confirmPassword(PASSWORD);
        registrationPage.clickRegisterButton();

        SearchPage searchPage = new SearchPage();
        visit("https://google.com");
        searchPage.clickSignInButton();
        searchPage.setLogin(LOGIN);
        searchPage.setPassword(PASSWORD);
        searchPage.openOneGoogle();
        searchPage.navigateTo("Gmail");

        InboxPage inboxPage = new InboxPage();
        inboxPage.clickOnRefreshButton();
        inboxPage.openFirstUnreadEmailWhereSubjectContainsText("Kieskeurig");
        inboxPage.clickRegistrationLinkFromEmailText();

        KieskeurigPage loginPage = new KieskeurigPage();
        navigateToTab(1);
        loginPage.clickLoginButton();
        loginPage.openLoginTabOnModal();
        loginPage.setLoginEmailAddress(email);
        loginPage.setLoginPassword(PASSWORD);
        loginPage.clickLoginButtonOnModal();
        assertEquals(displayName, loginPage.getUserName(), "The displayName is not as expected");
    }
}
