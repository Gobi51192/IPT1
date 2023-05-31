package com.Goibibo_Summer;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {
	@Override
	public void onStart(ITestContext context) {
System.out.println(context.getStartDate());

	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println(context.getEndDate());
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is successfully completed");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		int testName = result.getStatus();
		TakesScreenshot ts = (TakesScreenshot) GoibiboRunner.driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\gobiv\\eclipse-workspace\\IPT_TestNG_Amazon\\ScreenShot\\" + testName + ".png");
		try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped");
	}
	

}
