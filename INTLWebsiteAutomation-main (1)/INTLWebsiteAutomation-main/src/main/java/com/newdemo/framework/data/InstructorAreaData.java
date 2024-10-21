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

public class InstructorAreaData extends CommonFunctions
{	
	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTBookmarkName = "";
	public String strDTBookmarkAddress = "";
	public String strDTBookmarkMessage = "";
	
	public String strDTInstructorEmail = "";
	public String strDTInstructorInformation = "";
	public String strDTInstructorInfoMessage = "";
	
	public String strDTstdFirstName1 = "";
	
	
	public InstructorAreaData(String strParametersNValues) throws Exception
	{
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "InstructorArea", "InputDataRow", "All");
		
		strDTBookmarkName = (String) hmInputDataSet.get("BookmarkName");
		strDTBookmarkAddress = (String) hmInputDataSet.get("BookmarkAddress");
		strDTBookmarkMessage = (String) hmInputDataSet.get("BookmarkMessage");
		
		strDTInstructorEmail = (String) hmInputDataSet.get("InstructorEmail");
		strDTInstructorInformation = (String) hmInputDataSet.get("InstructorInformation");
		strDTInstructorInfoMessage = (String) hmInputDataSet.get("InstructorInfoMessage");
		
	//	strDTstdFirstName1 = (String) hmInputDataSet.get("FirstName");
	}
}