package com.newdemo.testEZTJIRA;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;
import com.newdemo.framework.controller.StudentRegistrationController;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class QuestionTitleWWTB extends ScriptBase {
	StudentRegistrationController studcontroller = null;

	@Parameters({ "ParameterNValue" })
	@Test(description = "Create Course And Assignment", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation -Question Title WWTB";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "JIRA--> HEART-1488";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			final int WWTBCourseRow = 4;
			int wwtbAssignment = 3;
			// Clear runtime global variables
			connect().CreateCourseAndSectionPage().clearRuntimeGlobalVariables();

			// Login Connect
			loginClassicConnect();

			// add Course
			this.strDTParametersNValues = "InputDataRow=>" + WWTBCourseRow;
			addCourse();
			this.strDTParametersNValues = "InputDataRow=>" + wwtbAssignment;
			createAssignment(wwtbAssignment);

		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}
	}

	@Parameters({ "ParameterNValue" })
	@Test(description = "Assignment Preview", priority = 2, enabled = true)
	public void assignmentPreviewLSIHTML() throws Exception {
		connect().CreateAssignmentPage().selectAssignment();
		waiting(3);
		connect().CreateAssignmentPage().clickAssignmentPreviewTab();
		connect().CreateAssignmentPage().checkQuestionTitleInPreview();
		logoutConnect();
	}

	@Parameters({ "ParameterNValue" })
	@Test(description = "Student Registration", priority = 3, enabled = true)
	public void StudentRegistration(String ParameterNValue) throws Exception {
		strDTParametersNValues = ParameterNValue;
		final int student1 = 4;

		this.strDTParametersNValues = "InputDataRow=>" + student1;
		newStudentRegistration(1,student1);
		//connect().StudentRegistrationPage().registerNewStudentPAAM(student1);

	}
	
	@Parameters({"ParameterNValue"})
	@Test(description = "Student Assignment", priority = 3, enabled = true)
	public void StudentTakingAssignment(String ParameterNValue) throws Exception
	{
		strDTParametersNValues = ParameterNValue;
		final int student1 = 4;
		int wwtbAssignment = 3;
		
		this.strDTParametersNValues = "InputDataRow=>"+student1;
		loginClassicConnectStudent();
		
		this.strDTParametersNValues = "InputDataRow=>"+wwtbAssignment;
		takeAssignment();
		
		//connect().StudentRegistrationPage().loginStudentInPAAM();
		
		/*strDTParametersNValues = "InputDataRow=>3";
		connect().TakeAssignmentPage().leftSideNavigationUsingXPathNewUI("classes;"+contentTools().CreateCourseAndSectionPage().retrieveRuntimeGlobalVariable("CourseName")); 
	
		connect().TakeAssignmentPage().selectAssignment(1);
		connect().TakeAssignmentPage().clickBeginOrContinue();
		connect().TakeAssignmentPage().clickStartAssignment();*/
	}

	public void loginClassicConnect() throws Exception {
		connect().ConnectLoginPage().launchConnectURL();
		connect().ConnectLoginPage().waitForUserName(10);
		connect().ConnectLoginPage().typeEmail();
		connect().ConnectLoginPage().typePassword();
		connect().ConnectLoginPage().clickSignin();
		connect().ConnectLoginPage().waitForHomeScreen(20);
		connect().CreateCourseAndSectionPage().waitTillLoadingElement();
		connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
	}

	public void loginClassicConnectStudent()throws Exception
	{ 
		connect().ConnectLoginPage().launchConnectStudentURL();
		connect().ConnectLoginPage().waitForUserName(10);		
		connect().ConnectLoginPage().typeStudentEmail();
		connect().ConnectLoginPage().typeStudentPassword();
		connect().ConnectLoginPage().clickSignin();
		Thread.sleep(1000);
		connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
		Thread.sleep(1000);
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

	public void addAssignment(int dataRow) throws Exception {
		connect().InstructorAreaPage().waitForAddAssignment(10);
		connect().CreateAssignmentPage().clickAddAssignmentButton();
		connect().CreateAssignmentPage().clickAddQuestionBank();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().waitForQuestionSource(10);
		connect().CreateAssignmentPage().selectQuestionSource();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().selectChapter();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().waitForSelectAllQuestionEnable(10);
		connect().CreateAssignmentPage().renameAssignmentName(dataRow);
		connect().CreateAssignmentPage().waitForSelectAllQuestionEnable(10);
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().clickEnterStudentInstructions();
		connect().CreateAssignmentPage().enterStudentInstructions();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickSaveInstructions();
		Thread.sleep(2000);
	}

	public void createAssignment(int inputDataRow) throws Exception {

		addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		// addGradableQuestion();
		// customizeQuestionsOrder("Random",inputDataRow);
		connect().CreateAssignmentPage().selectQuestions();
		connect().CreateAssignmentPage().checkQuestionTitlesinAddQuestionsTab();
		connect().CreateAssignmentPage().addCheckedQuestionsAsIndividual();
		waiting(2);
		connect().CreateAssignmentPage().clickOrganizeTab();
		waiting(3);
		connect().CreateAssignmentPage().checkQuestionTitlesinOrganizeTab();
		connect().CreateAssignmentPage().clickAssignmentTab();
		connect().CreateAssignmentPage().clickContinue();
		// ************************SET POLICIES***********************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		connect().CreateAssignmentPage().typeAssignmentEndDate(inputDataRow);
		connect().CreateAssignmentPage().typeAssignmentTimeZoneEndTime();
		connect().CreateAssignmentPage().editLateSubmissionType();
		connect().CreateAssignmentPage().selectAssignmentType();
		waiting(3);
		connect().CreateAssignmentPage().clickExpandAdvancedSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickEditAllSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().resourcesSettings();
		connect().CreateAssignmentPage().clickApplyChangesToThisAssignmentButton();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickReviewNassignButton();
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);

	}
	
	public void newStudentRegistration(int regStudentNumber, int dataRow) throws Exception
	{
		connect().StudentRegistrationPage().launchStudentRegistrationURL(dataRow);
		connect().StudentRegistrationPage().waitForStudentSignin(10);
		connect().StudentRegistrationPage().clickRegisterNow();
		connect().StudentRegistrationPage().waitForNewEmailAddress(10);
		connect().StudentRegistrationPage().enterNewEmailAddress(regStudentNumber,dataRow);
		connect().StudentRegistrationPage().clickSubmitButton();	
		connect().StudentRegistrationPage().waitForStdRegCode(10);
		connect().StudentRegistrationPage().enterStdRegCode();	
		connect().StudentRegistrationPage().clickRegCodeSubmitButton();
		connect().StudentRegistrationPage().waitForcompleteRegistration(10);
		connect().StudentRegistrationPage().enterEmailConfirmAddress();
		connect().StudentRegistrationPage().enterPwdConfirmPwd();
		connect().StudentRegistrationPage().enterFirstNLastName();
		connect().StudentRegistrationPage().enterSecurityQuestionNAnswer();
		connect().StudentRegistrationPage().selectSchool();
		connect().StudentRegistrationPage().clickAcceptCheckBox();
		connect().StudentRegistrationPage().clickCompleteMyRegistration();
		connect().StudentRegistrationPage().waitForGoToConnect(10);
		connect().StudentRegistrationPage().clickGoToConnectNowButton();
		connect().StudentRegistrationPage().dismissUpdatesNnoticesPopup();
		studentlogOut();
	}
	
	public void studentlogOut() throws Exception
	{	
		connect().ConnectLoginPage().clickSignOutButton();
		Thread.sleep(5000);	
		connect().ConnectLoginPage().acceptAlert();
		connect().ConnectLoginPage().waitForStdUserName(10);		
	}
	
	public void takeAssignment()throws Exception
	{ 
		connect().TakeAssignmentPage().selectAssignmentFromList();
		connect().TakeAssignmentPage().clickAndGo();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().checkQuestionTitleInStudentAssignment();
	}
	
	public void logoutConnect()throws Exception
	{
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}
}