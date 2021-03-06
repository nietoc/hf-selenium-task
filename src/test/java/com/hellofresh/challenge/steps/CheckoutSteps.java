package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.CheckoutPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    public CheckoutSteps(WebDriver driver, WebDriverWait wait) {
        checkoutPage = new CheckoutPage(driver, wait);
    }

    public void proceedToCheckoutFromSummary() {
        checkoutPage.clickSummaryProceedToCheckoutBtn();
    }

    public void proceedToCheckoutFromAddress() {
        checkoutPage.clickAddressProceedToCheckoutBtn();
    }

    public void agreeToTerms() {
        checkoutPage.checkAgreeToTerms();
    }

    public void proceedToCheckoutFromShipping() {
        checkoutPage.clickShippingProceedToCheckoutBtn();
    }

    public void selectBankwirePayment() {
        checkoutPage.clickBankWire();
    }

    public void confirmOrder() {
        log.debug("Confirming the order...");

        checkoutPage.clickConfirmOrder();
    }

}
