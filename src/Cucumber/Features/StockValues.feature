#Author: rmani2005@gmail.com
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
			

@cucu-datatable
Feature: CNBC site and stock validationx

@cucu-datatable
Scenario: CNBC site validation - Smoke
    Given Open the Chrome browser and maximize it
    And Navigate to "Chrome" env and "test_url" site
    And Fetch the search_value from the site
      | browser		| url 			| title		| search_value	| title |
      | Chrome		| test_url	| Google	|	S&P 500 | Stock Markets, Business News, Financials, Earnings - CNBC |
      | Chrome		| test_url	| Google	|	NASDAQ | Stock Markets, Business News, Financials, Earnings - CNBC |
			| Chrome		| dev_url		| Google	|	VIX | Stock Markets, Business News, Financials, Earnings - CNBC |      
		And Close the browsers