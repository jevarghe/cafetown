package com.mobiquity.steps;

import com.mobiquity.pages.CreateEmployeePage;
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

public final class CreateEmployeeSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	private CreateEmployeePage createEmployeePage;

	public CreateEmployeeSteps(Pages pages) {
		super(pages);
		createEmployeePage = getPages().get(CreateEmployeePage.class);
	}

	@Step
	public void entersFirstName(String firstName) {
		createEmployeePage.enterFirstName(firstName);
	}

	@Step
	public void entersLastName(String lastName) {
		createEmployeePage.enterLastName(lastName);
	}

	@Step
	public void entersStartDate(String startDate) {
		createEmployeePage.enterStartDate(startDate);
	}
	
	@Step
	public void entersEmail(String email) {
		createEmployeePage.enterEmail(email);
	}
	
	@Step
	public void clicksAddButton() {
		createEmployeePage.clickAddBtn();
	}

	

}
