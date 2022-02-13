package com.salesforce.pages.UserMenuSettingsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.salesforce.Base.BasePage;

public class MyProfilePage extends BasePage{

	public MyProfilePage(WebDriver driver1) {
		super(driver1);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//a[normalize-space()=\"Complete 'About Me'\"]") WebElement aboutMe;
	@FindBy(xpath="//a[@class='contactInfoLaunch editLink']") WebElement editProfile;
	@FindBy(xpath="//a[@id='publisherAttachTextPost']") WebElement post;
	@FindBy(xpath="//body") WebElement postFrameText;
	@FindBy(id="publishersharebutton") WebElement saveAll;
	@FindBy(xpath="//span/p") WebElement postText;
	@FindBy(xpath ="//span[normalize-space()='File']") WebElement file;
	@FindBy(xpath="//a[@id='chatterUploadFileAction']") WebElement uploadButton;
	@FindBy(id="chatterFile") WebElement chooseFile;
	@FindBy(id="publishersharebutton") WebElement share;
	@FindBy(xpath="//span[contains(text(),'Download')]") WebElement filecheck;
	@FindBy(id="displayBadge") WebElement addPhoto1;
	@FindBy(xpath="//a[@id='uploadLink']") WebElement addPhoto2;
	@FindBy(id="j_id0:uploadFileForm:uploadInputFile") WebElement photoUpload;
	@FindBy(id="j_id0:uploadFileForm:uploadBtn") WebElement savePhoto;
	@FindBy(id="j_id0:j_id7:save") WebElement saveProfilePhoto;
	@FindBy(xpath="//span[@class='profileImage chatter-avatarFull chatter-avatar']//img[@title='praveena last']") WebElement image;
	@FindBy(id="tailBreadcrumbNode") WebElement userName;
	
	public void editProfile()
	{
		clickElement(editProfile);
	}
	
	public void profilePageCheck() 
	{
		waitUntilVisible(aboutMe);
		pageLoad(aboutMe,"About Me");
	}
	
	public String userNameCheck()
	{
		return(userName.getText());
	}
	
	public void clickPost()
	{
		waitUntilVisible(post);
		clickElement(post);
	}
	
	public void enterPost()
	{
		frameIndexSwitch(0);
		waitUntilVisible(postFrameText);
		enterText(postFrameText,"Waste text");
		report.logTestInfo("Entered text for post");
		driver.switchTo().defaultContent();
	}
	
	public void clickShareAll()
	{
		clickElement(saveAll);
		
	}
	
	
	public void checkPostText()
	{
		waitUntilVisible(postText);
		textCheck(postText,"Waste");
	}
	
	
	public void clickFile()
	{
		clickElement(file);
	}
	
	
	public void clickUploadButton()
	{
		waitUntilVisible(uploadButton);
		jsExecutor(uploadButton);
		report.logTestInfo("Clicked upload button");;
	}
	
	public void chooseFile()
	{
		mouseOver(chooseFile);
		chooseFile.sendKeys("/Users/praveenastandard/Downloads/1.jpg");
		report.logTestInfo("Selected file");
	}
	
	public void clickShare()
	{
		clickElement(share);
	}
	
	
	public void checkFileUpload()
	{
		uploadCheck(filecheck);
	}
	
	public void addPhoto()
	{
		mouseOver(addPhoto1);
		mouseOverClick(addPhoto2);
	}
	
	public void uploadPhoto()
	{
		driver.switchTo().frame(1);
		waitUntilVisible(photoUpload);
		mouseOver(photoUpload);
		photoUpload.sendKeys("/Users/praveenastandard/Downloads/1.jpg");
	}
	
	public void savePhoto()
	{
		WebElement savePhoto = driver.findElement(By.id("j_id0:uploadFileForm:uploadBtn"));
		waitUntilVisible(savePhoto);
		clickElement(savePhoto);
		
	}
	
	public void saveProfilePhoto()
	{
		
		saveProfilePhoto.click();
		report.logTestInfo("Saved profile photo");
	}
	
	public void checkImage()
	{
		waitUntilVisible(image);
		String imgVerify = image.getAttribute("src");
		checkImgAttribute(imgVerify,"7298");
	}
	
	
	
	
	
	
	
	
	
}
