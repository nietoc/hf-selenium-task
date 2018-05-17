package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.OrderConfirmationPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Slf4j
public class OrderConfirmationSteps {

    private OrderConfirmationPage orderConfirmationPage;

    public OrderConfirmationSteps(WebDriver driver, WebDriverWait wait) {
        orderConfirmationPage = new OrderConfirmationPage(driver, wait);
    }

    public void assertOrderConfirmed() {
        log.info("Verifying the order is confirmed...");

        asserOrderConfirmationDisplayed();
        assertOrderStepFourDisplayed();
        assertLastOrderStepDisplayed();
        assertTrue(orderConfirmationPage.getOrderCompleteText().contains("Your order on My Store is complete."));
        assertTrue(orderConfirmationPage.isOnOrderConfirmationController());
    }

    private void asserOrderConfirmationDisplayed() {
        WebElement heading = orderConfirmationPage.waitForVisibilityOfHeaderLocated();
        assertEquals("ORDER CONFIRMATION", heading.getText());
    }

    private void assertOrderStepFourDisplayed() {
        assertTrue(orderConfirmationPage.isOrderStepFourDisplayed());
    }

    private void assertLastOrderStepDisplayed() {
        assertTrue(orderConfirmationPage.isLastOrderStepDisplayed());
    }

}
