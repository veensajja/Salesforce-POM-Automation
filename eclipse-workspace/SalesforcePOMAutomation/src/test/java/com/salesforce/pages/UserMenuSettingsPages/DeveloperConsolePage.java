package com.salesforce.pages.UserMenuSettingsPages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.salesforce.Base.BasePage;

public class DeveloperConsolePage extends BasePage{

	public DeveloperConsolePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	public void checkDevConsole() 
	{
	String currentWindow = driver.getWindowHandle();
	Set<String> windows=driver.getWindowHandles();
	for(String window:windows)
	{
		if(!window.equals(currentWindow))
		{
			driver.switchTo().window(window);
			WebElement log = driver.findElement(By.xpath("//span[contains(text(),'Logs')]"));
			waitUntilVisible(log);
			if(log.isDisplayed())
				report.logTestInfo("Dev Console window is opened");
			else
				report.logTestInfo("Dev Console window is not opened");
		
			driver.close();
		}
	}
	driver.switchTo().window(currentWindow);
	
	}
}
