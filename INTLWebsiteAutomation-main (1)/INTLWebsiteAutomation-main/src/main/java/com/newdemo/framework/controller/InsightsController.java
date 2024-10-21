package com.newdemo.framework.controller;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Dimension;
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
import com.newdemo.framework.data.ConnectLoginData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.ConnectLoginPage;
import com.newdemo.framework.model.InsightsPage;

public class InsightsController extends ComponentFunctions {

	InsightsPage insightsPage = null;
	ConnectLoginData loginData = null;
	StudentRegistrationData StudentRegData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	public InsightsController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		insightsPage = PageFactory.initElements(driver, InsightsPage.class);		
	}
	
	
	public void clickInsights()throws Exception
	{
		clickObject(insightsPage.performance, "performance");
		waiting(1);		
		clickObject(insightsPage.insights, "insights");
		waiting(2);
		waitForInsightsPage(10);
	}
	
	public void waitForInsightsPage(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(insightsPage.howIsMySectionDoing, "How is My Section Doing", intWaitTime);
	}
	
	public void verifyQuadrantBubbles()throws Exception
	{
		try {
			List<WebElement> bubbles = insightsPage.separateQuadrantBubbles;	
			int intBubbles = bubbles.size();
			if(intBubbles!=0){
				verifyTextEquals(Integer.toString(bubbles.size()), "2", "Quadrant bubbles ");			
				waiting(1);
			}
			else{
				checkObjectExists(insightsPage.singlequadrantBubble, "Quadrant bubble ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}			
	}
	
	public void resizeBrowser()throws Exception
	{
		Dimension d = new Dimension(800,600);
		driver.manage().window().setSize(d);
	}
	
	public void maximizeBrowser()throws Exception
	{
		driver.manage().window().maximize();
	}
	
	public void goToSectionHome()throws Exception
	{
		clickObject(insightsPage.leftMenuBar, "Left Menu");
		waiting(1);		
		clickObject(insightsPage.leftMenuSectionHome, "Section Home");
		waiting(2);
		clickInsights();
	}
	
	public void goToLibrary()throws Exception
	{
		clickObject(insightsPage.leftMenuBar, "Left Menu");
		waiting(1);		
		clickObject(insightsPage.leftMenuLibrary, "Library");
		waiting(2);
		clickInsights();
	}
	
	public void goToGradeBook()throws Exception
	{
		clickObject(insightsPage.leftMenuBar, "Left Menu");
		waiting(1);		
		clickObject(insightsPage.leftMenuPerformance, "Performance");
		waiting(1);
		clickObject(insightsPage.leftSubMenuGradeBook, "Grade Book");
		waiting(2);
		clickInsights();
	}
	
	public void goToReports()throws Exception
	{
		clickObject(insightsPage.leftMenuBar, "Left Menu");
		waiting(1);		
		clickObject(insightsPage.leftMenuPerformance, "Performance");
		waiting(1);
		clickObject(insightsPage.leftSubMenuReports, "Reports");
		waiting(2);
		clickInsights();
	}
	
	public void goToInsight()throws Exception
	{
		clickObject(insightsPage.leftMenuBar, "Left Menu");
		waiting(1);		
		clickObject(insightsPage.leftMenuPerformance, "Performance");
		waiting(1);
		clickObject(insightsPage.leftSubMenuInsight, "Insight");
		waiting(2);
		waitForInsightsPage(10);
	}
	
	public void goToMyCourses()throws Exception
	{
		clickObject(insightsPage.switchSectionTriangle, "Switch Section Triangle");
		waiting(1);		
		clickObject(insightsPage.myCourses, "My Courses");
		waiting(2);		
	}
	
	public void goToSection(int sectionNumber)throws Exception
	{
		clickObject(insightsPage.switchSectionTriangle, "Switch Section Triangle");
		waiting(1);		
		String sectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		clickObject(insightsPage.switchToSection(driver,sectionName), "Section: "+sectionName);
		waiting(2);		
	}
	
	public void goMyAccount()throws Exception
	{
		clickObject(insightsPage.userIcon, "User Icon");
		waiting(1);				
		clickObject(insightsPage.myAccount, "My Account");
		waiting(1);		
		clickObject(insightsPage.exitMyAccount, " Exit My Account");
		waiting(2);		
	}
	
	public void goToTutorials()throws Exception
	{
		clickObject(insightsPage.userIcon, "User Icon");
		waiting(1);				
		clickObject(insightsPage.helpLink, "Help");
		waiting(1);		
		clickObject(insightsPage.tutorials, "Tutorials");
		waiting(2);		
		switchToNewWindow();
		closeApplication();
		switchToParentWindow();		
	}
	
	public void goToSupport()throws Exception
	{
		/*clickObject(insightsPage.userIcon, "User Icon");
		waiting(1);				
		clickObject(insightsPage.helpLink, "Help");
		waiting(1);		*/
		clickObject(insightsPage.support, "Support");
		waiting(2);		
		switchToNewWindow();
		closeApplication();
		switchToParentWindow();		
	}
	
	public void goToQuickGuide()throws Exception
	{
		/*clickObject(insightsPage.userIcon, "User Icon");
		waiting(1);		*/						
		clickObject(insightsPage.insightQuickGuide, "Insight - Quick Guide");
		waiting(1);		
		clickObject(insightsPage.closeQuickHelp, "close Quick Guide");
		waiting(2);				
	}
	
	public void clickQuickHelp()throws Exception
	{	
		clickObject(insightsPage.quickHelp, "Quick Help");
		waiting(2);				
	}
	
	public void clickInsightViewQuickHelp()throws Exception
	{	
		clickObject(insightsPage.insightsViewQuickHelp, "Quick Help");
		waiting(2);				
	}
	
	public void clickCloseQuickHelp()throws Exception
	{	
		clickObject(insightsPage.closeQuickHelp, "close Quick Help");
		waiting(2);				
	}
	
	public void clickDiveDeeper()throws Exception
	{
		clickObject(insightsPage.diveDeeper, "diveDeeper");
		waiting(2);
	}
	
	public void selectStudentCircle()throws Exception
	{
		clickObject(insightsPage.studentsCircle.get(1), "Circle");
		waiting(2);
	}
	
	public void selectSeeAssignments()throws Exception
	{
		clickObject(insightsPage.seeAssignments, "See Assignments");
		waiting(2);
	}
	
	public void clickBackIcon()throws Exception
	{	
		clickObject(insightsPage.backIcon, "Back Icon");
		waiting(2);				
	}
	
	public void clickAssignmentDistribution()throws Exception
	{	
		clickObject(insightsPage.assignmentDistribution, "Assignment Distribution");
		waiting(2);				
	}
	
	public void selectAssignmentSquare()throws Exception
	{
		clickObject(insightsPage.assignmentsSquare.get(1), "Assignments Square");
		waiting(2);
	}
	
	public void clickViewByScore()throws Exception
	{
		clickObject(insightsPage.viewByScore, "View by Score");
		waiting(1);
		clickObject(insightsPage.viewByScore, "View by Score");
		waiting(2);
	}
	
	public void clickviewByTime()throws Exception
	{
		clickObject(insightsPage.viewByTime, "View by Time");
		waiting(1);
		clickObject(insightsPage.viewByTime, "View by Time");
		waiting(2);
	}
	
	public void selectSeeWho()throws Exception
	{
		clickObject(insightsPage.seeWho, "See Who");
		waiting(2);
	}
	
}