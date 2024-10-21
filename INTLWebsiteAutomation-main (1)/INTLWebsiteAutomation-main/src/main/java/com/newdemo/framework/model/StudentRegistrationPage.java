package com.newdemo.framework.model;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.newdemo.framework.base.GlobalPaths;

public class StudentRegistrationPage {
	
	public By studentUserName = By.id("username");
	@FindBy(xpath="//a[@class='submit submitDisplayInlineBlock']") public WebElement registerNow;
	public By emailId = By.xpath("//input[@id='emailAddID']");		
	@FindBy(xpath="//input[@id='emailAddID']") public WebElement newEmailId;
	@FindBy(xpath="//button[@class='submit']") public WebElement submitButton;
	//public By stdRegCode = By.xpath("//input[@id='accessCodeInput']");
	@FindBy(xpath="//input[@id='accessCodeInput']") public WebElement stdRegCode;
	@FindBy(xpath="//input[@id='accessCodeInput']") public WebElement stdRegistrationCode;
	@FindBy(xpath="//input[@class='submit']") public WebElement regCodeSubmitButton;
	//public By completeReg = By.xpath("//input[@id='accountRegister']");
	@FindBy(xpath="//input[@id='accountRegister']") public WebElement completeReg;
	@FindBy(xpath="//input[@id='emailAddress']") public WebElement emailAddress;
	@FindBy(xpath="//input[@id='confirmEmailAddress']") public WebElement confirmemailAddress;
	@FindBy(xpath="//input[@id='passwd']") public WebElement password;
	@FindBy(xpath="(//input[@id='confirmPasswd'])") public WebElement confirmPasswd;
	@FindBy(xpath="//input[@id='firstName']") public WebElement firstName;
	@FindBy(xpath="//input[@id='lastName']") public WebElement lastName;
	@FindBy(xpath="//select[@id='question' and @class='school_select']") public WebElement securityQuestion;
	@FindBy(xpath="//input[@id='answer']") public WebElement securityAnswer;
	@FindBy(xpath="//input[@id='terms']") public WebElement acceptCheckBox;
	@FindBy(xpath="//input[@id='accountRegister']") public WebElement completeMyRegistration;
	public By registrationCompleteLocator = By.xpath("//div[@id='pageIntro']/h1/span");
	@FindBy(xpath="//a[@title='Go to Connect Now']") public WebElement goToConnectNow;
	@FindBy(xpath="//a[text() = 'OK']") public WebElement updatesNnoticesOKbutton;
	@FindBy(id="school") public WebElement schoolName;
	
	//===================NEW STUDENT REGISTRATION PAGE OBJECTS 1-June-2015==================================
		@FindBy(xpath="//input[@placeholder='Email']") public WebElement edtEmail;
		@FindBy(xpath="//input[@placeholder='Password']") public WebElement edtPasswordExistingStud;
		
		@FindBy(xpath="//img[@alt='instructor image']") public WebElement imgInstructorIcon;
		@FindBy(xpath="//div[contains(@class,'invalid-color')]") public WebElement eltInvalidMessage;
		@FindBy(xpath="//div[@class='message-label']") public List<WebElement> lstMessages;
		@FindBy(xpath="//a[text()='Forgot password?']/../a[1]") public WebElement lnkBack;
		@FindBy(xpath="//a[text()='Forgot password?']") public WebElement lnkForgotPassword;
		@FindBy(xpath="//a[text()='Cancel']") public WebElement lnkCancel;
		
		
		@FindBy(xpath="//h1[text()='Welcome']") public WebElement eltWelcomeMessage;
		@FindBy(xpath="//h1[text()='Review info']") public WebElement eltReviewInfo;
		@FindBy(xpath="//span[contains(@class,'instructor-name')]") public WebElement eltInstructorName;
		@FindBy(xpath="//div[contains(@class,'book-id')]") public WebElement eltTextBookId;
		@FindBy(xpath="//h4[contains(@class,'course-title')]") public WebElement eltCourseName;
		@FindBy(xpath="//p[contains(@class,'section-title')]") public WebElement eltSectionTitle;
		
