package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.netty.util.Timeout;

public class googleSearch {

	public WebDriver driver=null;
	String currDir=System.getProperty("user.dir");
	String driverPath=currDir+"/src/drivers/";
	String chromeDriverPath=driverPath+"chromedriver";
	
	@BeforeClass
	void PreCond() throws IOException
	{
		//Setup the Chromedriver
		
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		
		
		//Reading textfile
		String fileName = currDir+"/src/source.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		while((line = br.readLine()) != null){
		    //process the line
		    System.out.println(line);
		}
		
		//Reading Excel file
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void search()
	{
		
		String searchStr="Spotify Stock Rate";
		String url="www.google.com";
		//System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		//driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(url);
		driver.navigate().to(url);
		
		//driver.
	
		//   Search Bar   - //input[@name='q']
		//   Login Button - //input[@name='btnK']
	
		WebElement ele = driver.findElement(By.xpath("//input[@name='q']"));
		//ele.click();	
		
		
	}
	
}

