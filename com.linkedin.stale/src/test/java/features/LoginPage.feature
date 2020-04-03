@LoginPage
Feature: Verify login in linkedin feature

@Functional 
Scenario: Verify existing user of linkedin is able to login successfully using valid credentials
	Given user is navigated to Login Page
	When user enters username and password on login page
	And user clicks signin button
	Then user lands on home page of linkedin

@Functional @StaleCheck
Scenario: Verify staleness on linkedin by refreshing browser after providing login details and try to provide login details and signin
	Given user is navigated to Login Page of linkedin
	When user enters username and password on login page of linkedin
	And user refreshes browser and provides username and password
	And user clicks signin button of linkedin
	Then user lands on home page of linkedin and verifies title