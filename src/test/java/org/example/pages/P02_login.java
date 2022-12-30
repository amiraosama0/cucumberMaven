package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.example.stepDefs.Hooks.driver;

public class P02_login {
    public WebElement loginElement(){
        return driver.findElement(By.className("ico-login"));
    }

    public WebElement emailElement(){
        return driver.findElement(By.className("email"));
    }
    public WebElement passElement() {
        return driver.findElement(By.className("password"));
    }
    public WebElement loginButtonElement() {
        return driver.findElement(By.className("login-button"));

    }
    public WebElement myAccountElement() {
        return driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }
    public WebElement wrongMsgElement() {
        return driver.findElement(By.className("field-validation-error"));
    }

}