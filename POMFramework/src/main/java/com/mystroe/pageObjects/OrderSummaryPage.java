package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class OrderSummaryPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]") private WebElement confirmOrderBtn;
	
	public OrderSummaryPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() {
		actionPage.click(getDriver(), confirmOrderBtn);
		return new OrderConfirmationPage();
	}

}
