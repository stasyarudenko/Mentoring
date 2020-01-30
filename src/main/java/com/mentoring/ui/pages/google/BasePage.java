package com.mentoring.ui.pages.google;

import com.mentoring.ui.core.ConciseAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.ui.core.ConciseAPI.waitFor;


public class BasePage {

    private By ONE_GOOGLE_MENU = By.cssSelector("a.gb_oc[aria-expanded]");

    public void clickSignInButton() {

        By signInButton = By.cssSelector(".gb_9d.gb_4.gb_Vc");
        clickOnElementLocated(signInButton);
    }

    public void setLogin(String login) {

        By emailOrPhoneInput = By.cssSelector("input[type='email']");
        By nextButton = By.cssSelector("div[id='identifierNext']");

        fillInputWithText(emailOrPhoneInput, login);
        clickOnElementLocated(nextButton);
    }

    public void setPassword(String password) {

        By enterYourPasswordInput = By.cssSelector("input[type='password']");
        By nextButton = By.cssSelector("div[id='passwordNext']");

        fillInputWithText(enterYourPasswordInput, password);
        clickOnElementLocated(nextButton);
    }

    public void openOneGoogle() {

        clickOnElementLocated(ONE_GOOGLE_MENU);
    }

    public void waitForOneGoogleListToBeExpanded() {

        ConciseAPI.waitFor(ExpectedConditions.attributeToBe(ONE_GOOGLE_MENU, "aria-expanded", "true"));
    }

    public void navigateTo(String menuToSelect) {

        By navMenuItemLabel = By.xpath(String.format("//li/a[contains(@class,'gb_f')]//span[@class='gb_t'][(text()='%s')]", menuToSelect));
        ConciseAPI.waitFor(ExpectedConditions.elementToBeClickable(navMenuItemLabel)).click();
    }

    private void fillInputWithText(By locator, String text) {

        ConciseAPI.waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        ConciseAPI.waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    private void clickOnElementLocated(By locator) {
        ConciseAPI.waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
