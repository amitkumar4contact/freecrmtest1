package com.crm.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class CommonPage extends TestBase{
	public static WebElement element;
	public static WebElement toolTipElement;
	
	

	public LoginPage settings() {
    Actions toolAct = new Actions(driver);
    element = driver.findElement(By.xpath(".//*[@id='age']"));
    toolAct.moveToElement(element).build().perform();
    driver.findElement(By.cssSelector(".ui-tooltip"));
    String toolTipText = toolTipElement.getText();
    System.out.println(toolTipText);
    return LoginPage();
	}

}
