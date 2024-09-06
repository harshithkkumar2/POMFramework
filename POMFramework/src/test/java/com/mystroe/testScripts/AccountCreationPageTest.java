package com.mystroe.testScripts;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.dataProvider.DataProviders;
import com.mystroe.pageObjects.AccountCreationPage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.LoginPage;

public class AccountCreationPageTest extends Baseclass{
	
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchBrowser(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Regression"}, dataProvider = "email",dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String eml){
		indexPage= new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(eml);
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
	}
	
	/*
	 * @Test public void createAccountTest(HashMap<String,String> hashMapValue) {
	 * indexPage= new IndexPage(); loginPage=indexPage.clickOnSignIn();
	 * acountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
	 * acountCreationPage.createAccount( hashMapValue.get("Gender"),
	 * hashMapValue.get("FirstName"), hashMapValue.get("LastName"),
	 * hashMapValue.get("SetPassword"), hashMapValue.get("Day"),
	 * hashMapValue.get("Month"), hashMapValue.get("Year"),
	 * hashMapValue.get("Company"), hashMapValue.get("Address"),
	 * hashMapValue.get("City"), hashMapValue.get("State"),
	 * hashMapValue.get("Zipcode"), hashMapValue.get("Country"),
	 * hashMapValue.get("MobilePhone"));
	 * homePage=acountCreationPage.validateRegistration(); Assert.assertEquals(
	 * "http://automationpractice.com/index.php?controller=my-account",
	 * homePage.getCurrURL()); }
	 */
}
