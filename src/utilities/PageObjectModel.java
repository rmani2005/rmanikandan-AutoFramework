package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMFramework.Pages.Home_Page;
import POMFramework.Pages.LogIn_Page;

public class PageObjectModel {

	private static WebDriver driver = null;

	String browser = "Chrome";
	String currDir=System.getProperty("user.dir");
	String driverPath=currDir+"/src/drivers/";
	
	@BeforeTest
	public void beforeTestCondif() {

		if (browser.equalsIgnoreCase("Chrome")) 
		{
			String driverPath=currDir+"chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver=new ChromeDriver();  
			
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("https://www.store.demoqa.com");
		}
	}

	@Test
	public void firstTC() {

		// Use page Object library now

		Home_Page.lnk_MyAccount(driver).click();

		LogIn_Page.txtbx_UserName(driver).sendKeys("testuser_1");

		LogIn_Page.txtbx_Password(driver).sendKeys("Test@123");

		LogIn_Page.btn_LogIn(driver).click();

		System.out.println(" Login Successfully, now it is the time to Log Off buddy.");

		Home_Page.lnk_LogOut(driver).click();

		driver.quit();

	}
	
	@AfterTest
	public void tearDown() {

		driver.close();
		driver.quit();
		
	}


}