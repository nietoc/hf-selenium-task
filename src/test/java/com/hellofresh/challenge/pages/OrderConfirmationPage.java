package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderConfirmationPage extends BasePage {

    private By headerLocator = By.cssSelector("h1");

    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private WebElement orderStepFourListItem;

    @FindBy(xpath = "//li[@id='step_end' and @class='step_current last']")
    private WebElement lastOrderStepListItem;

    @FindBy(xpath ="//*[@class='cheque-indent']/strong")
    private WebElement orderCompleteText;

    public OrderConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement waitForVisibilityOfHeaderLocated() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headerLocator));
    }

    public boolean isOrderStepFourDisplayed() {
        return orderStepFourListItem.isDisplayed();
    }

    public boolean isLastOrderStepDisplayed() {
        return lastOrderStepListItem.isDisplayed();
    }

    public String getOrderCompleteText() {
        return orderCompleteText.getText();
    }

    public boolean isOnOrderConfirmationController() {
        return driver.getCurrentUrl().contains("controller=order-confirmation");
    }

}
