package Tasks.TestNg_Mentoring.Day03;

import Tasks.utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T01_ActionsFormTest extends TestBase {

    @Parameters({"name","age","department","interest","gender"})
    @Test
    public void fillFormTest(String name, String age, String department, String interest, String gender) throws InterruptedException {
        driver.get("https://claruswaysda.github.io/ActionsForm.html");

        // Name & Age
        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("age")).sendKeys(age);

        // Department (select)
        new Select(driver.findElement(By.id("options"))).selectByValue(department);

        // Interest (checkbox)
        driver.findElement(By.xpath("//input[@value='" + interest + "']")).click();

        // Gender
        driver.findElement(By.xpath("//input[@value='" + gender + "']")).click();

        // Submit
        driver.findElement(By.xpath("//button[@type='button']")).click();
        Thread.sleep(1000);

        // Handle alert
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains("Your passcode is:"));
        alert.accept();
        Thread.sleep(1000);
    }
}