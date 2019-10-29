package com.mentoring.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.NoSuchElementException;

import static com.mentoring.core.ConciseAPI.waitFor;


public class GoogleBasePage {

    private By ONE_GOOGLE_MENU = By.cssSelector("a.gb_B[aria-expanded]");

    public void clickSignInButton() {

        By signInButton = By.cssSelector(".gb_jg .gb_If");
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
        waitFor(ExpectedConditions.attributeToBe(ONE_GOOGLE_MENU, "aria-expanded", "true"));
    }

    public void navigateTo(String menuToSelect) {

        By navMenuItem = By.className("gb_d");
        By navMenuItemLabel = By.cssSelector("span.gb_r");

        waitFor(ExpectedConditions.presenceOfAllElementsLocatedBy(navMenuItem)).stream()
                .filter(p -> p.findElement(navMenuItemLabel).getText().equalsIgnoreCase(menuToSelect))
                .findFirst()
                .orElseThrow(NoSuchElementException::new).click();
    }

    private void fillInputWithText(By locator, String text) {

        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    private void clickOnElementLocated(By locator) {
        waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}
