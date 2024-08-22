package testcase;

import org.testng.annotations.DataProvider;

public class DataProviderFile {
    @DataProvider
    public Object[][] dataSet1() {
        return new Object[][] {
                {"user5", "password5", 555},
                {"user6", "password6", 666},
                {"user7", "password7", 777}
        };
    }

    @DataProvider
    public Object[][] dataSet()
    {
        Object[][] dataset = new Object[2][2];

        //first row
        dataset[0][0] = "1060214371";
        dataset[0][1] = "503018";

        //second row
        dataset[1][0] = "2400558405";
        dataset[1][1] = "322335";

        return dataset;
    }
}
