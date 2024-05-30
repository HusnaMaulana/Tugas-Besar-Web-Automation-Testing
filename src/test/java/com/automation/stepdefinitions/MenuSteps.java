package com.automation.stepdefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import com.automation.hooks.Hooks;
import com.automation.pages.MenuPage;
import com.automation.pages.ProductsPage;

public class MenuSteps {

    private WebDriver driver;
    private MenuPage menuPage;
    @Before
    public void setUp() {
        Hooks.setUp();
        driver = Hooks.driver;
        new ProductsPage(driver);
        menuPage = new MenuPage(driver);
    }

    @Then("The menu should appear")
    public void the_menu_should_appear() {
        // Verify that the menu is displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuPage.ALL_ITEMS_LINK));
        assertTrue(driver.findElement(menuPage.ALL_ITEMS_LINK).isDisplayed());
    }

    @When("I click the about button")
    public void i_click_the_close_menu_button() {
        menuPage.clickAboutButton();
    }

    @Then("I should be redirected to the Sauce Labs About")
    public void i_should_be_redirected_to_the_the_sauce_labs_about() {
        String expectedUrl = "https://saucelabs.com/";
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrl));
    }
    
    @When("I click the all items link")
    public void i_click_the_all_items_link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(menuPage.ALL_ITEMS_LINK)).click();
    }

    @Then("I should be redirected again to the products page")
    public void i_should_be_redirected_to_the_inventory_page() {
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains(expectedUrl));
    }

    @After
    public void tearDown() {
        Hooks.tearDown();
    }
}
