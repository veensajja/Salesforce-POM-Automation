package com.salesforce.tests.Leads;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Login.LoginTest;

public class LeadsTest extends BaseTest{

	
LoginTest ltest = new LoginTest();
	
@Test
	public void verifyLeadsPage() 
	{
		ltest.LoginSFDC();
		homePage.clickLeads();
		leadsPage.LeadsPageCheck();
	}
	
@Test
public void checkLeadsMenu()
{
	verifyLeadsPage();
	leadsPage.checkLeadsMenu();
	
}


@Test
public void checkDefaultView() 
{
	verifyLeadsPage();
	leadsPage.selectTodaysDeals();
	leadsPage.clickGo();
	leadsPage.checkLeadsViewOPtion();
	homePage.clickUserMenu();
	homePage.clickLogout();
	ltest.Login();
	homePage.clickLeads();
	leadsPage.clickGo();
	leadsPage.checkLeadsViewOPtion();
	report.logTestInfo("The lead page is loaded with the same option selected in the previous session");
}


@Test
public void checkNewLead() 
{
	verifyLeadsPage();
	homePage.clickNewLead();
	newLeadPage.checkNewLeadPage();
	newLeadPage.enterLastName();
	newLeadPage.enterCompanyName();
	newLeadPage.clickSave();
	newLeadPage.checkCreatedNewLeadPage();

}

}