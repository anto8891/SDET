package stepdefinitions;

import org.testng.Assert;
import io.cucumber.java.en.*;


import pages.PhotoDirectorPage;
import pages.WordPressHomePage;
import utils.BaseTest;

public class WordPressSteps extends BaseTest {

WordPressHomePage homepage;
PhotoDirectorPage photopage;

@Given("user launches the browser")
public void launchBrowser() {
setUp();
homepage = new WordPressHomePage(driver);
photopage = new PhotoDirectorPage(driver);
}

@When("user navigates to WordPress homepage")
public void navigateToHomePage() {
// already handled in setUp() if URL is there
}

@Then("page title should be {string}")
public void verifyTitle(String expectedTitle) {
String actualTitle = homepage.getPageTitle();
System.out.println("Actual Title = " + actualTitle);
Assert.assertEquals(actualTitle, expectedTitle);
}

@When("user hovers on {string}")
public void hoverDownload(String menu) {
homepage.hoveronDownloadAndExtend();
}

@Then("user should see {string} text")
public void verifyText(String expectedText) {
String actualText = homepage.getGetWordPressText();
System.out.println("Actual Text = " + actualText);
Assert.assertEquals(actualText, expectedText);
}

@When("user clicks on Community menu")
public void clickCommunity() {
homepage.getCommunitButton();
}

@When("user clicks on Photo Directory")
public void clickPhotoDirectory() {
homepage.getPhotDirectory();
}

@When("user searches photos with keyword {string}")
public void searchPhotos(String keyword) throws InterruptedException {
photopage.searchphot(keyword);
Thread.sleep(1000);
}

@Then("photos should be displayed")
public void verifyPhotosDisplayed() {
Assert.assertTrue(photopage.arePhotosDisplay(),
"Photos should be displayed after search");

System.out.println("Photos count = " + photopage.getphotoscount());
}

@io.cucumber.java.After
public void tearDown() {
closeBrowser();
}
}


