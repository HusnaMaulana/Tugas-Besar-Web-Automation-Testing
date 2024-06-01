package com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/api/PutUserApi.feature",
    glue = {"com.api.stepdefinitions"},
    plugin = {"html:target/cucumber.html"}
)

public class RunCucumberTest {
}
