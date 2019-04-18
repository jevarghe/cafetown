package com.mobiquity;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.mobiquity.steps.CreateEmployeeSteps;
import com.mobiquity.steps.EmployeesSteps;
import com.mobiquity.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.junit.annotations.UseTestDataFrom;

/**
 * 
 * Author : Jebin Varghese
 * Created on : 17/04/19
 * Test to validate the Employee Creation functionality
 * Test data injected from external data source
 * 
 **/

@WithTagValuesOf({ "type:ui", "Applicatoin:cafe Town", "Feature:Employee Creation" })
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/employeeDetails.csv")
public class EmployeesTest extends BaseUiTest {

	private String firstName;
	private String lastName;
	private String startDate;
	private String email;
	private String newEmail;

	@Steps
	private LoginSteps loginApi;
	@Steps
	private EmployeesSteps employeesApi;
	@Steps
	private CreateEmployeeSteps creationApi;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	@Test
	public void test1CreateEmployees() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.clicksCreateButton();
		creationApi.entersEmployeeDetails(firstName, lastName, startDate, email);
		creationApi.clicksAddButton();
		employeesApi.verifyEmployeeInTheList(firstName, lastName);

	}

	@Test
	public void test2EditEmployees() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.selectEmployee(firstName + " " + lastName);
		employeesApi.clicksEditButton();
		creationApi.entersEmail(newEmail);
		creationApi.clicksUpdateButton();
		employeesApi.viewEmployeeDetails(firstName + " " + lastName);
		creationApi.validateEmail(newEmail);
	}

	@Test
	public void test3DeleteEmployees() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.selectEmployee(firstName + " " + lastName);
		employeesApi.clicksDeleteButton();
		employeesApi.confirmEmployeeDeletion();
		employeesApi.verifyEmployeeNotInTheList(firstName + " " + lastName);
	}

}
