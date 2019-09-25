package com.mentoring.pages.gmail;

import com.mentoring.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public void setLogin(String login) {

        WebElement emailOrPhoneInput = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        WebElement nextButton = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='identifierNext']")));

        emailOrPhoneInput.click();
        emailOrPhoneInput.sendKeys(login);
        nextButton.click();
    }

    public void setPassword(String password) {

        WebElement enterYourPasswordInput = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        WebElement nextButton = waitFor(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='passwordNext']")));

        enterYourPasswordInput.click();
        enterYourPasswordInput.sendKeys(password);
        nextButton.click();
    }
}
