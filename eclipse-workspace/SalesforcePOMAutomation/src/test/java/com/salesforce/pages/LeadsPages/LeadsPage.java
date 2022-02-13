package com.salesforce.pages.LeadsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class LeadsPage extends BasePage{

	public LeadsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[contains(text(),'Leads')]") WebElement leadsTitle;
	@FindBy(id="fcf") WebElement leadsMenu;
	@FindBy(xpath="//input[@title='Go!']") WebElement go;
	@FindBy(xpath="//select[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']/option[@selected='selected']") WebElement checkLeadOption;
	
	
	public void LeadsPageCheck()
	{
		pageLoad(leadsTitle,"Leads");
	}
		
	public void checkLeadsMenu()
	{
		String[] exp= {"All Open Leads","My Leads","Recently Viewed Leads","Today's Leads"};
		dropDownValidation(exp,leadsMenu);
	}
	
	public void clickGo()
	{

		clickElement(go);
	}
	
	public void selectTodaysDeals()
	{
		selectElement(leadsMenu,"Today's Leads");
	}
	
	public void checkLeadsViewOPtion()
	{
		
		textCheck(checkLeadOption,"Today's Leads");
	
	
	}
}
