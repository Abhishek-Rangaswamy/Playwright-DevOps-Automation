package com.project.pages;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    private Locator title;
    private Locator emailLocator;
    private Locator password;
    private Locator signInLocator;
    private Locator loginSuccessMessage;

    public LoginPage() {
        this.title = page.locator("//h1[contains(text(),'Learn Automation123')]" +
                "|//h1[contains(text(),'Automation courses')]" +
                "|//h1[contains(text(),'Learn Automation')]");
        this.emailLocator = page.getByPlaceholder("Enter Email");
        this.password = page.locator("//input[@type='password']");
        this.loginSuccessMessage = page.locator("//div[text()='Signup successfully, Please login!']");
        this.signInLocator = page.locator("//button[text()='Sign in']");
    }

    public Locator getTitle() {
        return title;
    }

    public Locator getEmailLocator() {
        return emailLocator;
    }

    public Locator getPassword() {
        return password;
    }

    public Locator getSignInButton() {
        return signInLocator;
    }

    public Locator getLoginSuccessMessage() {
        return loginSuccessMessage;
    }
}
