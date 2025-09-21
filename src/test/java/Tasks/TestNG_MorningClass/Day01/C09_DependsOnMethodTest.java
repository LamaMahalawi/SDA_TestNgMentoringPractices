package Tasks.TestNG_MorningClass.Day01;

import Tasks.utilities.TestBase;
import org.testng.annotations.Test;

public class C09_DependsOnMethodTest extends TestBase {
      /*
        Create tests that depend on each other
        First go to Facebook
        Then go to Google depending on Facebook
        Then go to Amazon depending on Google
     */

    @Test
    void facebookTest() {
        driver.get("https://facebook.com");
    }

    @Test(dependsOnMethods = "facebookTest")
    void googleTest() {
        driver.get("https://google.com");
    }

    @Test(dependsOnMethods = {"googleTest","facebookTest"})
    void amazonTest() {
        driver.get("https://amazon.com");
    }

}
