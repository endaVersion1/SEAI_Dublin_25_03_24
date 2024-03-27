using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using NUnit.Framework;

namespace blazingChat
{
    [TestFixture]
    public class BlazingChatTests
    {
        private IWebDriver driver;
    [SetUp]
    public void Setup()
    {
    // Set the path to the Chrome WebDriver executable
    string chromeDriverPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "webdriver");

    // Configure the Chrome options
    ChromeOptions options = new ChromeOptions();
    options.AddArgument("--start-maximized"); // Maximize the browser window

    // Initialize the class-level driver field with the ChromeDriver instance
    driver = new ChromeDriver(chromeDriverPath, options);

    // Navigate to the specified URL
    string url = "https://localhost:44323/";
    driver.Navigate().GoToUrl(url);
    Thread.Sleep(TimeSpan.FromSeconds(20));
    }

    [Test]
    public void VerifyProfileHeader()
    {
         // Login
            IWebElement loginButton = driver.FindElement(By.XPath("//button[@id='button_login']"));
            loginButton.Click();
            Thread.Sleep(TimeSpan.FromSeconds(20));
            IWebElement h2Element = driver.FindElement(By.TagName("h2"));
            string actualText = h2Element.Text;
            Assert.AreEqual("Profile", actualText);

            //Select Contacts
            IWebElement contacts = driver.FindElement(By.XPath("//a[normalize-space()='Contacts']"));
            contacts.Click();
    }

//---Code Challenge Check Create account validation--
     public void VerifyUserNotAuth()
    {
         // Login
            IWebElement loginButton = driver.FindElement(By.Id("button_login"));
            loginButton.Click();
            IWebElement h2Element = driver.FindElement(By.TagName("h2"));
            string actualText = h2Element.Text;
            Assert.AreEqual("Profile", actualText);

            //Select Contacts
            IWebElement contacts = driver.FindElement(By.XPath("//a[normalize-space()='Contacts']"));
            contacts.Click();
            //Select User and verify Not Authorized
    }

    [TearDown]
    public void Cleanup()
    {
        // Close the browser when the test is done
        driver.Quit();
    }
        
    }
}