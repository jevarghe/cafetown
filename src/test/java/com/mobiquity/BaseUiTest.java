package com.mobiquity;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import net.thucydides.core.annotations.Managed;

/**
 * 
 * Author : Jebin Varghese
 * Created : 17/04/19
 * Any property or method that is commonly used by all the UI tests can be defined here
 * 
 **/

public abstract class BaseUiTest extends BaseTest {

	@Managed
	public WebDriver webdriver;

	@Before
	public void setup() {
		webdriver.manage().deleteAllCookies();
		webdriver.manage().window().maximize();
		webdriver.get("http://cafetownsend-angular-rails.herokuapp.com");
	}

}
