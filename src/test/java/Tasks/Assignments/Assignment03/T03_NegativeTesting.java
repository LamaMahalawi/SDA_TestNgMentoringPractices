package Tasks.Assignments.Assignment03;

import Tasks.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T03_NegativeTesting extends TestBase{

    @Test(dataProvider = "negativeData", dataProviderClass =Tasks.Assignments.Assignment03.T03_SignInDataProvider.class)
    public void negativeLoginTest(String username, String password) throws InterruptedException {

        driver.get("https://claruswaysda.github.io/signIn.html");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginBtn.click();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        if (username.isEmpty()) {
            String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", usernameField);
            Assert.assertEquals(validationMessage, "Please fill out this field.");
            System.out.println("username empty → " + validationMessage);
            Thread.sleep(200);

        } if (password.isEmpty()) {
            String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", passwordField);
            Assert.assertEquals(validationMessage, "Please fill out this field.");
            System.out.println("password empty → " + validationMessage);
            Thread.sleep(200);

        } if (!username.isEmpty() && !password.isEmpty()) {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            Assert.assertTrue(alertText.contains("Incorrect username or password"));
            Thread.sleep(500);
            System.out.println("Alert Message → " + alertText);
            alert.accept();
            }

        }
    }
