package com.mobiquity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Author : Jebin Varghese
 * Created on 17/04/2019 
 * Definition of Login Page is implemented in this class.
 *
 */

public final class LoginPage extends BasePage {

	/**
	 * 
	 * Web Elements on the page can be declared below
	 * 
	 */

	@FindBy(css = "#login-form > fieldset > label:nth-child(3) > input")
	private WebElement userNameTextField;

	@FindBy(css = "#login-form > fieldset > label:nth-child(4) > input")
	private WebElement passwordTextField;

	@FindBy(css = "#login-form > fieldset > button")
	private WebElement submitButton;

	@FindBy(css = "#login-form > fieldset > p.error-message.ng-binding")
	private WebElement errorMsgHolder;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 * Actions can be defined below for the above web elements
	 * 
	 */

	public void enterUserName(String userName) {
		$(userNameTextField).type(userName);
	}

	public void enterPassword(String password) {
		$(passwordTextField).type(password);
	}

	public void clickSubmitBtn() {
		$(submitButton).click();
	}

	public String getErrorText() {
		return $(errorMsgHolder).getText();
	}

}
