package com.academy.techcenture.step_definitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchStepDefinition {

    private WebDriver driver;
    private String searchItem;

    @Given("user launches a browser")
    public void user_launches_a_browser() {
       WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @And("user navigates to google search page")
    public void user_navigates_to_google_search_page() {
       driver.get("https://google.com");
    }

    @When("user searches for {string}")
    public void userSearchesFor(String searchItem) {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(searchItem + Keys.ENTER);
        this.searchItem = searchItem; //copy the searchItem value into this.searchItem class member
    }

    @Then("user should see search result")
    public void user_should_see_search_result() {
        String title = driver.getTitle();
        Assert.assertTrue("Title does not contain Unicorn", title.contains(searchItem));
    }
}
