package com.NeoStox.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Pages.TradePanelPage;
import com.NeoStox.Utilities.CommonActions;



public class LoginPageTest extends TestBase {

	TradePanelPage tradepanelpage;
	CommonActions commonactions ;
    
	@Test
	public void LoginPageNavigationTest()  {
		tradepanelpage= new TradePanelPage(driver);
		commonactions = new CommonActions();
		System.out.println(commonactions.getTitle(driver));
		Assert.assertEquals(tradepanelpage.headerUserName.getText(), "Hi adesh khedkar");
		
	}  

	
	
	@Test 
	public void LoginPageTest1()  {
		tradepanelpage= new TradePanelPage(driver);
		commonactions = new CommonActions();
		System.out.println(commonactions.getTitle(driver));
		Assert.assertEquals(tradepanelpage.headerUserName.getText(), "Hi123");
		
	} 
	
}
