package com.salesforce.tests.Contacts;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Login.LoginTest;

public class ContactsTest extends BaseTest{

	LoginTest ltest = new LoginTest();
	
	
	public void clickContact()
	{
		ltest.LoginSFDC();
		homePage.clickContact();
		contactsPage.checkContactsPage();
	}
	
	@Test
		public void createNewContact() 
		{
			clickContact();
			contactsPage.newContact();
			newContactPage.checkNewContactPage();
			newContactPage.enterLastName("lastContact");
			newContactPage.searchAccount();
			newContactPage.enterAccountName("AcctTesting");
			newContactPage.clickSave();	
			report.logTestInfo("New account created and saved");
		}
	
	
	
	@Test
	public void createNewContactView() 
	{
		clickContact();
		homePage.clickNewContactView();
		newContactViewPage.checkNewContactViewPage();
		newContactViewPage.enterViewName();
		newContactViewPage.enterUniqueViewName();
		newContactViewPage.clickSave();
		newContactViewPage.checkNewView();
	
	}
	
	@Test
	public void checkRecentlyCreatedContact() 
	{
		clickContact();
		contactsPage.selectRecentlyCreated();
		contactsPage.checkRecentlyCreated();
	
	}
	
	
	@Test
	public void checkMyContactsView() 
	{
		clickContact();
		contactsPage.selectMyContacts();
		contactsPage.checkSelectMyContacts();
	}
	
	
	@Test
	public void viewContact() 
	{
		clickContact();
		String contactInfo =contactsPage.selectContact();
		contactsPage.checkSelectedContact(contactInfo);
	
	}
	
	
	@Test
	public void newContactViewError() 
	{
		clickContact();
		homePage.clickNewContactView();
		newContactViewPage.checkNewContactViewPage();
		newContactViewPage.enterUniqueViewName();
		newContactViewPage.clickSave();
		newContactViewPage.checkViewErrorMsg();
		
	}	
		
	@Test
	public void cancelNewView() 
	{
		clickContact();
		homePage.clickNewContactView();
		newContactViewPage.checkNewContactViewPage();
		newContactViewPage.enterViewName("ABCD");
		newContactViewPage.enterUniqueViewName("EFGH");
		newContactViewPage.clickCancel();
		contactsPage.checkViewContact();	
		
	}
	
	@Test
	public void checkSaveAndNewView() throws InterruptedException 
	{
		clickContact();
		contactsPage.newContact();
		newContactPage.enterLastName("Indian");
		Thread.sleep(1000);
		newContactPage.enterAccountName("Global Media");
		Thread.sleep(1000);
		newContactPage.clickSaveAndNew();
		contactsPage.checkCreatedNewContactPage();
		report.logTestInfo("New contact has been created and new contact page opened");
	}
	
}
