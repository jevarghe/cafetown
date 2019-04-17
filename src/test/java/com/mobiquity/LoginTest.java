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
public class LoginTest extends BaseUiTest {

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

	@Test
	public void TestloginWithValidCredentials() {
		loginApi.entersUserName(userName);
		loginApi.entersPassword(password);
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello Luke");
	}

	@Test
	public void TestErrorMessageForInvalidCredentials() {
		loginApi.entersUserName("invalidName");
		loginApi.entersPassword("inval1dp@ssword");
		loginApi.clicksSubmitButton();
		loginApi.validatesErrorText("Invalid username or password!");
	}

	@Test
	public void TestLoginWithInvalidCredentials() {
		loginApi.entersUserName("invalidName");
		loginApi.entersPassword("inval1dp@ssword");
		loginApi.clicksSubmitButton();
		employeesApi.validatesGreetingsText("Hello hello");
	}

}
