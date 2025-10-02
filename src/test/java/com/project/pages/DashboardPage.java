package com.project.pages;

import com.microsoft.playwright.Locator;

public class DashboardPage extends BasePage {
    private Locator welcomeMessageLocator;

    public DashboardPage() {
        this.welcomeMessageLocator = page.locator("//h4[contains(normalize-space(.), 'Welcome')]");
    }

    public Locator getWelcomeMessageLocator() {
        return welcomeMessageLocator;
    }
}
