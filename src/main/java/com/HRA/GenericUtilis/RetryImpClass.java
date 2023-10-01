
package com.HRA.GenericUtilis;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImpClass implements IRetryAnalyzer{
	int count=0;
	int upperlimit=4;
	
	@Override
	public boolean retry(ITestResult result) {
		while(count<upperlimit) {
			count++;
		return true;
		
	}
	return false;

}
}