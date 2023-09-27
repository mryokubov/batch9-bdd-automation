package com.academy.techcenture.step_definitions;

import com.academy.techcenture.utils.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.time.Duration;

public class NopCommerceRegisterStepDefinitions {

    private WebDriver driver;
    private int randomUserId = CommonUtils.generateId();
    private String username;
    private String password;

    //this method will execute before the scenario begins
    @Before
    public void beforeScenario(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");
    }

    //this method will execute before the scenario begins
    @After
    public void afterScenario(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }

    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Home page title is not correct", homePageTitle.equals("nopCommerce demo store"));
    }
    @When("user clicks on register link on top")
    public void user_clicks_on_register_link_on_top() {
        driver.findElement(By.linkText("Register")).click();
    }
    @Then("user should be navigated to register page")
    public void user_should_be_navigated_to_register_page() {
        String registerPageTitle = driver.getTitle();
        Assert.assertTrue("Register page title is not correct", registerPageTitle.equals("nopCommerce demo store. Register"));
    }
    @Then("user selects gender male")
    public void user_selects_gender_male() {
        driver.findElement(By.id("gender-male")).click();
    }
    @Then("user enters {string} for firstname input")
    public void user_enters_for_firstname_input(String firstname) {
       driver.findElement(By.id("FirstName")).sendKeys(firstname);
    }
    @Then("user enters {string} for lastname input")
    public void user_enters_for_lastname_input(String lastname) {
        driver.findElement(By.id("LastName")).sendKeys(lastname);
    }
    @Then("user selects {string} for day, {string} for month and {string} for year")
    public void user_selects_for_day_for_month_and_for_year(String day, String month, String year) {
        Select selectDay = new Select(driver.findElement(By.name("DateOfBirthDay")));
        selectDay.selectByValue(day);

        Select selectMonth = new Select(driver.findElement(By.name("DateOfBirthMonth")));
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(driver.findElement(By.name("DateOfBirthYear")));
        selectYear.selectByValue(year);

    }
    @Then("user enters {string} in email input")
    public void user_enters(String email) {
        int indexOfAt = email.indexOf("@");
        this.username = email.substring(0 , indexOfAt) + randomUserId + email.substring(indexOfAt);
        driver.findElement(By.id("Email")).sendKeys(username);
    }
    @Then("user enters {string} for company name input")
    public void user_enters_for_company_name_input(String companyName) {
       driver.findElement(By.id("Company")).sendKeys(companyName);
    }
    @Then("user unselects newsletter radio box")
    public void user_unselects_newsletter_radio_box() {
        WebElement newsletter = driver.findElement(By.id("Newsletter"));
        if (newsletter.isSelected()){
            newsletter.click();
        }
    }
    @Then("user enters {string} for password input")
    public void user_enters_for_password_input(String password) {
        driver.findElement(By.id("Password")).sendKeys(password);
        this.password = password;
    }
    @Then("user confirms {string} for confirm password input")
    public void user_confirms_for_confirm_password_input(String password) {
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
        driver.findElement(By.id("register-button")).click();
    }
    @Then("user should see {string} success message")
    public void user_should_see_success_message(String registerSuccessMsg) {
       Assert.assertTrue("Register success is not correct", driver.findElement(By.className("result")).getText().trim().equals(registerSuccessMsg));
    }
    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.linkText("CONTINUE")).click();
    }
    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        driver.findElement(By.linkText("Log in")).click();
    }
    @Then("user is on the login page")
    public void user_is_on_the_login_page() {
        String homePageTitle = driver.getTitle();
        Assert.assertTrue("Login page title is not correct", homePageTitle.equals("nopCommerce demo store. Login"));
    }
    @Then("user enters valid username and password as login credentials")
    public void user_enters_and_as_login_credentials() {

        driver.findElement(By.id("Email")).sendKeys(this.username);
        driver.findElement(By.id("Password")).sendKeys(this.password);
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        driver.findElement(By.xpath("//button[contains(@class, 'login-button')]")).click();
    }
    @Then("user can see my account link")
    public void user_can_see_my_account_link() {
        Assert.assertTrue("My Account link is not displayed", driver.findElement(By.linkText("My account")).isDisplayed());

    }

}