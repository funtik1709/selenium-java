package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loc = new Properties();
	public static FileReader fr;
	public static FileReader fr1;

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {

		if (driver == null) {
			FileReader fr = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\config.properties");
			FileReader fr1 = new FileReader(
					System.getProperty("user.dir") + "\\src\\test\\resources\\configfiles\\locators.properties");
			prop.load(fr);
			loc.load(fr1);
		}

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
			
			WebDriverManager.chromedriver().clearDriverCache().setup();

			driver = new ChromeDriver();

			driver.get(prop.getProperty("test_url"));
			
			driver.manage().window().maximize();
			Thread.sleep(3000);
			String title = driver.getTitle();
			//System.out.println(title);

		} else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
			// import geckodriver bellow
			System.setProperty("webdriver.firefox.driver", "src/test/resources/geckodriver/geckodriver.exe"); 
			driver = new FirefoxDriver();

			driver.get(prop.getProperty("test_url"));
			driver.manage().window().maximize();
		} else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
			// import msedgedriver bellow
			System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver/msedgedriver.exe");
			driver = new EdgeDriver();

			driver.get(prop.getProperty("test_url"));
			driver.manage().window().maximize();
		}
		Thread.sleep(2000);
		//select city modal
		WebElement confirmButton = driver.findElement(By.xpath("//*[@id=\"modal1\"]/div/div[2]/button[1]"));
		confirmButton.click();

	}

//	@AfterMethod
//	public void tearDown() {
//		driver.close();
//		System.out.println("Teardown successful");
//	}

}
