package com.crm.qa.testcases;

import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage; //just declared globally not initialized so we need to initialize at before method.
	TestUtil testUtil;
	String sheetName = "contacts";
	
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {



		initialization();
		//testUtil = new TestUtil(); //if test util is used for frame
		contactsPage = new ContactsPage(); //here it is initialized.
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//testUtil.switchToFrame();//if frame is there
		homePage.clickonContactsLink();
		
	}
	
	@Test  //(retryAnalyzer = com.crm.qa.Analyzer.RetryAnalyzer.class) // This is to defined Fail retry on this class
	public void verifyContactsPageLabel() {
		Assert.assertEquals(true, false);
	}
	/*
	@Test (priority =2)
	public void selectSingleContactTest()  {
    contactsPage.selectContactsByName("Amit kumar");
	}
    
    @Test (priority =3)
	public void selectMultipleContactTest()  {
    contactsPage.selectContactsByName("Amit kumar");
    contactsPage.selectContactsByName("sumit kumar");
	}
   
    @DataProvider
    public Object[][] getCRMTestData() {
    	Object data[][] =TestUtil.getTestData(sheetName);
    	return data;
    	
    }
    
    @Test(priority = 4, dataProvider = "getCRMTestData")
    public void validataCreateNewContactfromExcel(String firstname, String lastname) {
    	contactsPage.clickOnNewContact();
    	contactsPage.createNewContact(firstname, lastname);
    	
    } */
    /*
	@Test (priority =5)
    public void validateCreateNewContactManual() {
    	
    	contactsPage.clickOnNewContact();
    	contactsPage.createNewContact("amit", "sharma234");
    	
    	
    }*/
	
	
	
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
	

}
