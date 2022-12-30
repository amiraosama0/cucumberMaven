package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class D08_WishlistStepDef {

    P03_homePage home = new P03_homePage();

    @When("user click on wishlist button")
    public void step1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.wishListElement();
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        home.wishlistButtonElement().get(2).click();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
    }

    @Then("product successfully added to wishlist")
    public void successfullyAddedToWishList() {
//        WebDriverWait successWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        successWait.until(home.text().getText().equals("The product has been added to your wishlist"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        SoftAssert soft = new SoftAssert();
        String actualMsg = home.textContentElement().getText();
        soft.assertEquals(actualMsg, "The product has been added to your wishlist");
        String actualCol = home.backgroundRecElement().getCssValue("background-color");
        actualCol = Color.fromString(actualCol).asHex();
        soft.assertEquals(actualCol, "#4bb07a");
        soft.assertAll();
    }

    @And("user click on wishlist tap")
    public void userClickOnWishList() throws InterruptedException {
        home.closeTapElement().click();
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.wishListLabelTapElement();
        js.executeScript("arguments[0].scrollIntoView();", element);
        home.wishListLabelTapElement().click();

    }

    boolean check = false;

    @Then("get product quantity value bigger than zero")
    public void getQTyValueBiggerThan() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String number = home.qtyElement().getAttribute("value");
        int num = Integer.parseInt(number);
        if (num > 0) {
            check = true;
        }
        Assert.assertTrue(check);

    }
}
