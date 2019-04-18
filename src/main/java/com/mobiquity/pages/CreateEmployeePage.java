package com.mobiquity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Author : Jebin Varghese
 * Created on : 17/04/2019
 * Definition of Employee Creation Page is implemented in this class. 
 *
 */

public final class CreateEmployeePage extends BasePage {

	public CreateEmployeePage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 * Web Elements on the page can be declared below
	 * 
	 */

	@FindBy(css = "body > div > div > div > form > fieldset > label:nth-child(3) > input")
	private WebElement firstNameInput;

	@FindBy(css = "body > div > div > div > form > fieldset > label:nth-child(4) > input")
	private WebElement lastNameInput;

	@FindBy(css = "body > div > div > div > form > fieldset > label:nth-child(5) > input")
	private WebElement startDateInput;

	@FindBy(css = "body > div > div > div > form > fieldset > label:nth-child(6) > input")
	private WebElement emailInput;

	@FindBy(css = "body > div > div > div > form > fieldset > div > button:nth-child(2)")
	private WebElement addButton;
	
	@FindBy(css = "body > div > div > div > form > fieldset > div > button:nth-child(1)")
	private WebElement updateButton;

	/**
	 * 
	 * Actions can be defined below for the above web elements
	 * 
	 */

	public void enterFirstName(String firstName) {
		$(firstNameInput).type(firstName);
	}

	public void enterLastName(String lastName) {
		$(lastNameInput).type(lastName);
	}

	public void enterStartDate(String startDate) {
		$(startDateInput).type(startDate);
	}

	public void enterEmail(String email) {
		$(emailInput).type(email);
	}

	public void clickAddBtn() {
		$(addButton).click();
	}
	
	public void clickUpdateBtn() {
		$(updateButton).click();
	}

	public String getEmail() {
		return $(emailInput).getAttribute("value");
	}
}
