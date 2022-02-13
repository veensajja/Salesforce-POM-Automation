package com.salesforce.tests.UserMenuSettings;

import org.testng.annotations.Test;

import com.salesforce.base.BaseTest;
import com.salesforce.tests.Home.UserMenuDropDownTest;

public class DevConsoleTest extends BaseTest{

	UserMenuDropDownTest umenutest = new UserMenuDropDownTest();
	
	@Test
	public void DeveloperConsole()  
	{	
		umenutest.DeveloperConsole();
		devConsolePage.checkDevConsole();
	}
	
}
