package Tasks.Assignments.Assignment02;

import Tasks.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class T01_AmazonSearchTest extends TestBase {


    @Test
    @Parameters("keyword")
    public void searchTest(String keyword) {

        // 1. Navigate to: https://www.amazon.com
        driver.get("https://www.amazon.com");

        // Click 'Continue shopping' button
        WebElement firstButton = driver.findElement(By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button"));
        firstButton.click();

        // 2. Search for different keywords: Java, Selenium
        WebElement searchBox = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        WebElement submit = driver.findElement(By.xpath("//*[@id=\"nav-search-submit-button\"]"));
        searchBox.sendKeys(keyword);
        submit.click();
        System.out.println("Searched for: " + keyword);


        // 3. Assert that result text contains the searched word
        WebElement resultText = driver.findElement(By.xpath("//span[contains(@class,'a-color-state')]"));
        Assert.assertTrue(resultText.getText().toLowerCase().contains(keyword.toLowerCase()), "Result does not contain: " + keyword);
        System.out.println("Results contain the keyword : " + keyword);
    }

    }