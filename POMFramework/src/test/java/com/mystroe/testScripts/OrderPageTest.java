package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.pageObjects.AddToCartPage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.OrderPage;
import com.mystroe.pageObjects.SearchResultPage;

public class OrderPageTest extends Baseclass{
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchBrowser(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyTotalPrice(){
		index= new IndexPage();
		searchResultPage=index.searchProduct("T-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		getDriver().switchTo().frame(0);
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("S");
		addToCartPage.clickOnAddToCart();
		getDriver().switchTo().defaultContent();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*2)+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
	}
}
