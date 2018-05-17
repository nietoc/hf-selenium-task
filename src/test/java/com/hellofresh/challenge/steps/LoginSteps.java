package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        loginPage.fillEmail(email);
        loginPage.fillPassword(password);
        loginPage.submit();
    }
}
