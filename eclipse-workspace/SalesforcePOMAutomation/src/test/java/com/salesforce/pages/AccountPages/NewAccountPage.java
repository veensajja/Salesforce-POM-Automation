package com.salesforce.pages.AccountPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class NewAccountPage extends BasePage{

	public NewAccountPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="acc2") WebElement accountName;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']") WebElement save;
	
	
	public String getTitleOfTheNewAccountPage() {
		String title=getTitleOfThePage();
		return title;
	}

	public void enterAccountName()
	{

		enterText(accountName,"AcctTesting");
	}
	
	public void save()
	{

		clickElement(save);
		
	}
	
	
	
	
}
