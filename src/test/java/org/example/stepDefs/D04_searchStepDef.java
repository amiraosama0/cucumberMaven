package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D04_searchStepDef {
    P03_homePage p03homePage = new P03_homePage();
    static String search;

    @When("user enter product {string}")
    public void userEnterProduct(String arg0) {
        search = arg0;
        p03homePage.searchFieldElement().sendKeys(search);
    }

    @When("user press on search button")
    public void userPressOnSearchButton() {
        p03homePage.searchButtonElement().click();
    }

    @Then("results must be shown")
    public void resultsMustBeShown() {
        SoftAssert soft = new SoftAssert();
        String actualUrl = driver.getCurrentUrl();
        soft.assertEquals(actualUrl, "https://demo.nopcommerce.com/search?q=" + search);
        int size = p03homePage.addToCardButtonElement().size();
        System.out.println("Size= " + size);
        for (int x = 0; x < size; x++) {
            String ProductName = p03homePage.productTitleElement().get(x).getText();
            System.out.println(x);
            System.out.println(ProductName.toLowerCase());
        }
        soft.assertAll();
    }

    @And("user press on the product")
    public void userPressOnTheProduct() {
        p03homePage.productPictureElement().click();
    }

    @Then("sku of the product must be the same like on search")
    public void skuOfTheProductMustBeTheSameLikeOnSearch() {
        String actualMessage = p03homePage.skuElement().getText();
        Assert.assertEquals(actualMessage, search);
    }
}
