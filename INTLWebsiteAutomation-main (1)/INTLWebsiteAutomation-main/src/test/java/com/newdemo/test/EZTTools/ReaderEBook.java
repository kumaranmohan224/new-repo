/*package com.newdemo.test.EZTTools;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;
import com.newdemo.framework.controller.StudentRegistrationController;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class ReaderEBook extends ScriptBase
{
	StudentRegistrationController studcontroller=null;
	@Parameters({"ParameterNValue"})
	@Test(description = "Reader 17", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception
	{
		try {
			ATUReports.indexPageDescription = "Connect application automation - Course Management";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "Reader 17";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			
			final int Reader17Asignment = 11;
			final int Reader17Course=5;
					
			//Clear runtime global variables
			connect().CreateCourseAndSectionPage().clearRuntimeGlobalVariables();
			
			//Login Connect
			loginClassicConnect();
			
			//add Course
			this.strDTParametersNValues="InputDataRow=>"+Reader17Course;
			addCourse();
			
			// Create Assignment with Policy
			this.strDTParametersNValues="InputDataRow=>"+Reader17Asignment;
			createAssignment(Reader17Asignment);
			
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
		final int student1 = 5;
		
		this.strDTParametersNValues = "InputDataRow=>"+student1;
		//newStudentRegistration(1,student1);
		connect().StudentRegistrationPage().registerNewStudentPAAM(student1);

	}
	
	@Parameters({"ParameterNValue"})
	@Test(description = "Student Assignment", priority = 3, enabled = true)
	/*public void StudentTakingAssignment(String ParameterNValue) throws Exception
	{
		strDTParametersNValues = ParameterNValue;
		final int student1 = 5;
		
		waiting(5);
		this.strDTParametersNValues = "InputDataRow=>"+student1;
		connect().StudentRegistrationPage().loginStudentInPAAM();
		
		strDTParametersNValues = "InputDataRow=>3";
		connect().TakeAssignmentPage().leftSideNavigationUsingXPathNewUI("classes;"+contentTools().CreateCourseAndSectionPage().retrieveRuntimeGlobalVariable("CourseName")); 
	
		connect().TakeAssignmentPage().selectAssignment(1);
		connect().TakeAssignmentPage().clickBeginOrContinue();
		//Validate 10% deduction Message
		connect().TakeAssignmentPage().validateWelcomePage();
		//Start
		connect().TakeAssignmentPage().clickStartAssignment();
		waiting(2);
		connect().TakeAssignmentPage().clickEbookLink();
		connect().TakeAssignmentPage().checkEbookLinksPresent();
		connect().TakeAssignmentPage().validateEBookDedecution();
		connect().TakeAssignmentPage().clickCancel();
		connect().TakeAssignmentPage().clickEbookLink();
		
		//Contextual Book Link
		connect().TakeAssignmentPage().verifyEbookLinksOpeningInNewWindow();
		waiting(1);
		//ContextLess Book Link
		connect().TakeAssignmentPage().verifyContextLessEbookLinksOpeningInNewWindow();
		connect().TakeAssignmentPage().closeEbook();
	
		
		//Answer Q1  viewing EBook & 10% should be deducted
		connect().TakeAssignmentPage().answerQuestionOne();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		//SubmitAndViewResults and Validate 10% dedcution
		submitAndValidate();
		
		//Second Attempt
		connect().TakeAssignmentPage().selectAssignment(1);
		connect().TakeAssignmentPage().clickBeginOrContinue();
		
		connect().TakeAssignmentPage().validateWelcomePage();
		//Start
		connect().TakeAssignmentPage().clickStartAssignment();
		waiting(2);
		
		//Answer Q2 ebook deduction message and cancel and check full points
		connect().TakeAssignmentPage().nextQuestionPAAM();
		waiting(2);
		connect().TakeAssignmentPage().clickEbookLink();
		connect().TakeAssignmentPage().validateEBookDedecution();
		connect().TakeAssignmentPage().clickCancel();
		connect().TakeAssignmentPage().answerQuestionTwo();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		submitAndValidateSecondAttempt();
		
		//Third Attempt ContextLess Book should open where it was last visited
		connect().TakeAssignmentPage().selectAssignment(1);
		connect().TakeAssignmentPage().clickBeginOrContinue();
		
		connect().TakeAssignmentPage().validateWelcomePage();
		//Start
		connect().TakeAssignmentPage().clickStartAssignment();
		waiting(2);
		connect().TakeAssignmentPage().clickEbookLink();
		connect().TakeAssignmentPage().validateEBookDedecution();
		connect().TakeAssignmentPage().validateEbookContextLessPageOpening();
		
	}*/
	
	