package com.mentoring.pages.gmail;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;


public class InboxPage extends BasePage {

    private static final By SUBJECT_ON_INBOX_PAGE = By.cssSelector("span.bog");
    private static final By UNREAD_EMAIL_LINE = By.cssSelector(".zA.zE");

    public void clickWriteEmailBtn() {

        By composeButton = By.cssSelector(".z0 div[role='button']");
        By newMessagePopup = By.cssSelector(".a3E .aYF");

        waitForElementToBeDisplayed(composeButton).click();
        waitForElementToBeDisplayed(newMessagePopup);
    }

    public void fillRecipients(String email) {

        WebElement recipientsField = waitForElementToBeDisplayed(By.cssSelector(".oL.aDm"));
        recipientsField.click();

        WebElement toField = waitForElementToBeDisplayed(By.cssSelector(".l1 textarea.vO"));
        toField.click();
        toField.sendKeys(email);
    }

    public void fillEmailText(String letterText) {

        WebElement emailTextField = waitForElementToBeDisplayed(By.cssSelector(".Am.LW-avf"));
        emailTextField.click();
        emailTextField.sendKeys(letterText);
    }

    public void fillSubject(String subject) {

        WebElement subjectField = waitForElementToBeDisplayed(By.cssSelector("input[name='subjectbox']"));
        subjectField.click();
        subjectField.sendKeys(subject);
    }

    public void clickSendButton() {

        WebElement sendButton = waitForElementToBeDisplayed(By.cssSelector(".v7.L3"));
        sendButton.click();
    }

    public void clickOnRefreshButton() {

        By refreshButton = By.cssSelector(".nu.L3");
        waitForElementToBeDisplayed(refreshButton).click();
    }

    public void openEmailWithSubject(String subject) {
        getEmailWithSubject(subject).click();
    }

    public WebElement getEmailWithSubject(String subject) {

        return waitForAllElementsToBeDisplayed(UNREAD_EMAIL_LINE).stream()
                .filter(p -> p.findElement(SUBJECT_ON_INBOX_PAGE).getText().equalsIgnoreCase(subject))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No email with subject was found"));
    }

    public String getEmailText() {
        By emailText = By.cssSelector(".ii.gt div[dir='ltr']");
        return waitForElementToBeDisplayed(emailText).getText();
    }

    public String getFirstEmailSubject() {
        return waitForElementToBeDisplayed(UNREAD_EMAIL_LINE).findElement(SUBJECT_ON_INBOX_PAGE).getText();
    }
}
