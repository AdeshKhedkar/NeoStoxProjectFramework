package com.NeoStox.TestCases;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Pages.TradePanelPage;
import com.NeoStox.Utilities.CommonActions;

public class TradePanelPageTest extends TestBase {
	
	TradePanelPage tradepanelpage;
	CommonActions commonactions ;

	@Test  
	public void ExpandCollapseFunctionality_ShowInstrumentList()  {
		tradepanelpage= new TradePanelPage(driver);
		commonactions = new CommonActions();
		Assert.assertTrue(commonactions.visibilityOfelement(tradepanelpage.panelWatchlist));
		Assert.assertTrue(commonactions.visibilityOfelement(tradepanelpage.buttonShowInstrumentList));
		commonactions.click_on_Element(tradepanelpage.buttonShowInstrumentList);
		Assert.assertFalse(commonactions.visibilityOfelement(tradepanelpage.optionNIFTY50));
	}  
	
	
	@Test (dataProvider="getData",dataProviderClass = com.NeoStox.Utilities.DataProviderUtils.class)
	public void watchlist(Map<String,String> data)  {
		tradepanelpage= new TradePanelPage(driver);
		tradepanelpage.select_share_from_dropdown(data.get("Share"));	
	} 
	
	@Test
	public void LinkValidation() {
		commonactions = new CommonActions();
		tradepanelpage= new TradePanelPage(driver);
		commonactions.click_on_Element(tradepanelpage.linkPendingOrders);
		Assert.assertTrue(commonactions.visibilityOfelement(tradepanelpage.panelPendingOrders));
	}
	
	
	
}
