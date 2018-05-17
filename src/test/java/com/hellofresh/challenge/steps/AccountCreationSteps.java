package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.AccountCreationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationSteps {

    private AccountCreationPage accountCreationPage;

    public AccountCreationSteps(WebDriver driver, WebDriverWait wait) {
        accountCreationPage = new AccountCreationPage(driver, wait);
    }

    public void fillAccountDetails(String firstName, String lastName) {
        accountCreationPage.selectMrsTitle();
        accountCreationPage.fillFirstName(firstName);
        accountCreationPage.fillLastName(lastName);
        accountCreationPage.fillPassword("Qwerty");
        accountCreationPage.selectBirthDay("1");
        accountCreationPage.selectBirthMonth("1");
        accountCreationPage.selectBirthYear("2000");
        accountCreationPage.fillCompany("Company");
        accountCreationPage.fillAddress1("Qwerty, 123");
        accountCreationPage.fillAddress2("zxcvb");
        accountCreationPage.fillCity("Qwerty");
        accountCreationPage.selectState("Colorado");
        accountCreationPage.fillPostCode("12345");
        accountCreationPage.fillOther("Qwerty");
        accountCreationPage.fillPhone("12345123123");
        accountCreationPage.fillMobile("12345123123");
        accountCreationPage.fillAlias("hf");
    }

    public void submit() {
        accountCreationPage.submit();
    }
}
