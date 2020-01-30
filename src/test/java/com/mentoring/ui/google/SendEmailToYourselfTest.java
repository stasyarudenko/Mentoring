package com.mentoring.ui.google;

import com.mentoring.ui.pages.google.gmail.InboxPage;
import com.mentoring.ui.pages.google.google.SearchPage;
import com.mentoring.ui.BaseTest;
import com.mentoring.ui.core.ConciseAPI;
import com.mentoring.ui.core.Configuration;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static com.mentoring.ui.core.ConciseAPI.visit;
import static com.mentoring.ui.core.Configuration.LOGIN;
import static com.mentoring.ui.core.Configuration.PASSWORD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendEmailToYourselfTest extends BaseTest {

    @Test
    public void testSendEmailToYourselfAndVerifyItWasReceived() {

        SearchPage searchPage = new SearchPage();
        visit("https://google.com");
        searchPage.clickSignInButton();
        searchPage.setLogin(LOGIN);
        searchPage.setPassword(PASSWORD);
        searchPage.openOneGoogle();
        searchPage.waitForOneGoogleListToBeExpanded();
        searchPage.navigateTo("Gmail");

        String subject = Calendar.getInstance().getTime().toString();
        String emailText = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa.";
        String email = "anrud.user@gmail.com";

        InboxPage inboxPage = new InboxPage();
        inboxPage.clickWriteEmailBtn();
        inboxPage.fillSubject(subject);
        inboxPage.fillEmailText(emailText);
        inboxPage.fillRecipients(email);
        inboxPage.clickSendButton();

        inboxPage.clickOnRefreshButton();
        assertEquals(subject, inboxPage.getFirstEmailSubject(), "The email subject is not as expected.");
        inboxPage.openFirstUnreadEmailWhereSubjectContainsText(subject);
        assertEquals(emailText, inboxPage.getEmailText(), "The email text is not as expected.");
    }
}
