package Tasks.TestNg_Mentoring.Day01;

import org.testng.annotations.*;

public class T01_AnnotationHierarchyTest {
    @BeforeSuite
    void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @BeforeTest
    void beforeTest() {
        System.out.println("BeforeTest");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("BeforeClass");
    }

    @BeforeMethod
    void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @Test
    void test01() {
        System.out.println("test01");
    }

    @Test
    void test02() {
        System.out.println("test02");
    }

    @AfterMethod
    void afterMethod() {
        System.out.println("AfterMethod");
    }

    @AfterClass
    void afterClass() {
        System.out.println("AfterClass");
    }

    @AfterTest
    void afterTest() {
        System.out.println("AfterTest");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("AfterSuite");
    }
}
