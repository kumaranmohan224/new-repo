package com.newdemo.framework.model;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.media.webkitMediaStream;
import com.newdemo.framework.base.GlobalPaths;

public class StudentReportsPage {

	@FindBy(xpath="//*[@title='performance']") public WebElement performanceTab;
	@FindBy(xpath="//*[@title='Reports page']") public WebElement reports;
	@FindBy(xpath="//*[@id='studentAssignmentList']") public WebElement stdAssignmentListTable;
	
	@FindBy(xpath="//*[@class='subReportViewPanel']/div[1]") public WebElement autoGrade;
	@FindBy(xpath="//*[@class='subReportViewPanel']/div[2]") public WebElement manualGrade;
	@FindBy(xpath="//*[@class='subReportViewPanel']/div[3]") public WebElement totalScore;
	@FindBy(xpath="//*[@id='ebFrame']") public WebElement stdReportsFrame;
	@FindBy(xpath="//*[@id='nextCtl']") public WebElement nextBtn;
	@FindBy(xpath="//*[@id='navbarSelect_input']") public WebElement questionNavBar;
	@FindBy(xpath="//*[@class='gradeParticipationSpan']") public WebElement fullCreditHeader;
	@FindBy(xpath="//*[@id='subReport']") public WebElement subReport;
	@FindBy(xpath="//*[@title='section home page']") public WebElement sectionHomeBtn;
	
	//*********************correct incorrect indicator elements --- question-wise
	//***************for 1st question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[1]") public WebElement firstQsIndicator1;
	@FindBy(xpath="(//span[contains(@class,'indicator')])[2]") public WebElement firstQsIndicator2;
	//****************for 2nd question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[3]") public WebElement secondQsIndicator1;
	@FindBy(xpath="(//span[contains(@class,'indicator')])[4]") public WebElement secondQsIndicator2;
	@FindBy(xpath="(//span[contains(@class,'indicator')])[5]") public WebElement secondQsIndicator3;
	@FindBy(xpath="(//span[contains(@class,'indicator')])[6]") public WebElement secondQsIndicator4;
	@FindBy(xpath="(//span[contains(@class,'indicator')])[7]") public WebElement secondQsIndicator5;
	//*****************for 3rd question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[8]") public WebElement thirdQsIndicator1;
	@FindBy(xpath="//input[@value='Delhi']") public WebElement thirdQsAns;
	//*****************for 5th question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[9]") public WebElement fifthQsIndicator1;
	//******************for 7th question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[10]") public WebElement seventhQsIndicator1;
	//*******************for 8th question
	@FindBy(xpath="(//span[contains(@class,'indicator')])[11]") public WebElement eightQsIndicator1;
	//******************for 9th qorksheet question
	@FindBy(xpath="(//img[@class='checkMark'])[1]") public WebElement worksheetQsIndicator1; 
	@FindBy(xpath="(//img[@class='checkMark'])[2]") public WebElement worksheetQsIndicator2;
	@FindBy(xpath="(//img[@class='checkMark'])[3]") public WebElement worksheetQsIndicator3;
	@FindBy(xpath="(//img[@class='checkMark'])[4]") public WebElement worksheetQsIndicator4;
	
	
	
	public WebElement assignmentRowList(WebDriver driver, int assignmentNumber) {
		return driver.findElement(By.xpath("//*[@id='studentAssignmentList']/tbody/tr[@class='student_row'][" + assignmentNumber + "]"));
	}
	
	public List<WebElement> attemptRowList(WebDriver driver, int assignmentNumber) {
		return driver.findElements(By.xpath("//*[@id='studentAssignmentList']/tbody/tr[@class='student_row'][" + assignmentNumber + "]//following::tr"));
	}
	
	public List<WebElement> extractAttemptsFromFullList(List<WebElement> assignmentList) throws Exception {
		String attrVal = "";
		List<WebElement> resultList = new ArrayList<WebElement>();
		for(WebElement element: assignmentList) {
			attrVal = element.getAttribute("class");
			if(attrVal.contains("txtAlignCenter")) {
				resultList.add(element);			
			} else {
				break;
			}
		}
		return resultList;
	}
	
	public WebElement attemptRow(WebDriver driver, int assignmentNumber, int attemptNumber) {
		return driver.findElement(By.xpath("(//*[@id='studentAssignmentList']/tbody/tr[@class='student_row'][" + assignmentNumber + "]//following::tr/td[2]/a)[" + attemptNumber + "]"));
	}
	
	
	
	public WebElement questionScoreInfo(WebDriver driver, int questionNumber) {
		return driver.findElement(By.xpath("(//*[@class='questionScoreInfo'])[" + questionNumber + "]"));
	}
	
	public WebElement questionTitle(WebDriver driver, int questionNumber) {
		return driver.findElement(By.xpath("(//*[@class='hm_questionTitle'])[" + questionNumber + "]"));
	}
	
}
