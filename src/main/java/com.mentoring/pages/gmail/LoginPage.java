package com.mentoring.pages.gmail;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public void setLogin(String login) {

        WebElement emailInput = waitForElementToBeDisplayed(By.cssSelector("input[type=\"email\"]"));
        WebElement nextButton = waitForElementToBeDisplayed(By.cssSelector("div[id=\"identifierNext\"]"));

        emailInput.click();
        emailInput.sendKeys(login);
        nextButton.click();
    }

    public void setPassword(String password) {

        WebElement passwordInput = waitForElementToBeDisplayed(By.cssSelector("input[type=\"password\"]"));
        WebElement passwordNextButton = waitForElementToBeDisplayed(By.cssSelector("div[id=\"passwordNext\"]"));

        passwordInput.click();
        passwordInput.sendKeys(password);
        passwordNextButton.click();
    }
}
