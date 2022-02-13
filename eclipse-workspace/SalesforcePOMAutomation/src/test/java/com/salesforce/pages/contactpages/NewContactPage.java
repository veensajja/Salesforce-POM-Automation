package com.salesforce.pages.contactpages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.salesforce.Base.BasePage;

public class NewContactPage extends BasePage{

	public NewContactPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h2[normalize-space()='New Contact']") WebElement newContactPage;
	@FindBy(id="name_lastcon2") WebElement lastName;
	@FindBy(id="con4") WebElement accountName;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save']") WebElement save;
	@FindBy(xpath="//img[@title='Account Name Lookup (New Window)']") WebElement accountSearch;
	@FindBy(id="lksrch") WebElement acctSearch;
	//@FindBy(xpath="input[name*='go']") WebElement go;
	@FindBy(css="input[title='Go!']") WebElement go;
	@FindBy(xpath="//a[contains(text(),'Acct')]") WebElement acctPick;
	@FindBy(xpath="//td[@id='topButtonRow']//input[@title='Save & New']") WebElement saveAndNew;
	
	public void checkNewContactPage()
	{
		pageLoad(newContactPage,"New Contact");
	}
	
	public void enterLastName(String lastContactName)
	{
		enterText(lastName,lastContactName);
		textCheckValue(lastName,lastContactName);
	}
	
	public void searchAccount()
	{
	String currentwindow=driver.getWindowHandle();
	multipleWindows(accountSearch);
	driver.switchTo().frame(0);
	mouseOverClick(acctSearch);
	enterText(acctSearch,"Acct");
	mouseOverClick(go);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("resultsFrame");
	clickElement(acctPick);
	driver.switchTo().window(currentwindow);
	}
	
	public void enterAccountName(String accName)
	{
	
		clickElement(accountName);	
		enterText(accountName,accName);
		textCheckValue(accountName,accName);
	}
	
	public void clickSave()
	{
	clickElement(save);
	}
	
	public void clickSaveAndNew()
	{
		
		clickElement(saveAndNew);
	}
	
}
