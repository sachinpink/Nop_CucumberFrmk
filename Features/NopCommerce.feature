Feature: Login the application and adding and searching customer
@LoginApp
Scenario: Test Login function 
Given User is on Login Page
When User enters UserName and Password and click on login
Then user should Login Successfully
@AddCustomer
Scenario: Add new customer
Given User on home page 
When user click on Customers dropdown link
And User click on Customers link
And User click on AddNew link
And User fill Customer info and click on save button
Then messge should be displayed as Customer added sucessfully 

@searchCust
Scenario: Search customer
Given User on home page
When Enter name to search customer
And Click on search button
Then Customer list should be displayed in table

