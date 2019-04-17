package com.mobiquity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Author : Jebin Created on 17/04/2019 Page definition of homepage is
 * implemented in this class. As Page object model is used, it will make the
 * maintenance easier
 *
 */

public final class LoginPage extends BasePage {

	// Elements Declaration

	@FindBy(css = "#login-form > fieldset > label:nth-child(3) > input")
	private WebElement userNameTextField;

	@FindBy(css = "#login-form > fieldset > label:nth-child(4) > input")
	private WebElement passwordTextField;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Actions

	public void enterUserName(String userName) {
		$(userNameTextField).type(userName);
	}

	public void enterPassword(String password) {
		$(passwordTextField).type(password);
	}

}
