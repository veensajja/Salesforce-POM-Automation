package com.salesforce.pages.AccountPages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class MergeAccountsPage extends BasePage{

	public MergeAccountsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id="srch") WebElement searchAccount;
	@FindBy(css="input[title='Find Accounts'][value='Find Accounts']") WebElement findAccount;
	@FindBy(xpath="//th[@scope=\"row\"]") WebElement accRows;
	@FindBy(xpath="//input[@title=\"Select row 0\"]") WebElement accRowOne;
	@FindBy(xpath="//input[@title=\"Select row 1\"]") WebElement accRowTwo;
	@FindBy(xpath="//div[contains(@class,'pbBottomButtons')]//input[contains(@title,'Next')]") WebElement next;
	@FindBy(xpath="//h1[contains(text(),'Merge My Accounts')]") WebElement mergeAccounts;
	@FindBy(xpath="//div[@class='pbTopButtons']//input[@title='Merge']") WebElement merge;
	@FindBy(xpath="//table[@class='list']//tr/th[1]") List<WebElement> accList;
	
	
	public void enterAccount()
	{
		enterText(searchAccount, "Acct");
		clickElement(searchAccount);
	}
	
	public void findAccount()
	{
		
		clickElement(findAccount);
	}
	
	public void selectAccountsToMerge() 
	{
		System.out.println(accRows.getSize());

		if(!(accRows.getSize().equals(0)))
		{
			accRowOne.click();
			accRowTwo.click();
			clickElement(next);
			Assert.assertEquals(true, mergeAccounts.isDisplayed(),"Merge my accounts is dispalyed");
			report.logTestInfo("Merge my accounts is dispalyed");
		}
	}
	
	public void Merge()
	{
		clickElement(merge);
	}
	
	
	public void accountsMergeAlert()
	{
		Alert alert = driver.switchTo().alert();
		 String alertMessage= driver.switchTo().alert().getText();
		 if(alertMessage.contains("These records will be merged"))
		 {
		 alert.accept();
		 report.logTestInfo("Merge alert accepted");
		 }
	}
	
	public void checkMergedAccount()
	{
		 
			for(WebElement acc:accList)
			{
				if(acc.getText().contains("Acct"))
				{
					report.logTestInfo("Merged Account is displayed");
					break;
				}
			}
	}
}
