package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//OR - Object repository
	@FindBy(xpath="//td[contains(text(),'User: Simiriya Kaur')]")
	WebElement userNameLavel;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealslink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement Contactslink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Taskslink;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserName(){
		return userNameLavel.isDisplayed();
	}
	
	public ContactsPage clickOnContactLink(){
		Contactslink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		Contactslink.click();
		return new DealsPage();
	}
	
}
