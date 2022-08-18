package com.NeoStox.Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import com.NeoStox.Base.TestBase;

public  final class ScreenshotUtil extends TestBase {
	
     static WebDriver driver;
	
	public static String getBase64img(WebDriver driver){
		ScreenshotUtil.driver=driver;
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
	
}
