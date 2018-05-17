package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.LoginPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;

    public LoginSteps(WebDriver driver, WebDriverWait wait) {
        homePage = new HomePage(driver, wait);
        loginPage = new LoginPage(driver, wait);
    }

    public void goToLoginPage() {
        homePage.clickLogin();
    }

    public void login(String email, String password) {
        log.info("Logging in using '{}' : '{}'",  email, password);

        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.login();
    }

    public void startAccountCreation(String email) {
        log.info("Creating a new account with email '{}'",  email);

        loginPage.fillCreateAccountEmail(email);
        loginPage.clickCreateAccount();
    }
}
