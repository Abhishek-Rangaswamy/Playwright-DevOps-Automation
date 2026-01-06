#Author: Abhishek Rangaswamy
Feature: Login and logout to OrangeHRM application in the web

  Scenario: User launches the OrangeHRM login page
    Given the user opens a browser
    When the user navigates to the OrangeHRM URL
    Then the OrangeHRM login page should be displayed
