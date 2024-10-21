package com.newdemo.framework.model;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class InsightsPage {	

	@FindBy(xpath="//li[@id='performance_tab_e']/a/span[text()='Performance']")public WebElement performance;
	@FindBy(xpath="//a[@id='insightsLink']/span")public WebElement insights;
	@FindBy(xpath="//h2[text()='How is my section doing?']")public WebElement howIsMySectionDoing;
	@FindBy(xpath="//span[@class='quadrant-bubble'][text()='1']")public List<WebElement> separateQuadrantBubbles;
	@FindBy(xpath="//span[@class='quadrant-bubble'][text()='2']")public WebElement singlequadrantBubble;
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
	@FindBy(xpath="//div[contains(@class,'insights-view')]//span[contains(@class,'quick-help')]")public WebElement insightsViewQuickHelp;
	@FindBy(xpath="//div[@class='quick-guide-container']//span[@class='icon-cancel-circle']")public WebElement closeQuickHelp;
	@FindBy(xpath="//div[@class='quick-guide-container']//img")public WebElement quickHelpImage;
	@FindBy(xpath="//div[contains(@class,'left-menu-bar')][contains(@class,'icon')]")public WebElement leftMenuBar;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Section home']")public WebElement leftMenuSectionHome;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Library']")public WebElement leftMenuLibrary;
	@FindBy(xpath="//ul[@class='header-left-menu-bar-list']//span[text()='Performance']")public WebElement leftMenuPerformance;
	@FindBy(xpath="//li[@class='header-left-menu-bar-item-submenu-item']/span[text()='Gradebook']")public WebElement leftSubMenuGradeBook;
	@FindBy(xpath="//li[@class='header-left-menu-bar-item-submenu-item']/span[text()='Reports']")public WebElement leftSubMenuReports;
	@FindBy(xpath="//li[contains(@class,'submenu-item')]/span[text()='Insight']")public WebElement leftSubMenuInsight;
	@FindBy(xpath="//div[@class='triangle-image switch-section-js']")public WebElement switchSectionTriangle;
	@FindBy(xpath="//div[@class='section-button-container to-mycourses-js']")public WebElement myCourses;
	public WebElement switchToSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//div[@class='section-item'][text()='"+strSectionName+"']")) ;
	}
	@FindBy(xpath="//span[@id='iconUser']")public WebElement userIcon;
	@FindBy(xpath="//div[@class='my-account my-account-js']")public WebElement myAccount;
	@FindBy(xpath="//li[@class='liExit']/a")public WebElement exitMyAccount;
	@FindBy(xpath="//div[@id='helpLink']")public WebElement helpLink;
	@FindBy(xpath="//ul[@id='helpLinkListHeader']/li/a[text()='Tutorials']")public WebElement tutorials;
	@FindBy(xpath="//ul[@id='helpLinkListHeader']/li/a[text()='Support']")public WebElement support;
	@FindBy(xpath="//li[text()='Insight - Quick guide']")public WebElement insightQuickGuide;
}