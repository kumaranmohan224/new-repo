package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class CourseManagement extends ScriptBase {
	@Parameters({ "ParameterNValue" })
	@Test(description = "Course Management", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Course Management";
			ATUReports.setAuthorInfo("Revathi S", Utils.getCurrentTime(), "2.2");
			String strDescription = "Create Course and Section";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			// Clear runtime global variables
			connect().CreateCourseAndSectionPage().clearRuntimeGlobalVariables();

			// Login Connect
			loginClassicConnect();

			// Add Course
			addCourse();
			goToMyCourses();

			// Add Section
			addSection();
			goToMyCourses();

			// Duplicate Section
			duplicateSection();
			goToMyCourses();
			verifyDuplicateSectionIssue();

			// Logout
			logoutConnect();

		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}

	}

	public void loginClassicConnect() throws Exception {
		connect().ConnectLoginPage().launchConnectURL();
		connect().ConnectLoginPage().waitForUserName(10);
		connect().ConnectLoginPage().typeEmail();
		connect().ConnectLoginPage().typePassword();
		connect().ConnectLoginPage().clickSignin();
		connect().ConnectLoginPage().waiting(5);
		connect().ConnectLoginPage().waitForHomeScreen(20);
		connect().CreateCourseAndSectionPage().waitTillLoadingElement();
		connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
	}

	public void addCourse() throws Exception {
		connect().CreateCourseAndSectionPage().waitForAddCourse(10);
		connect().CreateCourseAndSectionPage().clickAddCourse();
		connect().CreateCourseAndSectionPage().waitForTitleSearch(10);
		connect().CreateCourseAndSectionPage().typeISBN();
		connect().CreateCourseAndSectionPage().clickSearch();
		connect().CreateCourseAndSectionPage().selectBook();
		connect().CreateCourseAndSectionPage().selectBundle();
		connect().CreateCourseAndSectionPage().typeCourseName();
		connect().CreateCourseAndSectionPage().selectTimezone();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().typeSectionName(1);
		connect().CreateCourseAndSectionPage().clickCreateCourse();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().verifyCourseCreatedMessage();
		connect().CreateCourseAndSectionPage().clickEditAddress();
		connect().CreateCourseAndSectionPage().typeAddress(1);
		connect().CreateCourseAndSectionPage().clickSaveAddress();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().verifyWebAddressSavedMessage();
		connect().CreateCourseAndSectionPage().clickSectionHomeButton();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().clickProceedsectionHomeButton();
		Thread.sleep(1000);
	}

	public void goToMyCourses() throws Exception {
		connect().CreateCourseAndSectionPage().clickMyCourses();
		connect().CreateCourseAndSectionPage().waitForAddCourse(15);
	}

	public void addSection() throws Exception {
		connect().CreateCourseAndSectionPage().clickCourseOptions();
		connect().CreateCourseAndSectionPage().clickAddSection();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().typeAnotherSectionName(2);
		connect().CreateCourseAndSectionPage().clickSaveAnotherSection();
		connect().CreateCourseAndSectionPage().clickChangeSectionLink();
		connect().CreateCourseAndSectionPage().typeAnotherSectionAddress(2);
		connect().CreateCourseAndSectionPage().clickSaveSectionLink();
		connect().CreateCourseAndSectionPage().clickContinueToNewSection();
		Thread.sleep(1000);
	}

	public void duplicateSection() throws Exception {
		connect().CreateCourseAndSectionPage().clickSectionOptions(2);
		connect().CreateCourseAndSectionPage().clickDuplicateSection();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().typeDuplicateSectionName(3);
		connect().CreateCourseAndSectionPage().clickContinueToDuplicateSection();
		connect().CreateCourseAndSectionPage().clickChangeSectionLink();
		connect().CreateCourseAndSectionPage().typeAnotherSectionAddress(3);
		connect().CreateCourseAndSectionPage().clickSaveSectionLink();
		connect().CreateCourseAndSectionPage().clickContinueToNewSection();
		Thread.sleep(1000);
	}

	public void verifyDuplicateSectionIssue() throws Exception {
		connect().CreateCourseAndSectionPage().clickSectionOptions(2);
		connect().CreateCourseAndSectionPage().clickEditSection();
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().verifyEditSectionPopUp();
		// connect().CreateCourseAndSectionPage().verifySectionAddress(2); //TODO
		// continue to verify section duplication issue
		Thread.sleep(1000);
		connect().CreateCourseAndSectionPage().clickCancelEditSection();
		Thread.sleep(1000);
	}

	public void logoutConnect() throws Exception {
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}

}