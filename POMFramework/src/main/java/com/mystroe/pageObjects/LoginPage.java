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
public class LoginPage extends Baseclass {
	
	ActionDriver actionPage = new ActionDriver();

	@FindBy(id="email") private WebElement userName;
	@FindBy(id="pass") private WebElement password;
	@FindBy(xpath ="//*[@id='login-form']/fieldset/div[4]/div/button/span") private WebElement signInBtn;
	@FindBy(id="//*[@id='login-form']/fieldset/div[4]/div[2]/a/span") private WebElement forgotPassword;
	@FindBy(xpath = "//*[@id='maincontent']/div[3]/div/div[2]/div[2]/div[2]/div/div/a/span") private WebElement createNewAccountBtn;
	@FindBy(xpath = "//*[@id='maincontent']/div[2]/div[2]/div/div/div") private WebElement authFailedmsg;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage login(String uname, String pswd) {
		actionPage.scrollByVisibilityOfElement(getDriver(), userName);
		actionPage.type(userName, uname);
		actionPage.type(password, pswd);
		actionPage.JSClick(getDriver(), signInBtn);
		actionPage.getSleep(2000);
		return new HomePage();
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) {
		actionPage.scrollByVisibilityOfElement(getDriver(), userName);
		actionPage.type(userName, uname);
		actionPage.type(password, pswd);
		actionPage.click(getDriver(), signInBtn);
		actionPage.getSleep(2000);
		addressPage=new AddressPage();
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail){
		//actionPage.type(forgotPassword, newEmail);
		actionPage.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	
	public String authFailmsg() {
		actionPage.fluentWait(getDriver(), authFailedmsg, 10);
		return authFailedmsg.getText();
	}
}
