package com.project.pages;

import com.microsoft.playwright.Page;
import com.project.base.BrowserManager;

/**
 * Base class for all page objects.
 */
public abstract class BasePage {
    protected Page page;

    public BasePage() {
        this.page = BrowserManager.getInstance().getPage();
    }

    /**
     * Navigate to a specific URL.
     * @param url The URL to navigate to.
     */
    public void navigateTo(String url) {
        page.navigate(url);
    }

    /**
     * Get the title of the current page.
     * @return Page title as a string.
     */
    public String getPageTitle() {
        return page.title();
    }
}
