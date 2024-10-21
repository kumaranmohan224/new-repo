package com.newdemo.framework.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.GlobalPaths;

public class CreateAssignmentData extends CommonFunctions
{	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTQuestionSource = "";
	public String strDTTestContent = "";
	public String strDTAssignmentTitleTemplate = "";
	public String strDTAssignmentTitle = "";
	public String strDTInstructions = "";
	public String strDTSelectQuestions = "";
	public String strDTQuestionsPoolName = "";
	public String strDTDrawQuestions = "";
	public String strDTAssignmentQuestions = "";
	
	public String strDTAssignmentStartDate = "";
	public String strDTAssignmentStartTime = "";
	public String strDTAssignmentEndDate = "";
	public String strDTAssignmentEndTime = "";	
	
	public String strDTCheckLateSubmissionDeduction = "";
	public String strDTLateSubmitDeduction = "";
	public String strDTLateSubmitDedType = "";
	public String strDTForceSubmit = "";				
	
	public String strDTAssignmentType = "";
	public String strDTAllowTimeLimit = "";
	public String strDTTimeLimit = "";
	public String strDTScrambleQuestions = "";
	public String strDTAllowPrinting = "";
	public String strDTAddPassword = "";
	public String strDTPassword = "";
	public String strDTAutomaticFullCredit = "";
	
	public String strDTAttemptsAllowed = "";
	public String strDTAttemptOption = "";
	public String strDTRevisePreviousAttempt = "";
	public String strDTCheckDeductionForAttempt = "";
	public String strDTDeductionForAttempt = "";
	public String strDTCompoundDeduction = "";	
	
	public String strDTIgnoreAccents = "";
	public String strDTIgnoreSpacing = "";
	public String strDTIgnoreCase = "";
	public String strDTToleranceValue = "";
	
	public String strDTQuestionTitle = "";
	public String strDTPointValue = "";
	public String strDTFormulas = "";	
	public String strDTReferences = "";
	public String strDTExternalLinks = "";
	public String strDTEbookAndResources = "";
	public String strDTDeductOnResources = "";
	public String strDTHints = "";
	public String strDTDeductOnHints = "";
	public String strDTCheckMyWork = "";
	public String strDTLimitCheckwork = "";
	public String strDTLimitCheckworkValue = "";	
	public String strDTDeductCheckwork = "";
	public String strDTDeductCheckworkValue = "";
	public String strDTShowAnswers = "";
	public String strDTShowGuidedAnswers = "";
	public String strDTAskInstructor = "";
	
	public String strDTAssignmentShareType = "";
	
	public String strDTShowFeedbackPostAttempt = "";
	public String strDTAfterFirstAttempt = "";
	public String strDTAfterAdditionalAttempt = "";
	public String strDTAfterFullScore = "";
	public String strDTShowFeedbackPostQuestion = "";
	
	public String strDTWebActivityLinkName = "";
	public String strDTWebActivityURL = "";
	
	public String strDTQuestionTitles = "";
	public String strDTSelectAssignments="";
	
	public CreateAssignmentData(String strParametersNValues) throws Exception
	{
		
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "CreateAssignment", "InputDataRow", "All");
		
		strDTQuestionSource = (String) hmInputDataSet.get("QuestionSource");
		strDTTestContent = (String) hmInputDataSet.get("TestContent");
		strDTAssignmentTitleTemplate = (String) hmInputDataSet.get("AssignmentTitleTemplate");
		strDTAssignmentTitle = (String) hmInputDataSet.get("AssignmentTitle");
		strDTInstructions = (String) hmInputDataSet.get("Instructions");
		strDTSelectQuestions = (String) hmInputDataSet.get("SelectQuestions");
		strDTQuestionsPoolName = (String) hmInputDataSet.get("QuestionsPoolName");
		strDTDrawQuestions = (String) hmInputDataSet.get("DrawQuestions");
		strDTAssignmentQuestions = (String) hmInputDataSet.get("AssignmentQuestions");
		
		strDTAssignmentStartDate = (String) hmInputDataSet.get("AssignmentStartDate");
		strDTAssignmentStartTime = (String) hmInputDataSet.get("AssignmentStartTime");
		strDTAssignmentEndDate = (String) hmInputDataSet.get("AssignmentEndDate");
		strDTAssignmentEndTime = (String) hmInputDataSet.get("AssignmentEndTime");
		
