package com.salesforce.pages.contactpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class NewContactViewPage extends BasePage{

	public NewContactViewPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h2[contains(text(),'Create New View')]") WebElement newViewPage;
	@FindBy(id="fname") WebElement viewName;
	@FindBy(id="devname") WebElement uniqueViewName;
	@FindBy(xpath="(//input[@title='Save'])[1]") WebElement save;
	@FindBy(xpath="//select[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']//option[@selected='selected']") WebElement checkView;
	@FindBy(xpath="//div[@class='requiredInput']//div[@class='errorMsg']") WebElement errorMsg;
	@FindBy(xpath="(//input[@title='Cancel'])[1]") WebElement cancel;
	

	public void checkNewContactViewPage()
	{
		pageLoad(newViewPage,"Create New View");
	}
	
	public void enterViewName()
	{
		enterText(viewName,"ViewTesting"+getcurrenttime());
		textCheckValue(viewName,"ViewTesting");
	}
	
	public void enterViewName(String viewname)
	{
		enterText(viewName,viewname);
		textCheckValue(viewName,viewname);
	}
	
	public void enterUniqueViewName()
	{
		clickElement(uniqueViewName);
	}
	
	public void enterUniqueViewName(String uviewname)
	{
		enterText(uniqueViewName,uviewname);
		textCheckValue(uniqueViewName,uviewname);
	}
	
	public void clickSave()
	{
		clickElement(save);
	}
	
	public void checkNewView()
	{
		textCheck(checkView,"ViewTesting");
		Assert.assertTrue(driver.getTitle().contains("Contacts"), "Homepageloaded");
		report.logTestInfo("New view created");
	}
	
	
	public void checkViewErrorMsg()
	{

		String expErrorMsg=" You must enter a value";
		Assert.assertTrue(errorMsg.getText().contains(expErrorMsg));
		report.logTestInfo("View error message displayed");
	}
	
	
	
	
	public void clickCancel()
	{
		clickElement(cancel);
	}
		
	
	
	
}
