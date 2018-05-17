package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    private By headerLocator = By.cssSelector("h1");

    @FindBy(className = "account")
    private WebElement usernameLink;

    @FindBy(className = "info-account")
    private WebElement accountInfoField;

    @FindBy(className = "logout")
    private WebElement logoutLink;

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement waitForVisibilityOfHeaderLocated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    public String getUsernameDisplayed() {
        return usernameLink.getText();
    }

    public String getAccountInfoText() {
        return accountInfoField.getText();
    }

    public boolean isLogoutDisplayed() {
        return logoutLink.isDisplayed();
    }

    public boolean isOnMyAccountController() {
        return driver.getCurrentUrl().contains("controller=my-account");
    }

}
