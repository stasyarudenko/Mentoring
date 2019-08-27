import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;

public class sendEmail {

    private WebDriver driver;
    private MainPage mainPage;
    private Credentials credentials;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        credentials = new Credentials();
        driver.manage().window().maximize();
        mainPage.goToGmailHomePage();
    }

    @After
    public void shutDown() {
        driver.close();
    }

    @Test
    public void verifyEmailWasReceived() {
        mainPage.loginInToMailAccountWithCredentials(credentials.getCredentials());
        int numberOfUnreadMessagesBefore = mainPage.getUnreadMessagesCounter();

        String subject = "test subject";
        String emailText = "test 1 \n test 2 \n test 3\n test4";
        String receiver = "anrud.user@gmail.com";

        mainPage.sendEmailWithSubjectAndTextToReceiver(subject, emailText, receiver);
        int numberOfUnreadMessagesAfter = mainPage.getUnreadMessagesCounter();
        assertThat("The are no new unread emails", (numberOfUnreadMessagesAfter-numberOfUnreadMessagesBefore) > 0);

        String sender = credentials.getEmail();
        mainPage.openLastEmailFromSenderWithSubject(sender, subject);
        String actualEmailText = mainPage.getEmailText();
        assertThat(String.format("The email text is not as expected.\n Expected:\n %s \n Actual:\n %s", emailText, actualEmailText),
                actualEmailText.equals(emailText));
    }

}
