package com.mystroe.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class AccountCreationPage extends Baseclass{
	
	ActionDriver actionPage = new ActionDriver();
	
	@FindBy(xpath = "//h1[text()='Create an account']")
	private WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	private WebElement mr;
	
	@FindBy(id = "id_gender2")
	private WebElement mrs;

	@FindBy(name = "customer_firstname")
	private WebElement firstName;

	@FindBy(name = "customer_lastname")
	private WebElement lastName;

	@FindBy(name = "passwd")
	private WebElement passWord;

	@FindBy(name = "days")
	private WebElement days;

	@FindBy(name = "months")
	private WebElement months;

	@FindBy(name = "years")
	private WebElement years;

	@FindBy(name = "firstname")
	private WebElement customerNirstName;

	@FindBy(name = "lastname")
	private WebElement customerLastName;

	@FindBy(name = "company")
	private WebElement companyName;

	@FindBy(name = "address1")
	private WebElement address;

	@FindBy(name = "city")
	private WebElement city;

	@FindBy(name = "id_state")
	private WebElement state;

	@FindBy(name = "postcode")
	private WebElement postCode;

	@FindBy(name = "id_country")
	private WebElement country;

	@FindBy(name = "phone")
	private WebElement phone;

	@FindBy(name = "phone_mobile")
	private WebElement mobile;

	@FindBy(name = "alias")
	private WebElement ref;

	@FindBy(name = "submitAccount")
	private WebElement registerBtn;
	
	public AccountCreationPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) {
		
		if(gender.equalsIgnoreCase("Mr")) {
			actionPage.click(getDriver(), mr);
		} else {
			actionPage.click(getDriver(), mrs);
		}
		
		actionPage.type(firstName, fName);
		actionPage.type(lastName, lName);
		actionPage.type(passWord, pswd);
		actionPage.selectByValue(days, day);
		actionPage.selectByValue(months, month);
		actionPage.selectByValue(years, year);
		actionPage.type(companyName, comPany);
		actionPage.type(address, addr);
		actionPage.type(city, cityString);
		actionPage.selectByVisibleText(stateName, state);
		actionPage.type(postCode, zip);
		actionPage.selectByVisibleText(countryName, country);
		actionPage.type(mobile, mobilePhone);
	}
	
	public HomePage validateRegistration() {
		registerBtn.click();
		return new HomePage();
	}
	
	public boolean validateAcountCreatePage() {
		 return actionPage.isDisplayed(getDriver(), formTitle);
	}

}
