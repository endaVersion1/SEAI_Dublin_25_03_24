package com.blazinchat;

import com.applitools.eyes.selenium.Eyes;
import com.applitools.eyes.RectangleSize;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VisualRegression {
    private WebDriver driver;
    private Eyes eyes;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();

        // Initialize the Eyes SDK
        eyes = new Eyes();
        eyes.setApiKey("6y34eXWURq0dop48OAf22DRoSGArUDeRJfJ0jM6EQ2Y110");
    }

    @Test
    public void testVisualRegressionLoginPage() {
        // Open the website
        driver.get("https://robotsparebinindustries.com/");

        // Start the visual regression test
        eyes.open(driver, "Blazing Chat", "Login Page", new RectangleSize(800, 600));

        // Perform visual checks on the page
        eyes.checkWindow("Login Page");

        // Close the visual regression test
        eyes.closeAsync();
    }

    @Test
    public void testVisualRegressionCreateAccountPage(){
        // Open the website
        driver.get("https://robotsparebinindustries.com/");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();

        // Abort the Eyes test if it's still running
        eyes.abortIfNotClosed();
    }
    
}
