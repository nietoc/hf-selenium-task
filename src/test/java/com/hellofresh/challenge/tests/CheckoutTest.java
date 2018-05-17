package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.steps.CheckoutSteps;
import com.hellofresh.challenge.steps.LoginSteps;
import com.hellofresh.challenge.steps.OrderConfirmationSteps;
import com.hellofresh.challenge.steps.PurchaseSteps;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    private LoginSteps loginSteps;
    private PurchaseSteps purchaseSteps;
    private CheckoutSteps checkoutSteps;
    private OrderConfirmationSteps orderConfirmationSteps;

    @Before
    public void initialize() {
        loginSteps = new LoginSteps(driver, wait);
        purchaseSteps = new PurchaseSteps(driver, wait);
        checkoutSteps = new CheckoutSteps(driver, wait);
        orderConfirmationSteps = new OrderConfirmationSteps(driver, wait);
    }

    @Test
    public void checkoutTest() {
        loginSteps.goToLoginPage();
        loginSteps.login(existingUserEmail, existingUserPassword);

        purchaseSteps.goToWomenCategory();
        purchaseSteps.selectWomenShortSleeveTshirts();
        purchaseSteps.addToCart();
        purchaseSteps.proceedToCheckout();

        checkoutSteps.proceedToCheckoutFromSummary();
        checkoutSteps.proceedToCheckoutFromAddress();
        checkoutSteps.agreeToTerms();
        checkoutSteps.proceedToCheckoutFromShipping();
        checkoutSteps.selectBankwirePayment();
        checkoutSteps.confirmOrder();

        orderConfirmationSteps.assertOrderConfirmed();
    }
    
}
