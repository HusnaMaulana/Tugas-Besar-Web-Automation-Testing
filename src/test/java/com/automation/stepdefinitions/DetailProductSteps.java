package com.automation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import com.automation.hooks.Hooks;
import com.automation.pages.*;

public class DetailProductSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private DetailProductPage detailProductPage;
    private Hooks hooks;

    @Before
    public void setUp() {
        hooks = new Hooks();
        driver = hooks.setUp();
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        detailProductPage = new DetailProductPage(driver);
    }

    @Given("I am logged in and on the products page")
    public void I_am_logged_in_and_on_the_products_page() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
        // Add wait to ensure the products page loads
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
    }

    @When("I click the product image")
    public void i_click_the_product_image() {
        productsPage.clickProductImage();
    }

    @When("I click the product name")
    public void i_click_the_product_name() {
        productsPage.clickProductName();
    }

    @Then("I should be redirected to the detail product page")
    public void i_should_be_redirected_to_the_product_detail_page() {
        assertTrue(driver.getCurrentUrl().contains("inventory-item.html?id=4"));
    }

    @When("I click back to product button")
    public void i_click_the_back_to_product() {
        detailProductPage.clickBackButton();
    }

    @After
    public void tearDown() {
        Hooks.tearDown();
    }
}