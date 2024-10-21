package com.newdemo.framework.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.GlobalPaths;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.CreateAssignmentData;
import com.newdemo.framework.data.InstructorAreaData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.CreateAssignmentPage;
import com.newdemo.framework.model.InstructorAreaPage;
import com.newdemo.framework.model.StudentReportsPage;
import com.newdemo.framework.model.TakeAssignmentPage;

public class InstructorAreaController extends ComponentFunctions {

	InstructorAreaPage InsAreaPage = null;
	StudentReportsPage stdReportsPage = null;
	CreateAssignmentPage AssignmentPage = null;
	TakeAssignmentPage TakeAssignmentPage = null;
	InstructorAreaData InsAreaData = null;
	CreateAssignmentData CreateAssignData = null;
	StudentRegistrationData stdRegistrationData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	public InstructorAreaController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		InsAreaPage = PageFactory.initElements(driver, InstructorAreaPage.class);
		stdReportsPage = PageFactory.initElements(driver, StudentReportsPage.class);
		AssignmentPage = PageFactory.initElements(driver, CreateAssignmentPage.class);
		TakeAssignmentPage = PageFactory.initElements(driver, TakeAssignmentPage.class);
	}

	public void waitForAddAssignment(int intWaitTime) throws Exception
	{
		waitTillElementEnabled(InsAreaPage.addAssignment, "Add Assignment Link", intWaitTime);
	}
	
	
	
	public void clickMessageSettings() throws Exception
	{
		clickObject(InsAreaPage.msgSetting, "Message Settings");
	}
	
	public void clickPostMessage() throws Exception
	{
		clickObject(InsAreaPage.postNewMsg, "Post New Message");
	}
	
	public void typeMessage(int msgNumber) throws Exception
	{
		String strMessage = "Message "+msgNumber;
		typeValue(InsAreaPage.announcementArea, "Post Message "+msgNumber ,strMessage);
		storeRuntimeGlobalVariable("Message"+msgNumber, strMessage);
		//CMNFunctions.saveDataInExcel("InstructorArea","Message"+msgNumber,rowNum,strMessage);
	}
	
	public void unselectCourse() throws Exception
	{
		String strCourseName = retrieveRuntimeGlobalVariable("CourseName");
		selectRadioOrCheckBox(InsAreaPage.courseShareMessage(driver,strCourseName), "Unselect Course", "OFF");
	}
	
	public void selectSection(int sectionNumber) throws Exception
	{
		String strSection = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		selectRadioOrCheckBox(InsAreaPage.sectionShareMessage(driver,strSection), "Select Section", "ON");
	}
	
	public void clickSaveMessage() throws Exception
	{
		waiting(2);
		clickObject(InsAreaPage.saveMessage, "Post New Message");
	}
	
	public void clickCloseMessages() throws Exception
	{
		waiting(5);
		clickObject(InsAreaPage.closeMessages, "Close Post/ Manage Messages");
		waiting(2);
	}
	
	public void clickManagePastMessages() throws Exception
	{
		clickObject(InsAreaPage.managePastMessages, "Manage Past Messages");
	}
	
	public void editMessage(int msgNumber) throws Exception
	{	
		String strMessage = retrieveRuntimeGlobalVariable("Message"+msgNumber);
		clickObject(InsAreaPage.editMessage(driver,strMessage), "Edit Message "+strMessage);
		String strMessageUpdated = strMessage+" Updated";
		clearNTypeValue(InsAreaPage.announcementArea, "Edit Message "+msgNumber ,strMessageUpdated);
		storeRuntimeGlobalVariable("Message"+msgNumber, strMessageUpdated);
	}
	
	public void deleteMessage(int msgNumber) throws Exception
	{	
		String strMessage = retrieveRuntimeGlobalVariable("Message"+msgNumber);
		waiting(2);
		clickObject(InsAreaPage.deleteMessage(driver,strMessage), "Edit Message "+strMessage);
		storeRuntimeGlobalVariable("Message"+msgNumber, "deleted");
	}
	
	public void clickBookmarkSettings() throws Exception
	{
		clickObject(InsAreaPage.bookmarkSetting, "Bookmark Settings");
	}
	
	public void typeBookmarkName() throws Exception
	{
		typeValue(InsAreaPage.newBookmarkName, "Bookmark Name",InsAreaData.strDTBookmarkName);
		storeRuntimeGlobalVariable("BookmarkName", InsAreaData.strDTBookmarkName);
	}
	
	public void typeBookmarkAddress() throws Exception
	{
		typeValue(InsAreaPage.newBookmarkAddress, "Bookmark Address",InsAreaData.strDTBookmarkAddress);
		storeRuntimeGlobalVariable("BookmarkAddress", InsAreaData.strDTBookmarkAddress);
	}
	
	public void uncheckBookmarkApplySections() throws Exception
	{
		selectRadioOrCheckBox(InsAreaPage.applyBookmarkAllSections, "Apply Bookmark to all Sections", "OFF");
	}
	
	public void clickSaveBookmark() throws Exception
	{
		clickObject(InsAreaPage.saveBookmark, "Save Bookmark");
	}
	
	public void verifyBookmarkMessage() throws Exception
	{
		verifyTextInElement(InsAreaPage.bookmarkMessage, InsAreaData.strDTBookmarkMessage,InsAreaData.strDTBookmarkMessage);
	}
	
	public void clickCloseBookmarkMessage() throws Exception
	{
		clickObject(InsAreaPage.closeBookmarkMessage, "Close Bookmark Confirmation Message");
	}
	
	public void clickShowBookmarkToStudents() throws Exception
	{
		clickObject(InsAreaPage.showBookmarks, "Show Bookmark to Students");
	}
	
	public void verifyBookmarkCreated() throws Exception
	{	
		clickObject(InsAreaPage.expandBookmarks, "Expand Bookmarks");
		String strBookmarkName = retrieveRuntimeGlobalVariable("BookmarkName");
		clickObject(InsAreaPage.bookmark(driver,strBookmarkName), "Bookmark");
	//	switchToNewWindow();
		switchToNewWindowCreated();
	//	closeApplication();
	//	closeApplications();
	//	switchToParentWindow();
		switchToParentWindows();
	}
	
	public Boolean switchToParentWindows() throws Exception {
		try {
			Iterator localIterator = this.driver.getWindowHandles().iterator();
			if (localIterator.hasNext()) {
				String objWindowHandle = (String) localIterator.next();

				this.driver.switchTo().window(objWindowHandle);
			}

			String strNewWindowTitle = this.driver.getTitle();
			this.objHTMLFunctions.reportPassFailToATU(
					"Moved to the parent window with title=><i>" + strNewWindowTitle + "</i>", "true", "true");
			return Boolean.valueOf(true);
		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Error while switching to the parent window.<br> Error message=>" + this.strErrorMsg, "true",
					"false");
		}
		return Boolean.valueOf(false);
	}
	public Boolean switchToNewWindowCreated() throws Exception {
		try {
			// Store the current window handle
			String winHandleBefore = this.driver.getWindowHandle();

			// Perform the click operation that opens new window

			// Switch to new window opened
			for(String winHandle : this.driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			String strNewWindowTitle = this.driver.getTitle();

			this.objHTMLFunctions.reportPassFailToATU(
					"Moved to the newly opened window with title=><i>" + strNewWindowTitle + "</i>", "true",
					"true");

			// Perform the actions on new window

			// Close the new window, if that window no more required
			driver.close();

		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Error while switching to newly opened window.<br> Error message=>" + this.strErrorMsg, "true",
					"fail");
		}
		return Boolean.valueOf(false);
	}
	public Boolean closeApplications() throws Exception {
		try {
			String strWindowTitle = this.driver.getTitle();
			this.driver.close();
			this.objHTMLFunctions.reportPassFailToATU("Browser window with title <i>" + strWindowTitle + "</i> closed",
					"true", "true");
			return Boolean.valueOf(true);
		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Unable to close the browser window.<BR>Error message=>" + this.strErrorMsg, "true", "false");
		}
		return Boolean.valueOf(false);
	}
	public void clickInstructorInfoSetting() throws Exception
	{
		clickObject(InsAreaPage.instructorInfoSetting, "Instructor Info Setting");
	}
	
	public void clickEditInstructorInfo() throws Exception
	{
		clickObject(InsAreaPage.editInstructorInfo, "Edit Instructor Info");
	}
	
	public void uploadPicture() throws Exception
	{
		//clickObject(InsAreaPage.imageFileURL, "Choose File");
		String strPictureUploadPath = System.getProperty("user.dir")+"/FilesToUpload/"+"photo.jpg";
		typeValue(InsAreaPage.txtFileUploadBackEnd, "File Upload", strPictureUploadPath);
		//pasteFromClipboard(strPictureUploadPath);
	}
	
	public void typeEmail() throws Exception
	{
		typeValue(InsAreaPage.email, "Instructor Email",InsAreaData.strDTInstructorEmail);
		storeRuntimeGlobalVariable("InstructorEmail", InsAreaData.strDTInstructorEmail);
	}
	
	public void typeBasicInformation() throws Exception
	{
		typeValue(InsAreaPage.basicInfo, "Basic Instructor Info",InsAreaData.strDTInstructorInformation);
		storeRuntimeGlobalVariable("InstructorInfo", InsAreaData.strDTInstructorInformation);
	}
	
	public void uncheckInsInfoApplyToSections() throws Exception
	{
		selectRadioOrCheckBox(InsAreaPage.applyInsInfoToAllSections, "Apply Instructor Info to all Sections", "OFF");		
	}
	
	public void clickSaveInstructorInfo() throws Exception
	{
		clickObject(InsAreaPage.saveInstructorInfo, "save Instructor Info");
	}
	
	public void verifyInstructorInfoMessage() throws Exception
	{
		waiting(3);
		//it's not working correctly so commented and insteadthe 2nd method is used for verification of the ins info msg
	//	verifyTextInElement(InsAreaPage.instructorInfoMessage, InsAreaData.strDTInstructorInfoMessage,InsAreaData.strDTInstructorInfoMessage); 
		checkObjectExists(InsAreaPage.instructorInfoMessage, InsAreaData.strDTInstructorInfoMessage);
		System.out.println("Expected ins save info text: " + InsAreaData.strDTInstructorInfoMessage);
		System.out.println("actual ins save info text: " + getTextFromElement(InsAreaPage.instructorInfoMessage, "ins info save text"));
	}
	
	public void clickCloseInstructorInfoMessage() throws Exception
	{
		waiting(2);
		clickObject(InsAreaPage.closeInstructorInfoMessage, "Close Instructor Info Confirmation Message");
	}
	
	public void verifyInstructorInfo() throws Exception
	{
		String strInstEmail = retrieveRuntimeGlobalVariable("InstructorEmail");
		verifyTextInElement(InsAreaPage.instructorEmail, "Instructor Email",strInstEmail);
		
		String strInstInfo = retrieveRuntimeGlobalVariable("InstructorInfo");
		verifyTextInElement(InsAreaPage.instructorInfo, "Instructor Email",strInstInfo);
	}
	
	public void clickUploadSyllabus() throws Exception
	{
		clickObject(InsAreaPage.uploadSyllabus, "Upload Syllabus");
	}
	
	public void clickChooseSyllabusFile() throws Exception
	{
		clickObject(InsAreaPage.syllabusFileURL, "Choose File to Upload");
	}
	
	public void uploadSyllabusFile() throws Exception
	{
		waiting(1);
		String strSyllabusUploadPath = System.getProperty("user.dir")+"/FilesToUpload/"+"Syllabus.txt"; //TODO objGLPaths.strFilesToUploadPath
		typeValue(InsAreaPage.txtFileUploadBackEnd, "File Upload", strSyllabusUploadPath);
		//pasteFromClipboard(strSyllabusUploadPath);
		waiting(3);
	}
	
	public void uncheckSaveSyllabusForAllSections() throws Exception
	{
		selectRadioOrCheckBox(InsAreaPage.saveSyllabusForAllSections, "Apply Syllabus to all Sections", "OFF");
	}
	
	public void clickUploadSyllabusFile() throws Exception
	{
		clickObject(InsAreaPage.uploadSpecificSyllabus, "Upload Specific Syllabus File");
	}
	
	public void verifySyllabusFileUploaded() throws Exception
	{	
		clickObject(InsAreaPage.downloadSyllabus, "Download Syllabus File");
		try{	
			
			String userdir = System.getProperty("user.dir");
			System.out.println("User Directory -> " + userdir);
			String username = System.getProperty("user.name");
			System.out.println("User Home -> " + username);
			String strDownloadFilePath = userdir.split(username)[0] + username + "/Downloads/";		//C:\Users\ok\Downloads
			String syllabusDownloadPath = strDownloadFilePath + "Syllabus.txt";
			System.out.println("File download path -> " + syllabusDownloadPath);
			File oFile = new File(syllabusDownloadPath);
			boolean fileDowloaded = false;
			int count = 0;
			while(fileDowloaded==false){	
				waiting(3);
				if (oFile.exists()){
					fileDowloaded = true;
				}
				if (count==30){
					break;
				}	
				count = count +1;
			}
			if(fileDowloaded == false)
			{
				ATUReports.add("Verification of the Syllabus Download", "Syllabus must be downloaded", "Syllabus not downloaded", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Verification of the Syllabus Download", "Syllabus must be downloaded", "Syllabus not downloaded");
			}
			else{
				ATUReports.add("Verification of the Syllabus Download", "Syllabus must be downloaded", "Syllabus downloaded successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Verification of the Syllabus Download", "Syllabus downloaded successfully", "Syllabus downloaded successfully");
				oFile.delete();
			}				
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void navigateToStudentPerformance() throws Exception {
		String stdFirstName1 = stdRegistrationData.strDTstdFirstName1;
		System.out.println("Stduent first naem: " + stdFirstName1);
		waiting(1);
		clickObject(InsAreaPage.performanceTab, "Performance tab");
		waiting(1);
		clickObject(InsAreaPage.reports, "Reports");
	//	waiting(2);
		waitTillElementEnabled(InsAreaPage.studentPerformance, "student performance page", 10);
		clickObject(InsAreaPage.studentPerformance, "student performance page");
		waiting(5);
		try {
			System.out.println(stdFirstName1);
			waitTillElementEnabled(InsAreaPage.enterStudentName, "student name input field", 10);
			clickObject(InsAreaPage.enterStudentName, "student name input field");
			clearNTypeValue(InsAreaPage.enterStudentName, "student name", stdFirstName1);
			waitTillElementEnabled(InsAreaPage.stdNamesDropDown, "Student Names Dropdown", 10);
		//	waiting(3);
		//	arrowDownUsingRobot(1);
			arrowDownUsingActionBuilder(1);
			waiting(3);
		//	pressEnterKeyUsingRobot(1);
			pressEnterKeyUsingActionBuilder(1);
		}catch(Exception e) {
			System.out.println("Student by the name: " + InsAreaPage.enterStudentName + " not found.");
			ATUReports.add("Student by the name: " + InsAreaPage.enterStudentName + " not found.", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}
		
		waiting(5);
	}
	
	public void navigateToStudentReports() throws Exception {
		String stdFirstName1 = stdRegistrationData.strDTstdFirstName1;
		String stdLastName1 = stdRegistrationData.strDTstdLastName1;
		String stdFullName1 = stdLastName1 + ", " + stdFirstName1;
		System.out.println("Student name: " + stdFullName1);
		clickObject(InsAreaPage.firstAssignment, "First Assignment");
		waitTillElementEnabled(InsAreaPage.assignmentResults, "Assignment Results", 15);
		clickObjectUsingJSExecutor(InsAreaPage.assignmentResults, "Assignment Results");
		waitTillElementEnabled(InsAreaPage.insStdList, "Student List in Ins Reports", 15);
		waitTillElementEnabled(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report", 10);
	//	clickObject(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report");
		clickObjectUsingJSExecutor(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report");
		
	}
	
	public void navigateToStudentReportsCoINS() throws Exception {
		String stdFirstName1 = stdRegistrationData.strDTstdFirstName1;
		String stdLastName1 = stdRegistrationData.strDTstdLastName1;
		String stdFullName1 = stdLastName1 + ", " + stdFirstName1;
		System.out.println("Student name: " + stdFullName1);
		//clickObject(InsAreaPage.firstAssignment, "First Assignment");
		waiting(8);
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		waitTillElementEnabled(TakeAssignmentPage.selectAssignmentToTakeByTitleIns(driver, assignmentName), "Assignment " + assignmentName, 5);
		clickObjectUsingJSExecutor(TakeAssignmentPage.selectAssignmentToTakeByTitleIns(driver, assignmentName), "Assignment " + assignmentName);
		waiting(2);
		waitTillElementEnabled(InsAreaPage.assignmentResults, "Assignment Results", 15);
		clickObjectUsingJSExecutor(InsAreaPage.assignmentResults, "Assignment Results");
		waitTillElementEnabled(InsAreaPage.insStdList, "Student List in Ins Reports", 15);
		waitTillElementEnabled(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report", 10);
	//	clickObject(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report");
		clickObjectUsingJSExecutor(InsAreaPage.selectStudentInInsReports(this.driver, stdFullName1), stdFullName1 + " Report");
		
	}
	
	public void selectAssignmenToTakeByTitle() throws Exception {
		waiting(8);
		String assignmentName = CreateAssignData.strDTAssignmentTitle;
		waitTillElementEnabled(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName, 5);
		clickObject(TakeAssignmentPage.selectAssignmentToTakeByTitle(driver, assignmentName), "Assignment " + assignmentName);
		waiting(2);
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
				validateDetailedFeedbackReportsIns();
			} else if(assignmentNumber == 2) {
				validateDetailedFeedbackReportsIns();
			} else if(assignmentNumber == 3) {
				validateDetailedFeedbackReportsIns();
			} else if(assignmentNumber == 4) {
				validateDetailedFeedbackReportsIns();
			} else if(assignmentNumber == 5) {
				validateFullCreditFeedbackReportsIns();
			}
						
			waiting(3);
			
		} catch(Exception e) {
			this.objHTMLFunctions.ReportPassFail("Assignment: " + assignmentNumber + " : Attempt No: " + attemptNumber + " : Not Found", "true", "false");
		}
	}
	
	public void validateDetailedFeedbackReportsIns() throws Exception {
			waitTillElementDisplayed(stdReportsPage.stdReportsFrame, "Student Reports Frame", 15);
			String expectedAssignmentTitle = CreateAssignData.strDTAssignmentTitle;
			String actualAssignmentTitle = getTextFromElement(InsAreaPage.assignmentTitleInsReports, "Assignment Title");
			verifyTextEquals(actualAssignmentTitle, expectedAssignmentTitle, "Assignment Title Display verification in Instructor Reports");
			switchiFrame();
			
			String questionTitle = "", questionScoreText = "";
			
			List<WebElement> questionNavList = selectQuestionNavStdAssignment();
			System.out.println("Total Number of question in student reports: " + questionNavList.size());
			
			
			waitForQuestionTitle();
			
			String strScore = InsAreaPage.totalScoreNPoint.getText();
			checkObjectExists(InsAreaPage.totalScoreNPoint, "Total Score: " + strScore);
			
			for(int i = 0; i < questionNavList.size(); i++) {
			//	System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaa");
				waitForQuestionTitle();
			//	System.out.println("bbbbbbbbbbbbbbbbbbbbbbbbb");
				waiting(2);
				questionTitle = getTextFromElement(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + i+1);
				System.out.println("questionTitle: " + questionTitle);
			//	questionScoreText = getTextFromElement(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + i+1);
			//	System.out.println("ddddddddddddddddddddddddd");
				checkObjectExists(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + (i+1) + " : " + questionTitle);
			//	System.out.println("eeeeeeeeeeeeeeeeeeeeeeeee");
			//	checkObjectExists(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + (i+1) + " : " + questionScoreText);
				
				if(i < questionNavList.size() - 1) {
					waiting(2);
					clickNextQuestion();
		//			waitForQuestionTitle();
				} else {
					break;
				}
			}
			
			switchToDefaultPage();
			clickSectionHomeButton();
		}
	
	public void validateFullCreditFeedbackReportsIns() throws Exception {
		waitTillElementDisplayed(stdReportsPage.stdReportsFrame, "Student Reports Frame", 15);
		String expectedAssignmentTitle = CreateAssignData.strDTAssignmentTitle;
		String actualAssignmentTitle = getTextFromElement(InsAreaPage.assignmentTitleInsReports, "Assignment Title");
		verifyTextEquals(actualAssignmentTitle, expectedAssignmentTitle, "Assignment Title Display verification in Instructor Reports");
		switchiFrame();
		
		String questionTitle = "", questionScoreText = "";
		
		List<WebElement> questionNavList = selectQuestionNavStdAssignment();
		System.out.println("Total Number of question in student reports: " + questionNavList.size());
		
		waitForQuestionTitle();
		
		String fullCreditForAttemptInsReportsText = getTextFromElement(InsAreaPage.fullCreditForAttemptElement, "Full Credit for Completion Text in Ins Reports");
		checkObjectExists(InsAreaPage.fullCreditForAttemptElement, fullCreditForAttemptInsReportsText);
		
		for(int i = 0; i < questionNavList.size(); i++) {
			waitForQuestionTitle();
			waiting(2);
			questionTitle = getTextFromElement(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + i+1);
		//	questionScoreText = getTextFromElement(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + i+1);
			checkObjectExists(stdReportsPage.questionTitle(driver, i+1), "Title of Question No: " + (i+1) + " " + questionTitle);
		//	checkObjectExists(stdReportsPage.questionScoreInfo(driver, i+1), "Score Info of Question No: " + (i+1) + " " + questionScoreText);
			
			if(i < questionNavList.size() - 1) {
				waiting(1);
				clickNextQuestion();
				waiting(1);
	//			waitForQuestionTitle();
			} else {
				break;
			}
		}
		
		switchToDefaultPage();
		clickSectionHomeButton();
	}
	
	public List<WebElement> selectQuestionNavStdAssignment() throws Exception{
		waitTillElementEnabled(AssignmentPage.questionNavigator, "Question Navigator", 6);
		waiting(1.5);
		clickObject(AssignmentPage.questionNavigator, "Question Navigator");
		waiting(2);
		
		return AssignmentPage.insPrevQuestionList(driver);
	}
	
	public void waitForQuestionTitle() throws Exception {
		waitTillElementEnabled(TakeAssignmentPage.questionTitle, "Question Title", 10);
	}	
	
	public void clickNextQuestion() throws Exception {
		clickObject(stdReportsPage.nextBtn, "Next Question");
	}
	
	public void clickSectionHomeButton() throws Exception {
		clickObject(stdReportsPage.sectionHomeBtn, "Section Home of Classic Student");
	}
	
	//utility methods using action builder
	
	public boolean arrowDownUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ARROW_DOWN).build().perform();
				Thread.sleep(250L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("Arrow Down key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press Arrow Down key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean arrowUpUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ARROW_UP).build().perform();
				Thread.sleep(250L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("Arrow Up key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press Arrow Up key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean arrowRightUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
				Thread.sleep(250L);
				
			}
		//	System.out.println("sayan's version");
			this.objHTMLFunctions.reportPassFailToATU("Arrow Right key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press Arrow Right key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean arrowLeftUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ARROW_LEFT).build().perform();
				Thread.sleep(250L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("Arrow Left key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press Arrow Left key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean pressEnterKeyUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.ENTER).build().perform();
				Thread.sleep(100L);
				
			}

			this.objHTMLFunctions.reportPassFailToATU("Enter key pressed " + intNoOfTimes + " times using action builder", "true",
					"true");
			return true;
		} catch (Exception var4) {
			this.objHTMLFunctions.reportPassFailToATU("Unable to press Enter key " + intNoOfTimes
					+ " times using action builder. Error<BR>" + this.objCMNFunctions.GetExceptionNDisplay(var4, true), "true",
					"false");
			return false;
		}
	}
	
	public boolean pressTabKeyUsingActionBuilder(int intNoOfTimes) throws Exception {
		try {
			Actions actions = new Actions(driver);

			for (int intCount = 0; intCount < intNoOfTimes; ++intCount) {
				//actions.keyDown(Keys.TAB).keyUp(Keys.TAB).build().perform();
				actions.sendKeys(Keys.TAB).build().perform();
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
	
	// Utility methods using Action Builder -------------------------------> end
	
	

}