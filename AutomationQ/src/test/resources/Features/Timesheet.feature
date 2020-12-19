@UITest
Feature: To automate the Online Timesheet 
@Smoke
Scenario: To create a New User in the application
	Given Open browser and navigate to the Url
	When In the HomePage Enter the valid username and password 
	Then User should be able to Login
	And Verify the user is able to login successfully
    Then Click on Employee Details 
    And Create a new user by clicking on the link
    Then Fill the details and create the user
    And Message displayed Employee Details saved sucessfully
    Then User will navigate to logout
    And Message displayed You have been logged out
    Then Close the browser
@riya  
Scenario: Update details
    Given Open browser and navigate to the Url
	When In the HomePage Enter the valid username and password 
	Then User should be able to Login
	And Verify the user is able to login successfully
    Then Click on Employee Details 
    And Go to edit employee 
    Then User will update new email ID
    And Message displayed Employee Details updated Successfully
    Then User will Validate the updated Email id
    Then User will navigate to logout
    And Message displayed You have been logged out
    Then Close the browser
