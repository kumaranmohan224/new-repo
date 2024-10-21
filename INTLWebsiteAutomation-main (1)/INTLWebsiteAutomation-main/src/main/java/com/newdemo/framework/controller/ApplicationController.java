package com.newdemo.framework.controller;

import org.openqa.selenium.WebDriver;

import com.newdemo.framework.data.ConnectLoginData;
import com.newdemo.framework.data.CreateAssignmentData;
import com.newdemo.framework.data.CreateCourseAndSectionData;
import com.newdemo.framework.data.INTLDBData;
import com.newdemo.framework.data.INTLLoginData;
import com.newdemo.framework.data.InstructorAreaData;
import com.newdemo.framework.data.InstructorGradingData;
import com.newdemo.framework.data.StudentAssignmentData;
import com.newdemo.framework.data.StudentRegistrationData;


public class ApplicationController 
{
	public static WebDriver driver;
	
	//====================CONTROLLER OBJECTS=======================
	
	public String strParametersNValues = "";
	public String strMainParametersNValues="";
	
	public ConnectLoginController login = null;
	public CreateCourseAndSectionController CourseAndSection = null;
	public InstructorAreaController InstructorArea = null;
	public CreateAssignmentController CreateAssignment = null;
	public StudentRegistrationController StudentRegistration = null;
	public TakeAssignmentController TakeAssignment = null;
	public InstructorGradingController InstructorGrading = null;
	public InsightsController Insights = null;
	public StudentReportsController StudentReports = null;
	public INTLLoginController intllogin = null;
	public INTLDBController intldb = null;
	
	public ApplicationController(WebDriver driver) 
	{
		this.driver = driver;
		
	}	
	
	public ConnectLoginController ConnectLoginPage() throws Exception
	{
		if(login == null)
		{
			login = new ConnectLoginController(driver, this.strParametersNValues);
		}
		login.loginData = new ConnectLoginData(strParametersNValues);
		login.StudentRegData = new StudentRegistrationData(strParametersNValues);
		return login;
	}
	
	public INTLLoginController INTLLoginPage() throws Exception
	{
		if(intllogin == null)
		{
			intllogin = new INTLLoginController(driver, this.strParametersNValues);
		}
		intllogin.intlloginData = new INTLLoginData(strParametersNValues);
		//intllogin.StudentRegData = new StudentRegistrationData(strParametersNValues);
		return intllogin;
	}
	
	public INTLDBController INTLDB() throws Exception
	{
		if(intldb == null)
		{
			intldb = new INTLDBController(driver, this.strParametersNValues);
		}
		intldb.intlDBData = new INTLDBData(strParametersNValues);
		
		return intldb;
	}
	
	
	public CreateCourseAndSectionController CreateCourseAndSectionPage() throws Exception
	{
		if(CourseAndSection == null)
		{
			CourseAndSection = new CreateCourseAndSectionController(driver, this.strParametersNValues);
		}
		CourseAndSection.CourseAndSectionData = new CreateCourseAndSectionData(strParametersNValues);
		return CourseAndSection;		
	}
	
	public InstructorAreaController InstructorAreaPage() throws Exception
	{
		if(InstructorArea == null)
		{
			InstructorArea = new InstructorAreaController(driver, this.strParametersNValues);
		}
		InstructorArea.InsAreaData = new InstructorAreaData(strParametersNValues);
		InstructorArea.stdRegistrationData = new StudentRegistrationData(strParametersNValues);
		InstructorArea.CreateAssignData = new CreateAssignmentData(strParametersNValues);
		return InstructorArea;
	}
	
	public CreateAssignmentController CreateAssignmentPage() throws Exception
	{
		if(CreateAssignment == null)
		{
			CreateAssignment = new CreateAssignmentController(driver, this.strParametersNValues);
		}
		CreateAssignment.LoginData = new ConnectLoginData(strParametersNValues);
		CreateAssignment.AssignmentData = new CreateAssignmentData(strParametersNValues);
		CreateAssignment.StudentRegData = new StudentRegistrationData(strParametersNValues);
		return CreateAssignment;
	}
	
	public StudentRegistrationController StudentRegistrationPage() throws Exception
	{
		if(StudentRegistration == null)
		{
			StudentRegistration = new StudentRegistrationController(driver, this.strParametersNValues);
		}
		StudentRegistration.StudentRegData = new StudentRegistrationData(strParametersNValues);
		return StudentRegistration;
	}
	
	public TakeAssignmentController TakeAssignmentPage() throws Exception
	{
		if(TakeAssignment == null)
		{
			TakeAssignment = new TakeAssignmentController(driver, this.strParametersNValues);
		}
		TakeAssignment.InsAreaData = new InstructorAreaData(strParametersNValues);
		TakeAssignment.CreateAssignData = new CreateAssignmentData(strParametersNValues);
		TakeAssignment.stdAssignmentData = new StudentAssignmentData(strParametersNValues);
		return TakeAssignment;
	}
	
	public InstructorGradingController InstructorGradingPage() throws Exception
	{
		if(InstructorGrading == null)
		{
			InstructorGrading = new InstructorGradingController(driver, this.strParametersNValues);
		}
		InstructorGrading.InsGradingData = new InstructorGradingData(strParametersNValues);
		InstructorGrading.CreateAssignData = new CreateAssignmentData(strParametersNValues);
		InstructorGrading.StudentData = new StudentRegistrationData(strParametersNValues);
		return InstructorGrading;
	}
	
	public InsightsController InsightsPage() throws Exception
	{
		if(Insights == null)
		{
			Insights = new InsightsController(driver, this.strParametersNValues);
		}
		Insights.loginData = new ConnectLoginData(strParametersNValues);
		Insights.StudentRegData = new StudentRegistrationData(strParametersNValues);
		return Insights;
	}
	
	public StudentReportsController StudentReportsPage() throws Exception
	{
		if(StudentReports == null)
		{
			StudentReports = new StudentReportsController(driver, this.strParametersNValues);
		}
		StudentReports.CreateAssignData = new CreateAssignmentData(strParametersNValues);
		StudentReports.stdAssignmentData = new StudentAssignmentData(strParametersNValues);
		return StudentReports;
	}
	
}
