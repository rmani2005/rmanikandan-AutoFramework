package pages;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

public class LogIn_Page {

        private static WebElement element = null;

        public static WebElement txtbx_SearchBox(WebDriver driver){

            element = driver.findElement(By.xpath("//input[@name='q']"));

            return element;

            }
        
        public static WebElement txtbx_SearchButton(WebDriver driver){

            element = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));

            return element;

            }
        
        public static WebElement cnbc_link(WebDriver driver){

            element = driver.findElement(By.xpath("//a[@href='https://www.cnbc.com/']"));

            return element;

            }

        public static WebElement nasdax_percentage(WebDriver driver){

            element = driver.findElement(By.xpath("//span[contains(text(),'NASDAQ')]//ancestor::div[contains(@class,'MarketCard-row')]//following-sibling::div//div//span[2]"));

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