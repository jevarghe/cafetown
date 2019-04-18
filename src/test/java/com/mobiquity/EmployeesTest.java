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

@WithTagValuesOf({ "type:ui", "Applicatoin:cafe Town", "Feature:Employee Management" })
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

	/**
	 * Test to verify the successful creation of employee 
	 * test steps are added to feed the employee data from external data source
	 * and finally verify that newly created employee is in the list
	 */
	
	@Test
	public void test4CreateEmployees() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.clicksCreateButton();
		creationApi.entersEmployeeDetails(firstName, lastName, startDate, email);
		creationApi.clicksAddButton();
		employeesApi.verifyEmployeeInTheList(firstName, lastName);
	}

	/**
	 * Test to verify the editing an employee details 
	 * test steps are added to feed the employee data from external data source
	 * and finally verify that edited details are reflected to the employee record
	 * 
	 * This test is dependent on the previous test, so failure in the first test will result in failure of this
	 * Best approach is to create test data prior to testing and use them for automation.
	 * Using this approach as no optimal solution is found to create Test Data for Automation.
	 */

	@Test
	public void test5EditEmployees() {
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

	/**
	 * Test to verify deleting an employee record 
	 * test steps are added to feed the employee data from external data source
	 * (Employees created in previous steps are deleted in this test. These tests are dependent
	 * on the previous tests so not the best approach. For the time being, implementing test cases
	 * that are dependent on the previous one)
	 * and finally verify that edited details are reflected to the employee record
	 */
	
	@Test
	public void test6DeleteEmployees() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.selectEmployee(firstName + " " + lastName);
		employeesApi.clicksDeleteButton();
		employeesApi.confirmEmployeeDeletion();
		employeesApi.verifyEmployeeNotInTheList(firstName + " " + lastName);
	}
}
