package POMFramework.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import POMFramework.BaseClass.baseClass;
import POMFramework.BaseClass.myRetry;
import POMFramework.Pages.Home_Page;
import POMFramework.Pages.LogIn_Page;
import de.redsix.pdfcompare.FileUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.*;

public class POMValidations extends baseClass{



	
	@Severity(SeverityLevel.BLOCKER)
	@Description("TC001_Valdaition types - assertEquals")
	@Story("Valdaition types - assertEquals")	
	@Test(groups = {"valdiation"}, 
	invocationCount=1, 
	description="Valdaition types - assertEquals", 
	enabled=true,
	retryAnalyzer=myRetry.class)
	public void TC1_AssertEquals() {

	  //WebDriverManager.chromedriver().setup();

	  //WebDriver driver = new ChromeDriver();
	  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, "AutomationByte - Handcrafted Practice Material");
	  System.out.println("Actual Title :: " + actualTitle);
	        
	}
	
		//@Listeners("TestListener.class")
		@Severity(SeverityLevel.CRITICAL)
		@Description("TC002_Valdaition types - assertNotEquals ")
		@Story("Valdaition types - assertNotEquals")	
		@Test(groups = {"valdiation"}, 
			invocationCount=1, 
			description="Valdaition types - assertNotEquals", 
			enabled=true,
			retryAnalyzer=myRetry.class)
		public void TC2_AssertNotEquals() {
		  
		 // WebDriverManager.chromedriver().setup();

		 // WebDriver driver = new ChromeDriver();
		  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
		  String actualTitle = driver.getTitle();
		  Assert.assertNotEquals(actualTitle, "AutomationByte - Handcrafted Practice Material");
		  System.out.println("Actual Title :: " + actualTitle);

		}
	
		//@Listeners("TestListener.class")
		@Severity(SeverityLevel.NORMAL)
		@Description("TC003_Valdaition types - assertTrue ")
		@Story("Valdaition types - assertTrue")	
		@Test(groups = {"valdiation"}, 
			invocationCount=1, 
			description="TC003_Valdaition types - assertTrue", 
			enabled=true,
			retryAnalyzer=myRetry.class)
			public void TC3_AssertTrue() {
			  
			 // WebDriverManager.chromedriver().setup();

			 // WebDriver driver = new ChromeDriver();
			  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
			  boolean isElementEnabled = driver.findElement(By.id("urFirstname")).isEnabled();
			  Assert.assertTrue(isElementEnabled);
			  System.out.println("isElementEnabled :: " + isElementEnabled);

			}
		
		//@Listeners("TestListener.class")
		@Severity(SeverityLevel.NORMAL)
		@Description("TC4_AssertFalse")
		@Story("AssertFalse")	
		@Test(groups = {"valdiation"}, 
			invocationCount=1, 
			description="TC4_AssertFalse", 
			enabled=true,
			retryAnalyzer=myRetry.class)
		public void TC4_AssertFalse() {
		  
		 // WebDriverManager.chromedriver().setup();

		 // WebDriver driver = new ChromeDriver();
		  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
		  boolean isElementEnabled = driver.findElement(By.id("urFirstname")).isEnabled();
		  Assert.assertFalse(isElementEnabled);
		  System.out.println("isElementEnabled :: " + isElementEnabled);

		}
		
		//@Listeners("TestListener.class")
				@Severity(SeverityLevel.NORMAL)
				@Description("TC5_AssertNull")
				@Story("AssertFalse")	
				@Test(groups = {"valdiation"}, 
					invocationCount=1, 
					description="TC5_AssertNull", 
					enabled=true,
					retryAnalyzer=myRetry.class)
		public void TC5_AssertNull() {
		  
		  //WebDriverManager.chromedriver().setup();

		 // WebDriver driver = new ChromeDriver();
		  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
		  String actualUrl = driver.getTitle();
		  Assert.assertNull(actualUrl);
		  System.out.println("actualUrl :: " + actualUrl);

		}
				
		//@Listeners("TestListener.class")
		@Severity(SeverityLevel.NORMAL)
		@Description("TC5_AssertNull")
		@Story("AssertFalse")	
		@Test(groups = {"valdiation"}, 
			invocationCount=1, 
			description="TC5_AssertNull", 
			enabled=true,
			retryAnalyzer=myRetry.class)
		public void TC6_AssertNotNull() {
		  
		 // WebDriverManager.chromedriver().setup();

		 // WebDriver driver = new ChromeDriver();
		  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
		  String actualUrl = driver.getTitle();
		  Assert.assertNotNull(actualUrl);
		  System.out.println("actualUrl :: " + actualUrl);

		}		
				
		
		//@Listeners("TestListener.class")
				@Severity(SeverityLevel.NORMAL)
				@Description("TC7_SoftAssert")
				@Story("AssertFalse")	
				@Test(groups = {"softvaldiation"}, 
					invocationCount=1, 
					description="TC7_SoftAssert", 
					enabled=true,
					retryAnalyzer=myRetry.class)
	    public void TC7_SoftAssert() {

	       // WebDriverManager.chromedriver().setup();

					SoftAssert softAssert = new SoftAssert();
					
	        //WebDriver driver = new ChromeDriver();
	        driver.get("https://practice.automationbyte.com/forms/basic-form-1");

	        String actualTitle = driver.getTitle();
	        softAssert.assertEquals(actualTitle, "AutomationByte - Handcrafted Practice Material");

	        boolean isElementEnabled = driver.findElement(By.id("urFirstname")).isEnabled();
	        softAssert.assertFalse(isElementEnabled);

	        softAssert.assertNotNull(driver.getCurrentUrl());

	        softAssert.assertAll();

	    }
		
		
	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
		
	}
	
	
	
	
	
	
}