package pages;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PhotoDirectorPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//*[@id=\"wp-block-search__input-8\"]")
	private WebElement searchButton;
	
	@FindBy(css ="img, .photo, .wp-block-image img")
	private List<WebElement> photos;
	
	
	public PhotoDirectorPage(WebDriver driver) {
		this.driver =  driver;
		PageFactory.initElements(driver,this);
		
	}


	
	public void searchphot(String photoName) {
		
		searchButton.sendKeys(photoName);
		searchButton.submit();
	}
		
	public boolean arePhotosDisplay() {
		
		return !photos.isEmpty();
	}
	
	public int getphotoscount() {
	
		int totalpic = photos.size();
		return totalpic;
	}
	
	}


