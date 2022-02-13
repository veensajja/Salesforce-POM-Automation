package com.salesforce.tests.Accounts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Login.LoginTest;
import com.salesforce.utility.CommonUtilities;

public class AccountsTest extends BaseTest{

	
LoginTest ltest = new LoginTest();
	
	@Test
	public void createAccount() throws InterruptedException
	{
	ltest.LoginSFDC();
	homePage.isUserMenuDisplayed();
	homePage.clickAccounts();
	accountsPage.accountsPageCheck();
	accountsPage.createNewAccount();
	String title = CommonUtilities.getApplicationProperty("newaccounttitle");
	Thread.sleep(1000);
	String pageTitle = newAccountPage.getTitleOfTheNewAccountPage();
	Assert.assertEquals(pageTitle,title);
	report.logTestInfo(pageTitle+" loaded");
	newAccountPage.enterAccountName();
	newAccountPage.save();
	accountsPage.accNameCheck();
	}
	
	@Test
		public void createView() throws InterruptedException
		{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		homePage.clickAccounts();
		accountsPage.accountsPageCheck();
		accountsPage.createNewView();
		newViewPage.enterViewName();
		newViewPage.enterUniqueViewName();
		newViewPage.clickSave();
		accountsPage.checkViewAddition();
		}
	
		public void addSelectAvailableDisplayField() throws InterruptedException
		{
			homePage.clickAccounts();
			accountsPage.accountsPageCheck();
			accountsPage.clickEditView();
			String title = CommonUtilities.getApplicationProperty("editviewtitle");
			String pageTitle = editViewPage.getTitleOfTheEditViewPage();
			Assert.assertEquals(pageTitle,title);
			report.logTestInfo(pageTitle+" loaded");
			editViewPage.changeViewName();
			editViewPage.selectField();
			editViewPage.selectOperator();
			editViewPage.selectA();
			editViewPage.selectAvialbleDisplayField();
			editViewPage.clickAdd();
			editViewPage.clickSave();
		}
		
		public void deleteSelectAvailableDisplayField()
		{
			homePage.clickViewAccounts();
			accountsPage.clickEditView();
			editViewPage.selectSelectedDisplayField();
			editViewPage.clickRemove();
			editViewPage.clickSave();
			
		}

		
		
		@Test
		public void editView() throws InterruptedException
		{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		addSelectAvailableDisplayField();
		newViewPage.checkNewView();
		newViewPage.checkLastActivity();
		newViewPage.accContainsA();
		//deleteSelectAvailableDisplayField();
		}
		
		@Test
		public void accountsMerge() throws InterruptedException
		{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		homePage.clickAccounts();
		accountsPage.accountsPageCheck();
		accountsPage.mergeAccounts();
		mergeAccountsPage.enterAccount();
		mergeAccountsPage.findAccount();
		mergeAccountsPage.selectAccountsToMerge();
		mergeAccountsPage.Merge();
		mergeAccountsPage.accountsMergeAlert();
		mergeAccountsPage.checkMergedAccount();
		
		}
		
		@Test
		public void createAccountReport() throws InterruptedException
		{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		homePage.clickAccounts();
		accountsPage.accountsPageCheck();
		accountsPage.createAccReport();
		createAccountReportPage.unsavedReport();
		createAccountReportPage.selectCreateDate();
		createAccountReportPage.selectTodayDate();
		createAccountReportPage.selectFromDate();
		createAccountReportPage.selectToDate();
		createAccountReportPage.previewDisplay();
		createAccountReportPage.clickSave();
		String repName=createAccountReportPage.enterReportName();
		createAccountReportPage.enterUniqueReportName();
		Thread.sleep(3000);
		createAccountReportPage.saveAndRunReport();
		createAccountReportPage.checkSavedReport(repName);
		
		}
	
	
}
