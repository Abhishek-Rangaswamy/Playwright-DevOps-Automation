package com.project.pages;

import com.project.actions.ValidationActionHelper;
import com.project.actions.UtilityActionHelper;

public class CommonPageObjects {
    private LoginPage loginPage;
    private SignupPage signupPage;
    private DashboardPage dashboardPage;
    private UtilityActionHelper utilityActionHelper;
    private ValidationActionHelper validationHelper;

    public CommonPageObjects() {
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.utilityActionHelper = new UtilityActionHelper();
        this.validationHelper = new ValidationActionHelper();
        this.dashboardPage = new DashboardPage();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public SignupPage getSignupPage() {
        return signupPage;
    }

    public ValidationActionHelper getValidationHelper() {
        return validationHelper;
    }

    public UtilityActionHelper getUtilityActionHelper() {
        return utilityActionHelper;
    }

    public DashboardPage getDashboardPage() {
        return dashboardPage;
    }
}
