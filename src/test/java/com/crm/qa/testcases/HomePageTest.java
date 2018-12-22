package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactspage = new ContactsPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homepage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority = 2 )
	public void verifyUsernameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyUserName());
	}
	
	@Test
	public void verifyContactslinksTest(){
		testUtil.switchToFrame();
		contactspage = homepage.clickOnContactLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
