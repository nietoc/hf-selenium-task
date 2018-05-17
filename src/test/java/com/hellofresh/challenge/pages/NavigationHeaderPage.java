package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationHeaderPage extends BasePage {

    private By womenLinkLocator = By.linkText("Women");

    public NavigationHeaderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void clickWomenCategory() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(womenLinkLocator)).click();
    }
}