		@FindBy(xpath="//button[text()='BEGIN']") public WebElement btnBegin;
		@FindBy(xpath="//input[@id='confirmEmailAddress']") public WebElement edtConfirmEmail;
		@FindBy(xpath="//input[@id='passwd']") public WebElement edtPasswordPAAM;
		@FindBy(xpath="//input[@id='confirmPasswd']") public WebElement edtConfirmPassword;
		@FindBy(xpath="//input[@id='firstName']") public WebElement edtFirstName;
		@FindBy(xpath="//input[@id='lastName']") public WebElement edtLastName;
		@FindBy(xpath="//select[@id='securityQuestion']") public WebElement lstSecurityQuestion;
		@FindBy(xpath="//input[@id='securityAnswer']") public WebElement edtSecurityAnswer;
		@FindBy(xpath="//input[@id='terms']") public WebElement chkAcceptTerms;
		@FindBy(xpath="//button[@id='ca-submit-btn']") public WebElement btnSubmitPAAM;
		@FindBy(xpath="//div[@class='continue-reg']/a") public WebElement eltContinueWithNewAccount;
		@FindBy(xpath="//input[@id='accessCode1']") public WebElement edtAccessCode;
		@FindBy(xpath="//*[@id='courtesyAccessCard']/div/div[2]/div/a/button") public WebElement tempAccess;
		@FindBy(xpath="//button[@id='place_order_btn']") public WebElement btnPlaceOrder;
		@FindBy(xpath="//button[text()='GO TO CONNECT']") public WebElement btnGoToConnect;
		@FindBy(xpath="//button[text()='COMPLETE REGISTRATION']") public WebElement btnCompleteRegistration;
		@FindBy(xpath="//a[contains(text(),'Contact customer service')]") public WebElement lnkCustomerService;
		@FindBy(xpath="//button[@type='submit']") public WebElement btnSubmit;
		
		//======================STATIC ELEMENTS=================================
		//***************************INSTRUCTOR LOGIN PAGE******************************
		@FindBy(name="username") public WebElement edtEmailAddress;
		@FindBy(name="password") public WebElement edtPassword;
		@FindBy(xpath="//button[@type='submit']") public WebElement btnSignIn;
		@FindBy(tagName="iframe") public WebElement frmLoginFrame;
		@FindBy(xpath="(//div[text()='Classes'])[1]") public WebElement eltClasses;
		
		//======================DYNAMIC ELEMENTS================================
		
		//======================SIKULI IMAGES===================================
		public String SKIMG_PAAMLeftNavigation = GlobalPaths.strSikuliImagesPath + "\\PAAMLeftNavigation.png";
		public String SKIMG_ClassesIcon = GlobalPaths.strSikuliImagesPath + "\\ClassesIcon.png";
		
		//*****************************New Student registration flow objects****************************** 07-Oct-2021
				//**************1st page after launching webaddress
				@FindBy(xpath="//input[@id='login-email']") public WebElement enterEmail;
				@FindBy(xpath="//button[contains(text(),'Continue')]") public WebElement continueBtn;
				//**********************************2nd page where student account details are to be filled****************************************************
				@FindBy(xpath="//input[@id='passwd']") public WebElement enterPassword;
				@FindBy(xpath="//input[@id='confirmPasswd']") public WebElement confirmPassword;
				@FindBy(xpath="//input[@id='firstName']") public WebElement stdFirstName;
				@FindBy(xpath="//input[@id='lastName']") public WebElement stdLastName;
				@FindBy(xpath="//select[@id='securityQuestions']") public WebElement stdSecurityQuestionSelectDropDown;
				@FindBy(xpath="//input[@id='securityAnswer']") public WebElement stdSecurityAnswer;
				@FindBy(xpath="//input[@id='agree-terms']") public WebElement stdAcceptTermsCheckbox;
				@FindBy(xpath="//button[@id='ca-submit-btn']") public WebElement stdCreateAccountbtn;
				//******************************3rd page - temporary access or access code**************************
				@FindBy(xpath="//input[@id='access-code']") public WebElement enterAccessCode;
				@FindBy(xpath="//button[@type='submit' and contains(text(),'Redeem')]") public WebElement redeemAccessCodeBtn;
				@FindBy(xpath="//button[@id='temporary-access-btn']") public WebElement tempAccessbtn;
				//********************************4th page - confirm temporary access or access code page
				@FindBy(xpath="//button[@id='confirm-btn']") public WebElement confirmTempAccessBtn;
				//*******************************5th page - connect complete registration page*****************************
				@FindBy(xpath="//button[@id='connect-btn']") public WebElement completeRegistrationBtn;
				
				//**********************enter password for already registered student**********************
				@FindBy(xpath="//input[@id='login-password']") public WebElement enterRegisteredStdPwd;
				
				//**********sayan
}
