package Tasks.Assignments.Assignment01;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T05_SoftAssertLoginTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void negativeLoginTest() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        // 1. Navigate to https://claruswaysda.github.io/signIn.html
        driver.get("https://claruswaysda.github.io/signIn.html");

        // 2. Enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("wronguser");
        Thread.sleep(500);

        // 3. Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("wrongpass");
        Thread.sleep(500);

        // 4. Click Submit button
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/form/input[2]"));
        submit.click();
        Thread.sleep(500);

        // 5. Use soft assertion to verify :

        // - javaScript alert is displayed
        Alert alert = driver.switchTo().alert();
        Thread.sleep(500);
        softAssert.assertNotNull(alert, "Alert was NOT displayed");

        // - Alert message text is "Incorrect username or password"
        String actualAlertText = alert.getText();
        String expectedAlertText = "Incorrect username or password";
        Thread.sleep(500);
        softAssert.assertEquals(actualAlertText, expectedAlertText, "Alert text is NOT as expected");


        alert.accept();
        softAssert.assertAll();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }

}
