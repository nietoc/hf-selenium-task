package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.helper.AccountDetails;
import com.hellofresh.challenge.pages.AccountCreationPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
public class AccountCreationSteps {

    private AccountCreationPage accountCreationPage;

    public AccountCreationSteps(WebDriver driver, WebDriverWait wait) {
        accountCreationPage = new AccountCreationPage(driver, wait);
    }

    public void fillAccountDetails(AccountDetails accountDetails) {
        log.info("Creating a new account for '{} {}'",  accountDetails.getFirstName(), accountDetails.getLastName());
        log.debug("Full account details: {}", accountDetails);

        accountCreationPage.selectMrsTitle();
        accountCreationPage.fillFirstName(accountDetails.getFirstName());
        accountCreationPage.fillLastName(accountDetails.getLastName());
        accountCreationPage.fillPassword(accountDetails.getPassword());
        accountCreationPage.selectBirthDay(accountDetails.getBirthDate().dayOfMonth().getAsString());
        accountCreationPage.selectBirthMonth(accountDetails.getBirthDate().monthOfYear().getAsString());
        accountCreationPage.selectBirthYear(accountDetails.getBirthDate().year().getAsString());
        accountCreationPage.fillCompany(accountDetails.getCompany());
        accountCreationPage.fillAddress1(accountDetails.getAddress1());
        accountCreationPage.fillAddress2(accountDetails.getAddress2());
        accountCreationPage.fillCity(accountDetails.getCity());
        accountCreationPage.selectState(accountDetails.getState());
        accountCreationPage.fillPostCode(accountDetails.getPostCode());
        accountCreationPage.fillOther(accountDetails.getOther());
        accountCreationPage.fillPhone(accountDetails.getPhone());
        accountCreationPage.fillMobile(accountDetails.getMobile());
        accountCreationPage.fillAlias(accountDetails.getAlias());
    }

    public void submit() {
        log.debug("Submitting the account details");

        accountCreationPage.submit();
    }
}
