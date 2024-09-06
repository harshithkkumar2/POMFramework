package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class PaymentPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
		
		@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")	private WebElement bankWireMethod;
		
		@FindBy(xpath = "//a[contains(text(),'Pay by check')]") private WebElement payByCheckMethod;
		
		public PaymentPage() {
			PageFactory.initElements(getDriver(), this);
		}
		
		public OrderSummaryPage clickOnPaymentMethod() {
			actionPage.click(getDriver(), bankWireMethod);
			return new OrderSummaryPage();
		}

}
