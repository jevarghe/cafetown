package com.mobiquity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import net.thucydides.core.pages.PageObject;

/**
 * 
 * Author : Jebin Varghese
 * Created : 17/04/2019
 * All the overridden methods can be implemented in this class that will be used by the pages
 * 
 **/
public abstract class BasePage extends PageObject {

	public BasePage(WebDriver driver) {
		super(driver);
	}

	// Customer Methods can be defined in this area

	private void waitForElementToBePresent(By by) {
		waitFor(ExpectedConditions.presenceOfElementLocated(by));
		waitFor(ExpectedConditions.visibilityOfElementLocated(by));
		waitFor(ExpectedConditions.elementToBeClickable(by));

	}

	private WebElement FindElement(By by) {
		waitForElementToBePresent(by);
		return getDriver().findElement(by);
	}

	public void selectOption(By by, String option) {
		if (option == null) {
			return;
		}
		Select select = new Select(FindElement(by));
		select.selectByVisibleText(option);
	}

}
