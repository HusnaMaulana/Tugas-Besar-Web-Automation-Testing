package com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources/api", "src/test/resources/automation"},
    glue = {"com.api.stepdefinitions", "com.automation.stepdefinitions"},
    plugin = {"html:target/cucumber.html"}
)

public class RunCucumberTest {
}
