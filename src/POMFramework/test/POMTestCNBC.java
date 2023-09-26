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

public class POMTestCNBC extends baseClass{

	

	//@Listeners("TestListener.class")
	@Severity(SeverityLevel.BLOCKER)
	@Description("TC001_Check_the_CNBC_for_NASDAC")
	@Story("CNBC Info bar value checks")
	
	@Test(dataProvider ="test_case_list_producer",
	groups = {"CNBCStocks"}, 
	invocationCount=1, 
	description="Check the CNBC for NASDAC", 
	enabled=false,
	retryAnalyzer=myRetry.class)
	public static void TC001_Check_the_CNBC_for_NASDAC(String value_to_search) throws InterruptedException 
	{
		
		System.out.println("XXXXXXXXXXXxTest is staring - Parameter Recieved - value_to_search : " + value_to_search );
		// Use page Object library now
		/* try {
			if(isAccessable(appURL, 30))
				driver.get(appURL);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		} */
				
		//Home_Page.lnk_MyAccount(driver).click();

		//Reading the Excel file and parameter the test data
		
		driver.get(appURL);
		LogIn_Page.txtbx_SearchBox(driver).sendKeys("cnbc news");
		LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		//LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");
		//Thread.sleep(5000);
		//LogIn_Page.txtbx_SearchButton(driver).click();
		//LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		explicitwait.until(ExpectedConditions.visibilityOf(LogIn_Page.cnbc_link(driver)));
		LogIn_Page.cnbc_link(driver).click();

		
		explicitwait.until(ExpectedConditions.visibilityOf(LogIn_Page.nasdax_percentage(driver,value_to_search)));
		String percentage = LogIn_Page.nasdax_percentage(driver,value_to_search).getText();
		System.out.println("NASDAX Percentage: " + percentage);

		//Assert.assertEquals(LogIn_Page.nasdax_percentage(driver).getText(), " ");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Alert bAlertPresent = wait.until(ExpectedConditions.alertIsPresent());
		

		//findElements method with tagName ‘iframe’
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		
		System.out.println(" Search Successfully");

		dateTimenow = getDateTime("dd-MM-yyyy hh:mm:ss");
		try {
			FileWriter fw = new FileWriter(stackFileName, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dateTimenow + "|" +value_to_search+ "|"+ percentage);
			bw.newLine();
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    


		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();

		//Validation - Soft or Hard
		//Frame
		//Shadframe
		//Extend report 
		//Loggin using log4j
		
		//BrowserStack or Saucelab execution
		//Selenium Grid or Selenium in Docker execution
		//Excel File readying
		//JSON file reading
		//API calls in ResAssured(GET,POST,PUT,DELET
		//Java
		//Java Collection Use cases
		//Java basics
		//Java Advance
		//Java SpringBoot
		//Selenium 4 features
		//
		
		//KaraterAPI Java and Aldo Javascripts using Claimscenter
		//Cucumber
		//
		
		//Docker
		//Jenkins
		
		
		//New Feature in Selenium 4
		
		//driver.get("https://www.google.com/");
		// Opens a new window and switches to new window
		if(false) {
		String windowParent=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		// Opens BrowserStack homepage in the newly opened window
		driver.navigate().to("https://www.browserstack.com/");
		//Thread.sleep(5000);
		driver.switchTo().window(windowParent);
		///Thread.sleep(5000);;
		}
		

        /* Check if the link is clicked by comparing the window title 
		String parentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
 
        while(iterator.hasNext())
        {
            String chld_window = iterator.next();
            if (!parentWindowHandle.equalsIgnoreCase(chld_window))
            {
                driver.switchTo().window(chld_window);
                System.out.println("Switched to the window where Google Store is open");
            }
        }
        
        */
		System.out.println("Title:" + driver.getCurrentUrl());
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.cnbc.com/");
        //assertEquals
        //areEqual
        //assertEqualsImpl
        
        Thread.sleep(3000);
        System.out.println("Demo of ExpectedConditions.elementToBeClickable successful\n");
		
        
        
	}
	
	
	@Test(invocationCount=1, dataProvider = "test_case_list_producer_2", groups = {"Search"}, enabled=true)
	@Severity(SeverityLevel.CRITICAL)
	@Description("TC002_Google Serach validation")
	@Story("Google Serach validation")
	public void secondTC(String search_value) throws InterruptedException {

		// Use page Object library now
		driver.get(appURL);
				
	//	Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_SearchBox(driver).sendKeys(search_value);
		LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		//LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");
		//Thread.sleep(5000);
		//LogIn_Page.txtbx_SearchButton(driver).click();
		//LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		String textCapture = LogIn_Page.search_link_snippet_recovery(driver).getText();
				
		System.out.println("NASDAX Percentage: " + textCapture);

		//Assert.assertEquals(LogIn_Page.nasdax_percentage(driver).getText(), " ");
				
		System.out.println(" Search Successfully");

		try {
			dateTimenow = getDateTime("dd-MM-yyyy hh:mm:ss");
			
			FileWriter fw = new FileWriter(stackFileNameJavaSearch, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(dateTimenow + "|" +search_value+ "|"+  textCapture);
			bw.newLine();
			bw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		//New Feature in Selenium 4
		
		//driver.get("https://www.google.com/");
		// Opens a new window and switches to new window
		String windowParent=driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		// Opens BrowserStack homepage in the newly opened window
		driver.navigate().to("https://www.browserstack.com/");
		Thread.sleep(5000);
		driver.switchTo().window(windowParent);
		Thread.sleep(5000);
	}
	
	
	@Test
	public void TC1_AssertEquals() {

	  WebDriverManager.chromedriver().setup();

	  WebDriver driver = new ChromeDriver();
	  driver.get("https://practice.automationbyte.com/forms/basic-form-1");
	  String actualTitle = driver.getTitle();
	  Assert.assertEquals(actualTitle, "AutomationByte - Handcrafted Practice Material");
	  System.out.println("Actual Title :: " + actualTitle);
	        
	}
	
	
	
	@AfterMethod
	public void tearDown() {

		driver.close();
		driver.quit();
		
	}
	
	@DataProvider(name="test_case_list_producer")
	public String[][] testcaseproducer(){
		
		String[][] object = null;
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm") ;
		dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		//
		//After 4 PM EST
		try {
			if(dateFormat.parse(dateFormat.format(date)).after(dateFormat.parse("09:30")) && dateFormat.parse(dateFormat.format(date)).before(dateFormat.parse("16:00"))) 
			{
				String[][] object2 = {{"DJIA"},{"S&P 500"},{"NASDAQ"},{"VIX"}};
				object=object2;
			}
			else {
				String[][] object1 = {{"S&P FUT*"},{"DOW FUT*"},{"NAS FUT*"},{"OIL*"},{"US 10-YR"}};
				object=object1;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		//ReadExcel file and convert to two array
		
		
		//Java concepts
		String[][] object2 = {{"Serilization in Java"},{"Object definition in Java"},{"Encasulation"}};
		
		return object;
	}
	
	@DataProvider(name="test_case_list_producer_2")
	public String[][] testcaseproducer_search(){

		
		String[][] object = {{"CNBC"},{"Serilization"}};
		
		//ReadExcel file and convert to two array
		
		
		//Java concepts
		String[][] object2 = {{"Serilization in Java"},{"Object definition in Java"},{"Encasulation"}};
		
		return object;
	}
	
	
	
	
}