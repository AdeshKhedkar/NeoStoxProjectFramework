package com.NeoStox.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Utilities.CommonActions;

public class LoginPage extends TestBase {

	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "txt_mobilenumber")
	private WebElement textboxMobileNumber;

	@FindBy(xpath = "//input[@id='txt_accesspin']")
	private WebElement textboxpin;   

	@FindBy(id = "lnk_submitmobnumber")
	private WebElement buttonSubmit;
	
	@FindBy (xpath="//li[@id='lnk_toplinks_signin']//a")
	private WebElement linkSignIn;
	
	@FindBy (id="lnk_submitaccesspin")
	private WebElement buttonSubmitPin;
	
	@FindBy(xpath="(//a[normalize-space(text())='OK'])[1]")
	private WebElement buttonOK;
	
	public void login()
	{
		CommonActions commonactions = new CommonActions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		commonactions.enters_data("9604154175", textboxMobileNumber);
		commonactions.wait(2000);
		commonactions.click_on_Element(buttonSubmit);
		commonactions.wait(2000);
		commonactions.enters_data("2812", textboxpin);  
		commonactions.wait(2000);
		commonactions.click_on_Element(buttonSubmitPin);
		commonactions.wait(2000);
		
		if (buttonOK.isDisplayed()) {
		commonactions.click_on_Element(buttonOK);}
	} 
	
	

	
}
