package com.mentoring.pages.google.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

import static com.mentoring.core.ConciseAPI.waitFor;


public class InboxPage {

    private static final By SUBJECT_ON_INBOX_PAGE = By.cssSelector("span.bog");
    private static final By UNREAD_EMAIL_LINE = By.cssSelector(".zA.zE");

    public void clickWriteEmailBtn() {

        By composeButton = By.cssSelector(".z0 div[role='button']");
        By newMessagePopup = By.cssSelector(".a3E .aYF");

        waitFor(ExpectedConditions.visibilityOfElementLocated(composeButton)).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(newMessagePopup));
    }

    public void fillRecipients(String email) {

        WebElement recipientsField = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".oL.aDm")));
        recipientsField.click();

        WebElement toField = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".l1 textarea.vO")));
        toField.click();
        toField.sendKeys(email);
    }

    public void fillEmailText(String letterText) {

        WebElement emailTextField = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Am.LW-avf")));
        emailTextField.click();
        emailTextField.sendKeys(letterText);
    }

    public void fillSubject(String subject) {

        WebElement subjectField = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='subjectbox']")));
        subjectField.click();
        subjectField.sendKeys(subject);
    }

    public void clickSendButton() {

        WebElement sendButton = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".v7.L3")));
        sendButton.click();
    }

    public void clickOnRefreshButton() {

        By refreshButton = By.cssSelector(".nu.L3");
        waitFor(ExpectedConditions.visibilityOfElementLocated(refreshButton)).click();
    }

    public void openFirstUnreadEmailWhereSubjectContainsText(String subject) {
        getFirstUnreadEmailWhereSubjectContainsText(subject).click();
    }

    public WebElement getFirstUnreadEmailWhereSubjectContainsText(String text) {

        return waitFor(ExpectedConditions.visibilityOfAllElementsLocatedBy(UNREAD_EMAIL_LINE)).stream()
                .filter(p -> p.findElement(SUBJECT_ON_INBOX_PAGE).getText().contains(text))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No email with subject was found"));
    }

    public String getEmailText() {

        By emailText = By.cssSelector(".ii.gt div[dir='ltr']");
        return waitFor(ExpectedConditions.visibilityOfElementLocated(emailText)).getText();
    }

    public void clickRegistrationLinkFromEmailText() {

        By linkFromEmailText = By.cssSelector(".ii.gt .a3s a");
        waitFor(ExpectedConditions.visibilityOfElementLocated(linkFromEmailText));
        waitFor(ExpectedConditions.elementToBeClickable(linkFromEmailText)).click();
    }

    public String getFirstEmailSubject() {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(UNREAD_EMAIL_LINE))
                .findElement(SUBJECT_ON_INBOX_PAGE).getText();
    }
}
