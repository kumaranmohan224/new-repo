package com.newdemo.framework.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.CreateAssignmentData;
import com.newdemo.framework.data.InstructorGradingData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.InstructorGradingPage;
import com.newdemo.framework.model.StudentReportsPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class InstructorGradingController extends ComponentFunctions {
	
	InstructorGradingPage InsGradingPage = null;
	InstructorGradingData InsGradingData = null;
	CreateAssignmentData CreateAssignData = null;
	StudentRegistrationData StudentData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	StudentReportsPage stdReportsPage = null;
	
	public InstructorGradingController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		InsGradingPage = PageFactory.initElements(driver, InstructorGradingPage.class);
		stdReportsPage = PageFactory.initElements(driver, StudentReportsPage.class);
	}
	
	public void clickAssignmentsToGrade()throws Exception
	{
		clickObject(InsGradingPage.assignmentsToGrade, "Assignments to Grade");
		waiting(2);	
	}
	
	public void selectAssignmentsToBeGraded()throws Exception
	{
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		System.out.println("Assignment Name retrieved from excel: " + assignmentName);
		List<WebElement> assignments = InsGradingPage.assignmentToGrade;
		System.out.println("Assignment List size retrieved from WebElement List: " + assignments.size());
		for(int i=0; i<=assignments.size()-1; i++){
		//	String[] assignment = InsGradingPage.assignmentToGrade.get(i).getText().trim().split(" \\(");
			String assignment = InsGradingPage.assignmentToGrade.get(i).getText();
			System.out.println("assignment : " + assignment);
			String assignmentRev = reverseOfString(assignment);
			System.out.println("assignmentRev : " + assignmentRev);
		    String assignmentActual = reverseOfString(assignmentRev.trim().split("\\( ")[1]);
		    System.out.println("Assignment actual : " + assignmentActual);
			if(assignmentName.equalsIgnoreCase(assignmentActual)){ 
				clickObject(InsGradingPage.assignmentToGrade.get(i), "Assignment to be Graded: "+assignmentName);
				System.out.println(assignmentName + " : " + assignmentActual + " Both Names Matched");
				break;
			}
		}		
		waiting(2);	
	}
	
	public static String reverseOfString(String str){
		
		String rev = "";
		for(int i=str.length()-1; i>=0; i--){
			rev = rev + str.charAt(i);
		}
		return rev;
	}
	
	public void waitForAssignmentHeader(int waitTime)throws Exception
	{
		waitTillElementDisplayed(InsGradingPage.assignmentHeader, "Assignment Header", waitTime);		
	}
	
	public void clickShowGradingQueue()throws Exception
	{
		clickObject(InsGradingPage.showGradingQueue, "Show Grading Queue");
		waiting(2);	
	}
	
	public void clickGradeByQuestion()throws Exception
	{
		clickObject(InsGradingPage.gradeByQuestion, "Grade by Question");
	//	waiting(2);	
		System.out.println("Leaving clickGradeByQuestion method----");
	}
	
	public void clickGradeByStudent()throws Exception
	{
		String studentName = StudentData.strDTLastName+", "+StudentData.strDTFirstName;
		clickObject(InsGradingPage.gradeByStudent(driver,studentName), "Grade by Student");
		waiting(2);	
		System.out.println("Leaving clickGradeByStudent method----");
	}
	
	public void waitForScoreField(int waitTime)throws Exception
	{
		System.out.println("Entered waitForScoreField method----");
		waiting(10);	
		System.out.println("waiting for 10 sec over!!");
		switchiFrame();
		boolean status = waitTillElementDisplayed(InsGradingPage.score.get(0), "Instructor Score", waitTime);
		if(status) {
			System.out.println("Waited for score field and found");
		} else {
			System.out.println("Waited for score field but not found");
		}
	//	switchToDefaultPage();
	}
	
	public void enterScoreNCommentForStudent()throws Exception
	{
	//	switchiFrame();
		List<WebElement> oScore = InsGradingPage.score;
		for(int i = 0; i < oScore.size(); i++){
			String strScore = InsGradingData.strDTScore;
			waiting(2);
			waitTillElementEnabled(InsGradingPage.score.get(i), "score field", 5);
			clickObject(InsGradingPage.score.get(i), "score field");
		//	clickObjectUsingActionBuilder(InsGradingPage.score.get(i), "score field");
			waiting(2);
			clearNTypeValue(InsGradingPage.score.get(i), "Instructor score", strScore);
		//	typeValueUsingActionBuilder(InsGradingPage.score.get(i),strScore);
			waiting(2);
			InsGradingPage.score.get(i).sendKeys(Keys.TAB);
			String strComment = InsGradingData.strDTComment;
			waitTillElementEnabled(InsGradingPage.instructorComment.get(i), "Ins comments field", 5);
			clickObject(InsGradingPage.instructorComment.get(i), "Ins comments field");
		//	clickObjectUsingActionBuilder(InsGradingPage.instructorComment.get(i), "Ins comments field");
			waiting(2);
			clearNTypeValue(InsGradingPage.instructorComment.get(i), "Instructor comments", strComment);
		//	typeValueUsingActionBuilder(InsGradingPage.instructorComment.get(i),strComment);
			waiting(2);
			InsGradingPage.instructorComment.get(i).sendKeys(Keys.TAB);
			waiting(2);	
			checkObjectExists(InsGradingPage.gradeStatusInfo.get(i),"Graded Status");
			checkObjectExists(InsGradingPage.commentSavedInfo.get(i),"Graded Status");
		}
	//	switchToDefaultPage();
	}
	
	public void clickNextStudent()throws Exception
	{
		waiting(2);
	//	switchiFrame();
		waitTillElementEnabled(InsGradingPage.nextStudent, "Next Student", 10);
		waiting(2);
		clickObject(InsGradingPage.nextStudent, "Next Student");
		waiting(2);	
	//	switchToDefaultPage();
	}
	
	public void clickLastStudent()throws Exception
	{
	//	switchiFrame();
		if(waitTillElementEnabled(InsGradingPage.lastStudent, "End of students list", 5)) {
		//	clickObjectUsingActionBuilder(InsGradingPage.lastStudent, "End of students list");
			clickObject(InsGradingPage.lastStudent, "End of students list");
			waiting(2);	
			switchToDefaultPage();
		} else {
			waitTillElementEnabled(InsGradingPage.nextStudent, "Next Student", 5);
			waiting(2);
			clickObject(InsGradingPage.nextStudent, "Next Student");
			waiting(2);
			waitTillElementEnabled(InsGradingPage.lastStudent, "End of students list", 5);
			clickObjectUsingActionBuilder(InsGradingPage.lastStudent, "End of students list");
			waiting(2);	
			switchToDefaultPage();
		}
		
	}
	
	public void enterScoreNCommentForQuestions()throws Exception
	{		
	//	switchiFrame();
		String[] questions = InsGradingPage.totalQuestions.getText().trim().split(" ");
		int totalQuestions = Integer.parseInt(questions[3]);
		List<WebElement> oScore = InsGradingPage.score;
		List<WebElement> pageNumberNavElements = InsGradingPage.pageNumberNavElements;
		System.out.println("Inside enterScoreNCommentForQuestions() method");
		for(int i=1; i<=totalQuestions; i++){
			
			if(!(pageNumberNavElements.size() - 3 > 0)) {
				
				for(int j = 0; j <= (oScore.size()) - 1; j++){
					String strScore = InsGradingData.strDTScore;
					waiting(2);
					waitTillElementEnabled(InsGradingPage.score.get(j), "Score field", 5);
					clickObject(InsGradingPage.score.get(j), "Score field");
					waiting(2);
					InsGradingPage.score.get(j).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
					waiting(2);
					clearNTypeValue(InsGradingPage.score.get(j),"Instructor score", strScore);
					waiting(2);
					InsGradingPage.score.get(j).sendKeys(Keys.TAB);
					String strComment = InsGradingData.strDTComment;
					waitTillElementEnabled(InsGradingPage.instructorComment.get(j), "Ins comments field", 5);
					clickObject(InsGradingPage.instructorComment.get(j), "Ins comments field");
					waiting(2);
					clearNTypeValue(InsGradingPage.instructorComment.get(j),"Instructor comments", strComment);
					waiting(2);
					InsGradingPage.instructorComment.get(j).sendKeys(Keys.TAB);
					waiting(2);	
					checkObjectExists(InsGradingPage.gradeStatusInfo.get(j),"Graded Status");
					checkObjectExists(InsGradingPage.commentSavedInfo.get(j),"Graded Status");
				}
				
			} else {
				
				for(int j = 2; j < pageNumberNavElements.size() - 1; j++){
					String strScore = InsGradingData.strDTScore;
					for(int k = 0; k < InsGradingPage.score.size(); k++) {
						waitTillElementEnabled(InsGradingPage.score.get(k), "Score field", 5);
						clickObject(InsGradingPage.score.get(k), "Score field");
					//	clickObjectUsingActionBuilder(InsGradingPage.score.get(k), "Score field");
						waiting(2);
						typeValue(InsGradingPage.score.get(k), "Instructor score", strScore);
					//	typeValueUsingActionBuilder(InsGradingPage.score.get(k), strScore);
						waiting(2);
						String strComment = InsGradingData.strDTComment;
						waitTillElementEnabled(InsGradingPage.instructorComment.get(k), "Ins comments field", 5);
						clickObject(InsGradingPage.instructorComment.get(k), "Ins comments field");
					//	clickObjectUsingActionBuilder(InsGradingPage.instructorComment.get(k), "Ins comments field");
						waiting(2);
						typeValue(InsGradingPage.instructorComment.get(k), "Instructor comments", strComment);
					//	typeValueUsingActionBuilder(InsGradingPage.instructorComment.get(k), strComment);
						waiting(2);
						InsGradingPage.instructorComment.get(k).sendKeys(Keys.TAB);
						waiting(2);	
						checkObjectExists(InsGradingPage.gradeStatusInfo.get(k),"Graded Status");
						checkObjectExists(InsGradingPage.commentSavedInfo.get(k),"Graded Status");
					}
					
					waitTillElementEnabled(pageNumberNavElements.get(j), "Student Number: " + j + " for Question Number: " + i, 5);
					clickObjectUsingActionBuilder(pageNumberNavElements.get(j), "Student Number: " + j + " for Question Number: " + i);
				}
			}
			
			
			waitTillElementEnabled(InsGradingPage.nextQuestion, "Next Question", 10);
			waiting(2);
			clickObject(InsGradingPage.nextQuestion, "Next Question");
			waiting(2);	
		}
		waitTillElementEnabled(InsGradingPage.lastQuestion1, "Exit Grading", 10);
		waiting(3);
		clickObject(InsGradingPage.lastQuestion1, "Exit Grading");
		switchToDefaultPage();
	}
	
	public void clickLastQuestion()throws Exception
	{
		switchiFrame();
		clickObject(InsGradingPage.lastQuestion1, "End of questions");
		waiting(2);	
		switchToDefaultPage();
	}
	
	public void clickGoToSectionHome()throws Exception
	{
		waiting(2);
		clickObject(InsGradingPage.home, "Go to Section Home");
		waiting(2);	
	}
	
	public void clickGradeFileAssignment()throws Exception
	{
		clickObject(InsGradingPage.gradeFileAssignment, "Grade File Assignment");
		waiting(2);	
	}
	
	public void waitForStudentResultSubmited(int waitTime)throws Exception
	{
		waitTillElementDisplayed(InsGradingPage.studentResultSubmited, "Student Result Submited", waitTime);
		waiting(2);	
	}
	
	public void clickStudentResultSubmited()throws Exception
	{
		clickObject(InsGradingPage.studentResultSubmited, "Student Result Submited");
		waiting(2);	
	}
	
	public void enterScore()throws Exception
	{
		String strScore = InsGradingData.strDTScore;
		clearNTypeValue(InsGradingPage.fileAttachScore, "Student Result Submited",strScore);
		waiting(2);	
	}
	
	public void enterComment()throws Exception
	{
		clickObject(InsGradingPage.fileAttachAddComment, "File Attach Add Comment");
		waiting(2);
		String strScore = InsGradingData.strDTComment;
		clearNTypeValue(InsGradingPage.fileAttachComment, "File Attach Add Comment",strScore);
		waiting(2);	
		clickObject(InsGradingPage.fileAttachSaveComment, "File Attach Save Comment");
		waiting(2);
	}
	
	public void clickSubmitFileAssignmentScore()throws Exception
	{
		clickObject(InsGradingPage.fileAttachSubmitScore, "Submit score");
		waiting(2);	
	}
	
	public void clickReturnToSectionHome()throws Exception
	{
		clickObject(InsGradingPage.returnToSectionHome, "Return To Section Home");
		waiting(2);	
	}
	
	public void clickMessages()throws Exception
	{
		waitTillElementEnabled(InsGradingPage.messages, "messages", 6);
		clickObject(InsGradingPage.messages, "messages");
		waiting(2);	
	}
	
	public void clickStudentInquiry()throws Exception
	{
		clickObject(InsGradingPage.studentInquiry, "Student Inquiry");
		waiting(2);	
	}
	
	public void waitForBackToSectionHome(int waitTime)throws Exception
	{
		waitTillElementDisplayed(InsGradingPage.backToSectionHome, "Back to Section Home", waitTime);
		waiting(2);	
	}
	
	public void clickReply(int replyStudent)throws Exception
	{
		clickObject(InsGradingPage.reply.get(replyStudent-1), "Reply");
		waiting(2);	
	}
	
	public void enterResponse(int responseNumber)throws Exception
	{
		String strResponse = InsGradingData.strDTAskInstructorResponse;
		typeValue(InsGradingPage.answerStudentQuestion, "Response",strResponse+" "+responseNumber);
		waiting(2);	
	}
	
	public void selectResponseType(String responseType)throws Exception
	{
		selectValueByTextFromList(InsGradingPage.responseType, "responseType",responseType);
		waiting(2);	
	}
	
	public void clickSendResponse()throws Exception
	{
		clickObject(InsGradingPage.sendMessage, "Reply");
		waiting(2);	
	}
	
	public void clickBackToSectionHome()throws Exception
	{
		clickObject(InsGradingPage.backToSectionHome, "Back to Section Home");
		waiting(2);	
	}
	
	public void clickMessageHistoryTab()throws Exception
	{
		waiting(2);
		clickObject(InsGradingPage.messageHistoryTab, "Message History Tab ");
		waiting(2);	
	}
	
	public void selectSortType()throws Exception
	{
		selectValueByTextFromList(InsGradingPage.sortMessages, "responseType","most recent");
		waiting(3);	
		selectValueByTextFromList(InsGradingPage.sortMessages, "responseType","A - Z");
		waiting(3);
	}
	
	public void clickAssignmentOptions()throws Exception
	{
		clickObject(InsGradingPage.assignmentOptions, "Assignment Options ");
		waiting(1);	
	}
	
	public void clickManageDates()throws Exception
	{
		try {
			clickObjectUsingJSExecutor(InsGradingPage.manageDates, "Manage Dates ");
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void clickEditDueDate()throws Exception
	{
		try {
			clickObjectUsingJSExecutor(InsGradingPage.editDueDate, "Edit Due Date ");
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void typeDueDate()throws Exception
	{
		clickObject(InsGradingPage.adjustDueDate, "Manage Dates ");
		waiting(1);	
		Date dt = new Date();	
		String strEndDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
		clearNTypeValue(InsGradingPage.adjustDueDate, "Assignment end date", strEndDate);	
	}
	
	public void typeDueHourMinute()throws Exception
	{
		clickObject(InsGradingPage.adjustDueHourMin, "Manage Dates ");
		waiting(1);	
		/*
		Date dt = new Date();
		Calendar cl = Calendar.getInstance(); */
	//	Calendar cl = new GregorianCalendar();
	//	cl.setTimeZone(TimeZone.getTimeZone("America/New_York"));
	//    cl.setTime(new Date()); 
	    //****for converting system IST date to EST****sayan
	//    cl.add(Calendar.HOUR, -9);	
	//    cl.add(Calendar.MINUTE, -29);	
	//    cl.add(Calendar.MINUTE, 1);
	    //*****sayan
	/*    SimpleDateFormat df = new SimpleDateFormat("hh:mma");
	    System.out.println("***************" + cl.getTime().toString() + "***************");
	    String strAssignmentEndTime = df.format(cl.getTime()).toLowerCase();	*/
		String strAssignmentEndTime = getEDTTimeStamp("America/New_York", "hh:mma", 1);
		System.out.println("++++++++++" + strAssignmentEndTime + "++++++++++++");
	    InsGradingPage.adjustDueHourMin.sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));
	    waiting(2);
	    clearNTypeValue(InsGradingPage.adjustDueHourMin, "Assignment end time using Gregorian Calendar", strAssignmentEndTime);
	    waiting(2);
	    System.out.println("After updating due-date from manage dates: new date is: " + getAttributeFromElement(InsGradingPage.adjustDueHourMin, "Updated due-date", "value"));
	}
	
	/*
	 * This method is returning the current time with added minute(s) in the specified timezone
	 */
	public String getEDTTimeStamp(String timeZoneStr, String formatStr, int addMinute) throws Exception {
		
		long timeInMilliSeconds = Calendar.getInstance().getTimeInMillis();
		Date date = new Date(timeInMilliSeconds + (addMinute * 60 * 1000)); // Adding 1 minute of time to current time
		DateFormat timeFormat = new SimpleDateFormat(formatStr);
	    timeFormat.setTimeZone(TimeZone.getTimeZone(timeZoneStr));
	    
	    String estTime = timeFormat.format(date);
	//    date = new SimpleDateFormat(formatStr, Locale.ENGLISH).parse(estTime);

	 //   return timeFormat.format(date);
	    return estTime;
	}
	
	public void clickDateSubmit()throws Exception
	{
		clickObject(InsGradingPage.dateSubmit, "Edit Due Date ");
		waiting(1);	
	}
	
	public void waitForPastDue()throws Exception
	{		
		String assignmentsToGrade = "//span[contains(@class,'caret-right')]/span[text()='Assignments to grade']";
		try
		{
			boolean assignmentsToGradeEnabled = checkObjectExistsWOError(assignmentsToGrade,"assignmentsToGrade");
			for(int i=1; i<=10; i++)	{
				waiting(60);
				clickObject(InsGradingPage.sectionHome, "Refresh Section Home ");
				System.out.println("Waiting for past-due assignment and refreshed after " + i + " minute(s)");
				waiting(1);	
				assignmentsToGradeEnabled = checkObjectExistsWOError(assignmentsToGrade,"assignmentsToGrade");	
				if(assignmentsToGradeEnabled == true)
					break;
			}
			//TODO change assignmentsToGrade to WebElement
		}	
		catch(Exception objException)
			{
				ATUReports.add("Failed in executing dismiss waitForPastDue method in InstructorGradingController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Failed in executing waitForPastDue in InstructorGradingController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
			}
	}
	

	
	public void clickStudent() throws Exception
	{
		waitTillElementDisplayed(InsGradingPage.selectStudent, "Select Student", 20);
		clickObjectUsingJSExecutor(InsGradingPage.selectStudent, "Select Student");
	}
	
	public void clickAssignmentAndCheckResults(int assignmentNumber) throws Exception
	{
		
	//	waitTillElementDisplayed(InsGradingPage.selectAssignmentToViewResults(driver), "Select Assignment",10);
		waiting(3);
		List<WebElement>[] bothAssignmentAndAttemptList = InsGradingPage.selectAssignmentToViewResults(this.driver);
		System.out.println("bothAssignmentAndAttemptList size: " + bothAssignmentAndAttemptList[0].size() + "++++++++++++++++++++++++");
		System.out.println("bothAssignmentAndAttemptList size: " + bothAssignmentAndAttemptList[1].size() + "++++++++++++++++++++++++");
		
		List<WebElement> assignmentList = InsGradingPage.getAssignmentListFromInsReports(bothAssignmentAndAttemptList);
		System.out.println("assignmentList size: " + assignmentList.size() + "++++++++++++++++++++++++");
		
		for(WebElement element: assignmentList) {
			System.out.println(element.getAttribute("class") + "******************");
		}
		waitTillElementDisplayed(assignmentList.get(assignmentNumber - 1), "Assignment No: " + assignmentNumber, 5);
		clickObject(assignmentList.get(assignmentNumber - 1), "Assignment No: " + assignmentNumber);
		waiting(2);
		switchingWindows();
		
		waitTillElementDisplayed(InsGradingPage.policySummaryReportsPage,"Policy Summary",10);
		clickObject(InsGradingPage.policySummaryReportsPage,"Policy Summary");		
		
		
		
	}
	
	public void switchingWindows()
	{
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
	}
	

	
	public void checkPolicyInReportsPage(String AssignmentType) throws Exception
	{
		//clickObjectUsingJSExecutor(InsGradingPage.reportsPolicySummary, "reports Policy Summary");
		waiting(2);
		
		if( AssignmentType.equalsIgnoreCase("HomeWork") || AssignmentType.equalsIgnoreCase("Practice") )
		{
			waitTillElementEnabled(InsGradingPage.reportsTimeLimit, "No time limit", 6);
			verifyTextEquals(InsGradingPage.reportsTimeLimit.getText(),"No time limit","Basic Policy Printing");
			String print = InsGradingPage.reportsPrinting.getText();
			System.out.println(print);
		
		//	verifyTextEquals(print, "Printing is allowed", "Basic Policy Printing");
			verifyTextEquals(print, "Printing is not allowed", "Basic Policy Printing");
			verifyTextEquals(InsGradingPage.reportsQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
			
		//	verifyTextEquals(InsGradingPage.reportsPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
			verifyTextEquals(InsGradingPage.reportsPasswordProtect.getText(),"password protected: <123456>","Basic Policy Password protect");
			
			verifyTextEquals(InsGradingPage.reportsCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
			
			verifyTextEquals(InsGradingPage.reportsBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
			verifyTextEquals(InsGradingPage.reportsStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
		
		//	verifyTextEquals(InsGradingPage.reportsAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
		//	verifyTextEquals(InsGradingPage.reportspunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
		//	verifyTextEquals(InsGradingPage.reportsCase.getText(),"Correct letter case is required","Tolerance Policy Case");
			
			verifyTextEquals(InsGradingPage.reportsQuestionPointValue.getText(),"Question point values are shown","Resource Policy Question Point Value");
			
		//	verifyTextEquals(InsGradingPage.reportsQuestionTitle.getText(),"Question titles are not shown","Resource Policy Question Title");
			verifyTextEquals(InsGradingPage.reportsQuestionTitle.getText(),"Question titles are shown","Resource Policy Question Title");
			
			verifyTextEquals(InsGradingPage.reportsReference.getText(),"References are shown","Resource Policy References");
		//	verifyTextEquals(InsGradingPage.reportsExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
		//	verifyTextEquals(InsGradingPage.reportsFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
			
		//	verifyTextEquals(InsGradingPage.reportseBookAssitantDeductions.getText(),"0%","Resource Policy EBook Deductions");
			verifyTextEquals(InsGradingPage.reportseBookAssitantDeductions.getText(),"10%","Resource Policy EBook Deductions");
			
		//	verifyTextEquals(InsGradingPage.reportsHintsDeductions.getText(),"0%","Resource Policy Hints Deductions");
			verifyTextEquals(InsGradingPage.reportsHintsDeductions.getText(),"10%","Resource Policy Hints Deductions");
			
		//	verifyTextEquals(InsGradingPage.reportsUsesofCheckMyWork.getText(),"0","Resource Policy CheckMyWork Uses per Question");
			verifyTextEquals(InsGradingPage.reportsUsesofCheckMyWork.getText(),"2","Resource Policy CheckMyWork Uses per Question");
			
		//	verifyTextEquals(InsGradingPage.reportseCheckMyWorkDeductions.getText(),"0%","Resource Policy CheckMyWork Uses Deduction");
			verifyTextEquals(InsGradingPage.reportseCheckMyWorkDeductions.getText(),"10%","Resource Policy CheckMyWork Uses Deduction");
			
		//	verifyTextEquals(InsGradingPage.reportsSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
		//	verifyTextEquals(InsGradingPage.reportsGuidedSolutions.getText(),"Guided solutions are allowed","Resource Policy Guided solutions");
		
		//	verifyTextEquals(InsGradingPage.reportsAskToInstructor.getText(),"Access to \"ask the instructor\" is not allowed","Resource Policy ask Instructor");
			verifyTextEquals(InsGradingPage.reportsAskToInstructor.getText(),"Access to \"ask the instructor\" is allowed","Resource Policy ask Instructor");
			
		//	verifyTextEquals(InsGradingPage.reportsPracticeQuestions.getText(),"Practice questions are allowed","Resource Policy Practice Questions");
			if(AssignmentType.equalsIgnoreCase("HomeWork"))
			{
			verifyTextEquals(InsGradingPage.reportsFeedbackafterFirstAttempt.getText(),"Detailed feedback","Feedback Policy After First Attempt");
			verifyTextEquals(InsGradingPage.reportsFeedbackafterAdditionalAttempt.getText(),"Detailed feedback","Feedback Policy After Additional Attempts");
			verifyTextEquals(InsGradingPage.reportsFeedbackafterFullScore.getText(),"Detailed feedback","Feedback Policy After Full Score");
		//	verifyTextEquals(InsGradingPage.reportsFeedbackDueDate.getText(),"Feedback shown on due date","Feedback Policy Due Date");
			}else
			{
				//verifyTextEquals(InsGradingPage.reportsPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				verifyTextEquals(InsGradingPage.reportsFeedbackafterQuestions1.getText(),"- question score","FeddBack Policy After each Question");
				verifyTextEquals(InsGradingPage.reportsFeedbackafterQuestion2.getText(),"- solution","FeddBack Policy After each Question");
				verifyTextEquals(InsGradingPage.reportsFeedbackafterQuestions3.getText(),"- correct answer","FeddBack Policy After each Question");
				verifyTextEquals(InsGradingPage.reportsFeedbackafterQuestions4.getText(),"- explanation (when available)","FeddBack Policy After each Question");
			}
			
			if(AssignmentType.equalsIgnoreCase("Quiz") || AssignmentType.equals("Exam"))
			{
				verifyTextEquals(InsGradingPage.reportsTimeLimit.getText(),"No time Limit","Basic Policy Printing");
				verifyTextEquals(print, "Printing is not allowed", "Basic Policy Printing");
				verifyTextEquals(InsGradingPage.reportsQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
				verifyTextEquals(InsGradingPage.reportsPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
				verifyTextEquals(InsGradingPage.reportsCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
				
				verifyTextEquals(InsGradingPage.reportsBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
				verifyTextEquals(InsGradingPage.reportsStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
			
		//		verifyTextEquals(InsGradingPage.reportsAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
		//		verifyTextEquals(InsGradingPage.reportspunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
		//		verifyTextEquals(InsGradingPage.reportsCase.getText(),"Correct letter case is required","Tolerance Policy Case");
				
				verifyTextEquals(InsGradingPage.reportsQuestionPointValue.getText(),"Question titles are not shown","Resource Policy Question Point Value");
				verifyTextEquals(InsGradingPage.reportsQuestionTitle.getText(),"Question point values are not shown","Resource Policy Question Title");
				verifyTextEquals(InsGradingPage.reportsReference.getText(),"References are not shown","Resource Policy References");
		//		verifyTextEquals(InsGradingPage.reportsExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
		//		verifyTextEquals(InsGradingPage.reportsFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
		//		
				verifyTextEquals(InsGradingPage.reportsEbookQuiz.getText(),"Access to the eBook and resources is not allowed","Resource Policy Ebook");
				verifyTextEquals(InsGradingPage.reportsHintsQuiz.getText(),"Access to hints is not allowed","Resource Policy Hints");
				verifyTextEquals(InsGradingPage.reportscheckWorkQuiz.getText(),"Access to check my work is not allowed","Resource Policy CheckMyWork");
				
		//		verifyTextEquals(InsGradingPage.reportsSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
		//		verifyTextEquals(InsGradingPage.reportsGuidedSolutions.getText(),"Guided solutions are not allowed","Resource Policy Guided solutions");
				verifyTextEquals(InsGradingPage.reportsAskToInstructor.getText(),"Access to '\"ask the instructor'\" is not allowed","Resource Policy ask Instructor");
		//		verifyTextEquals(InsGradingPage.reportsPracticeQuestions.getText(),"Practice questions are not allowed","Resource Policy Practice Questions");
				verifyTextEquals(InsGradingPage.reportsPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				
				if(AssignmentType.equalsIgnoreCase("Quiz"))
				{
					verifyTextEquals(InsGradingPage.reportsFeedbackafterFirstAttempt.getText(),"Total scores only", "Feedback Policy After submitting attempt");
					
				}else if(AssignmentType.equalsIgnoreCase("Exam"))
				{
					verifyTextEquals(InsGradingPage.reportsFeedbackafterFirstAttempt.getText(),"No feedback", "Feedback Policy After submitting attempt");
				}
			}
		
		}
	}
	public void adjustCreditingInReports() throws Exception
	{
		switchToFrame(InsGradingPage.iframe, "Iframe");
		List<WebElement> questionInReports=InsGradingPage.questionList;
		
		for(int i=0;i<=(questionInReports.size())-1;i++)
		{		
			if(i==0)
			{
				waitTillElementDisplayed(InsGradingPage.adjustCreditInReports, "Adjust Credit",10);
				clickObjectUsingJSExecutor(InsGradingPage.adjustCreditInReports, "Adjust Credit");
				waiting(2);
				clickObjectUsingJSExecutor(InsGradingPage.awardFullCredit, "Award Full Credit");
				waiting(1);
				clickObjectUsingJSExecutor(InsGradingPage.awardFullCreditForThisAssignment, "Award Full Credit For This Assignment");
				waiting(1);
				clickObjectUsingJSExecutor(InsGradingPage.adjust, "Adjust");
				waiting(1);
				clickObjectUsingJSExecutor(InsGradingPage.confirmAdjust, "Confirm Adjust");	
			}
		}
		switchToParentFrame();
		switchToParentWindow();
		waiting(2);
	}
}