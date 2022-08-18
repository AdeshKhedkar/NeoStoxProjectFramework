package com.NeoStox.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.NeoStox.Base.TestBase;
import com.NeoStox.Utilities.CommonActions;

public class BasketOrdersPage extends TestBase {
	
	WebDriver driver;
	
	public BasketOrdersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//a[@id='lnk_basketorders']")
	private WebElement linkBasketOrders;
	
	
	@FindBy(xpath="//a[text()='Create Basket']")
	private WebElement buttonCreateBasket;
	
	
	public void createBasket() {
		CommonActions commonactions = new CommonActions();
		commonactions.click_on_Element(linkBasketOrders);
		commonactions.click_on_Element(buttonCreateBasket);
	}
}
