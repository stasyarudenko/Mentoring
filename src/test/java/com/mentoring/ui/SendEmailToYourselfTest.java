package com.mentoring.ui;

import com.mentoring.pages.gmail.Credentials;
import com.mentoring.pages.gmail.InboxPage;
import com.mentoring.pages.gmail.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Calendar;

public class SendEmailToYourselfTest extends BaseTest {

    @Test
    public void sendEmailToYourselfAndVerifyItWasReceivedTest() {

        driver.get("http://gmail.com/");
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.titleIs("Gmail"));

        LoginPage.setLogin(Credentials.getLogin());
        LoginPage.setPassword(Credentials.getPassword());

        String subject = Calendar.getInstance().getTime().toString();
        String emailText = "test 1 \n test 2 \n test 3\n test4";
        String email = "anrud.user@gmail.com";
        InboxPage.clickWriteEmailBtn();
        InboxPage.fillSubject(subject);
        InboxPage.fillEmailText(emailText);
        InboxPage.fillReceivers(email);
        InboxPage.clickSendEmailBtn();

        InboxPage.openEmailWithSubject(subject);
        String actualEmailText = InboxPage.getEmailText();
        Assertions.assertEquals(emailText, actualEmailText, "The email text is not as expected.");
    }
}
