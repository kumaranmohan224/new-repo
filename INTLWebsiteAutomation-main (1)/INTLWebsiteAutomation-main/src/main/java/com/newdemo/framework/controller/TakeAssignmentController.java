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


public class TakeAssignmentController extends ComponentFunctions {

	TakeAssignmentPage TakeAssignmentPage = null;
	CreateAssignmentPage AssignmentPage = null;
	InstructorAreaPage InsAreaPage = null;
	InstructorAreaData InsAreaData = null;
	CreateAssignmentData CreateAssignData = null;
	StudentAssignmentData stdAssignmentData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	GlobalPaths Global = null;
	StudentReportsPage stdReportsPage = null;

	public TakeAssignmentController(WebDriver driver, String strParametersNValues) throws Exception {
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		TakeAssignmentPage = PageFactory.initElements(driver, TakeAssignmentPage.class);
		InsAreaPage = PageFactory.initElements(driver, InstructorAreaPage.class);
		AssignmentPage = PageFactory.initElements(driver, CreateAssignmentPage.class);
		Global = new GlobalPaths();
		stdReportsPage = PageFactory.initElements(driver, StudentReportsPage.class);
	}

	public void verifyInstructorEmail() throws Exception {
		String strInsEmail = InsAreaData.strDTInstructorEmail;
		checkObjectExists(TakeAssignmentPage.instructorEmail(driver, strInsEmail), "Instructor Email");
		waiting(2);
	}

	public void verifyInstructorInfo() throws Exception {
		String strInsInfo = InsAreaData.strDTInstructorInformation;
		checkObjectExists(TakeAssignmentPage.instructorInfo(driver, strInsInfo), "Instructor Information");
	}

	public void clickSectionNotifications() throws Exception {
		clickObject(TakeAssignmentPage.sectionNotifications, "Section Notifications");
		waiting(2);
	}

	public void verifyInstructorMessage(int msgNumber) throws Exception {
		String strMessage = retrieveRuntimeGlobalVariable("Message" + msgNumber);
		checkObjectExists(TakeAssignmentPage.instructorMessage(driver, strMessage), "Instructor Email");
	}

	public void clickViewBookmarks() throws Exception {
		clickObject(TakeAssignmentPage.viewBookmarks, "View Bookmarks");
		waiting(2);
	}

	public void verifyBookmark() throws Exception {
		String strBookmark = InsAreaData.strDTBookmarkName;
		checkObjectExists(TakeAssignmentPage.bookmark(driver, strBookmark), "Bookmark");
		clickObject(TakeAssignmentPage.bookmark(driver, strBookmark), "Bookmark");
		switchToNewWindow();
		closeApplication();
		switchToParentWindow();
	}

	public void clickDownloadSyllabus() throws Exception {
		clickObject(TakeAssignmentPage.downloadSyllabus, "Download Syllabus");
		waiting(2);
	}

	public void verifySyllabus() throws Exception {
		try {
			String username = System.getProperty("user.name");
			String strDownloadFilePath = "C:/Users/" + username + "/Downloads/";
			String syllabusDownloadPath = strDownloadFilePath + "Syllabus.txt";
			File oFile = new File(syllabusDownloadPath);
			boolean fileDowloaded = false;
			int count = 0;
			while (fileDowloaded == false) {
				waiting(3);
				if (oFile.exists()) {
					fileDowloaded = true;
				}
				if (count == 100) {
					break;
				}
				count = count + 1;
			}
			if (fileDowloaded == false) {
				ATUReports.add("Verification of the Syllabus Download", "Syllabus must be downloaded",
						"Syllabus not downloaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Verification of the Syllabus Download", "Syllabus must be downloaded",
						"Syllabus not downloaded");
			} else {
				ATUReports.add("Verification of the Syllabus Download", "Syllabus must be downloaded",
						"Syllabus downloaded successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Verification of the Syllabus Download",
						"Syllabus downloaded successfully", "Syllabus downloaded successfully");
				oFile.delete();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void selectAssignmentFromList() throws Exception {
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		waiting(2.5);
		waitTillElementEnabled(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName, 5);
		clickObject(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName);
		waiting(2);
	}
	
	public void completeRegistration() throws Exception
	{
		try
		{
			
			if(waitTillElementEnabled(TakeAssignmentPage.completeRegistration, "Complete Registration", 3)){
				clickObjectUsingJSExecutor(TakeAssignmentPage.completeRegistration, "Complete Registration");				
			}
			else{
				objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
			}
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed in Complete Registration" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}


	public void selectAssignmenToTake(int index) throws Exception {
		waiting(5);
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		validateAssignmentName(assignmentName, TakeAssignmentPage.selectAssignmentToTake(driver, index)); //verifying special character assignment name
		waiting(5);
		clickObject(TakeAssignmentPage.selectAssignmentToTake(driver, index), "Assignment " + assignmentName);
		waiting(2);
	}
	
	//********added by Sayan*************// start
	
	public String verifyCompoundDeductionMsgOnStart(int i) throws Exception {
		int deductionForAttempt = Integer.parseInt(stdAssignmentData.strDTDeductionForAttempt);
		int prevAttemptNumber = Integer.parseInt(getTextFromElement(TakeAssignmentPage.prevAttemptNumber, "Previous Attempt Number").replaceAll("[^\\d]", ""));
		int deduction = deductionForAttempt * prevAttemptNumber;
	//	storeRuntimeGlobalVariable("deductionPercent" + i, String.valueOf(deduction));
		String expectedAttemptDeductionMsg = "-" + deduction + "% for this attempt";
		String actualAttemptDeductionMsg = getTextFromElement(TakeAssignmentPage.attemptDeductionMsg, "Attempt Score Deduction Message");
		verifyTextEquals(actualAttemptDeductionMsg, expectedAttemptDeductionMsg, "Score Compound Deduction Message On Multiple Attempt");
		return String.valueOf(deduction);
	}
	
	public void verifyBOPAMessageOnStart() throws Exception {
		String expectedMsg = stdAssignmentData.strDTBOPAMsgOnStart;
	//	System.out.println("Expected BOPA message on start: " + expectedMsg + "+");
		String actualMsg = getTextFromElement(TakeAssignmentPage.bopaMsgOnStart, "BOPA message on assignment start");
		verifyTextEquals(actualMsg, expectedMsg, "BOPA message on start");
	//	verifyTextEquals(actualMsg, "If you take this assignment more than once, your previous answers will be displayed.", "BOPA message on start");
	}
	
	public void verifyAssignmentAttemptNumber(int launchNum) throws Exception {
		try {
		//	int maxAttemptsFromXL = Integer.parseInt(stdAssignmentData.strDTCurrentAssignMaxAttempts);
			String attemptsText = getTextFromElement(TakeAssignmentPage.assignmentAttempt, "Assignment attempts remaining");
		//	System.out.println(attemptsText + "+");
			String str[] = attemptsText.replaceAll("[^\\d]", " ").replaceAll("( +)"," ").trim().split(" ");
		//	System.out.println(str[0] + "+");
		//	System.out.println(str[1] + "+");
			int remainingAttempt = Integer.parseInt(str[0]);
		//	System.out.println(remainingAttempt + "+");
			int maxAttempt = Integer.parseInt(str[1]);
		//	System.out.println(maxAttempt + "+");
			
			if(launchNum == 1) {
				if(remainingAttempt == maxAttempt) {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "true");
				} else {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "false");
				}
			} else if(launchNum == 2) {
				if(remainingAttempt == maxAttempt - 1) {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "true");
				} else {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "false");
				}
			} else if(launchNum == 3) {
				if(remainingAttempt == maxAttempt - 2) {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "true");
				} else {
					this.objHTMLFunctions.reportPassFailToATU(attemptsText, "true", "false");
				}
			}
			
		} catch(Exception e) {
			System.out.println("Something went wrong while validating attempt deduction =>" + stdAssignmentData.strDTCurrentAssignMaxAttempts);
		}
		
	}
	
	public void validateAssignmentName(String expectedAssignmentName, WebElement element) throws Exception {
		String actualAssignmentName = getTextFromElement(element, "Real Assignment Name").trim();
		verifyTextEquals(actualAssignmentName, expectedAssignmentName, "Special character assignment name");
		
	}
	
