package com.mobiquity;

import org.junit.Test;
import org.junit.runner.RunWith;
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
 * Test to validate the login functionality
 * Test data injected from external data source
 * 
 **/

@WithTagValuesOf({ "type:ui", "Applicatoin:cafe Town", "Feature:Login" })
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/credentials.csv")
public class AuthenticationTest extends BaseUiTest {

	private String userName;
	private String password;

	@Steps
	private LoginSteps loginApi;
	@Steps
	private EmployeesSteps employeesApi;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Test to validate the login functionality with valid credentials  
	 * Test data is read from the external data source.
	 */

	@Test
	public void test1loginWithValidCredentials() {
		loginApi.entersUserNameAndPassword(userName, password);
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
	}

	/**
	 * Test to validate the error message when invalid credentials are used for login  
	 */
	
	@Test
	public void test2ErrorMessageForInvalidCredentials() {
		loginApi.entersUserNameAndPassword("invalidName", "inval1dp@ssword");
		loginApi.clicksSubmitButton();
		loginApi.validatesErrorText("Invalid username or password!");
	}

	/**
	 * Test to check if Greetings text are displayed for invalid credentials
	 * This test is intended to fail.  
	 * This test is to show how the failed test cases are displayed in test results
	 */
	
	@Test()
	public void test3LoginWithInvalidCredentials() {
		loginApi.entersUserNameAndPassword("invalidName", "inval1dp@ssword");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello hello");
	}
}
