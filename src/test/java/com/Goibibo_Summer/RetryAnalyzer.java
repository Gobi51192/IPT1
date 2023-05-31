package com.Goibibo_Summer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int max=2;
	int count=0;	
	@Override
	public boolean retry(ITestResult result) {
		if(count<=max) {
			count++;
			return true;
		}		
		return false;
	}
}
