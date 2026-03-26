package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		 System.setProperty("Webdriver.chrome.driver", "C:\\Users\\Aruna Vishvanathan\\eclipse-workspace\\sedtproject\\Driver");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://wordpress.org/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		if(driver != null) {
			driver.quit();
		}
	}
	

}
