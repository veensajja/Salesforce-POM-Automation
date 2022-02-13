package com.salesforce.pages.UserMenuSettingsPages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class MySettingsPage extends BasePage{

	public MySettingsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[contains(text(),'My Settings')]") WebElement mySettings;
	@FindBy(id="PersonalInfo_font") WebElement personal;
	@FindBy(xpath="//span[contains(text(),'Login History')]") WebElement loginHistory;
	@FindBy(xpath="//a[(contains(text(),'Download login history'))and(contains(text(),'csv'))]") WebElement downloadFormat;
	@FindBy(id="DisplayAndLayout_font") WebElement displayFormat;
	@FindBy(xpath="//span[contains(text(),'Customize My Tabs')]") WebElement customizeTab;
	@FindBy(xpath="//select[@id='p4']") WebElement customappdrop;
	@FindBy(xpath="//select[@id='duel_select_0']/option") List<WebElement> availableOptions;
	@FindBy(xpath="//img[@title='Add']") WebElement add;
	@FindBy(xpath="//select[@id='duel_select_1']") List<WebElement> selectedOptions;
	@FindBy(xpath="//input[@title='Save']") WebElement save;
	@FindBy(id="Chatter_Tab") WebElement salesChatterReports;
	@FindBy(id="EmailSetup_font") WebElement email;
	@FindBy(id="EmailSettings_font") WebElement emailSettings;
	@FindBy(id="signature") WebElement emailSignature;
	@FindBy(xpath="//input[@title='Save']") WebElement saveButton;
	@FindBy(id="meSaveCompleteMessage") WebElement savedMailSettings;
	@FindBy(id="CalendarAndReminders_font") WebElement calendar;
	@FindBy(id="Reminders_font") WebElement reminder;
	@FindBy(id="testbtn") WebElement testReminder;
	@FindBy(id="dismiss_all") WebElement dismissAll;
	@FindBy(xpath="//img[@title='Remove']") WebElement remove;
	@FindBy(id="duel_select_1") WebElement selectedTab;
	@FindBy(id="duel_select_0") WebElement availableTab;
	
	
	public void removeTabFromSelected()
	{
		selectElementClick(selectedTab,remove,"Forecasts");
	}
	
	public void checkTabInAvailable()
	{
		selectElementCheck(availableTab,"Forecasts");
	}
	
	public void addTabToSelected() 
	{
		selectElementClick(availableTab,add,"Forecasts");
	}
	
	
	public void settingsPageCheck() 
	{
		
		pageLoad(mySettings,"My Settings");
		
	}
	
	public void clickPersonal()
	{
		waitUntilVisible(personal);
		clickElement(personal);
	}
	
	public void clickLoginHistory()
	{
		waitUntilVisible(loginHistory);
		clickElement(loginHistory);
	}
	
	public void downloadLoginHistory()
	{
		clickElement(downloadFormat);
		if(downloadFormat.isDisplayed())
			report.logTestInfo("Downlaod Successin csv format");
		else
			report.logTestInfo("Downlaod fail");
		
	}
	
	public void clickDisplayFormat()
	{
		clickElement(displayFormat);
	}
	
	
	public void clickCustomizeTab()
	{
	clickElement(customizeTab);
	}
	
	public void selectCustomAppOption()
	{
		mouseOverClick(customappdrop);
		Select select = new Select(customappdrop);
		select.selectByVisibleText("Salesforce Chatter");
		report.logTestInfo("Salesforce Chatter selected");
	}
	
	public void availableOptionsReportsSelection()
	{
		
		List <WebElement> availableoptions= availableOptions;
		for(WebElement option:availableoptions)
		{
			if(option.getText().equalsIgnoreCase("Reports"))
			{
				mouseOverClick(option);
				clickElement(add);
				report.logTestInfo("Selected reports from available options to add");
				break;
			}
		}
		
	}
	
	public void selectedOptionsReportsCheck()
	{
	List <WebElement> selectedoptions = selectedOptions;
	for(WebElement option:selectedoptions)
	{
		if(option.getText().contains("Reports"))
		{
			mouseOverClick(option);
			report.logTestInfo("Reports have been moved to Selected Tab");
			break;
		}
	}
	
	}
	
	
	public void clickSave()
	{
		clickElement(save);
	}
	
	public void checkReportsDisplay()
	{
		Assert.assertEquals(true, salesChatterReports.isDisplayed());
			report.logTestInfo("Reports is displayed in Page");
	}
	
	public void clickEmail()
	{
	clickElement(email);
	
	}
	
	public void clickEmailSettings()
	{
	clickElement(emailSettings);
	
	}
	
	
	public void enterEmailSignature()
	{
		
		enterText(emailSignature,"xyz");
	}
	
	
	public void clickSaveButton()
	{
		clickElement(saveButton);
	}
	
	public void checkSavedMessage()
	{
		
		Assert.assertEquals(true, savedMailSettings.isDisplayed());
			report.logTestInfo("Email settings have been saved");

	}
	
	public void clickCalendar()
	{
		clickElement(calendar);
		
	}
	
	
	public void clickReminder()
	{
		clickElement(reminder);
	}
	
	public void openTestReminder()
	{

		clickElement(testReminder);
	}
	
	public void dismissReminderWindow()
	{
		String currentwindow=driver.getWindowHandle();
		Set <String> windows =driver.getWindowHandles();
		
		for(String window:windows)
		{
			if(!window.equals(currentwindow))
			{
				driver.switchTo().window(window);
				report.logTestInfo("Reminder window opened");
				waitUntilVisible(dismissAll);
				clickElement(dismissAll);
				
			}
		}
		driver.switchTo().window(currentwindow);
	}
	
	
}
