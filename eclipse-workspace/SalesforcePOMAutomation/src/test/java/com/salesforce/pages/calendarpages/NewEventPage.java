package com.salesforce.pages.calendarpages;


import static org.testng.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class NewEventPage extends BasePage{

	public NewEventPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[contains(text(),'New Event')]") WebElement newEventText;
	@FindBy(id="evt5") WebElement subject;
	@FindBy(xpath="//img[@title='Subject Combo (New Window)']") WebElement subjectSearch;
	@FindBy(xpath="//h1[contains(text(),'Select a Subject below.')]") WebElement subjectWindow;
	@FindBy(xpath="//li[@class='listItem4']//a[1]") WebElement other;
	@FindBy(id="EndDateTime_time") WebElement endTime;
	@FindBy(xpath="//div[@id='simpleTimePicker']") WebElement timePicker;
	@FindBy(id="timePickerItem_38") WebElement seven;
	@FindBy(id="EndDateTime_time") WebElement sevenText;
	@FindBy(id="IsRecurrence") WebElement recurrence;
	@FindBy(xpath="//table[@class='recurrenceTable']") WebElement recurenceFrequency;
	@FindBy(id="RecurrenceStartDateTime") WebElement startDate;
	@FindBy(id="RecurrenceEndDateOnly") WebElement endDate;
	@FindBy(id="rectypeftw") WebElement weekly;
	@FindBy(xpath="//div[contains(text(),'Recurs every')]") WebElement recurrsEvery;
	@FindBy(id="wi") WebElement day;
	@FindBy(xpath="//div[@id='w']//div[2]/label") List<WebElement> weekdays;
	@FindBy(xpath="//input[@id='\"+foroption+\"']") WebElement recurringWeekday;
	@FindBy(id="RecurrenceStartDateTime") WebElement recurrenceStartDate;
	@FindBy(id="RecurrenceEndDateOnly") WebElement recurrenceEndDate;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']") WebElement save;
	//@FindBy(id="evt5") WebElement subject;
	
	public void checkNewEventPage()
	{
	
		pageLoad(newEventText,"New Event");
	}
	
	public void searchAndEnterSubject()
	{
		waitUntilVisible(subject);
		elementFocusCheck(subject,"Subject");
		String currentwindow=driver.getWindowHandle();
		clickElement(subjectSearch);
		Set<String> windows= driver.getWindowHandles();
		for(String windowHandle:windows) {
			if(!windowHandle.equals(currentwindow)) {
				driver.switchTo().window(windowHandle);
				break;
		}
		
	}
	
		pageLoad(subjectWindow,"Select a Subject below.");
		mouseOverClick(other);
		driver.switchTo().window(currentwindow);
		textCheckValue(subject,"Other");
	}
	
	public void clickSeven()
	{
		waitUntilVisible(seven);
		clickElement(seven);
	}
	public void checkSeven()
	{
		textCheckValue(sevenText,"7:00 PM");
	}
	
	public void clickEndDate()
	{

		clickElement(endTime);
	}
	
	public void checkTimePicker()
	{
	assertTrue(timePicker.isDisplayed());
	}
	
	public void checkRecurrenceDisplay()
	{
		assertTrue(recurrence.isDisplayed(),"Recurrence checkbox");
		report.logTestInfo("Recurrence is dispalyed");;
	}
	
	public void isRecurrenceChecked()
	{
		isCheckboxChecked(recurrence,"Recurrence");
	}
	
	public void checkRecurrenceFrequency()
	{
		assertTrue(recurenceFrequency.isDisplayed(),"Recurrence frequency");
		report.logTestInfo("Recurrency frequency is dispalyed");
	}
	
	public void checkStartDateDisplay()
	{

	assertTrue(startDate.isDisplayed(),"Start date");
	report.logTestInfo("Start date dispalyed");;
	}
	
	public void checkEndDateDispaly()
	{
	
	assertTrue(endDate.isDisplayed(),"End date");
	report.logTestInfo("End date dispalyed");
	}
	public void clickWeekly()
	{
		
		waitUntilVisible(weekly);
		weekly.click();
	}
	public void isWeeklySeelcted() 
	{
		assertTrue(weekly.isSelected(),"Weekly");
		report.logTestInfo("Weekly selected");
	}
	
	public void checkRecurrsEveryDispaly()
	{
	
	assertTrue(recurrsEvery.isDisplayed(),"Recurs every");
	report.logTestInfo("Recuurs every is dispalyed");
	}
	public void checkDayValue()
	{
	
	textCheckValue(day,"1");
	
	}
	
	public void selectWeekday() {
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
	    Date date=calendar.getTime();
	    String weekday = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		for(WebElement weekdayoption:weekdays)
		{
			if(weekdayoption.getText().contains(weekday))
			{
				String foroption = weekdayoption.getAttribute("for");
				WebElement wday = driver.findElement(By.xpath("//input[@id='"+foroption+"']"));
				{
					assertTrue(wday.isSelected(),"Weekday");
					report.logTestInfo("Recurring weekday selected");
					break;
				}
			}
		}
	
	}
	
	public void enterRecurrenceEndDate()
	{
		String startdt = recurrenceStartDate.getAttribute("value");
		
		//Adding 2 weeks to current date
		 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		 Calendar c = Calendar.getInstance();
		 try {
			c.setTime(sdf.parse(startdt));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 c.add(Calendar.DATE, 14);  // number of days to add
		 startdt = sdf.format(c.getTime());  // dt is now the new date
		 
		
		 enterText(recurrenceEndDate, startdt);
		 report.logTestInfo("Entered recurrence end date");
	}
	
	public void clickSave()
	{
		
		 clickElement(save);
	}
	
}
