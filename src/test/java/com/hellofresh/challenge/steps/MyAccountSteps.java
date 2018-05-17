package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.MyAccountPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@Slf4j
public class MyAccountSteps {

    private MyAccountPage myAccountPage;

    public MyAccountSteps(WebDriver driver, WebDriverWait wait) {
        myAccountPage = new MyAccountPage(driver, wait);
    }

    public void assertMyAccountDisplayed() {
        WebElement heading = myAccountPage.waitForVisibilityOfHeaderLocated();
        assertThat(heading.getText(), is("MY ACCOUNT"));
    }

    private void assertUsernameDisplayed(String expected) {
        String username = myAccountPage.getUsernameDisplayed();
        log.debug("Logged in user: '{}'", username);

        assertThat(username, is(expected));
    }

    public void assertLoggedInAs(String fullName) {
        assertUsernameDisplayed(fullName);
        assertThat(myAccountPage.getAccountInfoText(), containsString("Welcome to your account."));
        assertThat(myAccountPage.isLogoutDisplayed(), is(true));
        assertThat(myAccountPage.isOnMyAccountController(), is(true));
    }
}
