package com.mentoring.ui;

import com.mentoring.pages.gmail.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        BasePage basePage = new BasePage(driver);
    }

    @AfterAll
    public static void shutDown() {
        driver.quit();
    }
}
