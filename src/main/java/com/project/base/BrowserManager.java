package com.project.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

/**
 * Singleton class to manage browser lifecycle.
 */
public class BrowserManager {
    private static BrowserManager instance;
    private Playwright playwright;
    private Browser browser;
    private Page page;

    private BrowserManager() {
        // Private constructor to prevent instantiation
    }

    /**
     * Get the singleton instance of BrowserManager.
     * @return BrowserManager instance
     */
    public static synchronized BrowserManager getInstance() {
        if (instance == null) {
            instance = new BrowserManager();
        }
        return instance;
    }

    /**
     * Open a browser based on the specified type.
     * @param browserType Type of browser (e.g., chrome, firefox)
     */
    public void openBrowser(String browserType) {
        if (playwright == null) {
            playwright = Playwright.create();

            switch (browserType.toLowerCase()) {
                case "chrome":
                    browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(500));
                    break;
                case "firefox":
                    browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                            .setHeadless(false)
                            .setSlowMo(500));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }

            page = browser.newPage();
            System.out.println("✅ Browser launched");
        }
    }

    /**
     * Get the current Playwright page instance.
     * @return Page instance
     */
    public Page getPage() {
        if (page == null) {
            throw new IllegalStateException("Browser is not initialized. Call openBrowser() first.");
        }
        return page;
    }

    /**
     * Close the browser and release resources.
     */
    public void closeBrowser() {
        try {
            if (page != null) page.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
            System.out.println("❌ Browser closed");
        } catch (Exception e) {
            System.err.println("Error while closing browser: " + e.getMessage());
        } finally {
            page = null;
            browser = null;
            playwright = null;
        }
    }
}