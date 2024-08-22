package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class CheckResults extends BaseTest {
    @Test(dataProvider="dataSet1", dataProviderClass= DataProviderFile.class, groups = "testResult")
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
        WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(5));

        try{
            WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"title\"]")));
            String titleValue = title.getText();
            Boolean titleDisplayed = title.isDisplayed();
            Assert.assertTrue(titleDisplayed);
            Assert.assertEquals(titleValue, "Результаты анализа", "Results page title assertion result");
            System.out.println(username+"----"+password);
        } catch(Exception e){
            WebElement not_ready = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));
            Boolean h3Displayed = not_ready.isDisplayed();
            Assert.assertTrue(h3Displayed);
            System.out.println(username+"----"+password);
        }

//        driver.close();
    }

    @Test(dataProvider="dataSet1", dataProviderClass= DataProviderFile.class, groups = "testResult")
    public void test2(String username, String password, int code){
        System.out.println("Login is: "+username+" Password is: "+password+" Code is: "+code);
//        driver.close();
    }
}
