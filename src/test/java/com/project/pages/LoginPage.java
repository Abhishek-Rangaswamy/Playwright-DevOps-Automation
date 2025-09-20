package com.project.pages;

import com.microsoft.playwright.Locator;

public class LoginPage extends BasePage {

    private Locator title;
    private Locator username;
    private Locator password;

    public LoginPage() {
        this.title = page.locator("//h1[contains(text(),'Learn Automation123')]" +
                "|//h1[contains(text(),'Automation courses')]" +
                "|//h1[contains(text(),'Learn Automation')]");
        this.username = page.getByPlaceholder("Enter Email");
        this.password = page.locator("//input[@type='password']");
    }

    public Locator getTitle() {
        return title;
    }

    public Locator getUsername() {
        return username;
    }

    public Locator getPassword() {
        return password;
    }
}
