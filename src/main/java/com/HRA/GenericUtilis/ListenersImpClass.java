package com.HRA.GenericUtilis;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImpClass implements ITestListener{
	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		// actual stcripts execution starts from here
		String MethodName = result.getMethod().getMethodName();
		 test = report.createTest(MethodName);
		Reporter.log(MethodName+"--->Execution Starts");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test .log(Status.PASS,MethodName+"--->Passed");
		Reporter.log(MethodName+"--->TestScript executed Successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dtn = new File("./screenshot/FailedScript.png");
	
	try{
		FileUtils.copyFile(src, dtn);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String MethodName=result.getMethod().getMethodName();
		test .log(Status.SKIP,result.getThrowable());
		test .log(Status.SKIP,MethodName+"--->Skipped");
		Reporter.log(MethodName+"--->Skipped");
	}

	@Override
	public void onStart(ITestContext context) {
		//create report
		ExtentSparkReporter htmlreport=new ExtentSparkReporter("./ExtentReport/report.html");
		
		htmlreport.config().setDocumentTitle("SDET");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("HRA");
		
		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("OS", "WINDOWS-10");
		report.setSystemInfo("Base-Browser","chrome");
		report.setSystemInfo("Baser URL", "http://rmgtestingserver/domain/House_Rental_Application/index.php");
		report.setSystemInfo("Reporter Name", "Pushpa");
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	

}
