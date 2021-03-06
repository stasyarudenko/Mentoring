package com.mentoring.ui.kieskeurig;

import com.github.javafaker.Faker;
import com.mentoring.ui.core.Configuration;
import com.mentoring.ui.pages.google.gmail.InboxPage;
import com.mentoring.ui.pages.google.google.SearchPage;
import com.mentoring.ui.BaseTest;
import com.mentoring.ui.pages.kieskeurig.MainPage;
import org.junit.jupiter.api.Test;

import static com.mentoring.ui.core.ConciseAPI.navigateToTab;
import static com.mentoring.ui.core.ConciseAPI.visit;
import static com.mentoring.ui.core.Configuration.LOGIN;
import static com.mentoring.ui.core.Configuration.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterAtKieskeurigTest extends BaseTest {


    @Test
    public void testRegisterUserAtKieskeurig() {

        MainPage registrationPage = new MainPage();
        Faker faker = new Faker();
        String email = Configuration.getEmailWithAlias();
        String displayName = Configuration.getLoginWithAlias();

        visit("https://www.kieskeurig.nl/");
        registrationPage.acceptCookies();
        registrationPage.clickLoginButton();
        registrationPage.enterDisplayName(displayName);
        registrationPage.enterFirstName(faker.name().firstName());
        registrationPage.enterLastName(faker.name().lastName());
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
        searchPage.waitForOneGoogleListToBeExpanded();
        searchPage.navigateTo("Gmail");

        InboxPage inboxPage = new InboxPage();
        inboxPage.clickOnRefreshButton();
        inboxPage.openFirstUnreadEmailWhereSubjectContainsText("Kieskeurig");
        inboxPage.clickRegistrationLinkFromEmailText();

        MainPage loginPage = new MainPage();
        navigateToTab(1);
        loginPage.clickLoginButton();
        loginPage.openLoginTabOnModal();
        loginPage.setLoginEmailAddress(email);
        loginPage.setLoginPassword(PASSWORD);
        loginPage.clickLoginButtonOnModal();
        assertEquals(displayName, loginPage.getUserName(), "The displayName is not as expected");
    }
}
