package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.example.stepDefs.Hooks.driver;

public class D06_homeSlidersStepDef {
    P03_homePage home = new P03_homePage();

    @When("user press on the slider {int}")
    public void step1(int x) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(home.controlButtonElement(x), "class", "nivo-control active"));
    }

    @And("user press on the image")
    public void userPressOnTheIphoneImage() {
        home.imgSliderElement().click();
    }

    @Then("user must go to another webpage {string}")
    public void userMustGoToAnotherWebpage(String arg0) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, arg0);
    }
}
