package com.newdemo.framework.data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.GlobalPaths;

public class InstructorGradingData extends CommonFunctions
{	
	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTScore = "";
	public String strDTComment = "";
	public String strDTAskInstructorResponse = "";
	
	
	public InstructorGradingData(String strParametersNValues) throws Exception
	{
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "InstructorGrading", "InputDataRow", "All");
		
		strDTScore = (String) hmInputDataSet.get("Score");
		strDTComment = (String) hmInputDataSet.get("Comments");
		strDTAskInstructorResponse = (String) hmInputDataSet.get("AskInstructorResponse");
	}
}