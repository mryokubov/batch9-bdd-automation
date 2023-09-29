package com.academy.techcenture.hooks;

import com.academy.techcenture.config.ConfigReader;
import com.academy.techcenture.driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static WebDriver driver;
    @Before
    public void beforeScenario(){
       driver = Driver.getDriver();
       driver.get(ConfigReader.getProperty("url"));
    }

    @After
    public void afterScenario(){
        Driver.quitDriver();
        driver = null;
    }
}
