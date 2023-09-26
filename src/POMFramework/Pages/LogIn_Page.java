package POMFramework.Pages;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.BaseClassFinder;

import POMFramework.BaseClass.baseClass;

public class LogIn_Page extends baseClass
{

        private static WebElement element = null;

        
        public static WebElement txtbx_SearchBox(WebDriver driver){

            element = driver.findElement(By.xpath("//*[@name='q']"));

            return element;

            }
        
        public static WebElement txtbx_SearchButton(WebDriver driver){

            element = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));

            return element;

            }
        
        /* Recovery Scenario concepts
        void ClickAndRecover(element){
			  try { driver.FindElement(element).Click(); }
			  catch (couldnt click) { Recover(); }
        */
        
        public static WebElement search_link_snippet_recovery(WebDriver driver)
        {
        	try
        	{
        	 element = driver.findElement(By.xpath("//h2[contains(text(),'Featured snippet')]/ancestor::div[1]//following-sibling::div//a"));
        			
        	}catch(Exception ee) //Recovery Scenario
        	{
        		System.out.println("No Such Element, so Recovery SCenario triggered");
        		element = driver.findElement(By.xpath("//h2[contains(text(),'Web Result with Site Links')]/ancestor::div[1]//following-sibling::div//div/a"));
        		//org.testng.Assert.fail("you wandered onto the wrong path");
        	}

            return element;
        }
        public static WebElement cnbc_link(WebDriver driver){

            element = driver.findElement(By.xpath("//h2[contains(text(),'Web Result with Site Links')]/ancestor::div[1]//following-sibling::div//div/a"));

            return element;
          //span[contains(text(),'search_value')]//ancestor::div[contains(@class,'MarketCard-row')]//following-sibling::div//div//span[2]
            //First Snippet link
          //h2[contains(text(),'Featured snippet')]/ancestor::div[1]//following-sibling::div//a
            
            //First Snippet value
            
            //if snippet is not available, the first link has to caputures
            
            }

        public static WebElement nasdax_percentage(WebDriver driver,String stockgroup){
        	
        	try {
        		//WebDriverWait wait=new WebDriverWait(driver, 30);
        		System.out.println("+++++++++++++++++++Xpath for search is - " + stockgroup + "++++++++++++++++++++==Xpath");
				//wait.until(ExpectedConditions.VisibilityofElementLocated(By.xpath("//span[contains(text(),'NASDAQ')]//ancestor::div[contains(@class,'MarketCard-row')]//following-sibling::div//div//span[2]")));
        		element = driver.findElement(By.xpath("//span[contains(text(),'"+stockgroup+"')]//ancestor::div[contains(@class,'MarketCard-row')]//following-sibling::div//div//span[2]"));

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            return element;

            }
        
      
        
    public static WebElement txtbx_UserName(WebDriver driver){

         element = driver.findElement(By.id("log"));

         return element;

         }

     public static WebElement txtbx_Password(WebDriver driver){

         element = driver.findElement(By.id("pwd"));

         return element;

         }

     public static WebElement btn_LogIn(WebDriver driver){

         element = driver.findElement(By.id("login"));

         return element;

         }

}