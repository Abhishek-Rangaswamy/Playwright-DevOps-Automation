package com.project.actions;

import com.microsoft.playwright.Locator;

public class UtilityActionHelper {

    public void fillValueInTextField(Locator textField, String value) {
        textField.fill(value);
    }

}
