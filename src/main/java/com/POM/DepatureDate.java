package com.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DepatureDate {
	public WebDriver driver;
	
	public DepatureDate(WebDriver driver1) {
	driver=driver1;
	PageFactory.initElements(driver, this);
	
	}
	@FindBy(xpath ="(//div[@class='sc-12foipm-16 dwhdnN fswFld '])[3]")
	private WebElement depDate;
	
	@FindBy(xpath="//div[@aria-label='Sun Jun 04 2023']")
	private WebElement selectedDate;
		
	@FindBy(xpath="//span[text()='Done']")
	private WebElement doneButton;
		
	public WebElement getDepDate() {
		return depDate;
	}

	public WebElement getSelectedDate() {
		return selectedDate;
	}

	public WebElement getDoneButton() {
		return doneButton;
	}
	

}
