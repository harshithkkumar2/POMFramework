package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mystroe.base.Baseclass;
import com.mystroe.pageObjects.IndexPage;

public class IndexPageTest extends Baseclass{
	private IndexPage indexPage;
	
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
	public void verifyLogo() {
		indexPage= new IndexPage();
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void verifyTitle() {
		String actTitle=indexPage.getMyStroeTitle();
		System.out.println("Actual Page Title : "+actTitle);
		Assert.assertEquals(actTitle, "Home Page");
	}

}
