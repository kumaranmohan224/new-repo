package com.newdemo.framework.controller;

import java.awt.AWTException;
//import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.GlobalPaths;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.CreateAssignmentData;
import com.newdemo.framework.data.InstructorAreaData;
import com.newdemo.framework.data.StudentAssignmentData;
import com.newdemo.framework.model.CreateAssignmentPage;
import com.newdemo.framework.model.InstructorAreaPage;
import com.newdemo.framework.model.StudentReportsPage;
import com.newdemo.framework.model.TakeAssignmentPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class StudentReportsController extends ComponentFunctions {

	CreateAssignmentData CreateAssignData = null;
	StudentAssignmentData stdAssignmentData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	GlobalPaths Global = null;
	StudentReportsPage stdReportsPage = null;
	CreateAssignmentPage AssignmentPage = null;
	TakeAssignmentPage TakeAssignmentPage = null;
	
	public StudentReportsController(WebDriver driver, String strParametersNValues) throws Exception {
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		stdReportsPage = PageFactory.initElements(driver, StudentReportsPage.class);
		AssignmentPage = PageFactory.initElements(driver, CreateAssignmentPage.class);
		TakeAssignmentPage = PageFactory.initElements(driver, TakeAssignmentPage.class);
		Global = new GlobalPaths();
	}
	
	public void clickPerformanceTab() throws Exception {
		clickObject(stdReportsPage.performanceTab, "Student Performance Tab");
	}
	
	public void clickClassicStudentReports() throws Exception {
		waiting(1);
		clickObjectUsingJSExecutor(stdReportsPage.reports, "Classic Student Reports");
	//	waiting(5);
	}
	
	public void waitForStdAssignmentListTable(int waitTime) throws Exception {
		waitTillElementDisplayed(stdReportsPage.stdAssignmentListTable, "Student Assignment List Table", waitTime);
	}
	
	public void assignmentRow(int assignmentNum) throws Exception {
		try {
			checkObjectExists(stdReportsPage.assignmentRowList(this.driver, assignmentNum), "Assignment: " + assignmentNum);
			String assignmentRow = getTextFromElement(stdReportsPage.assignmentRowList(this.driver, assignmentNum), "Assignment: " + assignmentNum);
			this.objHTMLFunctions.ReportPassFail("Assignment: " + assignmentNum + " report details: " + assignmentRow, "true", "true");
	//		System.out.println(assignmentRow);
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Assignment: " + assignmentNum + " report details: Not Found", "true", "false");
		}
	}
	
	public void assignmentAttemptRow(int assignmentNumber, int attemptNumber) throws Exception {
		try {
			List<WebElement> assignmentList = stdReportsPage.attemptRowList(driver, assignmentNumber);
			List<WebElement> attemptList = stdReportsPage.extractAttemptsFromFullList(assignmentList);
		//	System.out.println(assignmentList.size());
		//	System.out.println(attemptList.size());
		//	System.out.println(getTextFromElement(attemptList.get(attemptNumber-1), "attempt: " + attemptNumber));
			String attemptDetails = getTextFromElement(attemptList.get(attemptNumber-1), "Attempt: " + attemptNumber);
			this.objHTMLFunctions.ReportPassFail("Assignment: " + assignmentNumber + " : " + attemptDetails, "true", "true");
			clickObject(stdReportsPage.attemptRow(this.driver, assignmentNumber, attemptNumber), "Assignment: " + assignmentNumber + " Attempt No: " + attemptNumber);
		//	System.out.println(attemptList.get(0).getTagName().toString() + "+");
			waiting(5);
			if(assignmentNumber == 1) {
				validateDetailedFeedbackReports();
			} else if(assignmentNumber == 2) {
				validateTotalScoresFeedbackReports();
			} else if(assignmentNumber == 3) {
				validateDetailedFeedbackReports();
			} else if(assignmentNumber == 4) {
				validateDetailedFeedbackReports();
			} else if(assignmentNumber == 5) {
				validateFullCreditFeedbackReports();
			}
						
			waiting(3);
			
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Assignment: " + assignmentNumber + " : Attempt No: " + attemptNumber + " : Not Found", "true", "false");
		}
	}
	
	public void validateDetailedFeedbackReports() throws Exception {
	//	waitTillElementDisplayed(stdReportsPage.stdReportsFrame, "Student Reports Frame", 15);
		switchiFrame();
		waitTillElementDisplayed(stdReportsPage.totalScore, "Total Score", 10);
		String strScore = stdReportsPage.autoGrade.getText();
		checkObjectExists(stdReportsPage.autoGrade,
				"Points earned on auto-graded questions: " + strScore);
		strScore = stdReportsPage.manualGrade.getText();
		checkObjectExists(stdReportsPage.manualGrade,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = stdReportsPage.totalScore.getText();
		checkObjectExists(stdReportsPage.totalScore, "Total Score: " + strScore);
		
		String questionTitle = "", questionScoreText = "";
		
		List<WebElement> questionNavList = selectQuestionNavStdAssignment();
		System.out.println("Total Number of question in student reports: " + questionNavList.size());
		
		waitForQuestionTitle();
		
		for(int i = 0; i < questionNavList.size(); i++) {
			waitForQuestionTitle();
			questionTitle = getTextFromElement(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + i+1);
			questionScoreText = getTextFromElement(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + i+1);
			checkObjectExists(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + (i+1) + " " + questionTitle);
			checkObjectExists(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + (i+1) + " " + questionScoreText);
			
			//Correct Incorrect Indicators Validation
			if(i + 1 == 1) {
			//	checkCorrectIncorrectIndicatorsForFirstQuestion();
			}else if(i + 1 == 2) {
			//	checkCorrectIncorrectIndicatorsForSecondQuestion();
			}else if(i + 1 == 3) {
				checkCorrectIncorrectIndicatorsForThirdQuestion();
			}else if(i + 1 == 5) {
			//	checkCorrectIncorrectIndicatorsForFifthQuestion();
			}else if(i + 1 == 7) {
				checkCorrectIncorrectIndicatorsForSeventhQuestion();
			}else if(i + 1 == 8) {
			//	checkCorrectIncorrectIndicatorsForEightQuestion();
			}else if(i + 1 == 9) {
				checkCorrectIncorrectIndicatorsForWorksheetQuestion();
			}
			
			if(i < questionNavList.size() - 1) {
				waiting(1);
				clickNextQuestion();
			//	waitForQuestionTitle();
			} else {
				break;
			}
		}
		
		switchToDefaultPage();
		clickSectionHomeButton();
	}
	
	public void validateTotalScoresFeedbackReports() throws Exception {
		switchiFrame();
		waitTillElementDisplayed(stdReportsPage.totalScore, "Total Score", 10);
		String strScore = stdReportsPage.autoGrade.getText();
		checkObjectExists(stdReportsPage.autoGrade,
				"Points earned on auto-graded questions: " + strScore);
		strScore = stdReportsPage.manualGrade.getText();
		checkObjectExists(stdReportsPage.manualGrade,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = stdReportsPage.totalScore.getText();
		checkObjectExists(stdReportsPage.totalScore, "Total Score: " + strScore);
		switchToDefaultPage();
		clickSectionHomeButton();
	}
	
	public void validateFullCreditFeedbackReports() throws Exception {
		switchiFrame();
		String fullCreditText = getTextFromElement(stdReportsPage.fullCreditHeader, "Full Credit Text Header");
		checkObjectExists(stdReportsPage.fullCreditHeader, fullCreditText);
		String totalScore = getTextFromElement(stdReportsPage.subReport, "Total Score Text");
		checkObjectExists(stdReportsPage.subReport, totalScore);
		verifyDetailedFeedbackWithSolutionPart();	//verifying detailed feedback with solution for question 1
		switchToDefaultPage();
		clickSectionHomeButton();
	}
	
	public void verifyDetailedFeedbackWithSolutionPart() throws Exception {
		//Checking detailed feedback with solution => solution part for question 1
		String feedbackSolution = getTextFromElement(TakeAssignmentPage.feedbackSolutionQs1, "Feedback Solution for Question: 1");
		checkObjectExists(TakeAssignmentPage.feedbackSolutionQs1, "Feedback Solution for Question: 1 => " + feedbackSolution);
	}
	
	public void clickNextQuestion() throws Exception {
		clickObject(stdReportsPage.nextBtn, "Next Question");
	}
		
	public void waitForQuestionTitle() throws Exception {
		String questionTitle = getTextFromElement(TakeAssignmentPage.questionTitle, "Question title");
		waitTillElementDisplayed(TakeAssignmentPage.questionTitle, "Question Title : " + questionTitle, 10);
	}	
	
	public List<WebElement> selectQuestionNavStdAssignment() throws Exception{
		clickObject(AssignmentPage.questionNavigator, "Question Navigator");
		waiting(2);
		
		return AssignmentPage.insPrevQuestionList(driver);
	}
	
	public void clickSectionHomeButton() throws Exception {
		clickObject(stdReportsPage.sectionHomeBtn, "Section Home of Classic Student");
	}
	
	public void checkCorrectIncorrectIndicatorsForFirstQuestion() throws Exception {
		checkObjectExists(stdReportsPage.firstQsIndicator1, "First Question Indicator 1");
		checkObjectExists(stdReportsPage.firstQsIndicator2, "First Question Indicator 2");
	}
	
	public void checkCorrectIncorrectIndicatorsForSecondQuestion() throws Exception {
		checkObjectExists(stdReportsPage.secondQsIndicator1, "Second Question Indicator 1");
		checkObjectExists(stdReportsPage.secondQsIndicator2, "Second Question Indicator 2");
		checkObjectExists(stdReportsPage.secondQsIndicator3, "Second Question Indicator 3");
		checkObjectExists(stdReportsPage.secondQsIndicator4, "Second Question Indicator 4");
		checkObjectExists(stdReportsPage.secondQsIndicator5, "Second Question Indicator 5");
	}
	
	public void checkCorrectIncorrectIndicatorsForThirdQuestion() throws Exception {
		checkObjectExists(stdReportsPage.thirdQsIndicator1, "Third Question Indicator 1");
	//	System.out.println("Third qs ans is: " + getAttributeFromElement(stdReportsPage.thirdQsAns, "Third qs ans", "value"));
		
	}
	
	public void checkCorrectIncorrectIndicatorsForFifthQuestion() throws Exception {
		checkObjectExists(stdReportsPage.fifthQsIndicator1, "Fifth Question Indicator 1");
		
	}
	
	public void checkCorrectIncorrectIndicatorsForSeventhQuestion() throws Exception {
		checkObjectExists(stdReportsPage.seventhQsIndicator1, "Seventh Question Indicator 1");
		
	}
	
	public void checkCorrectIncorrectIndicatorsForEightQuestion() throws Exception {
		checkObjectExists(stdReportsPage.eightQsIndicator1, "Eight Question Indicator 1");
		
	}
	
	public void checkCorrectIncorrectIndicatorsForWorksheetQuestion() throws Exception {
		checkObjectExists(stdReportsPage.worksheetQsIndicator1, "Worksheet Question Indicator 1");
		checkObjectExists(stdReportsPage.worksheetQsIndicator2, "Worksheet Question Indicator 2");
		checkObjectExists(stdReportsPage.worksheetQsIndicator3, "Worksheet Question Indicator 3");
		checkObjectExists(stdReportsPage.worksheetQsIndicator4, "Worksheet Question Indicator 4");
		
	}
	
	
}

