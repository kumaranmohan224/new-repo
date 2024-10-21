package com.newdemo.framework.controller;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.ConnectLoginData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.ConnectLoginPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class ConnectLoginController extends ComponentFunctions {

	ConnectLoginPage loginPage = null;
	ConnectLoginData loginData = null;
	StudentRegistrationData StudentRegData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	public ConnectLoginController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		loginPage = PageFactory.initElements(driver, ConnectLoginPage.class);		
	}
	
	public void launchConnectURL() throws Exception
	{
		launchURL(loginData.strDTURL);
	}
	
	public void typeEmail() throws Exception
	{
		typeValue(loginPage.userName, "userName", loginData.strDTUserName);
	}
	
	public void typePassword() throws Exception
	{
		typeValue(loginPage.password, "password", loginData.strDTPassword);
	}
	
	public void waitForUserName(int intWaitTime) throws Exception
	{
		waitTillElementEnabled(loginPage.userName, "userName", intWaitTime);
		deleteAllCookies();
	}
	
	public void waitForStdUserName(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(loginPage.stdusername, "Studdent sign in page", intWaitTime);
	}
	
	public void clickSignin() throws Exception
	{
		clickObject(loginPage.signIn, "SignIn");
		
	}
	
	public void clickRemindMeLater() throws Exception
	{
		clickObject(loginPage.RemindMelater, "RemindMelater");
		
	}
	public boolean acceptAlerts() throws Exception {
		try {
			Alert objAlert = this.driver.switchTo().alert();
			String strAlertText = objAlert.getText();
			objAlert.accept();

			this.objHTMLFunctions.reportPassFailToATU("Alert with text <i>" + strAlertText + "</i> accepted", "true",
					"true");
			return true;
		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Error while accepting the alert.<br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		return false;
	}
	
	public void waitForHomeScreen(int intWaitTime) throws Exception
	{
		try
		{
			for(Integer intLoop = 0; intLoop < intWaitTime; intLoop++)
			{
				if(loginPage.home_courseContainer.getAttribute("class").toLowerCase().contains(loginPage.waitExpression().toLowerCase()))
				{
					Thread.sleep(1000);
				}
			}
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing waitForHomeScreen method in SmokeTestController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing waitForHomeScreen method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void waitForSectionHomePage(int waitTime)throws Exception
	{
		waitTillElementDisplayed(loginPage.homeIcon, "Home Icon", waitTime);		
	}
	
	
	public void dismissUpdatesNnoticesPopup() throws Exception
	{
		try
		{
			
			if(waitTillElementEnabled(loginPage.updatesNnoticesOKbutton, "Updates and Notices Popup", 10)){
				waiting(1.5);
				clickObjectUsingJSExecutor(loginPage.updatesNnoticesOKbutton, "Updates and Notices Pop Up");				
			}
			else{
				objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
			}
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed in executing dismissUpdatesNnoticesPopup method in ClassicConnectController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	public void dismissNewUpdatesNnoticesPopup() throws Exception
	{
		try
		{
			
			if(waitTillElementEnabled(loginPage.updatesNnoticesNewOKbutton, "Updates and Notices Popup", 5)){
				waiting(1.5);
				clickObjectUsingJSExecutor(loginPage.updatesNnoticesNewOKbutton, "Updates and Notices Pop Up");				
			}
			else{
				objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
			}
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed in executing dismissUpdatesNnoticesPopup method in ClassicConnectController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	public void clickSignOutButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(loginPage.signOutButton, "SignOut button",10)) {
			waiting(1.5);
			clickObject(loginPage.signOutButton, "SignOut button");
		} 
	}
	
	public void launchConnectStudentURL() throws Exception
	{
		launchURL(StudentRegData.strDTStudentURL);
	}
	
	public void typeStudentEmail() throws Exception
	{
		typeValue(loginPage.userName, "userName", StudentRegData.strDTStudentEmail);
	}
	
	public void typeStudentPassword() throws Exception
	{
		waitTillElementEnabled(loginPage.password, "password", 10);
		typeValue(loginPage.password, "password", StudentRegData.strDTPassword);
	}
	
}
