package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ClassicCRMLoginPage;
import com.crm.qa.pages.ForgetPasswordPage;
import com.crm.qa.pages.ForgotPasswordPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignupPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ForgetPasswordPage forgotPasswordPage;
	ClassicCRMLoginPage classicCRMLoginPage;
	SignupPage signupPage;
	
	public LoginPageTest() {
		super();
	}

	//Maven is already present in eclipse, testng u have to download.
	@BeforeMethod
	public void Setup() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=0)
	public void LoginPageTitleTest() {
		String title = loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "CRM");
	}
	
	@Test(priority=1)
	public void LoginPageSignupLinkTest() {
		signupPage = loginPage.ValidateSignupButton();
		
	}
	
	@Test(priority=2)
	public void LoginPageForgetPasswordLinkTest() {
		forgotPasswordPage = loginPage.ValidateForgetPasswordButton();
	}
	
	@Test(priority=3)
	public void LoginPageClassicCRMLoginLinkTest() {
		classicCRMLoginPage=loginPage.ValidateClassicCRMButton();
	}
	@Test(priority=4)
	public void loginTest() {
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
