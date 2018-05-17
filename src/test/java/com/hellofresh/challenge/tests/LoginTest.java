package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.steps.LoginSteps;
import com.hellofresh.challenge.steps.MyAccountSteps;
import org.junit.Before;
import org.junit.Test;

public class LoginTest extends BaseTest {

    private LoginSteps loginSteps;
    private MyAccountSteps myAccountSteps;

    @Before
    public void initialize() {
        loginSteps = new LoginSteps(driver, wait);
        myAccountSteps = new MyAccountSteps(driver, wait);
    }

    @Test
    public void logInTest() {
        loginSteps.goToLoginPage();
        loginSteps.login(existingUserEmail, existingUserPassword);

        myAccountSteps.assertMyAccountDisplayed();

        myAccountSteps.assertLoggedInAs(existingUserFullName);
    }
}
