Feature: Login into Application

Scenario Outline: Positive test validation login
Given Initialized the browser with chrome
And Navigate to "http://QAClickAcademy.com" Site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that user is successfully logged in
And close browsers

Examples:
|username				|password		|
|vladimirkon@gmail.com	|Kharkov@1965	|
|test123@gmail.com		|12345	|