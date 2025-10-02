#Author: Abhishek Rangaswamy
Feature: Automate Course Navigation and Validation

  Scenario: Open the application and verify the signup page is displayed
    Given access the application URL "https://freelance-learn-automation.vercel.app/signup"
    Then verify that the signup page is displayed

  Scenario: Successful account creation with valid details
    Given the user provides a unique username
    And enters a valid email address
    And sets a secure password
    And selects "AWS" as the area of interest
    And ensures the gender "Male" option is chosen
    And scroll to the bottom of the page
    And selects "Karnataka" from the state dropdown
    And chooses multiple hobbies including "Playing" and "Reading"
    When the user clicks the signup button
    Then the system should redirect the user to the login page
    And a toast success message "Signup successfully, Please login!" should be displayed

  Scenario: Login with newly created account
    Given the user is on the login page
    When the user enters the registered email address
    And inputs the correct password
    And clicks the signin button
    Then validate the page displays "Welcome" message
  #SceThen the user should be redirected to the dashboard page and validate the title "Welcome to the Dashboard"nario: Open the application and verify the login page is displayed
    #Given Access the application URL "https://freelance-learn-automation.vercel.app/login"
    #Then Verify that the "login" page is displayed
