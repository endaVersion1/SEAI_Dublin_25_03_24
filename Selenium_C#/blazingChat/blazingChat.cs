using System;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace blazingchat
{
    class Program
    {
        static void Main(string[] args)
        {
            // Set the path to the Chrome WebDriver executable
            string chromeDriverPath = @"webdriver/chromedriver.exe"; // Replace with the actual path

            // Configure the Chrome options
            ChromeOptions options = new ChromeOptions();
            options.AddArgument("--start-maximized"); // Maximize the browser window

            // Initialize the Chrome WebDriver with the specified options
            IWebDriver driver = new ChromeDriver(chromeDriverPath, options);

            // Navigate to the specified URL
            string url = "https://www.blazingchat.com/";
            driver.Navigate().GoToUrl(url);

            // Wait for a few seconds to see the result (you can replace this with explicit waits)
            System.Threading.Thread.Sleep(5000);

            // Login
            IWebElement loginButton = driver.FindElement(By.Id("button_login"));
            loginButton.Click();
            IWebElement h2Element = driver.FindElement(By.TagName("h2"));
            string actualText = h2Element.Text;
            Assert.AreEqual("Profile", actualText);

            //Select Contacts
            IWebElement contacts = driver.FindElement(By.XPath("//a[normalize-space()='Contacts']"));
            contacts.Click();

//---Code Challenge Check Create account validation--
            //Select User and verify Not Authorized

            // Close the browser window
            driver.Quit();
        }
    }
}
