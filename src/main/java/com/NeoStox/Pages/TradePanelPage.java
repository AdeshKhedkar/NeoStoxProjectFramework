package com.NeoStox.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Utilities.CommonActions;

public class TradePanelPage extends TestBase {

	WebDriver driver;
	
	public TradePanelPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="analyserDropDown")
	public WebElement buttonStrategies;
	
	
	@FindBy(xpath = "//button[@title='Show Instrument List']")
	public WebElement buttonShowInstrumentList;
	
	@FindBy(xpath="//span[@id='ctl00_lbl_username']")
	public  WebElement headerUserName;
	
	
	@FindBy(xpath="//div[@id='sidebar-wrapper']")
	public WebElement panelWatchlist;
	
	@FindBy(xpath="//div[text()='NIFTY 50']")
	public WebElement optionNIFTY50;
	
	@FindBy(id="txt_instruments")
	private WebElement textboxSearchInstr;
	
	@FindBy(xpath="//ul[@class='ui-menu ui-widget ui-widget-content ui-autocomplete ui-front']")
	private WebElement panelSearchInstr;
	
	@FindBy(xpath="//li[@class='ui-menu-item']//a")
	private List<WebElement> optionsSearchInstr;
	
	@FindBy(id="lnk_pendingorders")
	public WebElement linkPendingOrders;
	
	@FindBy(id="nav-pendingorders")
	public WebElement panelPendingOrders;
	
	public void select_share_from_dropdown(String string) {
		CommonActions commonactions = new CommonActions();
		commonactions.enters_data(string, textboxSearchInstr);
		commonactions.visibilityOfelement(panelSearchInstr);
		for(int i = 0; i<optionsSearchInstr.size(); i++) {
			
			if(optionsSearchInstr.get(i).getText().equals(string)) {
				optionsSearchInstr.get(i).click();
			}
		}	
	}
	
	
}
