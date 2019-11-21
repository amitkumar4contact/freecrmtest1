package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	
	//Object repository.
	@FindBy(xpath="//*[@class='ui header item mb5 light-black']")
	@CacheLookup // it ll create a cache memory, where it ll store the webelements. It should be used for improve the script performance. It should be used when element addredd do no chnage constantly.
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[contains(text(), 'New')]")
	WebElement newContactButton;
	
	@FindBy(xpath="//*[@name='first_name']")
	WebElement firstName;
	
	@FindBy(xpath="//*[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//*[contains(text(), 'Save')]")
	WebElement saveButton;
	
	// Initialization
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	//action
	public boolean verifyContactLabel() {
		return contactsLabel.isDisplayed();
		
	}
	public void selectContactsByName(String name) {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='ui celled sortable striped table custom-grid table-scroll']/tbody/tr/td"))).click();
		driver.findElement(By.xpath("//*[contains(text(), '"+name+"')]")).click();
		
	}
	
	public void clickOnNewContact() {
		newContactButton.click();
		
	}
	
	public void createNewContact(String firstname, String lastname) {
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		saveButton.click();
		
	}

	
	
	
	
	
}
