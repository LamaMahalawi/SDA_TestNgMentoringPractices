package Tasks.Assignments.Assignment01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class T03_DependencyTest {
    WebDriver driver;

    @BeforeClass
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void openYahoo() {
        driver.get("https://www.yahoo.com/");
        Assert.fail("Intentional Failure in Yahoo Test");
    }

    @Test(dependsOnMethods = "openYahoo")
    void openBing() {
        driver.get("https://www.bing.com/");
    }

    @Test(dependsOnMethods = "openBing")
    void openDuckDuckGo() {
        driver.get("https://duckduckgo.com/");
    }

    @AfterClass
    void setDown() {
        driver.close();
    }
}
