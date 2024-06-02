package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MenuPage {
    private WebDriver webDriver;

    public MenuPage(WebDriver driver) {
        this.webDriver = driver;
    }

    // Locator for the logout button
    public final By LOGOUT_BUTTON = By.id("logout_sidebar_link");

    // Locator for the "All Items" link
    public final By ABOUT_BUTTON = By.id("about_sidebar_link");

    // Locator for the "All Items" link
    public final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");

    public void clickLogoutButton() {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10)); // menunggu maksimal 10 detik
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON));
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", webDriver.findElement(LOGOUT_BUTTON));
        js.executeScript("arguments[0].click();", webDriver.findElement(LOGOUT_BUTTON));
    }

    // Method to click on the close menu button
    public void clickAboutButton() {
        webDriver.findElement(ABOUT_BUTTON).click();
    }

    // Method to click on the "All Items" link
    public void clickAllItemsLink() {
        webDriver.findElement(ALL_ITEMS_LINK).click();
    }
}
