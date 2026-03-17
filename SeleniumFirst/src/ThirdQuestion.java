
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ThirdQuestion {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("Webdriver.chrome.driver",
				"C:\\Users\\Aruna Vishvanathan\\eclipse-workspace\\SeleniumFirst\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			driver.get("https://autify.com/");
			System.out.println("Browser launched");
			WebElement pricing = driver.findElement(By.xpath("/html/body/div[5]/div[2]/div/nav/a[2]"));
			Actions action = new Actions(driver);
			action.moveToElement(pricing).build().perform();
			action.click(pricing).build().perform();
			System.out.println("Pricing Button clicked successfully");

			WebElement getStarted = driver
					.findElement(By.xpath("//*[@id=\"w-tabs-0-data-w-pane-0\"]/div[2]/div[1]/div[1]/a"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", getStarted);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			getStarted.click();
			System.out.println("Get started Button clicked successfully");

			String mainWindow = driver.getWindowHandle();
			System.out.println("Main window opened successfully");
			System.out.println("Main Window Title : " + driver.getTitle());
			System.out.println("Main URL :" + driver.getCurrentUrl());
			WebElement tryFree = driver.findElement(By.xpath("/html/body/section[1]/div/div/a"));

			String linkUrl = tryFree.getAttribute("href");
			driver.switchTo().newWindow(WindowType.WINDOW);
			driver.get(linkUrl);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.switchTo().window(mainWindow);
			Thread.sleep(1000);

			Set<String> allwindows = driver.getWindowHandles();
			for (String windowHandle : allwindows) {
				if (!windowHandle.equals(mainWindow)) {
					driver.switchTo().window(windowHandle);
					System.out.println("New window opened successfully");
					System.out.println("Current Window Title : " + driver.getTitle());
					System.out.println("Current URL :" + driver.getCurrentUrl());
					driver.close();
					System.out.println("child window Closed Successfully");
					break;
				}

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
			System.out.println("Browser Quit successfully");
		}

	}

}
