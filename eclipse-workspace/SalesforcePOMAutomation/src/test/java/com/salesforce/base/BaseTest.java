	package com.salesforce.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.salesforce.utility.CommonUtilities;
import com.salesforce.utility.GenerateReports;
import com.salesforce.utility.Constants;
import com.salesforce.pages.AccountPages.AccountsPage;
import com.salesforce.pages.AccountPages.CreateAccountReportPage;
import com.salesforce.pages.AccountPages.EditViewPage;
import com.salesforce.pages.AccountPages.MergeAccountsPage;
import com.salesforce.pages.AccountPages.NewAccountPage;
import com.salesforce.pages.AccountPages.NewViewPage;
import com.salesforce.pages.LeadsPages.LeadsPage;
import com.salesforce.pages.LeadsPages.NewLeadPage;
import com.salesforce.pages.UserMenuSettingsPages.DeveloperConsolePage;
import com.salesforce.pages.UserMenuSettingsPages.EditProfilePage;
import com.salesforce.pages.UserMenuSettingsPages.MyProfilePage;
import com.salesforce.pages.UserMenuSettingsPages.MySettingsPage;
import com.salesforce.pages.calendarpages.CalendarPage;
import com.salesforce.pages.calendarpages.NewEventPage;
import com.salesforce.pages.contactpages.NewContactPage;
import com.salesforce.pages.contactpages.NewContactViewPage;
import com.salesforce.pages.homepages.AllTabsPage;
import com.salesforce.pages.homepages.HomePage;
import com.salesforce.pages.loginpages.*;
import com.salesforce.pages.opportunitiespages.NewOpportunityPage;
import com.salesforce.pages.opportunitiespages.OpportunitiesPage;
import com.salesforce.pages.opportunitiespages.OpportunityReportPage;
import com.salesforce.tests.Contacts.ContactsPage; 




public class BaseTest {

	protected static WebDriver driver;
	protected static GenerateReports report=GenerateReports.getInstance();
	protected static LoginPage loginPage;
	protected static HomePage homePage;
	protected static ForgotPasswordPage forgotPasswordPage;
	protected static CheckMailPage checkMailPage;
	protected static MyProfilePage myProfilePage;
	protected static EditProfilePage editProfilePage;
	protected static MySettingsPage mySettingsPage;
	protected static DeveloperConsolePage devConsolePage;
	protected static AccountsPage accountsPage;
	protected static NewAccountPage newAccountPage;
	protected static NewViewPage newViewPage;
	protected static EditViewPage editViewPage;
	protected static MergeAccountsPage mergeAccountsPage;
	protected static CreateAccountReportPage createAccountReportPage;
	protected static OpportunitiesPage opportunitiesPage;
	protected static NewOpportunityPage newOpportunityPage;
	protected static OpportunityReportPage opportunityReportPage;
	protected static LeadsPage leadsPage;
	protected static NewLeadPage newLeadPage;
	protected static ContactsPage contactsPage;
	protected static NewContactPage newContactPage;
	protected static NewContactViewPage newContactViewPage;
	protected static AllTabsPage allTabsPage;
	protected static CalendarPage calendarPage;
	protected static NewEventPage newEventPage;
	
	@BeforeTest
	public void setUp() {
		System.out.println("Before classs is executing");
		report.startExtentReport();
		System.out.println("extent report document is created");
	}
	
	@Parameters({"browser"})
	@BeforeMethod
	public void initialSetUp(String browserName,Method method){
		report.startSingleTestReport(method.getName());
		System.out.println("Before method is executing");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get(CommonUtilities.getApplicationProperty("url"));
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		forgotPasswordPage=new ForgotPasswordPage(driver);
		checkMailPage=new CheckMailPage(driver);
		myProfilePage=new MyProfilePage(driver);
		editProfilePage=new EditProfilePage(driver);
		mySettingsPage=new MySettingsPage(driver);
		devConsolePage = new DeveloperConsolePage(driver);
		accountsPage = new AccountsPage(driver);
		newAccountPage = new NewAccountPage(driver);
		newViewPage=new NewViewPage(driver);
		editViewPage = new EditViewPage(driver);
		mergeAccountsPage = new MergeAccountsPage(driver);
		createAccountReportPage = new CreateAccountReportPage(driver);
		opportunitiesPage = new OpportunitiesPage(driver);
		newOpportunityPage = new NewOpportunityPage(driver);
		opportunityReportPage = new OpportunityReportPage(driver);
		leadsPage = new LeadsPage(driver);
		newLeadPage = new NewLeadPage(driver);
		contactsPage = new ContactsPage(driver);
		newContactPage = new NewContactPage(driver);
		newContactViewPage = new NewContactViewPage(driver);
		allTabsPage = new AllTabsPage(driver);
		calendarPage = new CalendarPage(driver);
		newEventPage = new NewEventPage(driver);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			report.logTestpassed();
		} else if(result.getStatus()==ITestResult.FAILURE) {
			report.logTestFailed();
			String path=takescreenshot();
			try {
				report.logger.addScreenCaptureFromPath(path);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		//closeAllDriver();
		driver.quit();
	}
	
	@AfterTest
	public void endUp() {
		report.endTestReport();
	}
	
	public static String takescreenshot() {
		//Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//D:\BatchProjectCodes\Dec21\SeleniumAutomation\screenshots\firebase.jpg
		String filePath=Constants.SCREENSHOT_PATH+"firebase.jpg";
		File DestFile=new File(filePath);
		//Copy file at destination
		try {
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filePath;
	}
}
