package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P02_login;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import static org.example.stepDefs.Hooks.driver;
public class D02_loginStepDef {
    P02_login p02login = new P02_login();


    @Given("user go to login page")
    public void userGoToLoginPage() {
        p02login.loginElement().click();

    }

    @When("user login with {string} and {string}")
    public void userLoginWithAnd(String arg0, String arg1) {
        p02login.emailElement().sendKeys(arg0);
        p02login.passElement().sendKeys(arg1);
    }

    @When("user press on login button")
    public void userPressOnLoginButton() {
        p02login.loginButtonElement().click();

    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        SoftAssert soft =new SoftAssert();
        String actualUrl =driver.getCurrentUrl();
        soft.assertEquals(actualUrl,"https://demo.nopcommerce.com/");
        boolean myaccount = p02login.myAccountElement().isDisplayed();
        soft.assertTrue(myaccount);
        soft.assertAll();
    }


    @Then("user could not login to the system")
    public void userCouldNotLoginToTheSystem() {
        SoftAssert soft =new SoftAssert();
        String actualMsg = p02login.wrongMsgElement().getText();
        soft.assertEquals(actualMsg,"Wrong email");
        String actualcol = p02login.wrongMsgElement().getCssValue("color");
        actualcol = Color.fromString(actualcol).asHex();
        soft.assertEquals(actualcol,"#e4434b");
        soft.assertAll();
    }
}
