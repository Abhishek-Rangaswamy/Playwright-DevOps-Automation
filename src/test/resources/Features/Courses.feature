#Author: Abhishek Rangaswamy
Feature: Automate Course Navigation and Validation

  Scenario: Open the application and verify the signup page is displayed
    Given access the application URL "https://freelance-learn-automation.vercel.app/signup"
    Then verify that the signup page is displayed

  Scenario: Successful account creation with valid details
    Given the user provides a unique username
    And enters a valid email address
    And sets a secure password
    # And selects "Java" as the area of interest
    # And ensures the gender "Male" option is chosen
    # And selects "Karnataka" from the state dropdown
    # And chooses multiple hobbies including "Playing" and "Reading"
    # When the user clicks the signup button
    # Then the system should redirect the user to the login page
  #Scenario: Open the application and verify the login page is displayed
    #Given Access the application URL "https://freelance-learn-automation.vercel.app/login"
    #Then Verify that the "login" page is displayed
