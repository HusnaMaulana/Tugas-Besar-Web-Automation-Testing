package com.automation.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import com.automation.hooks.Hooks;
import com.automation.pages.CartPage;
import com.automation.pages.LoginPage;
import com.automation.pages.ProductsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    
    private WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    CartPage cartPage = new CartPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    public CartSteps(){
        this.driver = Hooks.setUp(); // Initialize the WebDriver
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Given("Already login on website sauce demo")
    public void verifyLogin(){
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @When("Click add to cart button")
    public void cartButton(){
        cartPage.addProduct();
    }

    @And("Click cart icon")
    public void cartIcon(){
        cartPage.cart();
    }

    @Then("The added product should be displayed")
    public void verifyProductItem(){
        Assert.assertTrue(cartPage.verifyProductList());
    }

    @And("Click remove on product item")
    public void clickRemoveOnProductItem() {
        cartPage.removeProduct();
    }

    @Then("Product item should be removed")
    public void productItemShouldBeRemoved() {
        Assert.assertFalse(cartPage.verifyRemoveProd());
    }

    @When("Click on the cart icon")
    public void clickCartIconButton() {
        productsPage.clickCartIcon();
    }

    @When("Click continue shopping button")
    public void clickContinueShoppingButton() {
        cartPage.continueShopBtn();
    }
}
