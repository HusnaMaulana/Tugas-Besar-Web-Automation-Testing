package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailProductPage {

    // Mendapatkan Id dan Class dari element web sauce demo
    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(css = ".btn_secondary.back.btn_large.inventory_details_back_button")
    private WebElement backButton;

    @FindBy(css = ".btn_primary.btn_small.btn_inventory")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[contains(@class, 'inventory_details_name large_size')]")
    private WebElement productName;

    @FindBy(className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(className = "inventory_details_desc")
    private WebElement productDescription;

    @FindBy(className = "inventory_item_img")
    private WebElement productImage;

    public DetailProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickBackButton() {
        backButton.click();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public WebElement getItemName() {
        return productName;
    }

    public WebElement getItemPrice() {
        return productPrice;
    }

    public WebElement getItemDescription() {
        return productDescription;
    }

    public WebElement getItemImage() {
        return productImage;
    }
}