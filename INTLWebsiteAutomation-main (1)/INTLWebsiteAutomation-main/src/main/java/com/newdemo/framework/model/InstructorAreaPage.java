package com.newdemo.framework.model;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class InstructorAreaPage {
	
	@FindBy(xpath="//a/span[@class='icon-plus']") public WebElement addAssignment;
	
	//Post Messages
	@FindBy(xpath="//a[contains(@class,'msg-setting')]") public WebElement msgSetting;
	@FindBy(xpath="//a[@id='postNewMsg']") public WebElement postNewMsg;
	@FindBy(id="announcementText")public WebElement announcementArea;	
	public WebElement courseShareMessage(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//td[text()='" + strCourseName + "']/preceding-sibling::td/input")) ;
	}	
	public WebElement sectionShareMessage(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//td[text()='" + strSectionName + "']/preceding-sibling::td/input")) ;
	}	
	@FindBy(xpath="//a[contains(@class,'save-msg')]")public WebElement saveMessage;
	//@FindBy(xpath="//a[contains(@class,'cancel-button')]")public WebElement closeMessages;
	//===changed by Gaurav
	@FindBy(xpath="//a[contains(@class,'cancel-js icon-cancel-circle right cancel-button')]")public WebElement closeMessages;
	@FindBy(xpath="//a[@id='mngPastMsg']") public WebElement managePastMessages;	
	public WebElement deleteMessage(WebDriver driver, String strMessage)
	{
		return driver.findElement(By.xpath("//a[text()='" + strMessage + "']/../..//a[contains(@class,'delete-msg')]")) ;
	}	
	public WebElement editMessage(WebDriver driver, String strMessage)
	{
		return driver.findElement(By.xpath("//a[contains(@class,'editmessage')][text()='" + strMessage + "']")) ;
	}

	//Book marks
	@FindBy(xpath="//div[@class='bookmark-portlet clear']//span[@class='icon-cog']") public WebElement bookmarkSetting;
	@FindBy(xpath="//input[@name='newBookmarkName']")public WebElement newBookmarkName;
	@FindBy(xpath="//input[@name='newBookmarkAddress']")public WebElement newBookmarkAddress;
	@FindBy(xpath="//input[@name='newBookmarkApplyAllSections']")public WebElement applyBookmarkAllSections;
	@FindBy(id="saveNewBookmark")public WebElement saveBookmark;
	@FindBy(xpath="//div[@class='bookmark-msg']")public WebElement bookmarkMessage;
	@FindBy(xpath="//a[@class='right buttons btgy smbtgy']")public WebElement closeBookmarkMessage;
	@FindBy(xpath="//span[@class='icon-eye-close']")public WebElement showBookmarks;
	public WebElement bookmark(WebDriver driver, String strBookmarkname)
	{
		return driver.findElement(By.xpath("//a[text()='" + strBookmarkname + "']")) ;
	}
	@FindBy(xpath="//div[@id='bookmarkPortletContainer']//span[contains(@class,'icon-caret-right')]")public WebElement expandBookmarks;
	
	//Instructor Info
	@FindBy(xpath="//div[@id='sectionInfoPortletContainer']//span[contains(@class,'context-menu')]") public WebElement instructorInfoSetting;
	@FindBy(id="editInstructorInfo")public WebElement editInstructorInfo;
	@FindBy(id="imageFileURL")public WebElement imageFileURL;
	@FindBy(id="email")public WebElement email;
	@FindBy(id="basicInfo")public WebElement basicInfo;
	@FindBy(id="saveForAllSections")public WebElement applyInsInfoToAllSections;
	@FindBy(xpath="//a[contains(@class,'save-button-js')]")public WebElement saveInstructorInfo;
	@FindBy(xpath="//div[contains(@class,'confirmation-js')]//strong")public WebElement instructorInfoMessage;
//	@FindBy(xpath="//a[contains(@class,'cancel-and-reload')]")public WebElement closeInstructorInfoMessage;
	//***added by sayan start
	@FindBy(xpath="//*[text()='Instructor info' or text()='confirmation']/following-sibling::a") public WebElement closeInstructorInfoMessage;
	//***added by sayan end
	@FindBy(xpath="//p[@class='instructor-info']")public WebElement instructorInfo;
	@FindBy(xpath="//p[@class='instructor-email']")public WebElement instructorEmail;
	
	//Upload Syllabus
	@FindBy(xpath="//a[contains(@class,'upload-syllabus')]")public WebElement uploadSyllabus;
	@FindBy(id="syllabusFileURL")public WebElement syllabusFileURL;
	@FindBy(xpath="(//input[@type='file'])[1]") public WebElement txtFileUploadBackEnd;
	@FindBy(id="saveSyllabusForAllSections")public WebElement saveSyllabusForAllSections;
	@FindBy(xpath="//a[contains(@class,'upload-syllabus-specific')]")public WebElement uploadSpecificSyllabus;
	@FindBy(xpath="//div[contains(@class,'modify-syllabus')]//a[@class='syllabus-text'][text()='view']")public WebElement downloadSyllabus;
	
	//Insights
	@FindBy(xpath="//li[@id='performance_tab_e']/a/span[text()='Performance']]")public WebElement performance;
	@FindBy(xpath="//a[@id='insightsLink']/span")public WebElement insights;
	@FindBy(xpath="//span[@class='quadrant-bubble'][text()='1']")public List<WebElement> quadrantBubbles;
	@FindBy(xpath="//span[contains(text(),'Dive Deeper')]")public WebElement diveDeeper;
	@FindBy(xpath="//*[name()='svg']//*[name()='circle']")public List<WebElement> studentsCircle;
	@FindBy(xpath="//*[name()='svg']//*[name()='g' and @class='highcharts-markers highcharts-tracker']//*[name()='path']")public List<WebElement> assignmentsSquare;
	@FindBy(xpath="//span[contains(@class,'icon-file2 assignmentsIcon-js')]")public WebElement assignmentDistribution;
	@FindBy(xpath="//span[contains(@class,'icon-icn_student studentsIcon-js')]")public WebElement studentDistribution;
	@FindBy(xpath="//span[@class='icon-icn_target']/../span[text()='SCORE']")public WebElement viewByScore;
	@FindBy(xpath="//span[@class='icon-icn_quiz']/../span[text()='TIME SPENT']")public WebElement viewByTime;
	@FindBy(xpath="//li[@class='card-popup-name-cntr-js']")public WebElement studentName;
	@FindBy(xpath="//span[text()='See assignment(s)']")public WebElement seeAssignments;
	@FindBy(xpath="//li[@class='card-popup-name-cntr-js']")public WebElement assignmentName;
	@FindBy(xpath="//span[text()='See who']")public WebElement seeWho;
	@FindBy(xpath="//div[@class='backIcon']")public WebElement backIcon;
	@FindBy(xpath="//span[contains(@class,'quick-help')]")public WebElement quickHelp;
	@FindBy(xpath="//div[@class='quick-guide-container']//span[@class='icon-cancel-circle']")public WebElement closeQuickHelp;
	@FindBy(xpath="//div[@class='quick-guide-container']//img")public WebElement quickHelpImage;
	@FindBy(xpath="//div[contains(@class,'left-menu-bar')][contains(@class,'icon')]")public WebElement leftMenuBar;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Section home']")public WebElement leftMenuSectionHome;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Library']")public WebElement leftMenuLibrary;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Performance']")public WebElement leftMenuPerformance;
	@FindBy(xpath="//li[@class='header-left-menu-bar-item-submenu-item']/span[text()='Gradebook']")public WebElement leftSubMenuPerformance;
	@FindBy(xpath="//li[@class='header-left-menu-bar-item-submenu-item']/span[text()='Reports']")public WebElement leftSubMenuReports;
	@FindBy(xpath="//li[contains(@class,'submenu-item')]/span[text()='Reports']")public WebElement leftSubMenuInsight;
	@FindBy(xpath="//div[@class='triangle-image switch-section-js']")public WebElement switchSectionTriangle;
	public WebElement switchToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//div[@class='section-item'][text()='"+strSectionName+"']")) ;
	}
	@FindBy(xpath="//span[@id='iconUser']")public WebElement userIcon;
	@FindBy(xpath="//div[@class='my-account my-account-js']")public WebElement myAccount;
	@FindBy(xpath="//div[@id='helpLink']")public WebElement helpLink;
	@FindBy(xpath="//ul[@id='helpLinkListHeader']/li/a[text()='Tutorials']")public WebElement tutorials;
	@FindBy(xpath="//ul[@id='helpLinkListHeader']/li/a[text()='Support']")public WebElement support;
	@FindBy(xpath="//li[text()='Insight - Quick guide']")public WebElement insightQuickGuide;
	
	@FindBy(xpath="//span[@class='icon-home']")public WebElement sectionHome;
	
	
	@FindBy(xpath="//*[@title='performance']") public WebElement performanceTab;
	@FindBy(xpath="//*[@id='performance_drop_down_e']/li/a[@title='reports page']") public WebElement reports;
	@FindBy(xpath="//*[@class='reportTypeContainer']/div[2]/ul/li/div/a[text()='Student performance']") public WebElement studentPerformance;
	@FindBy(xpath="//*[@id='studentSearchField']") public WebElement enterStudentName;
	@FindBy(xpath="//*[@id='assignment_question']/span[2]") public WebElement assignmentTitleInsReports;
	@FindBy(xpath="//*[@id='subReport']") public WebElement totalScoreNPoint;
	@FindBy(xpath="//*[@class='subReportGradeParticipation']/div") public WebElement fullCreditForAttemptElement;
	@FindBy(xpath="//*[@class='ac_results']") public WebElement stdNamesDropDown;
	
	
	@FindBy(xpath="//*[@id='assignmentsContainerBody']/tr[2]/td[2]/div/div[2]/a") public WebElement firstAssignment;
	@FindBy(xpath="//*[@id='activityMain']/div[2]/div/div[1]/a") public WebElement assignmentResults;
	@FindBy(xpath="//*[@id='grade_report_list_cntr_e']") public WebElement insStdList;
	
	public WebElement selectStudentInInsReports(WebDriver driver, String stdName) {
		return driver.findElement(By.xpath("//*[@title='" + stdName + "']"));
	}
	
	
	
	
}