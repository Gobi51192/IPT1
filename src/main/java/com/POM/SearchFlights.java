package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchFlights {
	public WebDriver driver;
	
	public SearchFlights(WebDriver driver1) {
	driver=driver1;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='SEARCH FLIGHTS']")
	private WebElement searchflightButton;
	
	public WebElement getSearchflightButton() {
		return searchflightButton;
	}
	
	
	
	
}
