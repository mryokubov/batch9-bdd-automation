package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HomePage {


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    protected WebElement emailInput;

    @FindBy(id = "Password")
    protected WebElement passwordInput;

    @FindBy(id = "RememberMe")
    protected WebElement rememberMeCheckBox;

    @FindBy(linkText = "Forgot password?")
    protected WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    protected WebElement loginBtn;

    public void verifyPageTitle(){
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Login page title is not correct", homePageTitle.equals("nopCommerce demo store. Login"));
    }


    public void enterEmail(String username){
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }


    public void checkRememberMe(boolean check){
        if (check){
            if (!rememberMeCheckBox.isSelected()){
                rememberMeCheckBox.click();
            }
        }else{
            if (rememberMeCheckBox.isSelected()){
                rememberMeCheckBox.click();
            }
        }
    }

    public void clickLoginBtn(){
        loginBtn.click();
    }
}

