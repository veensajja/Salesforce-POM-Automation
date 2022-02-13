package com.salesforce.tests.RandomScenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Home.UserMenuDropDownTest;
import com.salesforce.tests.Login.LoginTest;
import com.salesforce.tests.UserMenuSettings.MyProfileTest;

	
public class RandomScenarioTest extends BaseTest{
	
	LoginTest ltest = new LoginTest();
	MyProfileTest ptest = new MyProfileTest();
	UserMenuDropDownTest umenutest = new UserMenuDropDownTest();
	
	@Test
	public void verifyFirstAndLastName()
	{
		
		ltest.LoginSFDC();
		homePage.clickLoggedUser();
		String loggedUserName =homePage.checkInitialLoggedUser();
		String profilePageUserName =myProfilePage.userNameCheck();
		Assert.assertEquals(loggedUserName, profilePageUserName);
		report.logTestInfo("The logged in username page is same as profile page");
	}
	
	@Test
	public void editedUserName() throws InterruptedException
	{
		ltest.LoginSFDC();
		String initialLoggedUserName =homePage.checkReLoggedUser();
		homePage.clickLoggedUser();
		String lastName = "Abcd";
		Thread.sleep(1000);
		ptest.profileLastNameChange(lastName);
		String edittedUserName = myProfilePage.userNameCheck();
		Assert.assertNotEquals(initialLoggedUserName, edittedUserName);
		report.logTestInfo("The changed lastname is changed on profile page");
		String editedUserMenuName=homePage.getUserMenuName();
		Assert.assertNotEquals(editedUserMenuName, initialLoggedUserName);
		report.logTestInfo("The changed lastname is changed on user Menu");
		homePage.clickHome();
		Assert.assertNotEquals(lastName, initialLoggedUserName);
		report.logTestInfo("The changed last name is changed on home page");
		homePage.clickUserMenu();
		homePage.clickMyProfileMenu();
		ptest.profileLastNameChange("last");
	}
	
	@Test
	public void verifyTabCustomization() 
	{
		ltest.LoginSFDC();
		homePage.clickAllTabs();
		allTabsPage.checkAllTabsPage();
		allTabsPage.clickCustomizeTab();
		allTabsPage.checkCustomizeTab();
		mySettingsPage.removeTabFromSelected();
		mySettingsPage.checkTabInAvailable();
		mySettingsPage.clickSave();
		homePage.clickUserMenu();
		homePage.clickLogout();
		ltest.Login();
		allTabsPage.checkAllTabsOptions();
		homePage.clickAllTabs();
		allTabsPage.clickCustomizeTab();
		mySettingsPage.addTabToSelected();
		mySettingsPage.clickSave();

		
	}
	
	public void homeCalendar()
	{
		homePage.clickHomeDate();
		calendarPage.checkCalendarPage();
	}
	
	public void endDate()
	{
		newEventPage.clickEndDate();
		newEventPage.checkTimePicker();
	}
	
	
	@Test
	public void blockEventInCalendar() throws InterruptedException 
	{
		ltest.LoginSFDC();
		homeCalendar();
		calendarPage.clickEight();
		newEventPage.checkNewEventPage();
		newEventPage.searchAndEnterSubject();
		endDate();
		calendarPage.clickNine();
		calendarPage.checkNine();
		calendarPage.clickSave();
		calendarPage.checkCalendarPage();
		calendarPage.checkOtherEvent();
		calendarPage.validateOtherEventSchedule();	
		
	}
	
	@Test
	public void checkCalendarWeeklyRecurrence()
	{
		ltest.LoginSFDC();
		homeCalendar();
		calendarPage.clickFour();
		newEventPage.checkNewEventPage();
		newEventPage.searchAndEnterSubject();
		endDate();
		newEventPage.clickSeven();
		newEventPage.checkSeven();
		newEventPage.checkRecurrenceDisplay();
		newEventPage.isRecurrenceChecked();
		newEventPage.checkRecurrenceFrequency();
		newEventPage.checkStartDateDisplay();
		newEventPage.checkEndDateDispaly();
		newEventPage.clickWeekly();
		newEventPage.isWeeklySeelcted();
		newEventPage.checkRecurrsEveryDispaly();
		newEventPage.checkDayValue();
		newEventPage.selectWeekday();
		newEventPage.enterRecurrenceEndDate();
		newEventPage.clickSave();
		calendarPage.checkCalendarPage();
		calendarPage.checkRecurringOtherEvent();
		calendarPage.validateRecurringOtherEventSchedule();
		
		
		
	}
	

}
