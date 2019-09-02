package com.mentoring.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class InboxPage extends BasePage {

    // INBOX PAGE
    private static final By WRITE_EMAIL_BUTTON = By.cssSelector(".z0 div[role=\"button\"]");
    private static final By NEW_EMAIL_POPUP = By.cssSelector(".a3E .aYF");
    private static final By INBOX_LINK = By.cssSelector(".aim.ain a.J-Ke.n0");
    private static final By UNREAD_EMAIL_LINE = By.cssSelector(".zA.zE");
    private static final By SUBJECT = By.cssSelector("span.bog");
    // NEW EMAIL FORM
    private static final By SUBJECT_FIELD = By.cssSelector("input[name=\"subjectbox\"]");
    private static final By EMAIL_TEXT_FIELD = By.cssSelector(".Am.LW-avf");
    private static final By RECEIVERS_FIELD = By.cssSelector(".oL.aDm");
    private static final By RECEIVERS_EMAILS_FIELD = By.cssSelector(".l1 textarea.vO");
    private static final By SEND_EMAIL_BUTTON = By.cssSelector(".v7.L3");
    // EMAIL PAGE
    private static final By EMAIL_TEXT = By.cssSelector(".ii.gt div[dir=\"ltr\"]");

    public InboxPage(WebDriver driver) {
        super(driver);
    }

    public static void clickWriteEmailBtn() {

        waitForElementToBeDisplayed(WRITE_EMAIL_BUTTON).click();
        waitForElementToBeDisplayed(NEW_EMAIL_POPUP);
    }

    public static void fillReceivers(String email) {

        WebElement emailField = waitForElementToBeDisplayed(RECEIVERS_FIELD);
        emailField.click();

        WebElement receiversField = waitForElementToBeDisplayed(RECEIVERS_EMAILS_FIELD);
        receiversField.click();
        receiversField.sendKeys(email);
    }

    public static void fillEmailText(String letterText) {

        WebElement emailTextField = waitForElementToBeDisplayed(EMAIL_TEXT_FIELD);
        emailTextField.click();
        emailTextField.sendKeys(letterText);
    }

    public static void fillSubject(String subject) {

        WebElement subjectField = waitForElementToBeDisplayed(SUBJECT_FIELD);
        subjectField.click();
        subjectField.sendKeys(subject);
    }

    public static void clickSendEmailBtn() {

        WebElement sendBtn = waitForElementToBeDisplayed(SEND_EMAIL_BUTTON);
        sendBtn.click();
    }

    public static void openEmailWithSubject(String subject) {

        if (subject.equals("")) {
            subject = "(без темы)";
        }
        getEmailWithSubject(subject).click();
    }

    public static WebElement getEmailWithSubject(String subject) {

        waitForElementToBeDisplayed(INBOX_LINK).click();

        return waitForAllElementsToBeDisplayed(UNREAD_EMAIL_LINE).stream()
                .filter(p -> p.findElement(SUBJECT).getText().equalsIgnoreCase(subject))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No email with subject was found"));
    }

    public static String getEmailText() {
        return waitForElementToBeDisplayed(EMAIL_TEXT).getText();
    }

    // ToDo:
    // logout after test passed ?


    // naming convenction - java package naming, interface, methods, test methods,
    // page object
    // DONE. тестовые методы заканчиваются на слово Test
    // DONE. test class name - ...Test -->
    // DONE. Web Driver Manager -- удалить папку с драйверами
    // DONE. JUnit --> 5 вместо 4
    // readbility -- clean code
    // DONE. browser.quit instead of .close
    // DONE. before, after --> beforeClass, AfterClass вынести в отд класс
    // selenium - как знает, что страница прогрузилась: document.readyState = complete
    // DONE. сделать проще тест - логин и пароль
    // commit from текущей бранчи с фичей вмерджить в другую бранчу с фичей
    // git HEAD, git revert, git reset
    // UNIX - terminal
    // DONE. gitignore - добавить в гитигнор чтоб не коммитился
    // DONE. .gitignore - сгенерить и убрать лишнее
}
