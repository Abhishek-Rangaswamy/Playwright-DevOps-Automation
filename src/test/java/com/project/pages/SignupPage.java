package com.project.pages;

import com.microsoft.playwright.Locator;

public class SignupPage extends BasePage {

    private Locator title;
    private Locator nameTextField;
    private Locator emailTextField;
    private Locator passwordTextField;
    private Locator seleniumTextOption;
    private Locator javaTextOption;
    private Locator maleRadioButton;
    private Locator femaleRadioButton;
    private Locator selectStateDropdownElement;
    private Locator selectStateOptionKarnataka;
    private Locator hobbies;
    private Locator hobbiesOptionPlaying;
    private Locator hobbiesOptionReading;
    private Locator signupButton;

    public SignupPage() {
        this.title = page.locator("//h2[text()='Sign Up']");
        this.nameTextField = page.getByPlaceholder("Name");
        this.emailTextField = page.getByPlaceholder("Email");
        this.passwordTextField = page.getByPlaceholder("Password");
        this.seleniumTextOption = page.getByText("Selenium");
        this.javaTextOption = page.getByText("AWS");
        this.maleRadioButton = page.locator("//input[@type='radio' and @value='Male']");
        this.femaleRadioButton = page.locator("//input[@type='radio' and @value='Female']");
        this.selectStateDropdownElement = page.locator("#state");
        this.selectStateOptionKarnataka = page.getByText("Karnataka");
        this.hobbies = page.locator("#hobbies");
        this.hobbiesOptionPlaying = hobbies.getByText("Playing");
        this.hobbiesOptionReading = hobbies.getByText("Reading");
        this.signupButton = page.locator(".submit-btn");
    }

    public Locator getTitle() {
        return title;
    }

    public Locator getNameTextField() {
        return nameTextField;
    }

    public Locator getEmailTextField() {
        return emailTextField;
    }

    public Locator getPasswordTextField() {
        return passwordTextField;
    }

    public Locator getSeleniumTextOption() {
        return seleniumTextOption;
    }

    public Locator getJavaTextOption() {
        return javaTextOption;
    }

    public Locator getMaleRadioButton() {
        return maleRadioButton;
    }

    public Locator getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public Locator getSelectStateDropdownElement() {
        return selectStateDropdownElement;
    }

    public Locator getStateDropdown() {
        return selectStateDropdownElement;
    }

    public Locator getStateOptionKarnataka() {
        return selectStateOptionKarnataka;
    }

    public Locator getStateOption(String stateName) {
        return page.getByText(stateName);
    }

    public Locator getHobbies() {
        return hobbies;
    }

    public Locator getHobbiesOptionPlaying() {
        return hobbiesOptionPlaying;
    }

    public Locator getHobbiesOptionReading() {
        return hobbiesOptionReading;
    }

    public Locator getSignupButton() {
        return signupButton;
    }
}
