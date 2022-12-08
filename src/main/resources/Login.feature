@SmokeTest
Feature: Login fuction test
@Tc-123
Scenario: As a luma aplication user,must do succesfull login with valid creadential.
Given open any browser
And go to application URL
When click sign in button
And put email
And put Password 
And click second sign in button
Then validate login was successful
