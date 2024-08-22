package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemoTest1 extends BaseTest {

    @Test(dataProvider="dataSet")
    public void test(String username, String password)
    {
        driver.get("https://new.kdlolymp.kz/results/login");

        WebElement login = driver.findElement(By.xpath("//input[@id=\"login_input\"]"));
        WebElement pass = driver.findElement(By.xpath("//input[@id=\"password_input\"]"));
        WebElement checkbox = driver.findElement(By.xpath("//span[@class=\"checkbox__indicator\"]"));

        login.sendKeys(username);
        pass.sendKeys(password);
        checkbox.click();

        WebElement submit = driver.findElement(By.xpath("//button[@class=\"dd_button send\"]"));
        submit.click();

        System.out.println(username+"----"+password);

        driver.close();
    }

    @DataProvider
    public Object[][] dataSet() {
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
