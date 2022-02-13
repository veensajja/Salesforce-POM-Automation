package com.salesforce.tests.Login;

import org.testng.Assert;
import org.testng.annotations.*;

import com.salesforce.base.BaseTest;
import com.salesforce.utility.CommonUtilities;


public class LoginTest extends BaseTest{

	@Test
	public void LoginErrorMessage()
	{
		String username = CommonUtilities.getApplicationProperty("username");
		loginPage.enterIntoUsername(username);
		loginPage.clearPassword();
		loginPage.clickLoginButton();
		loginPage.getPasswordErrMsg();

	}
	
	@Test
	public void LoginSFDC()
	{
		String username = CommonUtilities.getApplicationProperty("username");
		String password = CommonUtilities.getApplicationProperty("passwordname");
		String title = CommonUtilities.getApplicationProperty("homepagetitle");
		loginPage.enterIntoUsername(username);
		loginPage.enterIntoPassword(password);
		loginPage.clickLoginButton();
		homePage.closeDialogBox();
		String pageTitle = homePage.getTitleOfTheHomePage();
		Assert.assertEquals(pageTitle,title);
		report.logTestInfo(pageTitle+" loaded");
		
	}
	
	public void Login()
	{
		String username = CommonUtilities.getApplicationProperty("username");
		String password = CommonUtilities.getApplicationProperty("passwordname");
		//String title = CommonUtilities.getApplicationProperty("homepagetitle");
		loginPage.enterIntoUsername(username);
		loginPage.enterIntoPassword(password);
		loginPage.clickLoginButton();
	
	}
	
	
	@Test
	public void ForgotPassword() 
	{
		
		loginPage.clickForgotPassword();
		String title = CommonUtilities.getApplicationProperty("forgotpasswordtitle");
		System.out.println(title);
		String forgotpasswordTitle = forgotPasswordPage.getTitleOfTheHomePage();
		System.out.println(forgotpasswordTitle);
		Assert.assertEquals(forgotpasswordTitle,title);
		report.logTestInfo(forgotpasswordTitle+" loaded");
		String username = CommonUtilities.getApplicationProperty("username");
		forgotPasswordPage.enterIntoForgotUsername(username);
		forgotPasswordPage.clickContinue();
		String checkitle = CommonUtilities.getApplicationProperty("checkmailtitle");
		String checkmailtitle = checkMailPage.getTitleOfTheHomePage();
		Assert.assertEquals(checkmailtitle,checkitle);
		report.logTestInfo(checkmailtitle+" loaded");
	
	}
	
    @Test
	public void WrongUserNamePwd()
	{
		String username = "123";
		loginPage.enterIntoUsername(username);
		String password = "22131";
		loginPage.enterIntoPassword(password);	
		loginPage.clickLoginButton();
		loginPage.getWrongUsernamePasswordErrMsg();
			
	}
    
    @Test
    public void CheckRememberMe()
    {
    	String username = CommonUtilities.getApplicationProperty("username");
		String password = CommonUtilities.getApplicationProperty("passwordname");
		String title = CommonUtilities.getApplicationProperty("homepagetitle");
		loginPage.enterIntoUsername(username);
		loginPage.enterIntoPassword(password);
		loginPage.clickRememberMe();
		loginPage.clickLoginButton();
		homePage.closeDialogBox();
		String pageTitle = homePage.getTitleOfTheHomePage();
		Assert.assertEquals(pageTitle,title);
		report.logTestInfo(pageTitle+" loaded");
		homePage.clickUserMenu();
		homePage.clickLogout();
		loginPage.isRememberMeSelected();
		String actualusername = loginPage.userNameCheck();
		Assert.assertEquals(actualusername, username);
		report.logTestInfo( "Username remembered");
    	
    }

	
}