package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class ShippingPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void checkTheTerms() {
		actionPage.click(getDriver(), terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut(){
		actionPage.click(getDriver(), proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
