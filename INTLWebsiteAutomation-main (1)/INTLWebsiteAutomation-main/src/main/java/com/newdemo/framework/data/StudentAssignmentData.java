package com.newdemo.framework.data;

import java.util.HashMap;

import com.newdemo.framework.base.CommonFunctions;

public class StudentAssignmentData extends CommonFunctions {

	//====================FIELD VARIABLES DECLARATION=============================

		public String strDTURL = "";
		public String strDTUserName = "";
		public String strDTPassword = "";
		public String strDTTimedAssignmentMsg = "";
		public String strDTPasswordMsg = "";
		public String strDTAssignmentPwd = "";
		public String strDTHintAlertMsg = "";
		public String strDTHintMsg = "";
		public String strDTCMWScoreDeductionMsg = "";
		public String strDTCMWAttemptNumber = "";
		public String strDTEbookAlertMsg = "";
		public String strDTHintMsgAtAssignStart = "";
		public String strDTEbookMsgAtAssignStart = "";
		public String strDTCMWMsgAtAssignStart = "";
		public String strDTTimedAutoSubmitText = "";
		public String strDTCurrentAssignMaxAttempts = "";
		public String strDTBOPAMsgOnStart = "";
		public String strDTBOPAQsHeaderInfo1 = "";
		public String strDTBOPAQsHeaderInfo2 = "";
		public String strDTDeductionForAttempt = "";
		public String strDTCMWMaxAttemptsUsedMsg = "";
		
		
		public StudentAssignmentData(String strParametersNValues) throws Exception
		{
			HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "StudentAssignmentDetails", "InputDataRow", "All");
			
			strDTTimedAssignmentMsg = (String) hmInputDataSet.get("TimedAssignmentMsg");
			strDTPasswordMsg = (String) hmInputDataSet.get("PasswordMsg");
			strDTAssignmentPwd = (String) hmInputDataSet.get("AssignmentPassword");
			strDTHintAlertMsg = (String) hmInputDataSet.get("HintAlertMessage");
			strDTHintMsg = (String) hmInputDataSet.get("HintValue");
			strDTCMWScoreDeductionMsg = (String) hmInputDataSet.get("CMWScoreDeductionText");
			strDTCMWAttemptNumber = (String) hmInputDataSet.get("MaxCMWAttemptNumber");
			strDTEbookAlertMsg = (String) hmInputDataSet.get("EbookAlertMessage");
			strDTHintMsgAtAssignStart = (String) hmInputDataSet.get("HintMsgAtAssignStart");
			strDTEbookMsgAtAssignStart = (String) hmInputDataSet.get("EbookMsgAtAssignStart");
			strDTCMWMsgAtAssignStart = (String) hmInputDataSet.get("CMWMsgAtAssignStart");
			strDTTimedAutoSubmitText = (String) hmInputDataSet.get("TimedAutoSubmitText");
			strDTCurrentAssignMaxAttempts = (String) hmInputDataSet.get("AttemptsAllowed");
			strDTBOPAMsgOnStart = (String) hmInputDataSet.get("BOPAMessageOnStart");
			strDTBOPAQsHeaderInfo1 = (String) hmInputDataSet.get("BOPAQsHeaderInfo1");
			strDTBOPAQsHeaderInfo2 = (String) hmInputDataSet.get("BOPAQsHeaderInfo2");
			strDTDeductionForAttempt = (String) hmInputDataSet.get("DeductionForAttempt");
			strDTCMWMaxAttemptsUsedMsg = (String) hmInputDataSet.get("CMWMaxAttemptsUsedText");
			

			if(strParametersNValues.contains("ConnectLoginIN"))
			{
				hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "ConnectLoginIN", "ConnectLoginINDataRow", "All");
				strDTURL= (String)hmInputDataSet.get("URL");
				strDTUserName = (String) hmInputDataSet.get("UserName");
				strDTPassword = (String) hmInputDataSet.get("Password");
			}
		}
	
}
