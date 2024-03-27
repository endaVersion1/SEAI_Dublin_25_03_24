package  com.blazinchat;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApiTest {
    private WebDriver driver;
/// Genertate 3 ramdom charaters 

 public static String generateRandomCharacters(int count) {
        StringBuilder randomChars = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < count; i++) {
            // Generate a random character between 'a' (97) and 'z' (122)
            char randomChar = (char) (random.nextInt(26) + 'a');
            randomChars.append(randomChar);
        }

        return randomChars.toString();
    }

String randomChars = generateRandomCharacters(3);
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
         // Open the website
         driver.get("https://api.restful-api.dev/objects?id=ff8081818b1b4123018b8a073f7d0cdb");

         RestAssured.baseURI = "https://api.restful-api.dev/";
    }

 @Test
    public void testApiGetPosts() {
         // Send a GET request to update the post
    Response response = RestAssured
        .given()
        .contentType(ContentType.JSON)
        .when()
        .get("objects?id=ff8081818b1b4123018b8a073f7d0cdb"); 

        // Retrieve the body of the Response
        Assert.assertEquals(response.getStatusCode(), 200);
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        
        //Back to the browser
        driver.get("https://api.restful-api.dev/objects?id=ff8081818b1b4123018b8a073f7d0cdb");
        WebElement phoneDetails = driver.findElement(By.cssSelector("body"));
        String actualText = phoneDetails.getText();
        System.out.println(actualText);
        // Perform the assertion
        Assert.assertNotEquals("[[{\"id\":\"ff8081818b1b4123018b8a073f7d0cdb\",\"na", actualText);
 }

    @Test
    public void testApiUpdatePosts() {
         // Define the JSON payload
         String requestBody = "{\n" +
         "   \"name\": \"Enda Brody New Phone " + generateRandomCharacters(3) + "\",\n" +
         "   \"data\": {\n" +
         "      \"year\": 2020,\n" +
         "      \"price\": 1500.99,\n" +
         "      \"CPU model\": \"Intel Core i9\",\n" +
         "      \"Hard disk size\": \"Enda Brody\",\n" +
         "      \"color\": \"Black\"\n" +
         "   }\n" +
         "}";

        // Send a PUT request to update the post
    Response response = RestAssured
        .given()
        .contentType(ContentType.JSON)
        .body(requestBody)
        .when()
        .put("objects/ff8081818b1b4123018b8a073f7d0cdb"); 

        Assert.assertEquals(response.getStatusCode(), 200);
        // Retrieve the body of the Response
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);
        
        //Back to the browser
        driver.get("https://api.restful-api.dev/objects?id=ff8081818b1b4123018b8a073f7d0cdb");
        WebElement postDetails = driver.findElement(By.cssSelector("body"));
        String actualText = postDetails.getText();
        // Perform the assertion
        Assert.assertNotEquals("new body Test", actualText);
 }

   //---Code Challenge Check Create Post Request--
    @Test
    public void testApiCreatePost() {
 }



  @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }

}