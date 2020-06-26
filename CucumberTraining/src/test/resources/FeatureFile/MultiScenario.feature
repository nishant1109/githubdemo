Feature: Login function of testme app
Tests the login function


Background:
Given Adithya is on TestMe app

Scenario: Valid login
When Adithya gives valid login password
Then Adithya can see the next page

Scenario: Invalid login
When Adithya gives invalid login password
Then Adithya can see a error message

Scenario: Blank Login
When Adithya clicks on login without any data
Then Adithya can see another error message