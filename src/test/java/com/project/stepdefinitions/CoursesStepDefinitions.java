package com.project.stepdefinitions;

import com.microsoft.playwright.Locator;
import com.project.hooks.Hooks;
import com.project.pages.CommonPageObjects;
import com.project.testhelper.TestDataStore;
import com.project.testhelper.testDataHelper;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for Courses feature.
 */
public class CoursesStepDefinitions extends CommonPageObjects {

    // private final CommonPageObjects commonPageObjects;

    public CoursesStepDefinitions() {
        // this.commonPageObjects = new CommonPageObjects();
        // Ensure test data is populated before running tests
        new testDataHelper().populateTestData();
    }

    private void logStep(String message) {
        Hooks.logStep(message);
    }

    @Given("access the application URL {string}")
    public void accessTheApplicationSignUpURL(String url) {
        logStep("access the application URL " + url);
        getSignupPage().navigateTo(url);
    }

    @Then("verify that the signup page is displayed")
    public void verifyThatTheSignupPageIsDisplayed() {
        logStep("Verify that the signup page is displayed");
        getValidationHelper().verifyTitleOfThePage(getSignupPage().getTitle(),
                "Sign Up");
    }

    @Then("verify that the login page is displayed")
    public void verifyThatTheLoginPageIsDisplayed() {
        logStep("verify that the login page is displayed");
        getValidationHelper().verifyTitleOfThePage(getLoginPage().getTitle(),
                "abcd");
    }

    @Given("the user provides a unique username")
    public void the_user_provides_a_unique_username() {
        logStep("the user provides a unique username");
        Locator usernameField = getSignupPage().getNameTextField();
        getUtilityActionHelper().fillValueInTextField(usernameField,
                testDataHelper.USERNAME.getUsername());
    }

    @Given("enters a valid email address")
    public void enters_a_valid_email_address() {
        logStep("enters a valid email address");
        Locator emailField = getSignupPage().getEmailTextField();
        getUtilityActionHelper().fillValueInTextField(emailField, testDataHelper.EMAIL.getEmail());
    }

    @Given("sets a secure password")
    public void sets_a_secure_password() {
        logStep("sets a secure password");
        Locator passwordField = getSignupPage().getPasswordTextField();
        getUtilityActionHelper().fillValueInTextField(passwordField,
                testDataHelper.PASSWORD.getPassword());
    }

    @Given("selects {string} as the area of interest")
    public void selects_as_the_area_of_interest(String string) {
        logStep("selects " + string + " as the area of interest");
        Locator areaOfInterestField = getSignupPage().getJavaTextOption();
        getUtilityActionHelper().clickOnElement(areaOfInterestField);
    }

    @Given("ensures the gender {string} option is chosen")
    public void ensures_the_gender_option_is_chosen(String string) {
        logStep("ensures the gender " + string + " option is chosen");
        Locator genderField = getSignupPage().getMaleRadioButton();
        getUtilityActionHelper().isElementChecked(genderField, string);
    }

    @And("scroll to the bottom of the page")
    public void scroll_to_the_bottom_of_the_page() {
        logStep("scroll to the bottom of the page");
        getUtilityActionHelper().scrollToBottomOfPage();
    }

    @Given("selects {string} from the state dropdown")
    public void selects_from_the_state_dropdown(String string) throws InterruptedException {
        logStep("selects " + string + " from the state dropdown");
        Locator stateDropdown = getSignupPage().getStateDropdown();
        Locator optionLocator = getSignupPage().getStateOption(string);
        getUtilityActionHelper().selectValueFromDropdown(stateDropdown, optionLocator, string);
    }

    @Given("chooses multiple hobbies including {string} and {string}")
    public void chooses_multiple_hobbies_including_and(String string1, String string2) {
        logStep("chooses multiple hobbies including " + string1 + " and " + string2);
        Locator hobbiesField = getSignupPage().getHobbies();
        getUtilityActionHelper().multiSelectOptions(hobbiesField, new String[] { string1, string2 });
    }

    @When("the user clicks the signup button")
    public void the_user_clicks_the_signup_button() {
        logStep("the user clicks the signup button");
        Locator signupButton = getSignupPage().getSignupButton();
        getUtilityActionHelper().clickButton(signupButton);
    }

    @And("the system should redirect the user to the login page")
    public void the_system_should_redirect_the_user_to_the_login_page() {
        logStep("the system should redirect the user to the login page");
        getValidationHelper().verifyTitleOfThePage(getLoginPage().getTitle(),
                "Learn Automation");
    }

    @Then("a toast success message {string} should be displayed")
    public void a_toast_success_message_should_be_displayed(String s) {
        logStep("a toast success message " + s + " should be displayed");
        getValidationHelper().verifyElementIsVisible(
                getLoginPage().getLoginSuccessMessage(), s);
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        logStep("the system should redirect the user to the login page");
        getValidationHelper().verifyTitleOfThePage(getLoginPage().getTitle(),
                "Learn Automation");
        Thread.sleep(3000);
    }

    @When("the user enters the registered email address")
    public void the_user_enters_the_registered_email_address() {
        logStep("the user enters the registered email address");
        getUtilityActionHelper().fillValueInTextField(
                getLoginPage().getEmailLocator(), TestDataStore.INSTANCE.getEmail());
        System.out.println(TestDataStore.INSTANCE.getEmail());
        // getLoginPage().getEmailField().setValue(TestDataStore.INSTANCE.getEmail());}
    }

    @When("inputs the correct password")
    public void inputs_the_correct_password() {
        logStep("inputs the correct password");
        getUtilityActionHelper().fillValueInTextField(
                getLoginPage().getPassword(), TestDataStore.INSTANCE.getPassword());
        System.out.println(TestDataStore.INSTANCE.getPassword());
    }

    @When("clicks the signin button")
    public void clicks_the_signin_button() {
        logStep("clicks the signin button");
        getUtilityActionHelper().clickButton(getLoginPage().getSignInButton());
    }

    @Then("validate the page displays {string} message")
    public void validate_the_page_displays_message(String s) {
        logStep("validate the page displays " + s + " message");
        getValidationHelper()
                .verifyElementIsVisible(getDashboardPage().getWelcomeMessageLocator(), s);
    }
}