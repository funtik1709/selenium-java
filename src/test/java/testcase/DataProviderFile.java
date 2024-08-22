package testcase;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class DataProviderFile {
    @DataProvider
    public Object[][] dataSet1(Method m) {
        Object[][] testdata = null;

        if (m.getName().equals("test")) {
            testdata = new Object[][]{
                    {"1060214371", "503018"},
                    {"2400558405", "322335"}
            };
        }
        else if (m.getName().equals("test2")) {
            testdata = new Object[][]{
                    {"1060214371", "503018", 111},
                    {"2400558405", "322335", 222}
            };

        }
        return testdata;

    };

}




