package com.salesforce.pages.calendarpages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class CalendarPage extends BasePage{

	public CalendarPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[@class=\"pageType\"]") WebElement userCalendar;
	@FindBy(xpath="//a[contains(text(),'8:00 PM')]") WebElement eight;
	@FindBy(id="timePickerItem_42") WebElement nine;
	@FindBy(id="EndDateTime_time") WebElement nineText;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']") WebElement save;
	@FindBy(xpath="//a[@title='Busy - Other']") WebElement otherEvent;
	@FindBy(id="EventHoverPage_00U8c00000fql4i_page") WebElement hoverEvent;
	@FindBy(xpath="//td[contains(text(),'8:00 PM')]") WebElement hoverBlockedEight;
	@FindBy(xpath="//td[contains(text(),'9:00 PM')]") WebElement hoverBlockedNine;
	@FindBy(xpath="//a[contains(text(),'4:00 PM')]") WebElement four;
	@FindBy(xpath="//span[@id='p:f:j_id25:j_id69:20:j_id71:0:j_id72:calendarEvent:j_id84']//a[@title='Busy - Other']") WebElement recurringOtherEvent;
	@FindBy(xpath="(//h2[contains(text(),'Event Detail')])[1]") WebElement recurringHoverEvent;
	@FindBy(xpath="//td[contains(text(),'4:00 PM')]") WebElement hoverBlockedFour;
	@FindBy(xpath="//td[contains(text(),'7:00 PM')]") WebElement hoverBlockedSeven;
	@FindBy(xpath="//input[@title='Delete']") WebElement delete;
	
			
	public void checkCalendarPage() 
	{
		
		pageLoad(userCalendar,"Calendar for praveena");
	}
	public void clickFour()
	{
		clickElement(four);
	}
	
	public void clickEight()
	{
		clickElement(eight);
	}
	
	public void clickNine()
	{
		waitUntilVisible(nine);
		clickElement(nine);
	}
	
	public void checkNine()
	{

		textCheckValue(nineText,"9:00 PM");
	}
	
	
	public void clickSave()
	{
		
		clickElement(save);
	}
	
	public void checkOtherEvent()
	{
		assertTrue(otherEvent.isDisplayed(),"Otherevent is displayed");
		report.logTestInfo("Other event is Dispalyed");
	}
	
	public void validateOtherEventSchedule() throws InterruptedException
	{
		mouseOver(otherEvent);
		Thread.sleep(1000);
		//waitUntilVisible(hoverEvent);
	/*	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		assertTrue(hoverBlockedEight.isDisplayed(),"Blocked for 8pm");
		assertTrue(hoverBlockedNine.isDisplayed(),"Blocked for 9pm");
		report.logTestInfo("Event Blocked from 8 -9pm");
		clickElement(delete);
		
	}
	
	public void checkRecurringOtherEvent()
	{
	
	assertTrue(recurringOtherEvent.isDisplayed(),"Otherevent is displayed");
	report.logTestInfo("Recurring other event is displayed");
	}
	public void validateRecurringOtherEventSchedule()
	{
		mouseOver(recurringOtherEvent);
		//waitUntilVisible(recurringHoverEvent);
		
		assertTrue(hoverBlockedFour.isDisplayed(),"Blocked for 4pm");
		assertTrue(hoverBlockedSeven.isDisplayed(),"Blocked for 7pm");
		report.logTestInfo("Recurring event Blocked from 4 -7pm");
		clickElement(delete);
	}
}
