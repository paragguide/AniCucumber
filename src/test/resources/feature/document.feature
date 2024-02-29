Feature: amazon project feature file
  I want to use this for amazon project
  @amazon @uid
  Scenario: Amazon Uid test
    Given I open browser "chrome" and enter url "https://www.amazon.in/"
    And i click on sign in
    When I enter userid "paragguide@yahoo.co.in"
    And click continue button
    Then I validate userid
    And check password textbox comes
    
  @amazon @pwd  
  Scenario: Amazon Pwd test  
    Given uid is valid and pwd displayed
    When i enter password "RMinfotech"
    And click submit button
    Then i should login
    
  @amazon @search
  Scenario Outline: Amazon Product search
    Given you are logged in
    When i search product <product> with price <price>
    Then result comes
    
   Examples:
   |product|price|
   |mobile|15000|
   |Lcd| 40000|
   |shirt| 3000|
  