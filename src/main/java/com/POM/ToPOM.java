package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ToPOM {
	public WebDriver driver;
		
	public ToPOM(WebDriver dri) {
		driver=dri;
		PageFactory.initElements(dri, this);
	}

	@FindBy(xpath="(//p[text()='Enter city or airport'])[2]")
	private WebElement toLocation;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement tofieldText;
	
	@FindBy(xpath="//span[text()='Madurai, India']")
	private WebElement maduraiSelect;
	
	public WebElement getToLocation() {
		return toLocation;
	}

	public WebElement getTofieldText() {
		return tofieldText;
	}

	public WebElement getMaduraiSelect() {
		return maduraiSelect;
	}
}
