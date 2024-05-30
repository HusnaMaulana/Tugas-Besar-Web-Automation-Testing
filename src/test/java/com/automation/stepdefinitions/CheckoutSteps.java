package com.automation.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.automation.hooks.Hooks;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private WebDriver driver;
    private CheckoutPage checkPage;
    private CartPage cartPage;
    private LoginPage loginPage;
    @Before
    public void setUp() {
        new Hooks();
        driver = Hooks.setUp();
        checkPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
        loginPage = new LoginPage(driver);
    }

    @Given("The user is logged in")
    public void userIsLoggedIn() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @And("Already adding two item {string} and {string} to cart")
    public void alreadyAddingTwoItemToCart(String prodOne, String prodTwo) {
        checkPage.addProduct(prodOne);
        checkPage.addProduct(prodTwo);
    }

    @And("Already on cart page")
    public void verifyCartPage() {
        cartPage.cart();
        assertTrue(cartPage.verifyCartPage());
    }

    @When("User Remove one item")
    public void userRemoveOneItem() {
        checkPage.removeOne();
    }

    @And("Click checkout button")
    public void clickBtnCheckout(){
        checkPage.clickCheckout();
    }

    @And("Redirect to checkout page")
    public void verifyCheckoutPage() {
        assertTrue(checkPage.verifyCheckoutPage());
    }

    @And("User input {string} as firstName {string} as lastName and {int} as zipPostalCode")
    public void userInputData(String firstName, String lastName, int zipPostalCode) {
        checkPage.setFirstName(firstName);
        checkPage.setLastName(lastName);
        checkPage.setPostalCode(zipPostalCode);
    }

    @And("Click continue button")
    public void clickContinueButton() {
        checkPage.clickContinue();
    }

    @And("Display checkout information total price {string} is match")
    public void displayCheckoutInformation(String price) {
        String totalPrice = checkPage.getTotalPrice().replace("Total: ", "");
        assertTrue(checkPage.verifyCheckoutSum());
        assertEquals(price, totalPrice);
    }

    @And("Click finish button")
    public void clickFinishButton() {
        checkPage.clickFinishBtn();
    }

    @Then("Click back home button")
    public void clickBackHomeButton() {
        checkPage.clickBackBtn();
    }

    /* Negative Test Case */
    @Then("Checkout button should not appear")
    public void checkoutButtonShouldNotAppear() {
        assertFalse(checkPage.verifyCheckoutBtn());
    }

    @And("Click cancel button")
    public void clickCancelButton() {
        checkPage.clickCancelBtn();
    }

    @Then("Should be on Cart Page")
    public void shouldBeOnCartPage() {
        assertTrue(cartPage.verifyCartPage());
    }

    @Then("I should see an error message first name required")
    public void i_should_see_an_error_message_first_name_required() {
        assertTrue(checkPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Error: First Name is required";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Then("I should see an error message last name required")
    public void i_should_see_an_error_message_last_name_required() {
        assertTrue(checkPage.isErrorMessageDisplayed());
        String expectedErrorMessage = "Error: Last Name is required";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @After
    public void tearDown() {
        Hooks.tearDown();
    }
}
