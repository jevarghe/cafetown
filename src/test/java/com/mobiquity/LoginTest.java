package com.mobiquity;

import org.junit.Test;
import org.junit.runner.RunWith;
import com.mobiquity.steps.LoginPageSteps;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithTagValuesOf;
import net.thucydides.junit.annotations.UseTestDataFrom;

/**
 * 
 * Author : Jebin Created : 17/04/19 Test to validate the search functionality
 * with the test data injected from external data source
 * 
 **/

@WithTagValuesOf({ "type:ui", "Applicatoin:cafe Town", "Feature:Login" })
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "src/test/resources/credentials.csv")
public class LoginTest extends BaseUiTest {

	private String userName;
	private String password;

	@Steps
	private LoginPageSteps loginApi;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Test
	public void loginTest() {
		loginApi.entersUserName(userName);
		loginApi.entersPassword(password);
	}

}
