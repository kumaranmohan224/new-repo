package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class StudentRegistration extends ScriptBase {
	@Parameters({ "ParameterNValue" })
	@Test(description = "Student Registration", priority = 1, enabled = true)
	public void RegisterStudents(String ParameterNValue) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Student Registration scenarios";
			ATUReports.setAuthorInfo("Gaurav D", Utils.getCurrentTime(), "2.2");
			String strDescription = "Register Students";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail("Scenario_03=>" + strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			final int student1 = 2;
			final int student2 = 3;

			this.strDTParametersNValues = "InputDataRow=>" + student1;
			// newStudentRegistration(2, student1);
		//	connect().StudentRegistrationPage().registerNewStudentPAAM(student1);
			connect().StudentRegistrationPage().registerNewStudentPAAMUpdatedUIOct2021(student1, "WebAddress1");
			studentlogOut();

			this.strDTParametersNValues = "InputDataRow=>" + student2;
			// newStudentRegistration(3, student2);
		//	connect().StudentRegistrationPage().registerNewStudentPAAM(student2);
			connect().StudentRegistrationPage().registerNewStudentPAAMUpdatedUIOct2021(student2, "WebAddress1");
			studentlogOut();

			this.strDTParametersNValues = "InputDataRow=>" + defaultDataRow;

		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
		}
	}

	public void newStudentRegistration(int regStudentNumber, int dataRow) throws Exception {
		connect().StudentRegistrationPage().launchStudentRegistrationURL(dataRow);
		connect().StudentRegistrationPage().waitForStudentSignin(10);
		connect().StudentRegistrationPage().clickRegisterNow();
		connect().StudentRegistrationPage().waitForNewEmailAddress(10);
		connect().StudentRegistrationPage().enterNewEmailAddress(regStudentNumber, dataRow);
		connect().StudentRegistrationPage().clickSubmitButton();
		waiting(15);
		connect().StudentRegistrationPage().waitForStdRegCode(60);
		connect().StudentRegistrationPage().enterStdRegCode();
		connect().StudentRegistrationPage().clickRegCodeSubmitButton();
		connect().StudentRegistrationPage().waitForcompleteRegistration(10);
		connect().StudentRegistrationPage().enterEmailConfirmAddress();
		connect().StudentRegistrationPage().enterPwdConfirmPwd();
		connect().StudentRegistrationPage().enterFirstNLastName();
		connect().StudentRegistrationPage().selectSchool();
		connect().StudentRegistrationPage().enterSecurityQuestionNAnswer();
		connect().StudentRegistrationPage().clickAcceptCheckBox();
		connect().StudentRegistrationPage().clickCompleteMyRegistration();
		connect().StudentRegistrationPage().waitForGoToConnect(10);
		connect().StudentRegistrationPage().clickGoToConnectNowButton();
		connect().StudentRegistrationPage().dismissUpdatesNnoticesPopup();
		studentlogOut();
	}

	public void studentlogOut() throws Exception {
		connect().StudentRegistrationPage().dismissUpdatesNnoticesPopup();
		connect().ConnectLoginPage().clickSignOutButton();
		Thread.sleep(3000);
		/*
		 * connect().ConnectLoginPage().acceptAlerts();
		 * connect().ConnectLoginPage().waitForStdUserName(10);
		 **/
	}
}
