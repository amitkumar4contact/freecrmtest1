package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	//if test util is used for frame
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		testUtil = new TestUtil(); //if test util is used for frame
		ContactsPage contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	//always end test case name with TEST
	//we are closing browser after every test case so that there is not coockie issue and should not be exaused. Test cases should be independent to eachother
	// There should not be any dependency bw 2 test cases. So before every test case launch and execute and close.
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHamePageTitle();
		Assert.assertEquals(homePageTitle, "CRM");
	}
	
	@Test(priority = 2)
	public void verifyUserNameTest() {
		//testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority =3)
	public void verifyContactsPageLink() {
		contactsPage = homePage.clickonContactsLink();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
