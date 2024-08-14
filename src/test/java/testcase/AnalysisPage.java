package testcase;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AnalysisPage extends BaseTest {
    @Test
    public static void analysisCheckbox() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href=\"/analyzes\"]")).click();
        Thread.sleep(3000);


        WebElement filterDropdown = driver.findElement(By.xpath("//div[@class=\"drop-down\"]"));
        filterDropdown.click();

        WebElement gematology = driver.findElement(By.xpath("//span[text()='Гематология']"));
        gematology.click();
        // handle radio button
//		WebElement radio = driver.findElement(By.id("radio"));
//		Actions actions = new Actions(driver);
//		actions.moveToElement(radio);
//		actions.perform();
    }
}
