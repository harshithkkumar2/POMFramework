package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class HomePage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath="//html/body/div[2]/header/div[2]/div[1]/a") private WebElement shopingCart;
	
	@FindBy(xpath = "//span[text()='Order history and details']") private WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateShopingCart() {
		return actionPage.isDisplayed(getDriver(), shopingCart);
	}
	
	public boolean validateOrderHistory() {
		return actionPage.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrURL() {
		return actionPage.getCurrentURL(getDriver());
	}

}
