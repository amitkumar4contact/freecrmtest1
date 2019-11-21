package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	ContactsPage contactpage = new ContactsPage();
	DealsPage dealpage = new DealsPage();
	
	//Object repository
	
	@FindBy(xpath="//*[contains(text(), 'Amit Kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//*[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	

	
	
	
	// Initialization
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHamePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		System.out.println(userNameLabel.getText());
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	

	
	

}
