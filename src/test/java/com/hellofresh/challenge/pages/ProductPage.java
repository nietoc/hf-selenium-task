package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage {

    private By addToCartBtnLocator = By.name("Submit");
    private By proceedToCheckoutBtnLocator = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartBtnLocator)).click();
    }

    public void clickProceedToCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutBtnLocator)).click();
    }

}