	public void selectAssignmenToTakeByTitle() throws Exception {
		waiting(8);
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		waitTillElementDisplayed(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName, 5);
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName);
		waiting(2);
	}
	
	public void verifyTimedAssignmentMessage() throws Exception {
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		String expectedTimedMsg = "\"" + assignmentName + "\"" + " " +  stdAssignmentData.strDTTimedAssignmentMsg;
		String actualTimedMsg = getTextFromElement(TakeAssignmentPage.timedMsg, "Timed Message Element");
		verifyTextEquals(actualTimedMsg, expectedTimedMsg, "Timed Assignment Message");
	}
	
	public void verifyTimedAutoSubmitText() throws Exception {
		String expectedTexts[] = stdAssignmentData.strDTTimedAutoSubmitText.split("=>");
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		String expectedAutoSubmitText = expectedTexts[0] + "\"" + assignmentName + "\"" + expectedTexts[1];
		String actualAutoSubmitText = getTextFromElement(TakeAssignmentPage.timedMsg, "Timed Message Element");
		verifyTextEquals(actualAutoSubmitText, expectedAutoSubmitText, "Timed Assignment Auto-submit Text");
	}
	
	public void verifyPasswordMessage() throws Exception {
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		String expectedPasswordMsg = stdAssignmentData.strDTPasswordMsg + " " + "\"" + assignmentName + "\"";
		String actualPasswordMsg = getTextFromElement(TakeAssignmentPage.passwordMsg, "Password Message Element");
		verifyTextEquals(actualPasswordMsg, expectedPasswordMsg, "Assignment Password Message");
	}
	
	public void enterAssignmentPassword() throws Exception {
		String assignmentPwd = stdAssignmentData.strDTAssignmentPwd;
		clearNTypeValue(TakeAssignmentPage.enterPassword, "Enter Assignment Password", assignmentPwd);
	}
	
	public void clickStartAssignmentClassicStd() throws Exception {
		clickObject(TakeAssignmentPage.startAssignmentBtn, "Start Assignment Button Classic Student");
	}
	
	//********added by Sayan*************// end
	
	public void selectWebActivityAssignmentFromList() throws Exception {
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		clickObject(TakeAssignmentPage.assignmentWebActivity(driver, assignmentName), "Assignment " + assignmentName);
		waiting(2);
	}
	public void clickGoButton() throws Exception {
		try {
		//	waiting(5);
			waitTillElementEnabled(TakeAssignmentPage.takeAssignmentStdPreview, "Question", 10);
			String strInstruction = CreateAssignData.strDTInstructions;
		//	checkObjectExists(TakeAssignmentPage.assignmentInstructions(driver, strInstruction),
			//		"Assignment Instructions");
		} catch (Exception e) {
			e.printStackTrace();
		}
		clickObject(TakeAssignmentPage.takeAssignment, "Go Button");
	}
	
	public void verifyEbook_CMW_Hints_Msg() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.takeAssignmentStdPreview, "Question", 10);
		String actualHintMsg = getTextFromElement(TakeAssignmentPage.hintMsgAtAssignStart, "Hint Deduction Message at assignment start");
		String actualEbookMsg = getTextFromElement(TakeAssignmentPage.ebookMsgAtAssignStart, "Hint Deduction Message at assignment start");
		String actualCMWMsg = getTextFromElement(TakeAssignmentPage.cmwMsgAtAssignStart, "Hint Deduction Message at assignment start");
	/*	System.out.println(actualHintMsg + "+");
		System.out.println(actualEbookMsg + "+");
		System.out.println(actualCMWMsg + "+"); */
		String expectedHintMsg = stdAssignmentData.strDTHintMsgAtAssignStart;
		String expectedtEbookMsg = stdAssignmentData.strDTEbookMsgAtAssignStart;
		String expectedCMWMsg = stdAssignmentData.strDTCMWMsgAtAssignStart;
		verifyTextEquals(actualHintMsg, expectedHintMsg, "Hint deduction message at assignment start");
		verifyTextEquals(actualEbookMsg, expectedtEbookMsg, "Ebook deduction message at assignment start");
		verifyTextEquals(actualCMWMsg, expectedCMWMsg, "Check my work deduction message at assignment start");
	}

	public void clickAndGo() throws Exception {
		waiting(2);
		clickObject(TakeAssignmentPage.takeAssignment, "Go Button");
	}

	public void waitForQuestionNavigator(int waitTime) throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.questionNavigator, "Question Navigator", waitTime);
	}

	public void verifyEBook() throws Exception {
		clickObject(TakeAssignmentPage.eBook, "EBook");
		switchToNewWindow();
		closeApplication();
		switchToParentWindow();
	}

	public void verifyPrint() throws Exception {
		clickObject(TakeAssignmentPage.print, "Print");
		waiting(2);
		switchToNewWindow();
		clickObject(TakeAssignmentPage.newWindowPrint, "Print Question");
		waiting(2);
		/*
		 * checkObjectExists(TakeAssignmentPage.printDialogPrint,
		 * "Print Dialog"); clickObject(TakeAssignmentPage.printDialogCancel,
		 * "Close Print Dialog");
		 */
		/* Robot is not supported in headless environment so using actions class to perform key press actions for jenkins
		 * Robot r = new Robot(); r.keyPress(KeyEvent.VK_ESCAPE);
		 * r.keyRelease(KeyEvent.VK_ESCAPE);
		 */
		escapeKeyUsingActionBuilder(1);
		waiting(2);
		closeApplication();
		waiting(2);
		switchToParentWindow();
	}
	
	public boolean escapeKeyUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ESCAPE);
				Thread.sleep(100L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("ESCAPE key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press ESCAPE key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean tabKeyUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.TAB);
				Thread.sleep(100L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("TAB key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press TAB key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}

	public void answerQuestion(String answeringType) throws Exception {
		try {
			waitTillElementDisplayed(TakeAssignmentPage.questionTitle, "Question Title", 6);
			waiting(2);
			String strQuestionTitle = TakeAssignmentPage.questionTitle.getText();
			String[] arrAnswernType = getAnswerForQuestion(strQuestionTitle).split(";");
			String strAnswer = arrAnswernType[0];
			if (answeringType.equalsIgnoreCase("tolerance")) {
				strAnswer = strAnswer.toLowerCase().replace(" ", "").replace(";", "n");
			}
			String strQuestionType = arrAnswernType[1];

			switch (strQuestionType) {
			case "Worksheet":
				List<WebElement> questionsList = TakeAssignmentPage.worksheetAnswer;
				for (int i = 0; i <= (questionsList.size()) - 1; i++) {
					typeValue(TakeAssignmentPage.worksheetAnswer.get(i), "", strAnswer);
				}
				waiting(2);
				break;
			case "Fill in the Blank":
				typeValue(TakeAssignmentPage.fillInTheBlankAnswer, "", strAnswer);
				waiting(2);
				break;
			case "Essay":
			/*	switchiFrame();
				clickObject(TakeAssignmentPage.essayAnswer, "Enter essay answer");
				typeValueUsingActionBuilder(TakeAssignmentPage.essayAnswer, "Instructor has to manually grade");
				switchToDefaultPage();	*/
				essay();
			//	waiting(2);
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//***************************sayan start***************************************
	
	public void takeFullCreditNativeAssignment() throws Exception {
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		// select 1st question
		selectQuestionNumber(questionNavList, 1); //select the question number for answering
		waitForQuestionTitle();
		//1. answer matching question
	    verifyPointValueResource();
		answerMatchingQuestionNative();
		waiting(3);
	//	verifyEBookDeduction();	//verify Ebook deduction
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle(); 
		//2. answer ranking question
		verifyPointValueResource();
		answerRankingQuestionNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//3. answer fill in the blank question
		verifyPointValueResource();
		answerFillInTheBlankQuestionNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//4. answer essay or short answer question
		verifyPointValueResource();
		essay();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//5. true/false question answer
		verifyPointValueResource();
		TrueOrFalse();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//6. answer essay or short answer question
		verifyPointValueResource();
		essay();
		waiting(3);
		clickNextQuestion();	
		waitForQuestionTitle();	
		//7. Numeric Response question answer
		verifyPointValueResource();
		verifyNAnswerNumericResponse();	//verifying numeric tolerance at 100% tolerance
		answerNumericResponse();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//8. MCQ question answer
		verifyPointValueResource();
		answerMCQNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle(); 
		//9. Worksheet question answer
		verifyPointValueResource();
		answerWorksheetQuestion();
		waiting(3);  
	}
	
	public void verifyPointValueResource() throws Exception {
		String pointVal = getTextFromElement(TakeAssignmentPage.pointValue, "EZT resource point value");
		checkObjectExists(TakeAssignmentPage.pointValue, "EZT resource point value : " + pointVal);
	}
	
	public void verifyBOPAAssignment() throws Exception {
		String expectedBOPAQsHeaderInfoCorrect = stdAssignmentData.strDTBOPAQsHeaderInfo1;
		String expectedBOPAQsHeaderInfoIncorrect = stdAssignmentData.strDTBOPAQsHeaderInfo2;
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		selectQuestionNumber(questionNavList, 1);
		String actualBOPAQsHeaderInfo = "";
		
		for(int i = 1; i <= questionNavList.size(); i++) {
			waiting(2);
			if(i == 4 || i == 6 || i == 9) {
				actualBOPAQsHeaderInfo = getTextFromElement(TakeAssignmentPage.bopaQsHeaderInfo, "BOPA question " + i + " header info");
				verifyTextEquals(actualBOPAQsHeaderInfo, expectedBOPAQsHeaderInfoIncorrect, "BOPA question " + i + " header info status");
			} else {
				actualBOPAQsHeaderInfo = getTextFromElement(TakeAssignmentPage.bopaQsHeaderInfo, "BOPA question " + i + " header info");
				verifyTextEquals(actualBOPAQsHeaderInfo, expectedBOPAQsHeaderInfoCorrect, "BOPA question " + i + " header info status");
			}
			
			if(i < questionNavList.size()) {
				clickNextQuestion();
				waitForQuestionTitle();
			} else {
				break;
			}
		}
	}
	
	public void takeBOPANativeAssignment() throws Exception {
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		// select 1st question
		selectQuestionNumber(questionNavList, 1); //select the question number for answering
		waitForQuestionTitle();
		//1. answer matching question
		answerMatchingQuestionNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle(); 
		//2. answer ranking question
		answerRankingQuestionNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//3. answer fill in the blank question
		answerFillInTheBlankQuestionNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//4. answer essay or short answer question
		essay();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//5. true/false question answer
		TrueOrFalse();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//6. answer essay or short answer question
		essay();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();	
		//7. Numeric Response question answer
	//	verifyNAnswerNumericResponse();	//verifying numeric tolerance at 100%
		answerNumericResponse();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle();
		//8. MCQ question answer
		answerMCQNative();
		waiting(3);
		clickNextQuestion();
		waitForQuestionTitle(); 
		//9. Worksheet question answer
		answerWorksheetQuestion();
		waiting(3);  
	}
	
	public void verifyScrambleQuestionAssignment(String totalScrambledTitleFirstAttempt) throws Exception {
	//	String totalScrambledTitleFirstAttempt = retrieveRuntimeGlobalVariable("allScrambledQsTitleFirstAttempt");
		
		String qsTitle = "", totalScrambledTitleSecondAttempt = "";
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		// select 1st question
	//	selectQuestionNumber(questionNavList, 1); //select the question number for answering
		waitForQuestionTitle();
		
		for(int i = 0; i < questionNavList.size(); i++) {
		//	selectQuestionNumber(questionNavList, i+1);
			qsTitle = getTextFromElement(TakeAssignmentPage.questionTitle, "Question Title: " + i+1);
			totalScrambledTitleSecondAttempt = totalScrambledTitleSecondAttempt + "=>" + (i+1) + "=>" + qsTitle;
			
			if(qsTitle.toLowerCase().contains("matching")) {
				answerMatchingQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("ranking")) {
				answerRankingQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("fill in the blanks")) {
				answerFillInTheBlankQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("short answer")) {
				essay();
				
			} else if(qsTitle.toLowerCase().contains("true")) {
				TrueOrFalse();
				
			} else if(qsTitle.toLowerCase().contains("essay")) {
				essay();
				
			} else if(qsTitle.toLowerCase().contains("numeric response")) {
				answerNumericResponse();
				
			} else if(qsTitle.toLowerCase().contains("multiple choice")) {
				answerMCQNative();
				
			} else if(qsTitle.toLowerCase().contains("worksheet")) {
				answerWorksheetQuestion();
				
			}
			
			if(i < questionNavList.size()-1) {
				waiting(5);
				clickNextQuestion();
				waitForQuestionTitle();
			} else {
				break;
			}
		}
		
		if(!totalScrambledTitleFirstAttempt.equalsIgnoreCase(totalScrambledTitleSecondAttempt)) {
			System.out.println("First Attempt => " + totalScrambledTitleFirstAttempt);
			System.out.println("Second Attempt => " + totalScrambledTitleSecondAttempt);
			this.objHTMLFunctions.reportPassFailToATU("Concatinated Question Titles From Two(2) Consecutive Attempts Not Matched => Scrambling Policy Successfull =>", "true", "true");
		} else if(totalScrambledTitleFirstAttempt.equalsIgnoreCase(totalScrambledTitleSecondAttempt)) {
			this.objHTMLFunctions.reportPassFailToATU("Concatinated Question Titles From Two(2) Consecutive Attempts Matched => Scrambling Policy Unsuccessful =>", "First Attempt => " + totalScrambledTitleFirstAttempt, "Second Attempt => " + totalScrambledTitleSecondAttempt);
		}
		
	}
	
	public String takeScrambledNativeAssignment() throws Exception{
		String qsTitle = "", totalScrambledTitleFirstAttempt = "";
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		// select 1st question
		selectQuestionNumber(questionNavList, 1); //select the question number for answering
		waitForQuestionTitle();
		
		for(int i = 0; i < questionNavList.size(); i++) {
		//	selectQuestionNumber(questionNavList, i+1);
			
			qsTitle = getTextFromElement(TakeAssignmentPage.questionTitle, "Question Title: " + i+1);
			totalScrambledTitleFirstAttempt = totalScrambledTitleFirstAttempt + "=>" + (i+1) + "=>" + qsTitle;
			if(qsTitle.toLowerCase().contains("matching")) {
				answerMatchingQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("ranking")) {
				answerRankingQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("fill in the blanks")) {
				answerFillInTheBlankQuestionNative();
				
			} else if(qsTitle.toLowerCase().contains("short answer")) {
				essay();
				
			} else if(qsTitle.toLowerCase().contains("true")) {
				TrueOrFalse();
				
			} else if(qsTitle.toLowerCase().contains("essay")) {
				essay();
				
			} else if(qsTitle.toLowerCase().contains("numeric response")) {
				answerNumericResponse();
				
			} else if(qsTitle.toLowerCase().contains("multiple choice")) {
				answerMCQNative();
				
			} else if(qsTitle.toLowerCase().contains("worksheet")) {
				answerWorksheetQuestion();
				
			}
			
			if(i < questionNavList.size()-1) {
				waiting(5);
				clickNextQuestion();
				waitForQuestionTitle();
			} else {
				break;
			}
		}
		
		return totalScrambledTitleFirstAttempt;
		
	//	storeRuntimeGlobalVariable("allScrambledQsTitleFirstAttempt", totalScrambledTitleFirstAttempt);
		
	}
	
	public void takeNativeAssignment() throws Exception {
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		// select 1st question
		selectQuestionNumber(questionNavList, 1); //select the question number for answering
		waitForQuestionTitle();
		//1. answer matching question
		answerMatchingQuestionNative();
		waiting(2);
		verifyHintNAlertMsg(); //verify hint and hint alert message
		clickNextQuestion();
		waitForQuestionTitle(); 
		//2. answer ranking question
		answerRankingQuestionNative();
		waiting(2);
		verifyCheckMyWork();	//verify check my work attempt and score deduction
	//	verifyEBookDeduction();	//verify Ebook deduction
		clickNextQuestion();
		waitForQuestionTitle();
		//3. answer fill in the blank question
		answerFillInTheBlankQuestionNative();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle();
		//4. answer essay or short answer question
		essay();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle();
		//5. true/false question answer
		TrueOrFalse();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle();
		//6. answer essay or short answer question
		essay();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle();
		//7. Numeric Response question answer
		answerNumericResponse();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle();
		//8. MCQ question answer
		answerMCQNative();
		waiting(2);
		clickNextQuestion();
		waitForQuestionTitle(); 
		//9. Worksheet question answer
		answerWorksheetQuestion();
		waiting(2);  
		
		
	}
	
	public void verifyEBookDeduction() throws Exception {
		try {
		String strExpectedText = stdAssignmentData.strDTEbookAlertMsg;
		clickObject(TakeAssignmentPage.eBook, "EBook");
		waiting(1);
		verifyAlertText(strExpectedText);	//verify ebook deduction text
		checkNAcceptAlert(3);
	//	switchToNewWindowNClose();
		switchToNewWindow();
		waiting(3);
		closeApplication();
		switchToParentWindow();
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not verify Rbook deduction properly", "true", "false");
		}
	}
	
	public void verifyCheckMyWork() throws Exception {
		try {
		clickObject(TakeAssignmentPage.cmwBtn, "Check My Work");
		String actualCMWScoreDeductionText = getTextFromElement(TakeAssignmentPage.cmwScoreDeductionText, "CMW score deduction text");
		String actualCMWAttemptDeductionText = getTextFromElement(TakeAssignmentPage.cmwAttemptDeductionText, "CMW attempt deduction text");
		String expectedCMWScoreDeductionText = stdAssignmentData.strDTCMWScoreDeductionMsg;
		verifyTextEquals(actualCMWScoreDeductionText, expectedCMWScoreDeductionText, "Check My Work Score Deduction Text");
		int cmwAttemptNumber = extractNumberFromText(actualCMWAttemptDeductionText);
		int maxCMWAttemptNumber = Integer.parseInt(stdAssignmentData.strDTCMWAttemptNumber);
		if(cmwAttemptNumber == maxCMWAttemptNumber) {
		//	System.out.println("Maximum CMW attempt number matched => Expected => " + maxCMWAttemptNumber + " Actual => " + cmwAttemptNumber);
			this.objHTMLFunctions.reportPassFailToATU("Verification of max check my work attempt => ", "" + maxCMWAttemptNumber, "" + cmwAttemptNumber);
		} else {
		//	System.out.println("Maximum CMW attempt number not matched => Expected => " + maxCMWAttemptNumber + " Actual => " + cmwAttemptNumber);
			this.objHTMLFunctions.reportPassFailToATU("Verification of max check my work attempt => ", "" + maxCMWAttemptNumber, "" + cmwAttemptNumber);
		}
		
	//	System.out.println("Actual score:" + actualCMWScoreDeductionText + "+");
	//	System.out.println("Actual attempt:" + actualCMWAttemptDeductionText + "+");
	//	clickObject(TakeAssignmentPage.cmwCancel, "Check My Work cancel");
		clickObject(TakeAssignmentPage.cmwAccept, "Check My Work accept");
	//	switchToNewWindowNClose();
		switchToNewWindow();
		waiting(3);
		closeApplication();
		switchToParentWindow();
		waiting(1);
		clickObject(TakeAssignmentPage.cmwBtn, "Check My Work");	//checking CMW 2nd time
	//	switchToNewWindowNClose();
		switchToNewWindow();
		waiting(2);
		closeApplication();
		switchToParentWindow();
		waiting(1);
		clickObject(TakeAssignmentPage.cmwBtn, "Check My Work");	//Checking CMW 3rd time and it will exceed max attempts
		String expectedCMWMaxAttemptsUsedText = stdAssignmentData.strDTCMWMaxAttemptsUsedMsg;
		String actualCMWMaxAttemptsUsedText = getTextFromElement(TakeAssignmentPage.cmwMaxAttemptsUsed, "Check my work max attempts used text");
		verifyTextEquals(actualCMWMaxAttemptsUsedText, expectedCMWMaxAttemptsUsedText, "Check my work max attempts used text");
		clickObject(TakeAssignmentPage.cmwDenialCancel, "Check my work cancel");
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not verify Check My Work properly", "true", "false");
			switchToNewWindow();
			waiting(2);
			closeApplication();
			switchToParentWindow();
		}
		
	}
	
	public int extractNumberFromText(String str) {
		str = str.replaceAll("[^\\d]", "").trim();
		int number = Integer.parseInt(str);
		return number;
	}
	
	public void verifyHintNAlertMsg() throws Exception {
		try {
		String expectedHintMsg = stdAssignmentData.strDTHintMsg;
		System.out.println("Expected:" + expectedHintMsg + "+");
		waiting(3);
	//	clickObjectUsingJSExecutor(TakeAssignmentPage.hintBtn1, "Hint Button");
	//	clickObject(TakeAssignmentPage.hintBtn1, "Hint Button");
	//	WebDriverWait wait = new WebDriverWait(driver, 5);
		clickObjectUsingActionBuilder(TakeAssignmentPage.hintBtn1, "Hint Button");
	//	String actualHintAlertMsg = waitForAlertNReturnAlertText(5, wait);
	//	verifyAlertText(stdAssignmentData.strDTHintAlertMsg);
	//	verifyTextEquals(actualHintAlertMsg, stdAssignmentData.strDTHintAlertMsg, "Hint alert message");
		checkNAcceptAlert(3);
		checkObjectExists(TakeAssignmentPage.hintModal, "Hint modal");
		String actualHintMsg = getTextFromElement(TakeAssignmentPage.hintMsg, "Hint Message");
		System.out.println("Actual:" + actualHintMsg + "+");
		if(actualHintMsg.equals(expectedHintMsg)) {
			System.out.println("hint msg matched!!");
			this.objHTMLFunctions.reportPassFailToATU("Verification of text displayed in object vs expectation (hint message)", "true", "true");
		} else {
			System.out.println("hint msg not matched!!");
			this.objHTMLFunctions.reportPassFailToATU("Verification of text displayed in object vs expectation (hint message)", "true", "false");
		}
		verifyTextEquals(actualHintMsg, expectedHintMsg, "Hint Message");
		clickObject(TakeAssignmentPage.hintModalCloseBtn, "Hint Modal Close Button");
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not verify Hint and Hint alert message", "true", "false");
		}
		
	}
	
	public String waitForAlertNReturnAlertText(int waitTime, WebDriverWait wait) throws Exception {
		try {
		//	WebDriverWait wait = new WebDriverWait(driver, waitTime);
		    wait.until(ExpectedConditions.alertIsPresent());
		    Alert alert = driver.switchTo().alert();
		    System.out.println(alert.getText());
		    return alert.getText();
		//    alert.accept();
		//    Assert.assertTrue(alert.getText().contains("Thanks.")); 
		} catch (Exception e) {
		    //exception handling
			System.out.println("Waited for alert but could not be found!!!");
			return "No alert present";
		}
	}
	
	public void waitForQuestionTitle() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.questionTitle, "Question Title ", 10);
		String questionTitle = getTextFromElement(TakeAssignmentPage.questionTitle, "Question title");
		
	}
	
	//1. Matching Type Question Answering Native
	public void answerMatchingQuestionNative() throws Exception {
		
		try {
		String leftStatement1 = getTextFromElement(TakeAssignmentPage.matchingLeftStatement1, "Left Statement 1");
		String leftStatement2 = getTextFromElement(TakeAssignmentPage.matchingLeftStatement2, "Left Statement 2");
		String rightStatement1 = getTextFromElement(TakeAssignmentPage.matchingRightStatement1, "Right Statement 1");
		String rightStatement2 = getTextFromElement(TakeAssignmentPage.matchingRightStatement2, "Right Statement 2");
	/*	System.out.println(leftStatement1 + "*");
		System.out.println(leftStatement2 + "*");
		System.out.println(rightStatement1 + "*");
		System.out.println(rightStatement2 + "*"); */
		
		if(leftStatement1.toLowerCase().contains("bengal")) {
			if(rightStatement1.toLowerCase().contains("kolkata")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption1, "option 1");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption1, "option 1");
			} else if(rightStatement2.toLowerCase().contains("kolkata")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption1, "option 1");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption1, "option 1");
			}
			
		} else if(leftStatement2.toLowerCase().contains("bengal")) {
			if(rightStatement1.toLowerCase().contains("kolkata")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement1_selector, "kolkata selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption2, "option 2");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption2, "option 2");
			} else if(rightStatement2.toLowerCase().contains("kolkata")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement2_selector, "kolkata selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption2, "option 2");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption2, "option 2");
			}
			
		} 
		if(leftStatement1.toLowerCase().contains("india")) {
			if(rightStatement1.toLowerCase().contains("delhi")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption1, "option 1");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption1, "option 1");
			} else if(rightStatement2.toLowerCase().contains("delhi")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption1, "option 1");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption1, "option 1");
			}
		} else if(leftStatement2.toLowerCase().contains("india")) {
			if(rightStatement1.toLowerCase().contains("delhi")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement1_selector, "delhi selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption2, "option 2");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption2, "option 2");
			} else if(rightStatement2.toLowerCase().contains("delhi")) {
			//	clickObject(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.matchingRightStatement2_selector, "delhi selector");
				waiting(1);
				clickObject(TakeAssignmentPage.matchingOption2, "option 2");
			//	clickObjectUsingJSExecutor(TakeAssignmentPage.matchingOption2, "option 2");
			}
		}
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Matching question", "true", "false");
		}
	}
	
	//2. Ranking type question answering native
	public void answerRankingQuestionNative() throws Exception {
		try {
		List<String> rankingStatements = new ArrayList<String>();
		int i = 1;
		try {
			while(TakeAssignmentPage.rankingStatementText(this.driver, i).getText() != null) {
			//	System.out.println(TakeAssignmentPage.rankingStatementText(this.driver, i).getText());
				rankingStatements.add(i-1, TakeAssignmentPage.rankingStatementText(this.driver, i).getText().toLowerCase());
				i++;
			}
		} catch(Exception e) {
			System.out.println(i-1 +  " Statements added in List succesfully");
		}
		
		for(String str: rankingStatements) {
			if(str.contains("jammu")) {
				i = rankingStatements.indexOf(str) + 1;
			//	clickObject(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				waiting(1);
				clickObject(TakeAssignmentPage.rankingOption(this.driver, 1), "Rank " + 1);
			} else if(str.contains("punjab")) {
				i = rankingStatements.indexOf(str) + 1;
			//	clickObject(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				waiting(1);
				clickObject(TakeAssignmentPage.rankingOption(this.driver, 2), "Rank " + 2);
			} else if(str.contains("delhi")) {
				i = rankingStatements.indexOf(str) + 1;
			//	clickObject(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				waiting(1);
				clickObject(TakeAssignmentPage.rankingOption(this.driver, 3), "Rank " + 3);
			} else if(str.contains("kolkata")) {
				i = rankingStatements.indexOf(str) + 1;
			//	clickObject(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				waiting(1);
				clickObject(TakeAssignmentPage.rankingOption(this.driver, 4), "Rank " + 4);
			} else if(str.contains("tamil")) {
				i = rankingStatements.indexOf(str) + 1;
			//	clickObject(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				clickObjectUsingActionBuilder(TakeAssignmentPage.rankingStatement_selector(this.driver, i), str + " selector");
				waiting(1);
				clickObject(TakeAssignmentPage.rankingOption(this.driver, 5), "Rank " + 5);
			}
		}
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Ranking question", "true", "false");
		}
		
	}
	
	//3. Fill in the blank question answering native
	public void answerFillInTheBlankQuestionNative() throws Exception {
		try {
		clearNTypeValue(TakeAssignmentPage.fillInTheBlankAnswerNative, "Fill in the blanks answer", "Delhi");
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Fill in the question", "true", "false");
		}
	}
	
	//7. Numeric Response question answering
	public void answerNumericResponse() throws Exception {
		try {
		waitTillElementDisplayed(TakeAssignmentPage.numericExpression, "Numeric Expression", 10);
		String expression = getTextFromElement(TakeAssignmentPage.numericExpression, "Numeric Expression");
		System.out.println("Expression = " + expression);
		
		String expressionMod = expression.replaceAll(" ", "");
	//	System.out.println(expressionMod);
		String parts[] = expressionMod.split("\\+");
	//	System.out.println("Parts = " + parts[0] + "|" + parts[1]);
		String firstPart[] = parts[0].split("\\*");
	//	System.out.println("FirstPart = " + firstPart[0] + "|" + firstPart[1]);
		String secondPart[] = parts[1].split("\\*");
	//	System.out.println("SecondPart = " + secondPart[0] + "|" + secondPart[1]);
		int numericAnswer = (Integer.parseInt(firstPart[0]) * Integer.parseInt(firstPart[1])) + (Integer.parseInt(secondPart[0]) * Integer.parseInt(secondPart[1]));
	//	System.out.println(numericAnswer);
		clearNTypeValue(TakeAssignmentPage.answerNum, "Number input", String.valueOf(numericAnswer));
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Numeric Response question", "true", "false");
		}
		
	}
	
	//7. Verify and Answer Numeric Response --->
	public void verifyNAnswerNumericResponse() throws Exception {
		int answer = evaluateNumericResponse();	//evaluating numeric response answer
		int upperLimit = answer * 2;	//based on 100% numeric tolerance
		int lowerLimit = 0;				//based on 100% numeric tolerance
		
		//answering and verifying upper limit using CMW
		answerNumericResponse(upperLimit + 1);	//answering greater than upper limit tolerance -- expected --> Wrong
		clickCheckMyWork();
		waiting(2);
		clickObject(TakeAssignmentPage.cmwAccept, "Check My Work accept");
		waiting(2);
		switchToNewWindow();
		waiting(3);
		checkObjectExists(TakeAssignmentPage.cmwWrongInputCheck, "Numeric Input Value has exceeded upper Tolerance Value --> Wrong");
		closeApplication();
		switchToParentWindow();
		waiting(1);
		
		answerNumericResponse(upperLimit);	//answering exact value upper limit tolerance -- expected --> Correct
		clickCheckMyWork();
		waiting(3);
		switchToNewWindow();
		waiting(3);
		checkObjectExists(TakeAssignmentPage.cmwCorrectInputCheck, "Numeric Input Value has not exceeded upper Tolerance Value --> Correct");
		closeApplication();
		switchToParentWindow();
		waiting(1);
		
		//Answering and verifying lower limit using CMW
		answerNumericResponse(lowerLimit - 1);	//answering exact value lower limit tolerance -- expected --> Wrong
		clickCheckMyWork();
		waiting(3);
		switchToNewWindow();
		waiting(3);
		checkObjectExists(TakeAssignmentPage.cmwWrongInputCheck, "Numeric Input Value has exceeded lower Tolerance Value --> Wrong");
		closeApplication();
		switchToParentWindow();
		waiting(1);
		
		answerNumericResponse(lowerLimit);	//answering exact value lower limit tolerance -- expected --> Correct
		clickCheckMyWork();
		waiting(3);
		switchToNewWindow();
		waiting(3);
		checkObjectExists(TakeAssignmentPage.cmwCorrectInputCheck, "Numeric Input Value has not lower exceeded Tolerance Value --> Correct");
		closeApplication();
		switchToParentWindow();
		waiting(1);
		
		//Answering Exact correct answer and using CMW to verify
		answerNumericResponse(answer);	//answering exact correct answer -- expected --> Correct
		clickCheckMyWork();
		waiting(3);
		switchToNewWindow();
		waiting(3);
		checkObjectExists(TakeAssignmentPage.cmwCorrectInputCheck, "Numeric Input Value Exact Answe --> Correct");
		closeApplication();
		switchToParentWindow();
		waiting(1);
		
		
	}
	
	public void answerNumericResponse(int answer) throws Exception {
		clearNTypeValue(TakeAssignmentPage.answerNum, "Number input", String.valueOf(answer));
	}
	
	public int evaluateNumericResponse() throws Exception {
		try {
			waitTillElementDisplayed(TakeAssignmentPage.numericExpression, "Numeric Expression", 10);
			String expression = getTextFromElement(TakeAssignmentPage.numericExpression, "Numeric Expression");
			System.out.println("Expression = " + expression);
			
			String expressionMod = expression.replaceAll(" ", "");
		//	System.out.println(expressionMod);
			String parts[] = expressionMod.split("\\+");
		//	System.out.println("Parts = " + parts[0] + "|" + parts[1]);
			String firstPart[] = parts[0].split("\\*");
		//	System.out.println("FirstPart = " + firstPart[0] + "|" + firstPart[1]);
			String secondPart[] = parts[1].split("\\*");
		//	System.out.println("SecondPart = " + secondPart[0] + "|" + secondPart[1]);
			int numericAnswer = (Integer.parseInt(firstPart[0]) * Integer.parseInt(firstPart[1])) + (Integer.parseInt(secondPart[0]) * Integer.parseInt(secondPart[1]));
		//	System.out.println(numericAnswer);
		//	clearNTypeValue(TakeAssignmentPage.answerNum, "Number input", String.valueOf(numericAnswer));
			return numericAnswer;	//returns the evaluated answer
			} catch(Exception e) {
				this.objHTMLFunctions.ReportPassFail("Could not answer Numeric Response question", "true", "false");
				return -32767;
			}
	}
	
	//8. MCQ question answering
	public void answerMCQNative() throws Exception {
		try {
		waiting(2);
		clickObject(TakeAssignmentPage.mcqChoice(this.driver, "gmail"), "gmail option");
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer MCQ Native question", "true", "false");
		}
	}
	
	//9. Worksheet question answering
	public void answerWorksheetQuestion() throws Exception {
		try {
			waitTillElementDisplayed(TakeAssignmentPage.worksheetBody, "Worksheet Body", 10);
			clearNTypeValue(TakeAssignmentPage.listCompletionWorksheetAns, "List Completion Answer", "Seoul");
			selectValueByTextFromList(TakeAssignmentPage.mcqWorksheetAns, "MCQ worksheet answer", "Mundaka Upanishad");
			clearNTypeValue(TakeAssignmentPage.fillInTheBlankWorksheet, "Fill in the blank worksheet answer",
					"C. Rajagopalachari");
			selectValueByTextFromList(TakeAssignmentPage.trueOrFalseWorksheet, "True or False worksheet answer",
					"False");
			clearNTypeValue(TakeAssignmentPage.essayWorksheet1, "Essay Worksheet 1",
					"Instructor has to manually grade 1.");
			clearNTypeValue(TakeAssignmentPage.essayWorksheet2, "Essay Worksheet 1",
					"Instructor has to manually grade 2.");
		} catch (Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Worksheet question properly", "true", "false");
		}
		
	}
	
	public List<WebElement> selectQuestionNavStdAssignment() throws Exception{
		clickObject(AssignmentPage.questionNavigator, "Question Navigator");
		waiting(2);
		
		return AssignmentPage.insPrevQuestionList(driver);
	}
	
	public void selectQuestionNumber(List<WebElement> questionNavList, int number) throws Exception {
		clickObject(questionNavList.get(number-1), "Quesion " + number);
	}
	
	//***************************sayan end

	public String getAnswerForQuestion(String question) throws Exception {
		String strDTQuestion = "", strAnswer = "", strQuestionType = "";
		try {
			GlobalPaths objGLPaths = new GlobalPaths();
			HSSFWorkbook objWB = new HSSFWorkbook(new FileInputStream(objGLPaths.strXLInputDatasheetPath));
			HSSFSheet objSHOutputSheet = objWB.getSheet("QuestionsAndAnswers");

			for (int intRow = 0; intRow <= objSHOutputSheet.getLastRowNum(); intRow++) {
				strDTQuestion = CMNFunctions.GetCellValueInExcel(objSHOutputSheet, intRow, 0);
				if (question.equalsIgnoreCase(strDTQuestion)) {
					strAnswer = CMNFunctions.GetCellValueInExcel(objSHOutputSheet, intRow, 2);
					strQuestionType = CMNFunctions.GetCellValueInExcel(objSHOutputSheet, intRow, 1);
					break;
				}
			}
			return strAnswer + ";" + strQuestionType;
		} catch (Exception e) {
			e.printStackTrace();
			return strAnswer + ";" + strQuestionType;
		}
	}

	public void clickNextQuestion() throws Exception {
		clickObject(TakeAssignmentPage.nextQuestion, "Next Question");
	}
	public void clickNextQuestionPAAM() throws Exception {
		clickObject(TakeAssignmentPage.next, "Next Question");
	}

	public void clickSaveNExit() throws Exception {
		clickObject(TakeAssignmentPage.saveNExitAssignment, "Save and Exit Assignment");
	}

	public void clickSubmit() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.submitAssignment, "Submit Assignment", 10);
		clickObject(TakeAssignmentPage.submitAssignment, "Submit Assignment");
	}

	public void clickConfirmSubmit() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.confirmSubmit1, "Confirm Submit", 6);
		clickObject(TakeAssignmentPage.confirmSubmit1, "Confirm Submit");
	}

	public void verifyIncompleteQuestions() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.incompleteAssignment, "Wait! You have not completed all of the questions.", 4);
		checkObjectExists(TakeAssignmentPage.incompleteAssignment, "Wait! You have not completed all of the questions.");
	}

	public void clickCancelSubmit() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.cancelIncompleteAssignment, "Cancel Incomplete Assignment", 10);
		clickObject(TakeAssignmentPage.cancelIncompleteAssignment, "Cancel Incomplete Assignment");
	}
	public void CancelSubmit() throws Exception {
		clickObject(TakeAssignmentPage.cancelSubmit, "Cancel Incomplete Assignment");
	}

	public void verifyDetailedFeedback() throws Exception {
		String strScore = TakeAssignmentPage.subReportAutoGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportAutoGraded,
				"Points earned on auto-graded questions: " + strScore);
		strScore = TakeAssignmentPage.subReportInstructorGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportInstructorGraded,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = TakeAssignmentPage.totalScore.getText();
		checkObjectExists(TakeAssignmentPage.totalScore, "Total Score: " + strScore);
	}
	
	//*********************sayan start
	
	public void attemptDeductionScoreValidation(int i, String deductionPercentStr) throws Exception {
		String strScore = TakeAssignmentPage.subReportAutoGraded.getText();
		int actualAutoGradedScore = Integer.parseInt(strScore);
		int autoGradingFullMarks = Integer.parseInt(getTextFromElement(TakeAssignmentPage.autoGradingFullMarks, "Full marks on auto-gradable questions").replaceAll("[^\\d]", ""));
	//	int deductionPercentage = Integer.parseInt(retrieveRuntimeGlobalVariable("deductionPercent" + i));
		int deductionPercentage = Integer.parseInt(deductionPercentStr);
		if(actualAutoGradedScore == autoGradingFullMarks - (autoGradingFullMarks * deductionPercentage) / 100) {
			this.objHTMLFunctions.reportPassFailToATU("Verification of Compound Deduction at " + deductionPercentage + "% for auto-gradable questions in Post Submission View => <b>" + actualAutoGradedScore + " out of " + autoGradingFullMarks + "</b>", "true", "true");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Verification of Compound Deduction at " + deductionPercentage + "% for auto-gradable questions in Post Submission View => <b>" + actualAutoGradedScore + " out of " + autoGradingFullMarks + "</b>", "true", "false");
		}
		
	}
	
	public void verifyDetailedFeedbackWithScoreDeductions() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment List", 10);
		
		String strScore = TakeAssignmentPage.subReportAutoGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportAutoGraded,
				"Points earned on auto-graded questions: " + strScore);
		strScore = TakeAssignmentPage.subReportInstructorGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportInstructorGraded,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = TakeAssignmentPage.totalScore.getText();
		checkObjectExists(TakeAssignmentPage.totalScore, "Total Score: " + strScore);
		
		List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
		selectQuestionNumber(questionNavList, 1);
		List<String> questionScoreInfoList = new ArrayList<String>();
		for(int i = 0; i < 3; i++) {
			questionScoreInfoList.add(getTextFromElement(TakeAssignmentPage.questionScoreInfo(this.driver, i+1), "Question Score Info " + i+1));
			clickNextQuestion();
			waiting(1);
		}
		
		
		//1. Question No. 1 => Hints and Ebook Deduction validation
		String scoreInfo = questionScoreInfoList.get(0);
		scoreInfo = scoreInfo.replaceAll("[^\\d]", " ").replaceAll("( +)"," ");
		int score = Integer.parseInt(scoreInfo.split(" ")[0]);
		int fullMarks = Integer.parseInt(scoreInfo.split(" ")[1]);
		
		if(fullMarks*.9 == score) {
			this.objHTMLFunctions.reportPassFailToATU("Verification of Hints and Ebook Deduction at 10% each in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "true");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Verification of Hints and Ebook Deduction at 10% each in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "false");
		}
		
		//2. Question No. 2 => Check My Work and Ebook Deduction validation
		scoreInfo = questionScoreInfoList.get(1);
		scoreInfo = scoreInfo.replaceAll("[^\\d]", " ").replaceAll("( +)"," ");
		score = Integer.parseInt(scoreInfo.split(" ")[0]);
		fullMarks = Integer.parseInt(scoreInfo.split(" ")[1]);
		
		if(fullMarks*.9 == score) {
			this.objHTMLFunctions.reportPassFailToATU("Verification of CMW and Ebook Deduction at 10% each in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "true");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Verification of CMW and Ebook Deduction at 10% each in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "false");
		}
		
		//3. Question No. 3 => Ebook Deduction validation
		scoreInfo = questionScoreInfoList.get(2);
		scoreInfo = scoreInfo.replaceAll("[^\\d]", " ").replaceAll("( +)"," ");
		score = Integer.parseInt(scoreInfo.split(" ")[0]);
		fullMarks = Integer.parseInt(scoreInfo.split(" ")[1]);
		
		if(fullMarks*1 == score) {
			this.objHTMLFunctions.reportPassFailToATU("Verification Ebook Deduction at 10% in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "true");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Verification Ebook Deduction at 10% in Post Submission View => <b>" + score + " out of " + fullMarks + "</b>", "true", "false");
		}
		
	}
	
	
	
	//*********************sayan end

	public void clickReturnToAssignmentList() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment List", 10);
		clickObject(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment List");
		waiting(2);
	}

	public void verifyFullCredit() throws Exception {
		checkObjectExists(TakeAssignmentPage.fullCreditMessage,
				"Full credit for this question has been awarded to all students");
	}

	public void verifyQuestionDropped() throws Exception {
		checkObjectExists(TakeAssignmentPage.questionDroppedMessage,
				"This question and its points have been dropped for all students");
	}

	public void verifyTotalScoresFeedback() throws Exception {
	/*	String strScore = TakeAssignmentPage.subReportAutoGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportAutoGraded,
				"Points earned on auto-graded questions: " + strScore);
		strScore = TakeAssignmentPage.subReportInstructorGraded.getText();
		checkObjectExists(TakeAssignmentPage.subReportInstructorGraded,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = TakeAssignmentPage.assignmentWorth.getText();
		checkObjectExists(TakeAssignmentPage.assignmentWorth, "This assignment is worth: " + strScore);	*/
		waitTillElementDisplayed(stdReportsPage.totalScore, "Total Score", 10);
		String strScore = stdReportsPage.autoGrade.getText();
		checkObjectExists(stdReportsPage.autoGrade,
				"Points earned on auto-graded questions: " + strScore);
		strScore = stdReportsPage.manualGrade.getText();
		checkObjectExists(stdReportsPage.manualGrade,
				"Points you may earn on instructor-graded questions: " + strScore);
		strScore = stdReportsPage.totalScore.getText();
		checkObjectExists(stdReportsPage.totalScore, "Total Score: " + strScore);
	}

	public void waitForScoreThisQuestion(int waitTime) throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.scoreThisQuestion, "Score This Question", waitTime);
	}

	public void clickScoreThisQuestion() throws Exception {
		clickObject(TakeAssignmentPage.scoreThisQuestion, "Score This Question");
		waiting(1);
	}

	public void clickContinueAnyway() throws Exception {
		waiting(2);
		waitTillElementEnabled(TakeAssignmentPage.continueAnyway1, "Continue Anyway", 5);
		checkObjectExists(TakeAssignmentPage.incompleteQuestion,
				"Wait! You have not completed all of the questions on this page.");
		clickObject(TakeAssignmentPage.continueAnyway1, "Continue Anyway");
	}

	public void verifyIntermediaryScore() throws Exception {
		//***changed by sayan
		checkObjectExists(TakeAssignmentPage.intermediaryScore, "Intermediary Score" + getTextFromElement(TakeAssignmentPage.intermediaryScore, "Intermediary Score"));
		//***changed by sayan
	//	checkObjectExists(TakeAssignmentPage.intermediaryScore, "Intermediary Score" + getTextFromElement(TakeAssignmentPage.intermediaryScore, "Intermediary Score").split(";")[1]);
	}

	public void verifyQuestionFeedback() throws Exception {
		String strScore = TakeAssignmentPage.reportScore.getText();
		String strPercentage = TakeAssignmentPage.reportPercentage.getText();
		checkObjectExists(TakeAssignmentPage.reportScorePercentage(driver, strScore, strPercentage),
				"Score: " + strPercentage + " Points " + strPercentage + "%");
	}

	public void verifyNoFeedback() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.thankYouForSubmission, "Thank You For Submission", 5);
		waiting(1);
		checkObjectExists(TakeAssignmentPage.thankYouForSubmission, "Thank You For Submission");
	}

	public void verifyBOPA() throws Exception {
		checkObjectExists(TakeAssignmentPage.bopaMessage, "Your attempt has not yet been graded. Check back later.");
		try {
			String assignmentName = CreateAssignData.strDTAssignmentTitle;
			String actualClassVal = getAttributeFromElement(TakeAssignmentPage.selectAssignmentToTakeByTitle(this.driver, assignmentName), assignmentName, "class");
			String expectedClassVal = "freeze assignment-title";
			verifyTextEquals(actualClassVal, expectedClassVal, "Freezed Assignment Title class attribute value verification");
			
		}catch(Exception e) {
			System.out.println("Unable to verify Freezed Assignment Title class attribute value");
			this.objHTMLFunctions.reportPassFailToATU("Unable to verify Freezed Assignment Title class attribute value", "true", "false");
		}
	}
	
	public void verifyFullCreditOnCompletion() throws Exception {
		checkObjectExists(TakeAssignmentPage.fullCreditOnCompletionText, "You received credit for the questions you attempted.");
		//replacing all other characters except digits with space -> [^//d] = finds all the characters except digits, "//s+" = finds all the more than one spaces together
		String scoreTexts[] = getTextFromElement(TakeAssignmentPage.fullCreditOnCompletionScore, "Full Credit On Completion Score").replaceAll("[^\\d]", " ").replaceAll("\\s+"," ").split(" ");	
		String score = scoreTexts[0];
		String fullMarks = scoreTexts[1];
		if(score.equalsIgnoreCase(fullMarks)) {
			this.objHTMLFunctions.reportPassFailToATU("Full Credit on Completion Verification => Score => " + score + " out of " + fullMarks, "true", "true");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Full Credit on Completion Verification => Score => " + score + " out of " + fullMarks, "true", "false");
		}
		
		verifyDetailedFeedbackWithSolutionPart();
	}
	
	public void verifyDetailedFeedbackWithSolutionPart() throws Exception {
		//Checking detailed feedback with solution => solution part for question 1
		String feedbackSolution = getTextFromElement(TakeAssignmentPage.feedbackSolutionQs1, "Feedback Solution for Question: 1");
		checkObjectExists(TakeAssignmentPage.feedbackSolutionQs1, "Feedback Solution for Question: 1 => " + feedbackSolution);
	}

	public void verifyAnswerTolerance() throws Exception {
		verifyTextInElement(TakeAssignmentPage.answerToleranceMessage, "Tolerance Message",
				"Your answer(s) received credit but don't exactly match the correct answer(s).");
	}

	public void uploadFile() throws Exception {
		try {
			getCooridnatesNClick(TakeAssignmentPage.uploadFilesTakeAssignment, "Upload files");
			waiting(3);
			pasteFromClipboard(System.getProperty("user.dir") + "//FilesToUpload//" + "FileAttachmentSample.txt");
			waiting(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void waitForReturnToSectionHome(int waitTime) throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.returnToSectionHome, "Return to Section Home", waitTime);
	}

	public void clickSubmitFileAttachment() throws Exception {
		clickObject(TakeAssignmentPage.submitFileAttach, "Click submit assignment");
		waiting(2);
	}

	public void clickDoneFileAttachment() throws Exception {
		clickObject(TakeAssignmentPage.doneFileAtachment, "Click done assignment");
		waiting(2);
	}

	public void waitForWebActivityPage(int waitTime) throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.doneWebActivity, "Web Activity Page", waitTime);
	}

	public void clickWebLink() throws Exception {
		clickObject(TakeAssignmentPage.webLink, "Click submit assignment");
		waiting(2);
		switchToNewWindow();
		closeApplication();
		switchToParentWindow();
		waiting(2);
	}

	public void clickDoneWebActivity() throws Exception {
		clickObject(TakeAssignmentPage.doneWebActivity, "Web Activity Page");
		waiting(2);
	}

	public void clickAskInstructor() throws Exception {
		clickObject(TakeAssignmentPage.askInstructor, "Ask Instructor");
		waiting(2);
	}

	public void typeMessage() throws Exception {
		typeValue(TakeAssignmentPage.askInstructorMessage, "Ask Instructor Message", "Question to Instructor");
		waiting(2);
	}

	public void clickSendMessage() throws Exception {
		clickObject(TakeAssignmentPage.sendMessage, "Send Message");
		waiting(3);
	}

	public void uploadDataAttachment_UsingJS() throws Exception {
		try {
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String stringfilePath = System.getProperty("user.dir") + "//FilesToUpload//" + "FileAttachmentSample.txt";
			typeValue(TakeAssignmentPage.txtFileUploadBackEnd, "File Upload", stringfilePath);
		} catch (Exception objException) {
			objException.getMessage();
		}
	}

	/*************************************************************************************************
	 * â€‚â€‚ * Expands/collapses classes/results and selects the course
	 * corresponding to the section â€‚â€‚ * @param strParentMenu â€‚â€‚
	 * * @param strChildMenu â€‚â€‚ * @param strSectionName â€‚â€‚ * @throws
	 * Exception â€‚â€‚
	 *************************************************************************************************/
	public void leftSideNavigationUsingXPathNewUI(String strMenu) throws Exception {
		try {
			switchToDefaultPage();
			switchiFrame();
			if (checkObjectVisibleWOError(TakeAssignmentPage.eltLeftMenuHiddenLHSNew, "eltLeftMenuHiddenLHSNew")) {
				clickObject(TakeAssignmentPage.eltFlowButtonLHSNew, "eltFlowButtonLHSNew");
			}
			// clickObject(TakeAssignmentPage.eltFlowButtonLHSNew,
			// "eltFlowButtonLHSNew");
			if (strMenu.contains(";")) {
				String strParentMenu = strMenu.split(";")[0];
				String strChildMenu = strMenu.split(";")[1];
				System.out.println(strParentMenu + "--" + strChildMenu);

				if (strParentMenu.equalsIgnoreCase("userinfo")) {
					clickObject(TakeAssignmentPage.eltUserInfoNew, "eltUserInfoNew");

					if (strChildMenu.equalsIgnoreCase("messages"))
						clickObjectUsingJSExecutor(TakeAssignmentPage.eltMessagesNew, "eltMessagesNew");
					else if (strChildMenu.equalsIgnoreCase("notifications"))
						clickObjectUsingJSExecutor(TakeAssignmentPage.eltNotificationsNew, "eltNotificationsNew");
					else if (strChildMenu.equalsIgnoreCase("settings"))
						clickObjectUsingJSExecutor(TakeAssignmentPage.eltSettingsNew, "eltSettingsNew");
					else if (strChildMenu.equalsIgnoreCase("help"))
						clickObjectUsingJSExecutor(TakeAssignmentPage.eltHelpNew, "eltHelpNew");
					else
						System.out.println("Invalid child for UserInfo");
				} else if (strParentMenu.equalsIgnoreCase("classes")) {
					clickObject(TakeAssignmentPage.eltClassesNew, "eltClassesNew");
					try {
						clickObjectUsingJSExecutor(TakeAssignmentPage.CourseNameClass(driver, strChildMenu),
								"Course: " + strChildMenu);
					} catch (NoSuchElementException NSE) {
						System.out.println("Course: " + strChildMenu + " is not available in Classes");
						objHTMLFunctions.reportPassFailToATU("CourseNotAvailable - Classes", strChildMenu, "");
						objHTMLFunctions.ReportPassFail("CourseNotAvailable - Classes", strChildMenu, "");
					}
				} else if (strParentMenu.equalsIgnoreCase("results")) {
					clickObject(TakeAssignmentPage.eltResultsNew, "eltResultsNew");
					try {
						clickObjectUsingJSExecutor(TakeAssignmentPage.CourseNameResults(driver, strChildMenu),
								"Course: " + strChildMenu);
					} catch (NoSuchElementException NSE) {
						System.out.println("Course: " + strChildMenu + " is not available in Results");
						objHTMLFunctions.reportPassFailToATU("CourseNotAvailable - Results", strChildMenu, "");
						objHTMLFunctions.ReportPassFail("CourseNotAvailable - Results", strChildMenu, "");
					}
				}
			} else {
				System.out.println(strMenu);
				if (strMenu.equalsIgnoreCase("todo"))
					clickObject(TakeAssignmentPage.eltToDoNew, "eltToDoNew");
				else if (strMenu.equalsIgnoreCase("calendar"))
					clickObject(TakeAssignmentPage.eltCalendarNew, "eltCalendarNew");
				else if (strMenu.equalsIgnoreCase("classes")) {
					clickObject(TakeAssignmentPage.eltClassesNew, "eltClassesNew");
					clickObjectUsingJSExecutor(TakeAssignmentPage.eltDefClassCourseNew, "CourseInClass");
				} else if (strMenu.equalsIgnoreCase("results")) {
					clickObject(TakeAssignmentPage.eltResultsNew, "eltResultsNew");
					clickObjectUsingJSExecutor(TakeAssignmentPage.eltDefResCourseNew, "CourseInResults");
				} else if (strMenu.equalsIgnoreCase("insight"))
					clickObject(TakeAssignmentPage.eltInsightsNew, "eltInsightsNew");
				else if (strMenu.equalsIgnoreCase("logout"))
					clickObject(TakeAssignmentPage.eltLogoutNew, "eltLogoutNew");
				else
					System.out.println("Invalid option: " + strMenu);
			}
		} catch (Exception objException) {
			objHTMLFunctions
					.reportPassFailToATU("Executing function leftSideNavigationUsingXPathNewUI failed. <BR>Error=>"
							+ objCMNFunctions.GetExceptionNDisplay(objException, true), "true", "false");
		}

	}

	// ************* New Methods **************** 20/07/2017 //TODO

	public void selectAssignment(int index) throws Exception {
		try {
			switchToDefaultPage();
			waiting(2);
			switchiFrame(1);
			String assignmentName = CreateAssignData.strDTAssignmentTitle.trim();
			clickObjectUsingJSExecutor(TakeAssignmentPage.SelectAssignmentFromList(driver, index), "Assignment Name");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void clickBeginOrContinue() throws Exception {
		try {
			switchToDefaultPage();
			waiting(2);
			switchiFrame();
			clickObjectUsingJSExecutor(TakeAssignmentPage.btnEnterAssignment, "Click begin / continue assignment");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickStartAssignment() throws Exception {
		try {
			switchToDefaultPage();
			waiting(10);

			switchiFrame(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.startAssignment, "Click Start Assignment");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToClickAndDragQuestion() throws Exception {
		waiting(3);
		try {
			// switchToDefaultPage();
			// switchToFrame(TakeAssignmentPage.frmQuestionFrame, "Main
			// iFrame");
			waitTillElementEnabled("//*[@class='external  ']", "Iframe", 25);
			switchToFrame("//*[@class='external  ']", "Sub iFrame");
			// switchiFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void checkMultipleChoiceAnswered() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.correctIndicator, "Correct Indicator", 25);
		if (TakeAssignmentPage.correctIndicator.isDisplayed()) {
			clickObject(TakeAssignmentPage.correctIndicator, "Correct Indicator Present");
		}
	}

	public void dragAndDrop(WebElement source, WebElement target) {
		// Configure the action
		Actions builder = new Actions(driver);

		Action drag = builder.clickAndHold(source).moveToElement(target).release(target).build();

		drag.perform();
	}

	public void answerClickAndDrag() throws InterruptedException {
		dragAndDrop(TakeAssignmentPage.dragableLaMesa, TakeAssignmentPage.dragLaMesa);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableElRaloj, TakeAssignmentPage.dragElRaloj);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableLaPared, TakeAssignmentPage.dragLaPared);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableElEscritotio, TakeAssignmentPage.dragElEscritotio);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableElTecho, TakeAssignmentPage.dragElTecho);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableElMapa, TakeAssignmentPage.dragElMapa);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableLaPizzare, TakeAssignmentPage.dragLaPizzare);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableLaVentana, TakeAssignmentPage.dragLaVentana);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableLaSilla, TakeAssignmentPage.dragLaSilla);
		waiting(1);
		dragAndDrop(TakeAssignmentPage.dragableLosPupitries, TakeAssignmentPage.dragLosPupitries);
		waiting(1);

	}

	public void answerMCQ() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.multipleChoiceOption, "Page Loading", 25);
		clickObject(TakeAssignmentPage.multipleChoiceOption, "Multiple Choice Option");
	}

