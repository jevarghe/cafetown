package com.mobiquity;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.mobiquity.steps.CreateEmployeeSteps;
import com.mobiquity.steps.EmployeesSteps;
import com.mobiquity.steps.LoginSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;

/**
 * 
 * Author : Jebin Varghese
 * Created on : 17/04/19
 * Test to validate the Employee Creation functionality
 * Test data injected from external data source
 * 
 **/

@WithTagValuesOf({ "type:ui", "Applicatoin:cafe Town", "Feature:Employee Management" })
@RunWith(SerenityRunner.class)
public class DataValidationTest extends BaseUiTest {

	@Steps
	private LoginSteps loginApi;
	@Steps
	private EmployeesSteps employeesApi;
	@Steps
	private CreateEmployeeSteps creationApi;

	/**
	 * Test to validate the error message thrown by the applicatoin when  
	 * start date is entered in wrong format (YYYY-DD-MM)
	 * Expected format for start date is (YYYY-MM-DD)
	 */
	
	@Test
	public void test7ValidateStartDateFormat() {
		loginApi.entersUserNameAndPassword("Luke", "Skywalker");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
		employeesApi.clicksCreateButton();
		creationApi.entersEmployeeDetails("Valid Name", "Second Name", "2019-28-04", "abc@xyz.com");
		creationApi.clicksAddButton();
		creationApi.validateErrorText("Error trying to create a new employee: {\"start_date\":[\"can't be blank\"]})");
	}
}
