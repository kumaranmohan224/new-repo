package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class InstructorGrading extends ScriptBase {
	@Parameters({ "ParameterNValue" })
	@Test(description = "Instructor Grading", priority = 1, enabled = true)
	public void Grading(String ParameterNValue) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Grade Assignments";
			ATUReports.setAuthorInfo("Revathi S", Utils.getCurrentTime(), "2.2");
			String strDescription = "Grade non-autogradable Questions as Instructor";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_05=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			final int homeworkDataRow = 2;
			final int practiceDataRow = 3;

			// Login Connect
			loginClassicConnect();
			
			// Select Section
			selectSection();

			gradeFirstAssignment(defaultDataRow, homeworkDataRow);

			gradeSecondAssignment(defaultDataRow, practiceDataRow);

		//	 insightNavigations();

		//	 insightDistributions();
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

	public void selectSection() throws Exception {
		connect().CreateCourseAndSectionPage().selectSection(1);
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void gradeFirstAssignment(int defaultRow, int assignmentRow) throws Exception {
		Thread.sleep(1000);
		connect().InstructorGradingPage().clickAssignmentsToGrade();
		this.strDTParametersNValues = "InputDataRow=>" + assignmentRow;
		connect().InstructorGradingPage().selectAssignmentsToBeGraded();
		this.strDTParametersNValues = "InputDataRow=>" + defaultRow;
		Thread.sleep(1000);
		connect().InstructorGradingPage().waitForAssignmentHeader(10);
		connect().InstructorGradingPage().clickShowGradingQueue();
		connect().InstructorGradingPage().clickGradeByStudent();
		connect().InstructorGradingPage().waitForScoreField(20);
		connect().InstructorGradingPage().enterScoreNCommentForStudent();
		connect().InstructorGradingPage().clickNextStudent();	
		connect().InstructorGradingPage().enterScoreNCommentForStudent();
		connect().InstructorGradingPage().clickNextStudent();
		connect().InstructorGradingPage().clickLastStudent();
		connect().InstructorGradingPage().waitForAssignmentHeader(10);
		connect().InstructorGradingPage().clickGoToSectionHome();
	}

	public void gradeSecondAssignment(int defaultRow, int assignmentRow) throws Exception {
	//	connect().InstructorAreaPage().waitForAddAssignment(20);
		connect().InstructorGradingPage().clickAssignmentsToGrade();
		this.strDTParametersNValues = "InputDataRow=>" + assignmentRow;
		connect().InstructorGradingPage().selectAssignmentsToBeGraded();
		this.strDTParametersNValues = "InputDataRow=>" + defaultRow;
		Thread.sleep(1000);
		connect().InstructorGradingPage().waitForAssignmentHeader(10);
		connect().InstructorGradingPage().clickShowGradingQueue();
		connect().InstructorGradingPage().clickGradeByQuestion();
		connect().InstructorGradingPage().waitForScoreField(20);
		connect().InstructorGradingPage().enterScoreNCommentForQuestions();

		// No need for this method
		// connect().InstructorGradingPage().clickLastQuestion();

		connect().InstructorGradingPage().waitForAssignmentHeader(10);
		connect().InstructorGradingPage().clickGoToSectionHome();
	}

	public void insightNavigations() throws Exception {
		connect().InsightsPage().clickInsights();
		connect().InsightsPage().resizeBrowser();

		// Left navigation validations
		connect().InsightsPage().goToSectionHome();
		connect().InsightsPage().goToLibrary();
		connect().InsightsPage().goToGradeBook();
		connect().InsightsPage().goToReports();
		connect().InsightsPage().goToInsight();

		// Navigate to sections
		connect().InsightsPage().goToMyCourses();
		connect().CreateCourseAndSectionPage().waitForAddCourse(10);
		selectSection();
		connect().InsightsPage().clickInsights();

		connect().InsightsPage().goToSection(2);
		connect().CreateCourseAndSectionPage().clickMyCourses();
		connect().CreateCourseAndSectionPage().waitForAddCourse(10);
		selectSection();
		connect().InsightsPage().clickInsights();

		connect().InsightsPage().goToSection(3);
		connect().CreateCourseAndSectionPage().clickMyCourses();
		connect().CreateCourseAndSectionPage().waitForAddCourse(10);
		selectSection();
		connect().InsightsPage().clickInsights();

		// User account navigations
		connect().InsightsPage().goMyAccount();
		connect().CreateCourseAndSectionPage().waitForAddCourse(10);
		selectSection();
		connect().InsightsPage().clickInsights();

		connect().InsightsPage().goToTutorials();
		connect().InsightsPage().goToSupport();
		connect().InsightsPage().goToQuickGuide();

		connect().InsightsPage().maximizeBrowser();
	}

	public void insightDistributions() throws Exception {
		connect().InsightsPage().verifyQuadrantBubbles();
		connect().InsightsPage().clickQuickHelp();
		connect().InsightsPage().clickCloseQuickHelp();
		connect().InsightsPage().clickDiveDeeper();
		Thread.sleep(1000);
		connect().InsightsPage().clickInsightViewQuickHelp();
		connect().InsightsPage().clickCloseQuickHelp();
		connect().InsightsPage().selectStudentCircle();
		connect().InsightsPage().selectSeeAssignments();
		connect().InsightsPage().clickBackIcon();
		Thread.sleep(1000);
		connect().InsightsPage().clickAssignmentDistribution();
		connect().InsightsPage().clickInsightViewQuickHelp();
		connect().InsightsPage().clickCloseQuickHelp();
		connect().InsightsPage().clickViewByScore();
		connect().InsightsPage().clickviewByTime();
		connect().InsightsPage().selectAssignmentSquare();
		connect().InsightsPage().selectSeeWho();

	}

	public void logoutConnect() throws Exception {
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}
}
