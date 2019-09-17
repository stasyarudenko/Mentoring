package com.mentoring.ui;

import com.mentoring.pages.gmail.InboxPage;
import com.mentoring.pages.gmail.LoginPage;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static com.mentoring.core.Configuration.LOGIN;
import static com.mentoring.core.Configuration.PASSWORD;
import static com.mentoring.pages.BasePage.visit;
import static com.mentoring.pages.gmail.InboxPage.getEmailText;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SendEmailToYourselfTest extends BaseTest {

    @Test
    public void testSendEmailToYourselfAndVerifyItWasReceived() {

        LoginPage loginPage = new LoginPage();
        visit("https://gmail.com");
        loginPage.setLogin(LOGIN);
        loginPage.setPassword(PASSWORD);

        String subject = Calendar.getInstance().getTime().toString();
        String emailText = "test 1 \n test 2 \n test 3\n test4";
        String email = "anrud.user@gmail.com";

        InboxPage.clickWriteEmailBtn();
        InboxPage.fillSubject(subject);
        InboxPage.fillEmailText(emailText);
        InboxPage.fillReceivers(email);
        InboxPage.clickSendEmailBtn();

        InboxPage.openEmailWithSubject(subject);
        assertEquals(emailText, getEmailText(), "The email text is not as expected.");
    }
}
