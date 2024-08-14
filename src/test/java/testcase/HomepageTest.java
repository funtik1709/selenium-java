package testcase;

import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

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

	@Test
	public static void headerCheck() throws InterruptedException {
		// verify title
		Boolean verifyTitle = driver.getTitle().equalsIgnoreCase("Медицинские анализы КДЛ ОЛИМП");
		System.out.println(verifyTitle);
		assertTrue(verifyTitle);

		// JAVASCRIPT EXECUTOR

		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		String script = "return document.title;";
		String title = (String) jsExecutor.executeScript(script);
		System.out.println("Page itile is - " +title);

		// click results button
		// jsExecutor.executeScript("myFunction()");

		//highlight element
		WebElement results_button = driver.findElement(By.xpath("//a[@class=\"results\"]"));
		jsExecutor.executeScript("\"arguments[0].style.color='red'\"", results_button);

		// scroll
		WebElement articles = driver.findElement(By.xpath("//div[@class=\"articles\"]"));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true)", articles);

		// /JAVASCRIPT EXECUTOR

		//verify image
		WebElement main_logo = driver.findElement(By.xpath("//*[local-name()='svg' and @class=\"resize_to_small in_700\"]"));
		int logoHeight = main_logo.getSize().getHeight();
		int logoWidth = main_logo.getSize().getWidth();

		assertEquals(logoHeight, 62);
		assertEquals(logoWidth, 140);
		Thread.sleep(2000);
		//driver.close();
	}
	@Test
	public static void navigationCheck() throws InterruptedException {
		WebElement nav=driver.findElement(By.xpath("//nav[@class=\"main__header__wrapper__blocks__nav\"]"));

		boolean flag=nav.isDisplayed();

		System.out.println("Nav element is displayed: " +flag);

		driver.close();
	}
	@Test
	public static void headerInfoBlock() throws InterruptedException {
		WebElement info_block = driver.findElement(By.xpath("//div[@class=\"main__header__wrapper__blocks__info\"]"));

		boolean flag=info_block.isDisplayed();

		System.out.println("Info block is displayed: " +flag);

		List<WebElement> links =  driver.findElements(By.tagName("a"));
		System.out.println("Total links are: " + links.size());

        for (WebElement link : links) {
            System.out.println("Link " + link.getText() + " with href: " + link.getAttribute("href"));
        }
	}
	@Test
	public static void searchAnalysis() throws InterruptedException {
		// //input[@id="analyzes"]
		WebElement search_field = driver.findElement(By.xpath("//input[@placeholder=\"Поиск услуг и анализов\"]"));
		Thread.sleep(2000);
		search_field.sendKeys("гормональный фон");
		driver.findElement(By.xpath("//button[@class=\"find\"]")).click();
	}

	@Test
	public static <Set> void multipleWindows() throws InterruptedException {
		// check redirect to developers site which opens in new tab
		WebElement dd_logo = driver.findElement(By.xpath("//a[@class=\"developed\"]"));

		// find and click developers logo
		Actions actions = new Actions(driver);
		actions.moveToElement(dd_logo);
		actions.click().perform();

		// set window handles
		java.util.Set<String> windowhandles = driver.getWindowHandles();
		System.out.println(windowhandles);

		Iterator<String> iterator = windowhandles.iterator();

		String parentWindow = iterator.next();
		String childWindow = iterator.next();
		driver.switchTo().window(childWindow);

		// get site title and check
		WebElement dd_title = driver.findElement(By.xpath("//div[@class=\"site-header__company\"]"));
		Boolean isTitle = dd_title.isDisplayed();
		System.out.println("Developers Site is opened - " + isTitle);
	}

@Test
public static void downloadQR() throws InterruptedException {
		WebElement download_button = driver.findElement(By.xpath("//div[@class=\"download\"]"));

		Actions action = new Actions(driver);
		action.moveToElement(download_button).perform();

		WebElement download_modal = driver.findElement(By.xpath("//div[@class=\"download__modal active\"]"));
		Boolean isModal = download_modal.isDisplayed();
		System.out.println("Download Modal is visible - " + isModal);
}

@Test
public static void reloadPage() throws InterruptedException {
		WebElement isoImg = driver.findElement(By.xpath("//*[@id=\"__nuxt\"]/div/div/main/div[1]/img"));
		Actions action = new Actions(driver);
		action.contextClick(isoImg).perform();
}

