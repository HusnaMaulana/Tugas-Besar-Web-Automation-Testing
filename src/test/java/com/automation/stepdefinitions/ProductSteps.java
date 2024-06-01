package com.automation.stepdefinitions;

import static org.junit.Assert.*;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.hooks.Hooks;
import com.automation.pages.ProductsPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSteps {

    private WebDriver driver;
    private ProductsPage productsPage;
    private String originalWindow;

    @Before
    public void setUp() {
        Hooks.setUp();
        driver = Hooks.driver;
        productsPage = new ProductsPage(driver);
        originalWindow = driver.getWindowHandle();
    }

    @When("I click the twitter button")
    public void i_click_the_twitter_button() {
        productsPage.clickTwitterButton();
        // Wait for a new window or tab to open
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
    }

    @Then("The twitter page appear")
    public void the_twitter_page_appear() {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindow)) {
                // Switch to the new window
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Wait for the new URL to be loaded
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("x.com/saucelabs"));

        // Verify the URL
        String expectedUrl = "https://x.com/saucelabs";
        String actualUrl = driver.getCurrentUrl();
        assertTrue("Expected URL to contain: " + expectedUrl + " but was: " + actualUrl, actualUrl.contains(expectedUrl));

        // Close the new window and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @When("I click the filter button")
    public void i_click_the_filter_button() {
        productsPage.clickFilterButton();
    }

    @When("I click the option name Z-A")
    public void i_click_the_option_name_Z_A() {
        productsPage.clickFilterOption("Name (Z to A)");
    }

    @Then("The product sorted by name")
    public void the_product_sorted_by_name() {
        assertTrue(productsPage.isSortedByName());
    }

    @When("I click the option price \\(low to high\\)")
    public void i_click_the_option_price_low_to_high() {
        productsPage.clickFilterOption("Price (low to high)");
    }

    @Then("The product sorted by price")
    public void the_product_sorted_by_price() {
        assertTrue(productsPage.isSortedByPrice());
    }

    @After
    public void tearDown() {
        Hooks.tearDown();
    }
}
