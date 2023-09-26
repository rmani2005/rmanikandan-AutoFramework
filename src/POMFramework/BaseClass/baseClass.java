package POMFramework.BaseClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.NoSuchElementException;

import javax.print.DocFlavor.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;

public class baseClass extends wrappermethods
{

	
	protected static WebDriver driver = null;

	public String browser = "";
	//String browser = "";
	public static String appURL = "";
	//public String appURL = "https://www.google.com";
	//ExtentReports reports = new ExtentReports("Path of directory to store the resultant HTML file", rue/faltse);
	//ExtentTest test = reports.startTest("TestName");
	//Fluent wait impl
		
	protected FluentWait flu=null;
			
	//Explicit wait impl
	WebDriverWait wait=null;
	//Explicit wait impl
	protected static WebDriverWait explicitwait=null;
	
	 String[] str_urlarr =
		    {
		        "https://phptravels.com/demo/",
		        "http://the-internet.herokuapp.com/javascript_alerts",
		        "http://the-internet.herokuapp.com/dynamic_content?with_content=static",
		        "https://phptravels.com/demo/",
		        "https://jqueryui.com/spinner/",
		        "https://lambdatest.github.io/sample-todo-app/"
		    };

		static String currDir=System.getProperty("user.dir");
		String driverPath=currDir+"/src/POMFramework/Drivers/";
		protected static String stackFileName = currDir + "/output/NASDAXStack.txt";
		protected String stackFileNameJavaSearch = currDir + "/output/NASDAXStack-JavaSearch.txt";
		String reportFolder =currDir+"/src/report/";
		int type = 0;
		protected static String dateTimenow = "";
		public String hostname="http://localhost";
		//public String hostname="";
		public String portString="4445";
		public String remoteHostAddr=configSeleniumDockerHubHostAddr(getHostName(),getPort());
		
		public String configSeleniumDockerHubHostAddr(String hostname, String portString) {
			
			return hostname+"/"+portString+"/wd/hub";
		}
		
