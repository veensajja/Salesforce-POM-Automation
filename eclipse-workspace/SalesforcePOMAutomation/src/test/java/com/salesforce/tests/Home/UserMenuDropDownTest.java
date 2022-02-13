package com.salesforce.tests.Home;

import org.testng.Assert;
import org.testng.annotations.*;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Login.LoginTest;
import com.salesforce.utility.CommonUtilities;

public class UserMenuDropDownTest extends BaseTest{

	LoginTest ltest = new LoginTest();
	String lastname = CommonUtilities.getApplicationProperty("lastnamechange");
	String explastname = CommonUtilities.getApplicationProperty("lastnamechange");
	@Test
	public void userMenuDropDownCheck()
	{
		
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		String expuserMenuName = CommonUtilities.getApplicationProperty("usermenuname");
		String actuserMenuName = homePage.getUserMenuName();
		//Assert.assertEquals(actuserMenuName, expuserMenuName);
		Assert.assertEquals(true, actuserMenuName.contains(expuserMenuName));
		report.logTestInfo("User Menu name verified");
		homePage.clickUserMenu();
		homePage.verifyUserMenuOptions();
	}
	
	@Test
	public void MyProfileSetting() 
	{	
		userMenuDropDownCheck();
		homePage.clickMyProfileMenu();
		myProfilePage.profilePageCheck();
	}
	
	public void MySettings()
	{
		userMenuDropDownCheck();
		homePage.clickMySettings();
		
	}
	
	public void DeveloperConsole()
	{
		userMenuDropDownCheck();
		homePage.clickDeveloperConsole();
		
	}
	
	
	@Test
	public void DeveloperConsoleSetting()  
	{	
		DeveloperConsole();
		devConsolePage.checkDevConsole();
	}
	@Test
	public void MySettingsSetting() throws InterruptedException 
	{	
		MySettings();
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
	
	public void profileLastNameChange( String lastname)
	{
		myProfilePage.editProfile();
		editProfilePage.editProfileDialogBoxCheck();
		editProfilePage.switchEditFrame();
		editProfilePage.aboutContactTabCheck();
		editProfilePage.aboutTabCheck();
		editProfilePage.clickAbout();
		editProfilePage.enterLastName(lastname);
		editProfilePage.clickSave();
		myProfilePage.profilePageCheck();
		
	}
	@Test
	public void MyProfileSettingSetting() throws InterruptedException 
	{	
		MyProfileSetting();
		profileLastNameChange(lastname);
		editProfilePage.lastNameCheck(explastname);
		myProfilePage.clickPost();
		myProfilePage.enterPost();
		myProfilePage.clickShareAll();
		myProfilePage.checkPostText();
		myProfilePage.clickFile();
		myProfilePage.clickUploadButton();
		myProfilePage.chooseFile();
		myProfilePage.clickShare();
		myProfilePage.checkFileUpload();
		myProfilePage.addPhoto();
		myProfilePage.uploadPhoto();
		myProfilePage.savePhoto();
		myProfilePage.saveProfilePhoto();
		myProfilePage.checkImage();
		
		
		
	}
	
	
	@Test
	public void Logout()
	{
		userMenuDropDownCheck();
		homePage.clickLogout();
	}
	

	
}
