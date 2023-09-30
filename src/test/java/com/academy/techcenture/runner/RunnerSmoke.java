package com.academy.techcenture.runner;

import io.cucumber.junit .Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/com/academy/techcenture/features/"} ,
        glue = {"com/academy/techcenture/step_definitions", "com/academy/techcenture/hooks"})
public class RunnerSmoke {

}