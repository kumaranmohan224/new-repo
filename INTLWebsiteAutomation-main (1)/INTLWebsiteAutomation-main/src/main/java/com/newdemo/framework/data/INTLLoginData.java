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

public class INTLLoginData extends CommonFunctions
{	
	//====================FIELD VARIABLES DECLARATION=============================
	public String strDTURL = "";
	public String strDTUserName = "";
	public String strDTPassword = "";
	public String strDTSearchText = "";
	public String strDTTaxID = "";
	public String strDTTaxName = "";
	public String strDTInvoicePostalCode = "";
	public String strDTSurName = "";
	public String strDTStreet = "";
	public String strDTStreet2 ="";
	public String strDTCity = "";
	public String strDTTelephone = "";
	public String strDTBillingPostCode = "";
	public String strDTCCFullName = "";
	public String strDTCCNumber = "";
	public String strDTSecurityCode = "";
	public String strDTCustomerEmailLogin = "";
	public String strDTCustomerPassword = "";
	public String strDTExpiration = "";
	public String strDTOTPValue = "";
	public String strDTNIFDNI = "";
	public String strDTNumeroDeIdentification = "";
	public String strDTSelectBank = "";
	
	
	public INTLLoginData(String strParametersNValues) throws Exception
	{
		
		HashMap hmInputDataSet = fetchXLDataNStoreInHashMap(strParametersNValues, "INTLLogin", "InputDataRow", "All");
		
		strDTURL = (String) hmInputDataSet.get("URL");
		strDTUserName = (String) hmInputDataSet.get("UserName");
		strDTPassword = (String) hmInputDataSet.get("Password");
		strDTSearchText = (String) hmInputDataSet.get("SearchText");
		strDTTaxID = (String) hmInputDataSet.get("TaxID");
		strDTTaxName = (String) hmInputDataSet.get("FirstName");
		strDTSurName = (String) hmInputDataSet.get("LastName");
		strDTInvoicePostalCode = (String) hmInputDataSet.get("InvoicePostalCode");
		strDTStreet = (String) hmInputDataSet.get("Street");
		strDTStreet2 = (String) hmInputDataSet.get("AddressLine2");
		strDTCity = (String) hmInputDataSet.get("City");
		strDTTelephone = (String) hmInputDataSet.get("Telephone");
		strDTBillingPostCode = (String) hmInputDataSet.get("PostCode");
		strDTCCFullName = (String) hmInputDataSet.get("CCFullName");
		strDTCCNumber = (String) hmInputDataSet.get("CCNumber");	
		strDTSecurityCode = (String) hmInputDataSet.get("SecurityCode");
		strDTCustomerEmailLogin = (String) hmInputDataSet.get("CustomerEmailLogin");
		strDTCustomerPassword = (String) hmInputDataSet.get("CustomerPassword");
		strDTExpiration = (String) hmInputDataSet.get("Expiration");
		strDTOTPValue = (String) hmInputDataSet.get("OTP");
		strDTNIFDNI = (String) hmInputDataSet.get("NIFDNI");
		strDTNumeroDeIdentification = (String) hmInputDataSet.get("NumeroDeIdentification");
		strDTSelectBank = (String) hmInputDataSet.get("SelectBank");
		
	}

}	