		strDTCheckLateSubmissionDeduction = (String) hmInputDataSet.get("CheckLateSubmissionDeduction");
		strDTLateSubmitDeduction = (String) hmInputDataSet.get("LateSubmitDeduction");
		strDTLateSubmitDedType = (String) hmInputDataSet.get("LateSubmitDedType");
		strDTForceSubmit = (String) hmInputDataSet.get("ForceSubmit");
		
		strDTAssignmentType = (String) hmInputDataSet.get("AssignmentType");
		
		strDTAllowTimeLimit = (String) hmInputDataSet.get("AllowTimeLimit");
		strDTTimeLimit = (String) hmInputDataSet.get("TimeLimit");
		strDTScrambleQuestions = (String) hmInputDataSet.get("ScrambleQuestions");
		strDTAllowPrinting = (String) hmInputDataSet.get("AllowPrinting");
		strDTAddPassword = (String) hmInputDataSet.get("AddPassword");
		strDTPassword = (String) hmInputDataSet.get("Password");
		strDTAutomaticFullCredit = (String) hmInputDataSet.get("AutomaticFullCredit");
		
		strDTAttemptsAllowed = (String) hmInputDataSet.get("AttemptsAllowed");
		strDTAttemptOption = (String) hmInputDataSet.get("AttemptOption");
		strDTRevisePreviousAttempt = (String) hmInputDataSet.get("RevisePreviousAttempt");
		strDTCheckDeductionForAttempt = (String) hmInputDataSet.get("CheckDeductionForAttempt");
		strDTDeductionForAttempt = (String) hmInputDataSet.get("DeductionForAttempt");
		strDTCompoundDeduction = (String) hmInputDataSet.get("CompoundDeduction");
		
		strDTIgnoreAccents = (String) hmInputDataSet.get("IgnoreAccents");
		strDTIgnoreSpacing = (String) hmInputDataSet.get("IgnoreSpacing");
		strDTIgnoreCase = (String) hmInputDataSet.get("IgnoreCase");
		strDTToleranceValue = (String) hmInputDataSet.get("ToleranceValue");
		
		strDTQuestionTitle = (String) hmInputDataSet.get("QuestionTitle");
		strDTPointValue = (String) hmInputDataSet.get("PointValue");
		strDTFormulas = (String) hmInputDataSet.get("Formulas");	
		strDTReferences = (String) hmInputDataSet.get("References");
		strDTExternalLinks = (String) hmInputDataSet.get("ExternalLinks");
		strDTEbookAndResources = (String) hmInputDataSet.get("EbookAndResources");
		strDTDeductOnResources = (String) hmInputDataSet.get("DeductOnResources");
		strDTHints = (String) hmInputDataSet.get("Hints");
		strDTDeductOnHints = (String) hmInputDataSet.get("DeductOnHints");
		strDTCheckMyWork = (String) hmInputDataSet.get("CheckMyWork");
		strDTLimitCheckwork = (String) hmInputDataSet.get("LimitCheckwork");
		strDTLimitCheckworkValue = (String) hmInputDataSet.get("LimitCheckworkValue");	
		strDTDeductCheckwork = (String) hmInputDataSet.get("DeductCheckwork");
		strDTDeductCheckworkValue = (String) hmInputDataSet.get("DeductCheckworkValue");
		strDTShowAnswers = (String) hmInputDataSet.get("ShowAnswers");
		strDTShowGuidedAnswers = (String) hmInputDataSet.get("ShowGuidedAnswers");
		strDTAskInstructor = (String) hmInputDataSet.get("AskInstructor");
		
		strDTAssignmentShareType = (String) hmInputDataSet.get("AssignmentShareType");
		
		strDTShowFeedbackPostAttempt = (String) hmInputDataSet.get("ShowFeedbackPostAttempt");
		strDTAfterFirstAttempt = (String) hmInputDataSet.get("AfterFirstAttempt");
		strDTAfterAdditionalAttempt = (String) hmInputDataSet.get("AfterAdditionalAttempt");
		strDTAfterFullScore = (String) hmInputDataSet.get("AfterFullScore");
		strDTShowFeedbackPostQuestion = (String) hmInputDataSet.get("ShowFeedbackPostQuestion");
		
		strDTWebActivityLinkName = (String) hmInputDataSet.get("WebActivityLinkName");
		strDTWebActivityURL = (String) hmInputDataSet.get("WebActivityURL");
		
		strDTQuestionTitles=(String) hmInputDataSet.get("QuestionTitles");
		strDTSelectAssignments=(String) hmInputDataSet.get("SelectAssignments");
	}

}	