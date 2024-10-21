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

public class ConnectLoginData extends CommonFunctions
{	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTURL = "";
	public String strDTUserName = "";
	public String strDTPassword = "";
	
	public ConnectLoginData(String strParametersNValues) throws Exception
	{
		
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "ConnectLoginIN", "InputDataRow", "All");
		
		strDTURL = (String) hmInputDataSet.get("URL");
		strDTUserName = (String) hmInputDataSet.get("UserName");
		strDTPassword = (String) hmInputDataSet.get("Password");
	}

}	
