Feature: Google Search 
Scenario: Search for Cucumber BDD 
Given User is on Google Home Page
When User searches for "Cucumber BDD"
Then Results should contain "Cucumber"