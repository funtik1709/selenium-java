package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckResults extends BaseTest {
    @Test(dataProvider="dataSet", dataProviderClass= DataProviderFile.class)
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
    @Test(dataProvider="dataSet1", dataProviderClass= DataProviderFile.class)
    public void test2(String username, String password, int code){
        System.out.println(username+"----"+password+"----"+code);
    }
}
