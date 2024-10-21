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

public class StudentRegistrationData extends CommonFunctions
{	
	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTRegistrationURL = "";
	public String strDTStudentURL = "";
	public String strDTStudentLoginURL = "";
	public String strDTStudentEmail = "";
	public String strDTRegistrationCode = "";
	public String strDTPassword = "";
	public String strDTFirstName = "";
	public String strDTLastName = "";
	public String strDTSecurityQuestion = "";
	public String strDTSecurityAnswer = "";
	public String strDTSavedStudentEmail = "";
	public String strDTschoolName = "";
	
	public String strDTURL = "";
	public String strDTUserName = "";
	public String strDTLoginPassword = "";
	
	public String strDTstdFirstName1 = "";
	public String strDTstdLastName1 = "";
	
	public StudentRegistrationData(String strParametersNValues) throws Exception
	{
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "StudentDetails", "InputDataRow", "All");
		
		strDTRegistrationURL = (String) hmInputDataSet.get("RegistrationURL");
		strDTStudentURL = (String) hmInputDataSet.get("StudentURL");
		strDTStudentLoginURL= (String) hmInputDataSet.get("StudentLoginURL");
		strDTStudentEmail = (String) hmInputDataSet.get("StudentEmail");
		strDTRegistrationCode = (String) hmInputDataSet.get("RegistrationCode");
		strDTPassword = (String) hmInputDataSet.get("Password");
		strDTFirstName = (String) hmInputDataSet.get("FirstName");
		strDTLastName = (String) hmInputDataSet.get("LastName");
		strDTSecurityQuestion = (String) hmInputDataSet.get("SecurityQuestion");
		strDTSecurityAnswer = (String) hmInputDataSet.get("SecurityAnswer");
		strDTSavedStudentEmail= (String) hmInputDataSet.get("SaveStudentEmail");
		strDTschoolName=(String) hmInputDataSet.get("SchoolName");
		
		strDTstdFirstName1 = (String) hmInputDataSet.get("FirstName");
		strDTstdLastName1 = (String) hmInputDataSet.get("LastName");
		
		

		if(strParametersNValues.contains("ConnectLoginIN"))
		{
			hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "ConnectLoginIN", "ConnectLoginINDataRow", "All");
			strDTURL= (String)hmInputDataSet.get("URL");
			strDTUserName = (String) hmInputDataSet.get("UserName");
			strDTPassword = (String) hmInputDataSet.get("Password");
		}
	}
	
	
}