package com.salesforce.pages.opportunitiespages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class NewOpportunityPage extends BasePage{

	public NewOpportunityPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="opp3") WebElement opportunityName;
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']") WebElement acctNameSearch;
	@FindBy(id="lksrch") WebElement acctSearch;
	@FindBy(css="input[title='Go!']") WebElement go;
	@FindBy(xpath="//a[contains(text(),'Acct')]") WebElement acctPick;
	@FindBy(id="opp4") WebElement accountName;
	@FindBy(xpath="//tbody/tr[4]/td[2]/span[1]/a[1]/img[1]") WebElement campaignSearch;
	@FindBy(id="lksrch") WebElement campNameSearch;
	@FindBy(css="input[name*='go']") WebElement gogo;
	@FindBy(xpath="//tr[@class='dataRow even first']/th") WebElement campaignPick;
	@FindBy(id="opp17") WebElement campaignName;
	@FindBy(xpath="//span[@class=\"dateFormat\"]/a") WebElement currentDate;
	@FindBy(id="opp11") WebElement stage;
	@FindBy(id="opp12") WebElement probability;
	@FindBy(id="opp6") WebElement source;
	@FindBy(xpath="//td[@id='bottomButtonRow']//input[@title='Save']") WebElement save;
	@FindBy(xpath="//h1[contains(text(),'Opportunity')]") WebElement newOpportunityPage;
	@FindBy(xpath="//div[@id='opp3_ileinner']") WebElement oppName;
	@FindBy(xpath="//div[@id=\"opp4_ileinner\"]/a") WebElement accName;
	@FindBy(xpath="//div[@id=\"opp17_ileinner\"]/a") WebElement campName;
	
	
	public void enterOpportunityName()
	{
		enterText(opportunityName,"opp"+getcurrenttime());
	}
	
	public void accountNameSearch()
	{
		String currentwindow=driver.getWindowHandle();
		multipleWindows(acctNameSearch);
		driver.switchTo().frame(0);
		mouseOverClick(acctSearch);
		enterText(acctSearch,"Acct");
		mouseOverClick(go);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		clickElement(acctPick);
		driver.switchTo().window(currentwindow);
		clickElement(accountName);
		report.logTestInfo("Account name entered");
	}
	
	public String campaignSearch()
	{

		String currentwindowcamp=driver.getWindowHandle();
		multipleWindows(campaignSearch);
		driver.switchTo().frame(0);
		mouseOverClick(campNameSearch);
		enterText(campNameSearch,"Cust");
		mouseOverClick(gogo);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		clickElement(campaignPick);
		String camptext = campaignPick.getText();
		Assert.assertTrue(camptext.contains("Cust"));
			report.logTestInfo("Campaign entered");	
		driver.switchTo().window(currentwindowcamp);
		return camptext;
	}
	
	public void enterCampaignName(String string)
	{
		clickElement(campaignName);
		enterText(campaignName,string);
	}
	
	public void enterCloseDate()
	{
		clickElement(currentDate);
		report.logTestInfo("Entered close date");
	}
	
	public void selectStage()
	{
		Select selectstage = new Select(stage);
		selectstage.selectByValue("Proposal");
	}
			
	public void enterProbability()
	{
		enterText(probability,"10");
	}
	
	public void selectLeadSource()
	{
		Select selectsource = new Select(source);
		selectsource.selectByValue("Employee Referral");
	}
	
	public void Save()
	{
		WebElement save = driver.findElement(By.xpath("//td[@id='bottomButtonRow']//input[@title='Save']"));
		clickElement(save);
	}
	
	public void checkCreatedOpportunity()
	{
	
	pageLoad(newOpportunityPage,"Opportunity");
	textCheck(accName,"Acct");
	textCheck(oppName,"opp");
	textCheck(campName,"Cust");
	}
	
	
}
