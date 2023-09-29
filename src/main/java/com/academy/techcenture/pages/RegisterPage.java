package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends HomePage{

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FirstName")
    protected WebElement firstNameInput;

    @FindBy(id = "LastName")
    protected WebElement lastNameInput;

    @FindBy(name = "DateOfBirthDay")
    protected WebElement dateOfBirthDaySelect;

    @FindBy(name = "DateOfBirthMonth")
    protected WebElement dateOfBirthMonthSelect;

    @FindBy(name = "DateOfBirthYear")
    protected WebElement dateOfBirthYearSelect;

    @FindBy(id = "Email")
    protected WebElement emailInput;

    @FindBy(id = "Company")
    protected WebElement companyNameInput;

    @FindBy(id = "Newsletter")
    protected WebElement newsLetterCheckBox;

    @FindBy(id = "Password")
    protected WebElement passwordInput;

    @FindBy(id = "ConfirmPassword")
    protected WebElement confirmPasswordInput;

    @FindBy(id = "register-button")
    protected WebElement registerBtn;

    @FindBy(className = "result")
    protected WebElement registerSuccess;

    @FindBy(linkText = "CONTINUE")
    protected WebElement continueBtn;

    public void verifyPageTitle(){
        String registerPageTitle = driver.getTitle();
        Assert.assertTrue("Register page title is not correct", registerPageTitle.equals("nopCommerce demo store. Register"));
    }

    public void selectGender(String gender){
        driver.findElement(By.id("gender-"+gender)).click();
    }

    public void enterFirstName(String firstName){
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName){
        lastNameInput.sendKeys(lastName);
    }

    public void enterDob(String day, String month, String year){
        Select daySelect = new Select(dateOfBirthDaySelect);
        daySelect.selectByValue(day);

        Select monthSelect = new Select(dateOfBirthMonthSelect);
        monthSelect.selectByVisibleText(month);

        Select yearSelect = new Select(dateOfBirthYearSelect);
        yearSelect.selectByValue(year);
    }

    public void enterEmail(String email){
        emailInput.sendKeys(email);
    }

    public void enterCompanyName(String companyName){
        companyNameInput.sendKeys(companyName);
    }

    public void checkNewsLetter(boolean check){
        if (check){
            if (!newsLetterCheckBox.isSelected()){
                newsLetterCheckBox.click();
            }
        }else{
            if (newsLetterCheckBox.isSelected()){
                newsLetterCheckBox.click();
            }
        }
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void enterPasswordConfirm(String password){
        confirmPasswordInput.sendKeys(password);
    }

    public void clickRegisterBtn(){
        registerBtn.click();
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }

    public void verifyRegisterSuccess(String registerMessage){
        Assert.assertTrue("Register message is not correct",registerSuccess.getText().trim().equals(registerMessage));
    }

}
