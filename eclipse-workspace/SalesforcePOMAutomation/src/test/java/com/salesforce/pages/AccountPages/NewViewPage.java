package com.salesforce.pages.AccountPages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class NewViewPage extends BasePage{

	public NewViewPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="fname") WebElement viewName;
	@FindBy(id="devname") WebElement uniqueViewName;
//	@FindBy(xpath="//input[@title='Save'])[1]") WebElement save;
	@FindBy(xpath="//body[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]") WebElement save;
	@FindBy(id="is:islv:inlineSchedulerListView:enhancedList_listSelect") WebElement newView;
	@FindBy(xpath="//div[@title='Last Activity']") WebElement lastActivity;
	@FindBy(xpath="//table[@class=\"x-grid3-row-table\"]/tbody/tr/td[4]") List <WebElement> accountList;
	
	
	
	public void enterViewName()
	{
	
	enterText(viewName,"viewtest"+getcurrenttime());
	
	}
	
	public void enterUniqueViewName()
	{
		enterText(uniqueViewName,"viewuntest"+getcurrenttime());
		clearElement(uniqueViewName);
		enterText(uniqueViewName,"viewuntest"+getcurrenttime());
	}
	
	public void clickSave()
	{
		clickElement(save);
	}
	
	public void checkNewView()
	{
		waitUntilVisible(newView);
	report.logTestInfo(newView.getText());
	assertTrue(newView.getText().contains("viewtesting"),"New view data");
	}
	
  public void checkLastActivity()
  {
	
	Assert.assertEquals(true, lastActivity.isDisplayed(),"Last activity is displayed");
  }
	
	public void accContainsA()
	{
	
	for(WebElement acc:accountList)
	{

		if(acc.getText().contains("a"))
		{
			report.logTestInfo("Accounts with 'a' are displayed");
			break;
		}
	}
	}
	
	
	
}
