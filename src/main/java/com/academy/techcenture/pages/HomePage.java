package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(linkText = "Register")
    protected WebElement registerLink;

    @FindBy(linkText = "Log in")
    protected WebElement loginLink;

    @FindBy(linkText = "My account")
    protected WebElement myAccountLink;

    @FindBy(linkText = "Log out")
    protected WebElement logOutLink;

    public void verifyPageTitle(){
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Home page title is not correct", homePageTitle.equals("nopCommerce demo store"));
    }

    public void clickRegisterLink(){
        registerLink.click();
    }

    public void clickLoginLink(){
        loginLink.click();
    }

    public void clickLogoutLink(){
        logOutLink.click();
    }

    public void verifyMyAccountLink(){
        Assert.assertTrue("My Account Link is not displayed", myAccountLink.isDisplayed());
    }

}
