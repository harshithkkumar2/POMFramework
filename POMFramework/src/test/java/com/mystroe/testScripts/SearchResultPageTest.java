package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.SearchResultPage;

public class SearchResultPageTest extends Baseclass{
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchBrowser(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke","Regression"})
	public void productAvailabilityTest() {
		index= new IndexPage();
		searchResultPage=index.searchProduct("T-Shirt");
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
	}
}
