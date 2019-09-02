package com.mentoring.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private static final By EMAIL_INPUT = By.cssSelector("input[type=\"email\"]");
    private static final By LOGIN_NEXT_BUTTON = By.cssSelector("div[id=\"identifierNext\"]");

    private static final By PASSWORD_INPUT = By.cssSelector("input[type=\"password\"]");
    private static final By PASSWORD_NEXT_BUTTON = By.cssSelector("div[id=\"passwordNext\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static void setLogin(String login) {

        WebElement emailInput = waitForElementToBeDisplayed(EMAIL_INPUT);
        WebElement nextButton = waitForElementToBeDisplayed(LOGIN_NEXT_BUTTON);

        emailInput.click();
        emailInput.sendKeys(login);
        nextButton.click();
    }

    public static void setPassword(String password) {

        WebElement passwordInput = waitForElementToBeDisplayed(PASSWORD_INPUT);
        WebElement passwordNextButton = waitForElementToBeDisplayed(PASSWORD_NEXT_BUTTON);

        passwordInput.click();
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }
}
