package com.mobiquity.steps;

import com.mobiquity.pages.EmployeesPage;
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

public class EmployeesSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	private EmployeesPage employeesPage;

	public EmployeesSteps(Pages pages) {
		super(pages);
		employeesPage = getPages().get(EmployeesPage.class);
	}

	@Step
	public void validatesGreetingsText(String greetingsText) {
		assert (employeesPage.getGreetingsText().equals(greetingsText));
	}

	@Step
	public void logsOut() {
		employeesPage.clickLogoutBtn();
	}

	@Step
	public void clicksCreateButton() {
		employeesPage.clickCreateBtn();
	}

	@Step
	public void clicksEditButton() {
		employeesPage.clickEditBtn();
	}

	@Step
	public void clicksDeleteButton() {
		employeesPage.clickDeleteBtn();
	}
	
	@Step
	public void selectEmployee(String employeeName) {
		employeesPage.selectEmployee(employeeName);
	}

	@Step
	public void confirmEmployeeDeletion() {
		employeesPage.acceptAlert();
	}

	@Step
	public void verifyEmployeeInTheList(String firstName, String lastName) {
		assert (employeesPage.isEmployeePresent(firstName + " " + lastName));
	}

	@Step
	public void viewEmployeeDetails(String employeeName) {
		employeesPage.selectEmployee(employeeName);
		employeesPage.clickEditBtn();
	}

	@Step
	public void verifyEmployeeNotInTheList(String employeeName) {
		if (employeesPage.isEmployeePresent(employeeName) == false) {
			assert (true);
		}

	}

}
