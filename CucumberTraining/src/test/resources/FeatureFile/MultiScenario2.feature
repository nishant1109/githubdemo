Feature: Login function of Demoweb shop app
Tests the login function of Demo webshop


Background:
Given Adithya is on Demowebshop app

Scenario: Valid login to Demoweb shop
When Adithya gives valid credentials to Demowebshop
Then Adithya can view the next page of Demowebshop

Scenario: Invalid login to Demoweb shop
When Adithya gives invalid credentials to Demowebshop
Then Adithya can get a error message from Demowebshop
