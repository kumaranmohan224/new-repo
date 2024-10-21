package com.newdemo.framework.model;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CreateAssignmentPage {
	
	@FindBy(xpath=".//*[@id='tabassign_2']/a") public WebElement addAssignmentButton;
	@FindBy(xpath="//div[@class='assignmentTypesLg bankIcon']") public WebElement addQuestionBankImage;
	public By questionSourceListLocator = By.xpath("//li[@class='pool_sections']");
	@FindBy(xpath="//select[@id='sourcepool']") public WebElement questionSourceList;	
	public WebElement chapterCourse(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//span[text()='" + strCourseName + "']")) ;
	}
	public WebElement chapterSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//span[text()='" + strSectionName + "']")) ;
	}
	public WebElement chapterAssignment(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//div[text()='" + strAssignmentName + "']/..//a/span[text()='select']")) ;
	//	return driver.findElement(By.xpath("//div[text()='" + strAssignmentName + "']/..//a[@ezid='" + ezid + "']")) ;   //added by sayan
	}
	//span[text()="CourseMcCnl_AnswerTolerance"]/../../../..         //to check expanded status
	@FindBy(xpath="//div[@id='qp_interstitial']") public WebElement loadingWait;
	public String waitExpression()
	{
		return "wait";
	}
	
	@FindBy(xpath="//a[@class='enterStudentInstructions']") public WebElement enterStudentInstructions;
	@FindBy(xpath="//textarea[@id='note']") public WebElement studentInstructions;
	@FindBy(xpath="//a[@id='enterSave']") public WebElement saveInstructions;
	
	//Assignment questions		
	@FindBy(xpath="//div[@id='subrightcontianer']//a[@id='random_top']//b") public WebElement addRandomSelection;
	@FindBy(xpath="//input[@id='no_questions']") public WebElement addNumQuestions;
	@FindBy(xpath="//input[@name='selectorder'][@value='order']") public WebElement selectOrder;
	@FindBy(xpath="//input[@name='selectorder'][@value='random_order']") public WebElement selectRandom;
	@FindBy(xpath="//input[@class='inputradio hidepool'][@name='addtype']") public WebElement addAsIndividualQuestions;
	@FindBy(xpath="//input[@class='inputradio showpool'][@name='addtype']") public WebElement addToNewPool;
	@FindBy(xpath="//div[@class='createpool']//input[@class='poolTxt input createPoolName']") public WebElement newPoolName;
	@FindBy(xpath="//ul[@id='random_save']//li[text()='add questions']") public WebElement addQuestions;
	
	@FindBy(xpath="//th[@class='cboxCenter']/input") public WebElement selectAllQuestionsCheckBox;
	public WebElement addQuestionCheckbox(WebDriver driver, int chkbxNo)
	{
		return driver.findElement(By.xpath("//table[@id='questionListTable']//tbody//tr["+chkbxNo+"]//input[@type='checkbox']")) ;
	}
	
	@FindBy(xpath=".//*[@id='questionListTable']/thead/tr/th[5]/input") public WebElement selectAllQuestions;
	
	@FindBy(xpath="//a[@id='topaddQuestion']/span/b") public WebElement addCheckedQuestions;
	@FindBy(xpath="//div[@id='subrightcontianer']//a[@class='addQuestion']") public WebElement addCheckedQuestionsIndividual;
	@FindBy(xpath="//div[@id='subrightcontianer']//a[@class='qp_poolmodal']") public WebElement addCheckedQuestionsToPool;
	
	@FindBy(xpath="//div[@id='pool_modal']//input[@name='poolname']") public WebElement poolName;
	@FindBy(xpath="//span[@id='pooling_save_text']") public WebElement savePool;
	
	@FindBy(xpath="//input[@catname='not auto-gradable'][@grpname='Gradable']") public WebElement nonAutoGradableCheckBox;
	@FindBy(xpath="//ul[@id='categorymenus']//span[text()='Gradable']/../../..//a[@class='updateresults']") public WebElement filterGradable;
	
	@FindBy(xpath="//li[@id='Qassignmenttab']//div[contains(text(),'organize assignment')]") public WebElement assignmentTab;
	
	@FindBy(xpath="//div[@class='toggle_pool collapse_pool']") public WebElement collapsePool;
	@FindBy(xpath="//div[@class='toggle_pool expand_pool']") public WebElement expandPool;	
	@FindBy(xpath="//select[@class='drawpooltxt readonly_disable_input']") public WebElement drawQuestions;
	
	@FindBy(xpath="//input[@class='cboxcount ']") public List<WebElement> questionsCheckbox;
	
	@FindBy(xpath="//a[@class='mrgthree assign_ques']") public List<WebElement> assignmentQuestions;
	@FindBy(xpath="//a[@id='deleteQuestion']") public WebElement deleteQuestion;
	
	@FindBy(xpath="//a[@id='create_Cont']") public WebElement continueAssignment;	
	
	//Assignment Policies
	@FindBy(id="title") public WebElement renameAssignmentEditBox;
	@FindBy(xpath="//a[contains(text(),'continue')]") public WebElement addQuestions_continueButton;
	public By reviewNassignButtonLocator = By.id("reviewAndAssignBtn");
	@FindBy(xpath="//input[@class='available_now']") public WebElement startOnceAssigned;
	@FindBy(id="assignment_availablity") public WebElement startOnThisDateButton;
	@FindBy(id="scheduleDateStart") public WebElement assignmentStartDate;
	@FindBy(id="startHourMin") public WebElement assignmentStartTime;
	@FindBy(id="scheduleDateEnd") public WebElement assignmentEndDate;
	@FindBy(id="dueHourMin") public WebElement assignmentEndTime;
	@FindBy(xpath=".//*[@id='increSize']") public WebElement saveExtensions;
	@FindBy(xpath=".//*[@class='remove_exceptions_e']") public WebElement checkExtension;
	@FindBy(xpath=".//*[@id='innerWrapper']/div[1]/a") public WebElement backToStudentActivity;
	
	@FindBy(xpath="//a[@id='submit_edit'][text()='edit']") public WebElement editLateSubmission;
	@FindBy(xpath="//input[@id='second'][@class='late_submit']") public WebElement acceptLateSubmission;
	@FindBy(xpath="//input[@id='latesubmitval1']") public WebElement lateSubmissionValue;
	@FindBy(xpath="//span[@class='bgr selectValue']") public WebElement lateSubmissionDeductionType;
	@FindBy(xpath="//ul[@class='bgr selectDDlist']/li[text()='hour']") public WebElement deductionTypeHour;
	@FindBy(xpath="//ul[@class='bgr selectDDlist']/li[text()='day']") public WebElement deductionTypeDay;
	@FindBy(xpath="//input[@id='first'][@class='auto_submit']") public WebElement forceSubmission;
	
	@FindBy(xpath="//li[@id='homework_tab']/a") public WebElement homeworkTab;
	@FindBy(xpath="//li[@id='practice_tab']/a") public WebElement practiceTab;
	@FindBy(xpath="//li[@id='quiz_tab']/a") public WebElement quizTab;
	@FindBy(xpath="//li[@id='exam_tab']/a") public WebElement examTab;
	
	@FindBy(xpath="//a[@id='home_setting']") public WebElement expandAdvancedSettings;
	@FindBy(xpath="//a[@id='hide_setting']") public WebElement collapseAdvancedSettings;
	
	@FindBy(xpath="//a[@id='edit_setting']") public WebElement editAllSettings;
	
	@FindBy(xpath="//li[@id='basic']/a") public WebElement basicSettings;
	@FindBy(xpath="//li[@id='attempts']/a") public WebElement attemptsSettings;
	@FindBy(xpath="//li[@id='answer_tolerance']/a") public WebElement toleranceSettings;
	@FindBy(xpath="//li[@id='resources']/a") public WebElement resourcesSettings;
	@FindBy(xpath="//li[@id='feedback']/a") public WebElement feedbackSettings;
	
	//*****************************************************************************
	@FindBy(xpath="//input[@name='timeRadioCheck']") public WebElement timeLimitCheck;
	@FindBy(xpath="//input[@id='timeLimit']") public WebElement timeLimit;
	@FindBy(xpath=".//*[@id='allowPrinting']") public WebElement allowPrinting;
	@FindBy(xpath="//input[@id='allowScramble1']") public WebElement allowScramble;
	@FindBy(xpath="//input[@id='addPassword']") public WebElement addPassword;
	@FindBy(xpath="//input[@id='passwordField']") public WebElement assignmentPassword;
	@FindBy(xpath="//input[@id='grade_by_participation']") public WebElement automaticFullCredit;
	
	@FindBy(xpath="//*[@id='nextAttemptSetting']") public WebElement attemptsAllowed;
	@FindBy(xpath="//input[@value='fresh']") public WebElement attemptFresh;
	@FindBy(xpath="//input[@value='previous']") public WebElement attemptPrevious;
	@FindBy(xpath="//input[@name='attemptcheckbopa1']") public WebElement revisePreviousAttempt;
	@FindBy(xpath="//input[@id='deductpercmultipleattempt1']") public WebElement checkDeductionForAttempt;
	@FindBy(xpath="//input[@name='deductpercmultipleattemptval1']") public WebElement deductionForAttempt;
	@FindBy(xpath="//input[@name='compounddeduct1']") public WebElement compoundDeduction;
	@FindBy(xpath=".//*[@id='allowForStudyAttemptsCheckbox']") public WebElement studyAttempts;
	
	@FindBy(xpath="//input[@name='ignoreAccents1']") public WebElement ignoreAccents;
	@FindBy(xpath="//input[@name='ignoreSpacing1']") public WebElement ignoreSpacing;
	@FindBy(xpath="//input[@name='ignoreCase1']") public WebElement ignoreCase;
	@FindBy(xpath="//input[@id='toleranceValue']") public WebElement toleranceValue;
	
	@FindBy(xpath="//input[@name='questionTitle1']") public WebElement questionTitle;
	@FindBy(xpath="//input[@name='pointValue1']") public WebElement pointValue;
	@FindBy(xpath="//input[@name='formula1']") public WebElement formulas;
	@FindBy(xpath="//input[@name='references1']") public WebElement references;
	@FindBy(xpath="//input[@name='externalContent1']") public WebElement externalLinks;
	@FindBy(xpath="//input[@name='libraryResources1']") public WebElement ebookAndResources;
	@FindBy(xpath=".//*[@id='libraryResources']/input") public WebElement deductOnResources;
	@FindBy(xpath="//input[@name='hints1']") public WebElement hints;
	@FindBy(xpath=".//*[@id='hintsResources']/input") public WebElement deductOnHints;
	@FindBy(xpath="//input[@name='checkWork1']") public WebElement checkMyWork;
	@FindBy(xpath="//input[@name='limitcheckwork1']") public WebElement limitCheckwork;
	@FindBy(xpath="//input[@name='limitcheckworkval1']") public WebElement limitCheckworkValue;	
	@FindBy(xpath="//input[@name='deductcheckwork1']") public WebElement deductCheckwork;
	@FindBy(xpath=".//*[@id='allowCheckWork']/p[2]/span/input[2]") public WebElement deductCheckworkValue;
	@FindBy(xpath="//input[@name='showAnswer1']") public WebElement showAnswers;
	@FindBy(xpath="//input[@name='guidance1']") public WebElement showGuidedAnswers;
	@FindBy(xpath="//input[@name='askinstructor1']") public WebElement askInstructor;
	
	@FindBy(xpath="//input[@id='feedbackAA']") public WebElement showFeedbackPostAttempt;
	@FindBy(xpath="//select[@class='attemptset'][@id='1']") public WebElement afterFirstAttempt;
	@FindBy(xpath="//select[@class='attemptset'][@id='2']") public WebElement afterAdditionalAttempt;
	@FindBy(xpath="//select[@class='attemptset'][@id='3']") public WebElement afterFullScore;
	@FindBy(xpath=".//*[@id='allowfeedback']") public WebElement aftereachQuestion;
	@FindBy(xpath="//li[@selectval='showdetailfeedback']/a") public WebElement detailFeedback;
	@FindBy(xpath="//li[@selectval='none']/a") public WebElement noFeedback;
	@FindBy(xpath="//li[@selectval='showscore']/a") public WebElement totalScoresFeedback;
	@FindBy(xpath="//li[@selectval='showscoreplus']/a") public WebElement totalScoresFeedbackIndicators;
	//******************Sayan start
	@FindBy(xpath="//li[@selectval='showdetailfeedbackplus']/a") public WebElement detailFeedbackWithSolutions;
	//*****************sayan end
	/*public WebElement feedbackType(WebDriver driver, String feedbackType)
	{
		return driver.findElement(By.xpath("//div[@class='contentContainer1']//li/a[text()='"+feedbackType+"']")) ;
	}*/
	@FindBy(xpath="//input[@id='allowfeedback']") public WebElement showFeedbackPostQuestion;
	
	@FindBy(xpath="//a[contains(text(),'apply to this assignment only')]") public WebElement applyChangesToThisAssignment;
	@FindBy(id="reviewAndAssignBtn") public WebElement reviewAndAssign;
	@FindBy(xpath=".//a[text()='review & assign']") public WebElement reviewAndAssignColleague;
	
	public WebElement shareAssignmentToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//label[text()='" + strSectionName + "']/../..//input[@name='sectionCheckBox'][@type='checkbox']")) ;
	}
	
	public WebElement copyAssignmnetToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//label[text()='"+strSectionName+"']/..//input[@name='desSectionIds'][@type='checkbox']"));
	}
	//TODO
	@FindBy(xpath="//div[@id='shareColleague']//ul/li/input[contains(@value,'onlyduedates')]") public WebElement onlyduedates;
	@FindBy(xpath="//div[@id='shareColleague']//ul/li/input[contains(@value,'allpolicies')]") public WebElement allpolicies;
	@FindBy(xpath="//div[@id='shareColleague']//ul/li/input[contains(@value,'nopolicies')]") public WebElement nopolicies;
	
	@FindBy(xpath="//h4[text()='review policies']") public WebElement reviewPolicies;
	
	
	@FindBy(id="reviewAssign_Assign") public WebElement assign;
	
	//File Attachment Assignment
	@FindBy(xpath="//div[@class='assignmentTypesLg fileattachIcon']") public WebElement fileAttachment;
	@FindBy(xpath="//input[@id='assignmentTitle']") public WebElement fileAttachmentAssignmentTitle;
	@FindBy(xpath="//textarea[@id='note']") public WebElement fileAttachmentInstructions;
	@FindBy(xpath="//a[@title='choose file...']") public WebElement chooseFile;
	@FindBy(xpath="//a[@class='uploadfiles right courseuploadlink_e']") public WebElement uploadFiles;
	@FindBy(xpath="(//input[@type='file'])[1]") public WebElement txtFileUploadBackEnd;
