package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	ForgetPasswordPage forgetpassword = new ForgetPasswordPage();
	SignupPage signuppage = new SignupPage();
	ClassicCRMLoginPage classiccrmloginpage = new ClassicCRMLoginPage();
	
	//Page Factory - OR: Define
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//div[@class='ui fluid large blue submit button']")
	WebElement LoginButton;
	
	@FindBy(xpath = "//a[@href='https://api.cogmento.com/register']")
	WebElement SignupButton;
	
	@FindBy(xpath = "//a[@href= 'https://register.cogmento.com/password/reset/request/']")
	WebElement ForgetPasswordButton;
	
	@FindBy(xpath = "//a[@href= 'https://classic.crmpro.com/login.cfm']")
	WebElement ClassicCRMButton;
	
	//Initialize element of Object reporitory. "This" means current class objects(or u can use 'loginpage.class')
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Define Actions on login page. Or feature of login page.
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public ForgetPasswordPage ValidateForgetPasswordButton() {
		ForgetPasswordButton.click();
		return new ForgetPasswordPage();
	}
	
	public SignupPage ValidateSignupButton() {
		SignupButton.click();
		return new SignupPage();
	}
	
	public ClassicCRMLoginPage ValidateClassicCRMButton() {
		ClassicCRMButton.click();
		return new ClassicCRMLoginPage();
	}
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		LoginButton.click();
		//this menthod returns homepage
		return new HomePage();
		
	}

	

}
