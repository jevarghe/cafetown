package com.mobiquity.steps;

import com.mobiquity.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * 
 * Author : Jebin Varghese
 * Created : 17/04/19 
 * Steps are defined in this file and are invoked by the test case classes.
 * Methods defined under @Step annotations are displayed as test steps in the results file
 * 
 **/

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	private LoginPage loginPage;

	public LoginSteps(Pages pages) {
		super(pages);
		loginPage = getPages().get(LoginPage.class);
	}

	@Step
	public void entersUserNameAndPassword(String userName, String password) {
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@Step
	public void clicksSubmitButton() {
		loginPage.clickSubmitBtn();
	}

	@Step
	public void validatesErrorText(String errorText) {
		assert (loginPage.getErrorText().equals(errorText));
	}

}
