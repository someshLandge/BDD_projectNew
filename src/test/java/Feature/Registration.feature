Feature: Registration Functionality

Scenario: Check Registration with Valid Details
Given User is navigated to Registration page
When  User Enter Valid details in FirstName
And User Enter Valid LastName
And User Enter Valid Email
And User Enter Valid telephone
And User Enter Valid Password
And User Enter valid confirm password
And User cliked on disclimer
And User Clicked on Continue
Then User should register successfully and Navigate to Account success page

