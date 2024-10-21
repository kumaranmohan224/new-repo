package com.newdemo.testEZTJIRA;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class DeletMultipleCourses extends ScriptBase{

	@Parameters({"ParameterNValue"})
	@Test(description = "Create Course And Assignment", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception
	{
		try {
			ATUReports.indexPageDescription = "Connect application automation - Course Management";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "Delete Multiple Courses";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			
			loginClassicConnect();
			
		//	DeleteMultipleSectionss();
			
			
}catch(Exception ex)
		{
		objHTMLFunctions.reportPassFailToATU(ex.getMessage(), "Exception", "MESSAGE");
		}
	}
	
	public void loginClassicConnect() throws Exception
	{ 
		connect().ConnectLoginPage().launchConnectURL();
		connect().ConnectLoginPage().waitForUserName(10);		
		connect().ConnectLoginPage().typeEmail();
		connect().ConnectLoginPage().typePassword();
		connect().ConnectLoginPage().clickSignin();
		connect().ConnectLoginPage().waitForHomeScreen(20);
		connect().CreateCourseAndSectionPage().waitTillLoadingElement();
		connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
	}	
	
	/*public void DeleteMultipleSectionss() throws Exception
	{
		connect().CreateCourseAndSectionPage().Delete();
	}*/
}