/*	public void MacthingAnswer() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.selectOption(driver, 1), "Select Option", 10);
		clickObject(TakeAssignmentPage.selectOption(driver, 1), "Select First Match");
		waiting(2);
		
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber1, "Select First Option");
		waiting(2);
		clickObject(TakeAssignmentPage.selectOption(driver, 2), "Select Second Match");
		waiting(2);
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumbers, "Select Second Option");
	}*/
	public void MacthingAnswer() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.selectOption(driver, 1), "Select Option", 10);
		clickObject(TakeAssignmentPage.selectOption(driver, 1), "Select First Match");
		waiting(2);
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber1, "Select First Option");
		waiting(2);
		clickObject(TakeAssignmentPage.selectOption(driver, 2), "Select Second Match");
		waiting(2);
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumbers, "Select Second Option");
	}
	//Ans 1 Macthing Correct
	public void macthingAnswer() throws Exception {
		
		try{
		waitTillElementDisplayed(TakeAssignmentPage.selectOptionMatchingText(driver, 1), "Select Option", 10);
		String s = TakeAssignmentPage.selectOptionMatchingText(driver, 1).getText();
		String t=TakeAssignmentPage.selectOptionMatchingText(driver, 2).getText();
		String x=TakeAssignmentPage.selectOptionMatchingClassicText(driver, 1).getText();
		String z=TakeAssignmentPage.selectOptionMatchingClassicText(driver, 2).getText();
		if((TakeAssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("kolkata") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("west"))))
		{
			clickObject(TakeAssignmentPage.selectOptionButton(driver, 1), "Select First Match");
			waiting(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,1,2), "Select First Option");
			waiting(2);
		}else if((TakeAssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("Delhi") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("west"))))
		{
			clickObject(TakeAssignmentPage.selectOptionButton(driver, 1), "Select First Match");
			waiting(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,1,3), "Select First Option");
			waiting(2);
		}else if((TakeAssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("Delhi") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("India"))))
		{
			clickObject(TakeAssignmentPage.selectOptionButton(driver, 1), "Select First Match");
			waiting(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,1,2), "Select First Option");
			waiting(2);
		}else
		{
			clickObject(TakeAssignmentPage.selectOptionButton(driver, 1), "Select First Match");
			waiting(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,1,3), "Select First Option");
			waiting(2);
		}
		waiting(3);
		if((TakeAssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("Delhi") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("India"))))
			{
		//	clickObject(TakeAssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
			waiting(2);
			clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,2,3), "Select First Option");
			waiting(2);
			}else if((TakeAssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("kolkata") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("India"))))
				{
			//	clickObject(TakeAssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,2,2), "Select First Option");
				waiting(2);
				}else if((TakeAssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("kolkata") && (TakeAssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("west"))))
				{
			//	clickObject(TakeAssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,2,3), "Select First Option");
				waiting(2);
				}else
				{
			//	clickObject(TakeAssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionMatchingClassicButton(driver,2,2), "Select First Option");
				waiting(2);
				}
		}catch(Exception e)
		{
			nextQuestion();
			this.objHTMLFunctions.reportPassFailToATU(
					 "Matching Answer Student Preview couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		
		}
	//Ranking Answer Wrong
	public void RankingAnswerWrong() throws Exception {

		List<WebElement> rankingOptions = TakeAssignmentPage.rankingOptionsNew;
		waitTillElementDisplayed(TakeAssignmentPage.selectOptionRanking(driver, 1), "Select Option", 10);
		for (int i = 0; i <= (rankingOptions.size()) - 1; i++) {
			if (TakeAssignmentPage.rankingOptionsNew.get(i).getText().contains("Punjab")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswer1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptionsNew.get(i).getText().contains("Tamil")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswer1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptionsNew.get(i).getText().contains("Jammu")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswer1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptionsNew.get(i).getText().contains("Delhi")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswer1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptionsNew.get(i).getText().contains("Kolkata")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswer1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			}
		}
	}
//Ranking Answer Correct
	public void RankingAnswer() throws Exception {

		List<WebElement> rankingOptions = TakeAssignmentPage.rankingOptions;
		waitTillElementDisplayed(TakeAssignmentPage.selectOptionRanking(driver, 1), "Select Option", 10);
		for (int i = 0; i <= (rankingOptions.size()-1); i++) {
			if (TakeAssignmentPage.rankingOptions.get(i).getText().contains("Punjab")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswers2(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptions.get(i).getText().contains("Tamil")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswers5(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptions.get(i).getText().contains("Jammu")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswers1(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptions.get(i).getText().contains("Delhi")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswers3(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			} else if (TakeAssignmentPage.rankingOptions.get(i).getText().contains("Kolkata")) {
				clickObject(TakeAssignmentPage.selectOptionRanking(driver, i + 1), "Select First Rank");
				waiting(2);
				clickObjectUsingJSExecutor(TakeAssignmentPage.selectRankingAnswers4(driver, i + 1),
						"Select Fifth Option");
				waiting(2);
			}
		}
	}

	/*
	 * //===============================
	 * waitTillElementDisplayed(TakeAssignmentPage.selectOption(driver, 1),
	 * "Select Option", 10); clickObject(TakeAssignmentPage.selectOption(driver,
	 * 1), "Select First Rank"); waiting(2);
	 * clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber5,
	 * "Select Fifth Option"); waiting(2);
	 * clickObject(TakeAssignmentPage.selectOption(driver, 2),
	 * "Select Second Rank"); waiting(2);
	 * clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber4,
	 * "Select Fourth Option"); waiting(2);
	 * clickObject(TakeAssignmentPage.selectOption(driver, 3),
	 * "Select Third Rank"); waiting(2);
	 * clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber3,
	 * "Select First Option"); waiting(2);
	 * clickObject(TakeAssignmentPage.selectOption(driver, 4),
	 * "Select Fourth Rank"); waiting(2);
	 * clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumber2,
	 * "Select Third Option"); waiting(2);
	 * clickObject(TakeAssignmentPage.selectOption(driver, 5),
	 * "Select Fifth Rank"); waiting(2);
	 * clickObjectUsingJSExecutor(TakeAssignmentPage.selectOptionNumberss,
	 * "Select Second Option"); }
	 */

	/*public void fillInTheBlanks() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", 10);
		typeValue(TakeAssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", "Delhi");
	}*/

	public void fillInTheBlanks() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", 10);
		typeValue(TakeAssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", "Delhi");
	}
	
	public void random() throws Exception {
		/*waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", 10);
		String randomvalues = TakeAssignmentPage.randomVariable.getText();
		String randomvariable[] = randomvalues.split(" +");

		String firstpart = randomvariable[0];

		String secondpart = randomvariable[1];

		String firstValue[] = firstpart.split("\\*");

		String secondValue[] = secondpart.split("\\*");

		String firstNumber = firstValue[0];
		String secondNumber = firstValue[1].replaceAll("\\*", "");

		String thirdNumber = secondValue[0].replaceAll("\\+", "");
		String fourthNumber = secondValue[1].replaceAll("\\*", "");

		// String firstcharacter= firstValue[0];
		// int firstcharacter1 = firstValue[1].length()-1;

		// String secondcharacter= secondValue[0];
		// int secondcharacter1 = secondValue[1].length()-1;

		int firstpartMul = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
		int secondpartMul = Integer.parseInt(thirdNumber) * Integer.parseInt(fourthNumber);

		int finalCal = firstpartMul + secondpartMul;
		String cal = Integer.toString(finalCal);
		// waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswer,
		// "Fill in the Blanks",10);
		typeValue(TakeAssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", cal);*/
		waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", 10);
		String randomvalues = TakeAssignmentPage.randomVariable.getText();
		String randomvariable[] = randomvalues.split(" +");

		String firstpart = randomvariable[0];

		String secondpart = randomvariable[1];

		String firstValue[] = firstpart.split("\\*");

		String secondValue[] = secondpart.split("\\*");

		String firstNumber = firstValue[0];
		String secondNumber = firstValue[1].replaceAll("\\*", "");

		String thirdNumber = secondValue[0].replaceAll("\\+", "");
		String fourthNumber = secondValue[1].replaceAll("\\*", "");

		// String firstcharacter= firstValue[0];
		// int firstcharacter1 = firstValue[1].length()-1;

		// String secondcharacter= secondValue[0];
		// int secondcharacter1 = secondValue[1].length()-1;

		int firstpartMul = Integer.parseInt(firstNumber) * Integer.parseInt(secondNumber);
		int secondpartMul = Integer.parseInt(thirdNumber) * Integer.parseInt(fourthNumber);

		int finalCal = firstpartMul + secondpartMul;
		String cal = Integer.toString(finalCal);
		// waitTillElementDisplayed(TakeAssignmentPage.fillInTheBlanksAnswer,
		// "Fill in the Blanks",10);
		typeValue(TakeAssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", cal);
	}

	public void answerWorsheet() throws Exception {
		List<WebElement> questionsList = TakeAssignmentPage.worksheetAnswer;
		for (int i = 0; i <= (questionsList.size()) - 1; i++) {
			typeValue(TakeAssignmentPage.worksheetAnswer.get(i), "", "This is answer");
		}
		waiting(1);
		clickObject(TakeAssignmentPage.answerRdbtnWk,"Radio Button ");
		waiting(1);
		selectValueByIndexFromList(TakeAssignmentPage.answerSelectWk, "Worksheet Dropdown", 1);
		

	}

	public void essay() throws Exception {
		/*switchiFrame();
		clickObject(TakeAssignmentPage.essayAnswer, "Enter essay answer");
		typeValueUsingActionBuilder(TakeAssignmentPage.essayAnswer, "Instructor has to manually grade");
		switchToDefaultPage();
		waiting(2);*/
		try {
		waiting(5);
		switchiFrame();
		waitTillElementEnabled(TakeAssignmentPage.essayAnswer, "Enter essay answer", 15);
		clickObject(TakeAssignmentPage.essayAnswer, "Enter essay answer");
		waiting(1.5);
	//	typeValueUsingActionBuilder(TakeAssignmentPage.essayAnswer, "Instructor has to manually grade");
		clearNTypeValue(TakeAssignmentPage.essayAnswer, "Essay or Short Answer", "Instructor has to manually grade");
		switchToDefaultPage();
		waiting(2);
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer Essay or Short question", "true", "false");
		}
	}

	public void TrueOrFalse() throws Exception {
		try {
		waitTillElementDisplayed(TakeAssignmentPage.trueorfalseNew, "trueorfalse", 10);
		clickObject(TakeAssignmentPage.trueorfalseNew, "trueorfalse Answer");
		waiting(2);
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Could not answer True or False question", "true", "false");
		}
	}

	public void scoreQuestion() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.scoreTheQuestion, "Score Answer", 10);
		clickObject(TakeAssignmentPage.scoreTheQuestion, "Score Answer");
		waiting(2);
		/*clickObject(TakeAssignmentPage.continueAnyway, "Score Answer");
		waiting(2);*/

	}

	public void scoreQuestions() throws Exception {
		try {
			switchToDefaultPage();
			switchiFrame(2);
			waitTillElementDisplayed(TakeAssignmentPage.scoreAnswer, "Score Answer", 10);
			clickObject(TakeAssignmentPage.scoreAnswer, "Score Answer");
			waiting(2);
			clickObject(TakeAssignmentPage.YesScoreNow, "Score Answer");
			waiting(2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void nextQuestion() throws Exception {
		
		waiting(3);
		clickNextQuestion();
	}
	
	public void nextQuestionPAAM() throws Exception {
		
		waiting(3);
		clickNextQuestionPAAM();
	}

	public void previousQuestion() throws Exception {
		try {
			switchToDefaultPage();
			switchiFrame(2);
			waitTillElementDisplayed(TakeAssignmentPage.previous, "Previous Question", 10);
			clickObject(TakeAssignmentPage.previous, "Previous Question");
			waiting(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickCheckMyWork() throws Exception
	{
		clickObject(TakeAssignmentPage.cmwBtn,"Check My Work");
	}

	public void submitAssignment() throws Exception {
		waitTillElementDisplayed(TakeAssignmentPage.submit, "Submit", 10);
		clickObject(TakeAssignmentPage.submit, "Submit");
		waiting(3);
		clickObject(TakeAssignmentPage.confirmSubmitAss, "Confirm Submit Assignment");
		waitTillElementDisplayed(TakeAssignmentPage.viewResults, "View Results", 10);
		clickObject(TakeAssignmentPage.viewResults, "View Results");
		waiting(3);
	}

	public void takeQuestionCount() throws Exception {
		int count = 1;
		try {
			for (int i = 0; i < 7; i++) {
				waitTillElementDisplayed(TakeAssignmentPage.nextcheck, "Next	", 10);
				clickObject(TakeAssignmentPage.nextcheck, "Next	");
				count++;
			}
			System.out.println("Total Question Count is: " + count);
			//clickObject(TakeAssignmentPage.exit, "Exit Assignment");
			waiting(5);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clickQuestionMap() throws Exception
	{
		waitTillElementEnabled(TakeAssignmentPage.questionMap, "Question Map", 20);
		clickObject(TakeAssignmentPage.questionMap, "Question Map");
		waiting(2);
		
	}

	public void closeQuestionMap() throws Exception
	{
		waitTillElementEnabled(TakeAssignmentPage.closeQuestionMap, "Question Map", 20);
		clickObject(TakeAssignmentPage.closeQuestionMap, "Close Question Map");
		waiting(2);
		
	}
	public void verifyQuestionStatus() throws Exception {
		int intNumberOfQuestions = Integer.parseInt(CreateAssignData.strDTSelectQuestions);
		clickQuestionMap();
		waiting(2);
		for (int i = 1; i <= intNumberOfQuestions; i++) {
			try {
				
				if (!(TakeAssignmentPage.QuestionsinMap(driver, i).size()>0)) {
					objHTMLFunctions.ReportPassFail("There is no question status for question "+i, "True", "True");
					
					
				} else {
					String status=TakeAssignmentPage.QuestionsinMapText(driver, i).getAttribute("class");
					System.out.println("Question "+ i +" status Present and its " +status+" ------NOT EXPECTED");
					if(i==1 || i==3)
					{
						Assert.assertTrue(status.contains("skipped"));
					}else
					{
						Assert.assertTrue(status.contains("incomplete"));
					}
				}
			} catch(NoSuchElementException e)
			{
				return;
			}
		}
		clickObject(TakeAssignmentPage.closeQuestionMap, "Close Question Map");
	}
	
	public void verifyQuestionStatusAfterAnswer() throws Exception {
		int intNumberOfQuestions = Integer.parseInt(CreateAssignData.strDTSelectQuestions);
		clickQuestionMap();
		waiting(2);
		for (int i = 1; i <= intNumberOfQuestions; i++) {
			try {
				
				if (!(TakeAssignmentPage.QuestionsinMap(driver, i).size()>0)) {
					objHTMLFunctions.ReportPassFail("There is no question status for question "+i, "True", "True");
					
					
				} else {
					String status=TakeAssignmentPage.QuestionsinMapText(driver, i).getAttribute("class");
					System.out.println("Question "+ i +" status Present and its " +status);
					if(i==1 || i==3)
					{
						Assert.assertTrue(status.contains("skipped"));
					}else
					{
						Assert.assertTrue(status.contains("incomplete"));
					}
				}
			} catch(NoSuchElementException e)
			{
				return;
			}
		}
		clickObject(TakeAssignmentPage.closeQuestionMap, "Close Question Map");
	}
	
	
	public void checkStatusForQuestion(String expected,int questionNumber) throws Exception
	{
		waiting(5);
		String status=TakeAssignmentPage.QuestionsinMapText(driver, questionNumber).getAttribute("class");
		objHTMLFunctions.ReportPassFail(status, "True", "True");
		Assert.assertTrue( status.contains(expected));
		
		clickObject(TakeAssignmentPage.closeQuestionMap, "Close Question Map");
		waiting(2);
	}
	
	public void answerFewOptionsQuestionTwo() throws Exception{
		switchiFrame();
		waitTillElementDisplayed(TakeAssignmentPage.dropdownlistOne, "First Dropdown", 25);
		typeValue(TakeAssignmentPage.dropdownlistOne, "First Dropdown", "Change in cost");
		typeValue(TakeAssignmentPage.dropdownlistTwo, "First Dropdown", "Change in volume");
		switchToDefaultPage();
		switchiFrame(2);
		verifyQuestionStatusAfterAnswer();
	}
	
	public void deleteAnswersQuestionThreeAndCheckStatus() throws Exception
	{
		switchiFrame();
		waitTillElementDisplayed(TakeAssignmentPage.dropdownFiveQuesThree,"dropdownFiveQuesThree", 5);
		TakeAssignmentPage.dropdownFiveQuesThree.sendKeys(Keys.CONTROL + "a");
		TakeAssignmentPage.dropdownFiveQuesThree.sendKeys(Keys.DELETE);
		Thread.sleep(500L);
		
	}
	
	public void answerThirdQuestionDeletedPart() throws Exception
	{
		String questionText[]=TakeAssignmentPage.questionThreeText.getText().trim().split("\\$");
		String firstpart[]=questionText[1].split(" ");
		String FirstValue=firstpart[0];
		
		switchiFrame();
		waitTillElementDisplayed(TakeAssignmentPage.dropdownFiveQuesThree,"dropdownFiveQuesThree", 5);
		typeValue(TakeAssignmentPage.dropdownFiveQuesThree, "Fifth Dropdown", FirstValue);
		switchToDefaultPage();
		waiting(2);
		switchiFrame(2);
	}
	
	
	public void checkMyWorkValidation(String expected) throws Exception
	{
		switchiFrame();
		waitTillElementEnabled(TakeAssignmentPage.chechMyWorkStatus, "Check my Work Text", 25);
		String questionStatus=TakeAssignmentPage.chechMyWorkStatus.getText();
		objHTMLFunctions.ReportPassFail(questionStatus, "True", "True");
		Assert.assertTrue(questionStatus.contains(expected));
		switchToDefaultPage();
		
		waiting(1);
		switchiFrame(2);
		
		clickObject(TakeAssignmentPage.returnToQuestion,"Return to Question");
		clickQuestionMap() ;
		if(expected=="Answer is complete and correct.")
		{
		checkStatusForQuestion("answered",3);	
		}
		
	}
	
	//Q1
	public void answerFirstQuestion() throws Exception
	{
		//waitTillElementEnabled(TakeAssignmentPage.questionText, "Question", 10);
	//	String questionText[]=TakeAssignmentPage.questionText.getText().trim().split("\\$");
	//	String firstpart[]=questionText[1].split(" ");
	//	int FirstValue=Integer.parseInt(firstpart[0].replaceAll(",",""));
		
	//	String secondpart[]=questionText[2].split(" ");
	//	int secondValue=Integer.parseInt(secondpart[0].replaceAll(",",""));
	//	int thirdValue= secondpart.length-1;
	//	String percentage=secondpart[thirdValue];
	//
	//	int value=FirstValue+secondValue;
	//	String FinalValue= String.valueOf(value);
		waitTillElementEnabled(TakeAssignmentPage.questionText, "Question", 10);
		switchiFrame();
		typeValue(TakeAssignmentPage.dropdownlistTwo, "First Dropdown", "Fixed costs plus pretax income");
		typeValue(TakeAssignmentPage.dropdownlistThree, "third Dropdown", "Contribution margin ratio");
		typeValue(TakeAssignmentPage.inputBoxOne,"Input First Value", "205");
		typeValue(TakeAssignmentPage.inputBoxTwo,"Input Second Value", "25%");
		TakeAssignmentPage.inputBoxTwo.sendKeys(Keys.TAB);
		
	//	String FirstPartAuto[]=TakeAssignmentPage.inputBoxThree.getText().trim().split("\\$");
	//	String autoValue=FirstPartAuto[1];
	//	System.out.println(autoValue);
	//	clickObject(TakeAssignmentPage.inputBoxFour,"Input Box Fourth");
		typeValueUsingActionBuilder(TakeAssignmentPage.inputBoxFour, "205");
		
		typeValueUsingActionBuilder(TakeAssignmentPage.inputBoxFive,String.valueOf("205"));
		//TakeAssignmentPage.inputBoxFive.sendKeys(Keys.TAB);
		typeValueUsingActionBuilder(TakeAssignmentPage.inputBoxSix,String.valueOf("205"));
		//TakeAssignmentPage.inputBoxSix.sendKeys(Keys.TAB);
		
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		
	}

	//Q3
	public void answerThirdQuestion() throws Exception
	{
		/*String costOfSalesValue=TakeAssignmentPage.costOfSales.getText();
		String costOfSalesFullValue=TakeAssignmentPage.costOfSalesFull.getText();
		
		int changeInCost=Integer.parseInt(costOfSalesFullValue.replaceAll(",", ""))-Integer.parseInt(costOfSalesValue.replaceAll(",", ""));*/
		String questionText[]=TakeAssignmentPage.questionThreeText.getText().trim().split("\\$");
		String firstpart[]=questionText[1].split(" ");
		String FirstValue=firstpart[0];
		float FirstValueInt=Float.parseFloat(firstpart[0]);
		
		String secondpart[]=questionText[2].split(" ");
		String secondValue=secondpart[0];
		float secondValueInt=Float.parseFloat(secondpart[0]);
		
		switchiFrame();
		typeValue(TakeAssignmentPage.dropdownOneQuesThree, "First Dropdown", "Less");
		typeValue(TakeAssignmentPage.dropdownTwoQuesThree, "Second Dropdown", "Sales");
		typeValue(TakeAssignmentPage.dropdownThreeQuesThree, "Third Dropdown", "Variable cost");
		typeValue(TakeAssignmentPage.dropdownFiveQuesThree, "Fifth Dropdown", FirstValue);
		closeOptionalPopUp();
		typeValue(TakeAssignmentPage.dropdownFourQuesThree, "Fourth Dropdown", secondValue);
		closeOptionalPopUp();
		
		TakeAssignmentPage.dropdownFiveQuesThree.sendKeys(Keys.TAB);
		
	/*	String FirstPartAuto[]=TakeAssignmentPage.autoValue.getText().trim().split("\\$");
		String autoValue=FirstPartAuto[1];
		System.out.println(autoValue);*/
		float thirdValue=FirstValueInt-secondValueInt;
		typeValue(TakeAssignmentPage.dropdownTenQuesThree, "Tenth Dropdown",  String.valueOf(thirdValue));
		closeOptionalPopUp();
		typeValue(TakeAssignmentPage.dropdownSixQuesThree, "Sixth Dropdown", "Contribution margin per unit");
		
		typeValue(TakeAssignmentPage.dropdownSevenQuesThree, "Seventh Dropdown", "Selling price per unit");
		
		typeValue(TakeAssignmentPage.dropdownEightQuesThree, "Eighth Dropdown", String.valueOf(thirdValue));
		closeOptionalPopUp();
		typeValue(TakeAssignmentPage.dropdownNineQuesThree, "Ninth Dropdown", FirstValue);
		closeOptionalPopUp();
		TakeAssignmentPage.dropdownNineQuesThree.sendKeys(Keys.TAB);
	}
	public void closeOptionalPopUp() throws Exception
	{
		if(waitTillElementEnabled(TakeAssignmentPage.decimalPopup,"Pop up",3)){
			clickObject(TakeAssignmentPage.decimalPopupClose, "Decimal Pop Up Close");
		}
	}
	
	public void submitAndCancel() throws Exception
	{
		waitTillElementDisplayed(TakeAssignmentPage.submit, "Submit", 10);
		clickObject(TakeAssignmentPage.submit, "Submit");
		CancelSubmit();
		
	}
	
	//IP Q1
	public void answerQuestionOneIP() throws Exception{
		
		waiting(5);
		switchiFrame();
		clickObject(TakeAssignmentPage.startVideo, "Click Start button video");
/*		waiting(5);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		switchToFrame("//*[@class='external  ']", "Sub iFrame");
		switchToFrame("//*[@id='anotherIframe']", "Sub sub iFrame");
		driver.switchTo().frame("ScormContent");
		waitTillElementEnabled(TakeAssignmentPage.nextSlide, "Next Slide",10);
		clickObject(TakeAssignmentPage.nextSlide, "Next Slide");*/
		clickNextSlide(6);
		waiting(5);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		
	}
	
	public void visitFewSlidesOfQuestionOne() throws Exception{
		
		waiting(5);
		switchiFrame();
		clickObject(TakeAssignmentPage.startVideo, "Click Start button video");
		continueWithQuestion();
		clickNextSlide(2);
		waiting(5);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		
	}
	
	//Q2
	public void asnwerQuestionTwoIP() throws Exception
	{
		
		waiting(2);
		switchiFrame();
		clickObject(TakeAssignmentPage.startVideo, "Click Start button video");
		clickNextSlide(2);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
	}
	
	public void continueWithQuestion() throws Exception
	{

	/*	Robot robot = new Robot(); 
		waiting(2);
		robot.keyPress(KeyEvent.VK_ENTER);	
		robot.keyRelease(KeyEvent.VK_ENTER); */
		
		waiting(2);
	}
	public void NavigateAwayToNextQuestion() throws Exception
	{
	/*	Robot robot = new Robot(); 
		waiting(2);

		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyPress(KeyEvent.VK_ESCAPE); */
		waiting(2);
		
	}
	public void clickNextSlide(int totalSlides) throws Exception
	{
		for(int i=1;i<totalSlides;i++)
		{
			switchToDefaultPage();
			waiting(1);
			switchiFrame(2);
			waiting(1);
			switchToFrame("//*[@class='external  ']", "Sub iFrame");
			switchToFrame("//*[@id='anotherIframe']", "Sub sub iFrame");
			driver.switchTo().frame("ScormContent");
			waitTillElementEnabled(TakeAssignmentPage.nextSlide, "Next Slide",25);
			clickObject(TakeAssignmentPage.nextSlide, "Next Slide "+i);
			waiting(3);
		}
	}
	
	//MLG Q1
	public void answerquestionOneMLG() throws Exception
	{
		waiting(3);
		switchiFrame();
		waitTillElementEnabled(TakeAssignmentPage.mediaStartButton, "Play Button",25);
		clickObject(TakeAssignmentPage.mediaStartButton, "Play Button");
		checkStatusCommpletion("100");
		waiting(3);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		 
	}
	
	public void answerQuestionOneHalf() throws Exception
	{
		waiting(3);
		switchiFrame();
		clickObject(TakeAssignmentPage.mediaStartButton, "Play Button");
		checkStatusCommpletion("100");
		waiting(3);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		 
	}
	public void answerQuestionTwoHalf() throws Exception
	{
		waiting(3);
		switchiFrame();
		clickObject(TakeAssignmentPage.mediaStartButton, "Play Button");
		checkStatusCommpletion("5");
		clickObject(TakeAssignmentPage.mediaPauseButton, "Play Button");
		waiting(3);
		switchToDefaultPage();
		waiting(1);
		switchiFrame(2);
		waiting(1);
		 
	}
	public void checkStatusForQuestionTwo(int questionNumber) throws Exception
	{
		if (!(TakeAssignmentPage.QuestionsinMap(driver, questionNumber).size()>0)) {
			objHTMLFunctions.ReportPassFail("There is no question status for question "+questionNumber, "True", "True");
			
			
		} else {
			String status=TakeAssignmentPage.QuestionsinMapText(driver, questionNumber).getAttribute("class");
			System.out.println("Question "+ questionNumber +" status Present and its " +status+" ------NOT EXPECTED");
		}
		clickObject(TakeAssignmentPage.closeQuestionMap,"Close Question Map");
		waiting(2);
	}

	public void checkStatusCommpletion(String value) throws InterruptedException
	{
		waiting(5);
		String completionValue=TakeAssignmentPage.completionValue.getText();
		System.out.println("Current Completion status is "+completionValue);
		if(completionValue.equals(value)||completionValue.contains(value))
		{
			return;
		}else
		{
			checkStatusCommpletion(value);
		}
	}
	public void clickForceIcon() throws Exception
	{
		waiting(5);
		switchiFrame();
		clickObject(TakeAssignmentPage.forceIcon, "Force Icon");
		waiting(2);
		switchToDefaultPage();
		waiting(2);
		switchiFrame(2);
		waiting(2);
		switchToFrame("//*[@class='external  ']", "Sub iFrame");
	}
	//Q1 FBD
		public void answerFirstQuestionFBD() throws Exception
		{
			pageDown();
			clickForceIcon();
			
			//First Force
			selectForceAndAngle(TakeAssignmentPage.tensionD, TakeAssignmentPage.origin, "60","A");
			clickForceIcon();
			//Second Force
			selectForceAndAngle(TakeAssignmentPage.tensionC, TakeAssignmentPage.origin, "90","A");
			clickForceIcon();
			//Third Force
			selectForceAndAngle(TakeAssignmentPage.tensionB, TakeAssignmentPage.origin, "150","A");
			clickForceIcon();
			//Fourth Force
			selectForceAndAngle(TakeAssignmentPage.weightOfLoad, TakeAssignmentPage.origin, "270","A");
			
			
			
		}
		
		public void pageDown() throws AWTException
		{
			JavascriptExecutor jsx = (JavascriptExecutor)driver;
			jsx.executeScript("window.scrollBy(0,450)", "");
			
		}
		
		public void clickReset() throws Exception
		{
			waiting(5);
			switchiFrame();
			waitTillElementEnabled(TakeAssignmentPage.reset, "Reset", 25);
			clickObject(TakeAssignmentPage.reset, "Reset");
			waiting(1);
			continueWithQuestion();
			
			switchToDefaultPage();
			waiting(1);
			switchiFrame(2);
			waiting(2);
		
			
			
		}
		//Q2 FBD
		public void answerFewForcesQuestionFBD() throws Exception
		{
			pageDown();
			clickForceIcon();
			
			//First Force
			selectForceAndAngle(TakeAssignmentPage.tensionD, TakeAssignmentPage.origin, "60","A");
			clickForceIcon();
			//Second Force
			selectForceAndAngle(TakeAssignmentPage.tensionC, TakeAssignmentPage.origin, "90","A");

		}
		
		//Q5,6,7 Independent Multipart
		
		public void answerIndependantMultipartFBD() throws Exception
		{
			pageDown();
			clickForceIcon();
			
			//First Force
			selectForceAndAngle(TakeAssignmentPage.reactionC, TakeAssignmentPage.origin, "60","C");

		}
		
		public void selectForceAndAngle(WebElement force,WebElement origin,String angle,String originValue) throws Exception
		{
			
			clickObject(TakeAssignmentPage.forceName, "Force Name");
			waiting(1);
			clickObject(force, "Select Force");
			selectValueByTextFromList(origin, "Origin", originValue);
			waiting(3);
			clickObject(TakeAssignmentPage.awayForceModal, "Away Force");
			clearNTypeValue(TakeAssignmentPage.angle, "Angle", angle);
			clickObject(TakeAssignmentPage.tickArrow,"Tick/Save");
			waiting(3);
			switchToDefaultPage();
			waiting(2);
			switchiFrame(2);
			waiting(2);
			
		}
		
		//Highlighter Codes
		
		public void answerMultipart() throws Exception
		{
			waiting(5);
			switchiFrame();
			waitTillElementEnabled(TakeAssignmentPage.hightlightIndependant, "Waiting..", 10);
			clickObject(TakeAssignmentPage.hightlightIndependant, "Highlight First part");
			waiting(3);
			switchToDefaultPage();
			waiting(2);
			switchiFrame(2);
			waiting(2);
		}
		public void SaveNExitAssignment() throws Exception
		{
			waitTillElementEnabled(TakeAssignmentPage.saveNExit,"Save N Exit Assignment", 5);
			clickObject(TakeAssignmentPage.saveNExit,"Save N Exit Assignment");
		}

		public Boolean answerTimedAssignment() throws Exception {
			try {

				waitTillElementEnabled(TakeAssignmentPage.questionNavigatorStdPreview, "Question", 10);
				List<WebElement> questions = driver.findElements(By.xpath(".//*[@id='navbarSelect']/option"));
				for (int i = 1; i <= questions.size(); i++) {
					waitTillElementEnabled(TakeAssignmentPage.questionNavigatorStdPreview, "Question", 10);
					// Q1 Matching
					if (TakeAssignmentPage.questionTitles.getText().contains("Matching")) {
						waiting(2.5);
						answerMatchingQuestionNative();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("Ranking")) {
						// Q2 Ranking
						waiting(2.5);
						RankingAnswer();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("Fill")) {
						// Q3 fill in the blanks
						waiting(2.5);
						fillInTheBlanks();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("Short")) {

						// Q4 Essay
						waiting(2.5);
						essay();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("true ")) {

						// Q5 TrueOrFalse
						waiting(2.5);
						TrueOrFalse();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("Essay")) {

						// Q6 Short Answer
						waiting(2.5);
						essay();
						waiting(2.5);

					} else if (TakeAssignmentPage.questionTitles.getText().contains("Numeric ")) {

						// Q7 Random
						waiting(2.5);
						random();
						waiting(2.5);
					} else {
						waiting(2.5);
						answerWorsheet();
						waiting(2.5);
					}

					// scoreThisQuestionAndContinue();
					if (i != questions.size()) {
						clickNextQuestion();
					}
					// Save And Exit Assignment
				}
				SaveNExitAssignment();
				return Boolean.valueOf(true);
			} catch (Exception e) {
				this.objHTMLFunctions.reportPassFailToATU(
						"Unable to Answer properly in Timed Assignment . <br> Error message=>" + this.strErrorMsg,
						"true", "false");
			}
			return null;

		}
		public Boolean verfiyTimedMessage()
		{
			try{
				
				String TimedAssignment=CreateAssignData.strDTAssignmentTitle;
				
			//	selectAssignmenToTake(1);
				selectAssignmenToTakeByTitle();
				
				if(waitTillElementDisplayed(TakeAssignmentPage.timedMessage, "Timed message", 3))
				{
					String expectedText = "\""+TimedAssignment+"\""+ " has a time limit of 10 minutes. If you don't submit the assignment before the time limit, it will be submitted to the instructor automatically. The time begins once you click Start Assignment and can't be paused.";
					
					String actualText=TakeAssignmentPage.timedMessage.getText();
					
					verifyTextEquals(TakeAssignmentPage.timedMessage.getText(), expectedText, "Timed Message shown");
					clickObject(TakeAssignmentPage.startAssignmentStd,"Start Assignment");
					waitTillElementEnabled(TakeAssignmentPage.takeAssignmentStdPreview, "Question", 10);
					clickGoButton();
					return Boolean.valueOf(true);
				}
			}catch(Exception e)
			{
				System.out.checkError();
				return Boolean.valueOf(false);
			}
			return null;
		}
		
		public Boolean verifyAutoSubmit() throws Exception
		{
			try{
				selectAssignmentFromList();
			//	waitTillElementEnabled(TakeAssignmentPage.takeAssignmentStdPreview, "Question", 10);
			    waiting(3);
				if(waitTillElementDisplayed(TakeAssignmentPage.timedMessage, "Timed message", 2))
				{
					waitForTimedAssignmentToFinish();
					
					String TimedAssignment = CreateAssignData.strDTAssignmentTitle;	
					
					String expectedText = "You've exceeded the time limit for "+"\""+TimedAssignment+"\""+ ". Your work for this attempt has been automatically submitted to the instructor.";
					
					String actualText = TakeAssignmentPage.timedMessage.getText();
					
					verifyTextEquals(TakeAssignmentPage.timedMessage.getText(), expectedText, "Timed Message shown");
					clickObject(TakeAssignmentPage.resumeAssignmentStd,"Submit the Previous Attempt");
					waitTillElementEnabled(TakeAssignmentPage.takeAssignmentStdPreview, "Question", 10);
					clickGoButton();
					waiting(10);
				//	checkNAcceptAlert(5);
					waitTillElementEnabled(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment list", 10);
					this.objHTMLFunctions.reportPassFailToATU("Time Over!!!Assignment is Auto Submitted","true","true");
					System.out.println("Just before accepting alert**************");
					checkNAcceptAlert(5);
					System.out.println("Just after accept alert method*************");
					checkNAcceptAlert(5);
					checkNAcceptAlert(5);
					checkNAcceptAlert(5);
					checkNAcceptAlert(5);
					checkNAcceptAlert(5);
					return Boolean.valueOf(true);
				}
			}catch(Exception e)
			{
				System.out.checkError();
				this.objHTMLFunctions.reportPassFailToATU("Time Over!!!Assignment is not Automatically Submitted","true","true");
				return Boolean.valueOf(false);
			}
			return null;
		}
		
		//************added by sayan****************// start
		public void waitForTimedAssignmentToFinish()throws Exception
		{		
			//String assignmentsToGrade = "//span[contains(@class,'caret-right')]/span[text()='Assignments to grade']";
			try
			{
			//	boolean assignmentsToGradeEnabled = checkObjectExistsWOError(assignmentsToGrade,"assignmentsToGrade");
				for(int i=1; i<=10; i++)	{
					waitTillElementEnabled(TakeAssignmentPage.timedMessage, "Timed assignment resume message", 5);
					String actualText = TakeAssignmentPage.timedMessage.getText();
					if(actualText.toLowerCase().contains("exceeded")) {
						waiting(5);
						driver.navigate().refresh();
						waitTillElementDisplayed(TakeAssignmentPage.assignmentHeader, "Assignment Header List", 10);
						selectAssignmentFromList();
						waitTillElementEnabled(TakeAssignmentPage.timedMessage, "Timed assignment resume message", 5);
						break;
					}
					waiting(60);
					driver.navigate().refresh();
					System.out.println("Refresh attempt number for timed assignment : " + i);
				//	waiting(10);	
					waitTillElementDisplayed(TakeAssignmentPage.assignmentHeader, "Assignment Header List", 10);
					selectAssignmentFromList();
				//	waitTillElementDisplayed(TakeAssignmentPage.timedMessage, "Timed message", 2);
					
				//	assignmentsToGradeEnabled = checkObjectExistsWOError(assignmentsToGrade,"assignmentsToGrade");	
				//	if(assignmentsToGradeEnabled == true)
				//		break;
				}
				//TODO change assignmentsToGrade to WebElement
			}	
			catch(Exception objException)
				{
					ATUReports.add("Failed in executing dismiss waitForPastDue method in TakeAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
					objHTMLFunctions.ReportPassFail("Failed in executing waitForPastDue in TakeAssignmentController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
				}
		}
		//********************added by sayan*********************//end
		
		public void enterPassword() throws Exception
		{
			if(waitTillElementDisplayed(TakeAssignmentPage.enterPassword, "Password Field", 2))
			{
				clickObject(TakeAssignmentPage.enterPassword,"Password Field");
				clearNTypeValue(TakeAssignmentPage.enterPassword, "Enter Password", CreateAssignData.strDTPassword);
				clickObject(TakeAssignmentPage.submitPassword,"Submit Password");
			}
		}
		
		public void waitForClassicStdAssignmentTable(int waitTime) throws Exception {
			waitTillElementDisplayed(TakeAssignmentPage.stdAssignmentTableClassic, "Student Assignment Table Classic", waitTime);
		}
		
		public void takeMathMLAssignmentClassic() throws Exception {
			waiting(2.5);
			List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
			// select 1st question
			selectQuestionNumber(questionNavList, 1); //select the question number for answering
			waiting(3);
			answerAndVerifyFirstMathMLQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifySecondMathMLQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyThirdMathMLQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyFourthMathMLQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyFifthMathMLQuestion();
			
		}
		//1st mathml question answering
		public void answerAndVerifyFirstMathMLQuestion() throws Exception {
			String expectedText = "If you have 120 10 120 kg. of rice and you give 60 12 60 kg. "
					+ "of rice to your friend then how much rice will remain? (Note: Give only numeric answer)";
			System.out.println("fraction stem---");
			String actualText = getTextFromElement(TakeAssignmentPage.questionStem, "fraction stem");
			System.out.println(actualText);
			if(actualText.contains("\n"))
				System.out.println("new line found");
			else 
				System.out.println("new line not found");
		//	objHTMLFunctions.ReportPassFail(strStepCondition, strExpectedResult, strActualResult)
			verifyTextEquals(actualText, expectedText, "MathML question with fractions");
			clearNTypeValue(TakeAssignmentPage.mathMLnumericInput1, "numeric input 1st question", "7");
		}
		//2nd mathml question answering
		public void answerAndVerifySecondMathMLQuestion() throws Exception {
			String expectedText = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n"
					+ "  <mrow>\n"
					+ "    <mi mathvariant=\"normal\">&#x3A3;</mi>\n"
					+ "    <mo>(</mo>\n"
					+ "    <mi>X</mi>\n"
					+ "    <mo>&#x2212;</mo>\n"
					+ "    <mover>\n"
					+ "      <mrow>\n"
					+ "        <mi>X</mi>\n"
					+ "      </mrow>\n"
					+ "      <mrow>\n"
					+ "        <mo>&#xAF;</mo>\n"
					+ "      </mrow>\n"
					+ "    </mover>\n"
					+ "    <mo>)</mo>\n"
					+ "    <mo>=</mo>\n"
					+ "    <mn>0</mn>\n"
					+ "  </mrow>\n"
					+ "</math>";
			String expectedtext1 = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mrow><mi mathvariant=\"normal\">&#x3A3;</mi>"
					+ "<mo>(</mo><mi>X</mi><mo>&#x2212;</mo><mover><mrow><mi>X</mi></mrow><mrow><mo>&#xAF;</mo></mrow></mover><mo>)</mo>"
					+ "<mo>=</mo><mn>0</mn></mrow></math>";
			clearNTypeValue(TakeAssignmentPage.mathMLnumericInput2, "numeric input 2nd question", "4.2");
			selectValueByTextFromList(TakeAssignmentPage.wkTrueOrFalseList, "true false dropdown 2nd question", "True");
			String actualText = getAttributeFromElement(TakeAssignmentPage.mathMLExpression1, "mathml expression 2nd question", "data-mathml");
		//	verifyTextEquals(actualText, expectedText, "MathML Expression - conatining new line");
			verifyTextEquals(actualText, expectedtext1, "MathML Expression 2nd question - not conatining new line");
		}
		//3rd mathml question answering
		public void answerAndVerifyThirdMathMLQuestion() throws Exception {
			String expectedText = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><msub><mi>&#x3BC;</mi>"
					+ "<mtext>s</mtext></msub><mtext>&#xA0;=&#xA0;</mtext><mn>0</mn><mtext>.208</mtext></math>";
			selectRadioOrCheckBox(TakeAssignmentPage.radioInputThirdQuestion, "radio input 3rd question mathml", "ON");
			String actualText = getAttributeFromElement(TakeAssignmentPage.mathMLExpression2, "mathml expression 3rd question", "data-mathml");
			verifyTextEquals(actualText, expectedText, "MathML Expression 3rd question");
		}
		//4th mathml question answering
		public void answerAndVerifyFourthMathMLQuestion() throws Exception {
			String expectedText = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><msub><mi>&#x3BC;</mi><mtext>s</mtext></msub>"
					+ "<mtext>&#xA0;=&#xA0;</mtext><mn>0</mn><mtext>.200</mtext></math>";
			selectRadioOrCheckBox(TakeAssignmentPage.radioInputFourthQuestion, "radio input 3rd question mathml", "ON");
			String actualText = getAttributeFromElement(TakeAssignmentPage.mathMLExpression3, "mathml expression 4th question", "data-mathml");
			verifyTextEquals(actualText, expectedText, "MathML Expression 4th question");
		}
		//5th mathml question answering
		public void answerAndVerifyFifthMathMLQuestion() throws Exception {
			String actualText = getAttributeFromElement(TakeAssignmentPage.mathMLExpression1, "mathml expression 5th question", "data-mathml");
			String expectedText = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"><mrow><mover><mrow><mi>X</mi></mrow>"
					+ "<mrow><mo>&#x2212;</mo></mrow></mover></mrow></math>";
			verifyTextEquals(actualText, expectedText, "MathML Expression 5th question");
			selectRadioOrCheckBox(TakeAssignmentPage.radioInputFifthQuestion1, "radio input fifth question", "ON");
			waiting(1.5);
			clearNTypeValue(TakeAssignmentPage.mathMLNumericInputFifthQs1, "numeric qs fifth qs", "6.57");
			waiting(1.5);
			clearNTypeValue(TakeAssignmentPage.mathMLNumericInputFifthQs2, "numeric qs fifth qs", "3.50");
			waiting(1.5);
			
		}
		
		public List<String> takeWorldLanguageAssignmentClassic() throws Exception {
			waiting(2.5);
			List<WebElement> questionNavList =  selectQuestionNavStdAssignment();
			// select 1st question
			selectQuestionNumber(questionNavList, 1); //select the question number for answering
			waiting(5);
			List<String> expectedTextList = answerAndVerifyFirstAndSecondSectionBreakWorldLanguageQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyThirdWorldLanguageQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyFourthWorldLanguageQuestion();
			clickNextQuestion();
			waiting(2);
			waitForQuestionTitle();
			answerAndVerifyFifthWorldLanguageQuestion();
			waiting(2);
			questionNavList =  selectQuestionNavStdAssignment();
			selectQuestionNumber(questionNavList, 1); //select the question number for answering
			waiting(5);
			verifyWorldLangforeignCharQsnavigationRetention(expectedTextList);
			
			return expectedTextList;
		}
		
		public List<String> answerAndVerifyFirstAndSecondSectionBreakWorldLanguageQuestion() throws Exception {
		//	dragAndDrop(source, target);
		//	dragAndDropElements(objDragElement, objDropElement, strDragObjectName, strDropObjectName)
			waiting(3);
			switchiFrame();
			waitTillElementEnabled(TakeAssignmentPage.sourceDrag1, "source drag 1", 6);
			waiting(1);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDrag1, TakeAssignmentPage.targetDrop3, "drag object 1", "drop object 1");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDrag2, TakeAssignmentPage.targetDrop4, "drag object 2", "drop object 2");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDrag3, TakeAssignmentPage.targetDrop2, "drag object 3", "drop object 3");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDrag4, TakeAssignmentPage.targetDrop1, "drag object 4", "drop object 4");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDrag5, TakeAssignmentPage.targetDrop5, "drag object 5", "drop object 5");
			waiting(1.5);
			switchToDefaultPage();
			//clickig next button for section break question
			clickObject(TakeAssignmentPage.sectionBreakNextBtnClassic, "Section break next button");
			//1. 
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs1, "2nd world lang qs fib 1", 6);
			clearNTypeValue(TakeAssignmentPage.fibSecondQs1, "2nd world lang qs fib 1", "Allan");
			waiting(1.5);
			typeFromSpanishCharPalette();
			String expectedText1 = "Allanáéíóúüñ¡¿«»";
			String actualText1 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs1, "2nd world lang qs fib 1", "value");
			verifyTextEquals(actualText1, expectedText1, "spanish foreign character palette");
			clickObject(TakeAssignmentPage.paletteCloseBtn, "palette close button");
			waiting(1.5);
			//2. 
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs2, "2nd world lang qs fib 2", 5);
			clearNTypeValue(TakeAssignmentPage.fibSecondQs2, "2nd world lang qs fib 2", "Yenaro");
			waiting(1.5);
			typeFromSpanishCharPalette();
			String expectedText2 = "Yenaroáéíóúüñ¡¿«»";
			String actualText2 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs2, "2nd world lang qs fib 2", "value");
			verifyTextEquals(actualText2, expectedText2, "spanish foreign character palette");
			clickObject(TakeAssignmentPage.paletteCloseBtn, "palette close button");
			waiting(1.5);
			//3. 
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs3, "2nd world lang qs fib 3", 5);
			clearNTypeValue(TakeAssignmentPage.fibSecondQs3, "2nd world lang qs fib 3", "Zulay");
			waiting(1.5);
			typeFromSpanishCharPalette();
			String expectedText3 = "Zulayáéíóúüñ¡¿«»";
			String actualText3 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs3, "2nd world lang qs fib 3", "value");
			verifyTextEquals(actualText3, expectedText3, "spanish foreign character palette");
			clickObject(TakeAssignmentPage.paletteCloseBtn, "palette close button");
			waiting(1.5);
			//4. 
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs4, "2nd world lang qs fib 4", 5);
			clearNTypeValue(TakeAssignmentPage.fibSecondQs4, "2nd world lang qs fib 4", "Henry");
			waiting(1.5);
			typeFromSpanishCharPalette();
			String expectedText4 = "Henryáéíóúüñ¡¿«»";
			String actualText4 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs4, "2nd world lang qs fib 4", "value");
			verifyTextEquals(actualText4, expectedText4, "spanish foreign character palette");
			clickObject(TakeAssignmentPage.paletteCloseBtn, "palette close button");
			waiting(1.5);
			//5. 
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", 5);
			clearNTypeValue(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", "Alexander");
			waiting(1.5);
			typeFromSpanishCharPalette();
			String expectedText5 = "Alexanderáéíóúüñ¡¿«»";
			String actualText5 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", "value");
			verifyTextEquals(actualText5, expectedText5, "spanish foreign character palette");
			
			clickObject(TakeAssignmentPage.sectionBreakPrevBtnClassic, "section break previous button classic");
			waiting(2);
			clickObject(TakeAssignmentPage.sectionBreakNextBtnClassic, "section break next button classic");
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", 5);
			waiting(1.5);
			String actualText1_1 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs1, "2nd world lang qs fib 1", "value");
			String actualText1_2 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs2, "2nd world lang qs fib 2", "value");
			String actualText1_3 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs3, "2nd world lang qs fib 3", "value");
			String actualText1_4 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs4, "2nd world lang qs fib 4", "value");
			String actualText1_5 = getAttributeFromElement(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", "value");
			verifyTextEquals(actualText1_1, expectedText1, "spanish foreign character palette");
			verifyTextEquals(actualText1_2, expectedText2, "spanish foreign character palette");
			verifyTextEquals(actualText1_3, expectedText3, "spanish foreign character palette");
			verifyTextEquals(actualText1_4, expectedText4, "spanish foreign character palette");
			verifyTextEquals(actualText1_5, expectedText5, "spanish foreign character palette");
			
			List<String> expectedTextList = new ArrayList<>();
			expectedTextList.add(expectedText1);
			expectedTextList.add(expectedText2);
			expectedTextList.add(expectedText3);
			expectedTextList.add(expectedText4);
			expectedTextList.add(expectedText5);
			
			return expectedTextList;
		}

		public void answerAndVerifyThirdWorldLanguageQuestion() throws Exception {
			waiting(2);
			switchiFrame();
			waitTillElementEnabled(TakeAssignmentPage.fibThirdQs1, "third world question fib 1", 5);
			clearNTypeValue(TakeAssignmentPage.fibThirdQs1, "third world question fib 1", "bolígrafo");
			waiting(1);
			clearNTypeValue(TakeAssignmentPage.fibThirdQs2, "third world question fib 2", "lápiz");
			waiting(1);
			clearNTypeValue(TakeAssignmentPage.fibThirdQs3, "third world question fib 3", "mochila");
			waiting(1);
			clearNTypeValue(TakeAssignmentPage.fibThirdQs4, "third world question fib 4", "hoja");
			waiting(1);
			clearNTypeValue(TakeAssignmentPage.fibThirdQs5, "third world question fib 5", "computadora");
			waiting(2);
			
			switchToDefaultPage();
			//drag and drop
		/*	List<WebElement> dropElements = TakeAssignmentPage.thirdQsDropElementsList(this.driver);
		//	System.out.println(dropElements.size() + "------------------");
		//	switchiFrame();
			waiting(1);
			dragAndDrop(TakeAssignmentPage.sourceDragThirdQs1, dropElements.get(0));
		//	dragAndDropElements(TakeAssignmentPage.sourceDragThirdQs1, dropElements.get(0), "drag object 1", "drop object 1");
		//	dragHoldAndDropElements(TakeAssignmentPage.sourceDragThirdQs1, dropElements.get(0), "drag object 1", "drop object 1");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDragThirdQs2, dropElements.get(1), "drag object 2", "drop object 2");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDragThirdQs3, dropElements.get(2), "drag object 3", "drop object 3");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDragThirdQs4, dropElements.get(3), "drag object 4", "drop object 4");
			waiting(1.5);
			dragHoldAndDropElements(TakeAssignmentPage.sourceDragThirdQs5, dropElements.get(4), "drag object 5", "drop object 5");
			waiting(1.5);	*/
		}

		public void answerAndVerifyFourthWorldLanguageQuestion() throws Exception {
			waiting(4);
			List<WebElement> radioInputList = TakeAssignmentPage.wkRadioInputFourthQsList(this.driver);
			selectRadioOrCheckBox(radioInputList.get(1), "Radio input", "ON");
			waiting(1);
			selectRadioOrCheckBox(radioInputList.get(3), "Radio input", "ON");
			waiting(1);
			selectRadioOrCheckBox(radioInputList.get(5), "Radio input", "ON");
			waiting(1);
			selectRadioOrCheckBox(radioInputList.get(6), "Radio input", "ON");
			waiting(1);
			selectRadioOrCheckBox(radioInputList.get(8), "Radio input", "ON");
			waiting(1);
			selectRadioOrCheckBox(radioInputList.get(11), "Radio input", "ON");
		}

		public void answerAndVerifyFifthWorldLanguageQuestion() throws Exception {
			
		}
		
		public void verifyWorldLangforeignCharQsnavigationRetention(List<String> expectedTextList) throws Exception {
			List<String> actualTextList = new ArrayList<String>();
			String actualText = "";
			clickObject(TakeAssignmentPage.sectionBreakNextBtnClassic, "Section break next button");
			
			waitTillElementEnabled(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", 6);
			actualTextList.add(getAttributeFromElement(TakeAssignmentPage.fibSecondQs1, "2nd world lang qs fib 1", "value"));
			actualTextList.add(getAttributeFromElement(TakeAssignmentPage.fibSecondQs2, "2nd world lang qs fib 2", "value"));
			actualTextList.add(getAttributeFromElement(TakeAssignmentPage.fibSecondQs3, "2nd world lang qs fib 3", "value"));
			actualTextList.add(getAttributeFromElement(TakeAssignmentPage.fibSecondQs4, "2nd world lang qs fib 4", "value"));
			actualTextList.add(getAttributeFromElement(TakeAssignmentPage.fibSecondQs5, "2nd world lang qs fib 5", "value"));
			
			int i = 0;
			for(String expectedText: expectedTextList) {
				actualText = actualTextList.get(i++);
				verifyTextEquals(actualText, expectedText, "spanish foreign character palette");
			}
			
		}
		
		public void verifyMathMLDetailedFeedback() throws Exception {
			waitTillElementEnabled(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment List", 10);
			
		/*	String strScore = TakeAssignmentPage.subReportAutoGraded.getText();
			checkObjectExists(TakeAssignmentPage.subReportAutoGraded,
					"Points earned on auto-graded questions: " + strScore);
			
			strScore = TakeAssignmentPage.subReportInstructorGraded.getText();
			checkObjectExists(TakeAssignmentPage.subReportInstructorGraded,
					"Points you may earn on instructor-graded questions: " + strScore);
			
			strScore = TakeAssignmentPage.totalScore.getText();
			checkObjectExists(TakeAssignmentPage.totalScore, "Total Score: " + strScore);	*/
			StringBuilder sb = new StringBuilder(TakeAssignmentPage.reportScore.getText());
			String strActualScore = sb.toString().split("/")[0];
			String strExpectedScore = "47.50";
			checkObjectExists(TakeAssignmentPage.reportScore, "Total Score: " + strActualScore);
			if(strActualScore.equals("47.50"))
				objHTMLFunctions.ReportPassFail("MathML obtained score: Expected and actual score matched", strExpectedScore, strActualScore);
			else
				objHTMLFunctions.ReportPassFail("MathML obtained score: Expected and actual score not matched", strExpectedScore, strActualScore);
			
		}
		
		public void verifyWorldLanguageDetailedFeedback(List<String> expectedTextList) throws Exception {
			waitTillElementEnabled(TakeAssignmentPage.returnToAssignmentList, "Return to Assignment List", 10);
			waiting(3);
			List<WebElement> wkWorldLangFibPSVList = TakeAssignmentPage.wkWorldLangFibPSVList(this.driver);
			String actualText = "";
			int i = 0;
			
			for(WebElement element: wkWorldLangFibPSVList) {
				actualText = getTextFromElement(element, "work sheet WorldLangFibPSV " + (i+1));
				verifyTextEquals(actualText, expectedTextList.get(i++), "World Language FIB Worksheet PSV answer: " + (i));
			}
		}
		
		public void typeFromSpanishCharPalette() throws Exception {
			List<WebElement> spanishCharListElements = TakeAssignmentPage.spanishPaletteCharactersElementList(this.driver);
			int i = 0;
			for(WebElement element: spanishCharListElements) {
				clickObject(element, "Spanish char " + (i+1));
				i++;
				waiting(0.25);
			}
		}
		
		public void validateUnsupportedContentClassic() throws Exception {
			waitTillElementEnabled(TakeAssignmentPage.unsupportedContentClassicModalCloseBtn, "Unsupported Content Classic Modal Close Button", 10);
			waiting( 1 );
			String expectedText = "You have encountered an assignment which is not supported. We have notified your instructor to correct the situation.";
			String actualText = getTextFromElement(TakeAssignmentPage.unsupportedContentClassicModalText, "Unsupported Content Classic Modal Text");
			StringBuilder sbd = new StringBuilder(actualText);
			StringBuffer sbf = new StringBuffer(actualText);
			String actualTextTrimmed = sbd.toString().trim();
			
			verifyTextEquals(actualTextTrimmed, expectedText, "Unsupported content classic message");
			
			clickObject(TakeAssignmentPage.unsupportedContentClassicModalCloseBtn, "Unsupported Content Classic Modal Close Button");
		}

		
	}


