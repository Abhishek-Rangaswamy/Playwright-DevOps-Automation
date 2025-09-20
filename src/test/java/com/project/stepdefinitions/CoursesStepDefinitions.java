package com.project.stepdefinitions;

import com.microsoft.playwright.Locator;
import com.project.hooks.Hooks;
import com.project.pages.CommonPageObjects;
import com.project.testhelper.testDataHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

/**
 * Step definitions for Courses feature.
 */
public class CoursesStepDefinitions {

    private final CommonPageObjects commonPageObjects;

    public CoursesStepDefinitions() {
        this.commonPageObjects = new CommonPageObjects();
        // Ensure test data is populated before running tests
        new testDataHelper().populateTestData();
    }

    private void logStep(String message) {
        Hooks.logStep(message);
    }

    @Given("access the application URL {string}")
    public void accessTheApplicationSignUpURL(String url) {
        logStep("access the application URL " + url);
        commonPageObjects.getSignupPage().navigateTo(url);
    }

    @Then("verify that the signup page is displayed")
    public void verifyThatTheSignupPageIsDisplayed() {
        logStep("Verify that the signup page is displayed");
        commonPageObjects.getValidationHelper().verifyTitleOfThePage(commonPageObjects.getSignupPage().getTitle(),
                "Sign Up");
    }

    @Then("verify that the login page is displayed")
    public void verifyThatTheLoginPageIsDisplayed() {
        logStep("verify that the login page is displayed");
        commonPageObjects.getValidationHelper().verifyTitleOfThePage(commonPageObjects.getLoginPage().getTitle(),
                "abcd");
    }

    @Given("the user provides a unique username")
    public void the_user_provides_a_unique_username() {
        logStep("the user provides a unique username");
        Locator usernameField = commonPageObjects.getSignupPage().getNameTextField();
        commonPageObjects.getUtilityActionHelper().fillValueInTextField(usernameField,
                testDataHelper.USERNAME.getUsername());
    }

    @Given("enters a valid email address")
    public void enters_a_valid_email_address() {
        logStep("enters a valid email address");
        Locator emailField = commonPageObjects.getSignupPage().getEmailTextField();
        commonPageObjects.getUtilityActionHelper().fillValueInTextField(emailField, testDataHelper.EMAIL.getEmail());
    }

    @Given("sets a secure password")
    public void sets_a_secure_password() {
        logStep("sets a secure password");
        Locator passwordField = commonPageObjects.getSignupPage().getPasswordTextField();
        commonPageObjects.getUtilityActionHelper().fillValueInTextField(passwordField,
                testDataHelper.PASSWORD.getPassword());
    }

    // @Given("selects {string} as the area of interest")
    // public void selects_as_the_area_of_interest(String string) {
    // logStep("selects " + string + " as the area of interest");
    // Locator areaOfInterestField =
    // commonPageObjects.getSignupPage().getAreaOfInterestDropdown();
    // commonPageObjects.getUtilityActionHelper().selectValueInDropdown(areaOfInterestField,
    // string);
    // }

    // @Given("ensures the gender {string} option is chosen")
    // public void ensures_the_gender_option_is_chosen(String string) {
    // logStep("ensures the gender " + string + " option is chosen");
    // Locator genderField =
    // commonPageObjects.getSignupPage().getGenderRadioButton(string);
    // commonPageObjects.getUtilityActionHelper().selectRadioButton(genderField);
    // }

    // @Given("selects {string} from the state dropdown")
    // public void selects_from_the_state_dropdown(String string) {
    // logStep("selects " + string + " from the state dropdown");
    // Locator stateDropdown = commonPageObjects.getSignupPage().getStateDropdown();
    // commonPageObjects.getUtilityActionHelper().selectValueInDropdown(stateDropdown,
    // string);
    // }

    // @Given("chooses multiple hobbies including {string} and {string}")
    // public void chooses_multiple_hobbies_including_and(String string, String
    // string2) {
    // logStep("chooses multiple hobbies including " + string + " and " + string2);
    // Locator hobbiesField =
    // commonPageObjects.getSignupPage().getHobbiesCheckboxGroup();
    // commonPageObjects.getUtilityActionHelper().selectMultipleCheckboxes(hobbiesField,
    // string, string2);
    // }

    // @When("the user clicks the signup button")
    // public void the_user_clicks_the_signup_button() {
    // logStep("the user clicks the signup button");
    // Locator signupButton = commonPageObjects.getSignupPage().getSignupButton();
    // commonPageObjects.getUtilityActionHelper().clickButton(signupButton);
    // }

    // @Then("the system should redirect the user to the login page")
    // public void the_system_should_redirect_the_user_to_the_login_page() {
    // logStep("the system should redirect the user to the login page");
    // commonPageObjects.getValidationHelper().verifyTitleOfThePage(commonPageObjects.getLoginPage().getTitle(),
    // "Login");
    // }
}