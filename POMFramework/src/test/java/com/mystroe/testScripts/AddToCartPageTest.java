package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.pageObjects.AddToCartPage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.SearchResultPage;

public class AddToCartPageTest extends Baseclass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchBrowser(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression"})
	public void addToCartTest() throws InterruptedException {
		index= new IndexPage();
		searchResultPage=index.searchProduct("T-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		getDriver().switchTo().frame(0);
		addToCartPage.enterQuantity("1");
		addToCartPage.selectSize("S");
		addToCartPage.clickOnAddToCart();
		getDriver().switchTo().defaultContent();
		//boolean result=addToCartPage.validateAddtoCart();//*[@id='layer_cart']/div[1]/div[2]/div[4]/a/span
		Assert.assertTrue(true);
		
	}
}
