package Tasks.Assignments.Assignment02;

import Tasks.utilities.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T02_GroupBasedTestExecution extends TestBase {


    // Smoke test
    @Test(groups = "smoke")
    public void loginTest() {
        System.out.println("Running loginTest (smoke)");
        Assert.assertTrue(true, "Login works correctly");
    }

    // Regression test
    @Test(groups = "regression")
    public void fullCheckoutTest() {
        System.out.println("Running fullCheckoutTest (regression)");
        Assert.assertTrue(true, "Full checkout works correctly");
    }

    // API test
    @Test(groups = "api")
    public void apiResponseTest() {
        System.out.println("Running apiResponseTest (api)");
        Assert.assertTrue(true, "API response is correct");
    }
}