package com.hellofresh.challenge.steps;

import com.hellofresh.challenge.pages.NavigationHeaderPage;
import com.hellofresh.challenge.pages.ProductPage;
import com.hellofresh.challenge.pages.WomenCategoryPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j
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
        log.debug("Clicking on the 'Women' category...");

        navigationHeaderPage.clickWomenCategory();
    }

    public void selectWomenShortSleeveTshirts() {
        log.debug("Selecting 'short sleeve T shirts'...");

        womenCategoryPage.clickShortSleeveTshirts();
    }

    public void addToCart() {
        log.debug("Adding to cart...");

        productPage.clickAddToCart();
    }

    public void proceedToCheckout() {
        log.debug("Proceeding to checkout...");

        productPage.clickProceedToCheckout();
    }

}
