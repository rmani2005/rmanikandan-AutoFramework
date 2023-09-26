package Cucumber.stepDefinition;
 

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.firefox.FirefoxDriver;

import POMFramework.BaseClass.baseClass;
import POMFramework.test.POMTestCNBC;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class stepdefinition extends baseClass { 
   WebDriver driver = null; 
   String test_url = "https://www.google.com/";
   String dev_url = "https://www.CNBC.com/";
   String appURL = "test";
    
   
   
   @Given("^Open the Chrome browser and maximize it$")
   public void open_the_Chrome_browser_and_maximize_it() throws Throwable {
       // Write code here that turns the phrase above into concrete actions
	  
	   System.out.println("+++++++++ Step Definition is invoked +++++++++");
	  
	   
	   if(appURL.equalsIgnoreCase("test"))
		   beforeTestCondif("chrome", test_url);
	   else
		   beforeTestCondif("chrome", dev_url);
	   driver=getDriver();
		  
   }

   @Given("^Navigate to \"(.*)\" env and \"(.*)\" site$")
   public void navigate_to_test_env_and_test_url_site(String env, String url) throws Throwable {
       // Write code here that turns the phrase above into concrete actions
     
	   System.out.println("+++++++++ Step Definition for Browser navigating to URL is invoked +++++++++");
	   if(appURL.equalsIgnoreCase("test"))
		   driver.get(test_url);
	   else
		   driver.get(dev_url);
   }
   
   @When("Fetch the \"(.*)\" in CNBC site and store the same$")
   public void ensure_the_(String search_value) 
   {
       // Write code here that turns the phrase above into concrete actions
	   try {
		POMTestCNBC.TC001_Check_the_CNBC_for_NASDAC(search_value);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
   }
  
   @Given("Check the {string} is displayed")
   public void check_the_title_is_displayed(String titlestring) {
       // Write code here that turns the phrase above into concrete actions
	   //Stock Markets, Business News, Financials, Earnings - CNBC

	   //assert.assertEquals((Object)titlestring, (Object)getDriver().getTitle().trim());
	   boolean boo=titlestring.equalsIgnoreCase(getDriver().getTitle().trim());
	   System.out.println("Title is from Application-" + getDriver().getTitle().trim());
	   System.out.println("Title is from Datatable-" + titlestring);
	   System.out.println("Title is matching-" + boo);
	   //assert.assertEquals(titlestring, titlestring);
   }
   @Given("Close the browsers")
   public void close_the_browsers() {
       // Write code here that turns the phrase above into concrete actions
    getDriver().quit();
   }

   @Given("Fetch the search_value from the site")
   public void featch_values_dataTableConcepts(DataTable data) 
   {
       // Write code here that turns the phrase above into concrete actions\
	 //Initialize data table 
	      @SuppressWarnings("rawtypes")
		List<List<String>> datafromDatatable = data.asLists();
	      System.out.println("Row number 1 and Item number 1 - " + datafromDatatable.get(1).get(1)); 
	      System.out.println("Row number 1 and Item number 2 - " + datafromDatatable.get(1).get(2));
	      System.out.println("Row number 1 and Item number 3 - " + datafromDatatable.get(1).get(3));
	      System.out.println("Row number 1 and Item number 4 - " + datafromDatatable.get(1).get(4));
	      //System.out.println("Row number 1 and Item number 5 - " + datafromDatatable.get(1).get(5));
	      
	      for (List<String> list : datafromDatatable.subList(1, datafromDatatable.size())) 
	      {
			Iterator<String> itr=list.iterator();
			while(itr.hasNext())
			{
				System.out.println("Item ffrom dataTable ni iterator - " + itr.next().toString());
			}
			try {
			POMTestCNBC.TC001_Check_the_CNBC_for_NASDAC(list.get(3));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	      }
	      
   }
   
}