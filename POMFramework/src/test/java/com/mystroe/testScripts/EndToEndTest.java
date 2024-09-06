package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.pageObjects.AddToCartPage;
import com.mystroe.pageObjects.AddressPage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.LoginPage;
import com.mystroe.pageObjects.OrderConfirmationPage;
import com.mystroe.pageObjects.OrderPage;
import com.mystroe.pageObjects.OrderSummaryPage;
import com.mystroe.pageObjects.PaymentPage;
import com.mystroe.pageObjects.SearchResultPage;
import com.mystroe.pageObjects.ShippingPage;

public class EndToEndTest extends Baseclass{

	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummaryPage orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

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
	public void endToEndTest() {
		index= new IndexPage();
		searchResultPage=index.searchProduct("T-Shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		getDriver().switchTo().frame(0);
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		getDriver().switchTo().defaultContent();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
	}
	
}
