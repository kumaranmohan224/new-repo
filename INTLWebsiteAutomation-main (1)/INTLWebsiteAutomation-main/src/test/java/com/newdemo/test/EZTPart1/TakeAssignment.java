package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class TakeAssignment extends ScriptBase {
	@Parameters({ "ParameterNValue" })
	@Test(description = "Take Assignment", priority = 1, enabled = true)
	public void StudentArea(String ParameterNValue) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Take Assignments";
			ATUReports.setAuthorInfo("Revathi S", Utils.getCurrentTime(), "2.2");
			String strDescription = "Take Assignments as Student";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_04=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			final int student1 = 2;
			final int student2 = 3;
			final int HomeworkAssignment = 2;
			final int QuizAssignment = 3;
			final int PracticeAssignment = 4;
			final int ExamAssignment = 5;
			final int ToleranceAssignment = 6;

			this.strDTParametersNValues = "InputDataRow=>" + student1;

			loginClassicConnect();

			selectSection();

			this.strDTParametersNValues = "InputDataRow=>" + defaultDataRow;
			// verifyStudentArea(); // do not run this - 

			this.strDTParametersNValues = "InputDataRow=>" + HomeworkAssignment;
			takeHomeworkAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + QuizAssignment;
			takeQuizAssignment();
			
			this.strDTParametersNValues = "InputDataRow=>" + PracticeAssignment;
			takePracticeAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + ExamAssignment;
			takeExamAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + ToleranceAssignment;
			takeToleranceAssignment();		

			logoutConnect();	

			this.strDTParametersNValues = "InputDataRow=>" + student2;

			loginClassicConnect();

			selectSection();

			// This is for rebase purpoase

			this.strDTParametersNValues = "InputDataRow=>" + HomeworkAssignment;
			takeHomeworkAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + QuizAssignment;
			takeQuizAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + PracticeAssignment;
			takePracticeAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + ExamAssignment;
			takeExamAssignment();

			this.strDTParametersNValues = "InputDataRow=>" + ToleranceAssignment;
			takeToleranceAssignment();		

			logoutConnect();
		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}
	}

	public void loginClassicConnect() throws Exception {
		connect().ConnectLoginPage().launchConnectStudentURL();
		connect().StudentRegistrationPage().newClassicFlow();
		// connect().ConnectLoginPage().waitForUserName(10);
		// connect().ConnectLoginPage().typeStudentEmail();.
	//	connect().ConnectLoginPage().typeStudentPassword();
		connect().StudentRegistrationPage().enterLoginPwdForRegisteredStudent();
	//	connect().ConnectLoginPage().clickSignin();
		Thread.sleep(3000);
		// connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
		connect().ConnectLoginPage().dismissNewUpdatesNnoticesPopup();
		Thread.sleep(1000);
	}

	public void selectSection() throws Exception {
	//	connect().CreateCourseAndSectionPage().selectSectionStudent(1);
		connect().InstructorAreaPage().waitForAddAssignment(10);
	}

	public void verifyStudentArea() throws Exception {
		// Verify Instructor Information
		// connect().TakeAssignmentPage().verifyInstructorEmail();
		connect().TakeAssignmentPage().verifyInstructorInfo();

		// Verify Messages
		connect().TakeAssignmentPage().clickSectionNotifications();
		connect().TakeAssignmentPage().verifyInstructorMessage(1);
		connect().TakeAssignmentPage().verifyInstructorMessage(2);

		// Verify Book marks
		/*
		 * connect().TakeAssignmentPage().clickViewBookmarks();
		 * connect().TakeAssignmentPage().verifyBookmark();
		 */

		// Verify Syllabus
		connect().TakeAssignmentPage().clickDownloadSyllabus();
		connect().TakeAssignmentPage().verifySyllabus();
	}

	public void takeHomeworkAssignment() throws Exception {
		// Have to change as headlessly its not working

		// connect().TakeAssignmentPage().selectAssignmentFromList();
		connect().TakeAssignmentPage().completeRegistration();
		connect().ConnectLoginPage().dismissUpdatesNnoticesPopup();
		// connect().TakeAssignmentPage().selectAssignmenToTake(1);
		connect().TakeAssignmentPage().waitForClassicStdAssignmentTable(20);
		connect().TakeAssignmentPage().selectAssignmenToTakeByTitle();
		connect().TakeAssignmentPage().clickGoButton();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);

		// connect().TakeAssignmentPage().verifyEBook();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);
		connect().TakeAssignmentPage().verifyPrint();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);

		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().verifyIncompleteQuestions();
		connect().TakeAssignmentPage().clickCancelSubmit();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");

		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().clickConfirmSubmit();
		connect().TakeAssignmentPage().verifyDetailedFeedback();
		connect().TakeAssignmentPage().clickReturnToAssignmentList();
	}

	public void takeQuizAssignment() throws Exception {
		// connect().TakeAssignmentPage().selectAssignmentFromList();
		// connect().TakeAssignmentPage().selectAssignmenToTake(2);
		connect().TakeAssignmentPage().waitForClassicStdAssignmentTable(20);
		connect().TakeAssignmentPage().selectAssignmenToTakeByTitle();
		connect().TakeAssignmentPage().clickGoButton();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);

		connect().TakeAssignmentPage().verifyFullCredit();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().verifyQuestionDropped();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");

		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().clickConfirmSubmit();
		connect().TakeAssignmentPage().verifyTotalScoresFeedback();
		connect().TakeAssignmentPage().clickReturnToAssignmentList();
		waiting(2);
	}

	public void takePracticeAssignment() throws Exception {
		waiting(2);
		// connect().TakeAssignmentPage().selectAssignmentFromList();
		// connect().TakeAssignmentPage().selectAssignmenToTake(3);
		connect().TakeAssignmentPage().waitForClassicStdAssignmentTable(20);
		connect().TakeAssignmentPage().selectAssignmenToTakeByTitle();
		connect().TakeAssignmentPage().clickGoButton();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);

		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		connect().TakeAssignmentPage().verifyIntermediaryScore();

		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().clickConfirmSubmit();
		connect().TakeAssignmentPage().verifyQuestionFeedback();
		connect().TakeAssignmentPage().clickReturnToAssignmentList();
	}

	public void takeExamAssignment() throws Exception {
		// connect().TakeAssignmentPage().selectAssignmentFromList();
		// connect().TakeAssignmentPage().selectAssignmenToTake(4);
		connect().TakeAssignmentPage().waitForClassicStdAssignmentTable(20);
		connect().TakeAssignmentPage().selectAssignmenToTakeByTitle();
		connect().TakeAssignmentPage().clickGoButton();
		connect().TakeAssignmentPage().waitForQuestionNavigator(10);

		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().answerQuestion("normal");

		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().clickConfirmSubmit();
		connect().TakeAssignmentPage().verifyNoFeedback();
		connect().TakeAssignmentPage().clickReturnToAssignmentList();
	}

	public void takeToleranceAssignment() throws Exception {
		// connect().TakeAssignmentPage().selectAssignmentFromList();
		// connect().TakeAssignmentPage().selectAssignmenToTake(5);
		connect().TakeAssignmentPage().waitForClassicStdAssignmentTable(20);
		connect().TakeAssignmentPage().selectAssignmenToTakeByTitle();
		connect().TakeAssignmentPage().clickGoButton();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);

		connect().TakeAssignmentPage().answerQuestion("tolerance");
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		// connect().TakeAssignmentPage().verifyAnswerTolerance();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().answerQuestion("tolerance");
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		// connect().TakeAssignmentPage().verifyAnswerTolerance();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().answerQuestion("tolerance");
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		connect().TakeAssignmentPage().clickContinueAnyway();
		// connect().TakeAssignmentPage().verifyAnswerTolerance();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().answerQuestion("tolerance");
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		// connect().TakeAssignmentPage().clickContinueAnyway();
		// connect().TakeAssignmentPage().verifyAnswerTolerance();
		connect().TakeAssignmentPage().verifyIntermediaryScore();
		connect().TakeAssignmentPage().clickNextQuestion();
		connect().TakeAssignmentPage().waitForScoreThisQuestion(10);
		connect().TakeAssignmentPage().answerQuestion("tolerance");
		connect().TakeAssignmentPage().clickScoreThisQuestion();
		// connect().TakeAssignmentPage().clickContinueAnyway();
		// connect().TakeAssignmentPage().verifyAnswerTolerance();
		connect().TakeAssignmentPage().verifyIntermediaryScore();

		connect().TakeAssignmentPage().clickSubmit();
		connect().TakeAssignmentPage().clickConfirmSubmit();
		connect().TakeAssignmentPage().verifyQuestionFeedback();
		connect().TakeAssignmentPage().clickReturnToAssignmentList();
	}

	public void logoutConnect() throws Exception {
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}
}