package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class SearchResultPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath="//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img") private WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable() {
		return actionPage.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct() {
		actionPage.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
