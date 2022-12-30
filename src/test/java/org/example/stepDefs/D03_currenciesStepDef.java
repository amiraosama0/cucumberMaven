package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class D03_currenciesStepDef {
    P03_homePage p03homePage = new P03_homePage();

    @Then("fist option is dollar")
    public void step1(){
Select currList =new Select(p03homePage.customerCurrencyElement());
String first0ption = currList.getFirstSelectedOption().getText();
        Assert.assertEquals(first0ption,"US Dollar");
    }

    @Then("first option is dollar")
    public void firstOptionIsDollar() {
    }

    @When("user select Euro option")
    public void userSelectEuroOption() {
        Select currList =new Select(p03homePage.customerCurrencyElement());
        currList.selectByVisibleText("Euro");
    }

    @Then("price changed successfully")
    public void priceChangedSuccessfully() {
for (int x=0;x<4;x++)
{
    String price = p03homePage.priceListElement(). get(x).getText();
    System.out.println(x);
    System.out.println(price);
    Assert.assertTrue(price.contains("€"));
    }
}
}
