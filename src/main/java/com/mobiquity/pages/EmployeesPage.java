package com.mobiquity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * 
 * Author : Jebin Varghese
 * Created on : 17/04/2019
 * Definition of Employees Page is implemented in this class. 
 *
 */

public final class EmployeesPage extends BasePage {

	public EmployeesPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * 
	 * Web Elements on the page can be declared below
	 * 
	 */

	@FindBy(css = "body > div > header > div > p.main-button")
	private WebElement logOutButton;

	@FindBy(id = "bAdd")
	private WebElement addBtn;

	@FindBy(id = "bEdit")
	private WebElement editBtn;

	@FindBy(id = "bDelete")
	private WebElement deleteBtn;

	@FindBy(id = "greetings")
	private WebElement greetingsPlaceHolder;

	/**
	 * 
	 * Actions can be defined below for the above web elements
	 * 
	 */

	public void clickLogoutBtn() {
		$(logOutButton).click();
	}

	public void clickAddBtn() {
		$(addBtn).click();
	}

	public void clickEditBtn() {
		$(editBtn).click();
	}

	public void clickDeleteBtn() {
		$(deleteBtn).click();
	}

	public String getGreetingsText() {
		return $(greetingsPlaceHolder).getText();
	}

}
