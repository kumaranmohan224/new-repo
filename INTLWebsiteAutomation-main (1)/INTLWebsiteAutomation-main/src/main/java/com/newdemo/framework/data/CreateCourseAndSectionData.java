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

public class CreateCourseAndSectionData extends CommonFunctions
{	
	public int intParamInputRow = 0;

	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTDiscipline = "";
	public String strDTISBN = "";
	public String strDTBookTitle = "";
	public String strDTComponent = "";
	public String strDTTimeZone = "";
	public String strDTCourseNamePrefix = "";
	public String strDTSectionNamePrefix = "";
	public String strDTCourseName = "";
	public String strDTSectionName = "";
	public String strDTCourseStartDate = "";
	public String strDTCourseEndDate= "";	
	public String strDTWebAddressPrefix = "";
	public String strDTCourseCreatedMessage = "";
	public String strDTWebAddressSavedMessage = "";
	public String strDTCannotShareMessage = "";
	public String strDTRosterInformation = "";
	public String strDTSaveCourseDetails = "";
	public String strDTSaveSectionDetails = "";
	public String strDTSetRegistrationDates = "";
	public String strDTSaveCourseName = "";
	public String strDTSectionNameFull = "";
	
		
	public CreateCourseAndSectionData(String strParametersNValues) throws Exception
	{
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "CourseDetails", "InputDataRow", "All");
		HashMap<String, String> hmParamsNValues = SplitNStoreParamsInHashMap(strParametersNValues);
		int intParamInputRow = Integer.parseInt((String) hmParamsNValues.get("InputDataRow"));
		
		strDTDiscipline = (String) hmInputDataSet.get("Discipline");
		strDTISBN = (String) hmInputDataSet.get("ISBN");
		strDTBookTitle = (String) hmInputDataSet.get("BookTitle");
		strDTComponent = (String) hmInputDataSet.get("Component");
		strDTTimeZone = (String) hmInputDataSet.get("TimeZone");
		strDTCourseNamePrefix = (String) hmInputDataSet.get("CourseNamePrefix");
		strDTSectionNamePrefix = (String) hmInputDataSet.get("SectionNamePrefix");
		strDTCourseName = (String) hmInputDataSet.get("CourseName");
		strDTSectionName = (String) hmInputDataSet.get("SectionName");
		strDTCourseStartDate = (String) hmInputDataSet.get("CourseStartDate");
		strDTCourseEndDate = (String) hmInputDataSet.get("CourseEndDate");		
		strDTWebAddressPrefix = (String) hmInputDataSet.get("WebAddressPrefix");
		strDTCourseCreatedMessage = (String) hmInputDataSet.get("CourseCreatedMessage");
		strDTWebAddressSavedMessage = (String) hmInputDataSet.get("WebAddressSavedMessage");
		strDTCannotShareMessage = (String) hmInputDataSet.get("CannotShareMessage");
		strDTRosterInformation = (String) hmInputDataSet.get("StudentRosterInformation");
		strDTSaveCourseDetails = (String) hmInputDataSet.get("SaveCourseDetails");
		strDTSaveSectionDetails = (String) hmInputDataSet.get("SaveSectionDetails");
		strDTSetRegistrationDates = (String) hmInputDataSet.get("SetRegistrationDates");
		strDTSaveCourseName = (String) hmInputDataSet.get("SaveCourseName");
		strDTSectionNameFull=(String) hmInputDataSet.get("SectionName");
	}

}	
