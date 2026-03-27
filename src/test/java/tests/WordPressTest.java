package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.BaseTest;
import pages.PhotoDirectorPage;
import pages.WordPressHomePage;

public class WordPressTest extends BaseTest {
	

	@BeforeClass
	public void launchBrowser() {
		setUp();
	}
	
	@Test
	public void wordpressMiniProject() throws InterruptedException {
		WordPressHomePage homepage = new WordPressHomePage(driver);
		PhotoDirectorPage photopage = new PhotoDirectorPage(driver);
		
		String expectedTitle = "Blog Tool, Publishing Platform, and CMS – WordPress.org";
		String actualTitle = homepage.getPageTitle();
		System.out.println("actualTitle =" + actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Title Verified Successfully" );
		
		homepage.hoveronDownloadAndExtend();
		
		String actualText = homepage.getGetWordPressText();
		String expectedText = "Get WordPress";
		System.out.println("actualText =" + actualText);
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Text Verified Successfully" );
		
		homepage.getCommunitButton();
		System.out.println("Community DropDown clicked successfully");
		
		homepage.getPhotDirectory();
		System.out.println("PhotDirectory link clicked successfully");
		
		photopage.searchphot("nature");
		Thread.sleep(1000);
		Assert.assertTrue(photopage.arePhotosDisplay(),"Photos should be displayed after search");
		System.out.println("Selected photos are displayed successfully is =  " + photopage.getphotoscount() );		
		
		
		
	}
	@AfterClass
	public void quitBrowser() {
		closeBrowser();
	}
	

}
