package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class CreateAssignment extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Create EZT Assignments", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Revathi S", Utils.getCurrentTime(), "2.2");
			String strDescription = "Create Assignments, Messages, Instructor Info, Upload Syllabus and Create Bookmarks";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_02=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			final int homeworkDataRow = 2;
			final int quizDataRow = 3;
			final int practiceDataRow = 4;
			final int examDataRow = 5;
			final int toleranceHWDataRow = 6;
			
			
			// Login Connect
			loginClassicConnect();
			// Select Section
			selectSection();

		/*	
			// Edit Instructor Information 
			editInstructorInformation();

			// Post and Manage Messages 
			postOrManageMessages();

			// Create Book mark 
			createBookmark();

			// Upload Syllabus 
			uploadSyllabus();	*/
			 

			// Create Assignment

			
			this.strDTParametersNValues = "InputDataRow=>" + homeworkDataRow;
			createHomeworkAssignment(homeworkDataRow, env);
			//validateInsPreview();

			this.strDTParametersNValues = "InputDataRow=>" + quizDataRow;
			createQuizAssignment(quizDataRow, env);
			elegantHandling();

			this.strDTParametersNValues = "InputDataRow=>" + practiceDataRow;
			createPracticeAssignment(practiceDataRow, env);
		//	validateInsPreview();

			this.strDTParametersNValues = "InputDataRow=>" + examDataRow;
			createExamAssignment(examDataRow, env);
		//	validateInsPreview();  

			this.strDTParametersNValues = "InputDataRow=>" + toleranceHWDataRow;
			createToleranceAssignment(toleranceHWDataRow, env);
			validateInsPreview();	

			this.strDTParametersNValues = "InputDataRow=>" + defaultDataRow;	

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

	public void postOrManageMessages() throws Exception {
		connect().InstructorAreaPage().clickMessageSettings();
		connect().InstructorAreaPage().clickPostMessage();
		Thread.sleep(1000);
		connect().InstructorAreaPage().unselectCourse();
		connect().InstructorAreaPage().selectSection(1);
		// Post messages
		connect().InstructorAreaPage().typeMessage(1);
		connect().InstructorAreaPage().clickSaveMessage();
		Thread.sleep(1000);
		connect().InstructorAreaPage().typeMessage(2);
		connect().InstructorAreaPage().clickSaveMessage();
		Thread.sleep(1000);
		connect().InstructorAreaPage().typeMessage(3);
		connect().InstructorAreaPage().clickSaveMessage();
		connect().InstructorAreaPage().clickCloseMessages();
		// Edit message
		connect().InstructorAreaPage().clickMessageSettings();
		connect().InstructorAreaPage().clickManagePastMessages();
		connect().InstructorAreaPage().editMessage(2);
		connect().InstructorAreaPage().clickSaveMessage();
		Thread.sleep(1000);
		connect().InstructorAreaPage().clickCloseMessages();
		// Delete message
		connect().InstructorAreaPage().clickMessageSettings();
		connect().InstructorAreaPage().clickManagePastMessages();
		connect().InstructorAreaPage().deleteMessage(3);
		Thread.sleep(1000);
		connect().InstructorAreaPage().clickCloseMessages();
		waiting(6);
	}

	public void createBookmark() throws Exception {
		connect().InstructorAreaPage().clickBookmarkSettings();
		connect().InstructorAreaPage().typeBookmarkName();
		connect().InstructorAreaPage().typeBookmarkAddress();
		connect().InstructorAreaPage().uncheckBookmarkApplySections();
		connect().InstructorAreaPage().clickSaveBookmark();
		connect().InstructorAreaPage().verifyBookmarkMessage();
		connect().InstructorAreaPage().clickCloseBookmarkMessage();
		connect().InstructorAreaPage().clickShowBookmarkToStudents();
		connect().InstructorAreaPage().verifyBookmarkCreated();
	}

	public void editInstructorInformation() throws Exception {
		connect().InstructorAreaPage().clickInstructorInfoSetting();
		connect().InstructorAreaPage().clickEditInstructorInfo();
		connect().InstructorAreaPage().uploadPicture();
		connect().InstructorAreaPage().typeEmail();
		connect().InstructorAreaPage().typeBasicInformation();
		connect().InstructorAreaPage().uncheckInsInfoApplyToSections();
		connect().InstructorAreaPage().clickSaveInstructorInfo();
		Thread.sleep(1000);
		connect().InstructorAreaPage().verifyInstructorInfoMessage();
		connect().InstructorAreaPage().clickCloseInstructorInfoMessage();
		Thread.sleep(1000);
		connect().InstructorAreaPage().verifyInstructorInfo();
	}

	public void uploadSyllabus() throws Exception {
		connect().InstructorAreaPage().clickUploadSyllabus();
		// connect().InstructorAreaPage().clickChooseSyllabusFile();
		connect().InstructorAreaPage().uploadSyllabusFile();
		connect().InstructorAreaPage().uncheckSaveSyllabusForAllSections();
		connect().InstructorAreaPage().clickUploadSyllabusFile();
	//	connect().InstructorAreaPage().verifySyllabusFileUploaded();	//commented as not able to validate this in jenkins
	}

	public void customizeQuestionsOrder(String order, int dataRow) throws Exception {
		connect().CreateAssignmentPage().clickAddRandomSelection();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().enterNumberOfQuestions();
		if (order.equalsIgnoreCase("Random"))
			connect().CreateAssignmentPage().selectInRandom();
		else if (order.equalsIgnoreCase("Order"))
			connect().CreateAssignmentPage().selectInOrder();
		connect().CreateAssignmentPage().selectAddAsIndividualQuestions();
		connect().CreateAssignmentPage().clickAddQuestions();
		Thread.sleep(2000);
	}

	public void setPolicies(int dataRow) throws Exception {
		connect().CreateAssignmentPage().waitForAdvancedSettings(5);
		connect().CreateAssignmentPage().selectAssignmentType();
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickExpandAdvancedSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickEditAllSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().basicSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().attemptSettings();
		Thread.sleep(1000);
		// Tolerances has been disabled for this ISBN so this part of code has been
		// commented

	//	connect().CreateAssignmentPage().toleranceSettings();
		Thread.sleep(1000);

		connect().CreateAssignmentPage().resourcesSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().feedbackSettings();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickApplyChangesToThisAssignmentButton();
		
		//editing late submission settings***********************
		connect().CreateAssignmentPage().editLateSubmissionType();
		
		connect().CreateAssignmentPage().clickReviewNassignButton();
	}

	public void setPoliciestolerance(int dataRow) throws Exception {
		connect().CreateAssignmentPage().waitForAdvancedSettings(5);
		connect().CreateAssignmentPage().selectAssignmentType();
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickExpandAdvancedSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickEditAllSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().basicSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().attemptSettings();
		Thread.sleep(1000);

		// commented because this isbn does not support tolerance
	//	connect().CreateAssignmentPage().toleranceSettings();
		Thread.sleep(1000);

		connect().CreateAssignmentPage().resourcesSettings();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().feedbackSettingstolerance();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickApplyChangesToThisAssignmentButton();
		connect().CreateAssignmentPage().clickReviewNassignButton();
	}

	public void createHomeworkAssignment(int inputDataRow, String env) throws Exception {

		String environmentName = env;
		
		addAssignment(inputDataRow, environmentName);
		// *******************QUESTION SELECTION**********************
		addGradableQuestion();
		customizeQuestionsOrder("Random", inputDataRow);
		connect().CreateAssignmentPage().clickAssignmentTab();
		connect().CreateAssignmentPage().clickContinue();
		// ************************SET POLICIES***********************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		connect().CreateAssignmentPage().typeAssignmentEndDate(inputDataRow);
		connect().CreateAssignmentPage().typeAssignmentTimeZoneEndTime();
		
		setPolicies(inputDataRow);
		
		
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void createQuizAssignment(int inputDataRow, String env) throws Exception {
		String environmentName = env;
		addAssignment(inputDataRow, environmentName);
		
	//	addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		addGradableQuestion();
		customizeQuestionsOrder("Order", inputDataRow);
		connect().CreateAssignmentPage().clickAssignmentTab();
		connect().CreateAssignmentPage().clickContinue();
		// ************************************************************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		connect().CreateAssignmentPage().typeAssignmentEndDate(inputDataRow);
		connect().CreateAssignmentPage().typeAssignmentTimeZoneEndTime();
		
		setPolicies(inputDataRow);
		
		
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().shareToOwnSection(2);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void createPracticeAssignment(int inputDataRow, String env) throws Exception {
		String environmentName = env;
		addAssignment(inputDataRow, environmentName);
		
		//	addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		createQuestionPool();
		connect().CreateAssignmentPage().clickAssignmentTab();
		Thread.sleep(1000);
		deleteQuestion();
		Thread.sleep(1000);
		drawQuestion();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().clickContinue();
		// ************************************************************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		connect().CreateAssignmentPage().typeAssignmentEndDate(inputDataRow);
		connect().CreateAssignmentPage().typeAssignmentTimeZoneEndTime();
		
		setPolicies(inputDataRow);
		
		
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().shareToOwnSection(2);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void createExamAssignment(int inputDataRow, String env) throws Exception {
		String environmentName = env;
		addAssignment(inputDataRow, environmentName);
		
	//	addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		createQuestionPool();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickAssignmentTab();
		Thread.sleep(1000);
		drawQuestion();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickContinue();
		// ************************************************************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		connect().CreateAssignmentPage().typeAssignmentEndDate(inputDataRow);
		connect().CreateAssignmentPage().typeAssignmentTimeZoneEndTime();
		
		setPolicies(inputDataRow);
		
		
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().shareToOwnSection(2);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void createToleranceAssignment(int inputDataRow, String env) throws Exception {
		String environmentName = env;
		addAssignment(inputDataRow, environmentName);
		
	//	addAssignment(inputDataRow);
		// *******************QUESTION SELECTION**********************
		connect().CreateAssignmentPage().selectQuestions();
		connect().CreateAssignmentPage().addCheckedQuestionsAsIndividual();
		connect().CreateAssignmentPage().clickAssignmentTab();
		connect().CreateAssignmentPage().clickContinue();
		// ************************************************************
		connect().CreateAssignmentPage().waitForReviewNassignButton(10);
		connect().CreateAssignmentPage().clickStartOnceAssigned();
		// commented because this isbn does not support tolerance
		setPoliciestolerance(inputDataRow);
		
		// ************************Assign the Assignment**************
		connect().CreateAssignmentPage().waitForAssignButton(10);
		connect().CreateAssignmentPage().shareToOwnSection(2);
		connect().CreateAssignmentPage().clickAssignButton();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void addAssignment(int dataRow, String environmentName) throws Exception {
		connect().InstructorAreaPage().waitForAddAssignment(10);
		connect().CreateAssignmentPage().clickAddAssignmentButton();
		connect().CreateAssignmentPage().clickAddQuestionBank();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().waitForQuestionSource(10);
		connect().CreateAssignmentPage().selectQuestionSource();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		connect().CreateAssignmentPage().selectChapter(environmentName);
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

	public void addGradableQuestion() throws Exception {
		connect().CreateAssignmentPage().selectNonAutoGradableFilter();
		connect().CreateAssignmentPage().clickFilterGradableResults();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().selectGradableQuestion();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().addCheckedQuestionsAsIndividual();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().selectRemoveNonAutoGradableFilter();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickFilterGradableResults();
		Thread.sleep(1000);
	}

	public void createQuestionPool() throws Exception {
		connect().CreateAssignmentPage().selectQuestions();
		connect().CreateAssignmentPage().addCheckedQuestionsToPool();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().enterPoolName();
		connect().CreateAssignmentPage().clickSavePool();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
		Thread.sleep(1000);
	}

	public void deleteQuestion() throws Exception {
		connect().CreateAssignmentPage().clickExpandPool();
		connect().CreateAssignmentPage().selectQuestionToDelete();
		connect().CreateAssignmentPage().clickDeleteQuestion();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
	}

	public void drawQuestion() throws Exception {
		connect().CreateAssignmentPage().clickExpandPool();
		connect().CreateAssignmentPage().selectDrawQuestions();
		connect().CreateAssignmentPage().waitTillLoadingCompletes(20);
	}

	public void createFileAttachmentAssignment(int inputDataRow) throws Exception {
		connect().InstructorAreaPage().waitForAddAssignment(20);
		connect().CreateAssignmentPage().clickAddAssignmentButton();
		connect().CreateAssignmentPage().clickFileAttachmentAssignment();
		connect().CreateAssignmentPage().waitForFileAttachmentAssignButton(10);
		connect().CreateAssignmentPage().assignmentTitleWA(inputDataRow);
		connect().CreateAssignmentPage().fileAttachmentInstructions();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().uploadFiles();
		connect().CreateAssignmentPage().clickNextAssignFileAttach();
		connect().CreateAssignmentPage().waitForAssignFileAttach(10);
		connect().CreateAssignmentPage().shareFileAssignmentToOwnSection(2);
		connect().CreateAssignmentPage().clickAddColleague();
		this.strDTParametersNValues = "InputDataRow=>3";
		connect().CreateAssignmentPage().enterColleagueEmail();
		this.strDTParametersNValues = "InputDataRow=>" + inputDataRow;
		connect().CreateAssignmentPage().clickFindColleague();
		connect().CreateAssignmentPage().selectColleagueCourse();
		connect().CreateAssignmentPage().clickSaveColleague();
		connect().CreateAssignmentPage().selectColleagueSection();
		connect().CreateAssignmentPage().setStartDateNTime();
		connect().CreateAssignmentPage().setDueDateNTime();
		connect().CreateAssignmentPage().clickAssignFileAttach();
		connect().InstructorAreaPage().waitForAddAssignment(20);
	}

	public void createWebActivityAssignment(int inputDataRow) throws Exception {
		connect().InstructorAreaPage().waitForAddAssignment(20);
		connect().CreateAssignmentPage().clickAddAssignmentButton();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().clickWebActivityAssignment();
		Thread.sleep(1000);
		connect().CreateAssignmentPage().waitForWebActivityNextAssign(10);
		connect().CreateAssignmentPage().setWebActivityTitle(inputDataRow);
		connect().CreateAssignmentPage().webActivityInstructions();
		connect().CreateAssignmentPage().typeWebActivityLinkName();
		connect().CreateAssignmentPage().typeWebActivityLinkURL();
		connect().CreateAssignmentPage().clickWebActivityAssignNext();
		Thread.sleep(2000);
		connect().CreateAssignmentPage().selectShareToOwnSection(2);
		connect().CreateAssignmentPage().selectShareToColleagueSection(1);
		connect().CreateAssignmentPage().setWebActivityStartDateNTime();
		connect().CreateAssignmentPage().setWebActivityDueDateNTime();
		connect().CreateAssignmentPage().clickAssignWebActivity();
	}

	public void elegantHandling() throws Exception {
		connect().CreateAssignmentPage().selectAssignment();
		connect().CreateAssignmentPage().waitForAssignmentTitleHeader(10);
		connect().CreateAssignmentPage().clickAssignmentPreviewTab();
		connect().CreateAssignmentPage().switchToPreviewPage();
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		// Award Full Credit for Question 1
		connect().CreateAssignmentPage().selectQuestion(1);
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().clickAdjustCredit();
		connect().CreateAssignmentPage().waitForAdjustCreditPopUp(10);
		connect().CreateAssignmentPage().awardFullCredit();
		connect().CreateAssignmentPage().clickApplyCredit();
		connect().CreateAssignmentPage().clickConfirmApplyCredit();
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().verifyFullCredit();
		// Drop Question 2
		connect().CreateAssignmentPage().selectQuestion(2);
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().clickAdjustCredit();
		connect().CreateAssignmentPage().waitForAdjustCreditPopUp(10);
		connect().CreateAssignmentPage().dropQuestion();
		connect().CreateAssignmentPage().clickApplyCredit();
		connect().CreateAssignmentPage().clickConfirmApplyCredit();
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().verifyDropQuestion();
		// Flag Question 3 for manual grading
		connect().CreateAssignmentPage().selectQuestion(3);
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().clickAdjustCredit();
		connect().CreateAssignmentPage().waitForAdjustCreditPopUp(10);
		connect().CreateAssignmentPage().flagForManualGrading();
		connect().CreateAssignmentPage().clickApplyCredit();
		connect().CreateAssignmentPage().clickConfirmApplyCredit();
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().verifyFlaggedForManualGrading();
		connect().CreateAssignmentPage().selectQuestion(3);
		connect().CreateAssignmentPage().waitForQuestionNavigator(10);
		connect().CreateAssignmentPage().verifyManualGradingConfirm();
		connect().CreateAssignmentPage().switchToAssignmentPage();

		connect().CreateAssignmentPage().clickHomeButton();
		connect().InstructorAreaPage().waitForAddAssignment(10);
	}

	// New code added Nov '18
	public void validateInsPreview() throws Exception {
		connect().CreateAssignmentPage().selectAssignment();
		connect().CreateAssignmentPage().verifyInsPreview();
	}

	public void logoutConnect() throws Exception {
		Thread.sleep(2000);
		connect().ConnectLoginPage().clickSignOutButton();
		connect().ConnectLoginPage().waitForUserName(10);
	}
}