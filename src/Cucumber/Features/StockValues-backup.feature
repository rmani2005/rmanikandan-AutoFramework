#Author: rmani2005@gmail.com

@smoke, @regression
Feature: Login to the CNBC site and fetch different stock index


@core, @login, @Blocker
  Scenario: login into the CNBC site through Google
    Given Open the Chrome browser and maximize it
    And Navigate to test env and test_url site
    When Ensure the browser is open and navigate to test_url and CNBC    

@core, @login, @Blocker
  Scenario Outline: login into the CNBC site through Google
    Given Open the <browser> browser and maximize it
    And Navigate to <browser> env and <url> site
    When Ensure the browser is open and navigate to <url> and <title>
    And Check the site is reachable
    
Examples: 
      | browser		| env		|	url 			| title		|
      | Chrome		| test	| test_url	| Google	|	
      | Chrome		| test	| dev_url	| Google	|	
      | Chrome		| test	| test_url	| Google	|	
      | Chrome		| test	| test_url	| Google	|
      | Chrome		| test	| test_url	| Google	|	

  @core, @login, @Blocker
  Scenario Outline: login into the CNBC site through Google
    Given Open the <browser> browser and maximize it
    And Navigate to <browser> env and <url> site
    When Ensure the browser is open and navigate to <url> and <title>
    And Check the site is reachable
    And enter the <serach_str>
    And click on the search button
    Then Ensure the result is displayed
    And Click on the first search result
    Then Ensure the targeted site is open and navigate to <url> and <title>
    And Check the <stock_search> is present
    And Fetch the <stock_search> value and append or store in text file
    And Fetch the <stock_search> value and append or store in excel file

Examples: 
      | browser		| env		|	url 			| title		| serach_str	| stock_search	|
      | Chrome		| test	| test_url	| Google	|	CNBC				| NASDAQ				|
      | Chrome		| test	| dev_url	| Google	|	CNBC				| S & P 				|
      | Chrome		| test	| test_url	| Google	|	CNBC				| CNBC					|
      | Chrome		| test	| test_url	| Google	|	CNBC				| CNBC					|
      | Chrome		| test	| test_url	| Google	|	CNBC				| CNBC					|
      

Need to Copy to original file     
@core, @login, @Blocker
Scenario: login into the CNBC site through Google
    Given Open the Chrome browser and maximize it
    And Navigate to test env and test_url site
    When Ensure the browser is open and navigate to test_url and CNBC
    
@core, @login, @Blocker
Scenario Outline: login into the CNBC site through Google
    Given Open the Chrome browser and maximize it
    And Navigate to "browser" env and "url" site
   
Examples: 
      | browser		| env		|	url 			| title		|
      | Chrome		| test	| test_url	| Google	|	
      | Chrome		| test	| dev_url		| Google	|	
      
      
#Finall list
@smoke, @regression
Feature: CNBC site and stock validationx

@smoke
Scenario: CNBC site validation - Smoke
    Given Open the Chrome browser and maximize it
    And Navigate to "Chrome" env and "test_url" site
		And Close the browsers

		
@core, @login, @Blocker, @regression
Scenario Outline: CNBC site validation
    Given Open the Chrome browser and maximize it
    And Navigate to "<browser>" env and "<url>" site
   	And Fetch the "<search_value>" in CNBC site and store the same
   	And Check the "<title>" is displayed
   	And Close the browsers

Examples: 
      | browser		| url 			| title		| search_value	| title |
      | Chrome		| test_url	| Google	|	S&P 500 | Stock Markets, Business News, Financials, Earnings - CNBC |
			| Chrome		| test_url	| Google	|	NASDAQ | Stock Markets, Business News, Financials, Earnings - CNBC |
			| Chrome		| dev_url		| Google	|	VIX | Stock Markets, Business News, Financials, Earnings - CNBC |
			

			

      