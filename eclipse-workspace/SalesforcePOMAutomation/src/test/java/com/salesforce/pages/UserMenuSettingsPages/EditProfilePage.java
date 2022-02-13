package com.salesforce.pages.UserMenuSettingsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;
import com.salesforce.utility.CommonUtilities;

public class EditProfilePage extends BasePage{

	
	public EditProfilePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//h2[@id='contactInfoTitle']") WebElement editProfileDialogBox;
	@FindBy(id="contactInfoContentId") WebElement editProfileFrame;
	@FindBy(xpath="//a[contains(text(),'Contact')]") WebElement contactTab;
	@FindBy(xpath="//a[contains(text(),'About')]") WebElement aboutTab;
	@FindBy(id="lastName") WebElement lastName;
	//"//body/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"
	@FindBy(xpath="//input[@value='Save All']") WebElement save;
	@FindBy(id="tailBreadcrumbNode") WebElement lastNameChange;
	
	
	public void editProfileDialogBoxCheck()
	{
		dialogBoxCheck(editProfileDialogBox,"Edit Profile");
	}
	
	public void switchEditFrame()
	{
		frameElementSwitch(editProfileFrame);
	}
	
	public void aboutContactTabCheck()
	{
		enableCheck(contactTab);
	}
	
	
	public void aboutTabCheck()
	{
		enableCheck(aboutTab);
	}
	
	public void clickAbout()
	{
		clickElement(aboutTab);
	}
	
	
	public void enterLastName(String lastname)
	{

		enterText(lastName,lastname);
	}
	
	public void clickSave()
	{
		clickElement(save);
	}
	
	public void lastNameCheck(String explastname)
	{
		textCheck(lastNameChange,explastname);
		Assert.assertTrue(lastNameChange.getText().contains(explastname));
	}
	
}
