package com.hellofresh.challenge.tests;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

@Slf4j
public abstract class BaseTest {

    WebDriver driver;
    WebDriverWait wait;

    String existingUserEmail = "hf_challenge_123456@hf12345.com";
    String existingUserPassword = "12345678";
    String existingUserFullName = "Joe Black";

    @Before
    public void setUp() throws ConfigurationException {

        String browser;
        Configurations configs = new Configurations();

        try {

            PropertiesConfiguration config = configs.properties(new File("test.properties"));
            browser = config.getString("driver.browser");
            log.info("driver.browser: {}", browser);

        } catch (ConfigurationException e) {

            log.error("Something went wrong while reading the configuration file :(");
            throw e;

        }

        driver = getDriver(browser);

        wait = new WebDriverWait(driver, 10, 50);
        driver.get("http://automationpractice.com/index.php");
    }

    private WebDriver getDriver(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            return new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            return new ChromeDriver();
        } else {
            throw new RuntimeException(String.format("Browser %s is not supported", browser));
        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
