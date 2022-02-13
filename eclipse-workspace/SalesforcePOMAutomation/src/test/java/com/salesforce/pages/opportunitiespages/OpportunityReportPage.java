package com.salesforce.pages.opportunitiespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class OpportunityReportPage extends BasePage{

	public OpportunityReportPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[contains(text(),'Opportunity Report')]") WebElement opportunityReportPage;
	@FindBy(xpath="//select[@id='open']/option[@selected='selected']") WebElement checkStatus;
	@FindBy(xpath="//select[@id='quarter_q']//optgroup[@label='Fiscal Quarter']//option[@selected='selected']") WebElement checkInterval;
	
	public void checkReportPage()
	{
	pageLoad(opportunityReportPage,"Opportunity Report");
	}
	
	public void checkStatus()
	{
	textCheck(checkStatus,"Closed");
	}
	
	public void checkInterval()
	{
	textCheck(checkInterval,"Previous FQ");
	}
	
	
}
