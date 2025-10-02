package com.project.actions;

import java.util.regex.Pattern;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ValidationActionHelper {

    public void verifyTitleOfThePage(Locator titleLocator, String expectedTitleText) {
        PlaywrightAssertions.assertThat(titleLocator).containsText(Pattern.compile(expectedTitleText));
    }

    public void verifyElementIsVisible(Locator elementLocator, String elementName) {
        elementLocator.waitFor(new Locator.WaitForOptions().setTimeout(5000)); // wait until visible
        PlaywrightAssertions.assertThat(elementLocator).isVisible();
        System.out.println("Element '" + elementName + "' is visible on the page.");
    }
}
