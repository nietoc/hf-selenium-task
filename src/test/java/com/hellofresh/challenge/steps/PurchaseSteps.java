package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.NavigationHeaderPage;
import com.hellofresh.challenge.pages.ProductPage;
import com.hellofresh.challenge.pages.WomenCategoryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PurchaseSteps {

    private NavigationHeaderPage navigationHeaderPage;
    private WomenCategoryPage womenCategoryPage;
    private ProductPage productPage;

    public PurchaseSteps(WebDriver driver, WebDriverWait wait) {
        navigationHeaderPage = new NavigationHeaderPage(driver, wait);
        womenCategoryPage = new WomenCategoryPage(driver, wait);
        productPage = new ProductPage(driver, wait);
    }

    public void goToWomenCategory() {
        navigationHeaderPage.clickWomenCategory();
    }

    public void selectWomenShortSleeveTshirts() {
        womenCategoryPage.clickShortSleeveTshirts();
    }

    public void addToCart() {
        productPage.clickAddToCart();
    }

    public void proceedToCheckout() {
        productPage.clickProceedToCheckout();
    }

}
