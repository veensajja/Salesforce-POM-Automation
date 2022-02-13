package com.salesforce.pages.LeadsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class NewLeadPage extends BasePage{

	public NewLeadPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[normalize-space()='New Lead']") WebElement newLeadPage;
	@FindBy(id="name_lastlea2") WebElement lastName;
	@FindBy(id="lea3") WebElement companyName;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']") WebElement save;
	@FindBy(xpath="//h2[contains(text(),'ABCD')]") WebElement newLeadNamePage;
	
	
	
	public void checkNewLeadPage()
	{
		pageLoad(newLeadPage,"New Lead");
	}
	
	public void enterLastName()
	{
		enterText(lastName,"ABCD");
		textCheckValue(lastName,"ABCD");
	}
	
	public void enterCompanyName()
	{
	
		enterText(companyName,"ABCD");
		textCheckValue(companyName,"ABCD");
	}
	
	public void clickSave()
	{
		clickElement(save);
	}
	
	public void checkCreatedNewLeadPage()
	{
		pageLoad(newLeadNamePage,"ABCD");
	}
	
	
	
}
