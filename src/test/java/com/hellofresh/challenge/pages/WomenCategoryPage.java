package com.hellofresh.challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenCategoryPage extends BasePage {

    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
    private WebElement shortSleeveTshirtsLink;

    public WomenCategoryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickShortSleeveTshirts() {
        shortSleeveTshirtsLink.click();
    }

}
