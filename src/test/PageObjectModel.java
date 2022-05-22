package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Import package pageObject.*

import pages.Home_Page;

import pages.LogIn_Page;

public class PageObjectModel {

	private static WebDriver driver = null;

	String browser = "Chrome";
	String currDir=System.getProperty("user.dir");
	String driverPath=currDir+"/src/drivers/";
	
	@BeforeTest
	public void beforeTestCondif() {

		if (browser.equalsIgnoreCase("Chrome")) 
		{
			String chromeDriverPath=driverPath+"chromedriver";
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver=new ChromeDriver();  
			
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.store.demoqa.com");
		}
	}

	@Test
	public void firstTC() throws InterruptedException {

		// Use page Object library now
		driver.get("https://www.google.com");
				
	//	Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_SearchBox(driver).sendKeys("cnbc news");
		LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		//LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");
		Thread.sleep(5000);
		//LogIn_Page.txtbx_SearchButton(driver).click();
		//LogIn_Page.txtbx_SearchButton(driver).sendKeys(Keys.ENTER);;
		LogIn_Page.cnbc_link(driver).click();
		
		
		System.out.println("NASDAX Percentage: " + LogIn_Page.nasdax_percentage(driver).getText());

		
		
		System.out.println(" Search Successfully");

		//Home_Page.lnk_LogOut(driver).click();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//driver.quit();

	}
	
	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		
	}


}