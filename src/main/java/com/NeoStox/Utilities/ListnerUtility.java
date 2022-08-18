package com.NeoStox.Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Constant.AppConstant;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerUtility extends TestBase implements ITestListener {
	
	private Logger logger = LoggerFactory.getLogger(ListnerUtility.class);
	ExtentReports extent = new ExtentReports();
	ExtentSparkReporter spark = new ExtentSparkReporter(AppConstant.getsparkreportPath());

	
	
	public void onStart(ITestContext result) {
		extent.attachReporter(spark);
		spark.config().setReportName("NeoStox Result");
		spark.config().setDocumentTitle("NeoStox Test Result");
		spark.config().setTheme(Theme.DARK);
		spark.config().setTimeStampFormat("MMMM dd, yyyy HH:mm:ss");
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();		
	}
	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Reports/FailedTestsScreenshots/"  +"embedded" + ".png";
		
		File DestFile = new File(destination);
		try {
			FileHandler.copy(scrFile, DestFile);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		ExtentTest test = extent.createTest(result.getMethod().getDescription());
		logger.info("Capturing the screenshot : " + result.getMethod().getDescription());
		test.fail(result.getMethod().getMethodName()).addScreenCaptureFromBase64String(ScreenshotUtil.getBase64img(driver));
		test.fail(result.getMethod().getDescription());
		test.log(Status.FAIL, result.getThrowable());
		
		CommonActions commonactions = new CommonActions();
		commonactions.wait(5000);
		driver.quit();
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " :"+ "Test Case Skip");	
		ExtentTest test = extent.createTest(result.getMethod().getDescription());
		test.skip(result.getMethod().getDescription());
		test.log(Status.SKIP, result.getThrowable());
		driver.quit();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getDescription() + ": Test Case Execuate Successfully");
		ExtentTest test = extent.createTest(result.getMethod().getDescription());
		test.pass(result.getMethod().getDescription());
		
	
	}

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("****Started Execuation of : >"  + result.getMethod().getDescription());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * We are not using this method currently
		 */
		
	}


	

}
