package com.salesforce.tests.Contacts;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class ContactsPage extends BasePage{

	public ContactsPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//h1[contains(text(),'Contacts')]") WebElement contactPage;
	@FindBy(xpath="//input[@title='New']") WebElement newContact;
	@FindBy(xpath="//select[@id='hotlist_mode']") WebElement recentlyCreated;
	@FindBy(xpath="//select[@id='hotlist_mode']") WebElement checkRecent;
	@FindBy(id="fcf") WebElement myContacts;
	@FindBy(xpath="//input[@title='Go!']") WebElement go;
	@FindBy(xpath="//select[@id='is:islv:inlineSchedulerListView:enhancedList_listSelect']") WebElement myContactsCheck;
	@FindBy(xpath="//tbody/tr[2]/th[1]/a[1]") WebElement contact;
	@FindBy(xpath="//h2[@class='topName']") WebElement contactCheck;
	@FindBy(xpath="//h1[@class='pageType']") WebElement newContactPageCheck;
	
	
	
	public void checkContactsPage()
	{
	pageLoad(contactPage,"Contacts");
	
	}
	
	public void newContact()
	{
		
		clickElement(newContact);
	}
	
	public void selectRecentlyCreated()
	{
	
		mouseOverClick(recentlyCreated);
		selectElement(recentlyCreated, "Recently Created");
	}
	
	public void checkRecentlyCreated()
	{
		textCheck(checkRecent,"Recently Created");
	 }
	
	public void selectMyContacts()
	{
		selectElement(myContacts,"My Contacts");
		if(go.isDisplayed())
		{
			go.click();
		}
	}
	
	
	public void checkSelectMyContacts()
	{
	
	textCheck(myContactsCheck,"My Contacts");
	
	}
	
	
	public String selectContact()
	{
	String contactInfo = contact.getText();
	mouseOverClick(contact);
	return contactInfo;
	
	}
	
	public void checkSelectedContact(String contactInfo)
	{
		String checkContactInfo = contactCheck.getText();
		Assert.assertEquals(contactInfo, checkContactInfo,"Slected contact info dispalyed");
		report.logTestInfo("Selected contact info dispalyed");
	}
	
	
	public void checkViewContact()
	{
		Select select = new Select(myContacts);  

    List<WebElement> options = select.getOptions();  
    boolean check=true;
    for(WebElement we:options)  
    {  
         if (we.getText().equals("ABCD")){
        	 check =false;
        	 report.logTestInfo(we.getText()+" view is created - error");
        	 break;
         } 
     } 
    if(check==true)
    	 report.logTestInfo("view is not created");

	}
	
	public void checkCreatedNewContactPage()
	{
		
		pageLoad(newContactPageCheck,"Contact Edit");
		
	}
	
}
