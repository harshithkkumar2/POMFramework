/**
 * 
 */
package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

/**
 * @author Harshit
 *
 */
public class AddressPage  extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}

	public ShippingPage clickOnCheckOut() {
		actionPage.click(getDriver(), proceedToCheckOut);
		return new ShippingPage();
	}

}
