package testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest {

    @Test(dataProvider="dataSet")
    public void test(String username, String password) {
        System.out.println(username+"----"+password);
    }

    @Test(dataProvider="dataSet1")
    public void test1(String username, String password, int code) {
        System.out.println(username+"----"+password+"----"+code);
    }

    @DataProvider
    public Object[][] dataSet1() {
        return new Object[][] {
                {"user5", "password5", 555},
                {"user6", "password6", 666},
                {"user7", "password7", 777}
        };
    }

    @DataProvider
    public Object[][] dataSet() {
        Object[][] dataset = new Object[4][2];

        //first row
        dataset[0][0] = "user1";
        dataset[0][1] = "pass1";

        //second row
        dataset[1][0] = "user2";
        dataset[1][1] = "pass2";

        //third row
        dataset[2][0] = "user3";
        dataset[2][1] = "pass3";

        //fourth row
        dataset[3][0] = "user4";
        dataset[3][1] = "pass4";

        return dataset;
    }
}