		@BeforeMethod
		@Parameters({"browser", "appURL"})
		//public void beforeTestCondif() {
		public void beforeTestCondif(String browser, String appURL) {
			System.out.println("XXXXXXXXXXXxXXXXXXXXXXXxParameter Recieved - browser : " + browser );
			System.out.println("XXXXXXXXXXXxXXXXXXXXXXXxParameter Recieved - appURL : " + appURL );
			if (browser.equalsIgnoreCase("Chrome")) 
			{
				if(type==1) 
				{
				try {
					String chromeDriverPath=driverPath+"chromedriver";
					System.setProperty("webdriver.chrome.driver", chromeDriverPath);
					driver=new ChromeDriver();  
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().window().maximize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
				try {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
					driver.manage().window().maximize();
					System.out.println("Page Loagin time: " + driver.manage().timeouts().getPageLoadTimeout());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
							
			}else if (browser.equalsIgnoreCase("Chrome-headless")) 
			{
				if(type==1) 
				{
				try {
					String chromeDriverPath=driverPath+"chromedriver";
					System.setProperty("webdriver.chrome.driver", chromeDriverPath);
					
					ChromeOptions options = new ChromeOptions();
					//options.setHeadless(true);
					
					options.addArguments("--headless=new");
					driver=new ChromeDriver(options);  
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().window().maximize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
				try {
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
					System.out.println("Page Loagin time: " + driver.manage().timeouts().getPageLoadTimeout());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
							
			} else if (browser.equalsIgnoreCase("Chrome-docker")) 
			{
				if(type==1) 
				{
					
				try {
					String chromeDriverPath=driverPath+"chromedriver";
					System.setProperty("webdriver.chrome.driver", chromeDriverPath);
					ChromeOptions options11 = new ChromeOptions();
					
					//options.setHeadless(true);
					//public static String remote_url_chrome = "http://localhost:4445/wd/hub";
					//Capabilities cap=new Capabilities(driver);
					//ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
					driver= new RemoteWebDriver((CommandExecutor) new URL(remoteHostAddr), options11);
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().window().maximize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else {
				try {
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					//driver=new ChromeDriver();
					driver= new RemoteWebDriver((CommandExecutor) new URL(remoteHostAddr), options);
					
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
					System.out.println("Page Login time: " + driver.manage().timeouts().getPageLoadTimeout());
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
							
			} else if (browser.equalsIgnoreCase("firefox")) {
				try {
					driver = new FirefoxDriver();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
					driver.get("https://www.store.demoqa.com");
					driver.manage().window().maximize();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				else if (browser.equalsIgnoreCase("firefox-docker")) {
					try {
						driver = new FirefoxDriver();
						FirefoxOptions options = new FirefoxOptions();
						driver= new RemoteWebDriver((CommandExecutor) new URL(remoteHostAddr), options);
						
						driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
						//driver.get("https://www.store.demoqa.com");
						driver.manage().window().maximize();
					} catch (Exception e) {
						e.printStackTrace();
					}
			}
			
			this.appURL=appURL;
			
			flu=new FluentWait(driver)
					.withTimeout(Duration.ofSeconds(90))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class);
			
			
			//Explicit wait impl
			explicitwait=new WebDriverWait(driver, Duration.ofSeconds(40), Duration.ofSeconds(10));
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	//Expected condition
	
	
	 
	 
	 
	 
	 
	 public static ExpectedCondition<WebElement> elementToBeClickable​(By locator)
	{
		
		//List of Expected Conditions
		/*
		titleContains​(java.lang.String title)
		elementToBeClickable​(By locator)
		elementToBeClickable​(WebElement element)
		presenceOfElementLocated​(By locator)
		
		visibilityOf​(WebElement element)
		invisibilityOf​(WebElement element)
		
		frameToBeAvailableAndSwitchToIt​(int frameLocator)
		
		
		*/
		
		return null;
	}
	
	//To test in the Browserstack
	  public void testSetUp() throws MalformedURLException {
	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability("build", "[Java] Testing Expected Conditions with Selenium");
	        capabilities.setCapability("name", "[Java] Testing Expected Conditions with Selenium");
	        capabilities.setCapability("platformName", "Windows 10");
	        capabilities.setCapability("browserName", "Chrome");
	        capabilities.setCapability("browserVersion","latest");
	        capabilities.setCapability("tunnel",false);
	        capabilities.setCapability("network",true);
	        capabilities.setCapability("console",true);
	        capabilities.setCapability("visual",true);
	 
	       // driver = new RemoteWebDriver(new URL("http://" + username + ":" + access_key + "@hub.lambdatest.com/wd/hub"),
	       //         capabilities);
	        System.out.println("Started session");
	    }
	 
	public static String getDateTime(String format)
	{
		
		//Base format - String format = "dd-MM-yyyy hh:mm:ss";
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat(format) ;
		dateFormat.format(date);
		System.out.println(dateFormat.format(date));
		return (String) dateFormat.format(date);
	}
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		System.out.println(result.getMethod().getMethodName() + " failed!");
		
		ITestContext context = result.getTestContext();
		WebDriver driver = (WebDriver) context.getAttribute("driver");
		saveFailureScreenShot(driver);
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static String capture(WebDriver driver) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File("src/../BStackImages/" + System.currentTimeMillis()
		+ ".png");
		String errflpath = Dest.getAbsolutePath();
		//FileUtils.copyFile(scrFile, Dest);
		return errflpath;
		}

	public void setHostName(String hostname)
	{
		this.hostname=hostname;
	}
	
	public String getHostName()
	{
		return hostname;
	}
	

	public void setHPort(String portString)
	{
		this.portString=portString;
	}
	
	public String getPort()
	{
		return portString;
	}

	public WebDriver getDriver()
    {
        return driver;
    }
 
    public void tearDownDriver()
    {
        getDriver().quit();
    }
	
	//ExpectedConditions List
	
	/*
	 * 
	 * 	explicit wait for input field field
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("input")));
	 * ExpectedConditions class can be useful in a lot of cases and provides some set of predefined condition to wait for the element. Here are some of them:
			alertIsPresent : Alert is present
			elementSelectionStateToBe: an element state is selection.
			elementToBeClickable: an element is present and clickable.
			elementToBeSelected: element is selected
			frameToBeAvailableAndSwitchToIt: frame is available and frame selected.
			invisibilityOfElementLocated: an element is invisible
			presenceOfAllElementsLocatedBy: present element located by.
			textToBePresentInElement: text present on particular an element
			textToBePresentInElementValue: and element value present for a particular element.
			visibilityOf: an element visible.
			titleContains: title contains 
	 */
    
    /*
     * 
     * get()
		getCurrentUrl()
		getTitle()
		getPageSource()
		getText()
		getTagName()
		getCssValue()
		getAttribute(String Name)
		getSize()
		close()
		quit()
     * 
     */
}
