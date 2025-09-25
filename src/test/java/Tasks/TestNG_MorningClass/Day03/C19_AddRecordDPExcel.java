package Tasks.TestNG_MorningClass.Day03;

import Tasks.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class C19_AddRecordDPExcel extends TestBase {

    @Test(dataProvider = "getEmployeeDataFromExcel", dataProviderClass = Tasks.utilities.DataProviderUtilities.class)
    void addRecordDPExcelTest(String name, double age, String country) {

        driver.get("https://claruswaysda.github.io/addRecordWebTable.html");
        driver.findElement(By.id("nameInput")).sendKeys(name);
        driver.findElement(By.id("ageInput")).sendKeys((int)age + "");
        new Select(driver.findElement(By.id("countrySelect"))).selectByVisibleText(country);
        driver.findElement(By.xpath("//*[.='Add Record']")).click();

    }
}
