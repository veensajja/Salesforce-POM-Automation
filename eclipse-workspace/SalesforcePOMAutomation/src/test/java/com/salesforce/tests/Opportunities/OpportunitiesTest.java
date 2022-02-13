package com.salesforce.tests.Opportunities;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Login.LoginTest;

public class OpportunitiesTest extends BaseTest{

	LoginTest ltest = new LoginTest();
	
	public void verifyOpportuniitesPage() 
	{
		homePage.clickOpportunities();
		opportunitiesPage.OpportunitiesPageCheck();
	}
	@Test	
	public void verifyOpportunitiesMenu()
	{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		verifyOpportuniitesPage(); 
		opportunitiesPage.CheckOpportunitiesMenu();	
	}
	
	@Test
	public void createNewOpportunity() 
	{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		verifyOpportuniitesPage(); 
		opportunitiesPage.createNewOpportunity();
		newOpportunityPage.enterOpportunityName();
		newOpportunityPage.accountNameSearch();
		String campaignText=newOpportunityPage.campaignSearch();
		newOpportunityPage.enterCampaignName(campaignText);
		newOpportunityPage.enterCloseDate();
		newOpportunityPage.selectStage();
		newOpportunityPage.enterProbability();
		newOpportunityPage.selectLeadSource();
		newOpportunityPage.Save();
		newOpportunityPage.checkCreatedOpportunity();
		
	}
	
	@Test
	public void checkOpportunityPipelineReport() 
	{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		verifyOpportuniitesPage(); 
		opportunitiesPage.clickOpportunityPipeline();
		opportunitiesPage.verifyOpportunityPipeline();
		
	}
	
	@Test
	public void checkOpportunityStuckReport() 
	{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		verifyOpportuniitesPage(); 
		opportunitiesPage.clickStuckOpportunity();
		opportunitiesPage.verifyStuckOpportunity();
	}
	
	@Test
	public void checkQuaterlySummaryReport() 
	{
		ltest.LoginSFDC();
		homePage.isUserMenuDisplayed();
		verifyOpportuniitesPage(); 
		opportunitiesPage.selectInterval();
		opportunitiesPage.selectOpportunityStatus();
		opportunitiesPage.clickRunReport();
		opportunityReportPage.checkReportPage();
		opportunityReportPage.checkInterval();
		opportunityReportPage.checkStatus();
		
		
		
	}
	
	
	
}
