package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.steps.AccountCreationSteps;
import com.hellofresh.challenge.steps.LoginSteps;
import com.hellofresh.challenge.steps.MyAccountSteps;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

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

        String timestamp = String.valueOf(new Date().getTime());
        String email = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
        String name = "Firstname";
        String surname = "Lastname";
        String fullName = name + " " + surname;

        loginSteps.startAccountCreation(email);

        accountCreationSteps.fillAccountDetails(name, surname);
        accountCreationSteps.submit();

        myAccountSteps.assertMyAccountDisplayed();
        myAccountSteps.assertLoggedInAs(fullName);
    }

}
