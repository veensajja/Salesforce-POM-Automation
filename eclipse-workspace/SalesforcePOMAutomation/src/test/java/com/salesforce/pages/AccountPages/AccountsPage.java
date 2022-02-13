package com.salesforce.pages.AccountPages;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.Base.BasePage;
import com.salesforce.utility.CommonUtilities;

public class AccountsPage extends BasePage{

	public AccountsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[contains(text(),'Accounts')]") WebElement accounts;
	@FindBy(xpath="//input[@title='New']") WebElement newAccount;
	@FindBy(xpath="//h2[contains(@class,'topName')]") WebElement accNameCheck;
	@FindBy(xpath="//a[contains(text(),'Create New View')]") WebElement newView;
	@FindBy(xpath="//select[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']") WebElement savedViewName;
	@FindBy(id="fcf") WebElement viewMenu;
	@FindBy(xpath="//a[normalize-space()='Edit']") WebElement editView;
	@FindBy(xpath="//a[contains(text(),'Accounts with last activity > 30 days')]") WebElement accActivity;


public void accountsPageCheck()
{
	
	pageLoad(accounts,"Accounts");
	
}

public void createNewAccount()
{
	clickElement(newAccount);
	
}

public void accNameCheck()
{

	Assert.assertTrue(accNameCheck.getText().contains("AcctTesting"));
	report.logTestInfo("New Account  saved");
}

public void createNewView()
{
	clickElement(newView);
}

public void checkViewAddition()
{
	String view = savedViewName.getText();
	assertTrue(view.contains("viewtest"),"New View added");
	report.logTestInfo("New view added");
}


public void clickEditView()
{
	Select select = new Select(viewMenu);
	String expectedViewName = "viewtest";
	List<WebElement> allViewList = select.getOptions();
	for (WebElement option : allViewList) {
	    String currentViewName = option.getText();
	    if (currentViewName.contains(expectedViewName)) {
	        select.selectByVisibleText(currentViewName);
			clickElement(editView);
			break;
	    }
	}
}

public void mergeAccounts()
{
	WebElement mergeacc = driver.findElement(By.xpath("//a[contains(text(),'Merge Accounts')]"));
	clickElement(mergeacc);
}


public void createAccReport()
{
	clickElement(accActivity);
}

}
