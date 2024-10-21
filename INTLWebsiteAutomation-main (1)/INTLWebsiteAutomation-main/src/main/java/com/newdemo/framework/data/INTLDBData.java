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

public class INTLDBData extends CommonFunctions
{	
	//====================FIELD VARIABLES DECLARATION=============================
	public String dbHost="";
	public String dbUser="";
	public String dbPassword="";
	
	
	public INTLDBData(String strParametersNValues) throws Exception
	{
		
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "DBConnect", "InputDataRow", "All");
		
		dbHost = (String) hmInputDataSet.get("DBHost");
		dbUser = (String) hmInputDataSet.get("DBUser");
		dbPassword = (String) hmInputDataSet.get("DBPassword");
		
		
	}

}	
