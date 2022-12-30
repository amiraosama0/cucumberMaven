package org.example.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.stepDefs.Hooks.driver;
public class P01_register {
    public WebElement register() {
        return driver.findElement(By.className("ico-register"));
    }

    public WebElement gender() {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement firstname() {
        return driver.findElement(By.id("FirstName"));
    }

    public WebElement lastname() {
        return driver.findElement(By.id("LastName"));
    }

    public WebElement dayList() {
        return driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement MonthList() {
        return driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement year() {
        return driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement email() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement password() {
        return driver.findElement(By.id("Password"));
    }

    public WebElement confimpassword() {
        return driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement RegisterButton() {
        return driver.findElement(By.id("register-button"));

    }
    public WebElement successMsg()
    {
        return  driver.findElement(By.className("result"));
    }
    public WebElement Continue()
    {
        return  driver.findElement(By.className("register-continue-button"));

    }
}