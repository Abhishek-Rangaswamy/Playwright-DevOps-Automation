package com.project.pages;

import com.microsoft.playwright.Locator;

public class SignupPage extends BasePage {

    private Locator title;
    private Locator nameTextField;
    private Locator emailTextField;
    private Locator passwordTextField;
    private Locator seleniumTextOption;
    private Locator maleRadioButton;
    private Locator femaleRadioButton;
    private Locator selectStateDropdownElement;
    private Locator hobbiesOptionPlaying;
    private Locator signupButton;

    public SignupPage() {
        this.title = page.locator("//h2[text()='Sign Up']");
        this.nameTextField = page.getByPlaceholder("Name");
        this.emailTextField = page.getByPlaceholder("Email");
        this.passwordTextField = page.getByPlaceholder("Password");
        this.seleniumTextOption = page.getByText("Selenium");
        this.maleRadioButton = page.locator("//input[@type='radio' and @value='Male']");
        this.femaleRadioButton = page.locator("//input[@type='radio' and @value='Female']");
        this.selectStateDropdownElement = page.getByTestId("state");
        this.hobbiesOptionPlaying = page.getByText("Playing");
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

    public Locator getMaleRadioButton() {
        return maleRadioButton;
    }

    public Locator getFemaleRadioButton() {
        return femaleRadioButton;
    }

    public Locator getSelectStateDropdownElement() {
        return selectStateDropdownElement;
    }

    public Locator getHobbiesOptionPlaying() {
        return hobbiesOptionPlaying;
    }

    public Locator getSignupButton() {
        return signupButton;
    }
}
