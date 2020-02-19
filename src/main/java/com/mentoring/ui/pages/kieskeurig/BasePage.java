package com.mentoring.ui.pages.kieskeurig;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.mentoring.ui.core.ConciseAPI.getDriver;
import static com.mentoring.ui.core.ConciseAPI.waitFor;


public class BasePage {

    public void clickLoginButton() {

        waitFor(ExpectedConditions.titleContains("Kieskeurig.nl"));

        By loginButton = By.cssSelector(".site-header__content .js-show-login");
        clickOnElementLocated(loginButton);
    }

    public void enterDisplayName(String login) {

        By loginInput = By.cssSelector("[name=account_displayname]");
        fillInputWithText(loginInput, login);
    }

    public void enterEmail(String email) {

        By emailInput = By.cssSelector("[name=user-register] [name=account_email]");
        fillInputWithText(emailInput, email);
    }

    public void enterPassword(String password) {

        By passwordInput = By.cssSelector("[name=user-register] [name=password]");
        fillInputWithText(passwordInput, password);
    }

    public void confirmPassword(String password) {

        By confirmPasswordInput = By.cssSelector("[name=user-register] [name=password-verify]");
        fillInputWithText(confirmPasswordInput, password);
    }

    public void enterFirstName(String firstName) {

        By firstNameField = By.cssSelector("[name=account_first_name]");
        fillInputWithText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {

        By lastNameField = By.cssSelector("[name=account_last_name]");
        fillInputWithText(lastNameField, lastName);
    }

    public void clickRegisterButton() {

        By registerButton = By.cssSelector("[name=user-register] .btn--blue--inline");
        clickOnElementLocated(registerButton);

        By messageVerification = By.cssSelector(".modal-login__right .msg");
        waitFor(ExpectedConditions.visibilityOfElementLocated(messageVerification));
    }

    public void acceptCookies() {

        By acceptCookiesButton = By.cssSelector(".modal-consent__right .js-consent-accept");
        if (getDriver().findElement(acceptCookiesButton).isDisplayed()) {
            clickOnElementLocated(acceptCookiesButton);
        }
    }

    public void openLoginTabOnModal() {

        By loginTab = By.cssSelector(".js-user-login--login-toggle");
        clickOnElementLocated(loginTab);
    }

    public void setLoginEmailAddress(String email) {

        By emailAddressInput = By.cssSelector("[name=user-login] [name=username]");
        fillInputWithText(emailAddressInput, email);
    }

    public void setLoginPassword(String password) {

        By passwordInput = By.cssSelector("[name=user-login] [name=password]");
        fillInputWithText(passwordInput, password);
    }

    public void clickLoginButtonOnModal() {

        By loginButton = By.cssSelector("[name=user-login] .btn--blue--inline");
        clickOnElementLocated(loginButton);
    }

    public String getUserName() {

        By userName = By.cssSelector(".site-header__usp .js-username");
        return waitFor(ExpectedConditions.visibilityOfElementLocated(userName)).getText();
    }

    public void fillInputWithText(By locator, String... text) {

        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).click();
        waitFor(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public void clickOnElementLocated(By locator) {
        waitFor(ExpectedConditions.elementToBeClickable(locator)).click();
    }
}

