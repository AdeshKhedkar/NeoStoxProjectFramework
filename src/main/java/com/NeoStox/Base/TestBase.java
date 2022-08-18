package com.NeoStox.Base;

import java.awt.Desktop;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import com.NeoStox.Constant.AppConstant;
import com.NeoStox.Pages.LoginPage;
import com.NeoStox.Utilities.PropertiesReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBase {

	public static WebDriver driver;	
	
	private Logger logger = LoggerFactory.getLogger(TestBase.class);
	
	@BeforeMethod
	public WebDriver initializeDriver() throws Exception {

		String browsername = PropertiesReader.getValue("browser");
		

		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",AppConstant.getChromePath());
			driver = new ChromeDriver();
		} else if (browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",AppConstant.getfirefoxPath());
			driver = new FirefoxDriver();
		} else if (browsername.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",AppConstant.getedgePath() );
			driver = new EdgeDriver();
		}
		logger.info("Initializing " + browsername + " driver");
		int implicitTime = Integer.parseInt(PropertiesReader.getValue("ImplicitWait"));
		int pageloadTime = Integer.parseInt(PropertiesReader.getValue("PageLoadTime"));
		driver.manage().timeouts().pageLoadTimeout(pageloadTime, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(implicitTime, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(PropertiesReader.getValue("application.url"));

		LoginPage lp = new LoginPage(driver);
		lp.login();
		return driver;
	}



	@AfterMethod
	public void teardown() {
		driver.quit();
		logger.info("Closing driver");
	}
	
	@AfterSuite(alwaysRun=true)
	public void openReport() {
			try {
				File reportFile = new File(AppConstant.getsparkreportPath());
				Desktop desktop = Desktop.getDesktop();
				if(reportFile.exists()) {
				desktop.open(reportFile);}
				
				//Backing up current report file with current time-stamp
				LocalDateTime myDate = LocalDateTime.now();
				DateTimeFormatter dateTime = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss");
				String dt = myDate.format(dateTime);
				
				File reportBackup = new File(AppConstant.getarcheiveSparkReportPath() + "_" + dt + ".html");
				
				FileUtils.copyFile(reportFile, reportBackup);
				
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail("", e.getCause());
			}
		}
	}
	
	
	

