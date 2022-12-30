package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.example.stepDefs.Hooks.driver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class D07_followUsStepDef {

    P03_homePage home = new P03_homePage();

    @When("user scroll down the page")
    public void step1() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = home.downPageElement();
        js.executeScript("arguments[0].scrollIntoView();", element);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }

    @And("user open link {string}")
    public void userOpenFacebookLink(String social) {
        home.socialElement(social).click();
    }

    @Then("new tap is opened expected {string}")
    public void newTapIsOpened(String expected) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> tabs = driver.getWindowHandles();
        ArrayList<String> arrayTabList = new ArrayList<String>(tabs);
        driver.switchTo().window(arrayTabList.get(1));
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expected);
        driver.close();
        driver.switchTo().window(arrayTabList.get(0));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
}
