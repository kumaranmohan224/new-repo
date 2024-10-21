package com.newdemo.framework.model;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class CreateCourseAndSectionPage {
	
	@FindBy(id="addCourse") public WebElement addCourse;	
	public By disciplineListLocator = By.id("disciplineList");
	@FindBy(xpath="//input[@role='textbox']") public WebElement disciplineTextBox;
	@FindBy(xpath="//li[@class='ui-menu-item']/a") public List<WebElement> disciplineList;
	@FindBy(xpath="//span[@class='ui-button-icon-primary ui-icon icon-caret-down']") public WebElement disciplineDropDown_showList;
	@FindBy(xpath="//span[@class='book-isbn']") public List<WebElement> disciplineISBN;
	@FindBy(xpath="//span[@class='slider-count']") public WebElement courseResultsCount;
	@FindBy(xpath="//div[@class='book-container']") public List<WebElement> disciplineBook;
	@FindBy(xpath="//div[@class='item-header']") public List<WebElement> disciplineComponentList;	
	@FindBy(xpath="//span[contains(@class,'module-checkbox-container')]") public List<WebElement> disciplineComponentCheckboxes;
	@FindBy(id="next-button") public WebElement selectDisciplinePage_nextButton;
	@FindBy(xpath="//div[@class='jcarousel-next jcarousel-next-horizontal']") public WebElement disciplineNextListButton;
	public By disciplineNextListButtonLocator = By.xpath("//div[@class='jcarousel-next jcarousel-next-horizontal']");	
	@FindBy(xpath="//div[@class='loading loading_e']") public WebElement loadingSymbol;	
	public By disciplineResultsLocator = By.xpath("//div[@class='jcarousel-prev jcarousel-prev-horizontal jcarousel-prev-disabled jcarousel-prev-disabled-horizontal']");
	public By componentBundles = By.xpath("(//div[@class='item-header'])[1]");
	@FindBy(xpath="//a[contains(@class, 'section-name-')]") public List<WebElement> selectSection;	
	@FindBy(xpath="//span[@class='icon-icn_3dots']") public List<WebElement> CourseOptions;		
	@FindBy(xpath="//span[contains(@class,'course-name-text')]") public List<WebElement> CourseName;	
	
	//******************courseInfoPage****************************
	@FindBy(id="courseNameValue") public WebElement courseInfo_courseName;		
	@FindBy(id="sectionName") public WebElement courseInfo_sectionName;
	@FindBy(id="create-button") public WebElement courseInfo_createButton;
	@FindBy(xpath="//a[@class='buttons btbl sectionhome-button']") public WebElement courseInfo_continueSection;
	@FindBy(xpath="//div[@id='continue_section']/a/div") public WebElement courseInfo_ProceedToSection;
	@FindBy(id="changelink") public WebElement courseInfo_changeLink;
	@FindBy(id="editSUrl") public WebElement courseInfo_editURL;
	@FindBy(id="saveUrl") public WebElement courseInfo_saveLink;
	
	@FindBy(xpath="//span[@class='success-message']") public WebElement successMessage;
	
	//**********************Section Home****************************
	@FindBy(xpath="//a[contains(text(),'My courses')]") public WebElement myCourses;
	
	//***********************My Courses Page************************
	public WebElement courseOptions(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//div/h4/span[text()='" + strCourseName + "']/../../../div/span/span[@class='icon-icn_3dots']")) ;
	}
	@FindBy(xpath="//li[contains(@class,'add-section-js')]/a/span") public WebElement addAnotherSection;
	@FindBy(xpath="//input[@class='input spl_char section-names-js palette_resized palette_added']") public WebElement addSectionName;
	@FindBy(xpath="//input[@class='input spl_char section-names-js']") public WebElement addSectionName1;
	//@FindBy(xpath="//input[@class='input spl_char section-names-js']") public WebElement addSectionName;
	@FindBy(xpath="//a[@class='buttons btbl smbtbl save-button-js']") public WebElement saveAnotherSection;	
	@FindBy(xpath="//div[@class='success-display success-block-js']/strong") public WebElement sectionSucessMsg;	
	@FindBy(xpath="//a[contains(@class,'tiny-text buttons btbl')]/span[1]") public WebElement continueToNewSection;	
	@FindBy(xpath="//a[text()='Switch sections']") public WebElement switchSections;
	@FindBy(xpath="//div[contains(@class,'listitem')]/a") public WebElement gotoSection1;	
	@FindBy(xpath="//a[@class='buttons btgy try-again']") public WebElement bundleLoader;
	
	@FindBy(id="editAddress") public WebElement changeSectionLink;
	@FindBy(id="sectionUrlEdit") public WebElement editSectionURL;
	@FindBy(id="saveEdit") public WebElement saveSectionLink;
	
	@FindBy(xpath="//a[@class='buttons btgy smbtgy cancel-button-js']") public WebElement cancelSectionEdit;
	
	public WebElement sectionOptions(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//a[text()='" + strSectionName + "']/../../..//span[@class='icon-cog']")) ;
	}
	
	public WebElement sectionLink(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//a[text()='" + strSectionName + "']")) ;
	}
	
	//16-Aug-2021 -- Sayan
	public WebElement sectionLinkNew(WebDriver driver, String strSectionName)
	{
		//original
		// return driver.findElement(By.xpath("//a[contains(text(),'" + strSectionName + "')]")) ;
		
		//*******changed by sayan
		return driver.findElement(By.xpath("(//a[starts-with(text(),'" + strSectionName + "')])[1]"));
		//a[contains(text(),'CTC1_09042019070726') and starts-with(text(),'copy of')]
		
	}
	
	public WebElement sectionToDelete(WebDriver driver,int number)
	{
		return driver.findElement(By.xpath("(//a[starts-with(.,'Section1_')])["+number+"]"));
		
	}
	
	public WebElement courseNameText(WebDriver driver, String strCourseName)
	{
		return driver.findElement(By.xpath("//span[@class='course-name-text'][text()='" + strCourseName + "']")) ;
	}
	
	@FindBy(xpath="//li[contains(@class,'duplicate-section-js')]/div/a/span") public WebElement duplicateSection;
	@FindBy(id="duplicateSessionName") public WebElement editDuplicateSectionName;
	
	@FindBy(xpath="//a[@class='buttons btbl smbtbl save-button-js']") public WebElement continueToDuplicateSection;
	@FindBy(xpath=".//*[@id='showStudentRegistrationSheet']/div/div[2]/div[3]/a/span[1]") public WebElement continueToNewDuplicateSection;
	
	@FindBy(xpath="//li/div/a/span[@class='icon-remove']") public WebElement deleteSection;
	
	@FindBy(xpath="//li/div/a/span[@class='icon-icn_share02']") public WebElement shareSection;	
	@FindBy(xpath="//div[text()='Cannot share or copy section']") public WebElement cannotShareOrCopy;
	@FindBy(xpath="//div[@class='section-no-assignment-modal-body medium-text']/p/b") public WebElement cannotShareMessage;
	@FindBy(xpath="//a[@class='cancel-js icon-cancel-circle right cancel-button']") public WebElement closeCannotSharePopUp;
	
	//Student Roster
	public WebElement checkRosterForSection(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//a[text()='" + strSectionName + "']/../../..//span[@class='icon-group']")) ;
	}
	@FindBy(xpath="//span[@class='dsa_prpt']") public WebElement roster;	
	@FindBy(xpath="//p[@class='instructions']") public WebElement rosterInstruction;	
	@FindBy(xpath="//a[@title='back to my courses']") public WebElement backToMyCourses;
	
	//Edit Course Details
	@FindBy(xpath="//li[contains(@class,'edit-course-details-js')]/a/span") public WebElement editCourseTitle;
	@FindBy(xpath="//div[text()='Edit course details']") public WebElement editCourseDetails;
	@FindBy(id="courseNameInput") public WebElement courseTitle;
	@FindBy(id="timeZoneVal") public WebElement editTimeZone;
	@FindBy(xpath="//ul[@id='courseDropdDownList']/li") public List<WebElement> editTimeZoneValue;
	@FindBy(xpath="//a[contains(@class,'save-button-js')]") public WebElement saveCourseDetails;
	@FindBy(xpath="//div[contains(@class,'confirmation-js')]/strong") public WebElement saveCourseDetailsMessage;
	@FindBy(xpath="//a[contains(@class,'cancel-button-js')][text()='Ok, got it.']") public WebElement confirmSaveCourseDetails;
	
	//Edit Section
	@FindBy(xpath="//li[contains(@class,'edit-section-details-js')]/span") public WebElement editSection;
	@FindBy(xpath="//div[text()='Edit section details']") public WebElement editSectionDetails;
	@FindBy(id="editSectionName") public WebElement editSectionName;
	@FindBy(id="editSectionUrl") public WebElement editSectionAddress;
	@FindBy(xpath="//a[contains(@class,'save-button-js')]") public WebElement saveSectionDetails;
	@FindBy(xpath="//div[contains(@class,'confirmation-js')]/strong") public WebElement saveSectionDetailsMessage;
	@FindBy(xpath="//a[contains(@class,'cancel-button-js')][text()='close']") public WebElement confirmSaveSectionDetails;
	
	//Set Registration dates
	@FindBy(xpath="//li[contains(@class,'set-course-date-js')]/a/span") public WebElement setRegistrationDates;
	@FindBy(xpath="//p[@class='instructions']") public WebElement registrationDatesInstruction;
	@FindBy(xpath="//input[@id='start']") public WebElement startDate;
	@FindBy(xpath="//input[@id='end']") public WebElement endDate;
	@FindBy(xpath="//input[@id='studentInfoSubmit']") public WebElement apply;
	
	public WebElement sectionRegistrationDate(WebDriver driver, String strSectionName)
	{
		return driver.findElement(By.xpath("//a[text()='" + strSectionName + "']/../../p/span[@class='medium-text section-dates']")) ;
	}
	
	//New changes
	@FindBy(xpath="//input[contains(@class,'courseSearch-textbox')]") public WebElement titleSearch;
	@FindBy(xpath="//button[contains(@class,'courseSearch-button')]") public WebElement search;
	public WebElement searchResultSubject(WebDriver driver, String strSubject)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'searchresult-rows')]//h4[text()='" + strSubject + "']")) ;
	}
	public WebElement bookTitle(WebDriver driver, String strIsbn)
	{
		return driver.findElement(By.xpath("//span[text()='ISBN:"+strIsbn+"']/../..//span[@class='mgh-book-title']")) ;
	} //ISBN:0067397045
	public WebElement bundle(WebDriver driver, String strBundle)
	{
		//return driver.findElement(By.xpath("//span[@class='tags-for-book'][text() ='" + strBundle + "']/../..//button")) ;
		return driver.findElement(By.xpath("//button[@value='" + strBundle + "']")) ;
		
	}
	
	public WebElement bundleByName(WebDriver driver, String strBundleName)
	{
		return driver.findElement(By.xpath("//span[@class='book-desc'][text() ='" + strBundleName + "']/../..//button")) ;
	}
	
	@FindBy(id="selectedTimezone") public WebElement timeZone;
	@FindBy(xpath="//ul[@id='timezoneList']/li") public List<WebElement> timeZoneValue;
	
	public WebElement sectionLinkStudent(WebDriver driver, String strSectionName)
	{
	//	System.out.println("3333333333333333333");
		return driver.findElement(By.xpath("//a[@title='" + strSectionName + "']")) ;
	}
	
	@FindBy(xpath="//*[@id='courseDropDown']/ul/li[6]/span") public WebElement deleteSections;
	
	public WebElement courseOptionss(WebDriver driver, int CourseNumber)
	{
		return driver.findElement(By.xpath("(//div/h4/span[starts-with(.,'CourseIC_')]/../../../div/span/span[@class='icon-icn_3dots'])["+CourseNumber+"]")) ;
	}
	public WebElement courseName(WebDriver driver, int courseNo)
	{
		return driver.findElement(By.xpath("(.//*[contains(text(),'CourseIC')]/../../../div[3]/span/span)["+courseNo+"]"));
	}
	@FindBy(xpath=".//*[@id='courseDropDown']/ul/li[6]/span") public WebElement delete;
}