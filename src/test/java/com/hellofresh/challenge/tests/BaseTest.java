package com.hellofresh.challenge.tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    String existingUserEmail = "hf_challenge_123456@hf12345.com";
    String existingUserPassword = "12345678";
    String existingUserFullName = "Joe Black";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
