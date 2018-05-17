package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    private By summaryProceedToCheckoutBtnLocator = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
    private By addressProceedToCheckoutBtnLocator = By.name("processAddress");
    private By agreeToTermsCheckBoxLocator = By.id("uniform-cgv");
    private By bankwirePaymentBtnLocator = By.className("bankwire");
    private By confirmOrderBtnLocator = By.xpath("//*[@id='cart_navigation']/button");

    @FindBy(name = "processCarrier")
    private WebElement shippingProceedToCheckoutBtn;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickSummaryProceedToCheckoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(summaryProceedToCheckoutBtnLocator)).click();
    }

    public void clickAddressProceedToCheckoutBtn() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressProceedToCheckoutBtnLocator)).click();
    }

    public void checkAgreeToTerms() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(agreeToTermsCheckBoxLocator)).click();
    }

    public void clickShippingProceedToCheckoutBtn() {
        shippingProceedToCheckoutBtn.click();
    }

    public void clickBankWire() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bankwirePaymentBtnLocator)).click();
    }

    public void clickConfirmOrder() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmOrderBtnLocator)).click();
    }

}
