/*package com.newdemo.framework.controller;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.INTLLoginData;
import com.newdemo.framework.data.INTLDBData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.INTLLoginPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;*/

package com.newdemo.framework.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.INTLDBData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.INTLLoginPage;

public class INTLDBController extends ComponentFunctions {

	INTLLoginPage intlloginPage = null;
	INTLDBData intlDBData = null;
	StudentRegistrationData StudentRegData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	public INTLDBController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		intlloginPage = PageFactory.initElements(driver, INTLLoginPage.class);
		//intlDBData = PageFactory.initElements(driver, INTLDBData.class);		
	}
	
	public void delToolsInDB() throws Exception
	{
		try
		{
			//String title;
			//String regURL;
			//String dbHost=intlDBData.dbHost;
			//String dbUser=intlDBData.dbUser;
			//String dbPassword=intlDBData.dbPassword;
			String dbHost="172.26.50.13";
			String dbUser="mhes01_qa";
			//String dbPassword="magent0f@@d";
			String dbPassword="Welcome#mhe01";
			//int toolID=0;
			
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Class.forName("DriverManager");
			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Going to establish connection with Database");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//10.227.75.114:1521/sprkqalv_ash", "cmsrep", "CMSREPQALV62$");			
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//"+dbHost, dbUser, dbPassword);
			Connection con=DriverManager.getConnection("jdbc:mysql://172.26.50.13:3307/mhes01_qa", dbUser, dbPassword);
			Statement stmt=con.createStatement();
			
			System.out.println("Going to execute the Query");
			
			String slectQuery="SELECT * FROM MAGENTO_PRODUCT_REGION WHERE ATTRIBUTE2='Y' AND MASTER_ISBN IS NOT NULL";			
			//String delToolQuery="delete from lti_external_tool_info where TITLE ='"+intlDBData.runTimeToolTitle+"'";
			System.out.println("The query going to be executed is : "+slectQuery);
			
			
			System.out.println("Preparing Result Set");
			ResultSet dbResult=stmt.executeQuery(slectQuery);
						
			System.out.println("---- Results ----");
			//dbResult.getString("ISBN13");
			while(dbResult.next()) { waiting(2);
			String toolID=dbResult.getString("ISBN13");
			 System.out.println(toolID);
			 
			 
			 //System.out.println("Title ID : "+toolID);
			}
			/*
			 * while(dbResult.next()) { waiting(2); title=dbResult.getString("TITLE");
			 * regURL=dbResult.getString("REGISTRATION_LAUNCH");
			 * toolID=dbResult.getInt("ID");
			 * 
			 * System.out.println("Title ID : "+toolID);
			 * System.out.println("Title : "+title);
			 * System.out.println("Registration URL : "+regURL); waiting(2); }
			 * System.out.println("---- END ----");
			 * 
			 * String
			 * delToolPoliciesQuery="delete from LTI_EXTERNAL_TOOL_POLICIES where TOOL_ID = "
			 * +toolID; System.out.
			 * println("Going to delete the record in Data Base using the query >>>>"
			 * +delToolPoliciesQuery); stmt.executeQuery(delToolPoliciesQuery);
			 * //System.out.
			 * println("Going to delete the record in Data Base using the query >>>>"
			 * +delToolQuery); //stmt.executeQuery(delToolQuery);
			 * System.out.println("Record is deleted");
			 */
			
			System.out.println("Going to close the Connection with database");
			con.close();
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed deleting tools from DB" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
}
	
	