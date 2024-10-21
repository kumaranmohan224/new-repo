package com.newdemo.framework.controller;

//import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
//import org.python.antlr.ast.Assign;
import org.testng.Assert;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.GlobalPaths;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.ConnectLoginData;
import com.newdemo.framework.data.CreateAssignmentData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.CreateAssignmentPage;
import com.newdemo.framework.model.TakeAssignmentPage;


public class CreateAssignmentController extends ComponentFunctions {

	CreateAssignmentPage AssignmentPage = null;
	CreateAssignmentData AssignmentData = null;
	ConnectLoginData LoginData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	GlobalPaths Global = null;
	//Actions actions = null;
	TakeAssignmentPage TakeAssignmentPage = null;
	StudentRegistrationData StudentRegData = null;
	
	public CreateAssignmentController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		AssignmentPage = PageFactory.initElements(driver, CreateAssignmentPage.class);		
		Global = new GlobalPaths();	
	//	actions = new Actions(driver);
		TakeAssignmentPage = PageFactory.initElements(driver, TakeAssignmentPage.class);
	}
	
	public void clickAddAssignmentButton() throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.addAssignmentButton, "addAssignment Button");
		waiting(1);
	}
	
	public void clickAddQuestionBank() throws Exception
	{
		clickObject(AssignmentPage.addQuestionBankImage, "Question Bank Button");
		waiting(1);
	}
	
	public void waitForQuestionSource(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.questionSourceListLocator, "Question SourceList", intWaitTime);
	}
	
	public void selectQuestionSource() throws Exception
	{
		String strQuestionSource = AssignmentData.strDTQuestionSource;
		selectValueByTextFromList(AssignmentPage.questionSourceList,"Question Source",strQuestionSource);
	}
	
	public void selectChapter(String environmentName) throws Exception
	{
		try {
			//*****added by sayan
			String strQuestionSource = AssignmentData.strDTQuestionSource;
			String strChapter = AssignmentData.strDTTestContent;
			
			
		/*	
			final String ezidQAStage = "13570164040828331"; //*****Do not change unless using another assignment as source in QAStage*****
			final String ezidQALive = "12917293995113600"; //*****Do not change unless using another assignment as source in QALive*****
			final String ezidProd = "12934605839513879"; //*****Do not change unless using another assignment as source in Production*****
			String ezid = "";
			
			if(environmentName.contains("stg") || environmentName.contains("stage")) {
				ezid = ezidQAStage;
			} else if(environmentName.contains("live") || environmentName.contains("lv")) {
				ezid = ezidQALive;
			} else if(environmentName.contains("production") || environmentName.contains("prod")) {
				ezid = ezidProd;
			} else {
				System.out.println("**********Wrong Environment**********");
			}  */
			
			
			//*****added by sayan
			if(strQuestionSource.equalsIgnoreCase("Assignments I Created"))
			{
				String[] arrChapter = strChapter.split(";");
				String strCourse = arrChapter[0];
				String strSection = arrChapter[1];
				String strAssignment = arrChapter[2];
				
				try {
					clickObject(AssignmentPage.chapterCourse(driver,strCourse), "Select Course : " + strCourse);
					clickObject(AssignmentPage.chapterSection(driver,strSection), "Select Section : " + strSection);
					clickObject(AssignmentPage.chapterAssignment(driver,strAssignment), "Select Chapter : " + strAssignment); //*****changed by sayan
				} catch (Exception e) {
					clickObjectUsingJSExecutor(AssignmentPage.chapterAssignment(driver,strAssignment), "Select Chapter");
				}			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
				
	}
	
	public void selectChapter() throws Exception
	{
		try {
			//*****added by sayan
			String strQuestionSource = AssignmentData.strDTQuestionSource;
			String strChapter = AssignmentData.strDTTestContent;
			
			
		/*	
			final String ezidQAStage = "13570164040828331"; //*****Do not change unless using another assignment as source in QAStage*****
			final String ezidQALive = "12917293995113600"; //*****Do not change unless using another assignment as source in QALive*****
			final String ezidProd = "12934605839513879"; //*****Do not change unless using another assignment as source in Production*****
			String ezid = "";
			
			if(environmentName.contains("stg") || environmentName.contains("stage")) {
				ezid = ezidQAStage;
			} else if(environmentName.contains("live") || environmentName.contains("lv")) {
				ezid = ezidQALive;
			} else if(environmentName.contains("production") || environmentName.contains("prod")) {
				ezid = ezidProd;
			} else {
				System.out.println("**********Wrong Environment**********");
			}  */
			
			
			//*****added by sayan
			if(strQuestionSource.equalsIgnoreCase("Assignments I Created"))
			{
				String[] arrChapter = strChapter.split(";");
				String strCourse = arrChapter[0];
				String strSection = arrChapter[1];
				String strAssignment = arrChapter[2];
				
				try {
					clickObject(AssignmentPage.chapterCourse(driver,strCourse), "Select Course : " + strCourse);
					clickObject(AssignmentPage.chapterSection(driver,strSection), "Select Section : " + strSection);
					clickObject(AssignmentPage.chapterAssignment(driver,strAssignment), "Select Chapter : " + strAssignment); //*****changed by sayan
				} catch (Exception e) {
					clickObjectUsingJSExecutor(AssignmentPage.chapterAssignment(driver,strAssignment), "Select Chapter");
				}			
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}	
				
	}
	
	public void selectAssignmentFromList() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		try {
			
			clickObject(AssignmentPage.selectAssignment(driver, strAssignmentTitle), "Select Assignment");
			
		}catch (Exception e) {
			clickObjectUsingJSExecutor(AssignmentPage.selectAssignment(driver,strAssignmentTitle), "Select Assignment");
		}			
	}
	
	public void clickPolicyTab() throws Exception
	{
		try {
			waitTillElementEnabled(AssignmentPage.policyTab, "Policy Tab", 5);
			clickObject(AssignmentPage.policyTab, "Policy Tab");
			waiting(1.5);
			clickObjectUsingJSExecutor(AssignmentPage.policyTab, "Policy Tab");
			
		}catch (Exception e) {
			clickObjectUsingJSExecutor(AssignmentPage.policyTab, "Policy Tab");
		}
		
	}
	
	
	public void checkAssignmentStatus() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
	try {
		
		verifyTextEquals(AssignmentPage.checkAssignmentStatus.getText(),"not assigned", "Assignment Not assigned");
		
	}catch (Exception e) {
		verifyElementExist(AssignmentPage.checkVisibilty, false);
		verifyTextEquals(AssignmentPage.checkAssignmentStatus.getText().trim(),"not assigned", "Assignment Not assigned");
	}			
}
		
	
	
	public void waitTillLoadingCompletes(int intWaitTime) throws Exception
	{
		try
		{
			for(Integer intLoop = 0; intLoop < intWaitTime; intLoop++)
			{
				if(AssignmentPage.loadingWait.getAttribute("style").toLowerCase().contains(AssignmentPage.waitExpression().toLowerCase()))
				{
					Thread.sleep(1000);
				}
			}
			if(AssignmentPage.loadingWait.getAttribute("style").toLowerCase().contains(AssignmentPage.waitExpression().toLowerCase()))
			{
				ATUReports.add("Page is still not ready after " + intWaitTime + " seconds wait time. Error in waitTillLoadingCompletes method", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Page is still not ready after " + intWaitTime + " seconds wait time. Error in waitTillLoadingCompletes method", "True", "False");
			}
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing waitTillLoadingCompletes method in CreateAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing waitTillLoadingCompletes method in CreateAssignmentController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void waitForSelectAllQuestionEnable(int intWaitTime) throws Exception
	{
		waitTillElementEnabled(AssignmentPage.selectAllQuestionsCheckBox, "Select all Questions checkbox", intWaitTime);
	}
	
	public void renameAssignmentName(int RowNum) throws Exception
	{	
		SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		Date objDate = new Date();
		Calendar objCal = Calendar.getInstance();
		objCal.setTime(objDate);
		String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitleTemplate+strAppendDateTime;
		CMNFunctions.saveDataInExcel("CreateAssignment","AssignmentTitle",RowNum,strAssignmentTitle);	
		clearNTypeValue(AssignmentPage.renameAssignmentEditBox, "Assignment Title", strAssignmentTitle);			
	}	
	
	public void clickEnterStudentInstructions() throws Exception
	{
		clickObject(AssignmentPage.enterStudentInstructions, "Enter Student Instructions");
	}
	
	public void enterStudentInstructions() throws Exception
	{
		String strInstructions = AssignmentData.strDTInstructions;
		clearNTypeValue(AssignmentPage.studentInstructions, "Student Instructions", strInstructions);
	}
	
	public void clickSaveInstructions() throws Exception
	{
		clickObject(AssignmentPage.saveInstructions, "Save Student Instructions");
	}
	
	/***********************************Add Questions********************************************/
	
	public void clickAddRandomSelection() throws Exception
	{
		clickObject(AssignmentPage.addRandomSelection, "Add Random Selection");
	}
	
	public void enterNumberOfQuestions() throws Exception
	{
		String strNumberOfQuestions = AssignmentData.strDTSelectQuestions;
		clearNTypeValue(AssignmentPage.addNumQuestions, "Add Random Selection", strNumberOfQuestions);
	}
	
	public void selectInRandom() throws Exception
	{
		waiting(2);
		selectRadioOrCheckBox(AssignmentPage.selectRandom, "Add Random Selection","ON");
	}
	
	public void selectInOrder() throws Exception
	{
		waiting(2);
		selectRadioOrCheckBox(AssignmentPage.selectOrder, "Add Ordered Selection","ON");
	}
	
	public void selectAddAsIndividualQuestions() throws Exception
	{
		waiting(2);
		selectRadioOrCheckBox(AssignmentPage.addAsIndividualQuestions, "Add as Individual Questions","ON");
	}
	
	public void selectAddToNewPool() throws Exception
	{
		waiting(2);
		selectRadioOrCheckBox(AssignmentPage.addToNewPool, "Add to a New Pool","ON");
	}
	
	public void enterNewPoolName() throws Exception
	{
		waiting(2);
		String strPoolName = AssignmentData.strDTQuestionsPoolName;
		clearNTypeValue(AssignmentPage.newPoolName, "Pool Name", strPoolName);
	}
	
	public void clickAddQuestions() throws Exception
	{
		waiting(2);
		clickObject(AssignmentPage.addQuestions, "Add Questions");
	}
	
	public void selectQuestions() throws Exception
	{
		int intNumberOfQuestions = Integer.parseInt(AssignmentData.strDTSelectQuestions);
		for(int intQuestion=1; intQuestion<=intNumberOfQuestions; intQuestion++){
			clickObject(AssignmentPage.addQuestionCheckbox(driver,intQuestion), "Select Question "+intQuestion);
		}		
	}
	public void selectAllQuestions() throws Exception
	{
		waitTillElementEnabled(AssignmentPage.selectAllQuestions, "Select All Questions", 10);
		clickObject(AssignmentPage.selectAllQuestions, "Select All Questions");
		
	}		
	
	public void addSectionBreakQuestion() throws Exception
	{
		//waitTillElementEnabled(AssignmentPage.addSectionBreakQuestion, "Select Quuestion Section Break", 10);
		for(int intQuestion=6; intQuestion<=8; intQuestion++){
			clickObject(AssignmentPage.addQuestionCheckbox(driver,intQuestion), "Select Question ");
	}
}
	
	
	public void addCheckedQuestionsAsIndividual() throws Exception
	{
		clickObject(AssignmentPage.addCheckedQuestions, "Add Checked Questions");
		waiting(1.5);
		clickObject(AssignmentPage.addCheckedQuestionsIndividual, "Add Questions as Individual");
		waiting(2);
	}
	
	public void addCheckedQuestionsToPool() throws Exception
	{
		clickObject(AssignmentPage.addCheckedQuestions, "Add Checked Questions");
		clickObject(AssignmentPage.addCheckedQuestionsToPool, "Add Questions to a Pool");
	}
	
	public void clickOrganizeTab() throws Exception
	{
		waiting(3);
		clickObjectUsingJSExecutor(AssignmentPage.organizeAssignmentTab, "Organize Assignment Tab");
		waiting(3);
	}
	
	public void enterPoolName() throws Exception
	{
		String strPoolName = AssignmentData.strDTQuestionsPoolName;
		clearNTypeValue(AssignmentPage.poolName, "Pool Name", strPoolName);
	}
	
	public void clickSavePool() throws Exception
	{
		clickObject(AssignmentPage.savePool, "Save Pool");
	}
	
	public void selectNonAutoGradableFilter() throws Exception
	{
		try {
			waiting(2);
			selectRadioOrCheckBox(AssignmentPage.nonAutoGradableCheckBox, "Non Auto-Gradable Filter","ON");
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectRemoveNonAutoGradableFilter() throws Exception
	{
		try {
			waiting(2);
			selectRadioOrCheckBox(AssignmentPage.nonAutoGradableCheckBox, "Non Auto-Gradable Filter","OFF");
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickFilterGradableResults() throws Exception
	{
		waiting(1);
		clickObject(AssignmentPage.filterGradable, "Filter Gradable");
	}
	
	public void selectGradableQuestion() throws Exception
	{		
		try{
			clickObject(AssignmentPage.addQuestionCheckbox(driver,1), "Select Gradable Question ");
		}
		catch(Exception e){
			System.out.println("No Gradable Questions available");
		}
	}
	
	public void clickAssignmentTab() throws Exception
	{
		waiting(5);
		waitTillElementEnabled(AssignmentPage.assignmentTab, "Assignment Tab", 10);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentTab, "Assignment Tab");
	}
	
	public void clickSaveNExit() throws Exception
	{
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.saveNExit, "Assignment Tab");
		waiting(5);
	}
	
	public void clickExpandPool() throws Exception
	{		
		try {
			clickObject(AssignmentPage.expandPool, "Expand Pool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickCollapsePool() throws Exception
	{		
		try {
			clickObject(AssignmentPage.collapsePool, "Collapse Pool");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectQuestionToDelete()throws Exception
	{
		List<WebElement> questionsList = AssignmentPage.questionsCheckbox; 
		int lastQuestion = questionsList.size();
		clickObject(AssignmentPage.questionsCheckbox.get(lastQuestion-1), "Select Question to delete");
	}
	
	public void clickDeleteQuestion() throws Exception
	{
		clickObject(AssignmentPage.deleteQuestion, "Delete Question");
	}
	
	public void selectDrawQuestions() throws Exception
	{
		selectValueByTextFromList(AssignmentPage.drawQuestions, "Draw Question",AssignmentData.strDTDrawQuestions);
	}	
	
	public void clickContinue() throws Exception
	{
		waitTillElementEnabled(AssignmentPage.continueAssignment, "Continue", 10);
	//	clickObject(AssignmentPage.continueAssignment, "Continue");
		clickObjectUsingJSExecutor(AssignmentPage.continueAssignment, "Continue");
	}
	
	/*public void getAssignmentQuestions(int RowNum) throws Exception
	{
		GlobalPaths objGLPaths = new GlobalPaths();
    	HSSFWorkbook objWB = new HSSFWorkbook(new FileInputStream(objGLPaths.strXLInputDatasheetPath));
    	HSSFSheet objSHInputSheet = objWB.getSheet("QuestionsAndAnswers");
    	
    	String questionNumber = "";
    	List<WebElement> questionsList = AssignmentPage.assignmentQuestions;
		for(Integer intOuterLoop = 0; intOuterLoop < questionsList.size(); intOuterLoop++){
			String strQuestion = questionsList.get(intOuterLoop).getText();			
			for(int intInnerLoop=1; intInnerLoop<=objSHInputSheet.getLastRowNum(); intInnerLoop++){
	    		String strDTQuestion = objSHInputSheet.getRow(intInnerLoop).getCell(0).getStringCellValue();
	    		if(strQuestion.equalsIgnoreCase(strDTQuestion)){
	    			System.out.println(strQuestion);
	    			if(questionNumber=="")
	    				questionNumber=Integer.toString(intInnerLoop);
	    			else
	    				questionNumber=questionNumber+"--"+Integer.toString(intInnerLoop);
	    		}
	    	}
		}
		CMNFunctions.saveDataInExcel("TakeAssignment","QuestionsSequence",RowNum,questionNumber);	
	}*/
	
	/***********************************Assignment Policies********************************************/
	public void waitForReviewNassignButton(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.reviewNassignButtonLocator, "Review and Assign button", intWaitTime);
	}
	
	public void waitForPolicyTab(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.policyTab, "Policy Tab", intWaitTime);
	}
	
	public void clickViewAndEditPolicy() throws Exception
	
	{
			waitTillElementDisplayed(AssignmentPage.viewAndEditPolicy, "viewAndEditPolicy", 5);
			clickObject(AssignmentPage.viewAndEditPolicy,"View And Edit Policy");
		
	}
	
	public void clickStartOnceAssigned() throws Exception
	{
		try {
			waitTillElementDisplayed(AssignmentPage.startOnceAssigned, "start Once Assigned", 5);
			selectRadioOrCheckBox(AssignmentPage.startOnceAssigned, "start Once Assigned","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickStartOnThisDateButton() throws Exception
	{
		try {
			waitTillElementDisplayed(AssignmentPage.startOnThisDateButton, "StartOnThisDate button", 5);
			selectRadioOrCheckBox(AssignmentPage.startOnThisDateButton, "StartOnThisDate button", "ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void typeAssignmentStartDate(int RowNum) throws Exception
	{
		String strAssignmentStartDate = AssignmentData.strDTAssignmentStartDate;
		if(strAssignmentStartDate.equalsIgnoreCase("Today"))
		{
			Date dt = new Date();
			strAssignmentStartDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
			waitTillElementDisplayed(AssignmentPage.assignmentStartDate, "Assignment start date", 5);
			typeValueUsingJSExecutor(AssignmentPage.assignmentStartDate, "Assignment start date", strAssignmentStartDate);
		}
		CMNFunctions.saveDataInExcel("CreateAssignment","StartDate",RowNum,strAssignmentStartDate);
	}
	
	public void typeAssignmentTimeZoneStartTime() throws Exception
	{
		String strAssignmentStartTime = AssignmentData.strDTAssignmentStartTime;
		if(strAssignmentStartTime.contains(":"))
		{
			waitTillElementDisplayed(AssignmentPage.assignmentStartTime, "Assignment Start time", 5);
			typeValueUsingJSExecutor(AssignmentPage.assignmentStartTime, "Assignment Start time", strAssignmentStartTime);
		}
		else
		{
			Date dt = new Date();	
		    Calendar cl = Calendar. getInstance();
		    cl.setTime(dt); 
		    SimpleDateFormat df = new SimpleDateFormat("hh:mma");
			strAssignmentStartTime = df.format(cl.getTime());
			waitTillElementDisplayed(AssignmentPage.assignmentStartTime, "Assignment Start time", 5);
			typeValueUsingJSExecutor(AssignmentPage.assignmentStartTime, "Assignment Start time", strAssignmentStartTime);
		}			
	}
	
	public void typeAssignmentEndDate(int RowNum) throws Exception
	{
	//	checkNAcceptAlert(3);
		String strAssignmentEndDate = AssignmentData.strDTAssignmentEndDate;
		Date dt = new Date();			
		String strEndDate = "";
		if(strAssignmentEndDate.equalsIgnoreCase("Today"))
			{	
				strEndDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
				waitTillElementDisplayed(AssignmentPage.assignmentEndDate, "Assignment end date", 5);
				typeValueUsingJSExecutor(AssignmentPage.assignmentEndDate, "Assignment end date", strEndDate);				
			}		
		else
		{
		    Calendar cl = Calendar.getInstance();
		    cl.setTime(dt); 
		    cl.add(Calendar.MONTH, 6);		    
			strEndDate =  new SimpleDateFormat("MM/dd/yyyy").format(cl.getTime());
		//	clearNTypeValue(AssignmentPage.assignmentEndDate, "Assignment end date", strEndDate);
			waitTillElementDisplayed(AssignmentPage.assignmentEndDate, "Assignment end date", 5);
			typeValueUsingJSExecutor(AssignmentPage.assignmentEndDate, "Assignment end date", strEndDate);
		//	typeValueUsingActionBuilder(AssignmentPage.assignmentEndDate, strEndDate);
		}
		CMNFunctions.saveDataInExcel("CreateAssignment","EndDate",RowNum,strEndDate);
	}
	
	public void typeAssignmentTimeZoneEndTime() throws Exception
	{
		String strAssignmentEndTime = AssignmentData.strDTAssignmentEndTime;
		if(strAssignmentEndTime.contains(":"))
		{
		//	clearNTypeValue(AssignmentPage.assignmentEndTime, "Assignment End time", strAssignmentEndTime);
			waitTillElementDisplayed(AssignmentPage.assignmentEndDate, "Assignment end date", 5);
			typeValueUsingJSExecutor(AssignmentPage.assignmentEndTime, "Assignment End time", strAssignmentEndTime);
		}
		else
		{
			Date dt = new Date();
			Calendar cl = Calendar. getInstance();
			cl.setTime(dt); 
		    SimpleDateFormat df = new SimpleDateFormat("hh:mma");
		    strAssignmentEndTime = df.format(cl.getTime());
		//	clearNTypeValue(AssignmentPage.assignmentEndTime, "Assignment End time", strAssignmentEndTime);
		    waitTillElementDisplayed(AssignmentPage.assignmentEndDate, "Assignment end date", 5);
		    typeValueUsingJSExecutor(AssignmentPage.assignmentEndTime, "Assignment End time", strAssignmentEndTime);
		//  tabUsingRobot(1);
		    tabKeyUsingActionBuilder(1);
		    
		}
	//	CMNFunctions.saveDataInExcel("CreateAssignment","EndTime",RowNum,strEndDate);
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
	
	public void editLateSubmissionType()throws Exception
	{
		try {
			waitTillElementEnabled(AssignmentPage.editLateSubmission, "Edit Late Submission", 10);
			clickObject(AssignmentPage.editLateSubmission, "Edit Late Submission");
			
			if(AssignmentData.strDTCheckLateSubmissionDeduction.equalsIgnoreCase("on"))
			{
				waitTillElementDisplayed(AssignmentPage.acceptLateSubmission, "Accept Late Submission", 5);
				selectRadioOrCheckBox(AssignmentPage.acceptLateSubmission, "Accept Late Submission","ON");
				waiting(2);
				waitTillElementDisplayed(AssignmentPage.lateSubmissionValue, "Late Submission Value", 5);
				typeValueUsingJSExecutor(AssignmentPage.lateSubmissionValue, "Late Submission Value", AssignmentData.strDTLateSubmitDeduction);
				
				clickObjectUsingJSExecutor(AssignmentPage.lateSubmissionDeductionType, "Late Submission Deduction Type");
				if(AssignmentData.strDTLateSubmitDedType.equalsIgnoreCase("hour"))		
					clickObjectUsingJSExecutor(AssignmentPage.deductionTypeHour, "Deduction Type Hour");
				else
					clickObjectUsingJSExecutor(AssignmentPage.deductionTypeDay, "Deduction Type Hour");				
			}
			
			if(AssignmentData.strDTForceSubmit.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.forceSubmission, "Force Submission","ON");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void waitForAdvancedSettings(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.expandAdvancedSettings, "Expand Advanced Settings", intWaitTime);
	}
	
	public void selectAssignmentType()throws Exception
	{	
		String strAssignmentType = AssignmentData.strDTAssignmentType;
		switch(strAssignmentType){
			case "homework":
				waitTillElementDisplayed(AssignmentPage.homeworkTab, "Home Work", 5);
				clickObjectUsingJSExecutor(AssignmentPage.homeworkTab, "Home Work");
				break;
			case "practice":
				waitTillElementDisplayed(AssignmentPage.practiceTab, "Practice", 5);
				clickObjectUsingJSExecutor(AssignmentPage.practiceTab, "Practice");
				break;
			case "quiz":
				waitTillElementDisplayed(AssignmentPage.quizTab, "Quiz", 5);
				clickObjectUsingJSExecutor(AssignmentPage.quizTab, "Quiz");
				break;
			case "exam":
				waitTillElementDisplayed(AssignmentPage.examTab, "Exam", 5);
				clickObjectUsingJSExecutor(AssignmentPage.examTab, "Exam");
				break;
			default:
				waitTillElementDisplayed(AssignmentPage.homeworkTab, "Home Work", 5);
				clickObjectUsingJSExecutor(AssignmentPage.homeworkTab, "Home Work");
				break;		
		}		
	}
	
	public void clickExpandAdvancedSettings()throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.expandAdvancedSettings, "Expand Advanced Settings", 5);
		clickObjectUsingJSExecutor(AssignmentPage.expandAdvancedSettings, "Expand Advanced Settings");
	}
	public void clickCollapseAdvancedSettings()throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.collapseAdvancedSettings, "Collapse Advanced Settings", 5);
		clickObjectUsingJSExecutor(AssignmentPage.collapseAdvancedSettings, "Collapse Advanced Settings");
	}
	
	public void clickEditAllSettings()throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.editAllSettings, "Edit All Settings", 5);
		clickObjectUsingJSExecutor(AssignmentPage.editAllSettings, "Edit All Settings");
	}
	
	
	public void basicSettings()throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.basicSettings, "Edit Basic Settings");
		waiting(3);		
		setTimeLimit();		
		setPrintingOption();
		setQuestionScrambling();	
		setAssignmentPassword();
		setAutomaticFullCredit();
	}
	
	public void clickReviewPolicies()throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.reviewPolicies, "Review Policies");
	}
	
	public void verifyPoliciesInAssignPage()throws Exception
	{
		clickReviewPolicies();
	}
	
	public void verifyBasicSettings()throws Exception
	{
		
	}
	
	public void setTimeLimit()throws Exception
	{
		try {
			if(AssignmentData.strDTAllowTimeLimit.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.timeLimitCheck, "Time Limit Check","ON");
				waiting(1);
				clearNTypeValue(AssignmentPage.timeLimit, "TimeLimit", AssignmentData.strDTTimeLimit);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.timeLimitCheck, "Time Limit Check","OFF");
				waiting(1);
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPrintingOption()throws Exception
	{
		try {
			if(AssignmentData.strDTAllowPrinting.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.allowPrinting, "Allow Printing","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.allowPrinting, "Allow Printing","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setQuestionScrambling()throws Exception
	{
		try {
			if(AssignmentData.strDTScrambleQuestions.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.allowScramble, "Scramble Questions","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.allowScramble, "Scramble Questions","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAssignmentPassword()throws Exception
	{
		try {
			if(AssignmentData.strDTAddPassword.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.addPassword, "Password","ON");
				waiting(1);
				clearNTypeValue(AssignmentPage.assignmentPassword, "Assignment Password", AssignmentData.strDTPassword);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.addPassword, "Password","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAutomaticFullCredit()throws Exception
	{
		try {
			if(AssignmentData.strDTAutomaticFullCredit.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.automaticFullCredit, "Automatic Full Credit","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.automaticFullCredit, "Automatic Full Credit","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void attemptSettings()throws Exception
	{
		clickObject(AssignmentPage.attemptsSettings, "Edit Attempt Settings");
		waiting(3);		
		setAttemptsAllowed();
		setAttemptOption();
		setAttemptDeduction();
	}
	
	public void setAttemptsAllowed()throws Exception
	{
		try {
			String attemptsFromExcel = AssignmentData.strDTAttemptsAllowed;
			System.out.println("Attempt value received from Excel = " + attemptsFromExcel);
			selectValueByTextFromList(AssignmentPage.attemptsAllowed, "Attempts Allowed",attemptsFromExcel);
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAttemptOption()throws Exception
	{
		try {
			if(AssignmentData.strDTAttemptOption.equalsIgnoreCase("fresh"))
			{
				selectRadioOrCheckBox(AssignmentPage.attemptFresh, "Start Over","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.attemptPrevious, "Previous attempt","ON");
				waiting(1);
				if(AssignmentData.strDTRevisePreviousAttempt.equalsIgnoreCase("on")){
					selectRadioOrCheckBox(AssignmentPage.revisePreviousAttempt, "Revise the previous attempt","ON");
				}
			}				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAttemptDeduction()throws Exception
	{
		try {
			if(AssignmentData.strDTCheckDeductionForAttempt.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.checkDeductionForAttempt, "Password","ON");
				waiting(1);
				clearNTypeValue(AssignmentPage.deductionForAttempt, "Assignment Password", AssignmentData.strDTDeductionForAttempt);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.checkDeductionForAttempt, "Password","OFF");
				waiting(1);
			}
			if(AssignmentData.strDTCompoundDeduction.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.compoundDeduction, "Start Over","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.compoundDeduction, "Start Over","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void toleranceSettings()throws Exception
	{
		clickObject(AssignmentPage.toleranceSettings, "Edit Tolerance Settings");
		waiting(3);		
		setAccentTolerance();
		setSpacingTolerance();
		setCaseTolerance();
		setToleranceValue();
	}
	
	public void setAccentTolerance()throws Exception
	{
		try {
			if(AssignmentData.strDTIgnoreAccents.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.ignoreAccents, "Ignore Accents","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.ignoreAccents, "Ignore Accents","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setSpacingTolerance()throws Exception
	{
		try {
			if(AssignmentData.strDTIgnoreSpacing.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.ignoreSpacing, "Ignore Spacing","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.ignoreSpacing, "Ignore Spacing","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCaseTolerance()throws Exception
	{
		try {
			if(AssignmentData.strDTIgnoreCase.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.ignoreCase, "Ignore Case","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.ignoreCase, "Ignore Case","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setToleranceValue()throws Exception
	{
		try {
			if(Integer.parseInt(AssignmentData.strDTToleranceValue)>0)
			{
				clearNTypeValue(AssignmentPage.toleranceValue, "Tolerance Value", AssignmentData.strDTToleranceValue);
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void resourcesSettings()throws Exception
	{
		clickObject(AssignmentPage.resourcesSettings, "Edit Resources Settings");
		waiting(3);	
		setQuestionTitle();
		setPointValue();
	//	setFormulas();
		setReferences();
	//	setExternalLinks();
		setEbookAndResources();
		setHints();
		setCheckMyWork();
	//	setShowAnswers();
	//	setShowGuidedAnswers();
		setAskInstructor();
		waiting(2);
	}
	
	public void setQuestionTitle()throws Exception
	{
		try {
			if(AssignmentData.strDTQuestionTitle.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.questionTitle, "Question Title","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.questionTitle, "Question Title","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setPointValue()throws Exception
	{
		try {
			if(AssignmentData.strDTPointValue.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.pointValue, "Point Value","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.pointValue, "Point Value","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setFormulas()throws Exception
	{
		try {
			if(AssignmentData.strDTFormulas.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.formulas, "Formulas","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.formulas, "Formulas","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setReferences()throws Exception
	{
		try {
			if(AssignmentData.strDTReferences.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.references, "References","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.references, "References","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setExternalLinks()throws Exception
	{
		try {
			if(AssignmentData.strDTExternalLinks.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.externalLinks, "External Links","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.externalLinks, "External Links","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setEbookAndResources()throws Exception
	{
		try {
			if(AssignmentData.strDTEbookAndResources.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.ebookAndResources, "Ebook And Resources","ON");
				waiting(1);
				
				clearNTypeValue(AssignmentPage.deductOnResources, "Deduct on Resources", AssignmentData.strDTDeductOnResources);
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.ebookAndResources, "Ebook And Resources","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setHints()throws Exception
	{
		try {
			if(AssignmentData.strDTHints.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.hints, "Hints","ON");
				waiting(1);
				
				clearNTypeValue(AssignmentPage.deductOnHints, "Deduct on Hints", AssignmentData.strDTDeductOnHints);
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.hints, "Hints","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setCheckMyWork()throws Exception
	{
		try {
			if(AssignmentData.strDTCheckMyWork.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.checkMyWork, "Check My Work","ON");
				waiting(1);
				
				if(AssignmentData.strDTLimitCheckwork.equalsIgnoreCase("on"))
				{
					selectRadioOrCheckBox(AssignmentPage.limitCheckwork, "Limit Check My Work","ON");
					waiting(1);
					clearNTypeValue(AssignmentPage.limitCheckworkValue, "Limit Checkwork Value", AssignmentData.strDTLimitCheckworkValue);
					waiting(1);
				}
				
				if(AssignmentData.strDTDeductCheckwork.equalsIgnoreCase("on"))
				{
					selectRadioOrCheckBox(AssignmentPage.deductCheckwork, "Deduct Checkwork","ON");
					waiting(1);
					clearNTypeValue(AssignmentPage.deductCheckworkValue, "Deduct Checkwork", AssignmentData.strDTDeductCheckworkValue);
					waiting(1);
				}
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.checkMyWork, "Check My Work","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setShowAnswers()throws Exception
	{
		try {
			if(AssignmentData.strDTShowAnswers.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.showAnswers, "Show Answers","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.showAnswers, "Show Answers","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setShowGuidedAnswers()throws Exception
	{
		try {
			if(AssignmentData.strDTShowGuidedAnswers.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.showGuidedAnswers, "Show Guided Answers","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.showGuidedAnswers, "Show Guided Answers","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setAskInstructor()throws Exception
	{
		try {
			if(AssignmentData.strDTAskInstructor.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.askInstructor, "Ask Instructor","ON");
				waiting(1);
			}
			else{
				selectRadioOrCheckBox(AssignmentPage.askInstructor, "Ask Instructor","OFF");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void feedbackSettings()throws Exception
	{
		clickObject(AssignmentPage.feedbackSettings, "Edit Feedback Settings");
		waiting(3);		
		setFeedbackPostAttempt();
		setFeedbackPostQuestion();
	}
	public void feedbackSettingsEDP()throws Exception
	{
		clickObject(AssignmentPage.feedbackSettings, "Edit Feedback Settings");
		waiting(3);		
		setFeedbackPostAttempt();
		setFeedbackPostQuestion();
	}
	public void feedbackSettingstolerance()throws Exception
	{
		clickObject(AssignmentPage.feedbackSettings, "Edit Feedback Settings");
		waiting(3);		
		setFeedbackPostAttempt();
		setFeedbackPostQuestion();
	}
	public void setFeedbackPostAttempt()throws Exception
	{
		try {
			if(AssignmentData.strDTShowFeedbackPostAttempt.equalsIgnoreCase("on"))
			{
				waitTillElementEnabled(AssignmentPage.showFeedbackPostAttempt, "Show Feedback After Attempt", 10);
				waiting(1);
				selectRadioOrCheckBox(AssignmentPage.showFeedbackPostAttempt, "Show Feedback After Attempt","ON");
				waiting(1);
				
				waitTillElementEnabled(AssignmentPage.afterFirstAttempt, "After First Attempt", 10);
				waiting(1.5);
				clickObject(AssignmentPage.afterFirstAttempt, "After First Attempt");
				String feedbackType = AssignmentData.strDTAfterFirstAttempt;
				selectFeedbackType(feedbackType);	
				waiting(1);
				
				if(AssignmentData.strDTAttemptsAllowed.equalsIgnoreCase("unlimited")){
					clickObject(AssignmentPage.afterAdditionalAttempt, "After Additional Attempt");
					feedbackType = AssignmentData.strDTAfterAdditionalAttempt;
					selectFeedbackType(feedbackType);
					waiting(1);
					
					clickObject(AssignmentPage.afterFullScore, "After Full Score");
					feedbackType = AssignmentData.strDTAfterFullScore;
					selectFeedbackType(feedbackType);
					waiting(1);
				}				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectFeedbackType(String feedbackType)throws Exception
	{
		switch (feedbackType)
		{
		case "detailed feedback":
			waitTillElementEnabled(AssignmentPage.detailFeedback, "Detail Feedback", 5);
			waiting(1.5);
			clickObject(AssignmentPage.detailFeedback, "Detail Feedback");
			break;
		case "no feedback":
			waitTillElementEnabled(AssignmentPage.noFeedback, "Detail Feedback", 5);
			waiting(1.5);
			clickObject(AssignmentPage.noFeedback, "No Feedback");
			break;
		case "total scores":
			waitTillElementEnabled(AssignmentPage.totalScoresFeedback, "Detail Feedback", 5);
			waiting(1.5);
			clickObject(AssignmentPage.totalScoresFeedback, "Total Scores");
			break;
		case "correct incorrect Indicators":
			waitTillElementEnabled(AssignmentPage.totalScoresFeedbackIndicators, "Detail Feedback", 5);
			waiting(1.5);
			clickObject(AssignmentPage.totalScoresFeedbackIndicators, "Correct Incorrect Indicators");
			break;
		case "detailed feedback with solutions":
			waitTillElementEnabled(AssignmentPage.detailFeedbackWithSolutions, "Detail Feedback", 5);
			waiting(1.5);
			clickObject(AssignmentPage.detailFeedbackWithSolutions, "Detailed feedback with Solutions");
			break;
		}
	}
	
	public void setFeedbackPostQuestion()throws Exception
	{
		try {
			if(AssignmentData.strDTShowFeedbackPostQuestion.equalsIgnoreCase("on"))
			{
				selectRadioOrCheckBox(AssignmentPage.showFeedbackPostQuestion, "Show Feedback After Question","ON");
				waiting(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickApplyChangesToThisAssignmentButton()throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.applyChangesToThisAssignment, "Apply Changes To This Assignment");
	}
	
	public void clickReviewNassignButton() throws Exception
	{
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.reviewAndAssign, "Review and Assign");
	}
	public void clickReviewNassignButtonColleague() throws Exception
	{
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.reviewAndAssignColleague, "Review and Assign");
	}
	
	public void waitForAssignButton(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.assign, "Assign", intWaitTime);
	}
	
	public void waitForAssignEditButton(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.assignmentEdit, "Assign Edit", intWaitTime);
	}
	
	public void AssignmentEditSection() throws Exception
	{
		String strQuestionTitle=AssignmentData.strDTAfterFirstAttempt;
		try{
		waiting(2);
		clickObject(AssignmentPage.assignmentEdit, "Assignment Edit");
		waiting(2);
		clickObject(AssignmentPage.assignmentEditOption, "Assignment Edit Option");
		
		String questionTitle=AssignmentData.strDTQuestionTitles;
		String questionList[]=questionTitle.split(";");
		
		for(int i=0;i<questionList.length;i++)
		{
			clickObject(AssignmentPage.selectQuestion(driver,questionList[i]), "Question");
			waitTillElementEnabled(AssignmentPage.editThisQuestion, "Waiting for edit Button", 30);
			clickObject(AssignmentPage.editThisQuestion, "Edit This Question");
			waiting(3);
			clickObject(AssignmentPage.acceptAllAnswer,"Accept All Answer Selected");
			clickObject(AssignmentPage.saveSettings, "Save Accept all Answer");
			waitTillElementEnabled(AssignmentPage.closeSettingsPopup, "Pop Up", 30);
			
				if(waitTillElementEnabled(AssignmentPage.closeSettingsPopup, "Settings Popup", 5))
				{
					clickObjectUsingJSExecutor(AssignmentPage.closeSettingsPopup, "Settings Pop Up");				
				}
				else
				{
					objHTMLFunctions.ReportPassFail("There is no Settings Pop up", "True","True");
				}	
				waiting(5);
				waitTillElementEnabled(AssignmentPage.nextQuestion, "Next Question", 10);
				if(AssignmentPage.nextQuestion.isEnabled())
				{
				clickObject(AssignmentPage.nextQuestion, "Next Question");
				}
		}
		
		waiting(5);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	
}

	
	
	public void shareToOwnSection(int sectionNumber)throws Exception
	{
		try {
			String sectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
			selectRadioOrCheckBox(AssignmentPage.shareAssignmentToSection(driver, sectionName), "Show Feedback After Question","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	

	public void CopyToOwnSection(int sectionNumber)throws Exception
	{
		try {
			String sectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
			selectRadioOrCheckBox(AssignmentPage.copyAssignmnetToSection(driver, sectionName), "Show Feedback After Question","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public void selectSharingPolicy()throws Exception
	{
		try {
			String shareType = AssignmentData.strDTAssignmentShareType;
			if(shareType.equalsIgnoreCase("only start and due dates"))
				selectRadioOrCheckBox(AssignmentPage.onlyduedates, "only start and due dates","ON");
			else if(shareType.equalsIgnoreCase("all policies"))			
				selectRadioOrCheckBox(AssignmentPage.allpolicies, "all policies","ON");
			else
				selectRadioOrCheckBox(AssignmentPage.nopolicies, "no policies","ON");
			waiting(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickAssignButton() throws Exception
	{
		waiting(2);
		waitTillElementEnabled(AssignmentPage.assign, "Assign", 15);
		clickObjectUsingJSExecutor(AssignmentPage.assign, "Assign");
	}

	public void clickFileAttachmentAssignment() throws Exception
	{		
		clickObjectUsingJSExecutor(AssignmentPage.fileAttachment, " File Attachment assignment is clicked");		
	}
	
	public void waitForFileAttachmentAssignButton(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.assignFileAttachment, "File Attachment Assign button", intWaitTime);
	}
	
	public void assignmentTitleWA(int RowNum) throws Exception
	{
		try
		{		
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strAssignmentTitle = "Assign"+strAppendDateTime;
			CMNFunctions.saveDataInExcel("CreateAssignment","AssignmentTitle",RowNum,strAssignmentTitle);	
			clearNTypeValue(AssignmentPage.fileAttachmentAssignmentTitle, "Assignment Title", strAssignmentTitle);
			
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing assignmentTitleWA in SmokeTestController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing assignmentTitleWA method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}	
	
	public void fileAttachmentInstructions() throws Exception
	{
		try{
			String strAssignmentInstructions = AssignmentData.strDTInstructions;
			clickObject(AssignmentPage.fileAttachmentInstructions,strAssignmentInstructions);
			typeValueUsingActionBuilder(AssignmentPage.fileAttachmentInstructions, strAssignmentInstructions);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing fileAttachmentInstructions in SmokeTestController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing fileAttachmentInstructions method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	

	public void uploadFiles() throws Exception
	{
		try{
			clickObject(AssignmentPage.chooseFile,"Click choose file");
			waiting(1);
			clickObjectUsingJSExecutor(AssignmentPage.uploadFiles, "upload files");
			waiting(4);
			//clickObjectUsingJSExecutor(AssignmentPage.browseButton, "Browse files");
			//Point p= AssignmentPage.browseButton.getLocation();
		//	getCooridnatesNClickUpdated(AssignmentPage.browseButton,  "Browse files", 30, 30);
	//		clickObjectUsingJSExecutor(AssignmentPage.browseButton,  "Browse files");
			int ImageWidth = AssignmentPage.browseButton.getSize().getWidth();
	        System.out.println("Image width Is "+ImageWidth+" pixels");

	        //Get height of element.
	        int ImageHeight = AssignmentPage.browseButton.getSize().getHeight();        
	        System.out.println("Image height Is "+ImageHeight+" pixels");
			waiting(5);	
			String strSyllabusUploadPath = System.getProperty("user.dir")+"\\FilesToUpload\\"+"FileAttachmentSample.txt";
			waiting(1);
			pasteFromClipboard(strSyllabusUploadPath);
			waiting(1);			
			//typeValue(AssignmentPage.txtFileUploadBackEnd, "File Upload", strSyllabusUploadPath);
			
			waitTillElementDisplayed(AssignmentPage.uploadLink, "Upload link", 10);
			clickObjectUsingJSExecutor(AssignmentPage.uploadLink,  "Upload the selected file");
			waiting(3);
			selectRadioOrCheckBox(AssignmentPage.attachFileCheckBox,"Select uploaded file", "ON");
			waiting(2);
			clickObjectUsingJSExecutor(AssignmentPage.attachSelectedFiles,  "Upload the selected file");
			waiting(1);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing uploadFiles in CreateAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing uploadFiles method in CreateAssignmentController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void clickNextAssignFileAttach() throws Exception
	{		
		try{
			clickObjectUsingJSExecutor(AssignmentPage.fileAttachmentNextAssign,  "File Attachment Next assign button is clicked");	
			waiting(2);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing clickAssignFileAttach in CreateAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing clickAssignFileAttach method in CreateAssignmentController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void waitForAssignFileAttach(int waitTime) throws Exception
	{		
		waiting(2);
		waitTillElementDisplayed(AssignmentPage.assignFileAttachment, "Assign button", waitTime);
	}
	
	public void shareFileAssignmentToOwnSection(int sectionNumber)throws Exception
	{
		try {
			String sectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
			selectRadioOrCheckBox(AssignmentPage.shareFileAssignmentToSection(driver, sectionName), "Share Assignment to own Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickAddColleague() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.addColleague, "add Colleague");
	}
	
	public void clickAddColleagueForEZT() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.eztAddColleague, "add Colleague");
	}
	
	public void enterColleagueEmail() throws Exception
	{		
		waiting(2);
		String strColleagueEmail = LoginData.strDTUserName;
		System.out.println(strColleagueEmail);
		clearNTypeValue(AssignmentPage.colleagueEmail, "Colleague Email",strColleagueEmail);
	}
	
	public void clickFindColleague() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.findColleague, "Find Colleague");
	}
	
	public void clickFindColleagueForEZT() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.findColleagueEzt, "Find Colleague");
	}
	
	public void selectColleagueCourse()throws Exception
	{
		try {
			String colleagueCourseName = retrieveRuntimeGlobalVariable("ColleagueCourseName");
			selectRadioOrCheckBox(AssignmentPage.colleagueCourse(driver, colleagueCourseName), "Share Assignment to Colleague Course","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectColleagueCourseForEzt()throws Exception
	{
		try {
			String colleagueCourseName = retrieveRuntimeGlobalVariable("ColleagueCourseName");
			selectRadioOrCheckBox(AssignmentPage.colleagueCourseEzt(driver, colleagueCourseName), "Share Assignment to Colleague Course","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectColleagueCourseForEzts()throws Exception
	{
		try {
			String colleagueCourseName = retrieveRuntimeGlobalVariable("ColleagueCourseName");
			selectRadioOrCheckBox(AssignmentPage.colleagueCourseEzts(driver, colleagueCourseName), "Share Assignment to Colleague Course","ON");
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void clickSaveColleague() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.saveColleague, "Save Colleague");
	}
	
	public void clickSaveColleagueForEzt() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.saveColleagueEzt, "Save Colleague");
	}
	
	public void clickSaveColleagueWebActivity() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.webActivitySaveColleague, "Save Colleague");
	}
	
	public void selectColleagueSection()throws Exception
	{
		try {
			waiting(2);
			String colleagueCourseName = retrieveRuntimeGlobalVariable("ColleagueCourseName");
			selectRadioOrCheckBox(AssignmentPage.colleagueSection(driver, colleagueCourseName), "Share Assignment to Colleague Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectColleagueSectionForEZT()throws Exception
	{
		try {
			waiting(2);
			String colleagueSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName1");
			selectRadioOrCheckBox(AssignmentPage.colleagueSectionEzt(driver, colleagueSectionName), "Share Assignment to Colleague Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setallPolicies() throws Exception
	{
		waiting(2);
		selectRadioOrCheckBox(AssignmentPage.setAllPolicies, "Set All Policies", "ON");
	}
	
	public void selectColleagueSectionForEZTs()throws Exception
	{
		try {
			waiting(2);
			String colleagueSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName1");
			selectRadioOrCheckBox(AssignmentPage.colleagueSectionEzts(driver, colleagueSectionName), "Share Assignment to Colleague Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectShareType()throws Exception
	{
		try {
			
			
			waiting(2);
			String colleagueCourseName = retrieveRuntimeGlobalVariable("ColleagueCourseName");
			selectRadioOrCheckBox(AssignmentPage.colleagueSection(driver, colleagueCourseName), "Share Assignment to Colleague Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setStartDateNTime()throws Exception
	{
		try {
			Date dt = new Date();
			Calendar cl = Calendar. getInstance();
			cl.setTime(dt); 
		    cl. add(Calendar.MINUTE, 2);	
			String strAssignmentStartDate = new SimpleDateFormat("MM/dd/yyyy").format(cl.getTime());
			clickObject(AssignmentPage.fileAssignStartDate, "fileAssignStartDate");
			clearNTypeValue(AssignmentPage.fileAssignStartDate, "Assignment start date", strAssignmentStartDate);
			
			String[] arrStartTime = new SimpleDateFormat("hh mm aa").format(cl.getTime()).split(" ");
			clearNTypeValue(AssignmentPage.fileAssignStartHour, "Assignment start Hour", arrStartTime[0]);
			clearNTypeValue(AssignmentPage.fileAssignStartMinute, "Assignment start Minute", arrStartTime[1]);
			selectValueByTextFromList(AssignmentPage.fileAssignStartAmPm,"Start Time AM/PM",arrStartTime[2].toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setDueDateNTime()throws Exception
	{
		try {
			Date dt = new Date();
			Calendar cl = Calendar. getInstance();
			cl.setTime(dt);
		    cl. add(Calendar.MONTH, 6);	
			String strAssignmentStartDate = new SimpleDateFormat("MM/dd/yyyy").format(cl.getTime());
			clickObject(AssignmentPage.fileAssignDueDate, "fileAssignDueDate");
			clearNTypeValue(AssignmentPage.fileAssignDueDate, "Assignment start date", strAssignmentStartDate);
			
			String[] arrStartTime = new SimpleDateFormat("hh mm aa").format(cl.getTime()).split(" ");
			clearNTypeValue(AssignmentPage.fileAssignDueHour, "Assignment start Hour", arrStartTime[0]);
			clearNTypeValue(AssignmentPage.fileAssignDueMinute, "Assignment start Minute", arrStartTime[1]);
			selectValueByTextFromList(AssignmentPage.fileAssignDueAmPm,"Start Time AM/PM",arrStartTime[2].toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickAssignFileAttach() throws Exception
	{		
		try{
			clickObjectUsingJSExecutor(AssignmentPage.assignFileAttachment,  "File Attachment assign button is clicked");	
			waiting(2);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing clickAssignFileAttach in CreateAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing clickAssignFileAttach method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void clickWebActivityAssignment() throws Exception
	{		
		clickObjectUsingJSExecutor(AssignmentPage.webActivity, "Web Activity assignment is clicked");		
	}
	
	public void waitForWebActivityNextAssign(int waitTime) throws Exception
	{		
		waitTillElementDisplayed(AssignmentPage.webActivityNextAssign, "Web Activity Next Assign button", waitTime);		
	}
	
	public void setWebActivityTitle(int RowNum) throws Exception
	{		
		try{
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strAssignmentTitle = "Assign"+strAppendDateTime;
			CMNFunctions.saveDataInExcel("CreateAssignment","AssignmentTitle",RowNum,strAssignmentTitle);	
			clearNTypeValue(AssignmentPage.webActivityTitle, "Assignment Title", strAssignmentTitle);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void webActivityInstructions() throws Exception
	{
		String strAssignmentInstructions = AssignmentData.strDTInstructions;
		clearNTypeValue(AssignmentPage.webActivityInstructions, "Web Activity Instructions", strAssignmentInstructions);
		
	}
	
	public void typeWebActivityLinkName() throws Exception
	{
		String strLinkName = AssignmentData.strDTWebActivityLinkName;
		clearNTypeValue(AssignmentPage.webActivityLinkName, "Web Activity Link Name", strLinkName);		
	}
	
	public void typeWebActivityLinkURL() throws Exception
	{
		String strLinkURL = AssignmentData.strDTWebActivityURL;
		clearNTypeValue(AssignmentPage.webActivityURL, "Web Activity URL", strLinkURL);		
	}
	
	public void clickWebActivityAssignNext() throws Exception
	{		
		clickObjectUsingJSExecutor(AssignmentPage.webActivityNextAssign, "Web Activity next assign");		
	}
	
	public void selectShareToOwnSection(int sectionNumber)throws Exception
	{
		try {
			String sectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
			selectRadioOrCheckBox(AssignmentPage.shareWebActivityToSection(driver, sectionName), "Share Assignment to Own Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectShareToColleagueSection(int sectionNumber)throws Exception
	{
		try {
			waiting(2);
			String colleagueSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName"+sectionNumber);
			selectRadioOrCheckBox(AssignmentPage.shareWebActivityToSection(driver, colleagueSectionName), "Share Assignment to Colleague Section","ON");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setWebActivityStartDateNTime()throws Exception
	{
		try {
			Date dt = new Date();
			Calendar cl = Calendar. getInstance();
			cl.setTime(dt); 
		    cl. add(Calendar.MINUTE, 2);	
			String strAssignmentStartDate = new SimpleDateFormat("MM/dd/yyyy").format(cl.getTime());
			clickObject(AssignmentPage.webActivityStartDate, "webActivityStartDate");
			clearNTypeValue(AssignmentPage.webActivityStartDate, "Assignment start date", strAssignmentStartDate);
			
			String[] arrStartTime = new SimpleDateFormat("hh mm aa").format(cl.getTime()).split(" ");
			clearNTypeValue(AssignmentPage.webActivityStartHour, "Assignment start Hour", arrStartTime[0]);
			clearNTypeValue(AssignmentPage.webActivityStartMinute, "Assignment start Minute", arrStartTime[1]);
			selectValueByTextFromList(AssignmentPage.webActivityStartAmPm,"Start Time AM/PM",arrStartTime[2].toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setWebActivityDueDateNTime()throws Exception
	{
		try {
			Date dt = new Date();
			Calendar cl = Calendar. getInstance();
			cl.setTime(dt);
		    cl. add(Calendar.MONTH, 6);	
			String strAssignmentStartDate = new SimpleDateFormat("MM/dd/yyyy").format(cl.getTime());
			clickObject(AssignmentPage.webActivityDueDate, "webActivityDueDate");
			clearNTypeValue(AssignmentPage.webActivityDueDate, "Assignment due date", strAssignmentStartDate);
			
			String[] arrStartTime = new SimpleDateFormat("hh mm aa").format(cl.getTime()).split(" ");
			clearNTypeValue(AssignmentPage.webActivityDueHour, "Assignment due Hour", arrStartTime[0]);
			clearNTypeValue(AssignmentPage.webActivityDueMinute, "Assignment due Minute", arrStartTime[1]);
			selectValueByTextFromList(AssignmentPage.webActivityDueAmPm,"due Time AM/PM",arrStartTime[2].toLowerCase());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void clickAssignWebActivity() throws Exception
	{		
		try{
			clickObjectUsingJSExecutor(AssignmentPage.webActivityAssign,  "Web Activity  assign button");	
			waiting(2);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing clickAssignFileAttach in CreateAssignmentController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing clickAssignFileAttach method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void selectAssignment() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		waiting(2.5);
		clickObject(AssignmentPage.assignment(driver,strAssignmentTitle), "Assignment "+strAssignmentTitle);		
	}
	
	public void selectAssignmentStdViewClassic() throws Exception {
		String assignmentTitle = AssignmentData.strDTAssignmentTitle;
		clickObject(AssignmentPage.stdPrevAssignment(this.driver, assignmentTitle), "Assignment: " + assignmentTitle);
	}
	
	public void selectStdViewClassic() throws Exception {
		waitTillElementEnabled(AssignmentPage.studentPreview, "Student View Classic", 10);
		waiting(2);
		clickObject(AssignmentPage.studentPreview, "Student View Classic");
	}
	
	public void selectInsViewClassic() throws Exception {
		waitTillElementEnabled(AssignmentPage.instructorView, "Instructor View Classic", 10);
		clickObject(AssignmentPage.instructorView, "Instructor View Cassic");
	}
	
	public void closeStudentPreviewCLassic() throws Exception {
		waitTillElementEnabled(AssignmentPage.closeStudentPreview, "Close Student View Classic", 10);
		clickObject(AssignmentPage.closeStudentPreview, "Close Student View Classic");
	}
	
	public void clickAssignmentResults() throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.assignmentResults, "Assignment Results", 20);
		waiting(2);
		clickObject(AssignmentPage.assignmentResults, "Assignment Results");
	}
	
	public void addStudentExtension() throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.assignmentResults, "Assignment Results", 20);
		waitTillElementEnabled(AssignmentPage.assignmentEdit, "Assignment Edit", 10);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentEdit, "Assignment Edit");
		waiting(2);
		if(AssignmentPage.manageExtensions.isDisplayed())
		{
		clickObjectUsingJSExecutor(AssignmentPage.manageExtensions, "Assignment Edit Option");
		}
		waitTillElementDisplayed(AssignmentPage.studentCheckBox, "Student Selected", 10);
		selectRadioOrCheckBox(AssignmentPage.studentCheckBox, "Student Clicked", "ON");
		waiting(2);
		clickObject(AssignmentPage.editDueDateForStudentExtension, "Edit Due Date");
		waiting(2);
		AssignmentPage.assignmentEndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waiting(2);
		clearNTypeValue(AssignmentPage.assignmentEndDate, "Change End Date", getCurrentDueDateAsString());
		waiting(2);
		AssignmentPage.assignmentEndTime.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		waiting(2);
		clearNTypeValue(AssignmentPage.assignmentEndTime, "Change End Time", getEDTTimeStamp("America/New_York", "hh:mma", 1));
		waiting(1.5);
		clickObject(AssignmentPage.saveExtensions, "Save Extensions");
		waitTillElementDisplayed(AssignmentPage.checkExtension, "Extension is provided", 20);
	//	clickObjectUsingJSExecutor(AssignmentPage.backToStudentActivity, "Back To Student Activity");
		waitTillElementDisplayed(AssignmentPage.assignmentResults, "Assignment Results", 20);
		
	}
	
	public String getCurrentDueDateAsString() {
		Date dt = new Date();	
		String strEndDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
		return strEndDate;
	}
	
	public String getEDTTimeStamp(String timeZoneStr, String formatStr, int addMinute) throws Exception {

		long timeInMilliSeconds = Calendar.getInstance().getTimeInMillis();
		Date date = new Date(timeInMilliSeconds + (addMinute * 60 * 1000)); // Adding 1 minute of time to current time
		DateFormat timeFormat = new SimpleDateFormat(formatStr);
		timeFormat.setTimeZone(TimeZone.getTimeZone(timeZoneStr));

		String estTime = timeFormat.format(date);
		// date = new SimpleDateFormat(formatStr, Locale.ENGLISH).parse(estTime);

		// return timeFormat.format(date);
		return estTime;
	}
	
	public void changeAssignmentEndDate() throws Exception
	{
		waiting(2);
		AssignmentPage.assignmentEndDate.clear();
		clearNTypeValue(AssignmentPage.assignmentEndDate, "Change End Date", "02/21/2020");
		waiting(2);
		AssignmentPage.assignmentEndTime.clear();
		clearNTypeValue(AssignmentPage.assignmentEndTime, "Change End Time", "1:00a");
	}
	
	
	public void checkAssignment() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		selectRadioOrCheckBox(AssignmentPage.assignmentCheck(driver,strAssignmentTitle), "Assignment "+strAssignmentTitle, "ON");		
	}
	
	public void waitForAssignmentTitleHeader(int waitTime) throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		waitTillElementDisplayed(AssignmentPage.assignmentTitleHeader(driver,strAssignmentTitle), "Assignment Header", waitTime);		
		waiting(2);
	}
	
	public void clickAssignmentPreviewTab() throws Exception
	{		
		waiting(2);
		clickObject(AssignmentPage.previewTab, "Assignment Preview Tab");		
	}
	
	public  void checkQuestionTitleInPreview() throws Exception
	{
		int intNumberOfQuestions=Integer.parseInt(AssignmentData.strDTSelectQuestions);
		for(int intQuestion=1;intQuestion<=intNumberOfQuestions;intQuestion++)
		{
			waitTillFrameLoads(AssignmentPage.iFramePreviewPage,"Wait Till Frame Loads");
			switchToPreviewPage();
			waitTillElementDisplayed(AssignmentPage.questionTitleInsPreview, "Wait for Question Title", 20);
			String questionTitle=AssignmentPage.questionTitleInsPreview.getText();
			System.out.println("Title for Question number "+intQuestion+ " in Instructor Preview is " +questionTitle);
			Assert.assertTrue(questionTitle!="WWTB","Question Title contains WWTB");
			clickObject(AssignmentPage.nextQuestionButtonInPreview, "Next Question");
			switchToAssignmentPage();
			
		}
	}
	
	public  void checkQuestionTitleInStudentAssignment() throws Exception
	{
		int intNumberOfQuestions=Integer.parseInt(AssignmentData.strDTSelectQuestions);
		for(int intQuestion=1;intQuestion<=intNumberOfQuestions;intQuestion++)
		{
			waitTillElementDisplayed(AssignmentPage.questionTitleInsPreview, "Wait for Question Title", 20);
			String questionTitle=AssignmentPage.questionTitleInsPreview.getText();
			System.out.println("Title for Question no "+intQuestion+ " in Student Assignment is " +questionTitle);
			Assert.assertTrue(questionTitle!="WWTB","Question Title contains WWTB");
			clickObject(AssignmentPage.nextQuestionButtonInPreview, "Next Question");
			
		}
	}
	
	public void waitTillFrameLoads(WebElement element,String message) throws Exception
	{
		waitTillElementDisplayed(element, message, 25);
	}
	
	public void switchToPreviewPage()throws Exception
	{
		switchiFrame();
	}
	
	public void switchToAssignmentPage()throws Exception
	{
		switchToDefaultPage();
	}
	
	public void waitForQuestionNavigator(int waitTime) throws Exception
	{
		waiting(2);
		waitTillElementDisplayed(AssignmentPage.questionNavigator, "Question Navigator", waitTime);	
	}
	
	
	
	public void clickAdjustCredit() throws Exception
	{		
		clickObject(AssignmentPage.adjustCredit, "Adjust Credit");	
	}
	
	public void waitForAdjustCreditPopUp(int waitTime) throws Exception
	{		
		waiting(2);
		waitTillElementDisplayed(AssignmentPage.adjustCreditPopUpHeader, "Adjust Credit PopUp", waitTime);			
	}
	
	public void awardFullCredit() throws Exception
	{		
		clickObject(AssignmentPage.awardFullCredit, "Award Full Credit");
		waiting(2);
		clickObject(AssignmentPage.fullCreditJustThisAssignment, "Adjust Credit");
	}
	
	public void dropQuestion() throws Exception
	{		
		clickObject(AssignmentPage.dropQuestion, "Award Full Credit");
		waiting(2);
		clickObject(AssignmentPage.dropQuestionJustThisAssignment, "Adjust Credit");
	}
	
	public void flagForManualGrading() throws Exception
	{		
		clickObject(AssignmentPage.flagForManualGrading, "Award Full Credit");
		waiting(2);
	}
	
	public void clickApplyCredit() throws Exception
	{		
		clickObject(AssignmentPage.applyCredit, "Apply Credit");		
	}
	
	public void clickConfirmApplyCredit() throws Exception
	{		
		clickObject(AssignmentPage.confirmApplyCredit, "COnfirm Apply Credit");		
	}
	
	public void verifyFullCredit() throws Exception
	{		
		String str = "Full credit has been awarded to all students.";
		checkObjectExists(AssignmentPage.fullCreditAwarded, str);		
	}
	
	public void verifyDropQuestion() throws Exception
	{		
		String str = "This question and its points have been dropped.";
		checkObjectExists(AssignmentPage.questionDropped, str);		
	}
	
	public void verifyFlaggedForManualGrading() throws Exception
	{		
		String str = "This item has been flagged for manual grading for all students.";
		checkObjectExists(AssignmentPage.flaggedForManualGrading, str);		
	}
	
	public void verifyManualGradingConfirm() throws Exception
	{		
		String str = "Question is flagged for manual grading.";
		checkObjectExists(AssignmentPage.manualGradingFlagged, str);		
	}
	
	public void clickHomeButton() throws Exception
	{		
		clickObject(AssignmentPage.homeButton, "Home Button");		
	}
	
	//Share Copy scenarios
	public void clickAssignmentOptions()throws Exception
	{
		clickObject(AssignmentPage.assignmentOptions, "Assignment Options ");
		waiting(1);	
	}
	
	public void clickShare()throws Exception
	{
		try {
			clickObjectUsingJSExecutor(AssignmentPage.share, "Share ");
			waiting(1);
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void clickConfirmShare()throws Exception
	{
		clickObject(AssignmentPage.confirmShare, "Share ");
		waiting(1);	
	}
	
	public void selectAssignmentSharingPolicy()throws Exception
	{
		try {
			String shareType = AssignmentData.strDTAssignmentShareType;
			if(shareType.equalsIgnoreCase("only start and due dates"))
				selectRadioOrCheckBox(AssignmentPage.onlyduedates, "only start and due dates","ON");
			else if(shareType.equalsIgnoreCase("all policies"))			
				selectRadioOrCheckBox(AssignmentPage.allpolicies, "all policies","ON");
			else
				selectRadioOrCheckBox(AssignmentPage.nopolicies, "no policies","ON");
			waiting(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void checkDefaultPolicy(String AssignmentType) throws Exception
	{
		if(AssignmentType=="HomeWork" || AssignmentType=="Practice")
		{
			checkElementNotSelected(AssignmentPage.timeLimitCheck, "Time Limit");
			checkElementSelected(AssignmentPage.allowPrinting, "Allow Printing ");
			checkElementNotSelected(AssignmentPage.allowScramble, "Allow Scramble");
			checkElementNotSelected(AssignmentPage.addPassword, "Add Password");
			checkElementNotSelected(AssignmentPage.awardFullCreditParticipant, "Award Full Credit");
			
			clickObject(AssignmentPage.attemptsSettings, "Edit Attempt Settings");
			waiting(3);		
		//	verifyTextInElement(AssignmentPage.attemptsAllowed.getText(), "Attempts allowed", "unlimited");
			
			checkElementSelected(AssignmentPage.attemptFresh, "Start Fresh is");
			
			checkElementNotSelected(AssignmentPage.checkDeductionForAttempt, "Deduction is not");
			checkElementNotSelected(AssignmentPage.studyAttempts, "Study Attempt is not");
			
		//	clickObject(AssignmentPage.toleranceSettings, "Edit Tolerance Settings"); PRod
			waiting(2);	
			
		//	checkElementSelected(AssignmentPage.ignoreAccents, "Accented characters is");   Prod
		//	checkElementNotSelected(AssignmentPage.ignoreSpacing, "Study Attempt is not");
		//	checkElementNotSelected(AssignmentPage.ignoreCase, "Study Attempt is not");
		//	verifyTextEquals(AssignmentPage.toleranceValue.getText().trim(), "", "Tolerance value ");
		
			clickObject(AssignmentPage.resourcesSettings, "Edit Resources Settings");
			waiting(3);	
			
			checkElementNotSelected(AssignmentPage.questionTitle, "Question Title is not");
			checkElementSelected(AssignmentPage.references, "references is");
			checkElementSelected(AssignmentPage.pointValue, "pointValue is");
		//	checkElementSelected(AssignmentPage.externalLinks, "externalLinks is");
		//	checkElementSelected(AssignmentPage.formulas, "formulas is");
			
			checkElementSelected(AssignmentPage.ebookAndResources, "ebookAndResources is");
			
			verifyTextEquals(AssignmentPage.deductOnResources.getAttribute("value"), "0", "ebookAndResources value ");
			
			checkElementSelected(AssignmentPage.hints, "hints is");
			verifyTextEquals(AssignmentPage.deductOnHints.getAttribute("value"), "0", "hints value ");
			
			checkElementSelected(AssignmentPage.checkMyWork, "checkMyWork is");
			verifyTextEquals(AssignmentPage.deductCheckworkValue.getAttribute("value"), "0", "deductCheckworkValue value ");
			
		//	checkElementSelected(AssignmentPage.showAnswers, "showAnswers is");
		//	checkElementSelected(AssignmentPage.showGuidedAnswers, "showGuidedAnswers is");
			
			checkElementNotSelected(AssignmentPage.askInstructor, "Question Title is not");
			
			clickObject(AssignmentPage.feedbackSettings, "Edit Feedback Settings");
			waiting(3);	
			if(AssignmentType=="HomeWork")
			{
			checkElementSelected(AssignmentPage.showFeedbackPostAttempt, "showFeedbackPostAttempt is");
			
			/*Select afterFirstAttempt = new Select(AssignmentPage.afterFirstAttempt);
			Select afterAdditionalAttempt = new Select(AssignmentPage.afterAdditionalAttempt);
			Select afterFullScore = new Select(AssignmentPage.afterFirstAttempt);
			
			verifyTextInElement(afterFirstAttempt.getFirstSelectedOption().getText().trim(), "afterFirstAttempt", "detailed feedback");
			verifyTextInElement(afterAdditionalAttempt.getFirstSelectedOption().getText().trim(), "afterFirstAttempt", "detailed feedback");
			verifyTextInElement(afterFullScore.getFirstSelectedOption().getText().trim(), "afterFirstAttempt", "detailed feedback");*/
			}else if(AssignmentType=="Practice")
			{
				checkElementSelected(AssignmentPage.aftereachQuestion, "After Each Question", true);
			}
		}else if(AssignmentType=="Quiz" || AssignmentType=="Exam")
		{
			checkElementNotSelected(AssignmentPage.timeLimitCheck, "Time Limit");
			checkElementNotSelected(AssignmentPage.allowPrinting, "Allow Printing ");
			checkElementNotSelected(AssignmentPage.allowScramble, "Allow Scramble");
			checkElementNotSelected(AssignmentPage.addPassword, "Add Password");
			checkElementNotSelected(AssignmentPage.fullCreditAwarded, "Award Full Credit");
			
			clickObject(AssignmentPage.attemptsSettings, "Edit Attempt Settings");
			waiting(3);		
	//		verifyTextInElement(AssignmentPage.attemptsAllowed.getAttribute("value"), "Attempts allowed", "1	");
			checkElementSelected(AssignmentPage.studyAttempts, "stud Attempts", false);
			
	//		clickObject(AssignmentPage.toleranceSettings, "Edit Tolerance Settings");
			waiting(3);	
			
	//		checkElementSelected(AssignmentPage.ignoreAccents, "Accented characters",true);
	//		checkElementSelected(AssignmentPage.ignoreSpacing, "Ignore Spacing",false);
	//		checkElementSelected(AssignmentPage.ignoreCase, "Ignore Case", false);
	//		verifyTextEquals(AssignmentPage.toleranceValue.getText().trim(), "", "Tolerance value ");
			
			clickObject(AssignmentPage.resourcesSettings, "Edit Resources Settings");
			waiting(3);	
			
			checkElementSelected(AssignmentPage.questionTitle, "Question Title",false);
			checkElementSelected(AssignmentPage.references, "references",false);
			checkElementSelected(AssignmentPage.pointValue, "pointValue is",false);
	//		checkElementSelected(AssignmentPage.externalLinks, "externalLinks is",true);
	//		checkElementSelected(AssignmentPage.formulas, "formulas is",true);
	//		
			checkElementSelected(AssignmentPage.ebookAndResources, "ebookAndResources",false);
			verifyTextEquals(AssignmentPage.deductOnResources.getAttribute("value"), "0", "ebookAndResources value ");
			
			checkElementSelected(AssignmentPage.hints, "hints ",false);
			verifyTextEquals(AssignmentPage.deductOnHints.getAttribute("value"), "0", "hints value ");
			
			checkElementSelected(AssignmentPage.checkMyWork, "checkMyWork",false);
			verifyTextEquals(AssignmentPage.deductCheckworkValue.getAttribute("value"), "0", "deductCheckworkValue value ");
			
	//		checkElementSelected(AssignmentPage.showAnswers, "showAnswers is",true);
	//		checkElementSelected(AssignmentPage.showGuidedAnswers, "showGuidedAnswers",false);
	//
			clickObject(AssignmentPage.feedbackSettings, "Edit Feedback Settings");
			waiting(3);	
			if(AssignmentType=="Exam")
			{
				checkElementSelected(AssignmentPage.showFeedbackPostAttempt, "showFeedbackPostAttempt",true);
				
				verifyTextInElement(AssignmentPage.afterFirstAttempt.getText().trim(), "afterFirstAttempt", "no feedback");
			}else
			{
				checkElementSelected(AssignmentPage.showFeedbackPostAttempt, "showFeedbackPostAttempt",true);
				verifyTextInElement(AssignmentPage.afterFirstAttempt.getText().trim(), "afterFirstAttempt", "total scores");
			}
		}
	}
	
	
	public void checkElementSelected(WebElement webElement, String strObjectName) throws Exception
	{
		if(webElement.isSelected())
		try {
			try {
				this.objHTMLFunctions.reportPassFailToATU("Element " + strObjectName + "</i> Selected", "true",
						"true");
			} catch (Exception objException) {
				 this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
					/*  404 */ this.objHTMLFunctions.reportPassFailToATU(
							strObjectName + " is not Selected. <br> Error message=>" + this.strErrorMsg, "true", "false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkElementNotSelected(WebElement webElement, String strObjectName) throws Exception
	{
		if(!webElement.isSelected())
		try {
			try {
				this.objHTMLFunctions.reportPassFailToATU("Element " + strObjectName + "</i>Not Selected", "true",
						"true");
			} catch (Exception objException) {
				 this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
					/*  404 */ this.objHTMLFunctions.reportPassFailToATU(
							strObjectName + " is not Selected. <br> Error message=>" + this.strErrorMsg, "true", "false");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void checkSetPolicy(String AssignmentType) throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.reviewPolicySummary, "review Policy Summary");
		waiting(2);
		
		if(AssignmentType=="HomeWork" || AssignmentType=="Practice")
		{
			verifyTextEquals(AssignmentPage.reviewTimeLimit.getText(),"No time Limit","Basic Policy Printing");
			String print=AssignmentPage.reviewPrinting.getText();
			System.out.println(print);
		
			verifyTextEquals(print, "Printing is allowed", "Basic Policy Printing");
			verifyTextEquals(AssignmentPage.reviewQuestionOrder.getText(),"Questions are scrambled","Basic Policy Scramble");
			verifyTextEquals(AssignmentPage.reviewPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
			verifyTextEquals(AssignmentPage.reviewCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
			
	//		verifyTextEquals(AssignmentPage.reviewBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
	//		verifyTextEquals(AssignmentPage.reviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
		
	//PROD	verifyTextEquals(AssignmentPage.reviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
	//		verifyTextEquals(AssignmentPage.reviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
	//		verifyTextEquals(AssignmentPage.reviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
			
			verifyTextEquals(AssignmentPage.reviewQuestionPointValue.getText(),"Question point values are shown","Resource Policy Question Point Value");
			verifyTextEquals(AssignmentPage.reviewQuestionTitle.getText(),"Question titles are not shown","Resource Policy Question Title");
			verifyTextEquals(AssignmentPage.reviewReference.getText(),"References are shown","Resource Policy References");
		//	verifyTextEquals(AssignmentPage.reviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
		//	verifyTextEquals(AssignmentPage.reviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
			
			verifyTextEquals(AssignmentPage.revieweBookAssitantDeductions.getText(),"0%","Resource Policy EBook Deductions");
			verifyTextEquals(AssignmentPage.reviewHintsDeductions.getText(),"0%","Resource Policy Hints Deductions");
		//	verifyTextEquals(AssignmentPage.reviewUsesofCheckMyWork.getText(),"0","Resource Policy CheckMyWork Uses per Question");
		//	verifyTextEquals(AssignmentPage.revieweCheckMyWorkDeductions.getText(),"0%","Resource Policy CheckMyWork Uses Deduction");
			
		//	verifyTextEquals(AssignmentPage.reviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
		//	verifyTextEquals(AssignmentPage.reviewGuidedSolutions.getText(),"Guided solutions are allowed","Resource Policy Guided solutions");
		//	verifyTextEquals(AssignmentPage.reviewAskToInstructor.getText(),"Access to \"ask the instructor\" is not allowed","Resource Policy ask Instructor");
		//	verifyTextEquals(AssignmentPage.reviewPracticeQuestions.getText(),"Practice questions are allowed","Resource Policy Practice Questions");
			if(AssignmentType=="HomeWork")
			{
			verifyTextEquals(AssignmentPage.reviewFeedbackafterFirstAttempt.getText(),"Detailed feedback","Feedback Policy After First Attempt");
			verifyTextEquals(AssignmentPage.reviewFeedbackafterAdditionalAttempt.getText(),"Detailed feedback","Feedback Policy After Additional Attempts");
			verifyTextEquals(AssignmentPage.reviewFeedbackafterFullScore.getText(),"Detailed feedback","Feedback Policy After Full Score");
		//	verifyTextEquals(AssignmentPage.reviewFeedbackDueDate.getText(),"Feedback shown on due date","Feedback Policy Due Date");
			}else
			{
				//verifyTextEquals(AssignmentPage.reviewPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				verifyTextEquals(AssignmentPage.reviewFeedbackafterQuestions1.getText(),"- question score","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.reviewFeedbackafterQuestion2.getText(),"- solution","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.reviewFeedbackafterQuestions3.getText(),"- correct answer","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.reviewFeedbackafterQuestions4.getText(),"- explanation (when available)","FeddBack Policy After each Question");
			}
			
			if(AssignmentType=="Quiz" || AssignmentType=="Exam")
			{
				verifyTextEquals(AssignmentPage.reviewTimeLimit.getText(),"No time Limit","Basic Policy Printing");
				verifyTextEquals(print, "Printing is not allowed", "Basic Policy Printing");
				verifyTextEquals(AssignmentPage.reviewQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
				verifyTextEquals(AssignmentPage.reviewPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
				//verifyTextEquals(AssignmentPage.reviewCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
				
		//	    verifyTextEquals(AssignmentPage.reviewBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
		//		verifyTextEquals(AssignmentPage.reviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
			
		//		verifyTextEquals(AssignmentPage.reviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
		//		verifyTextEquals(AssignmentPage.reviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
		//		verifyTextEquals(AssignmentPage.reviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
				
				verifyTextEquals(AssignmentPage.reviewQuestionPointValue.getText(),"Question titles are not shown","Resource Policy Question Point Value");
				verifyTextEquals(AssignmentPage.reviewQuestionTitle.getText(),"Question point values are not shown","Resource Policy Question Title");
				verifyTextEquals(AssignmentPage.reviewReference.getText(),"References are not shown","Resource Policy References");
		//		verifyTextEquals(AssignmentPage.reviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
		//		verifyTextEquals(AssignmentPage.reviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
				
				verifyTextEquals(AssignmentPage.reviewEbookQuiz.getText(),"Access to the eBook and resources is not allowed","Resource Policy Ebook");
				verifyTextEquals(AssignmentPage.reviewHintsQuiz.getText(),"Access to hints is not allowed","Resource Policy Hints");
				verifyTextEquals(AssignmentPage.reviewcheckWorkQuiz.getText(),"Access to check my work is not allowed","Resource Policy CheckMyWork");
				
		//		verifyTextEquals(AssignmentPage.reviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
		//		verifyTextEquals(AssignmentPage.reviewGuidedSolutions.getText(),"Guided solutions are not allowed","Resource Policy Guided solutions");
		//		verifyTextEquals(AssignmentPage.reviewAskToInstructor.getText(),"Access to '\"ask the instructor'\" is not allowed","Resource Policy ask Instructor");
		//		verifyTextEquals(AssignmentPage.reviewPracticeQuestions.getText(),"Practice questions are not allowed","Resource Policy Practice Questions");
				verifyTextEquals(AssignmentPage.reviewPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				
				if(AssignmentType=="Quiz")
				{
					verifyTextEquals(AssignmentPage.reviewFeedbackafterFirstAttempt.getText(),"Total scores only", "Feedback Policy After submitting attempt");
					
				}else if(AssignmentType=="Exam")
				{
					verifyTextEquals(AssignmentPage.reviewFeedbackafterFirstAttempt.getText(),"No feedback", "Feedback Policy After submitting attempt");
				}
			}
		}
	}
	public void verifyOrganizeAssignment() throws Exception
	{
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.organizeAssignmentTab, "Organize Assignment Tab");
		waiting(2);
		verifyTextEquals(AssignmentPage.pointsValue.getAttribute("value"),"10.00","Points Value per Question");
		
	}
	
	public void selectQuestionsIndividually() throws Exception
	{
		String strAssignmentStartDate = AssignmentData.strDTQuestionTitles;
		String []strQuestionList=strAssignmentStartDate.split(";");
		
		for(int i=0;i<strQuestionList.length;i++)
		{
			clickObject(AssignmentPage.selectQuestionsIndividually(driver, strQuestionList[i]),"Question Selected"+strQuestionList[i]);
			waitTillElementEnabled(AssignmentPage.addThisQuestion, "Add This Question", 5);
			clickObject(AssignmentPage.addThisQuestion, "Add This Question" +strQuestionList[i]);
			waiting(3);
			
			clickObject(AssignmentPage.addIndividualQuestions, "Add Questions as Individual");
			waiting(7);
			
			clickObject(AssignmentPage.organizeAssignmentTab, "Organize Assignment Tab");
			waiting(3);
			verifyElementDisplayed(AssignmentPage.selectQuestionsIndividually(driver,strQuestionList[i] ), true);
			waiting(2);
			clickObject(AssignmentPage.addQuestionTab, "Add Question Tab");
			waiting(3);
			
		}
	}
	
	public void checkAssignmnetIsShared() throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.sharedIcon, "Assignment Shared",5);
		verifyElementDisplayed(AssignmentPage.sharedIcon, true);
	}
	
	public void checkAssignmnetIsSharedInColleague() throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.colleagueSharedIcon, "Colleague Assignment Shared",5);
		verifyElementDisplayed(AssignmentPage.colleagueSharedIcon, true);
	}
	
	public void AssignmentEdit() throws Exception
	{
		waitTillElementEnabled(AssignmentPage.assignmentEdit, "Assignment Edit", 10);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentEdit, "Assignment Edit");
		waiting(2);
		if(AssignmentPage.assignmentEditOption.isDisplayed())
		{
		clickObjectUsingJSExecutor(AssignmentPage.assignmentEditOption, "Assignment Edit Option");
		}else
		{
			clickObjectUsingJSExecutor(AssignmentPage.assignmentEditColleague, "Assignment Edit Option Colleague");
		}
		waitTillElementDisplayed(AssignmentPage.continueAssignment, "Continue", 5);
		waiting(5);
		clickObjectUsingJSExecutor(AssignmentPage.continueAssignment, "Continue");
	
	}
	public void AssignmentEditColleague() throws Exception
	{
		waitTillElementEnabled(AssignmentPage.assignmentEdit, "Assignment Edit", 10);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentEdit, "Assignment Edit");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentEditColleague, "Assignment Edit Option Colleague");
		waitTillElementDisplayed(AssignmentPage.continueAssignment, "Continue", 5);
		waiting(5);
		clickObjectUsingJSExecutor(AssignmentPage.continueAssignment, "Continue");
	}
	public void verifyEditStartAndDueDate(int inputDataRow) throws Exception
	{
		waitTillElementDisplayed(AssignmentPage.editStartDate, "Assignment Start Date", 5);
		clickObject(AssignmentPage.editStartDate,"Edit Start Date");
		waiting(2);
		typeAssignmentStartDate(inputDataRow);
		waiting(2);
		clickObject(AssignmentPage.editEndDate,"Edit End date");
	}
	public void verifyEditStartAndDueDateColleague() throws Exception
	{
		waiting(2);
		clickObject(AssignmentPage.editEndDate, "Edit End Date");
		waiting(3);
		clearNTypeValue(AssignmentPage.assignmentEndDate, "Change End Date", "02/21/2018");
		waiting(3);
		clearNTypeValue(AssignmentPage.assignmentEndTime, "Change End Time", "12:00a");
	}
	public void editAssignmentEndDate() throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.editEndDate, "Edit End Date");
	}
	
	public void checkOwnSectionAssignment() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		clickObject(AssignmentPage.switchSections, "Switch Sections");
		waiting(3);
		clickObject(AssignmentPage.sectionFirst, "Switching Sections");
		waiting(5);
		verifyElementDisplayed(AssignmentPage.selectAssignment(driver, strAssignmentTitle), true);
		
	}
	
	public void switchSections() throws Exception
	{
		clickObject(AssignmentPage.switchSections, "Switch Sections");
		waiting(3);
		clickObject(AssignmentPage.sectionFirst, "Switching Sections");
		waiting(5);
	}
	public void checkAssignmentStatusIndividually() throws Exception
	{
		String s=AssignmentPage.checkAssignmentStatusIndividually(driver, 3).getText();
		verifyTextEquals("not assigned", AssignmentPage.checkAssignmentStatusIndividually(driver, 3).getText(),"Assignment Status in Colleague after unassigning");
	}
	
	public void stopSharing() throws Exception
	{
		String colleagueSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName1");
		waiting(5);
		clickObjectUsingJSExecutor(AssignmentPage.selectSharedIcon(driver,4), "Shared Icon");
		waiting (5);
		clickObjectUsingJSExecutor(AssignmentPage.selectSetion(driver,colleagueSectionName, 1), "Stop Sharing Section");
		waitTillElementEnabled(AssignmentPage.stopSharing, "Stop Sharing", 2);
		clickObjectUsingJSExecutor(AssignmentPage.stopSharing, "Stop Sharing");
		waiting(3);
		clickObjectUsingJSExecutor(AssignmentPage.confirmStopSharing, "Confirm Stop Sharing");
		
	}
	
	public void selectAssignments() throws Exception
	{
		int intNumberOfAssignments = Integer.parseInt(AssignmentData.strDTSelectAssignments);
		for(int intAssignmnet=1; intAssignmnet<=intNumberOfAssignments; intAssignmnet++){
			clickObject(AssignmentPage.selectAssignments(driver,intAssignmnet), "Select Question "+intAssignmnet);
		}		
	}
	
	public void groupAssignments() throws Exception
	{
		clickObjectUsingJSExecutor(AssignmentPage.assignmentOptions, "Assignment Options");
	}
	
	public void checkGroupingofAssignments() throws Exception
	{
		String strAssignmentTitle = AssignmentData.strDTAssignmentTitle;
		clickObjectUsingJSExecutor(AssignmentPage.assignmentOptions, "Assignment Options");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.group,"Group");
		waiting(1);
		clickObjectUsingJSExecutor(AssignmentPage.add,"Add Group");
		waitTillElementDisplayed(AssignmentPage.groupName, "Group Name", 5);
		clearNTypeValue(AssignmentPage.groupName, "Group Name", "Group");
		clearNTypeValue(AssignmentPage.groupDesc, "Group Description", "AssignmentGroupDesc");
		clickObjectUsingJSExecutor(AssignmentPage.groupNameSave, "Save Group");
		waitTillElementDisplayed(AssignmentPage.expandGroup, "Group Name", 15);
		//clickObjectUsingJSExecutor(AssignmentPage.expandGroup, "Group");
		
		clickObjectUsingJSExecutor(AssignmentPage.expandGroup, "Expand New Created Group");
		waiting(3);
		clickObjectUsingJSExecutor(AssignmentPage.selectAssignments(driver, 2), "Assignment Selected to Move to Group");
		//dragAndDrop(AssignmentPage.dragAssignment,AssignmentPage.expandGroup);
		//verifyElementExist(AssignmentPage.checkGroupAssignment(driver, strAssignmentTitle), true);
		clickObjectUsingJSExecutor(AssignmentPage.moveAssignment, "Move Assignment");
		//dragAndDrop(AssignmentPage.checkGroupAssignment(driver, strAssignmentTitle),AssignmentPage.undoGroup);
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.selectGroup, "Move Assignment to Selected Group");
		//verifyElementExist(AssignmentPage.selectAssignment(driver, strAssignmentTitle), true);
		clickObjectUsingJSExecutor(AssignmentPage.save, "Save and move Assignment");
		waitTillElementDisplayed(AssignmentPage.expandGroup, "Group Name", 15);
		driver.navigate().refresh();
		waitTillElementDisplayed(AssignmentPage.expandGroup, "Group Name", 15);
		clickObjectUsingJSExecutor(AssignmentPage.expandGroup, "Expand New Created Group");
		verifyElementExist(AssignmentPage.checkGroupAssignment(driver, strAssignmentTitle), true);
		
		clickObjectUsingJSExecutor(AssignmentPage.selectAssignments(driver, 4), "Move Assignment to Unassigned Group");
		clickObjectUsingJSExecutor(AssignmentPage.moveAssignment, "Move Assignment");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.selectGroup, "Move Assignment ");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.moveAssignmentToUnassignedGroup, "Move Assignment to Unassigned Group");
		clickObjectUsingJSExecutor(AssignmentPage.save, "Save and move Assignment to Unassigned Group");
		waitTillElementDisplayed(AssignmentPage.expandGroup, "Group Name", 15);
		waiting(5);
	}
	
	public void copyAndEditAssignment() throws Exception
	{
		String strAssignmentName=AssignmentData.strDTAssignmentTitle;
		clickObjectUsingJSExecutor(AssignmentPage.selectAssignments(driver, 2), "Assignment Selected to Move to Group");
		clickObjectUsingJSExecutor(AssignmentPage.assignmentOptions, "Assignment Options");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.assignmentOptions, "Assignment Options");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.Copy, "Copy");
		waitTillElementDisplayed(AssignmentPage.wantCopy, "Want a Copy", 5);
		clickObjectUsingJSExecutor(AssignmentPage.wantCopy, "Want a Copy");
		waitTillElementDisplayed(AssignmentPage.clickCopyButton, "Copy Button", 10);
		CopyToOwnSection(1);
		waiting(1);
		clickObject(AssignmentPage.clickCopyButton, "Got a Copy");
		//clickObjectUsingJSExecutor(AssignmentPage.clickCopyButton, "Got a Copy");
		waitTillElementDisplayed(AssignmentPage.selectDuplicateAssignment(driver, 3,strAssignmentName ), "Assignment Loaded", 20);
		clickObjectUsingJSExecutor(AssignmentPage.selectDuplicateAssignment(driver, 3,strAssignmentName ), "Copied Assignment");
		AssignmentEdit();
		
	}
	
	public void deleteAssignmentCopy() throws Exception
	{
	
		clickObjectUsingJSExecutor(AssignmentPage.selectAssignments(driver, 3), "Assignment Copy");
		clickObjectUsingJSExecutor(AssignmentPage.assignmentOptions, "Assignment Options");
		waiting(2);
		clickObjectUsingJSExecutor(AssignmentPage.deleteAssignment, "Delete Assignment Options");
		waitTillElementDisplayed(AssignmentPage.deleteAssignmentConfirm, "Delete Assignment Confirmation", 10);
		waiting(3);
		clickObjectUsingJSExecutor(AssignmentPage.deleteAssignmentConfirm, "Delete Assignment Confirm");
		waiting(3);
		}
	
	public void dragAndDrop(WebElement source, WebElement target)
	{
		Actions move = new Actions(driver);
		Action dragAndDrop = move.clickAndHold(source)
				   .moveToElement(target)
				   .release(target)
				   .build();
		dragAndDrop.perform();
	}
	
	
	public void checkPolicyPreview(String AssignmentType) throws Exception
	{
		
		
		if(AssignmentType=="HomeWork" || AssignmentType=="Practice")
		{
			waitTillElementDisplayed(AssignmentPage.policyPreviewTimeLimit, "No time Limit", 6);
			verifyTextEquals(AssignmentPage.policyPreviewTimeLimit.getText(),"No time Limit","Basic Policy Printing");
			String print=AssignmentPage.policyPreviewreviewPrinting.getText();
			System.out.println(print);
		
			verifyTextEquals(print, "Printing is allowed", "Basic Policy Printing");
			verifyTextEquals(AssignmentPage.policyPreviewreviewQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
			verifyTextEquals(AssignmentPage.policyPreviewreviewPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
			verifyTextEquals(AssignmentPage.policyPreviewreviewCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
			
			verifyTextEquals(AssignmentPage.policyPreviewreviewBOPA.getText(),"Unlimited attempts are allowed","Attempts Policy Attempts");
			verifyTextEquals(AssignmentPage.policyPreviewreviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
		
//PROD	//	verifyTextEquals(AssignmentPage.policyPreviewreviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
		//	verifyTextEquals(AssignmentPage.policyPreviewreviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
		//	verifyTextEquals(AssignmentPage.policyPreviewreviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
			
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewQuestionPointValue.getText(),"Question point values are shown","Resource Policy Question Point Value");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewQuestionTitle.getText(),"Question titles are not shown","Resource Policy Question Title");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewReference.getText(),"References are shown","Resource Policy References");
	//		verifyTextEquals(AssignmentPage.policyPreviewreviewreviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
	//		verifyTextEquals(AssignmentPage.policyPreviewreviewreviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
			
	//		verifyTextEquals(AssignmentPage.policyPreviewrevieweBookAssitantDeductions.getText(),"0%","Resource Policy EBook Deductions");
			verifyTextEquals(AssignmentPage.policyPreviewreviewHintsDeductions.getText(),"0%","Resource Policy Hints Deductions");
	//		verifyTextEquals(AssignmentPage.policyPreviewreviewUsesofCheckMyWork.getText(),"0","Resource Policy CheckMyWork Uses per Question");
	//		verifyTextEquals(AssignmentPage.policyPreviewrevieweCheckMyWorkDeductions.getText(),"0%","Resource Policy CheckMyWork Uses Deduction");
			
	//PROD	verifyTextEquals(AssignmentPage.policyPreviewreviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
	//		verifyTextEquals(AssignmentPage.policyPreviewreviewGuidedSolutions.getText(),"Guided solutions are allowed","Resource Policy Guided solutions");
			verifyTextEquals(AssignmentPage.policyPreviewreviewAskToInstructor.getText(),"Access to \"ask the instructor\" is not allowed","Resource Policy ask Instructor");
	//		verifyTextEquals(AssignmentPage.policyPreviewreviewPracticeQuestions.getText(),"Practice questions are allowed","Resource Policy Practice Questions");
			if(AssignmentType=="HomeWork")
			{
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterFirstAttempt.getText(),"Detailed feedback","Feedback Policy After First Attempt");
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterAdditionalAttempt.getText(),"Detailed feedback","Feedback Policy After Additional Attempts");
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterFullScore.getText(),"Detailed feedback","Feedback Policy After Full Score");
		//	verifyTextEquals(AssignmentPage.reviewFeedbackDueDate.getText(),"Feedback shown on due date","Feedback Policy Due Date");
			}else
			{
				verifyTextEquals(AssignmentPage.reviewPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterAdditionalAttempt.getText(),"- question score","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFullScore.getText(),"- solution","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewPalleteDisplay.getText(),"- correct answer","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedback.getText(),"- explanation (when available)","FeddBack Policy After each Question");
			}
			
			if(AssignmentType=="Quiz" || AssignmentType=="Exam")
			{
				verifyTextEquals(AssignmentPage.policyPreviewPrintingOff.getText(),"No time Limit","Basic Policy Printing");
				verifyTextEquals(print, "Printing is not allowed", "Basic Policy Printing");
				verifyTextEquals(AssignmentPage.reviewQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
				verifyTextEquals(AssignmentPage.reviewPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
				verifyTextEquals(AssignmentPage.reviewCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
				
				verifyTextEquals(AssignmentPage.reviewBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
				verifyTextEquals(AssignmentPage.reviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
			
		//		verifyTextEquals(AssignmentPage.reviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
		//		verifyTextEquals(AssignmentPage.reviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
		//		verifyTextEquals(AssignmentPage.reviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
				
				verifyTextEquals(AssignmentPage.reviewQuestionPointValueOff.getText(),"Question titles are not shown","Resource Policy Question Point Value");
				verifyTextEquals(AssignmentPage.reviewQuestionTitle.getText(),"Question point values are not shown","Resource Policy Question Title");
				verifyTextEquals(AssignmentPage.reviewReference.getText(),"References are not shown","Resource Policy References");
		//		verifyTextEquals(AssignmentPage.reviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
		//		verifyTextEquals(AssignmentPage.reviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
				
				verifyTextEquals(AssignmentPage.policyPreviewreviewEbookQuiz.getText(),"Access to the eBook and resources is not allowed","Resource Policy Ebook");
				verifyTextEquals(AssignmentPage.policyPreviewreviewHintsQuiz.getText(),"Access to hints is not allowed","Resource Policy Hints");
				verifyTextEquals(AssignmentPage.policyPreviewreviewcheckWorkQuiz.getText(),"Access to check my work is not allowed","Resource Policy CheckMyWork");
				
		//		verifyTextEquals(AssignmentPage.reviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
		//		verifyTextEquals(AssignmentPage.policyPreviewGuidedSolutionsOff.getText(),"Guided solutions are not allowed","Resource Policy Guided solutions");
				verifyTextEquals(AssignmentPage.reviewAskToInstructor.getText(),"Access to '\"ask the instructor'\" is not allowed","Resource Policy ask Instructor");
		//		verifyTextEquals(AssignmentPage.policyPreviewPracticeQuestionsOff.getText(),"Practice questions are not allowed","Resource Policy Practice Questions");
				verifyTextEquals(AssignmentPage.policyPreviewForeignPalleteOff.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				
				if(AssignmentType=="Quiz")
				{
					verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFirstAttempt.getText(),"Total scores only", "Feedback Policy After submitting attempt");
					
				}else if(AssignmentType=="Exam")
				{
					verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFirstAttempt.getText(),"No feedback", "Feedback Policy After submitting attempt");
				}
			}
		}
	}
	
	public void verifyReportsPolicy(String AssignmentType) throws Exception
	{
		
		if(AssignmentType=="HomeWork" || AssignmentType=="Practice")
		{
			verifyTextEquals(AssignmentPage.timeLimitReportsPage.getText(),"No time Limit","Basic Policy Printing");
			String print=AssignmentPage.printingReportsPage.getText();
			System.out.println(print);
		
			verifyTextEquals(print, "Printing is allowed", "Basic Policy Printing");
			verifyTextEquals(AssignmentPage.QuestionOrderReportsPage.getText(),"Questions are ordered","Basic Policy Scramble");
			verifyTextEquals(AssignmentPage.passwordReportsPage.getText(),"Not password protected","Basic Policy Password protect");
			verifyTextEquals(AssignmentPage.creditReportsPage.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
			
			verifyTextEquals(AssignmentPage.policyPreviewreviewBOPA.getText(),"Unlimited attempts are allowed","Attempts Policy Attempts");
			verifyTextEquals(AssignmentPage.policyPreviewreviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
		
			verifyTextEquals(AssignmentPage.policyPreviewreviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
			verifyTextEquals(AssignmentPage.policyPreviewreviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
			verifyTextEquals(AssignmentPage.policyPreviewreviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
			
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewQuestionPointValue.getText(),"Question point values are shown","Resource Policy Question Point Value");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewQuestionTitle.getText(),"Question titles are not shown","Resource Policy Question Title");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewReference.getText(),"References are shown","Resource Policy References");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
			verifyTextEquals(AssignmentPage.policyPreviewreviewreviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
			
			verifyTextEquals(AssignmentPage.policyPreviewrevieweBookAssitantDeductions.getText(),"0%","Resource Policy EBook Deductions");
			verifyTextEquals(AssignmentPage.policyPreviewreviewHintsDeductions.getText(),"0%","Resource Policy Hints Deductions");
			verifyTextEquals(AssignmentPage.policyPreviewreviewUsesofCheckMyWork.getText(),"0","Resource Policy CheckMyWork Uses per Question");
			verifyTextEquals(AssignmentPage.policyPreviewrevieweCheckMyWorkDeductions.getText(),"0%","Resource Policy CheckMyWork Uses Deduction");
			
			verifyTextEquals(AssignmentPage.policyPreviewreviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
			verifyTextEquals(AssignmentPage.policyPreviewreviewGuidedSolutions.getText(),"Guided solutions are allowed","Resource Policy Guided solutions");
			verifyTextEquals(AssignmentPage.policyPreviewreviewAskToInstructor.getText(),"Access to \"ask the instructor\" is not allowed","Resource Policy ask Instructor");
			verifyTextEquals(AssignmentPage.policyPreviewreviewPracticeQuestions.getText(),"Practice questions are allowed","Resource Policy Practice Questions");
			if(AssignmentType=="HomeWork")
			{
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterFirstAttempt.getText(),"Detailed feedback","Feedback Policy After First Attempt");
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterAdditionalAttempt.getText(),"Detailed feedback","Feedback Policy After Additional Attempts");
			verifyTextEquals(AssignmentPage.policyPreviewreviewFeedBackAfterFullScore.getText(),"Detailed feedback","Feedback Policy After Full Score");
		//	verifyTextEquals(AssignmentPage.reviewFeedbackDueDate.getText(),"Feedback shown on due date","Feedback Policy Due Date");
			}else
			{
				verifyTextEquals(AssignmentPage.reviewPalleteDisplay.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterAdditionalAttempt.getText(),"- question score","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFullScore.getText(),"- solution","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewPalleteDisplay.getText(),"- correct answer","FeddBack Policy After each Question");
				verifyTextEquals(AssignmentPage.policyPreviewreviewFeedback.getText(),"- explanation (when available)","FeddBack Policy After each Question");
			}
			
			if(AssignmentType=="Quiz" || AssignmentType=="Exam")
			{
				verifyTextEquals(AssignmentPage.policyPreviewPrintingOff.getText(),"No time Limit","Basic Policy Printing");
				verifyTextEquals(print, "Printing is not allowed", "Basic Policy Printing");
				verifyTextEquals(AssignmentPage.reviewQuestionOrder.getText(),"Questions are ordered","Basic Policy Scramble");
				verifyTextEquals(AssignmentPage.reviewPasswordProtect.getText(),"Not password protected","Basic Policy Password protect");
				verifyTextEquals(AssignmentPage.reviewCreditGiven.getText(),"Credit is given for accuracy","Basic Policy Full Credit");
				
				verifyTextEquals(AssignmentPage.reviewBOPA.getText(),"On each new attempt, students start over","Attempts Policy Attempts");
				verifyTextEquals(AssignmentPage.reviewStudentAttempts.getText(),"Study attempts are not allowed","Attempts Policy Study Attempts");
			
				verifyTextEquals(AssignmentPage.reviewAscentedCharacters.getText(),"Accented characters are required","Tolerance Policy Ascented Characters");
				verifyTextEquals(AssignmentPage.reviewpunctuations.getText(),"Correct spacing and punctuation are required","Tolerance Policy Punctuation and Spacing");
				verifyTextEquals(AssignmentPage.reviewCase.getText(),"Correct letter case is required","Tolerance Policy Case");
				
				verifyTextEquals(AssignmentPage.reviewQuestionPointValueOff.getText(),"Question titles are not shown","Resource Policy Question Point Value");
				verifyTextEquals(AssignmentPage.reviewQuestionTitle.getText(),"Question point values are not shown","Resource Policy Question Title");
				verifyTextEquals(AssignmentPage.reviewReference.getText(),"References are not shown","Resource Policy References");
				verifyTextEquals(AssignmentPage.reviewExternalLinks.getText(),"Access to external links is allowed","Resource Policy External Links");
				verifyTextEquals(AssignmentPage.reviewFormulas.getText(),"Formulas are shown","Resource Policy Formulas");
				
				verifyTextEquals(AssignmentPage.policyPreviewreviewEbookQuiz.getText(),"Access to the eBook and resources is not allowed","Resource Policy Ebook");
				verifyTextEquals(AssignmentPage.policyPreviewreviewHintsQuiz.getText(),"Access to hints is not allowed","Resource Policy Hints");
				verifyTextEquals(AssignmentPage.policyPreviewreviewcheckWorkQuiz.getText(),"Access to check my work is not allowed","Resource Policy CheckMyWork");
				
				verifyTextEquals(AssignmentPage.reviewSolutions.getText(),"Show solutions and answers","Resource Policy solutions and answers");
				verifyTextEquals(AssignmentPage.policyPreviewGuidedSolutionsOff.getText(),"Guided solutions are not allowed","Resource Policy Guided solutions");
				verifyTextEquals(AssignmentPage.reviewAskToInstructor.getText(),"Access to '\"ask the instructor'\" is not allowed","Resource Policy ask Instructor");
				verifyTextEquals(AssignmentPage.policyPreviewPracticeQuestionsOff.getText(),"Practice questions are not allowed","Resource Policy Practice Questions");
				verifyTextEquals(AssignmentPage.policyPreviewForeignPalleteOff.getText(),"The foreign language character palette is not shown","Resource Policy Foreign Language");
				
				if(AssignmentType=="Quiz")
				{
					verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFirstAttempt.getText(),"Total scores only", "Feedback Policy After submitting attempt");
					
				}else if(AssignmentType=="Exam")
				{
					verifyTextEquals(AssignmentPage.policyPreviewreviewFeedbackafterFirstAttempt.getText(),"No feedback", "Feedback Policy After submitting attempt");
				}
			}
		}
	}
	
	public void checkQuestionTitlesinAddQuestionsTab()
	{
		int intNumberOfQuestions=Integer.parseInt(AssignmentData.strDTSelectQuestions);
		for(int intQuestion=1;intQuestion<=intNumberOfQuestions;intQuestion++)
		{
			String title=AssignmentPage.questionTypes(driver, intQuestion).getText();
			System.out.println("Title for "+intQuestion+ " Question is " +title);
			Assert.assertTrue(title!="WWTB", "Question "+intQuestion+" doesnt contain WWTB");
		}
	}
	
	public void checkQuestionTitlesinOrganizeTab()
	{
		int intNumberOfQuestions=Integer.parseInt(AssignmentData.strDTSelectQuestions);
		for(int intQuestion=1;intQuestion<=intNumberOfQuestions;intQuestion++)
		{
			String title=AssignmentPage.questionTypesOrganizeTab(driver, intQuestion).getText();
			System.out.println("Title for "+intQuestion+ " Question in Organize Tab is " +title);
			Assert.assertTrue(title!="WWTB", "Question "+intQuestion+" in organize tab doesnt contain WWTB");
		}

	}
	
	public void selectQuestion(int questionNumber) throws Exception
	{		
		clickObject(AssignmentPage.questionNavigator, "Question Navigator");
		waiting(2);
		clickObject(AssignmentPage.question(driver,questionNumber), "Question Number "+questionNumber);
		waiting(2);
	}
	
	public List<WebElement> selectQuestionNavInsPrev() throws Exception{
		waiting(2);
		waitTillElementEnabled(AssignmentPage.questionNavigator, "Question Navigator", 20);
		clickObject(AssignmentPage.questionNavigator, "Question Navigator");
		waiting(2);
		
		return AssignmentPage.insPrevQuestionList(driver);
	}
	
	//NEw Code Nov 18 TCS
	
		public void verifyInsPreview() throws Exception
		{
			try{
			waitTillElementDisplayed(AssignmentPage.lnkPreview, "Instructor Preview", 15);
			waiting(3);
			clickObject(AssignmentPage.lnkPreview, "Instructor Preview");
			waiting(2);
			switchToPreviewPage();
			List<WebElement> insPrevQuestionList = selectQuestionNavInsPrev();
			int insPrevQuestionListSize = insPrevQuestionList.size();
			System.out.println("Instructor Preview Question List Size: " + insPrevQuestionListSize);
			
			for (int i = 1; i <= insPrevQuestionListSize; i++) {

				waitTillElementDisplayed(AssignmentPage.questionTitleIns, "Question Title", 10);
				String questionTitle = AssignmentPage.questionTitleIns.getText();
				objHTMLFunctions.ReportPassFail(
						"Page loaded correctly and Title of Question " + i + " is " + questionTitle, "True", "True");
				if (i == insPrevQuestionListSize) {
					break;
				} else {
					waiting(5);
					waitTillElementEnabled(AssignmentPage.lnkNextArrowIns, "Next Question", 10);
				//	waiting(5);
					waitTillElementDisplayed(AssignmentPage.lnkNextArrowIns, "Next Question", 10);
					clickObject(AssignmentPage.lnkNextArrowIns, "Next Question");
					waiting(2);

				}
			}
			
			/*
			 * for(int i=1;i<=Integer.parseInt(AssignmentData.strDTSelectQuestions);i++) {
			 * waitTillElementDisplayed(AssignmentPage.questionTitleIns, "Question Title",
			 * 10); String questionTitle=AssignmentPage.questionTitleIns.getText();
			 * objHTMLFunctions.
			 * ReportPassFail("Page loaded correctly and Title of Question " + i + " is "
			 * +questionTitle, "True", "True");
			 * if(i==Integer.parseInt(AssignmentData.strDTSelectQuestions)) { break; }else {
			 * waiting(3); waitTillElementEnabled(AssignmentPage.lnkNextArrowIns,
			 * "Next Question", 10); waiting(5);
			 * waitTillElementDisplayed(AssignmentPage.lnkNextArrowIns, "Next Question",
			 * 10); clickObject(AssignmentPage.lnkNextArrowIns, "Next Question");
			 * waiting(2);
			 * 
			 * } }
			 */
			 
			switchToDefaultPage();
			
			clickObject(AssignmentPage.lnksectionHome, "Section Home");
		}catch(Exception e)
			{
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(e, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Element  Next Question couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
			
				switchToDefaultPage();
				
				clickObject(AssignmentPage.lnksectionHome, "Section Home");
			}
		}
		
		//Student Preview
		public void clickStudentPreview() throws Exception
		{
			waitTillElementEnabled(AssignmentPage.studentView, "Student Preview", 10);
			clickObject(AssignmentPage.studentView, "Student View");
				
		}
		public void selectAssignmentStudentPreview(int num) throws Exception
		{
			waitTillElementDisplayed(AssignmentPage.selectAssignmentStudentPreview(driver, num), "Assignment Student Preview", 5);
			clickObject(AssignmentPage.selectAssignmentStudentPreview(driver, num), "Assignment Student Preview");
			if(waitTillElementDisplayed(AssignmentPage.timedMessage, "Timed message", 2))
			{
				String TimedAssignment=AssignmentData.strDTAssignmentTitle;	
				
				String actualText=AssignmentPage.timedMessage.getText();
				
				verifyTextEquals(AssignmentPage.timedMessage.getText(),"\""+TimedAssignment+"\""+ " has a time limit of 10 minutes. If you don't submit the assignment before the time limit, it will be submitted to the instructor automatically. The time begins once you click Start Assignment and can't be paused.",
						"Timed Message shown");
				clickObject(AssignmentPage.startAssignmentStdPreview,"Start Assignment");
			}
			if(waitTillElementDisplayed(AssignmentPage.enterPassword, "Password Field", 2))
			{
				clickObject(AssignmentPage.enterPassword,"Password Field");
				clearNTypeValue(AssignmentPage.enterPassword, "Enter Password", AssignmentData.strDTPassword);
				clickObject(AssignmentPage.submitPassword,"Submit Password");
			}
			
		}
		
		public void startAndAnswerFeedBackAssignment() throws Exception
		{
			waitTillElementEnabled(AssignmentPage.takeAssignmentStdPreview, "Go Button", 10);
			clickObject(AssignmentPage.takeAssignmentStdPreview, "Go Button");
			waitTillElementEnabled(AssignmentPage.questionNavigatorStdPreview, "Question", 10);
		
			
			//Q1 Matching
		//	macthingAnswer();
			answerMatchingQuestionNative();
			scoreQuestion();
			
			
			//Q2 Ranking
			RankingAnswer();
			scoreThisQuestionAndContinue();
			
			//Q3 fill in the blanks
			fillInTheBlanks();
			scoreQuestion();
			
					
			//Q4 Essay
			essay();
			scoreQuestion();
			
					
			//Q5 TrueOrFalse
			TrueOrFalse();
			scoreQuestion();
			
					
			//Q6 Short Answer
			essay();
			scoreQuestion();
			
					
			//Q7 Random
			random();
			scoreQuestion();
			
			waiting(3);
		//	answerWorsheet();
			scoreLastQuestion();
		//	scoreQuestion();
			waiting(2);
			
					
			//scoreThisQuestionAndContinue();
					
			//submitThisAssignment();
			clickSubmit();
			waiting(1);
			clickConfirmSubmit();
			returnToHome();
			
			
		}

		public Boolean startAndAnswerAssignment() throws Exception {
			try {
				waitTillElementEnabled(AssignmentPage.takeAssignmentStdPreview, "Go Button", 10);
				clickObject(AssignmentPage.takeAssignmentStdPreview, "Go Button");
				waitTillElementEnabled(AssignmentPage.questionNavigatorStdPreview, "Question", 10);
				
				int questionQuantity = Integer.parseInt(AssignmentData.strDTSelectQuestions);

				for (int i = 0; i <= questionQuantity; i++) {
					// Q1 Matching
					if (AssignmentPage.questionTitles.getText().contains("Matching")) {
						// macthingAnswer();
						answerMatchingQuestionNative();
						
					} else if (AssignmentPage.questionTitles.getText().contains("Ranking")) {
						// Q2 Ranking
						RankingAnswer();
						
					} else if (AssignmentPage.questionTitles.getText().contains("Fill")) {
						// Q3 fill in the blanks
						fillInTheBlanks();
						
					} else if (AssignmentPage.questionTitles.getText().contains("Short")) {

						// Q4 Essay
						essay();
						
					} else if (AssignmentPage.questionTitles.getText().contains("true")) {

						// Q5 TrueOrFalse
						TrueOrFalse();
						
					} else if (AssignmentPage.questionTitles.getText().contains("Essay")) {

						// Q6 Short Answer
						essay();
						
					} else if (AssignmentPage.questionTitles.getText().contains("Numeric")) {

						// Q7 Random
						random();
						
					} else {
						answerWorsheet();
					}
					
					if(i < questionQuantity - 1) {
						nextQuestion();
					}
				}
				// scoreThisQuestionAndContinue();

				// submitThisAssignment();
				clickSubmit();
				waiting(1.5);
				clickSubmitAnyway();
				returnToHome();

				return Boolean.valueOf(true);
			} catch (Exception e) {
				this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(e, true);
				this.objHTMLFunctions.reportPassFailToATU(
						AssignmentPage.questionTitles + " couldn't be clicked. <br> Error message=>" + this.strErrorMsg,
						"true", "false");
			}
			return Boolean.valueOf(false);
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
		
		//Answer Q1 Matching
				public void macthingAnswer() throws Exception {
					
					try{
					waitTillElementDisplayed(AssignmentPage.selectOptionMatchingText(driver, 1), "Select Option", 10);
					String s = AssignmentPage.selectOptionMatchingText(driver, 1).getText();
					String t=AssignmentPage.selectOptionMatchingText(driver, 2).getText();
					String x=AssignmentPage.selectOptionMatchingClassicText(driver, 1).getText();
					String z=AssignmentPage.selectOptionMatchingClassicText(driver, 2).getText();
					if((AssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("kolkata") && (AssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("west"))))
					{
						clickObject(AssignmentPage.selectOptionButton(driver, 1), "Select First Match");
						waiting(2);
						clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,1,2), "Select First Option");
						waiting(2);
					}else if((AssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("Delhi") && (AssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("west"))))
					{
						clickObject(AssignmentPage.selectOptionButton(driver, 1), "Select First Match");
						waiting(2);
						clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,1,3), "Select First Option");
						waiting(2);
					}else if((AssignmentPage.selectOptionMatchingText(driver, 1).getText().contains("Delhi") && (AssignmentPage.selectOptionMatchingClassicText(driver, 1).getText().contains("India"))))
					{
						clickObject(AssignmentPage.selectOptionButton(driver, 1), "Select First Match");
						waiting(2);
						clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,1,2), "Select First Option");
						waiting(2);
					}else
					{
						clickObject(AssignmentPage.selectOptionButton(driver, 1), "Select First Match");
						waiting(2);
						clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,1,3), "Select First Option");
						waiting(2);
					}
					waiting(3);
					if((AssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("Delhi") && (AssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("India"))))
						{
					//	clickObject(AssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
						waiting(2);
						clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,2,3), "Select First Option");
						waiting(2);
						}else if((AssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("kolkata") && (AssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("India"))))
							{
						//	clickObject(AssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
							waiting(2);
							clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,2,2), "Select First Option");
							waiting(2);
							}else if((AssignmentPage.selectOptionMatchingText(driver, 2).getText().contains("kolkata") && (AssignmentPage.selectOptionMatchingClassicText(driver, 2).getText().contains("west"))))
							{
						//	clickObject(AssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
							waiting(2);
							clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,2,3), "Select First Option");
							waiting(2);
							}else
							{
						//	clickObject(AssignmentPage.selectOptionButton(driver, 2), "Select Second Match");
							waiting(2);
							clickObjectUsingJSExecutor(AssignmentPage.selectOptionMatchingClassicButton(driver,2,2), "Select First Option");
							waiting(2);
							}
					}catch(Exception e)
					{
						returnToHome();
						this.objHTMLFunctions.reportPassFailToATU(
								 "Matching Answer Student Preview couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
					}
					
					}
		public void RankingAnswer() throws Exception {
			try{
			List<WebElement> rankingOptions = AssignmentPage.rankingOptionsNew;
			waitTillElementDisplayed(AssignmentPage.selectOptionRanking(driver, 1), "Select Option", 10);
			for (int i = 1; i <=rankingOptions.size(); i++) {
				waiting(1.5);
				if (AssignmentPage.rankingOptionsText(driver,i).getText().contains("Punjab")) {
					clickObject(AssignmentPage.selectOptionRanking(driver, i), "Select First Rank");
					waiting(2);
					clickObjectUsingJSExecutor(AssignmentPage.selectRankingAnswer1(driver,3),
							"Select Fifth Option");
					waiting(2);
				} else if (AssignmentPage.rankingOptionsText(driver,i).getText().contains("Tamil")) {
					clickObject(AssignmentPage.selectOptionRanking(driver, i), "Select First Rank");
					waiting(2);
					clickObjectUsingJSExecutor(AssignmentPage.selectRankingAnswer1(driver, 6),
							"Select Fifth Option");
					waiting(2);
				} else if (AssignmentPage.rankingOptionsText(driver,i).getText().contains("Jammu")) {
					clickObject(AssignmentPage.selectOptionRanking(driver, i), "Select First Rank");
					waiting(2);
					clickObjectUsingJSExecutor(AssignmentPage.selectRankingAnswer1(driver, 2),
							"Select Fifth Option");
					waiting(2);
				} else if (AssignmentPage.rankingOptionsText(driver,i).getText().contains("Delhi")) {
					clickObject(AssignmentPage.selectOptionRanking(driver, i), "Select First Rank");
					waiting(2);
					clickObjectUsingJSExecutor(AssignmentPage.selectRankingAnswer1(driver, 4),
							"Select Fifth Option");
					waiting(2);
				} else if (AssignmentPage.rankingOptionsText(driver,i).getText().contains("Kolkata")) {
					clickObject(AssignmentPage.selectOptionRanking(driver, i), "Select First Rank");
					waiting(2);
					clickObjectUsingJSExecutor(AssignmentPage.selectRankingAnswer1(driver, 5),
							"Select Fifth Option");
					waiting(2);
				}
			}
			}catch(Exception e)
			{
				returnToHome();
				this.objHTMLFunctions.reportPassFailToATU(
						 "Ranking Answer Student Preview couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
			}
		}
		
		public Boolean scoreQuestion() throws Exception {
		try{
		if(waitTillElementEnabled(AssignmentPage.scoreTheQuestion, "Score Answer", 1))
			clickObject(AssignmentPage.scoreTheQuestion, "Score Answer");
			waiting(1);
			/*clickObject(AssignmentPage.continueAnyway, "Score Answer");
			waiting(2);*/
			nextQuestion();
			return Boolean.valueOf(true);
			
		}catch(Exception e)
		{
			nextQuestion();
			return Boolean.valueOf(false);
		}
		}
		
		public Boolean scoreLastQuestion() throws Exception {
			try{
			if(waitTillElementEnabled(AssignmentPage.scoreTheQuestion, "Score Answer", 1))
				clickObject(AssignmentPage.scoreTheQuestion, "Score Answer");
				waiting(1);
				/*clickObject(AssignmentPage.continueAnyway, "Score Answer");
				waiting(2);*/
			//	nextQuestion();
				return Boolean.valueOf(true);
				
			}catch(Exception e)
			{
				nextQuestion();
				return Boolean.valueOf(false);
			}
			}
		
		public void nextQuestion() throws Exception {
			
			waiting(2);
			clickNextQuestion();
		}
		public void clickNextQuestion() throws Exception {
			clickObject(AssignmentPage.nextQuestionStdPreview, "Next Question");
		}
		
		public void fillInTheBlanks() throws Exception {
			waitTillElementDisplayed(AssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", 10);
			typeValue(AssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", "Delhi");
		}
		
		public void random() throws Exception {
			/*waitTillElementDisplayed(AssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", 10);
			String randomvalues = AssignmentPage.randomVariable.getText();
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
			// waitTillElementDisplayed(AssignmentPage.fillInTheBlanksAnswer,
			// "Fill in the Blanks",10);
			typeValue(AssignmentPage.fillInTheBlanksAnswer, "Fill in the Blanks", cal);*/
			
			try{
				
	
			waitTillElementDisplayed(AssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", 10);
			
			String randomvalues = AssignmentPage.randomVariable.getText();
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
			// waitTillElementDisplayed(AssignmentPage.fillInTheBlanksAnswer,
			// "Fill in the Blanks",10);
			typeValue(AssignmentPage.fillInTheBlanksAnswers, "Fill in the Blanks", cal);
		}catch(Exception e)
		{
			returnToHome();
			this.objHTMLFunctions.reportPassFailToATU(
					 "Random variable Answer Student Preview couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		}
		public void essay() throws Exception {
			/*switchiFrame();
			clickObject(AssignmentPage.essayAnswer, "Enter essay answer");
			typeValueUsingActionBuilder(AssignmentPage.essayAnswer, "Instructor has to manually grade");
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
			try{
			waitTillElementDisplayed(AssignmentPage.trueorfalseNew, "trueorfalse", 10);
			clickObject(AssignmentPage.trueorfalseNew, "trueorfalse Answer");
			waiting(2);
		}catch(Exception e)
		{
			returnToHome();
			this.objHTMLFunctions.reportPassFailToATU(
					 "True Answer Student Preview couldn't be clicked. <br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		}
		public void clickSubmit() throws Exception {
			waitTillElementEnabled(AssignmentPage.submitAssignment, "Submit Assignment", 6);
		//	clickObject(AssignmentPage.submitAssignment, "Submit Assignment");
			clickObjectUsingJSExecutor(AssignmentPage.submitAssignment, "Submit Assignment");
		}
		public void clickSubmitAnyway() throws Exception {
			clickObject(AssignmentPage.submitAssignmentAnyway, "Submit Assignment");
		}
		public void clickConfirmSubmit() throws Exception {
			waitTillElementEnabled(AssignmentPage.confirmSubmit, "Confirm Submit", 6);
			clickObject(AssignmentPage.confirmSubmit, "Confirm Submit");
		}
		
		public void returnToHome() throws Exception
		{
			waitTillElementDisplayed(AssignmentPage.closeStudentPreview	, "Student Preview", 10);
			clickObject(AssignmentPage.closeStudentPreview,"Return to Instructor Preview");
			waitTillElementEnabled(AssignmentPage.myCourses,"My Course Section Home",10);
		}
		public void clickContinueAnyway() throws Exception {
			
			if(waitTillElementEnabled(AssignmentPage.continueAnyway, "Continue Anyway", 1))
			{
			clickObject(AssignmentPage.continueAnyway, "Continue Anyway");
			}
		}
		
		
		public void scoreThisQuestionAndContinue() throws Exception
		{
			scoreQuestion();
			clickContinueAnyway();
			
		}
		
		public void clickOnMyCoursesLink() throws Exception {
			switchToDefaultPage();
			waitTillElementEnabled(AssignmentPage.myCoursesLink, "My Courses Link", 10);
			waiting(2);
			clickObject(AssignmentPage.myCoursesLink, "My Courses Link");
		}
		
	public void duplicatingSectionNEdit() {
		
	}
	
	public void getSectionAddressNStoreInXL(int number) throws Exception {
		try {
			String StudentUrl = StudentRegData.strDTRegistrationURL;
			waitTillElementEnabled(AssignmentPage.sectionAddress, "Section web address", 15);
		String secAddress = AssignmentPage.sectionAddress.getAttribute("value");
		
	//	fetchData.storeDataToExcel(secAddress);
		storeRuntimeGlobalVariable("WebAddress" + number, secAddress.split(StudentUrl)[1]);
		
		objHTMLFunctions.ReportPassFail("Section web address stored in excel: true", "true", "true");
	//	ATUReports.add("Section web address stored in excel :" + "true", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		}catch(Exception e) {
	//		ATUReports.add("Section web address stored in excel :" + "false " + e.getMessage(), LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Section web address stored in excel: false", "true", "true");
		}
	}
	
	}

