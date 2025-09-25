package Tasks.Assignments.Assignment03;

import org.testng.annotations.DataProvider;

public class T03_SignInDataProvider {

    @DataProvider(name = "negativeData")
    public Object[][] getNegativeData() {
        return new Object[][]{
                {"", ""},                        // Scenario 1: both empty
                {"User1", ""},                   // Scenario 2: username filled, password empty
                {"", "Pass1"},                   // Scenario 3: username empty, password filled
                {"wrongUser", "Admin.123"},      // Scenario 4: wrong username, correct password
                {"Admin", "wrongPass"},          // Scenario 5: correct username, wrong password
                {"wrongUser", "wrongPass"}       // Scenario 6: both wrong
        };
    }
}