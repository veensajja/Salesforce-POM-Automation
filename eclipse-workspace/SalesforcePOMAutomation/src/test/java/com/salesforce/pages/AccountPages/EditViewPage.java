package com.salesforce.pages.AccountPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.salesforce.Base.BasePage;

public class EditViewPage extends BasePage{

	public EditViewPage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(id="fname") WebElement changeViewName;
	@FindBy(id="fcol1") WebElement field;
	@FindBy(id="fop1") WebElement operator;
	@FindBy(id="fval1") WebElement valueA;
	@FindBy(id="colselector_select_0") WebElement availableDisplayField;
	@FindBy(id="colselector_select_1") WebElement selectedDisplayField;
	@FindBy(xpath="//img[@title='Add']") WebElement add;
	@FindBy(xpath="//img[@title='Remove']") WebElement remove;
	@FindBy(xpath="(//input[@title='Save'])[2]") WebElement save;
	@FindBy(xpath="//select[@id='colselector_select_0']//option[@value='ACCOUNT.LAST_ACTIVITY'][normalize-space()='Last Activity']") WebElement lastActivity;
	@FindBy(xpath="//select[id='colselector_select_1'] option[value='ACCOUNT.LAST_ACTIVITY']") WebElement selectLastActivity;
	
	
	public String getTitleOfTheEditViewPage() {
		String title=getTitleOfThePage();
		return title;
	}
	
	public void changeViewName()
	{
		clearElement(changeViewName);
		enterText(changeViewName,"viewtesting");	
	}
	
	public void selectField()
	{
		clickElement(field);
		Select selectacc = new Select(field);
		selectacc.selectByValue("ACCOUNT.NAME");
		clickElement(field);
		report.logTestInfo("Filtered by account name");
	}
	
	public void selectOperator()
	{
		Select selecopp = new Select(operator);
		String expectedOperator = "c";
		List<WebElement> allOpList = selecopp.getOptions();
		for (WebElement option : allOpList) {
		    String currentOpName = option.getText();
		    if (currentOpName.contains(expectedOperator)) {
		        selecopp.selectByVisibleText(currentOpName);
		        report.logTestInfo("Selected operator c");
		        break;
		    }
		}

	}
	
	public void selectAvialbleDisplayField() throws InterruptedException
	{

		        clickElement(lastActivity);
		        //	Select selectfield = new Select(availableDisplayField);
		        //	selectfield.selectByValue("ACCOUNT.LAST_ACTIVITY");
		

		report.logTestInfo("Selected available field");
		
	}
	public void selectSelectedDisplayField()
	{
		//clickElement(selectLastActivity);
		        Select selectfield = new Select(selectedDisplayField);
		    	selectfield.selectByValue("ACCOUNT.LAST_ACTIVITY");
		           
		report.logTestInfo("Selected available field");
		
	}
	public void selectSelectedFields()
	{
		
	}
	
	public void selectA()
	{
		
		enterText(valueA,"a");
	}
	
	public void clickAdd()
	{
		clickElement(add);
	}
	public void clickRemove()
	{
		clickElement(remove);
	}
	
	public void clickSave()
	{

		clickElement(save);
	}
	
}
