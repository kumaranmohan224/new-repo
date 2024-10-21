package com.newdemo.framework.controller;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.GlobalPaths;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.StudentRegistrationPage;

public class StudentRegistrationController extends ComponentFunctions {

	StudentRegistrationPage StudentRegPage = null;
	StudentRegistrationData StudentRegData = null;
	ConnectLoginController connectLogin=null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	
	public String strTempStudentEmail;
	public StudentRegistrationController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		StudentRegPage = PageFactory.initElements(driver, StudentRegistrationPage.class);		
	}
	
	public void launchStudentRegistrationURL(int dataRow) throws Exception
	{
		String StudentUrl = StudentRegData.strDTRegistrationURL+retrieveRuntimeGlobalVariable("WebAddress1");
		CMNFunctions.saveDataInExcel("StudentDetails","StudentURL",dataRow,StudentUrl);
		launchURL(StudentUrl);
	}
	
	public void waitForStudentSignin(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(StudentRegPage.studentUserName,"Student Signin",intWaitTime);
	}
	
	public void clickRegisterNow() throws Exception
	{		
		waitTillElementDisplayed(StudentRegPage.registerNow, "Register Now", 20);
		clickObject(StudentRegPage.registerNow, "Register Now");
		waiting(2);	
	}
	
	public void waitForNewEmailAddress(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(StudentRegPage.emailId,"New Email Address",intWaitTime);
	}
	
	public void enterNewEmailAddress(int studentNumber,int dataRow) throws Exception
	{
		try{
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
	    	String studentEmailId = "student-"+studentNumber+"_"+strAppendDateTime+"@mheqa.com";
			CMNFunctions.saveDataInExcel("StudentDetails","StudentEmail",dataRow,studentEmailId);
			clearNTypeValue(StudentRegPage.newEmailId, "Student Email", studentEmailId);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing enter New Email Address in StudentRegistrationController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing enterNewEmailAddress method in StudentRegistrationController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}	
	
	public void clickSubmitButton() throws Exception
	{	
		clickObjectUsingJSExecutor(StudentRegPage.submitButton, "Submit Student Email");
		waiting(2);		
	}
	
	public void waitForStdRegCode(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(StudentRegPage.stdRegCode,"Student Registration code",intWaitTime);
	}
	
	public void enterStdRegCode() throws Exception
	{					
		String strRegCode = StudentRegData.strDTRegistrationCode;						
		clearNTypeValue(StudentRegPage.stdRegistrationCode, "Student Registration Code", strRegCode);			
	}	
	
	public void clickRegCodeSubmitButton() throws Exception
	{
		clickObjectUsingJSExecutor(StudentRegPage.regCodeSubmitButton, "Submit the Registration Code");
		waiting(2);	
	}
	
	public void waitForcompleteRegistration(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(StudentRegPage.completeReg,"Student Registration code",intWaitTime);
	}
	
	public void enterEmailConfirmAddress() throws Exception
	{
		String strRetrieveEmail = StudentRegData.strDTStudentEmail;
		clearNTypeValue(StudentRegPage.emailAddress, "Student Email Address",strRetrieveEmail);
		clearNTypeValue(StudentRegPage.confirmemailAddress, "Student Confirm Email Address",strRetrieveEmail);		
	}
	
	public void enterPwdConfirmPwd() throws Exception
	{
		String strStudentPassword = StudentRegData.strDTPassword;
		clearNTypeValue(StudentRegPage.password, "Student password",strStudentPassword);
		clearNTypeValue(StudentRegPage.confirmPasswd, "Student Confirm password",strStudentPassword);	
		storeRuntimeGlobalVariable("StudentPassword", strStudentPassword);
	}	
	
	public void selectSchool() throws Exception
	{
		String strSchoolName= StudentRegData.strDTschoolName;
		selectValueByTextFromList(StudentRegPage.schoolName, "School Name", strSchoolName);
	}
	
	public void enterFirstNLastName() throws Exception
	{	
		String strStudentFirstName = StudentRegData.strDTFirstName;
		String strStudentLastName = StudentRegData.strDTLastName;
		clearNTypeValue(StudentRegPage.firstName, "Student First Name",strStudentFirstName);
		clearNTypeValue(StudentRegPage.lastName, "Student Last Name",strStudentLastName);	
		storeRuntimeGlobalVariable("StudentFirstName", strStudentFirstName);
		storeRuntimeGlobalVariable("StudentLastName", strStudentLastName);
	}	
	
	public void enterSecurityQuestionNAnswer() throws Exception
	{
		waiting(1);
		String strSecurityQuestion = StudentRegData.strDTSecurityQuestion;
		String strAnswer = StudentRegData.strDTSecurityAnswer;
		mouseOverNClick(StudentRegPage.securityQuestion, "Select the security question List box");													
		selectValueByTextFromList(StudentRegPage.securityQuestion, "Select value from dropdown", strSecurityQuestion);				
		clearNTypeValue(StudentRegPage.securityAnswer, "Student Last Name",strAnswer);
	}	
	
	public void clickAcceptCheckBox() throws Exception
	{
		selectRadioOrCheckBox(StudentRegPage.acceptCheckBox,"Select the Accept check box","ON");
	}
	
	public void clickCompleteMyRegistration() throws Exception
	{
		clickObjectUsingJSExecutor(StudentRegPage.completeMyRegistration,"Click complete my registration button");
	}
	
	public void waitForGoToConnect(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(StudentRegPage.registrationCompleteLocator,"Student Registration complete",intWaitTime);
	}
	
	public void clickGoToConnectNowButton() throws Exception
	{
		clickObject(StudentRegPage.goToConnectNow, "Go to connect now button");
	}
	
	public void dismissUpdatesNnoticesPopup() throws Exception
	{
		if(waitTillElementEnabled(StudentRegPage.updatesNnoticesOKbutton, "Updates and Notices Popup", 10)){
			clickObjectUsingJSExecutor(StudentRegPage.updatesNnoticesOKbutton, "Updates and Notices Pop Up");				
		}			
		else{
			ATUReports.add("There is no Updates and Notices Pop up", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
		}
	}
	
	public void registerNewStudentPAAM(int dataRow) throws Exception
	{
		String StudentUrl = StudentRegData.strDTRegistrationURL + retrieveRuntimeGlobalVariable("WebAddress1");
		CMNFunctions.saveDataInExcel("StudentDetails", "StudentURL", dataRow, StudentUrl);
		launchURL(StudentUrl);
		//launchURL(StudentRegData.strDTStudentURL);
		waitTillElementDisplayed(StudentRegPage.edtEmail,"edtEmail", 20);
		
		Date dt = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMMddhhmmssyyyy");
		String strTempStudentEmail = formatter2.format(dt).toLowerCase() + "@mheqa.com";
		//storeRuntimeGlobalVariable(strSaveStudentEmail, strTempStudentEmail);
		CMNFunctions.saveDataInExcel("StudentDetails","SaveStudentEmail",dataRow,strTempStudentEmail);
		
		typeValue(StudentRegPage.edtEmail, "edtEmail", strTempStudentEmail);
		clickObject(StudentRegPage.btnBegin, "btnBegin");
		waitTillElementDisplayed(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", 20);
		
		typeValue(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", strTempStudentEmail);
		typeValue(StudentRegPage.edtPasswordPAAM, "edtPasswordPAAM", StudentRegData.strDTPassword);
		typeValue(StudentRegPage.edtConfirmPassword, "ConfirmPassword", StudentRegData.strDTPassword);
		
		typeValue(StudentRegPage.edtFirstName, "edtFirstName", StudentRegData.strDTFirstName);
		typeValue(StudentRegPage.edtLastName, "edtLastName", StudentRegData.strDTLastName);
		
		selectValueByTextFromList(StudentRegPage.lstSecurityQuestion, "SecurityQuestion", StudentRegData.strDTSecurityQuestion);
		Thread.sleep(1000);
		typeValue(StudentRegPage.edtSecurityAnswer, "SecurityAnswer", StudentRegData.strDTSecurityQuestion);
		clickObjectUsingJSExecutor(StudentRegPage.chkAcceptTerms, "Accept Terms");
		//selectRadioOrCheckBox(StudentRegPage.chkAcceptTerms, "chkAcceptTerms", "ON");
		clickObject(StudentRegPage.btnSubmit, "btnSubmit");
		waiting(2);
		if(waitTillElementEnabled(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount", 20))
		{
			waiting(2);
			clickObject(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount");
			waiting(2);
		}
		waitTillElementEnabled(StudentRegPage.edtAccessCode, "edtAccessCode", 20);
	
	//	boolean tempAccessStatus = clickObject(StudentRegPage.tempAccess, "Access Now (temporary)");
		
		if (waitTillElementEnabled(StudentRegPage.tempAccess, "Access Now (temporary)", 20)) {
			waiting(2);
			clickObjectUsingJSExecutor(StudentRegPage.tempAccess, "Access Now (temporary)");
		} else {
			typeValueUsingJSExecutor(StudentRegPage.edtAccessCode, "edtAccessCode", StudentRegData.strDTRegistrationCode);
			clickObjectUsingJSExecutor(StudentRegPage.btnSubmit, "btnSubmit");
		}
		
		waitTillElementDisplayed(StudentRegPage.btnPlaceOrder, "btnPlaceOrder", 20);
		clickObject(StudentRegPage.btnPlaceOrder, "btnPlaceOrder");
		
		waitTillElementDisplayed(StudentRegPage.btnGoToConnect, "btnGoToConnect", 20);
		clickObject(StudentRegPage.btnGoToConnect, "btnGoToConnect");
	}
	
	public void newClassicFlow() throws Exception
	{
	/*	waitTillElementDisplayed(StudentRegPage.edtEmail,"edtEmail", 20);	
		typeValue(StudentRegPage.edtEmail, "edtEmail", StudentRegData.strDTSavedStudentEmail);
		waiting(2);
		clickObject(StudentRegPage.btnBegin, "btnBegin");
		waiting(2);	 */
	/*	if(waitTillElementEnabled(StudentRegPage.btnBegin, "btnBegin",5))
		{
			clickObject(StudentRegPage.btnBegin, "btnBegin");
			waiting(2);
		}*/
		
		waitTillElementEnabled(StudentRegPage.enterEmail,"edtEmail", 20);	
		typeValue(StudentRegPage.enterEmail, "Enter Email Address", StudentRegData.strDTSavedStudentEmail);
		waiting(2);
		clickObject(StudentRegPage.continueBtn, "btnBegin");
		waiting(2);
		
	}
	public void registerNewStudentPAAMCourtesyorAccess(int dataRow) throws Exception
	{
		String StudentUrl = StudentRegData.strDTRegistrationURL+retrieveRuntimeGlobalVariable("WebAddress1");
		CMNFunctions.saveDataInExcel("StudentDetails","StudentURL",dataRow,StudentUrl);
		launchURL(StudentUrl);
		//launchURL(StudentRegData.strDTStudentURL);
		waitTillElementDisplayed(StudentRegPage.edtEmail,"edtEmail", 20);
		
		Date dt = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMMddhhmmssyyyy");
		String strTempStudentEmail = formatter2.format(dt).toLowerCase() + "@mheqa.com";
		//storeRuntimeGlobalVariable(strSaveStudentEmail, strTempStudentEmail);
		CMNFunctions.saveDataInExcel("StudentDetails","SaveStudentEmail",dataRow,strTempStudentEmail);
		
		typeValue(StudentRegPage.edtEmail, "edtEmail", strTempStudentEmail);
		clickObject(StudentRegPage.btnBegin, "btnBegin");
		waitTillElementDisplayed(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", 20);
		
		typeValue(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", strTempStudentEmail);
		typeValue(StudentRegPage.edtPasswordPAAM, "edtPasswordPAAM", StudentRegData.strDTPassword);
		typeValue(StudentRegPage.edtConfirmPassword, "ConfirmPassword", StudentRegData.strDTPassword);
		
		typeValue(StudentRegPage.edtFirstName, "edtFirstName", StudentRegData.strDTFirstName);
		typeValue(StudentRegPage.edtLastName, "edtLastName", StudentRegData.strDTLastName);
		
		selectValueByTextFromList(StudentRegPage.lstSecurityQuestion, "SecurityQuestion", StudentRegData.strDTSecurityQuestion);
		Thread.sleep(1000);
		typeValue(StudentRegPage.edtSecurityAnswer, "SecurityAnswer", StudentRegData.strDTSecurityQuestion);
		clickObjectUsingJSExecutor(StudentRegPage.chkAcceptTerms, "Accept Terms");
		//selectRadioOrCheckBox(StudentRegPage.chkAcceptTerms, "chkAcceptTerms", "ON");
		clickObject(StudentRegPage.btnSubmit, "btnSubmit");
		waiting(2);
		if(waitTillElementDisplayed(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount", 20))
		{
			clickObject(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount");
			waiting(2);
		}
		waitTillElementDisplayed(StudentRegPage.edtAccessCode, "edtAccessCode", 20);
		/*if(waitTillElementDisplayed(StudentRegPage.eltCourtesyAccess, "eltCourtesyAccess", 10))
		{
			clickObject(StudentRegPage.eltCourtesyAccess, "eltCourtesyAccess");
		}else
		{*/
		typeValue(StudentRegPage.edtAccessCode, "edtAccessCode", StudentRegData.strDTRegistrationCode);
		clickObject(StudentRegPage.btnSubmit, "btnSubmit");
		//}
		waitTillElementDisplayed(StudentRegPage.btnPlaceOrder, "btnPlaceOrder", 20);
		clickObject(StudentRegPage.btnPlaceOrder, "btnPlaceOrder");
		
		waitTillElementDisplayed(StudentRegPage.btnGoToConnect, "btnGoToConnect", 20);
		clickObject(StudentRegPage.btnGoToConnect, "btnGoToConnect");
	}
	public void loginStudentInPAAM() throws Exception
	{
		String strURL = "";
		//WebElement edtUserName = null;
		strURL = StudentRegData.strDTStudentLoginURL;
		String edtUserName = StudentRegData.strDTSavedStudentEmail;
		
		/*String strEmailAddress = StudentRegData.strDTEmailAddress;
		if(strEmailAddress.contains("<<"))
		{
			strEmailAddress = retrieveRuntimeGlobalVariable(strEmailAddress.replace("<<", "").replace(">>", ""));
		}*/
		
		launchURL(strURL);
		waitTillElementEnabled(StudentRegPage.frmLoginFrame, "LoginFrame",30);
		if(checkObjectVisibleWOError(StudentRegPage.frmLoginFrame, "Frame"))
		{
		switchToFrame(StudentRegPage.frmLoginFrame, "LoginFrame");
		}
		waitTillElementEnabled(StudentRegPage.edtEmailAddress, "EmailAddress", 20);
		if(checkObjectVisibleWOError(StudentRegPage.edtEmailAddress, "EmailAddress"))
		{
			typeValue(StudentRegPage.edtEmailAddress, "EmailAddress", edtUserName);
			typeValue(StudentRegPage.edtPassword, "Password", StudentRegData.strDTPassword);
			clickObject(StudentRegPage.btnSignIn, "SignIn");
	//		switchToDefaultPage();
	//		waitTillElementDisplayed(login.eltClasses, "Classes", 20);
			waiting(5);
		}
	}
	public void launchPAAMURL() throws Exception
	{
		String strURL = StudentRegData.strDTStudentURL;
		launchURL(strURL);	
	}
	
	public void launchStudentConnectURL() throws Exception
	{
		launchURL(StudentRegData.strDTStudentLoginURL);
	}
	
	public void registerNewStudentPAAMUnsupportedSection(int dataRow) throws Exception
	{
		String StudentUrl = StudentRegData.strDTRegistrationURL + retrieveRuntimeGlobalVariable("WebAddress2");
		CMNFunctions.saveDataInExcel("StudentDetails","StudentURL",dataRow,StudentUrl);
		launchURL(StudentUrl);
		//launchURL(StudentRegData.strDTStudentURL);
		waitTillElementDisplayed(StudentRegPage.edtEmail,"edtEmail", 20);
		
		Date dt = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMMddhhmmssyyyy");
		String strTempStudentEmail = formatter2.format(dt).toLowerCase() + "@mheqa.com";
		//storeRuntimeGlobalVariable(strSaveStudentEmail, strTempStudentEmail);
		CMNFunctions.saveDataInExcel("StudentDetails","SaveStudentEmail",dataRow,strTempStudentEmail);
		
		typeValue(StudentRegPage.edtEmail, "edtEmail", strTempStudentEmail);
		clickObject(StudentRegPage.btnBegin, "btnBegin");
		waitTillElementDisplayed(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", 20);
		
		typeValue(StudentRegPage.edtConfirmEmail, "edtConfirmEmail", strTempStudentEmail);
		typeValue(StudentRegPage.edtPasswordPAAM, "edtPasswordPAAM", StudentRegData.strDTPassword);
		typeValue(StudentRegPage.edtConfirmPassword, "ConfirmPassword", StudentRegData.strDTPassword);
		
		typeValue(StudentRegPage.edtFirstName, "edtFirstName", StudentRegData.strDTFirstName);
		typeValue(StudentRegPage.edtLastName, "edtLastName", StudentRegData.strDTLastName);
		
		selectValueByTextFromList(StudentRegPage.lstSecurityQuestion, "SecurityQuestion", StudentRegData.strDTSecurityQuestion);
		Thread.sleep(1000);
		typeValue(StudentRegPage.edtSecurityAnswer, "SecurityAnswer", StudentRegData.strDTSecurityQuestion);
		clickObjectUsingJSExecutor(StudentRegPage.chkAcceptTerms, "Accept Terms");
		//selectRadioOrCheckBox(StudentRegPage.chkAcceptTerms, "chkAcceptTerms", "ON");
		clickObject(StudentRegPage.btnSubmit, "btnSubmit");
		waiting(2);
		if(waitTillElementEnabled(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount", 20))
		{
			waiting(2);
			clickObject(StudentRegPage.eltContinueWithNewAccount, "eltContinueWithNewAccount");
			waiting(2);
		}
		waitTillElementEnabled(StudentRegPage.edtAccessCode, "edtAccessCode", 20);
	
	//	boolean tempAccessStatus = clickObject(StudentRegPage.tempAccess, "Access Now (temporary)");
		
		if (waitTillElementEnabled(StudentRegPage.tempAccess, "Access Now (temporary)", 20)) {
			waiting(2);
			clickObjectUsingJSExecutor(StudentRegPage.tempAccess, "Access Now (temporary)");
		} else {
			typeValueUsingJSExecutor(StudentRegPage.edtAccessCode, "edtAccessCode", StudentRegData.strDTRegistrationCode);
			clickObjectUsingJSExecutor(StudentRegPage.btnSubmit, "btnSubmit");
		}
		
		waitTillElementDisplayed(StudentRegPage.btnPlaceOrder, "btnPlaceOrder", 20);
		clickObject(StudentRegPage.btnPlaceOrder, "btnPlaceOrder");
		
		waitTillElementDisplayed(StudentRegPage.btnGoToConnect, "btnGoToConnect", 20);
		clickObject(StudentRegPage.btnGoToConnect, "btnGoToConnect");
	}
	
	public void registerNewStudentPAAMUpdatedUIOct2021(int dataRow, String webAddressStr) throws Exception {
		
		//*****************new start
		String StudentUrl = StudentRegData.strDTRegistrationURL + retrieveRuntimeGlobalVariable(webAddressStr);
		//String StudentUrl = StudentRegData.strDTRegistrationURL;
		CMNFunctions.saveDataInExcel("StudentDetails", "StudentURL", dataRow, StudentUrl);
		objHTMLFunctions.ReportPassFail("Saved data in excel file => SheetName: StudentDetails, Row num: " + dataRow + " , Column: StudentURL, with value: " + StudentUrl, 
				"true", "true");
		launchURL(StudentUrl);
		//launchURL(StudentRegData.strDTStudentURL);
		waitTillElementDisplayed(StudentRegPage.enterEmail,"edtEmail", 20);
		
		Date dt = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMMddhhmmssyyyy");
		String strTempStudentEmail = formatter2.format(dt).toLowerCase() + "@mheqa.com";
		//storeRuntimeGlobalVariable(strSaveStudentEmail, strTempStudentEmail);
		CMNFunctions.saveDataInExcel("StudentDetails","SaveStudentEmail",dataRow,strTempStudentEmail);
		
		typeValue(StudentRegPage.enterEmail, "Enter student email", strTempStudentEmail);
		clickObject(StudentRegPage.continueBtn, "Continue button");
		waiting(1.5);
		
		//******************************************
		waitTillElementEnabled(StudentRegPage.enterPassword, "enter Password PAAM", 10);
		typeValue(StudentRegPage.enterPassword, "enter Password PAAM", StudentRegData.strDTPassword);
		typeValue(StudentRegPage.confirmPassword, "Confirm Password PAAM", StudentRegData.strDTPassword);
		
		typeValue(StudentRegPage.stdFirstName, "FirstName", StudentRegData.strDTFirstName);
		typeValue(StudentRegPage.stdLastName, "LastName", StudentRegData.strDTLastName);
		
		selectValueByTextFromList(StudentRegPage.stdSecurityQuestionSelectDropDown, "SecurityQuestion dropdown", StudentRegData.strDTSecurityQuestion);
		Thread.sleep(1000);
		typeValue(StudentRegPage.stdSecurityAnswer, "SecurityAnswer", StudentRegData.strDTSecurityQuestion);
		clickObjectUsingJSExecutor(StudentRegPage.stdAcceptTermsCheckbox, "Accept Terms & Conditions");
		//selectRadioOrCheckBox(StudentRegPage.chkAcceptTerms, "chkAcceptTerms", "ON");
		clickObject(StudentRegPage.stdCreateAccountbtn, "Create student account button");
	//	clickObjectUsingJSExecutor(StudentRegPage.stdCreateAccountbtn, "Create student account button");
		waiting(2);
		
		//*******************************************
		waitTillElementEnabled(StudentRegPage.enterAccessCode, "Enter Access Code", 20);
		if(waitTillElementEnabled(StudentRegPage.tempAccessbtn,"Temporary Access", 10)){
			waiting(1);
			clickObjectUsingJSExecutor(StudentRegPage.tempAccessbtn,"Temporary Access");
			
		}else{
			typeValue(StudentRegPage.enterAccessCode, "Enter Access Code", StudentRegData.strDTRegistrationCode);
			clickObjectUsingJSExecutor(StudentRegPage.redeemAccessCodeBtn, "Redeem Access Code Button");
		}
		
		waiting(2);
		
		waitTillElementEnabled(StudentRegPage.confirmTempAccessBtn, "Confirm Temporary Access Button", 15);
		clickObject(StudentRegPage.confirmTempAccessBtn, "Confirm Temporary Access Button");
		
		waitTillElementEnabled(StudentRegPage.completeRegistrationBtn, "Complete Student Registration Button Button", 15);
		clickObject(StudentRegPage.completeRegistrationBtn, "Complete Student Registration Button Button");
		
	}
	
public void registerNewStudentCoInstructor(int dataRow, String webAddressStr) throws Exception {
		
		//*****************new start
		//String StudentUrl = StudentRegData.strDTRegistrationURL + retrieveRuntimeGlobalVariable(webAddressStr);
		String StudentUrl = StudentRegData.strDTRegistrationURL;
		CMNFunctions.saveDataInExcel("StudentDetails", "StudentURL", dataRow, StudentUrl);
		objHTMLFunctions.ReportPassFail("Saved data in excel file => SheetName: StudentDetails, Row num: " + dataRow + " , Column: StudentURL, with value: " + StudentUrl, 
				"true", "true");
		launchURL(StudentUrl);
		//launchURL(StudentRegData.strDTStudentURL);
		waitTillElementDisplayed(StudentRegPage.enterEmail,"edtEmail", 20);
		
		Date dt = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("MMMddhhmmssyyyy");
		String strTempStudentEmail = formatter2.format(dt).toLowerCase() + "@mheqa.com";
		String studFirstName = "Student";
		CMNFunctions.saveDataInExcel("StudentDetails","FirstName",dataRow,studFirstName);
		String studLastName = formatter2.format(dt).toLowerCase();
		CMNFunctions.saveDataInExcel("StudentDetails","LastName",dataRow,studLastName);
		//storeRuntimeGlobalVariable(strSaveStudentEmail, strTempStudentEmail);
		CMNFunctions.saveDataInExcel("StudentDetails","SaveStudentEmail",dataRow,strTempStudentEmail);
		
		typeValue(StudentRegPage.enterEmail, "Enter student email", strTempStudentEmail);
		clickObject(StudentRegPage.continueBtn, "Continue button");
		waiting(10);
		
		//******************************************
		waitTillElementEnabled(StudentRegPage.enterPassword, "enter Password PAAM", 10);
		typeValue(StudentRegPage.enterPassword, "enter Password PAAM", StudentRegData.strDTPassword);
		typeValue(StudentRegPage.confirmPassword, "Confirm Password PAAM", StudentRegData.strDTPassword);
		
		typeValue(StudentRegPage.stdFirstName, "FirstName", studFirstName);
		typeValue(StudentRegPage.stdLastName, "LastName", studLastName);
		
		selectValueByTextFromList(StudentRegPage.stdSecurityQuestionSelectDropDown, "SecurityQuestion dropdown", StudentRegData.strDTSecurityQuestion);
		Thread.sleep(5000);
		typeValue(StudentRegPage.stdSecurityAnswer, "SecurityAnswer", StudentRegData.strDTSecurityQuestion);
		clickObjectUsingJSExecutor(StudentRegPage.stdAcceptTermsCheckbox, "Accept Terms & Conditions");
		//selectRadioOrCheckBox(StudentRegPage.chkAcceptTerms, "chkAcceptTerms", "ON");
		clickObject(StudentRegPage.stdCreateAccountbtn, "Create student account button");
	//	clickObjectUsingJSExecutor(StudentRegPage.stdCreateAccountbtn, "Create student account button");
		waiting(2);
		
		//*******************************************
		waitTillElementEnabled(StudentRegPage.enterAccessCode, "Enter Access Code", 20);
		if(waitTillElementEnabled(StudentRegPage.tempAccessbtn,"Temporary Access", 10)){
			waiting(1);
			clickObjectUsingJSExecutor(StudentRegPage.tempAccessbtn,"Temporary Access");
			
		}else{
			typeValue(StudentRegPage.enterAccessCode, "Enter Access Code", StudentRegData.strDTRegistrationCode);
			clickObjectUsingJSExecutor(StudentRegPage.redeemAccessCodeBtn, "Redeem Access Code Button");
		}
		
		waiting(2);
		
		waitTillElementEnabled(StudentRegPage.confirmTempAccessBtn, "Confirm Temporary Access Button", 15);
		clickObject(StudentRegPage.confirmTempAccessBtn, "Confirm Temporary Access Button");
		
		waitTillElementEnabled(StudentRegPage.completeRegistrationBtn, "Complete Student Registration Button Button", 15);
		clickObject(StudentRegPage.completeRegistrationBtn, "Complete Student Registration Button Button");
		
	}
	
	public void enterLoginPwdForRegisteredStudent() throws Exception {
		waitTillElementEnabled(StudentRegPage.enterRegisteredStdPwd, "Enter student password for registered student", 10);
		typeValue(StudentRegPage.enterRegisteredStdPwd, "Enter student password for registered student", StudentRegData.strDTPassword);
		clickObject(StudentRegPage.continueBtn, "Existing student login continue button");
	}

}
