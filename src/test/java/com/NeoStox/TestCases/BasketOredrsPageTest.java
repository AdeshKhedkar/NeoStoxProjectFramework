package com.NeoStox.TestCases;

import org.testng.annotations.Test;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Pages.BasketOrdersPage;
import com.NeoStox.Pages.TradePanelPage;
import com.NeoStox.Utilities.CommonActions;

public class BasketOredrsPageTest extends TestBase{
	
	CommonActions commonactions = new CommonActions();
	
	@Test
	public void createBasketfunt() {
		commonactions = new CommonActions();
		TradePanelPage tradepanelPage = new TradePanelPage(driver);
		BasketOrdersPage basketordersPage = new BasketOrdersPage(driver);
		commonactions.click_on_Element(tradepanelPage.buttonStrategies);
		basketordersPage.createBasket();
	}

}
