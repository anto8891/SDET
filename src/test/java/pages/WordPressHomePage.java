package pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WordPressHomePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//title")
	private WebElement pageTitle;
	
	@FindBy(xpath = "//a[contains(text(),'Get WordPress')]")
	private WebElement getWordPress;
	
	@FindBy(xpath = "//h1[contains(text(),'Get WordPress')]")
	private WebElement textElement;
	
	@FindBy(xpath = "//*[@id=\"modal-1-content\"]/ul/li[6]/button")
	private WebElement communityButton;
	
	@FindBy(xpath = "//*[@id=\"modal-1-content\"]/ul/li[6]/ul/li[3]/a/span")
	private WebElement photoDirectoryButton;
	
	
	
	public WordPressHomePage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);		
		
	}

	public String getPageTitle() {	
		return driver.getTitle();
	}
		
	public void hoveronDownloadAndExtend() {
				 
		Actions actions = new Actions(driver);
		actions.moveToElement(getWordPress).perform();
		getWordPress.click();
	}
	
	public String getGetWordPressText() {	
		return textElement.getText();
		
	}
	
	public void getCommunitButton() {
			communityButton.click();
	}
	
	public void getPhotDirectory() {
		photoDirectoryButton.click();
	}
	
	

}