//	@FindBy(xpath="//div[@class='browsefield']/object") public WebElement browseButton;
	@FindBy(xpath="(.//*[@id='uploadifive-uploadifive']/input[2]") public WebElement browseButton;
	@FindBy(xpath="//a[@class='uploadbutton_e uploadbtn']") public WebElement uploadLink;
	@FindBy(xpath="//input[@class='chk' and @name='cbox']") public WebElement attachFileCheckBox;
	@FindBy(xpath="//a[@class='buttons btbl attachModalButton_e']/span") public WebElement attachSelectedFiles;
	@FindBy(xpath="//a[@id='setpolicies_btn']/span/b") public WebElement fileAttachmentNextAssign;
	public WebElement shareFileAssignmentToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//label[@id='section_name'][text()='" + strSectionName + "']/../input")) ;
	}
	@FindBy(xpath="//a[@class='addcolleague']") public WebElement addColleague;
	@FindBy(xpath="//a[text()='add colleagues']") public WebElement eztAddColleague;
	@FindBy(xpath="//input[@class='input email']") public WebElement colleagueEmail;
	@FindBy(xpath="//p[@class='emailfield']//a/span/b") public WebElement findColleague;
	@FindBy(xpath="//p[@class='emailfield']//a[text()='find colleagues']") public WebElement findColleagueEzt;
	public WebElement colleagueCourse(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//label[@id='courselabel'][text()='" + strCourseName + "']/../input")) ;
	}
	public WebElement colleagueCourseEzt(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//h4[text()='" + strCourseName + "']/../..//input[@type='checkbox']")) ;
	}
	public WebElement colleagueCourseEzts(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("(//h4[text()='"+strCourseName+"']/../..//input[@type='checkbox'])[2]")) ;
	}
	@FindBy(xpath="//a[@class='buttons btbl smbtbl colleaguesave equalbutton']") public WebElement saveColleagueEzt;
	@FindBy(xpath="//a[@class='buttons btbl colleaguesave']/span/b") public WebElement saveColleague;
	@FindBy(xpath="//a[contains(@class,'btntwo buttons btgy colleaguesave')]/span/b") public WebElement webActivitySaveColleague;
	public WebElement colleagueSection(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//div[@id='shareColleague']//label[text()='" + strCourseName + "']/..//input[@name='sectionCheckBox']")) ;
	}
	
	public WebElement colleagueSectionEzt(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("(//div[text()='" + strSectionName + "']/input[@name='sectionCheckBox'])[1]")) ;
	}
	
	public WebElement colleagueSectionEzts(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//*[text()='"+strSectionName+"']/../../input")) ;
	}
	
	@FindBy(xpath=".//*[@class='right edit-option-wrapper']/ul/li[2]/input") public WebElement setAllPolicies;
	@FindBy(xpath="//input[@name='startdate']") public WebElement fileAssignStartDate;
	@FindBy(xpath="//input[@pid='starttime'][contains(@class,'txtHour')]") public WebElement fileAssignStartHour;
	@FindBy(xpath="//input[@pid='starttime'][contains(@class,'txtMinute')]") public WebElement fileAssignStartMinute;
	@FindBy(xpath="//select[@name='startampm']") public WebElement fileAssignStartAmPm;
	@FindBy(xpath="//input[@name='duedate']") public WebElement fileAssignDueDate;
	@FindBy(xpath="//input[@id='duetxtHour'][contains(@class,'txtHour')]") public WebElement fileAssignDueHour;
	@FindBy(xpath="//input[@id='duetxtMinute'][contains(@class,'txtMinute')]") public WebElement fileAssignDueMinute;
	@FindBy(xpath="//select[@name='dueampm']") public WebElement fileAssignDueAmPm;	
	@FindBy(xpath="//a[@class='buttons btbl']/span") public WebElement assignFileAttachment;
	
	//Web Activity Assignment
	@FindBy(xpath="//div[@class='assignmentTypesLg webIcon']") public WebElement webActivity;
	@FindBy(xpath="//input[@id='assignmentTitle']") public WebElement webActivityTitle;
	@FindBy(xpath="//textarea[@id='note']") public WebElement webActivityInstructions;
	@FindBy(xpath="//input[@id='webLinkName']") public WebElement webActivityLinkName;
	@FindBy(xpath="//input[@id='webLinkURL']") public WebElement webActivityURL;
	@FindBy(xpath="//div[@id='setpolicies']/span/span[@class='icon-caret-right']") public WebElement webActivityNextAssign;
	public WebElement shareWebActivityToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//label[text()='"+strSectionName+"']/../input[@name='sectionCheckBox']"));
	}
	@FindBy(xpath="//input[@name='startdate']") public WebElement webActivityStartDate;
	@FindBy(xpath="//input[@pid='startHourMin'][contains(@class,'txtHour')]") public WebElement webActivityStartHour;
	@FindBy(xpath="//input[@pid='startHourMin'][contains(@class,'txtMinute')]") public WebElement webActivityStartMinute;
	@FindBy(xpath="//select[@name='startampm']") public WebElement webActivityStartAmPm;
	@FindBy(xpath="//input[@name='duedate']") public WebElement webActivityDueDate;
	@FindBy(xpath="//input[@pid='dueHourMin'][contains(@class,'txtHour')]") public WebElement webActivityDueHour;
	@FindBy(xpath="//input[@pid='dueHourMin'][contains(@class,'txtMinute')]") public WebElement webActivityDueMinute;
	@FindBy(xpath="//select[@name='dueampm']") public WebElement webActivityDueAmPm;	
	@FindBy(xpath="//li[@class='assign-blue-btn_cntr buttons btbl']") public WebElement webActivityAssign;
	
	//Elegant Handling
	public WebElement assignment(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//a[@title='"+strAssignmentName+"']/span"));
	}
	
	public WebElement assignmentCheck(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//table//a[@title='"+strAssignmentName+"']/span/../../../../..//input[@type='checkbox']"));
	}

	
	public WebElement assignmentTitleHeader(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//h1[@title='"+strAssignmentName+"']"));
	}
	@FindBy(xpath="//li[@id='previewtab']/a") public WebElement previewTab;	
	@FindBy(xpath="//input[@id='navbarSelect_input']") public WebElement questionNavigator;
	public WebElement question(WebDriver driver, int questionNumber)
	{
		return driver.findElement(By.xpath("//div[@id='navbarSelect_container']/ul/li[contains(text(),'Question "+questionNumber+"')]"));
	}
	@FindBy(xpath="//div[@class='questionHeader']//a[@class='questionProblemLink']") public WebElement adjustCredit;
	@FindBy(xpath="//div[@class='modal-title'][text()='Adjust credit']") public WebElement adjustCreditPopUpHeader;
	@FindBy(xpath="//div[text()='Award full credit']/span[@class='icon-down']") public WebElement awardFullCredit;
	@FindBy(xpath="//div[@class='creditSlide']//span[text()='Just for this assignment']") public WebElement fullCreditJustThisAssignment;
	@FindBy(xpath="//div[text()='Drop question and its points']/span[@class='icon-down']") public WebElement dropQuestion;
	@FindBy(xpath="//div[@class='drop_bar']//span[text()='Just for this assignment']") public WebElement dropQuestionJustThisAssignment;
	@FindBy(xpath="//div[@class='flag_bar']//span[text()='Flag for manual grading']") public WebElement flagForManualGrading;
	@FindBy(xpath="//button[@id='creditApply'][text()='adjust']") public WebElement applyCredit;
	@FindBy(xpath="//button[@id='confirmAdjustCredit'][text()='continue']") public WebElement confirmApplyCredit;
	//@FindBy(xpath="//div[@class='creditedMessage'][text()='Full credit for this question has been awarded to all students']") public WebElement fullCreditAwarded;
	@FindBy(xpath="//div[@class='questionHeader']/div[4]") public WebElement fullCreditAwarded;
	
	//@FindBy(xpath="//div[@class='creditedMessage'][text()='This question and its points have been dropped for all students']") public WebElement questionDropped;
	@FindBy(xpath="//div[@class='questionHeader']/div[4]") public WebElement questionDropped;
	
	@FindBy(xpath="//div[text()='This item has been flagged for manual grading for all students.']") public WebElement flaggedForManualGrading;
	@FindBy(xpath="//div[text()='Question is flagged for manual grading.']") public WebElement manualGradingFlagged;
	@FindBy(xpath="//a[@class='home_button_e']") public WebElement homeButton;
	
	//share assignments
	@FindBy(xpath="//*[@id='actionItems']//span[@class='icon-stack']") public WebElement assignmentOptions;
	@FindBy(xpath="//span[@class='action-label'][text()='Share']") public WebElement share;
	@FindBy(xpath="//div[@id='wantShare']/a/span/b") public WebElement confirmShare;
	@FindBy(xpath="//div[@id='innerWrapper']/div/a/b") public WebElement returnToHomeFromShare;
	@FindBy(xpath="//span[@class='action-label'][text()='Copy']") public WebElement Copy;
	@FindBy(xpath=".//*[@id='wantCopy']/a") public WebElement wantCopy;
	@FindBy(xpath=".//*[@class='btntwo copysection']//*[@class='btnwidth']/b") public WebElement clickCopyButton;
	@FindBy(xpath=".//*[@id='deleteSelectedAssignments']/span[2]") public WebElement deleteAssignment;
	@FindBy(xpath=".//*[@id='delete_assignment_facebox']/div/div/div[2]/div[2]/ul[@id='delete_save']/li") public WebElement deleteAssignmentConfirm;
	
	
	//Group
	@FindBy(xpath="//span[@class='action-label'][text()='Group']") public WebElement group;
	@FindBy(xpath="//span[@class='action-label'][text()='Add']") public WebElement add;
	@FindBy(xpath=".//*[@id='ungroupAssignDropHere']/span[2]") public WebElement undoGroup;
	public WebElement checkGroupAssignment(WebDriver driver, String assignmentName)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//*[@id='assignmentsContainerBody']/tr/td[3]/div[1]/div[2]//a[contains(text(),'"+assignmentName+"')]"));
	}
	
	@FindBy(xpath="(.//*[@id='modalCtr']/div[2]/div[1]/ul[1]/li[2]/div/input)[2]") public WebElement groupName;
	@FindBy(xpath="(.//*[@id='modalCtr']/div[2]/div[1]/ul[2]/li[2]/div/input)[2]") public WebElement groupDesc;
	@FindBy(xpath=".//*[@id='facebox']/div/div/div/div/div[2]//div[2]/ul[1]/li[1]") public WebElement groupNameSave;
	
	@FindBy(xpath=".//*[starts-with(@id,'group_')]/td[2]/a") public WebElement expandGroup;
	
	public WebElement shareToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//label[text()='"+strSectionName+"']/../input[@name='sectionCheckBox']"));
	}	
	@FindBy(xpath="//label[contains(text(),'start and due dates only')]/../input") public WebElement startNDueDateOnly;
	@FindBy(xpath="//label[contains(text(),'no policies')]/../input") public WebElement noPolicies;
	@FindBy(xpath="//label[contains(text(),'all policies')]/../input") public WebElement allPolicies;
	@FindBy(xpath="//a[@class='btntwo submit']/span/b") public WebElement submitShare;

	public WebElement selectAssignment(WebDriver driver, String assignmentName)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//*[@id='assignmentsContainerBody']//tr//td[2]//a//span[contains(text(),'"+assignmentName+"')]")) ;
	}
	public WebElement selectDuplicateAssignment(WebDriver driver, int chkbox ,String assignmentName)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//*[@id='assignmentsContainerBody']//tr['"+chkbox+"']//td[2]//a//span[contains(text(),'"+assignmentName+"')]")) ;
	}
	
	public WebElement selectAndClickAssignment(WebDriver driver, String assignmentName)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//*[@id='assignmentsContainerBody']//tr[2]//td[2]//a//span[contains(text(),'"+assignmentName+"')]")) ;
	}
	
	@FindBy(xpath=".//*[@id='copyAndShareId']/div/a") public WebElement assignmentEdit;
	@FindBy(xpath=".//*[@id='selectOptions']/div/div/ul/li[3]/a") public WebElement assignmentEditOption;
	@FindBy(xpath=".//*[@id='selectOptions']/div/div/ul/li[4]") public WebElement manageExtensions;
	@FindBy(xpath=".//*[@id='studentProfileID']") public WebElement studentCheckBox;
	@FindBy(xpath="//*[@class='adj_extension']/ul/li[2]/div[2]/div[1]/a") public WebElement editDueDateForStudentExtension;
	@FindBy(xpath=".//*[@id='selectOptions']/div/div/ul/li/a") public WebElement assignmentEditColleague;
	public WebElement selectQuestion(WebDriver driver, String questionTitle)
	{
		return driver.findElement(By.xpath(".//table[@id='assignmentListTable']//*[@id='qpicker_assignment_data']//tr//td//a[contains(text(),'"+questionTitle+"')]"));
	}
	
	public WebElement selectQuestionsIndividually(WebDriver driver, String questionTitle)
	{
		return driver.findElement(By.xpath(".//*[@id='questionListTableContainer']//table[@id='questionListTable']/tbody/tr/td/a[contains(text(),'"+questionTitle+"')]"));
	}
	
	
	
	@FindBy(xpath=".//*[@id='addthisQuestion']/span/b") public WebElement addThisQuestion;
	@FindBy(xpath="//*[@id='selectQnavgation']/div[1]/div[5]/div[1]/ul/li[1]/a") public WebElement addIndividualQuestions;
	@FindBy(xpath=".//*[@id='Qquestiontab']/a") public WebElement addQuestionTab;
	
	@FindBy(xpath=".//*[@id='editthisQuestion']") public WebElement editThisQuestion;
	@FindBy(xpath=".//*[@id='compinc']") public WebElement acceptAllAnswer;
	@FindBy(xpath=".//*[@id='saveSettings']") public WebElement saveSettings;
	@FindBy(xpath=".//*[@id='settingSavePopup']/a") public WebElement closeSettingsPopup;
	@FindBy(xpath=".//*[@id='questionViewTab']/div[1]/div[1]/a[4]") public WebElement nextQuestion;
	@FindBy(xpath=".//*[@id='saveExitButton']") public WebElement saveNExit;
	
	@FindBy(css= ".statusCell.borderTd:nth-child(2n)") public WebElement checkAssignmentStatus;
	@FindBy(xpath=".//*[@class='statusCell borderTd ui-draggable']/a[@class='statusToggle enabled']") public WebElement checkVisibilty;
	@FindBy(xpath=".//*[@id='policiestab']/a") public WebElement policyTab;
	@FindBy(xpath=".//*[@id='policiescontent']/div[1]/a") public WebElement viewAndEditPolicy;
	@FindBy(xpath=".//*[@id='grade_by_participation']") public WebElement awardFullCreditParticipant;

	//----------------------Review And Assign Policy Part----------------------
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[1]/ul/li[1]/span") public WebElement reviewTimeLimit;
	@FindBy(xpath=".//*[@id='showHidePoliciesSummary']") public WebElement reviewPolicySummary;
	@FindBy(xpath=".//*[@id='assignmentAvailAbleIdDay']") public WebElement assignmentsStartDate;
	@FindBy(xpath=".//*[@id='assignmentDueIdDay']") public WebElement assignmentsDueDate;
	
	@FindBy(css=".print") public WebElement reviewPrinting;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[1]/ul/li[3]/span") public WebElement reviewQuestionOrder;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[1]/ul/li[4]/span") public WebElement reviewPasswordProtect;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[1]/ul/li[5]/span") public WebElement reviewCreditGiven;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[2]/ul/li[2]/span") public WebElement reviewBOPA;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[1]/div[2]/ul/li[3]/span") public WebElement reviewStudentAttempts;
	
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[1]/span") public WebElement reviewAscentedCharacters;
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[2]/span") public WebElement reviewpunctuations;
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[3]/span") public WebElement reviewCase;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[1]/p") public WebElement reviewFeedBackAfterFirstAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[2]/p") public WebElement reviewFeedBackAfterAdditionalAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[3]/p") public WebElement reviewFeedBackAfterFullScore;
	
	@FindBy(xpath=".//*[@id='referenceType']/li[1]/span") public WebElement reviewQuestionPointValue;
	@FindBy(xpath=".//*[@id='QUESTION_TITLE_OFF']/span") public WebElement reviewQuestionPointValueOff;
	@FindBy(xpath=".//*[@id='referenceType']/li[2]/span") public WebElement reviewQuestionTitle;
	@FindBy(xpath=".//*[@id='referenceType']/li[3]/span") public WebElement reviewReference;
	@FindBy(xpath=".//*[@id='REFERENCES_OFF']/span") public WebElement reviewReferenceOff;
	@FindBy(xpath=".//*[@id='referenceType']/li[4]/span") public WebElement reviewExternalLinks;
	@FindBy(xpath=".//*[@id='referenceType']/li[5]/span") public WebElement reviewFormulas;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[1]/ul/li/h1") public WebElement revieweBookAssitantDeductions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[2]/ul/li/h1") public WebElement reviewHintsDeductions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[1]/h1") public WebElement reviewUsesofCheckMyWork;
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[2]/h1") public WebElement revieweCheckMyWorkDeductions;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[4]/span") public WebElement reviewSolutions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[5]/span") public WebElement reviewGuidedSolutions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[6]/span") public WebElement reviewAskToInstructor;
	@FindBy(xpath=".//*[@id='assistanceType']/li[7]/span") public WebElement reviewPracticeQuestions;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[8]/span") public WebElement reviewPalleteDisplay;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[1]/p") public WebElement reviewFeedbackafterFirstAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[2]/p") public WebElement reviewFeedbackafterAdditionalAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[3]/p") public WebElement reviewFeedbackafterFullScore;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[4]") public WebElement reviewFeedbackDueDate;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[1]") public WebElement reviewFeedbackafterQuestions1;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[2]") public WebElement reviewFeedbackafterQuestion2;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[3]") public WebElement reviewFeedbackafterQuestions3;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[4]") public WebElement reviewFeedbackafterQuestions4;

	@FindBy(xpath=".//*[@id='assistanceType']/li[1]/span") public WebElement reviewEbookQuiz; 
	@FindBy(xpath=".//*[@id='assistanceType']/li[2]/span") public WebElement reviewHintsQuiz; 
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/span") public WebElement reviewcheckWorkQuiz; 
	
	@FindBy(xpath=".//*[@id='Qassignmenttab']/a") public WebElement organizeAssignmentTab;
	@FindBy(xpath=".//tbody[@id='qpicker_assignment_data']/tr[1]/td[6]/input") public WebElement pointsValue;
	
	@FindBy(xpath="//*[@id='assignmentsContainerBody']//tr[3]/td[3]/a[contains(@class,'shared')]") public WebElement sharedIcon;
	@FindBy(xpath="//table[@id='assignmentListitem']//*[@id='assignmentsContainerBody']//tr[2]/td[3]/a[@class='shared']") public WebElement colleagueSharedIcon;
	@FindBy(xpath=".//*[@id='assignmentcontent']/div[2]/div[1]/div[1]/span/span[2]") public WebElement editStartDate;
	@FindBy(xpath=".//*[@id='innerWrapper']/div[4]/div[2]/div[1]/div[1]/span/span[2]") public WebElement editStartDateColleague;
	@FindBy(xpath=".//*[@id='dueDateEditLink']") public WebElement editEndDate;
	@FindBy(id="scheduleDateStart") public WebElement enterNewStartDate;
	@FindBy(xpath=".//*[@id='switchsectionlink']") public WebElement switchSections;
	@FindBy(xpath=".//*[@id='linkcontainer']/form[2]/div/div/div/a[1]") public WebElement sectionFirst;
	public WebElement selectSharedIcon(WebDriver driver, int index)
	{
		return driver.findElement(By.xpath(".//*[@id='assignmentsContainerBody']//tr["+index+"]//td[3]//a"));
	}
	
	public WebElement checkAssignmentStatusIndividually(WebDriver driver, int index)
	{
		return driver.findElement(By.xpath(".//*[@id='assignmentsContainerBody']//tr["+index+"]//td[6]"));
	}
	
	public WebElement selectSetion(WebDriver driver, String SectionName, int index)
	{
		return driver.findElement(By.xpath("//label[text()='"+SectionName+"']/../..//li["+index+"]//input[@name='sectionId_insId'][@type='checkbox']"));
	}
	
	@FindBy(xpath=".//*[@id='removeSharedAssignment']/div/div[2]/span/span[2]/a[1]/span/b") public WebElement stopSharing;
	@FindBy(xpath=".//*[@id='submit']/li[2]") public WebElement confirmStopSharing;
	
	public WebElement selectAssignments(WebDriver driver, int chkBoxNo)
	{
		return driver.findElement(By.xpath("//table[@id='assignmentListitem']//tbody//tr["+chkBoxNo+"]//input[@type='checkbox']"));
	}
	
	@FindBy(xpath=".//*[@id='assignment_2147637499']/td[1]/a") public WebElement dragAssignment;
	@FindBy(xpath=".//*[@id='moveAssignmentsToModulesNew']") public WebElement moveAssignment;
	@FindBy(xpath="//*[@id='moveassignment_list']/div[2]/table/tbody/tr/td[1]/span/input") public WebElement selectGroup;
	@FindBy(xpath=".//*[@id='editsection_save']") public WebElement save;
	@FindBy(xpath="//*[@id='moveassignment_list']/div[1]/table/tbody/tr/td[1]/span/input") public WebElement moveAssignmentToUnassignedGroup;

	//***************Policy Preview Page********************************************
	//----------------------Review And Assign Policy Part----------------------
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[1]/span") public WebElement policyPreviewTimeLimit;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[4]/span") public WebElement policyPreviewPrintingOff;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[3]/span") public WebElement policyPreviewreviewPrinting;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[6]/span") public WebElement policyPreviewreviewQuestionOrder;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[7]/span") public WebElement policyPreviewreviewPasswordProtect;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[2]/div[3]/div/ul/li[10]/span") public WebElement policyPreviewreviewCreditGiven;
		
		@FindBy(xpath=".//*[@id='ATTEMPT_SELECTED_UNLIMITED']") public WebElement policyPreviewreviewBOPA;
		@FindBy(xpath=".//*[@id='ALLOW_FOR_STUDY_ATTEMPTS_OFF']/span") public WebElement policyPreviewreviewStudentAttempts;
		
		@FindBy(xpath=".//*[@id='ACCENTED_CHARACTERS_ON']/span") public WebElement policyPreviewreviewAscentedCharacters;
		@FindBy(xpath=".//*[@id='IGNORESPACING_OFF']/span") public WebElement policyPreviewreviewpunctuations;
		@FindBy(xpath=".//*[@id='IGNORECASE_OFF']/span") public WebElement policyPreviewreviewCase;
		
		@FindBy(xpath=".//*[@id='feedbackAfterOne']") public WebElement policyPreviewreviewFeedBackAfterFirstAttempt;
		@FindBy(xpath=".//*[@id='feedbackFromTwo']") public WebElement policyPreviewreviewFeedBackAfterAdditionalAttempt;
		@FindBy(xpath=".//*[@id='feedbackFinal']") public WebElement policyPreviewreviewFeedBackAfterFullScore;
		
		@FindBy(xpath=".//*[@id='POINT_VALUE_ON']/span") public WebElement policyPreviewreviewreviewQuestionPointValue;
		@FindBy(xpath=".//*[@id='QUESTION_TITLE_OFF']/span") public WebElement policyPreviewreviewreviewQuestionTitle;
		@FindBy(xpath=".//*[@id='REFERENCES_ON']/span") public WebElement policyPreviewreviewreviewReference;
		@FindBy(xpath=".//*[@id='EXTERNAL_LINKS_ON']/span") public WebElement policyPreviewreviewreviewExternalLinks;
		@FindBy(xpath=".//*[@id='FORMULA_ON']/span") public WebElement policyPreviewreviewreviewFormulas;
		
		@FindBy(xpath=".//*[@id='libResourceVal']") public WebElement policyPreviewrevieweBookAssitantDeductions;
		@FindBy(xpath=".//*[@id='hintVal']") public WebElement policyPreviewreviewHintsDeductions;
		@FindBy(xpath=".//*[@id='limitcheckworkval']") public WebElement policyPreviewreviewUsesofCheckMyWork;
		@FindBy(xpath=".//*[@id='deductcheckworkval']") public WebElement policyPreviewrevieweCheckMyWorkDeductions;
		
		@FindBy(xpath=".//*[@id='SHOW_SOLUTION_ON']/span") public WebElement policyPreviewreviewSolutions;
		@FindBy(xpath=".//*[@id='STUDENT_GUIDE_ON']/span") public WebElement policyPreviewreviewGuidedSolutions;
		@FindBy(xpath=".//*[@id='ASK_INSTRUCTOR_OFF']/span") public WebElement policyPreviewreviewAskToInstructor;
		@FindBy(xpath=".//*[@id='PRACTICE_QUESTIONS_ON']/span") public WebElement policyPreviewreviewPracticeQuestions;
		
		@FindBy(xpath=".//*[@id='assistanceType']/li[8]/span") public WebElement policyPreviewreviewPalleteDisplay;
		
		@FindBy(xpath=".//*[@id='feedbackAfterOne']") public WebElement policyPreviewreviewFeedbackafterFirstAttempt;
		@FindBy(xpath=".//*[@id='feedbackPreviewId']/p[1]") public WebElement policyPreviewreviewFeedbackafterAdditionalAttempt;
		@FindBy(xpath=".//*[@id='feedbackPreviewId']/p[2]") public WebElement policyPreviewreviewFeedbackafterFullScore;
		@FindBy(xpath=".//*[@id='feedbackPreviewId']/p[3]") public WebElement policyPreviewreviewFeedbackDueDate;
		@FindBy(xpath=".//*[@id='feedbackPreviewId']/p[4]") public WebElement policyPreviewreviewFeedback;
		
