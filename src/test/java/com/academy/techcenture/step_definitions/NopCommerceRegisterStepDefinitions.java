package com.academy.techcenture.step_definitions;

import com.academy.techcenture.pages.HomePage;
import com.academy.techcenture.pages.LoginPage;
import com.academy.techcenture.pages.RegisterPage;
import com.academy.techcenture.utils.CommonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NopCommerceRegisterStepDefinitions {

    private WebDriver driver;
    private int randomUserId = CommonUtils.generateId();
    private String username;
    private String password;

    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;

    @Before
    public void beforeScenario(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        loginPage = new LoginPage(driver);
    }


    @Given("user is on the homepage")
    public void user_is_on_the_homepage() {
        homePage.verifyPageTitle();
    }
    @When("user clicks on register link on top")
    public void user_clicks_on_register_link_on_top() {
        homePage.clickRegisterLink();
    }
    @Then("user should be navigated to register page")
    public void user_should_be_navigated_to_register_page() {
       registerPage.verifyPageTitle();
    }
    @Then("user selects gender {string}")
    public void user_selects_gender(String gender) {
        registerPage.selectGender(gender);
    }
    @Then("user enters {string} in firstname input")
    public void user_enters_in_firstname_input(String firstname) {
        registerPage.enterFirstName(firstname);
    }
    @Then("user enters {string} in lastname input")
    public void user_enters_in_lastname_input(String lastname) {
        registerPage.enterLastName(lastname);
    }
    @Then("user selects {string} for day, {string} for month and {string} for year")
    public void user_selects_for_day_for_month_and_for_year(String day, String month, String year) {
       registerPage.enterDob(day, month, year);
    }
    @Then("user enters {string} in email input")
    public void user_enters_in_email_input(String email) {
       registerPage.enterEmail(email);
    }
    @Then("user enters {string} in company name input")
    public void user_enters_in_company_name_input(String companyName) {
        registerPage.enterCompanyName(companyName);
    }
    @Then("user selects {string} on newsletter radio box")
    public void user_selects_on_newsletter_radio_box(String check) {
        boolean shouldCheck = false;
        if (check.equals("check")){
            shouldCheck = true;
        }
        registerPage.checkNewsLetter(shouldCheck);
    }
    @Then("user enters {string} in password input")
    public void user_enters_in_password_input(String password) {
       registerPage.enterPassword(password);
    }
    @Then("user confirms {string} in confirm password input")
    public void user_confirms_in_confirm_password_input(String password) {
       registerPage.enterPasswordConfirm(password);
    }
    @When("user clicks on register button")
    public void user_clicks_on_register_button() {
       registerPage.clickRegisterBtn();
    }
    @Then("user should see {string} success message")
    public void user_should_see_success_message(String registerSuccessMsg) {
        registerPage.verifyRegisterSuccess(registerSuccessMsg);
    }
    @When("user clicks on continue button")
    public void user_clicks_on_continue_button() {
       registerPage.clickContinueBtn();
    }

    @When("user clicks on login link")
    public void user_clicks_on_login_link() {
        homePage.clickLoginLink();
    }
    @Then("user is on the login page")
    public void user_is_on_the_login_page() {
        loginPage.verifyPageTitle();
    }
    @Then("user enters valid username and password as login credentials")
    public void user_enters_valid_username_and_password_as_login_credentials() {


    }

    @And("user selects {string} on remember me radio box")
    public void userSelectsOnRememberMeRadioBox(String arg0) {
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("user can see my account link")
    public void user_can_see_my_account_link() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



    @After
    public void afterScenario(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }



}