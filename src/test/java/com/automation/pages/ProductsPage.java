package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    private WebDriver driver;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(xpath = "//div[contains(@class, 'inventory_item_name')]")
    private WebElement productName;
    
    @FindBy(css = "[data-test='item-4-img-link']")
    private WebElement productImage;

    @FindBy(className = "inventory_details_price")
    private WebElement productPrice;

    @FindBy(className = "inventory_details_desc")
    private WebElement productDescription;

    @FindBy(xpath = "//div[@class='inventory_container']")
    private WebElement productList;
    
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;


    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterButton;

    @FindBy(className = "product_sort_container")
    private WebElement filterButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public void clickMenuButton() {
        menuButton.click();
    }

    public void clickProductName() {
        productName.click();
    }

    public void clickProductImage() {
        productImage.click();
    }

    public void clickCartIcon() {
        shoppingCartLink.click();
    }

    // Tambahkan metode untuk mencari dan mengklik produk berdasarkan teks
    public void clickProductByName(String productName) {
        try {
            WebElement productElement = productList.findElement(By.xpath(".//div[contains(@class, 'inventory_item_name') and normalize-space(text())='" + productName + "']"));
            productElement.click();
        } catch (NoSuchElementException e) {
            System.out.println("Product not found: " + productName);
        }
    }

    public void clickTwitterButton() {
        twitterButton.click();
    }

    public void clickFilterButton() {
        filterButton.click();
    }

    public void clickFilterOption(String optionText) {
        WebElement option = driver.findElement(By.xpath("//option[text()='" + optionText + "']"));
        option.click();
    }

    public boolean isSortedByName() {
        // Implement logic to check if products are sorted by name Z-A
        return true;
    }

    public boolean isSortedByPrice() {
        // Implement logic to check if products are sorted by price low to high
        return true;
    }

    // Metode untuk mengklik tautan keranjang belanja
    public void clickShoppingCartLink() {
        shoppingCartLink.click();
    }
}
