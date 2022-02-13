package com.salesforce.pages.opportunitiespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.salesforce.Base.BasePage;

public class OpportunitiesPage extends BasePage{

	public OpportunitiesPage(WebDriver driver1) {
		super(driver1);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Opportunities')]") WebElement opportunitiesTitle;
	@FindBy(id="fcf") WebElement oppDropDown;
	@FindBy(xpath="//input[@title='New']") WebElement newOpportunity;
	@FindBy(xpath="//a[contains(text(),'Opportunity Pipeline')]") WebElement opportunityPipeline;
	@FindBy(xpath="//h1[contains(text(),'Opportunity Pipeline')]") WebElement opportunityPipelinePage;
	@FindBy(xpath="//a[contains(text(),'Stuck Opportunities')]") WebElement opportunityStuck;
	@FindBy(xpath="//h1[contains(text(),'Stuck Opportunities')]") WebElement opportunityStuckPage;
	@FindBy(id="quarter_q") WebElement interval;
	@FindBy(id="open") WebElement status;
	@FindBy(xpath=" //input[@title='Run Report']") WebElement runReport;
	
	public void OpportunitiesPageCheck()
	{
		pageLoad(opportunitiesTitle,"Opportunities");
	}
		
	public void CheckOpportunitiesMenu()
	{
		String[] exp = {"All Opportunities","Closing Next Month","Closing This Month","Kanban","My Opportunities","New This Week","Opportunity Pipeline","Recently Viewed Opportunities","Won"};
	    dropDownValidation(exp,oppDropDown);
	    
	}
		
	public void createNewOpportunity()
	{
		clickElement(newOpportunity);
	}
	
	public void clickOpportunityPipeline()
	{
	
	
	clickElement(opportunityPipeline);
	}
	
	public void verifyOpportunityPipeline()
	{
	
	pageLoad(opportunityPipelinePage,"Opportunity Pipeline");
	}
	
	public void clickStuckOpportunity()
	{
	
	clickElement(opportunityStuck);
	}
	
	public void verifyStuckOpportunity()
	{
	
	pageLoad(opportunityStuckPage,"Stuck Opportunities");
	}
	
	public void selectInterval()
	{
	Select selectin = new Select(interval);
	selectin.selectByValue("prev1");
	report.logTestInfo("Selected interval");
	}
	
	public void selectOpportunityStatus()
	{
	
	Select selectclude = new Select(status);
	selectclude.selectByValue("closed");
	}
	
	public void clickRunReport()
	{
	
	clickElement(runReport);
	}
	
	
	
	
}
