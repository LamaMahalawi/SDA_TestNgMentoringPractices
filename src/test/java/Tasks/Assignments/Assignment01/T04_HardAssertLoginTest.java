package Tasks.Assignments.Assignment01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T04_HardAssertLoginTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void positiveLoginTest() {
        // 1. Navigate to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

        // 2. Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("admin");
        System.out.println("Username entered successfully");


        // 3. Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123");
        System.out.println("Password entered successfully");

        // 4. Click Submit button
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/input[2]"));
        submit.click();
        System.out.println("Submit button clicked");

        // 5. Use Hard Assertions to verify

        // - New page URL is https://claruswaysda.github.io/signIn.html
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://claruswaysda.github.io/signIn.html";
        Assert.assertEquals(actualUrl, expectedUrl, " URL is NOT as expected");
        System.out.println("URL verified successfully");


        // - page contains text "Employee Table"
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("Employee Table"), "Page does NOT contain 'Employee Table'");
        System.out.println("Page contains 'Employee Table'" );
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
