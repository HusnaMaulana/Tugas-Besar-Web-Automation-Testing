package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
    private WebDriver webDriver;

    public CheckoutPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(driver, this);
    }

    // Home Page: Select Product
    public void addProduct(String prodName) {
        webDriver.findElement(By.xpath("//button[contains(@id,'" + prodName + "')]")).click();
    }

    // Cart Page: Remove one product
    @FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")
    private WebElement removeProdOne;

    public void removeOne() {
        removeProdOne.click();
    }

    // Cart Page: Checkout button
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;

    public void clickCheckout() {
        checkoutBtn.click();
    }

    public boolean verifyCheckoutBtn() {
        return checkoutBtn.isDisplayed();
    }

    // Checkout Page: Form Fields
    @FindBy(xpath = "//div[@id='checkout_info_container']")
    private WebElement checkoutPage;

    public boolean verifyCheckoutPage() {
        return checkoutPage.isDisplayed();
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;

    public void setPostalCode(int postalCode) {
        this.postalCode.sendKeys(String.valueOf(postalCode));
    }

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;

    public void clickContinue() {
        continueBtn.click();
    }

    @FindBy(xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    public void clickCancelBtn() {
        cancelBtn.click();
    }

    // Error message for missing last name
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement errorMsg;

    public boolean isErrorMessageDisplayed() {
        return errorMsg.isDisplayed();
    }

    public String getErrorMessageText() {
        return errorMsg.getText();
    }

    // Checkout Summary Page
    @FindBy(xpath = "//div[@id='checkout_summary_container']")
    private WebElement checkoutSum;

    public boolean verifyCheckoutSum() {
        return checkoutSum.isDisplayed();
    }

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalPrice;

    public String getTotalPrice() {
        return totalPrice.getText();
    }

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    public void clickFinishBtn() {
        finishBtn.click();
    }

    // Checkout Complete Page
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement backHomeBtn;

    public void clickBackBtn() {
        backHomeBtn.click();
    }
}
