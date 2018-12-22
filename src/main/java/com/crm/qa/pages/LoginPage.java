package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Pagefactory and Object Reposatory
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;
	
	@FindBy (xpath = "button[text()='(//a[text()='Sign Up'])[1]']")
	WebElement signup;
	
	@FindBy(className= "img-responsive")
	WebElement crmLogo;
	
	//Initializing the page objects
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMimage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		
		return new HomePage();
		
	}
}
