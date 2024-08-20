package testcase;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


public class HomepageTest extends BaseTest {

	@Test(priority = 1, description = "Header Title And Logo Test", groups="header")
	public void headerCheck() throws InterruptedException {
		//verify title = boolean
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Медицинские анализы КДЛ ОЛИМП");
		System.out.println(verifyTitle);
		assertTrue(verifyTitle);

		// JAVASCRIPT EXECUTOR - get title
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "return document.title;";
		String actual_title = (String) jsExecutor.executeScript(script);
		System.out.println("Page title is - " + actual_title);

		String expected_title = "Медицинские анализы КДЛ ОЛИМП";

		// TestNG - assert title
		Assert.assertEquals(expected_title, actual_title, "Assertion result");

		//verify logo
		WebElement main_logo = driver.findElement(By.xpath("//*[local-name()='svg' and @class=\"resize_to_small in_700\"]"));
		int logoHeight = main_logo.getSize().getHeight();
		int logoWidth = main_logo.getSize().getWidth();

		Boolean logoIsDisplayed = main_logo.isDisplayed();
		System.out.println("Logo Is Displayed - " + logoIsDisplayed);


		driver.close();
	}
	@Test(priority = 2, description = "Navigation Test", groups="nav")
	public static void navigationCheck() throws InterruptedException {

		// NAVIGATION BLOCK IS DISPLAYED
		WebElement nav=driver.findElement(By.xpath("//nav[@class=\"main__header__wrapper__blocks__nav\"]"));
		boolean flag=nav.isDisplayed();
		System.out.println("Nav element is displayed: " + flag);

		// NAVIGATION LINKS TEXT CHECK
		String promotions = driver.findElement(By.xpath("//a[@href=\"/promotions\"]")).getText();
		String analysis = driver.findElement(By.xpath("//a[@href=\"/analyzes\"]")).getText();
		String cabinets = driver.findElement(By.xpath("//a[@href=\"/cabinets\"]")).getText();
		String house_call = driver.findElement(By.xpath("//a[@href=\"/house-call\"]")).getText();
		String about = driver.findElement(By.xpath("//a[@href=\"/about\"]")).getText();
		String franchise = driver.findElement(By.xpath("//a[@href=\"/franchise\"]")).getText();

		SoftAssert softassert = new SoftAssert();

		String[] nav_links = {"Акции", "Анализы", "Где сдать", "Выезд на дом", "О нас", "Франшиза"};

		Assert.assertEquals(promotions, nav_links[0], "Nav link assertion result");
		Assert.assertEquals(analysis, nav_links[1], "Nav link assertion result");
		softassert.assertEquals(cabinets, nav_links[2], "Nav link assertion result");
		Assert.assertEquals(house_call, nav_links[3], "Nav link assertion result");
		Assert.assertEquals(about, nav_links[4], "Nav link assertion result");
		Assert.assertEquals(franchise, nav_links[5], "Nav link assertion result");

		throw new SkipException("Skip navigation check test");
		//driver.close();
	}

	@Test(priority = 3, description = "Navigation to promotions page test", groups="nav")
	public static void navToPromotions() throws InterruptedException {
		WebElement promotions = driver.findElement(By.xpath("//a[@href=\"/promotions\"]"));
		promotions.click();

		WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
		String promotionsTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"title\"]"))).getText();

		System.out.println("Page title is " + promotionsTitle);

		Assert.assertEquals(promotionsTitle, "Акции", "Page title assertion result");
		driver.close();
	}

	@Test(priority = 4, description = "Navigation to analysis page test", groups="nav")
	public static void navToAnalysis() throws InterruptedException {
		WebElement analysis = driver.findElement(By.xpath("//a[@href=\"/analyzes\"]"));
		analysis.click();

		WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));

		String analysisTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class=\"title\"]"))).getText();
		System.out.println("Page title is " + analysisTitle);

		Assert.assertEquals(analysisTitle, "Анализы", "Page title assertion result");

		driver.close();
	}

}
