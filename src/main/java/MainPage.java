import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class MainPage {

    private WebDriver driver;
    private static final String GMAIL_HOME = "http://gmail.com/";
    // SIGN IN PAGE
    private static final By EMAIL_INPUT = By.cssSelector("input[type=\"email\"]");
    private static final By LOGIN_NEXT_BUTTON = By.cssSelector("div[id=\"identifierNext\"]");

    private static final By PASSWORD_INPUT = By.cssSelector("input[type=\"password\"]");
    private static final By PASSWORD_NEXT_BUTTON = By.cssSelector("div[id=\"passwordNext\"]");
    // INBOX PAGE
    private static final By WRITE_EMAIL_BUTTON = By.cssSelector(".z0 div[role=\"button\"]");
    private static final By NEW_EMAIL_POPUP = By.cssSelector("div[aria-label=\"Новое сообщение\"]");
    private static final By UNREAD_EMAILS_LINK = By.cssSelector("a[title=\"Входящие\"]");
    private static final By UNREAD_EMAILS_COUNTER = By.cssSelector("div[data-tooltip=\"Входящие\"] span+div");
    private static final By UNREAD_EMAIL_LINE = By.cssSelector(".zA.zE");
    private static final By SENDERS = By.cssSelector(".zF");
    private static final By SUBJECTS = By.cssSelector("span.bog");
    // NEW EMAIL FORM
    private static final By SUBJECTS_FIELD = By.cssSelector("input[name=\"subjectbox\"]");
    private static final By EMAIL_TEXT_FIELD = By.cssSelector("div[aria-label=\"Тело письма\"]");
    private static final By RECEIVERS_FIELD = By.cssSelector("div[tabindex=\"1\"]>div");
    private static final By RECEIVERS_EMAILS_FIELD = By.cssSelector("textarea[aria-label=\"Кому\"]");
    private static final By SEND_EMAIL_BUTTON = By.cssSelector("tbody div[role=\"button\"]");
    // EMAIL PAGE
    private static final By EMAIL_TEXT = By.cssSelector(".ii.gt div[dir=\"ltr\"]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToGmailHomePage() {
        driver.get(GMAIL_HOME);
        WebDriverWait wait = new WebDriverWait(driver, 100);
        wait.until(ExpectedConditions.titleIs("Gmail"));
    }

    public void loginInToMailAccountWithCredentials(Map<String, String> credentials) {
        enterLogin(credentials.get("login"));
        enterPassword(credentials.get("password"));
    }

    private void enterLogin(String login) {
        WebElement emailInput = waitForElementToBeDisplayed(EMAIL_INPUT);
        WebElement nextButton = waitForElementToBeDisplayed(LOGIN_NEXT_BUTTON);
        emailInput.click();
        emailInput.sendKeys(login);
        nextButton.click();
    }

    private void enterPassword(String password) {
        WebElement passwordInput = waitForElementToBeDisplayed(PASSWORD_INPUT);
        WebElement passwordNextButton = waitForElementToBeDisplayed(PASSWORD_NEXT_BUTTON);
        passwordInput.click();
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }

    private WebElement waitForElementToBeDisplayed(By locator) {
            WebDriverWait wait = new WebDriverWait(driver, 100);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator);
        } catch (StaleElementReferenceException e) {
            throw new NoSuchElementException("No element was found");
        }
    }

    public void sendEmailWithSubjectAndTextToReceiver(String subject, String letterText, String email) {
        clickWriteEmailBtn();
        fillSubject(subject);
        fillEmailText(letterText);
        fillReceivers(email);
        sendEmail();
    }

    private void clickWriteEmailBtn() {
        waitForElementToBeDisplayed(WRITE_EMAIL_BUTTON).click();
        waitForElementToBeDisplayed(NEW_EMAIL_POPUP);
    }

    private void fillReceivers(String email) {
        WebElement emailField = driver.findElements(RECEIVERS_FIELD).stream()
                .filter(p -> p.getText().equalsIgnoreCase("получатели")).findFirst()
                .orElseThrow(() -> new NoSuchElementException("No such receivers field was found"));
        emailField.click();
        waitForElementToBeDisplayed(RECEIVERS_EMAILS_FIELD).click();
        driver.findElement(RECEIVERS_EMAILS_FIELD).sendKeys(email);
    }

    private void fillEmailText(String letterText) {
        waitForElementToBeDisplayed(EMAIL_TEXT_FIELD).click();
        driver.findElement(EMAIL_TEXT_FIELD).sendKeys(letterText);
    }

    private void fillSubject(String subject) {
        waitForElementToBeDisplayed(SUBJECTS_FIELD).click();
        driver.findElement(SUBJECTS_FIELD).sendKeys(subject);
    }

    private void sendEmail() {
        WebElement sendBtn = driver.findElements(SEND_EMAIL_BUTTON).stream()
                .filter(p -> p.getText().equalsIgnoreCase("отправить"))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Send button was not found"));
        sendBtn.click();
    }

    public int getUnreadMessagesCounter() {
        return Integer.parseInt(waitForElementToBeDisplayed(UNREAD_EMAILS_COUNTER)
                .getText());
    }

    public void openLastEmailFromSenderWithSubject(String sender, String subject) {
        if (subject.equals("")) {
            subject = "(без темы)";
        }
        getLastEmailFromSenderWithSubject(sender,subject).click();
    }

    private WebElement getLastEmailFromSenderWithSubject(String sender, String subject) {
        driver.findElement(UNREAD_EMAILS_LINK).click();

        return driver.findElements(UNREAD_EMAIL_LINE).stream()
                .filter(p -> p.findElement(SENDERS).getAttribute("email").equalsIgnoreCase(sender))
                .filter(p -> p.findElement(SUBJECTS).getText().equalsIgnoreCase(subject))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("No email with such sender and subject was found"));
    }

    public String getEmailText() {
        waitForElementToBeDisplayed(EMAIL_TEXT);
        return driver.findElement(EMAIL_TEXT).getText();
    }

    // ToDo:
    // set language on login - russian
    // compare time send and time received?
    // logout after test passed
}
