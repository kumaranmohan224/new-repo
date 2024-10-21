package com.newdemo.testEZTJIRA;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class BulkStudentRegistration extends ScriptBase
{
	@Parameters({"ParameterNValue"})
	@Test(description = "Student Registration", priority = 1, enabled = true)
	public void RegisterStudents(String ParameterNValue) throws Exception
	{
		try {
			ATUReports.indexPageDescription = "Connect application automation - Student Registration scenarios";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "Register Students";
			 ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_01=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;
			
			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			final int student = 2;
			final int student2 = 3;
			
			this.strDTParametersNValues = "InputDataRow=>"+student;
			newStudentRegistration(student);
			/*
			this.strDTParametersNValues = "InputDataRow=>"+student2;
			newStudentRegistration(3,student2);*/
			
			this.strDTParametersNValues = "InputDataRow=>"+defaultDataRow;
		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}
	}
	
	public void newStudentRegistration(int student) throws Exception
	{
		for(int i=student;i<=50;i++)
		{
			connect().StudentRegistrationPage().registerNewStudentPAAMCourtesyorAccess(i);
			objHTMLFunctions.reportPassFailToATU("Student Registered Compeleted " +(i-1), "ModuleName", "ModuleName");
		}
	}
	
	
}
		
