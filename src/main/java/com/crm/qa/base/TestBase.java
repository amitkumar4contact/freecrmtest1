package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public WebDriverWait wait;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	
	public TestBase(){
		
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\amitk\\eclipse-workspace\\freeCRMpractice\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Project Files\\chromedriver.exe");
			driver = new ChromeDriver();
			
		/*else is used to execute set of code if 
		 * "if" is 'false'. elseif is used execute 
		 * another set of code if 'if' is false.
		 * e.g:
		 * if (condition1) {
          // block of code to be executed if condition1 is true
            } else if (condition2) {
          // block of code to be executed if the condition1 is false and condition2 is true
          } else {
          // block of code to be executed if the condition1 is false and condition2 is false
          }*/	
		}else if(browsername.equals("ff")) {
			System.setProperty("webdriver.gecko.driver","D:\\Eclipse Files\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//This is Explicit wait, meaning wait for certain condition to fulfill. This applies when called. It is recommended to use when the elements are taking long time to load.
		
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		
		/*This is like Thread.sleep(), but this is not prefered. We can also use ExpectedCondtions
		 * to wait until certain element appears. It throws ElementNotVisibleException*/
		
		
		//This is Implicit wait, i.e. wait for a given time. This applies to all element.It is recommended to use when the elements are located with the time frame specified in implicit wait
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		//There is also Fluent wait meaning Setting up a repeat cycle with the time frame to verify/check the condition at the regular interval of time
		/*Wait wait = new FluentWait(WebDriver reference).withTimeout(timeout, SECONDS).pollingEvery(timeout, SECONDS).ignoring(Exception.class);*/
		
		driver.get(prop.getProperty("url"));
		
		
	}

}
