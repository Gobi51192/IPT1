package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravellerClass {
	public WebDriver driver;
	
	public TravellerClass(WebDriver driver1) {
	driver=driver1;
	PageFactory.initElements(driver, this);
	
	}

	@FindBy(xpath="(//div[@class='sc-12foipm-16 dwhdnN fswFld '])[5]")
	private WebElement travelClassSelection;
	
	@FindBy(xpath="(//span[@class='sc-12foipm-63 ePVCFi'])[2]")
	private WebElement adultAddButton;
	
	@FindBy(xpath="//a[text()='Done']")
	private WebElement travelerDone;
	
	public WebElement getTravelClassSelection() {
		return travelClassSelection;
	}

	public WebElement getAdultAddButton() {
		return adultAddButton;
	}

	public WebElement getTravelerDone() {
		return travelerDone;
	}
	
	
	
	
}
