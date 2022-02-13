package com.salesforce.tests.UserMenuSettings;


import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Home.UserMenuDropDownTest;
import com.salesforce.utility.CommonUtilities;


public class MyProfileTest extends BaseTest{

	UserMenuDropDownTest umenutest = new UserMenuDropDownTest();
	String lastname = CommonUtilities.getApplicationProperty("lastnamechange");
	String explastname = CommonUtilities.getApplicationProperty("lastnamechange");
	
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
	public void MyProfileSetting() throws InterruptedException 
	{	
		umenutest.MyProfileSetting();
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
	
	
}
