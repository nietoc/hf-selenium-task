package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationPage extends BasePage {

    private By mrsTitleLocator = By.id("id_gender2");

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "days")
    private WebElement birthDayDropdown;

    @FindBy(id = "months")
    private WebElement birthMonthDropdown;

    @FindBy(id = "years")
    private WebElement birthYearDropdown;

    @FindBy(id = "company")
    private WebElement companyField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "id_state")
    private WebElement stateDropdown;

    @FindBy(id = "postcode")
    private WebElement postCodeField;

    @FindBy(id = "other")
    private WebElement otherField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;

    @FindBy(id = "alias")
    private WebElement aliasField;

    @FindBy(id = "submitAccount")
    private WebElement submitBtn;

    public AccountCreationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void selectMrsTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mrsTitleLocator)).click();
    }

    public void fillFirstName(String value) {
        firstNameField.sendKeys(value);
    }

    public void fillLastName(String value) {
        lastNameField.sendKeys(value);
    }

    public void fillPassword(String value) {
        passwordField.sendKeys(value);
    }

    public void selectBirthDay(String value) {
        selectByValue(birthDayDropdown, value);
    }

    public void selectBirthMonth(String value) {
        selectByValue(birthMonthDropdown, value);
    }

    public void selectBirthYear(String value) {
        selectByValue(birthYearDropdown, value);
    }

    public void selectState(String value) {
        selectByVisibleText(stateDropdown, value);
    }

    private void selectByValue(WebElement webElement, String value) {
        new Select(webElement).selectByValue(value);
    }

    private void selectByVisibleText(WebElement webElement, String value) {
        new Select(webElement).selectByVisibleText(value);
    }

    public void fillCompany(String value) {
        companyField.sendKeys(value);
    }

    public void fillAddress1(String value) {
        address1Field.sendKeys(value);
    }

    public void fillAddress2(String value) {
        address2Field.sendKeys(value);
    }

    public void fillCity(String value) {
        cityField.sendKeys(value);
    }

    public void fillPostCode(String value) {
        postCodeField.sendKeys(value);
    }

    public void fillOther(String value) {
        otherField.sendKeys(value);
    }

    public void fillPhone(String value) {
        phoneField.sendKeys(value);
    }

    public void fillMobile(String value) {
        mobilePhoneField.sendKeys(value);
    }

    public void fillAlias(String value) {
        aliasField.clear();
        aliasField.sendKeys(value);
    }

    public void submit() {
        submitBtn.click();
    }

}
