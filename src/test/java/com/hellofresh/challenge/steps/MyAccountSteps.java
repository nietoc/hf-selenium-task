package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.MyAccountPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

@Slf4j
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
        String username = myAccountPage.getUsernameDisplayed();
        log.debug("Logged in user: '{}'", username);

        assertEquals(expected, username);
    }

    public void assertLoggedInAs(String fullName) {
        assertUsernameDisplayed(fullName);
        assertTrue(myAccountPage.getAccountInfoText().contains("Welcome to your account."));
        assertTrue(myAccountPage.isLogoutDisplayed());
        assertTrue(myAccountPage.isOnMyAccountController());
    }
}
