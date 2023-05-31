package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FromPOM {
	public static WebDriver driver;

	@FindBy(xpath = "//span[@class='logSprite icClose']")
	private WebElement loginSkip;

	@FindBy(xpath = "(//p[text()='Enter city or airport'])[1]")
	private WebElement fromCity;

	@FindBy(xpath = "//input[@type='text']")
	private WebElement fromCityInput;
	
	@FindBy(xpath = "//p[text()='Chennai International Airport']")
	private WebElement Chennai;
	
	public WebElement getLoginSkip() {
		return loginSkip;
	}
	public WebElement getFromCity() {
		return fromCity;
	}
	public WebElement getFromCityInput() {
		return fromCityInput;
	}
	public WebElement getChennai() {
		return Chennai;
	}
	
	public FromPOM(WebDriver dri) {
		driver = dri;
		PageFactory.initElements(driver, this);
	}

}
