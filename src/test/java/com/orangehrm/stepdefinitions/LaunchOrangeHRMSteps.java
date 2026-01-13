package com.orangehrm.stepdefinitions;

import org.testng.Assert;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LaunchOrangeHRMSteps {
	
	Playwright playwright;
	BrowserType browserType;
	Browser browser;
	BrowserContext context;
	Page page;
	
	@Given("the user opens a browser")
	public void the_user_opens_a_browser() {
	    playwright = Playwright.create();
	    browserType = playwright.chromium();
	    browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(true));
	    context = browser.newContext();
	    page = context.newPage();
	}

	@When("the user navigates to the OrangeHRM URL")
	public void the_user_navigates_to_the_orange_hrm_url() {
	    page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@Then("the OrangeHRM login page should be displayed")
	public void the_orange_hrm_login_page_should_be_displayed() {
	    String title = page.title();
	    Assert.assertEquals(title, "OrangeHRM");
	    
	    if (page != null) page.close();
	    if (context != null) context.close();
	    if (browser != null) browser.close();
	    if (playwright != null) playwright.close();
	}

	
}
