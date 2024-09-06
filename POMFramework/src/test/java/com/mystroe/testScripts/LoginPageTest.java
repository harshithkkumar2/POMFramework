package com.mystroe.testScripts;

import java.lang.reflect.Method;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystroe.base.Baseclass;
import com.mystroe.dataProvider.DataProviders;
import com.mystroe.pageObjects.HomePage;
import com.mystroe.pageObjects.IndexPage;
import com.mystroe.pageObjects.LoginPage;
import com.mystroe.utility.Log;

public class LoginPageTest extends Baseclass{

	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		launchBrowser(browser); 
	}
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
//	@Test(dataProvider = "Credentials" ,dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity","Regression"})
//	public void loginTest(String trigger,String testcase,String usname,String passwd){
//		try {
//			Class reflectClass = Class.forName("com.mystroe.testScripts.LoginPageTest");
//			System.out.println(reflectClass.getName());
//			LoginPageTest test = (LoginPageTest) reflectClass.getDeclaredConstructor().newInstance();
//			Method[] methods = reflectClass.getDeclaredMethods();
//			for (Method method : methods) {
//				if(method.getName().equalsIgnoreCase(testcase) && trigger.equalsIgnoreCase("Y")) {
//					method.setAccessible(true);
//					method.invoke(test, usname,passwd);
//				}
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void ValidUserNameValidPassword() {
		Log.startTestCase("ValidUserNameValidPassword");
		indexPage= new IndexPage();
		Log.info("Click on SignIn Button");
		loginPage=indexPage.clickOnSignIn();
		Log.info("User enter Username and Password as "+prop.getProperty("username")+prop.getProperty("password"));     
		homePage=loginPage.login("harshit.hk.kumar2@gmail.com","Star#2607");
		Log.info("Get the actual url");
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="https://magento.softwaretestingboard.com/";
	    Log.info("Validating the url");
	    Assert.assertEquals(actualURL, expectedURL);
	    Log.endTestCase("Test Case ended successfully");
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void InValidUserNameValidPassword() {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("Click on SignIn Button");
		loginPage=indexPage.clickOnSignIn();
		Log.info("User enter Username and Password as "+prop.getProperty("username")+prop.getProperty("password"));     
		homePage=loginPage.login("abc@gmail.com","Star#2607");
	    String actualauthError=loginPage.authFailmsg();
	    String expectedauthError="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
	    Log.info("Validating the error message");
	    Assert.assertEquals(actualauthError, expectedauthError);
	    Log.endTestCase("Test Case ended successfully");
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void ValidUserNameInValidPassword() {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("Click on SignIn Button");
		loginPage=indexPage.clickOnSignIn();
		Log.info("User enter Username and Password as "+prop.getProperty("username")+prop.getProperty("password"));     
		homePage=loginPage.login("harshit.hk1.kumar2@gmail.com","3456");
		String actualauthError=loginPage.authFailmsg();
		String expectedauthError="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		Log.info("Validating the error message");
		Assert.assertEquals(actualauthError, expectedauthError);
		Log.endTestCase("Test Case ended successfully");
	}
	
	@Test(groups = {"Smoke","Sanity","Regression"})
	public void InValidUserNameInValidPassword() {
		Log.startTestCase("loginTest");
		indexPage= new IndexPage();
		Log.info("Click on SignIn Button");
		loginPage=indexPage.clickOnSignIn();
		Log.info("User enter Username and Password as "+prop.getProperty("username")+prop.getProperty("password"));     
		homePage=loginPage.login("abc@gmail.com","3456");
		String actualauthError=loginPage.authFailmsg();
		String expectedauthError="The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
		Log.info("Validating the error message");
		Assert.assertEquals(actualauthError, expectedauthError);
		Log.endTestCase("Test Case ended successfully");
	}
	
}
