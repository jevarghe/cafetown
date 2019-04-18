package com.mobiquity.pages;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(id = "employee-list")
	private WebElement employeeList;

	/**
	 * 
	 * Actions can be defined below for the above web elements
	 * 
	 */

	public void clickLogoutBtn() {
		$(logOutButton).click();
	}

	public void clickCreateBtn() {
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

	/**
	 * This method checks in the employee list for the given employee name and
	 * brings the focus to the record
	 */

	public void selectEmployee(String employeeName) {
		List<WebElement> countriesList = employeeList.findElements(By.tagName("li"));

		countriesList
				.stream()
				.filter(element -> element.getText().contains(employeeName))
				.findFirst().get().click();
	}

	/**
	 * This method checks if an employee record is present in the employee list
	 */

	public boolean isEmployeePresent(String employeeName) {
		List<WebElement> countriesList = employeeList.findElements(By.tagName("li"));

		boolean isPresent = countriesList
								.stream()
								.anyMatch(element -> element.getText().contains(employeeName));
		return isPresent;
	}

}
