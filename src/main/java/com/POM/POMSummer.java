package com.POM;

import org.openqa.selenium.WebDriver;

public class POMSummer {
	public WebDriver driver;
	
	public POMSummer(WebDriver dri) {
		driver=dri;
	}
	private FromPOM fromPOM;
	private ToPOM toPOM;
	private DepatureDate depatureDate;
	private TravellerClass travellerClass;
	private SearchFlights searchFlights;
	
	public FromPOM getFromPOM() {
		if(fromPOM==null) {
		fromPOM=new FromPOM(driver);
		}
		return fromPOM;
	}
	public ToPOM getToPOM() {
		if(toPOM==null) {
			toPOM=new ToPOM(driver);
			}
		return toPOM;
	}
	public DepatureDate getDepatureDate() {
		if(depatureDate==null) {
			depatureDate=new DepatureDate(driver);
			}
		return depatureDate;
	}
	public TravellerClass getTravellerClass() {
		if(travellerClass==null) {
			travellerClass=new TravellerClass(driver);
			}
		return travellerClass;
	}
	public SearchFlights getSearchFlights() {
		if(searchFlights==null) {
			searchFlights=new SearchFlights(driver);
			}
		return searchFlights;
	}

	
	
}
