package common;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonDataSetup {

    @BeforeSuite
    public void dataSetup() {
        System.out.println("Data setup");
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("Common data cleanup");
    }


}
