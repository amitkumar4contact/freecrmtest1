package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CommonPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SearchResultPage;
import com.crm.qa.pages.SettingsPage;

public class CommonPageTest extends TestBase {

	LoginPage loginPage;	
	CommonPage commonPage;
	HomePage homePage;
	SettingsPage settingPage;
	SearchResultPage searchResultPage;

	public CommonPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();		
		loginPage = new LoginPage();
		commonPage = new CommonPage();
		homePage = new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	/*
	@Test(priority = 1)
	public void verifyUserNameTest() {
		// testUtil.switchToFrame();
		Assert.assertTrue(true, "pass");
	}

	@Test(priority = 2)
	public void verifyUserBetaMessage() {
		// testUtil.switchToFrame();
		String s = "This is Beta software and as such, will contain bugs. We are working to resolve all issues.";
		Assert.assertEquals(s, commonPage.settingsPannelBeta());
	}
	
	@Test(priority = 5)
	public void searchTest() {
		logcommonPage.validateSearchPannelDropdownSettingButton();
	}
	
	@Test(priority = 4)
	public void settingPageLinkTest() {
		settingPage=commonPage.validateSettingsPannelDropdownSettingButton();
	}*/
	
	
	@Test(priority = 3)
	public void logoutTest() throws InterruptedException {
		loginPage=commonPage.validateLogoutPannelDropdownSettingButton();
	}
	
	
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
