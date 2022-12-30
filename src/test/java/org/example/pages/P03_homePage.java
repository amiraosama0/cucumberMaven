package org.example.pages;

import static org.example.stepDefs.Hooks.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P03_homePage {
    public WebElement customerCurrencyElement() {
        return driver.findElement(By.id("customerCurrency"));
    }

    public List<WebElement> priceListElement() {
        return driver.findElements(By.cssSelector("span[class=\"price actual-price\"]"
        ));
    }

    public WebElement searchFieldElement() {
        return driver.findElement(By.className("ui-autocomplete-input"));
    }

    public WebElement searchButtonElement() {
        return driver.findElement(By.cssSelector("button[class=\"button-1 search-box-button\"]"));
    }

    public List<WebElement> addToCardButtonElement() {
        return driver.findElements(By.cssSelector("button[class=\"button-2 product-box-add-to-cart-button\"]"));
    }

    public List<WebElement> productTitleElement() {
        return driver.findElements(By.cssSelector("h2[class=\"product-title\"]"));
    }

    public WebElement productPictureElement() {
        return driver.findElement(By.cssSelector("div[class=\"picture\"]"));
    }

    public WebElement skuElement() {
        return driver.findElement(By.id("sku-17"));
    }

    public List<WebElement> categoriesListElement() {
        return driver.findElements(By.xpath("//ul[@class=\"top-menu notmobile\"]/li"));
    }

    public List<WebElement> locatorElement(int selectedCategory) {
        return driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']//ul)[" + selectedCategory + "]/li"));
    }

    public WebElement pageTitleElement() {
        return driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }

    public WebElement controlButtonElement(int x) {
        return driver.findElement(By.cssSelector("a[rel=\"" + x + "\"]"));
    }

    public WebElement imgSliderElement() {
        return driver.findElement(By.cssSelector("div[id=\"nivo-slider\"]"));
    }

    public WebElement socialElement(String social) {
        return driver.findElement(By.linkText(social));
    }

    public WebElement downPageElement() {
        return driver.findElement(By.cssSelector("div[class=\"newsletter\"]"));
    }

    public WebElement wishListElement() {
        return driver.findElement(By.cssSelector("div[class=\"product-grid home-page-product-grid\"]"));
    }

    public List<WebElement> wishlistButtonElement() {
        return driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]"));
    }

    public WebElement backgroundRecElement() {
        return driver.findElement(By.cssSelector("div[class=\"bar-notification success\"]"));
    }

    public WebElement textContentElement() {
        return driver.findElement(By.cssSelector("p[class=\"content\"]"));
    }

    public WebElement wishListLabelTapElement() {
        return driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]"));
    }

    public WebElement closeTapElement() {
        return driver.findElement(By.cssSelector("span[class=\"close\"]"));
    }

    public WebElement qtyElement() {
        return driver.findElement(By.cssSelector("input[class=\"qty-input\"]"));
    }
}
