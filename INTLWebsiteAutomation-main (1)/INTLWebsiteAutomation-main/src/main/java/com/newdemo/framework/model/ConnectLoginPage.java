package com.newdemo.framework.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class ConnectLoginPage {
	
	//COmmenting this as new heclr changes cam in
	/*@FindBy(xpath="//input[@name='userName']") public WebElement userName;
	@FindBy(xpath="//input[@name='password']") public WebElement password;
	@FindBy(xpath="//*[@type='submit']") public WebElement signIn;*/
	@FindBy(xpath="//*[@id='mainCourseContainer']") public WebElement home_courseContainer;
	@FindBy(id="//span[@class='icon-home']") public WebElement homeIcon;
	@FindBy(xpath="//a[text() = 'OK']") public WebElement updatesNnoticesOKbutton;
	@FindBy(xpath="//*[@class='innerButton']/a") public WebElement updatesNnoticesNewOKbutton;
	@FindBy(xpath="//a[contains(text(),'Sign out')]") public WebElement signOutButton;
	public By stdusername = By.id("username");	
	//New HECLR changes for login page were made on 01-DEC-2021
	@FindBy(id="login-email") public WebElement userName;
	@FindBy(name="password") public WebElement password;
	@FindBy(id="login-submit-btn") public WebElement signIn;
	@FindBy(xpath="//u[normalize-space()='Remind me later']") public WebElement RemindMelater;
	
	public String waitExpression()
	{
		return "row courses-wrapper hide";
	}
}