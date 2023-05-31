package com.Goibibo_Summer;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Base.BaseClass;
import com.POM.POMSummer;

@Listeners(ListenerClass.class)
public class GoibiboRunner extends BaseClass {

	public POMSummer p;

	@Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
	public void ApplicationLaunch() throws InterruptedException {
		browserLaunch("Chrome");
		implicitWait(5);
		p = new POMSummer(driver);
		urlLaunch("https://www.goibibo.com/");
		clickOnElement(p.getFromPOM().getLoginSkip());
	}

	@Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
	private void orgin() {
		clickOnElement(p.getFromPOM().getFromCity());
		inputValues(p.getFromPOM().getFromCityInput(), "Chennai");
		Assert.assertTrue(p.getFromPOM().getChennai().isDisplayed());
		mouseClick(p.getFromPOM().getChennai());

	}

	@Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
	private void destination() {
		// clickOnElement(p.getToPOM().getToLocation());
		inputValues(p.getToPOM().getTofieldText(), "Madurai");
		Assert.assertTrue(p.getToPOM().getMaduraiSelect().isDisplayed());
		mouseClick(p.getToPOM().getMaduraiSelect());

	}

	@Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
	private void dataOfJourny() {
		// clickOnElement(p.getDepatureDate().getDepDate());
		clickOnElement(p.getDepatureDate().getSelectedDate());
		clickOnElement(p.getDepatureDate().getDoneButton());

	}

	@Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
	private void classOfJourny() {
		// clickOnElement(p.getTravellerClass().getTravelClassSelection());
		for(int i=0;i<3; i++) {
		clickOnElement(p.getTravellerClass().getAdultAddButton());
		}
		clickOnElement(p.getTravellerClass().getTravelerDone());
	}

	@Test(priority = 6, retryAnalyzer = RetryAnalyzer.class)
	private void searchForFlights() throws Exception {
		screenShot("goibibo-beforeClick");
		clickOnElement(p.getSearchFlights().getSearchflightButton());		
		Thread.sleep(15000);
		screenShot("goibibo");
		close();
	}
}
