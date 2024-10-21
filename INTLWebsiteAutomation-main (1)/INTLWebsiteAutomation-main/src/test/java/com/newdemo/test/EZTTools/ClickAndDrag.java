/*package com.newdemo.test.EZTTools;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;
import com.newdemo.framework.controller.StudentRegistrationController;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class ClickAndDrag extends ScriptBase
{
	StudentRegistrationController studcontroller=null;
	@Parameters({"ParameterNValue"})
	@Test(description = "Highlighter Tool", priority = 1, enabled = true)
	public void CreateCourse(String ParameterNValue) throws Exception
	{
		try {
			ATUReports.indexPageDescription = "Connect application automation - Course Management";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "ClickAndDrag";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			
			final int ClickAndDragLAsignment = 10;
			final int ClickAndDragToolCourse=5;
					
			//Clear runtime global variables
			connect().CreateCourseAndSectionPage().clearRuntimeGlobalVariables();
			
			//Login Connect
			loginClassicConnect();
			
			//add Course
			this.strDTParametersNValues="InputDataRow=>"+ClickAndDragToolCourse;
			addCourse();
			
			// Create Assignment with Policy
			this.strDTParametersNValues="InputDataRow=>"+ClickAndDragLAsignment;
			createAssignment(ClickAndDragLAsignment);
			
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
		connect().TakeAssignmentPage().clickStartAssignment();
		
		this.strDTParametersNValues="InputDataRow=>4";
		verifyQuestionMapWithoutAnswering();
		
		//Q1 Click And Drag
		connect().TakeAssignmentPage().switchToClickAndDragQuestion();
		connect().TakeAssignmentPage().answerClickAndDrag();
		connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		waiting(2);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",1);
		
		//Q1 Undo Correct Answer and check Status
		waiting(2);
		goToPreviousQuestion();
		waiting(5);
		//connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().switchToClickAndDragQuestion();
		connect().TakeAssignmentPage().clickResetButton();
		connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		waiting(2);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusAfterUndoAnswer(1);
		
		//Q2 
		connect().TakeAssignmentPage().switchToClickAndDragQuestion();
		connect().TakeAssignmentPage().answerMCQ();
		connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		waiting(2);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("answered",2);
		connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		
		//Q4 Fill only one/few dock and check status
		connect().TakeAssignmentPage().switchToClickAndDragQuestion();
		connect().TakeAssignmentPage().AnswerFewOptions();
		waiting(2);
		connect().TakeAssignmentPage().switchBackToBrowser();
		connect().TakeAssignmentPage().nextQuestionPAAM();
		waiting(2);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusAfterUndoAnswer(4);
		
		//Q5 Skipped
		connect().TakeAssignmentPage().nextQuestionPAAM();
		submitAndCancel();
		waiting(2);
		connect().TakeAssignmentPage().clickQuestionMap();
		connect().TakeAssignmentPage().checkStatusForQuestion("skipped",5);*/
		
		
		
		
		
	