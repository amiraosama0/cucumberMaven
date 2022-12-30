package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import io.cucumber.java.en.Given;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import static org.example.stepDefs.Hooks.driver;

public class D01_registerStepDef {
    P01_register p01_register = new P01_register();

    @Given("user go to register page")
    public void step1() {
        p01_register.register().click();
    }

    @When("user select gender type")
    public void step2() {
        p01_register.gender().click();
    }

    @And("user enter first & last name")
    public void userEnterFirstLastName() {
        p01_register.firstname().sendKeys("amira");
        p01_register.lastname().sendKeys("osama");
    }

    @And("user enter date of birth")
    public void userEnterDateOfBirth() {
        Select day = new Select(p01_register.dayList());
        day.selectByValue("2");
        Select Month = new Select(p01_register.MonthList());
        Month.selectByVisibleText("May");
        Select year = new Select(p01_register.year());
        year.selectByValue("1995");
    }

    @And("user enter validEmail")
    public void userEnterValidEmail() {
        p01_register.email().sendKeys("amira.osama036555@gmeil.com");
    }

    @And("user enter password & confirm password")
    public void userEnterPasswordConfirmPassword() {
        p01_register.password().sendKeys("123456");
        p01_register.confimpassword().sendKeys("123456");
    }

    @And("user click on register button")
    public void userClickOnRegisterButton() {
        p01_register.RegisterButton().click();

    }

    @Then("account created successfully")
    public void accountCreatedSuccessfully() {
        SoftAssert soft = new SoftAssert();
        String actualurl = driver.getCurrentUrl();
        soft.assertEquals(actualurl, "https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String actualMsg = p01_register.successMsg().getText();
        soft.assertEquals(actualMsg, "Your registration completed");
        String actualColor = p01_register.successMsg().getCssValue("color");
        actualColor = Color.fromString(actualColor).asHex();
        soft.assertEquals(actualColor, "#4cb17c");

        boolean statusBTN = p01_register.Continue().isDisplayed();
        soft.assertTrue(statusBTN);
        soft.assertAll();
    }
}
