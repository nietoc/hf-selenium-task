package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class MyAccountSteps {

    private MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver, WebDriverWait wait) {
        myAccountPage = new MyAccountPage(driver, wait);
    }

    public void assertMyAccountDisplayed() {
        WebElement heading = myAccountPage.waitForVisibilityOfHeaderLocated();
        assertEquals("MY ACCOUNT", heading.getText());
    }

    private void assertUsernameDisplayed(String expected) {
        assertEquals(expected, myAccountPage.getUsernameDisplayed());
    }

    public void assertLoggedInAs(String fullName) {
        assertUsernameDisplayed(fullName);
        assertTrue(myAccountPage.getAccountInfoText().contains("Welcome to your account."));
        assertTrue(myAccountPage.isLogoutDisplayed());
        assertTrue(myAccountPage.isOnMyAccountController());
    }
}
