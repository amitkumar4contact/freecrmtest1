package com.crm.qa.pages;

import javax.security.auth.kerberos.KerberosKey;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class CommonPage extends TestBase {
	public static WebElement element;
	public static WebElement toolTipElement;
	Actions toolAct;

	@FindBy(xpath = "//*[@class='ui basic button floating item dropdown']")
	WebElement settingdropdownLink;

	@FindBy(xpath = "//*[contains(text(), 'Settings')]")
	WebElement settingLink;

	@FindBy(xpath = "//*[contains(text(), 'Products')]")
	WebElement productsLink;

	@FindBy(xpath = "//*[contains(text(), 'Import')]")
	WebElement importLink;

	@FindBy(xpath = "//*[contains(text(), 'Tools')]")
	WebElement toolsLink;

	@FindBy(xpath = "//*[contains(text(), 'Log Out')]")
	WebElement logoutLink;

	@FindBy(xpath = "//*[contains(text(), 'Amit Kumar')]")
	WebElement userNameLabel;
	
	@FindBy(xpath = "//*[@placeholder='Search']")
	WebElement searchBox;
	
	@FindBy(xpath = "//*[@class='ui basic button item']")
	WebElement deleteButton;

	public boolean verifyCorrectUserName() {
		System.out.println(userNameLabel.getText());
		return userNameLabel.isDisplayed();
	}

	public void settingsPannelBeta() {
		String s = "This is Beta software and as such, will contain bugs. We are working to resolve all issues.";
		toolAct = new Actions(driver);
		element = driver.findElement(By.xpath("//*[contains(text(), 'Beta')]"));
		toolAct.moveToElement(element).build().perform();
		toolTipElement = driver
				.findElement(By.xpath("//*[@class='ui bottom center inverted popup transition visible']"));
		String toolTipText = toolTipElement.getText();
		Assert.assertEquals(s,
				"This is Beta software and as such, will contain bugs. We are working to resolve all issues.");
		System.out.println(toolTipText);
	}

	public SettingsPage validateSettingsPannelDropdownSettingButton() {
		settingdropdownLink.click();
		settingLink.click();
		return new SettingsPage();

	}

	public ProductsPage validateProductsPannelDropdownSettingButton() {
		settingdropdownLink.click();
		productsLink.click();
		return new ProductsPage();

	}

	public ImportPage validateImportPannelDropdownSettingButton() {
		settingdropdownLink.click();
		importLink.click();
		return new ImportPage();

	}

	public ToolsPage validateToolsPannelDropdownSettingButton() {
		settingdropdownLink.click();
		toolsLink.click();
		return new ToolsPage();

	}

	public LoginPage validateLogoutPannelDropdownSettingButton() {
		settingdropdownLink.click();
		logoutLink.click();
		return new LoginPage();

	}
	
	public SearchResultPage validateSearchPannelDropdownSettingButton() {
		searchBox.sendKeys("amit");
		searchBox.sendKeys(Keys.ENTER);
		return new SearchResultPage();

	}
	
	public RecycleBinPage validateSearch() {
		deleteButton.click();
		return new RecycleBinPage();

	}

}
