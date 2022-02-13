package com.salesforce.pages.AccountPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class CreateAccountReportPage extends BasePage{

	public CreateAccountReportPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[contains(text(),'Unsaved Report')]") WebElement unsavedReport;
	@FindBy(id="ext-gen20") WebElement createDate;
	@FindBy(xpath="//div[contains(text(),'Created Date')]") WebElement todayDate;
	@FindBy(id="ext-gen152") WebElement fromDate;
	@FindBy(id="ext-gen256") WebElement currDate;
	@FindBy(id="ext-gen154") WebElement toDate;
	@FindBy(id="ext-gen271") WebElement currDateBox;
	@FindBy(xpath="//div[@class='rb-preview-warning']") WebElement preview;
	@FindBy(id="ext-gen49") WebElement save;
	@FindBy(id="saveReportDlg_reportNameField") WebElement reportName;
	@FindBy(id="saveReportDlg_DeveloperName)") WebElement uniqueReportName;
	@FindBy(id="ext-comp-1067") WebElement description;
	@FindBy(id="dlgSaveAndRun") WebElement saveAndRunReport;
	@FindBy(xpath="//h1[@class=\"noSecondHeader pageType\"]") WebElement reportTitle;
	
	//input[@id='saveReportDlg_DeveloperName']
	
	public void unsavedReport()
	{
		
		Assert.assertEquals(true, unsavedReport.isDisplayed(),"Unsaved report is loaded");
		report.logTestInfo("Unsaved report is loaded");
	}
	
	public void selectCreateDate()
	{
	
	clickElement(createDate);
	}
	
	public void selectTodayDate()
	{
		
	clickElement(todayDate);
	
	}
	
	public void selectFromDate()
	{
	clickElement(fromDate);
	mouseOverClick(currDate);
	}
	
	public void selectToDate()
	{
	clickElement(toDate);
	mouseOverClick(currDateBox);
	}
	
	public void previewDisplay()
	{
	Assert.assertEquals(true, preview.isDisplayed(),"List of accounts displayed");
	report.logTestInfo("List of accounts displayed");
	}
	
	public void clickSave()
	{
	clickElement(save);
	}
	
	public String enterReportName()
	{
		String repName = "report1"+getcurrenttime();
		enterText(reportName,repName);
		return repName;
	}
	
	public void enterUniqueReportName()
	{
		
		clickElement(description);
	}
	
	public void saveAndRunReport()
	{
		
		clickElement(saveAndRunReport);
	}
	
	public void checkSavedReport(String string) throws InterruptedException
	{
		pageLoad(reportTitle,string);
	}
	
	
	
}
