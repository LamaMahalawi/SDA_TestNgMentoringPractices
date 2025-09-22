package Tasks.TestNG_MorningClass.Day01;

import Tasks.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class C05_SwagLabsTimeOut extends TestBase {
      /*
    Go to https://www.saucedemo.com/v1/index.html
    Enter username and password
    Hit enter
    Assert 'Products'
    User must log in in 10 seconds
     */

    @Test(timeOut = 10000)
//ThreadTimeoutException
    void loginTest() {
        driver.get("https://www.saucedemo.com/v1/index.html");
        driver.findElement(By.id("user-name")).sendKeys("performance_glitch_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce", Keys.ENTER);
        assert driver.findElement(By.xpath("//*[.='Products']")).isDisplayed();
    }


}
