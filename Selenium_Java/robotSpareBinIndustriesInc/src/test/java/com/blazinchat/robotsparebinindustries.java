package com.blazinchat;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class robotsparebinindustries {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Set the path to the ChromeDriver executable
        System.setProperty(
                "webdriver.chrome.driver",
                "webdriver/chromedriver.exe");

        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        // Set an implicit wait for the driver
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // maximize window
        driver.manage().window().maximize();

        // Open the website
        driver.get("https://robotsparebinindustries.com");
    }

    @Test
    public void testLogIn() {
        // Creating a webElement
        WebElement loginButton = driver.findElement(By.id("button_login"));
        // Interacting with web elment
        loginButton.click();

        WebElement userProfilePicture = driver.findElement(By.cssSelector("img[alt='User Profile Picture']"));
        WebElement firstNameInput = driver.findElement(By.cssSelector("input[placeholder='first name']"));
        WebElement lastNameInput = driver.findElement(By.cssSelector("input[placeholder='last name']"));
        WebElement emailInput = driver.findElement(By.cssSelector("input[placeholder='email address']"));
        WebElement aboutMeInput = driver.findElement(By.cssSelector("textarea[placeholder='about me']"));
        WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));

        // verify the profile
        Assert.assertTrue(userProfilePicture.isDisplayed(), "User Profile Picture is not visible.");
        firstNameInput.sendKeys(" Jones");
        lastNameInput.sendKeys(" Smith");
        emailInput.sendKeys(" qaauto@version1.com");
        aboutMeInput.sendKeys(" This Automated !!!");
        Assert.assertFalse(saveButton.isEnabled(), "Button is enabled when it shouldnt be");

        // Use JavaScript to remove the 'disabled' attribute
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled')", saveButton);

        // Perform actions with the enabled button (e.g., click it)
        saveButton.click();

        Assert.assertFalse(saveButton.isEnabled(), "Button is enabled when it shouldnt be");
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
