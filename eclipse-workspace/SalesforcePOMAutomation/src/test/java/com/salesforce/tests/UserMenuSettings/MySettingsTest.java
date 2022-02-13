package com.salesforce.tests.UserMenuSettings;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Home.UserMenuDropDownTest;

public class MySettingsTest extends BaseTest{

	UserMenuDropDownTest umenutest = new UserMenuDropDownTest();
	
	@Test
	public void MySettings() throws InterruptedException 
	{	
		umenutest.MySettings();
		mySettingsPage.settingsPageCheck();
		mySettingsPage.clickPersonal();
		mySettingsPage.clickLoginHistory();
		mySettingsPage.downloadLoginHistory();
		mySettingsPage.clickDisplayFormat();
		mySettingsPage.clickCustomizeTab();
		mySettingsPage.selectCustomAppOption();
		mySettingsPage.availableOptionsReportsSelection();
		mySettingsPage.selectedOptionsReportsCheck();
		mySettingsPage.clickSave();
		mySettingsPage.checkReportsDisplay();
		mySettingsPage.clickEmail();
		mySettingsPage.clickEmailSettings();
		mySettingsPage.enterEmailSignature();
		mySettingsPage.clickSaveButton();
		mySettingsPage.checkSavedMessage();
		mySettingsPage.clickCalendar();
		mySettingsPage.clickReminder();
		mySettingsPage.openTestReminder();
		Thread.sleep(3000);
		mySettingsPage.dismissReminderWindow();
	
	}
}