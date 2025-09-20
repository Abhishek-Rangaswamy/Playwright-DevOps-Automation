package com.project.testhelper;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator.WaitForOptions;
import com.microsoft.playwright.options.WaitForSelectorState;

public class locatorHelper {

	/*
	 * Author: Abhishek Rangaswamy 
	 * Description: Utility method to safely retrieve a 
	 * unique Playwright locator while avoiding timing issues.
	 * 
	 * Parameters: 
	 * Page page - the Playwright Page instance 
	 * String[] selectors - list of xpath selectors to attempt for locating the element.
	 * Date: 2025-09-03 
	 * Returns: Locator - the first unique locator found from the provided selectors
	 */
	public static Locator safeLocator(Page page, String[] selectors) {
		Locator locator = null;
		for (String selector : selectors) {
			locator = page.locator(selector);
			if (locator.count() > 0 && locator.count() == 1) {
				System.out.println("Found unique locator using selector: " + selector);
				break;
			}
		}
		if (locator == null) {
			throw new RuntimeException("No valid locator found from the provided selectors.");
		}
		return locator;
	}
	
	/*
	 * Author: Abhishek Rangaswamy 
	 * Description: Utility method to safely retrieve a 
	 * unique Playwright locator while having timing issues.
	 * 
	 * Parameters: 
	 * Page page - the Playwright Page instance 
	 * String[] selectors - list of xpath selectors to attempt for locating the element.
	 * Date: 2025-09-03 
	 * Returns: Locator - the first unique locator found from the provided selectors
	 */
	public static Locator safeLocator(Page page, String[] selectors, int timeoutMillis) {
		Locator locator = null;
		for (String selector : selectors) {
			locator = page.locator(selector);

			try {
				locator.waitFor(new WaitForOptions().setTimeout(timeoutMillis).setState(WaitForSelectorState.VISIBLE));
				if (locator.count() > 0 && locator.count() == 1) {
					System.out.println("Found unique locator using selector: " + selector);
					break;
				}
			} catch (Exception e) {
				throw new RuntimeException("No valid locator found from the provided selectors.");
			}
		}
		return locator;
	}
}
