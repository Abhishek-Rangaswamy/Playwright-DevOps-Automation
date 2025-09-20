package com.project.pages;

import com.project.actions.ValidationActionHelper;
import com.project.actions.UtilityActionHelper;

public class CommonPageObjects {
    private LoginPage loginPage;
    private SignupPage signupPage;
    private UtilityActionHelper utilityActionHelper;
    private ValidationActionHelper validationHelper;

    public CommonPageObjects() {
        this.loginPage = new LoginPage();
        this.signupPage = new SignupPage();
        this.utilityActionHelper = new UtilityActionHelper();
        this.validationHelper = new ValidationActionHelper();

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
}
