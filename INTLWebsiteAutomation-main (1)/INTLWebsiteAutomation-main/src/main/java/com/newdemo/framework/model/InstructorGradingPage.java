package com.newdemo.framework.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class InstructorGradingPage {
	
	@FindBy(xpath="//span[contains(@class,'caret-right')]/span[text()='Assignments to grade']") public WebElement assignmentsToGrade;
	public WebElement assignmentToGrade(WebDriver driver, String strAssignmentName)
	{
		return driver.findElement(By.xpath("//a[contains(text(),'" + strAssignmentName + "']"));
	}
	@FindBy(xpath="//div[@id='gradePortletContainer']//p/a") public List<WebElement> assignmentToGrade;
	@FindBy(xpath="//h1[@class='Pagehead left hdrmrgbtm']") public WebElement assignmentHeader;
	@FindBy(xpath="//a[@id='show_grading_queue_e']/span") public WebElement showGradingQueue;
	@FindBy(xpath="//a[@id='grade_by_question_link_e']") public WebElement gradeByQuestion;
	public WebElement gradeByStudent(WebDriver driver, String strStudentName)
	{
		return driver.findElement(By.xpath("//ul[@id='grade_list_box_e']/li/a[text()='" + strStudentName + "']"));
	}
	@FindBy(xpath="//input[@class='score score-input--mangrade']") public List<WebElement> score;
	@FindBy(xpath="//*[@id='ManualGrading_Page']/span") public List<WebElement> pageNumberNavElements;
	@FindBy(xpath="//textarea[contains(@class,'instructorComment')]") public List<WebElement> instructorComment;
	@FindBy(xpath="//span[@class='manualGradeStatusInfo']/span") public List<WebElement> gradeStatusInfo;
	@FindBy(xpath="//span[@class='commentSavedInfo']/span") public List<WebElement> commentSavedInfo;
	
	@FindBy(xpath="(//div[@class='current-question-num'])[1]") public WebElement totalQuestions;
	@FindBy(xpath="//div[@class='saveandexitDiv']//button[@id='nextQuestion']") public WebElement nextQuestion;
	@FindBy(xpath="//button[@id='firstbtn'][text()='Go to grading queue']") public WebElement lastQuestion;
	//*****changed by sayan start
	@FindBy(xpath="//div[@class='button_bar']/child::button[text()='Exit grading' or text()='Go to grading queue']") public WebElement lastQuestion1;
	@FindBy(xpath="//div[@class='button_bar']/child::button[text()='Exit grading']") public WebElement exitGradingBtn;
	@FindBy(xpath="//div[@class='button_bar']/child::button[text()='Continue grading']") public WebElement continueGradingBtn;
	//*****changed by sayan end
	
	@FindBy(xpath="//button[@id='nextStudent']") public WebElement nextStudent;
	@FindBy(xpath="//div[@id='lastStudentDialog1']//button[text()='Ok']") public WebElement lastStudent;
	
	@FindBy(xpath="//a[@class='home_button_e']") public WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'file attachment')]") public WebElement gradeFileAssignment;
	@FindBy(xpath="//a[@class='studentResultSubmited']") public WebElement studentResultSubmited;
	@FindBy(xpath="//td[@class='textAlignCenter']//input") public WebElement fileAttachScore;
	@FindBy(xpath="//a[@class='addComment']") public WebElement fileAttachAddComment;
	@FindBy(xpath="//textarea[@id='privateCommentBox']") public WebElement fileAttachComment;
	@FindBy(xpath="//a[@id='addcomment_btn']/span") public WebElement fileAttachSaveComment;
	@FindBy(xpath="//span[@class='right submitBtn']//span/b") public WebElement fileAttachSubmitScore;
	@FindBy(xpath="//a[text()=' Return to section home']/span") public WebElement returnToSectionHome;
	
	@FindBy(xpath="//span[@class='header-title-js'][text()='Messages']") public WebElement messages;	
	@FindBy(xpath="//a[@class='assignments'][contains(text(),'student inquiries')]") public WebElement studentInquiry;
	
	@FindBy(xpath="//a[text()='back to section home']/span") public WebElement backToSectionHome;
	@FindBy(xpath="//a[@class='btnsmalltwo big_button1']/span/b") public List<WebElement> reply;
	@FindBy(xpath="//textarea[@id='note']") public WebElement answerStudentQuestion;
	@FindBy(xpath="//select[@id='responseOption']") public WebElement responseType;  
	@FindBy(xpath="//a[@id='sendMsg']/span/b") public WebElement sendMessage;
	
	@FindBy(xpath="//li[@id='messagetab']/a") public WebElement messageHistoryTab;
	@FindBy(xpath="//select[@class='sort_most_recent']") public WebElement sortMessages; //most recent  //A - Z
	
	@FindBy(xpath="//*[@id='actionItems']//span[@class='icon-stack']") public WebElement assignmentOptions;
	/*@FindBy(xpath="//span[@class='action-label'][text()='Manage dates']") public WebElement manageDates;*/
	//@FindBy(xpath=".//*[@id='selectOptions']/div/div/ul/li[4]/a") public WebElement manageDates;
	@FindBy(xpath="//*[@class='action-menu']/li[4]") public WebElement manageDates;
	@FindBy(xpath="//li[@class='li_space clearfix due_cls']//a[text()='edit']") public WebElement editDueDate;
	@FindBy(xpath="//input[@id='adjustDueDate']") public WebElement adjustDueDate;
	@FindBy(xpath="//input[@id='adjustDueHourMin']") public WebElement adjustDueHourMin;
	@FindBy(xpath="//a[@id='dateSubmitButton']") public WebElement dateSubmit;
	
	@FindBy(xpath="//span[@class='icon-home']")public WebElement sectionHome;
	@FindBy(xpath=".//*[@id='grade_report_list_cntr_e']/ul[2]/li[1]/a") public WebElement selectStudent;
	
	public List<WebElement>[] selectAssignmentToViewResults(WebDriver driver)
	{
		List<WebElement>[] resultList = new ArrayList[2];
		
		// initializing
        for (int i = 0; i < resultList.length; i++) {
        	resultList[i] = new ArrayList<WebElement>();
        }
		
		resultList[0].addAll(driver.findElements(By.xpath("//*[@id='studentAssignmentList']/tbody/tr")));
		resultList[1].addAll(driver.findElements(By.xpath("//*[@id='studentAssignmentList']/tbody/tr/td/a")));
		
		resultList[0].remove(0);	
		
		return resultList;
		
	}
	
	
	public List<WebElement> getAssignmentListFromInsReports(List<WebElement>[] bothAssignmentAndAttemptList) {
		String attrVal = "";
		int i = 0;
		List<WebElement> resultList = new ArrayList<WebElement>();
		
		for( WebElement element: bothAssignmentAndAttemptList[0] ) {
			try {
				i++;
				attrVal = element.getAttribute("class");
				if(attrVal.contains("student_row")) {
					resultList.add(bothAssignmentAndAttemptList[1].get(i - 1));	
					
				} else {
					
					continue;
				}
			} catch(Exception e) {
				
				System.out.println("Could not fetch \"class\" attribute of element no: " + i + " in getAssignmentListFromInsReports() method");
				
				continue;
			}
			
		}
		return resultList;
	}
	
	@FindBy(xpath=".//*[@id='assignmentPreviewPolicySummary']/h5/span") public WebElement policySummaryReportsPage;
	
	//Reports Page Policy objects
	
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[1]/span") public WebElement reportsTimeLimit;
	@FindBy(xpath=".//*[@id='showHidePoliciesSummary']") public WebElement reportsPolicySummary;
	@FindBy(xpath=".//*[@id='assignmentAvailAbleIdDay']") public WebElement assignmentsStartDate;
	@FindBy(xpath=".//*[@id='assignmentDueIdDay']") public WebElement assignmentsDueDate;
	
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[2]/span") public WebElement reportsPrinting;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[3]/span") public WebElement reportsQuestionOrder;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[4]/span") public WebElement reportsPasswordProtect;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[1]/ul/li[5]/span") public WebElement reportsCreditGiven;
	
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[2]/span") public WebElement reportsBOPA;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[1]/div[2]/ul/li[5]/span") public WebElement reportsStudentAttempts;
	
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[1]/span") public WebElement reportsAscentedCharacters;
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[2]/span") public WebElement reportspunctuations;
	@FindBy(xpath=".//*[@id='answerTolerance']/ul/li[3]/span") public WebElement reportsCase;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[1]/p") public WebElement reportsFeedBackAfterFirstAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[2]/p") public WebElement reportsFeedBackAfterAdditionalAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[3]/p") public WebElement reportsFeedBackAfterFullScore;
	
	@FindBy(xpath=".//*[@id='referenceType']/li[2]/span") public WebElement reportsQuestionPointValue;
	@FindBy(xpath=".//*[@id='referenceType']/li[2]/span") public WebElement reportsQuestionPointValueOff;
	@FindBy(xpath=".//*[@id='referenceType']/li[1]/span") public WebElement reportsQuestionTitle;
	@FindBy(xpath=".//*[@id='referenceType']/li[3]/span") public WebElement reportsReference;
	@FindBy(xpath=".//*[@id='REFERENCES_OFF']/span") public WebElement reportsReferenceOff;
	@FindBy(xpath=".//*[@id='referenceType']/li[4]/span") public WebElement reportsExternalLinks;
	@FindBy(xpath=".//*[@id='referenceType']/li[5]/span") public WebElement reportsFormulas;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[1]/ul/li/h3") public WebElement reportseBookAssitantDeductions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[2]/ul/li/h3") public WebElement reportsHintsDeductions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[1]/h3") public WebElement reportsUsesofCheckMyWork;
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/ul/li[2]/h3") public WebElement reportseCheckMyWorkDeductions;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[4]/span") public WebElement reportsSolutions;
	@FindBy(xpath=".//*[@id='assistanceType']/li[5]/span") public WebElement reportsGuidedSolutions;
	@FindBy(xpath="//*[contains(text(),'ask the instructor')]") public WebElement reportsAskToInstructor;
	@FindBy(xpath=".//*[@id='assistanceType']/li[7]/span") public WebElement reportsPracticeQuestions;
	
	@FindBy(xpath=".//*[@id='assistanceType']/li[8]/span") public WebElement reportsPalleteDisplay;
	
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[1]/p") public WebElement reportsFeedbackafterFirstAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[2]/p") public WebElement reportsFeedbackafterAdditionalAttempt;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[3]/p") public WebElement reportsFeedbackafterFullScore;
	@FindBy(xpath=".//*[@id='policiescontent']/div[2]/div[3]/div[2]/ul/li[4]") public WebElement reportsFeedbackDueDate;
	
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/p[1]") public WebElement reportsFeedbackafterQuestions1;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/p[2]") public WebElement reportsFeedbackafterQuestion2;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/p[3]") public WebElement reportsFeedbackafterQuestions3;
	@FindBy(xpath=".//*[@id='policy_assignment_type']/div[2]/div[3]/div[2]/ul/p[4]") public WebElement reportsFeedbackafterQuestions4;

	@FindBy(xpath=".//*[@id='assistanceType']/li[1]/span") public WebElement reportsEbookQuiz; 
	@FindBy(xpath=".//*[@id='assistanceType']/li[2]/span") public WebElement reportsHintsQuiz; 
	@FindBy(xpath=".//*[@id='assistanceType']/li[3]/span") public WebElement reportscheckWorkQuiz; 
	
	@FindBy(xpath=".//*[@id='navbarSelect_input']") public WebElement selectQuestionDropdown;
	@FindBy(xpath=".//*[@id='navbarSelect_container']/ul/li") public List<WebElement> questionList; 
	@FindBy(xpath=".//*[@class='questionProblemLink']") public WebElement adjustCreditInReports;
	@FindBy(xpath=".//*[@id='adjustCreditDialog']/div[2]/div[1]/div[2]/div[1]/div[1]") public WebElement awardFullCredit;
	@FindBy(xpath=".//*[@id='adjustCreditDialog']/div[2]/div[1]/div[2]/div[1]/div[2]/label[1]/span")public WebElement awardFullCreditForThisAssignment;
	@FindBy(xpath=".//*[@id='creditApply']") public WebElement adjust;
	@FindBy(xpath=".//*[@id='confirmAdjustCredit']") public WebElement confirmAdjust;
	
	@FindBy(id="ezFrame") public WebElement iframe;
	@FindBy(xpath=".//*[@id='adjustCreditDialog']/div[2]/div[1]/div[2]/div[3]/div") public WebElement flagForManualGrading;
	
	
	
	//@FindBy(xpath=".//*[@id='contentArea']/div[1]/div/div[1]/div[4]") public WebElement manualGradable;
}
	