@Test
public static void keyboardEvents() throws InterruptedException {
	WebElement source_text = driver.findElement(By.xpath("//h1[@class=\"title\"]"));

	Actions action = new Actions(driver);
	Thread.sleep(2000);
	action.keyDown(source_text, Keys.CONTROL).sendKeys("a").sendKeys("c").build().perform();

	WebElement target_text = driver.findElement(By.xpath("//input[@placeholder=\"Поиск услуг и анализов\"]"));
	Thread.sleep(2000);
	action.keyDown(target_text, Keys.CONTROL).sendKeys("a").sendKeys("v").build().perform();

}

// Implicit and Explicit wait to check Google Play

@Test
public static void testWait() throws InterruptedException {
	WebElement d_button = driver.findElement(By.xpath("//div[@class=\"download\"]"));
	Actions action = new Actions(driver);
	action.moveToElement(d_button).perform();



// IMPLICIT WAIT
//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//IMPLICIT WAIT
//	WebElement g_play = driver.findElement(By.xpath("//div[@class=\"link\"]//child::img[@src=\"/icons/GooglePlay.svg\"]"));
//	g_play.click();

	// EXPLICIT WAIT
//	WebDriverWait wait = new  WebDriverWait(driver, Duration.ofSeconds(10));
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"link\"]//child::img[@src=\"/icons/GooglePlay.svg\"]"))).click();



// FLUENT WAIT

Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(10))
			.pollingEvery(Duration.ofSeconds(2))
			.ignoring(NoSuchElementException.class);

WebElement g_play = driver.findElement(By.xpath("//div[@class=\"link\"]//child::img[@src=\"/icons/GooglePlay.svg\"]"));
g_play.click();


// MULTIPLE WINDOWS

java.util.Set<String> windowhandles = driver.getWindowHandles();
System.out.println(windowhandles);

Iterator<String> iterator = windowhandles.iterator();

String parentWindow = iterator.next();
String childWindow = iterator.next();
driver.switchTo().window(childWindow);

String gplay_title = driver.findElement(By.xpath("//h1[@itemprop=\"name\"]")).getText();

assertEquals(gplay_title, "КДЛ ОЛИМП анализы");
}
@Test
public static void webTable() throws InterruptedException {
	driver.get("https://new.kdlolymp.kz/cabinets/protsedurnyy-kabinet-seyfullina1");

	// Step 1 - find table
	// Step 2 - get the number of rows
	// Step 3 - get the number of columns
	// Step 4 - iterate rows and columns to get data

	WebElement table = driver.findElement(By.xpath("//table[@class=\"services-desktop\"]"));
	Actions action = new Actions(driver);
	action.moveToElement(table).perform();

	//table[@class="services-desktop"]/tr
	//table[@class="services-desktop"]/tr[1]/th

	// find rows
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class=\"services-desktop\"]/tr"));
	int rowsize = rows.size();
	System.out.println(rowsize);

	// find columns
	List<WebElement> columns = driver.findElements(By.xpath("//table[@class=\"services-desktop\"]/tr[1]/th"));
	int columnsize = columns.size();
	System.out.println(columnsize);

	for (int i = 1; i <= rowsize; i++) {
		for (int j = 1; j <= columnsize; j++) {
			System.out.println(driver.findElement(By.xpath("//table[@class=\"services-desktop\"]/tr["+ i +"]/th["+ j +"]")).getText());
		}
	}

	// problem with table structure should be fixed
}

// TAKE SCREENSHOT

@Test
public static void takeScreenshots() throws InterruptedException, IOException {

	Date currentdate = new Date();
	String screenshot_filename =  currentdate.toString().replace(" ", "_").replace(":", "_");
	System.out.println(screenshot_filename);

	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotFile, new File(".//screenshots/"+screenshot_filename+".png"));

}

// handling auth passing login and password to the URL
@Test
public static void authHandling1() throws InterruptedException {
	driver.get("https://wewe:wewe@kdlolympsite.ddirection.kz");

}

// handling auth via external data
public static String login = "wewe";
public static String password = "wewe";

@Test
public static void authHandling2() throws InterruptedException {
	driver.get("https://"+login+":"+password+"@kdlolympsite.ddirection.kz");
}



}
