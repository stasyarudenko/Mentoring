package com.mentoring.ui;

import com.mentoring.ui.core.ConciseAPI;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
        ConciseAPI.setDriver(new ChromeDriver());
        ConciseAPI.getDriver().manage().window().maximize();
    }

    @AfterAll
    public static void shutDown() {
        ConciseAPI.getDriver().quit();
    }
}
