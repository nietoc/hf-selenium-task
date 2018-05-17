package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.helper.AccountDetails;
import com.hellofresh.challenge.steps.AccountCreationSteps;
import com.hellofresh.challenge.steps.LoginSteps;
import com.hellofresh.challenge.steps.MyAccountSteps;
import org.junit.Before;
import org.junit.Test;

public class SignUpTest extends BaseTest {

    private LoginSteps loginSteps;
    private AccountCreationSteps accountCreationSteps;
    private MyAccountSteps myAccountSteps;

    @Before
    public void initialize() {
        loginSteps = new LoginSteps(driver, wait);
        accountCreationSteps = new AccountCreationSteps(driver, wait);
        myAccountSteps = new MyAccountSteps(driver, wait);
    }

    @Test
    public void signUpTest() {
        loginSteps.goToLoginPage();

        AccountDetails accountDetails = new AccountDetails();

        loginSteps.startAccountCreation(accountDetails.getEmail());

        accountCreationSteps.fillAccountDetails(accountDetails);
        accountCreationSteps.submit();

        myAccountSteps.assertMyAccountDisplayed();
        myAccountSteps.assertLoggedInAs(accountDetails.getFullName());
    }

}