/*		
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[1]") public WebElement reviewFeedbackafterQuestions1;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[2]") public WebElement reviewFeedbackafterQuestion2;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[3]") public WebElement reviewFeedbackafterQuestions3;
		@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/p[4]") public WebElement reviewFeedbackafterQuestions4;*/
		@FindBy(xpath=".//*[@id='LANGUAGE_PALLETTE_OFF']/span") public WebElement policyPreviewForeignPalleteOff;
		@FindBy(xpath=".//*[@id='EBOOK_OFF']/span") public WebElement policyPreviewreviewEbookQuiz; 
		@FindBy(xpath=".//*[@id='HINTS_OFF']/span") public WebElement policyPreviewreviewHintsQuiz; 
		@FindBy(xpath=".//*[@id='CHECK_WORK_OFF']/span") public WebElement policyPreviewreviewcheckWorkQuiz; 
		@FindBy(xpath=".//*[@id='STUDENT_GUIDE_OFF']/span") public WebElement policyPreviewGuidedSolutionsOff;
		@FindBy(xpath=".//*[@id='PRACTICE_QUESTIONS_OFF']/span") public WebElement policyPreviewPracticeQuestionsOff;

		
		@FindBy(xpath=".//*[@id='activityMain']/div[2]/div/div[1]/a") public WebElement assignmentResults;
		@FindBy(xpath=".//*[@id='generated_report_single_assignment_name_e']") public WebElement assignmentReportsPage;
		@FindBy(xpath=".//*[@id='assignmentPreviewPolicySummary']/h5") public WebElement policySummaryReportsPage;

		
		
		//Reports page policy
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[1]/span") public WebElement timeLimitReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[2]/span") public WebElement printingReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[3]/span") public WebElement QuestionOrderReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[4]/span") public WebElement passwordReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[5]/span") public WebElement creditReportsPage;
		
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[1]") public WebElement attemptsReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[2]/span") public WebElement BOPAReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[3]") public WebElement scoringDeductionsReportsPage;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[4]/span") public WebElement studyAttemptsReportsPage;
		
		@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[1]/span") public WebElement ascentedReportsPage;
		@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[2]/span") public WebElement spacingReportsPage;
		@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[3]/span") public WebElement correctLetterReportsPage;
		
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/li[1]/p") public WebElement FeedBackAfterFirstAttemptReports;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/li[2]/p") public WebElement FeedBackAfterAdditionalAttemptReports;
		@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/li[3]/p") public WebElement reviewFeedBackAfterFullScoreReports;
		
		@FindBy(xpath=".//*[@id='referenceType']/li[1]/span") public WebElement reviewreviewQuestionPointValueReports;
		@FindBy(xpath=".//*[@id='referenceType']/li[2]/span") public WebElement reviewreviewQuestionTitleReports;
		@FindBy(xpath=".//*[@id='referenceType']/li[3]/span") public WebElement reviewreviewReferenceReports;
		@FindBy(xpath=".//*[@id='referenceType']/li[4]/span") public WebElement reviewreviewExternalLinksReports;
		@FindBy(xpath=".//*[@id='referenceType']/li[5]/span") public WebElement reviewreviewFormulasReports;
		
		@FindBy(xpath=".//*[@id='assistanceType']/li[1]/ul/li/h3") public WebElement revieweBookAssitantDeductionsReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[2]/ul/li/h3") public WebElement reviewHintsDeductionsReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[1]/h3") public WebElement reviewUsesofCheckMyWorkReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[2]/h3") public WebElement revieweCheckMyWorkDeductionsReports;
		
		@FindBy(xpath=".//*[@id='assistanceType']/li[4]/span") public WebElement reviewSolutionsReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[5]/span") public WebElement reviewGuidedSolutionsReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[6]/span") public WebElement reviewAskToInstructorReports;
		@FindBy(xpath=".//*[@id='assistanceType']/li[7]/span") public WebElement reviewPracticeQuestionsReports;
		
		//adjust Crediting in Reports page
		@FindBy(xpath="//*[@class='questionHeader']//div[3]/a") public WebElement reportsAdjustCredit;
		@FindBy(xpath=".//*[@id='adjustCreditDialog']/div[2]/div[1]/div[2]/div[3]/div") public WebElement reportsFlagForManualGrading;
		@FindBy(xpath=".//*[@id='creditApply']") public WebElement reportsApply;
		@FindBy(xpath=".//*[@id='confirmAdjustCredit']") public WebElement reportsConfirmApply;
		@FindBy(xpath=".//*[@id='contentArea']/div[4]/div/div[1]/div[3]") public WebElement reportsManuaGradingIns;
		
		
		public WebElement questionTypesOrganizeTab(WebDriver driver,int questionNumber)
		{
			return driver.findElement(By.xpath(".//*[@id='qpicker_assignment_data']/tr["+questionNumber+"]/td[3]/div/div[2]"));
	    }
		
		public WebElement questionTypes(WebDriver driver,int questionNumber)
		{
			return driver.findElement(By.xpath(".//*[@id='questionListTable']/tbody/tr["+questionNumber+"]/td[3]"));
	    }

		@FindBy(xpath=".//*[@class='references__cell--question-type']") public WebElement questionTitleInsPreview;
		@FindBy(xpath=".//*[@id='navbar']/div/span[2]/button") public WebElement nextQuestionButtonInPreview;
		@FindBy(xpath=".//iframe[@id='ezFrame']") public WebElement iFramePreviewPage;
		
		//INS Preview
		@FindBy(xpath="//a[text()='preview']") public WebElement lnkPreview;
		@FindBy(xpath="//*[@class='hm_questionTitle']") public WebElement questionTitleIns;
		@FindBy(xpath="//*[@class='creditedMessage']") public WebElement questionCreditMessage;
		@FindBy(xpath="//*[@class='questionScoreControls questionScoreControls--text-only']") public WebElement questionMGMessage;
		@FindBy(xpath="//button[@class='icon-next nextArrow']") public WebElement lnkNextArrowIns;
		@FindBy(xpath="//a[@class='home_button_e']") public WebElement lnksectionHome;
		
		//Std Preview
		@FindBy(xpath=".//*[@id='viewAsStudent']") public WebElement studentView;
		public WebElement selectAssignmentStudentPreview(WebDriver driver, int assignmentNumber)
		{
			return driver.findElement(By.xpath(".//*[@class='assignment-list-content']/tbody/tr["+assignmentNumber+"]/td[2]/a"));
			
		}
		@FindBy(xpath=".//*[@id='passwordForm']/label/input") public WebElement enterPassword;
		@FindBy(xpath=".//*[@id='passwordForm']/input[6]") public WebElement submitPassword;
		@FindBy(xpath=".//*[@id='eztPopup']/div[3]/a") public WebElement takeAssignmentStdPreview;
		@FindBy(xpath=".//*[@id='navbarSelect_input']") public WebElement questionNavigatorStdPreview;
		
		public WebElement selectOption(WebDriver driver, int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__row question--matching']/div//ul/li/div/span)["+index+"]"));
			
		}
		@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[3]/div/input[2]") public WebElement fillInTheBlanksAnswers;
		@FindBy(xpath=".//*[@id='contentArea']/div[1]/div[2]/div/div[2]") public WebElement randomVariable;
		public WebElement selectOptionRanking(WebDriver driver, int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__row question--ranking']/div/ul/li/div/span)["+index+"]"));
			
		}
		public WebElement selectRankingAnswer1(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath(".//*[@class='matching-ranking__options show']/ul/li["+index+"]"));
		}
		@FindBy(xpath=".//*[@class='matching-ranking__answer-options']/div/div[2]") public List<WebElement> rankingOptionsNew;
		@FindBy(id="answer_ifr") public WebElement iframe;
		@FindBy(xpath="(.//*[@class='matching-ranking__options show']/ul/li)[3]") public WebElement selectOptionNumbers;
		@FindBy(xpath="(.//*[@class='matching-ranking__options show']/ul/li)[2]") public WebElement selectOptionNumber1;
		
		@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[2])[5]") public WebElement selectOptionNumberss;
		@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[2])[3]") public WebElement selectOptionNumber3;
		@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[4])[4]") public WebElement selectOptionNumber2;
		@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[5])[2]") public WebElement selectOptionNumber4;
		@FindBy(xpath="(.//*[@class='answer--matching__choices']/button[6])[1]") public WebElement selectOptionNumber5;
		
		@FindBy(xpath=".//*[@class='matching-ranking__answer-options']/div") public List<WebElement> rankingOptions;
		public WebElement selectRankingAnswers2(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
		}
		public WebElement selectRankingAnswers3(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
		}
		public WebElement selectRankingAnswers4(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
		}
		public WebElement selectRankingAnswers5(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
		}
		public WebElement selectRankingAnswers1(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__options show']/ul/li)["+index+"]"));
		}
		@FindBy(xpath=".//*[@id='navbar']/div/span[2]/button") public WebElement nextQuestionStdPreview;
		@FindBy(xpath=".//*[@id='studentViewClose']") public WebElement closeStudentPreview;
		@FindBy(xpath="//body[@id='tinymce']") public WebElement essayAnswer;
		@FindBy(xpath="html/body/form[1]/div[2]/div[1]/div[2]/div/div[3]/div[1]/label") public WebElement trueorfalseNew;
		@FindBy(xpath="//*[@id='navbarSubmit']") public WebElement submitAssignment;
		@FindBy(xpath="//*[@id='TB_ajaxContent']/div[5]/input[1]") public WebElement submitAssignmentAnyway;
		@FindBy(xpath=".//*[contains(@title,'Submit')]") public WebElement confirmSubmit;
		@FindBy(xpath=".//*[@id='container_inner']/div[3]/div/div/div/ul[2]/li/a") public WebElement myCourses;
		@FindBy(xpath=".//*[@id='nextScoreQ']") public WebElement scoreTheQuestion;
		@FindBy(xpath=".//*[@title='Continue Anyway']") public WebElement continueAnyway;
		public WebElement selectOptionMatchingText(WebDriver driver,int index)
		{
			return driver.findElement(By.xpath(".//*[@class='myAnswers']/div[3]/div[3]/div/div["+index+"]/div[2]"));
		}
		
	
		public WebElement selectOptionButton(WebDriver driver, int index)
		{
			return driver.findElement(By.xpath(".//*[@class='no-style-ul']/li["+index+"]"));
			
		}
		public WebElement selectOptionMatchingClassicText(WebDriver driver, int index)
		{
			return driver.findElement(By.xpath("(.//*[@class='myAnswers']/div[3]/div)["+index+"]"));
			
		}
		public WebElement rankingOptionsText(WebDriver driver, int index)
		{
			return driver.findElement(By.xpath(".//*[@class='myAnswers']/div[3]/div[1]/div["+index+"]/div[2]"));
			
		}
		public WebElement selectOptionMatchingClassicButton(WebDriver driver, int index,int index1)
		{
			return driver.findElement(By.xpath("(.//*[@class='matching-ranking__content--width'])["+index+"]/div[3]/div[2]/ul/li["+index1+"]"));
			
		}
		@FindBy(xpath=".//*[@id='alaForm']/p") public WebElement timedMessage;
		@FindBy(xpath=".//*[@id='alaForm']/input[8]") public WebElement startAssignmentStdPreview;
		@FindBy(xpath=".//*[@class='hm_questionTitle']") public WebElement questionTitles;
	/*
	 * @FindBy(xpath="//div[@id='navbarSelect_container']/ul/li") public WebElements
	 * insPrevQuestionList;
	 */
		public List<WebElement> insPrevQuestionList(WebDriver driver) {
			return driver.findElements(By.xpath("//div[@id='navbarSelect_container']/ul/li"));
		}
		
		//***********Student assignment preview classic
		
		@FindBy(xpath="//*[@id='viewAsStudent']") public WebElement studentPreview;
		@FindBy(xpath="//*[@id='viewAsInstructor']") public WebElement instructorView;
		@FindBy(xpath="//*[@class='assignment-list-content']") public WebElement assignmentTableInStdPrev;
		
		public WebElement stdPrevAssignment(WebDriver driver, String assignmentTitle) {
			return driver.findElement(By.xpath("//*[text()='" + assignmentTitle + "']"));
		}
		
		//16-Aug-2021
		@FindBy(xpath="//div[@id='container_inner']/div[@class='header-nav']/div/div/div/ul[@class='right']/li[1]") public WebElement myCoursesLink;
		@FindBy(xpath="//input[@id='sectionAdress']") public WebElement sectionAddress;
}
