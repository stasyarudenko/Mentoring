package com.mentoring.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.mentoring.pages.BasePage.getDriver;
import static com.mentoring.pages.BasePage.setDriver;

public class BaseTest {

    @BeforeEach
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
    }

    @AfterEach
    public void shutDown() {
        getDriver().quit();
    }
}
