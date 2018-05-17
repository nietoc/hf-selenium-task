package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.OrderConfirmationPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        assertThat(orderConfirmationPage.getOrderCompleteText(), containsString("Your order on My Store is complete."));
        assertThat(orderConfirmationPage.isOnOrderConfirmationController(), is(true));
    }

    private void asserOrderConfirmationDisplayed() {
        WebElement heading = orderConfirmationPage.waitForVisibilityOfHeaderLocated();
        assertThat(heading.getText(), is("ORDER CONFIRMATION"));
    }

    private void assertOrderStepFourDisplayed() {
        assertThat(orderConfirmationPage.isOrderStepFourDisplayed(), is(true));
    }

    private void assertLastOrderStepDisplayed() {
        assertThat(orderConfirmationPage.isLastOrderStepDisplayed(), is(true));
    }

}
