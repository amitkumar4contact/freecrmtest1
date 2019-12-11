package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	ContactsPage contactpage = new ContactsPage();
	DealsPage dealpage = new DealsPage();

	
	//Object repository
	
	@FindBy(xpath="//*[contains(text(), 'Home')]")
	WebElement homeLink;
	
	@FindBy(xpath="//*[contains(text(), 'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//*[contains(text(), 'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath="//*[contains(text(), 'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//*[contains(text(), 'Cases')]")
	WebElement casesLink;
	
	@FindBy(xpath="//*[contains(text(), 'Calls')]")
	WebElement callsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Documents')]")
	WebElement documentsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Email')]")
	WebElement emailLink;
	
	@FindBy(xpath="//*[contains(text(), 'Campaigns')]")
	WebElement campaignsLink;
	
	@FindBy(xpath="//*[contains(text(), 'Forms')]")
	WebElement formsLink;

	
	// Initialization
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHamePageTitle() {
		return driver.getTitle();
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
