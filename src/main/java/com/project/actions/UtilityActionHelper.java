package com.project.actions;

import com.microsoft.playwright.Locator;
import com.project.base.BrowserManager;

public class UtilityActionHelper {

    public void fillValueInTextField(Locator textField, String value) {
        textField.fill(value);
    }

    public void clickOnElement(Locator elementLocator) {
        elementLocator.click();
    }

    public boolean isElementChecked(Locator elementLocator, String elementName) {
        boolean isChecked = false;
        if (elementLocator.isChecked()) {
            System.out.println("Element '" + elementName + "' is already checked");
            isChecked = elementLocator.isChecked();
        } else {
            elementLocator.check();
            System.out.println("Element '" + elementName + "' was not checked, so now it is checked");
            isChecked = elementLocator.isChecked();
        }
        return isChecked;
    }

    public void selectValueFromDropdown(Locator dropdownElement, Locator optionLocator, String valueToBeSelected)
            throws InterruptedException {
        dropdownElement.click();
        Thread.sleep(1000);
        dropdownElement.selectOption(valueToBeSelected);
    }

    public void clickButton(Locator buttonLocator) {
        buttonLocator.click();
    }

    public void scrollToBottomOfPage() {
        BrowserManager.getInstance().getPage()
                .evaluate("() => window.scrollTo({ top: document.body.scrollHeight, behavior: 'smooth' })");
    }

    public void multiSelectOptions(Locator dropdown, String[] values) {
        dropdown.selectOption(values); // Select multiple options in the dropdown
        System.out.println("User selected the options: " + String.join(", ", values));
    }
}
