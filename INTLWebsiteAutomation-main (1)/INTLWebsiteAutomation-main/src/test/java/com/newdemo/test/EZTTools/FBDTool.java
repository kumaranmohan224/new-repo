package com.newdemo.test.EZTTools;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;
import com.newdemo.framework.controller.StudentRegistrationController;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class FBDTool extends ScriptBase {
	StudentRegistrationController studcontroller=null;
	@Parameters({"ParameterNValue"})
	@Test(description = "FBD Tool", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception
	{
		try {
			ATUReports.indexPageDescription = "Connect application automation - Course Management";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "FBD Tool";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			
			final int FBDToolAsignment = 7;
			
			//Clear runtime global variables
			connect().CreateCourseAndSectionPage().clearRuntimeGlobalVariables();
			
			//Login Connect
			loginClassicConnect();
			
			//add Course
			addCourse();
			
			// Create Assignment with Policy
			this.strDTParametersNValues="InputDataRow=>"+FBDToolAsignment;
			createAssignment(FBDToolAsignment);
			
			logoutConnect();
		
			
		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}
}
	
	@Parameters({"ParameterNValue"})
	@Test(description = "Student Registration", priority = 2, enabled = true)
	public void StudentRegistration(String ParameterNValue) throws Exception
	{
		strDTParametersNValues = ParameterNValue;
		final int student1 = 2;
		
		this.strDTParametersNValues = "InputDataRow=>"+student1;
		//newStudentRegistration(1,student1);
		connect().StudentRegistrationPage().registerNewStudentPAAM(student1);

	}
	
	@Parameters({"ParameterNValue"})
	@Test(description = "Student Assignment", priority = 3, enabled = true)
	public void StudentTakingAssignment(String ParameterNValue) throws Exception
	{
		waiting(5);
		connect().StudentRegistrationPage().loginStudentInPAAM();
		
		strDTParametersNValues = "InputDataRow=>3";
		connect().TakeAssignmentPage().leftSideNavigationUsingXPathNewUI("classes;"+contentTools().CreateCourseAndSectionPage().retrieveRuntimeGlobalVariable("CourseName")); 
	
		connect().TakeAssignmentPage().selectAssignment(1);
		connect().TakeAssignmentPage().clickBeginOrContinue();
		connect().TakeAssignmentPage().clickStartAssignment();
		
		this.strDTParametersNValues="InputDataRow=>7";
		verifyQuestionMapWithoutAnswering();
		
		//Q1 Answer
		connect().TakeAssignmentPage().answerFirstQuestionFBD();
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",1);
		
		//Q2 Answer Few Forces
		connect().TakeAssignmentPage().answerFewForcesQuestionFBD();
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",2);
		
		//Q2 go back and answer few forces
		goToPreviousQuestion();
		connect().TakeAssignmentPage().clickReset();
		connect().TakeAssignmentPage().answerFewForcesQuestionFBD();
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",1);
		
		//SKip Q3 and Q4 and submit and cancel
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		submitAndCancel();
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("skipped",3);
		
		//Q5,6,7 Independant Multipart Validation
		
		connect().TakeAssignmentPage().answerIndependantMultipartFBD();
		connect().TakeAssignmentPage().nextQuestion();
		waiting(5);
		connect().TakeAssignmentPage().answerIndependantMultipartFBD();
		waiting(5);
		connect().TakeAssignmentPage().nextQuestion();
		waiting(2);
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",5);
		goToPreviousQuestion();
		connect().TakeAssignmentPage().clickReset();
		submitAndCancel();
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("skipped",6);
		
		
		
		
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
		//connect().CreateAssignmentPage().waitForQuestionSource(10);
		waiting(5);
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
		Thread.sleep(3000);
		connect().CreateAssignmentPage().clickSaveInstructions();
		Thread.sleep(2000);
	}
	
	public void createAssignment(int inputDataRow) throws Exception {

		addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		// addGradableQuestion();
		// customizeQuestionsOrder("Random",inputDataRow);
		connect().CreateAssignmentPage().selectQuestions();
		connect().CreateAssignmentPage().addSectionBreakQuestion();
		connect().CreateAssignmentPage().checkQuestionTitlesinAddQuestionsTab();
		connect().CreateAssignmentPage().addCheckedQuestionsAsIndividual();
		waiting(2);
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
		connect().CreateAssignmentPage().clickReviewNassignButton();
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);

	}
	
	public void verifyQuestionMapWithoutAnswering() throws Exception
	{
		
		connect().TakeAssignmentPage().verifyQuestionStatus();
	}
	
	public void submitAndCancel() throws Exception
	{
		connect().TakeAssignmentPage().submitAndCancel();
	}
	

	public void goToPreviousQuestion() throws Exception
	{
		connect().TakeAssignmentPage().previousQuestion();
	}
	public void logoutConnect()throws Exception
	{
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}

}
