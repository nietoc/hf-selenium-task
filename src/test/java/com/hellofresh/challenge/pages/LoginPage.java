package com.hellofresh.challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement submitBtn;

    @FindBy(id = "email_create")
    private WebElement createAccountEmailField;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillEmail(String value) {
        emailField.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void login() {
        submitBtn.click();
    }

    public void fillCreateAccountEmail(String value) {
        createAccountEmailField.sendKeys(value);
    }

    public void clickCreateAccount() {
        createAccountBtn.click();
    }
}
