Feature: Login Page Functions

Background: Launched the Web Application and should be a registered person

Scenario:  Check whether user could able to navigate to Log-In Screen page

Given User is on Facebook Log-In Screen of the application
When  User enters valid Login Name  and Password and clicks on login button	

Then  User navigate to Facebook Home Page

Scenario:  Check whether login credentials stored on browsers local storage
 
Given User is on Facebook Home Page
When  User stores login information in local browser
Then  User able to see stored information in local browser
 
 Scenario:  Check whether user could able to Logout 

Given User is on Dashboard Screen of the application
When  User navigate to the dropdown icon upper left corner by clicks on it
And  User clicks  Logout icon 
Then  User able to logout successfully

Scenario:  Check whether after logout user could able to access friends page 

Given User is on Facebook Sign in Screen 
When  User navigate to the facebook friends page without sigin in 
Then  User gets error message 


 