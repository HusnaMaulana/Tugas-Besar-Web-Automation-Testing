package com.automation.hooks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Hooks {

    public static WebDriver driver;

    public static WebDriver setUp() {
        if (driver == null) {
            String currentDirectory = System.getProperty("user.dir");
            String msedgedriverPath = currentDirectory + "\\msedgedriver.exe";
            System.setProperty("webdriver.edge.driver", msedgedriverPath);
            driver = new EdgeDriver();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

}