package com.project.actions;

import java.util.regex.Pattern;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.assertions.PlaywrightAssertions;

public class ValidationActionHelper {

    public void verifyTitleOfThePage(Locator titleLocator, String expectedTitleText) {
        PlaywrightAssertions.assertThat(titleLocator).containsText(Pattern.compile(expectedTitleText));
    }
}
