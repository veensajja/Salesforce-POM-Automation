package com.salesforce.pages.loginpages;

import org.openqa.selenium.WebDriver;

import com.salesforce.Base.BasePage;

public class CheckMailPage extends BasePage {

	public CheckMailPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	public String getTitleOfTheHomePage() {
		String title=getTitleOfThePage();
		return title;
	}
}
