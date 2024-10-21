package com.newdemo.framework.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.CreateCourseAndSectionData;
import com.newdemo.framework.model.CreateCourseAndSectionPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class CreateCourseAndSectionController extends ComponentFunctions {

	
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;	
	CreateCourseAndSectionPage CourseAndSection = null;
	CreateCourseAndSectionData CourseAndSectionData = null;
	
	public CreateCourseAndSectionController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();		
		CourseAndSection = PageFactory.initElements(driver, CreateCourseAndSectionPage.class);
	}
	
	public void waitForAddCourse(int intWaitTime) throws Exception
	{
		waitTillElementEnabled(CourseAndSection.addCourse, "Addcourse button", intWaitTime);
	}
	
	public void clickAddCourse() throws Exception
	{
		clickObjectUsingJSExecutor(CourseAndSection.addCourse, "Addcourse button");
	}
	
	public void waitForCourseDisciplineList(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.disciplineListLocator, "courseList dropdown", intWaitTime);
	}
	

	public void waitForDisciplineResults(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.disciplineResultsLocator, "Discipline Results", intWaitTime);
	}
		
	public void waitForBundleComponent(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.componentBundles, "Bundle component", intWaitTime);
	}
	
	public void waitTillLoadingElement() throws Exception
	{
		try
		{
			//boolean blnLoaderExists = checkObjectExistsWOError(CourseAndSection.loadingSymbol,"Loader symbol");	
			boolean blnLoaderExists = checkObjectExistsWOError("//div[@class='loading loading_e']","Loader symbol"); 
			//TODO change the xpath string type parameter to webelement parameter	
			do{			
				blnLoaderExists = checkObjectExistsWOError("//div[@class='loading loading_e']","Loader symbol");	
				//TODO change the xpath string type parameter to webelement parameter	
				if(blnLoaderExists == false){
					break;
				}
				waiting(5);
			}while (blnLoaderExists == true);		
		}	
		catch(Exception objException)
			{
				ATUReports.add("Failed in executing dismiss waitTillLoadingElement method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
				objHTMLFunctions.ReportPassFail("Failed in executing waitTillLoadingElement in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
			}
	}	
	
	public void clearRuntimeGlobalVariables()throws Exception
	{
		clearRuntimeGlobalVariableXL();
	}	
	
	public void typeCourseName() throws Exception
	{
		try
		{				
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strCourseName = CourseAndSectionData.strDTCourseNamePrefix+"_"+ strAppendDateTime;			
			waiting(2);	
			storeRuntimeGlobalVariable("CourseName", strCourseName);
			//CMNFunctions.saveDataInExcel("CourseDetails","CourseName",InputDataRow,strCourseName);	
			typeValue(CourseAndSection.courseInfo_courseName, "course Name", strCourseName);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeCourseName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeCourseName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void typeColleagueCourseName() throws Exception
	{
		try
		{						
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strCourseName = CourseAndSectionData.strDTCourseNamePrefix+"_"+ strAppendDateTime;			
			waiting(2);			
			storeRuntimeGlobalVariable("ColleagueCourseName", strCourseName);
			//CMNFunctions.saveDataInExcel("CourseDetails","ColleagueCourseName",InputDataRow,strCourseName);	
			typeValue(CourseAndSection.courseInfo_courseName, "course Name", strCourseName);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeCourseName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeCourseName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void typeSectionName(int sectionNumber) throws Exception
	{
		try
		{	
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strSectionName = CourseAndSectionData.strDTSectionNamePrefix+sectionNumber+"_"+strAppendDateTime;
			storeRuntimeGlobalVariable("SectionName"+sectionNumber, strSectionName);
			//CMNFunctions.saveDataInExcel("CourseDetails","SectionName"+sectionNumber,InputDataRow,strSectionName);	
			typeValue(CourseAndSection.courseInfo_sectionName, "Section Name", strSectionName);		
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeSectionName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeSectionName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void typeColleagueSectionName(int sectionNumber) throws Exception
	{
		try
		{	
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strSectionName = CourseAndSectionData.strDTSectionNamePrefix+sectionNumber+"_"+strAppendDateTime;
			storeRuntimeGlobalVariable("ColleagueSectionName"+sectionNumber, strSectionName);
			//CMNFunctions.saveDataInExcel("CourseDetails","ColleagueSectionName"+sectionNumber,InputDataRow,strSectionName);
			typeValue(CourseAndSection.courseInfo_sectionName, "Section Name", strSectionName);		
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeSectionName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeSectionName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void clickCreateCourse() throws Exception
	{
		clickObject(CourseAndSection.courseInfo_createButton, "Create Course button");
	}	
	
	public void verifyCourseCreatedMessage() throws Exception
	{
		verifyTextInElement(CourseAndSection.successMessage, CourseAndSectionData.strDTCourseCreatedMessage,CourseAndSectionData.strDTCourseCreatedMessage);
	}	
	
	public void clickProceedsectionHomeButton() throws Exception
	{	
		waiting(2);	
		if(waitTillElementEnabled(CourseAndSection.courseInfo_ProceedToSection, "Proceed to Section Home Page", 5)) {
			clickObject(CourseAndSection.courseInfo_ProceedToSection, "Proceed to Section Home Page");
		} else {
			this.objHTMLFunctions.reportPassFailToATU("Element " + "Proceed to Section Home Page" + "</i> is not present so not clicked", "true", "true");
		}
		waiting(2);
								
	}
	
	public void clickSectionHomeButton() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.courseInfo_continueSection, "Continue to Section Home", 10);
		waiting(2);
		clickObject(CourseAndSection.courseInfo_continueSection, "Continue to Section Home");
	}
	
	public void clickEditAddress() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.courseInfo_changeLink, "Edit Address button", 10);
		clickObject(CourseAndSection.courseInfo_changeLink, "Edit Address button");
	}
	
	public void typeAddress(int sectionNumber) throws Exception
	{
		String[] strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber).split("_");
		String strAddress = CourseAndSectionData.strDTWebAddressPrefix+sectionNumber+"_-"+strSectionName[1];
		clearNTypeValue(CourseAndSection.courseInfo_editURL, "Edit Address",strAddress);
		storeRuntimeGlobalVariable("WebAddress"+sectionNumber, strAddress);
		//CMNFunctions.saveDataInExcel("CourseDetails","WebAddress"+sectionNumber,InputDataRow,strAddress);
	}
		
	public void typeColleagueSectionAddress(int sectionNumber) throws Exception
	{		
		String[] strSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName"+sectionNumber).split("_");
		String strAddress = CourseAndSectionData.strDTWebAddressPrefix+sectionNumber+"_-"+strSectionName[1];
		clearNTypeValue(CourseAndSection.courseInfo_editURL, "Edit Address",strAddress);
		storeRuntimeGlobalVariable("ColleagueWebAddress"+sectionNumber, strAddress);
	}
	
	public void clickSaveAddress() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.courseInfo_saveLink, "Save Address link", 10);
		clickObject(CourseAndSection.courseInfo_saveLink, "Save Address link");		
		waiting(2);
	}
	
	public void verifyWebAddressSavedMessage() throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.successMessage, CourseAndSectionData.strDTWebAddressSavedMessage, 6);
		verifyTextInElement(CourseAndSection.successMessage, CourseAndSectionData.strDTWebAddressSavedMessage,CourseAndSectionData.strDTWebAddressSavedMessage);
	}
	
	public void clickMyCourses() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.myCourses, "Click My Courses link", 6);
		clickObject(CourseAndSection.myCourses, "Click My Courses link");
		waiting(1);
	}
	
	public void clickCourseOptions() throws Exception
	{
		String strCourseName = retrieveRuntimeGlobalVariable("CourseName");
		clickObject(CourseAndSection.courseOptions(driver,strCourseName), "Course Options");
	}
	
	public void clickAddSection() throws Exception
	{
		waiting(2);
		clickObject(CourseAndSection.addAnotherSection, "Add Section");
	}
	
	public void typeAnotherSectionName(int sectionNumber) throws Exception
	{
		try
		{	
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strSectionName = CourseAndSectionData.strDTSectionNamePrefix+sectionNumber+"_"+strAppendDateTime;
			storeRuntimeGlobalVariable("SectionName"+sectionNumber, strSectionName);
			if(waitTillElementDisplayed(CourseAndSection.addSectionName, "Add Section", 5))
			{
			clearNTypeValue(CourseAndSection.addSectionName, "Section Name", strSectionName);		
			}else
			{
				clearNTypeValue(CourseAndSection.addSectionName1, "Section Name", strSectionName);		
			}
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeSectionName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeSectionName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void clickSaveAnotherSection() throws Exception
	{
		waiting(2);
		clickObject(CourseAndSection.saveAnotherSection, "Save Section name button");
	}
	
	public void clickChangeSectionLink() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.changeSectionLink, "Edit Address button", 5);
		waiting(1.5);
		clickObject(CourseAndSection.changeSectionLink, "Edit Address button");
	}
	
	public void typeAnotherSectionAddress(int sectionNumber) throws Exception
	{
		String[] strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber).split("_");
		String strAddress = CourseAndSectionData.strDTWebAddressPrefix+sectionNumber+"_-"+strSectionName[1];
		clearNTypeValue(CourseAndSection.editSectionURL, "Edit Address",strAddress);
		storeRuntimeGlobalVariable("WebAddress"+sectionNumber, strAddress);
	}
	
	public void clickSaveSectionLink() throws Exception
	{
		clickObject(CourseAndSection.saveSectionLink, "Save Address button");
		/*checkNAcceptAlert(2);
		checkNAcceptAlert(2); */
		checkNAcceptAlerts(3);
		checkNAcceptAlerts(3); 
	}
	
	public Boolean checkNAcceptAlerts(int intWaitTime) throws Exception {
		Boolean blnAleartExists = Boolean.valueOf(false);
		try {
			WebDriverWait objWebDriverWait = new WebDriverWait(this.driver, intWaitTime);
			try {
				Alert objAlertExists = (Alert) objWebDriverWait.until(ExpectedConditions.alertIsPresent());
				blnAleartExists = Boolean.valueOf(true);
			} catch (Exception localException1) {
			}

			if (blnAleartExists.booleanValue()) {
				Alert objAlert = this.driver.switchTo().alert();
				String strAlertText = objAlert.getText();
				objAlert.accept();

				this.objHTMLFunctions.reportPassFailToATU(
						"Alert with text <i>" + strAlertText + "</i> appeard and it is accepted", "true", "true");
			}
			return Boolean.valueOf(true);
		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);

			this.objHTMLFunctions.reportPassFailToATU(
					"Error while waiting for Alert.<br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		return Boolean.valueOf(false);
	}

	public void clickCancelEditSection() throws Exception
	{
		clickObject(CourseAndSection.cancelSectionEdit, "Cancel Section Edit");
	}
	
	public void clickContinueToNewSection() throws Exception
	{
		clickObject(CourseAndSection.continueToNewSection, "Continue to New Section button");
	}
	
	public void clickSectionOptions(int sectionNumber) throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		waiting(2);
		clickObject(CourseAndSection.sectionOptions(driver,strSectionName), "Section options");
	}
	
	public void clickDuplicateSection() throws Exception
	{
		clickObject(CourseAndSection.duplicateSection, "Duplicate Section");
	}	
	
	public void typeDuplicateSectionName(int sectionNumber) throws Exception
	{
		try
		{	
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strSectionName = CourseAndSectionData.strDTSectionNamePrefix+sectionNumber+"_"+strAppendDateTime;
			storeRuntimeGlobalVariable("SectionName"+sectionNumber, strSectionName);
			clearNTypeValue(CourseAndSection.editDuplicateSectionName, "Section Name", strSectionName);		
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeSectionName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeSectionName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	public void typeDuplicateSectionNameAndSave(int sectionNumber) throws Exception
	{
		try
		{	
			SimpleDateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			Date objDate = new Date();
			Calendar objCal = Calendar.getInstance();
			objCal.setTime(objDate);
			String strAppendDateTime = objSimpleDtFormat.format(new Date()).replace("/", "").replace(":", "").replace(" ", "").trim();
			String strSectionName = CourseAndSectionData.strDTSectionNamePrefix+sectionNumber+"_"+strAppendDateTime;
			storeRuntimeGlobalVariable("DuplicateSectionName"+sectionNumber, strSectionName);
			clearNTypeValue(CourseAndSection.editDuplicateSectionName, "Section Name", strSectionName);		
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeSectionName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeSectionName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	public void clickContinueToDuplicateSection() throws Exception
	{
		clickObject(CourseAndSection.continueToDuplicateSection, "Continue to Duplicate Section");
	}
	
	public void clickContinueToNewDuplicateSection() throws Exception
	{
		clickObject(CourseAndSection.continueToNewDuplicateSection, "Continue to Newly Created Duplicate Section");
	}
	
	public void clickDeleteSection() throws Exception
	{
		clickObject(CourseAndSection.deleteSection, "Delete Section");		
		checkNAcceptAlert(2);
		checkNAcceptAlert(2); 
	}
	
	public void verifySectionDeleted(int sectionNumber) throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		try {	
			checkObjectNotExists(CourseAndSection.sectionLink(driver,strSectionName), "Deleted Section: "+strSectionName);
			ATUReports.add("Section '"+strSectionName+"' not deleted", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Section '"+strSectionName+"'not deleted" , "True", "False");
		} catch (Exception e) {
			ATUReports.add("Section '"+strSectionName+"'deleted successfully", LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Section '"+strSectionName+"'deleted successfully" , "True", "True");
		}		
		//storeRuntimeGlobalVariable("SectionName"+sectionNumber, "");
	}
	
	public void clickShareSection() throws Exception
	{
		clickObject(CourseAndSection.shareSection, "Share Section");
	}
	
	public void verifyCannotSharePopUp() throws Exception
	{
		checkObjectExists(CourseAndSection.cannotShareOrCopy, "Cannot Share Or Copy Section");
		verifyTextInElement(CourseAndSection.cannotShareMessage, CourseAndSectionData.strDTCannotShareMessage,CourseAndSectionData.strDTCannotShareMessage);		
	}
	
	public void closeCannotSharePopUp() throws Exception
	{
		clickObject(CourseAndSection.closeCannotSharePopUp, "Close cannot share popup");
	}
	
	public void clickCheckRoster(int sectionNumber) throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		clickObject(CourseAndSection.checkRosterForSection(driver,strSectionName), "Section options");
	}
	
	public void verifyStudentRoster() throws Exception
	{		
		waitTillElementDisplayed(CourseAndSection.rosterInstruction, "Student Roster Information", 6);
		verifyTextInElement(CourseAndSection.rosterInstruction, CourseAndSectionData.strDTRosterInformation, CourseAndSectionData.strDTRosterInformation);		
	}
	
	public void clickBackToMyCourses() throws Exception
	{
		clickObject(CourseAndSection.backToMyCourses, "Back to My Courses");
	}
	
	public void clickEditCourseTitle() throws Exception
	{
		waiting(2);
		clickObject(CourseAndSection.editCourseTitle, "Edit title/ time zone");
	}
	
	public void verifyEditCourseDetails() throws Exception
	{
		waiting(2);
		checkObjectExists(CourseAndSection.editCourseDetails, "Edit course details");
	}
	
	public void typeNewCourseName() throws Exception
	{
		try
		{				
			String strCourseName = retrieveRuntimeGlobalVariable("CourseName")+"Upd";			
			waiting(2);			
			storeRuntimeGlobalVariable("CourseName", strCourseName);
			clearNTypeValue(CourseAndSection.courseTitle, "Course Title", strCourseName);
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing typeNewCourseName method in CourseAndSectionController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing typeNewCourseName method in CourseAndSectionController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}				
	}
	
	public void selectEditTimezone() throws Exception           
	{
		clickObject(CourseAndSection.editTimeZone, "Edit time zone");		
		List<WebElement> timeZoneValue = CourseAndSection.editTimeZoneValue;		
		for(Integer intLoop = 0; intLoop< timeZoneValue.size();intLoop++)
		{
			if(timeZoneValue.get(intLoop).getText().equalsIgnoreCase(CourseAndSectionData.strDTTimeZone))
			{
				clickObject(timeZoneValue.get(intLoop), timeZoneValue.get(intLoop).getText() + " timezone is selected");
				waiting(1);				
				break;
			}
		}
	}
	
	public void clickSaveCourseName() throws Exception
	{
		clickObject(CourseAndSection.saveCourseDetails, "Save course name");
		waiting(3);
		verifyTextInElement(CourseAndSection.saveCourseDetailsMessage, CourseAndSectionData.strDTSaveCourseDetails,CourseAndSectionData.strDTSaveCourseDetails);
		clickObject(CourseAndSection.confirmSaveCourseDetails, "Ok, got it.");
	}
	
	public void verifyEditedCourseName() throws Exception
	{
		String strCourseName = retrieveRuntimeGlobalVariable("CourseName");
		checkObjectExists(CourseAndSection.courseNameText(driver, strCourseName), "Verify Course "+strCourseName+" exits");
	}
	
	public void clickEditSection() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.editSection, "Edit Section", 5);
		waiting(1.5);
		clickObject(CourseAndSection.editSection, "Edit Section");
	}	
	
	public void verifyEditSectionPopUp() throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.editSectionDetails, "Edit Section Details", 6);
		checkObjectExists(CourseAndSection.editSectionDetails, "Edit Section Details");
	}	
	
	public void typeNewSectionName(int sectionNumber)throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber)+"Upd";			
		waiting(2);			
		storeRuntimeGlobalVariable("SectionName"+sectionNumber, strSectionName);
		clearNTypeValue(CourseAndSection.editSectionName, "Edit Section Name", strSectionName);
	}
	
	public void verifySectionAddress(int sectionNumber)throws Exception
	{
		String strWebAddress = retrieveRuntimeGlobalVariable("WebAddress"+sectionNumber);			
		waiting(2);			
		String strAppWebAddress = CourseAndSection.editSectionAddress.getAttribute("value");
		verifyTextEquals(strAppWebAddress, strWebAddress, "Section duplication issue");
	}
	
	public void typeNewSectionAddress(int sectionNumber)throws Exception
	{
		String strSectionAddress = retrieveRuntimeGlobalVariable("WebAddress"+sectionNumber)+"upd";
		clearNTypeValue(CourseAndSection.editSectionAddress, "Edit Address",strSectionAddress);
		storeRuntimeGlobalVariable("WebAddress"+sectionNumber, strSectionAddress);
	}
	
	public void clickSaveSectionDetails() throws Exception
	{
		clickObject(CourseAndSection.saveSectionDetails, "Save Section Details");
		waiting(3);
		checkNAcceptAlert(2);
		checkNAcceptAlert(2);
		waitTillElementDisplayed(CourseAndSection.saveSectionDetailsMessage, "Save section details Done Pop-up", 5);
		waiting(2);
		verifyTextInElement(CourseAndSection.saveSectionDetailsMessage, CourseAndSectionData.strDTSaveSectionDetails,CourseAndSectionData.strDTSaveSectionDetails);
		clickObject(CourseAndSection.confirmSaveSectionDetails, "Close");
	}
	
	public void verifyEditedSectionName(int sectionNumber) throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		checkObjectExists(CourseAndSection.sectionLink(driver, strSectionName), "Verify Section "+strSectionName+" exits");
	}
	
	public void clickSetRegistrationDates() throws Exception
	{
		waiting(2);
		clickObject(CourseAndSection.setRegistrationDates, "Set Registration Dates");
	}
	
	public void verifyRegistrationDatesPage() throws Exception
	{	
		verifyTextInElement(CourseAndSection.registrationDatesInstruction, CourseAndSectionData.strDTSetRegistrationDates,CourseAndSectionData.strDTSetRegistrationDates);
	}
	
	public void setRegistrationDates() throws Exception
	{	
		String regStartDate = getCurrentTime("MM/dd/yyyy");
		String regEndDate = getNextMonthDate();
		
		waitTillElementEnabled(CourseAndSection.startDate, "Start Date", 10);
		waiting(2);
		clickObject(CourseAndSection.startDate, "Start Date");
		waiting(2);
		clearNTypeValue(CourseAndSection.startDate, "Start Date",regStartDate);
		waiting(2);
		clickObject(CourseAndSection.endDate, "End Date");
		waiting(2);
		clearNTypeValue(CourseAndSection.endDate, "End Date",regEndDate);
		
		storeRuntimeGlobalVariable("StartDate", regStartDate);
		storeRuntimeGlobalVariable("EndDate", regEndDate);		
	}
	
	public void clickApplyDates() throws Exception
	{
		waitTillElementEnabled(CourseAndSection.apply, "Apply Registration Dates", 5);
		waiting(2);
		clickObject(CourseAndSection.apply, "Apply Registration Dates");
	}
	
	public void verifySectionRegistrationDate(int sectionNumber) throws Exception
	{
		try {
			String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
			
			DateFormat objSimpleDtFormat = new SimpleDateFormat("MM/dd/yy");
			Date startDate = objSimpleDtFormat.parse(retrieveRuntimeGlobalVariable("StartDate")); 
			String strStartDate = objSimpleDtFormat.format(startDate);
			
			Date endDate = objSimpleDtFormat.parse(retrieveRuntimeGlobalVariable("EndDate")); 
			String strEndDate = objSimpleDtFormat.format(endDate);
			String strRegDate = strStartDate+" - "+strEndDate;
			
			verifyTextInElement(CourseAndSection.sectionRegistrationDate(driver,strSectionName), strRegDate, strRegDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectSection(int sectionNumber) throws Exception
	{
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
		clickObject(CourseAndSection.sectionLink(driver, strSectionName), "Select section: "+strSectionName);
	}
	public void selectSectionStudent(int sectionNumber) throws Exception
	{
	//	System.out.println("111111111111111111");
		String strSectionName = retrieveRuntimeGlobalVariable("SectionName"+sectionNumber);
	//	System.out.println("222222222222222222");
		clickObject(CourseAndSection.sectionLinkStudent(driver, strSectionName), "Select section: "+strSectionName);
	}
	
	public void selectSectionWithNameClassicStd() throws Exception {
		String strSectionName=CourseAndSectionData.strDTSectionNameFull;

		clickObject(CourseAndSection.sectionLinkStudent(driver, strSectionName), "Select section: "+strSectionName);
	}
	
	public void selectColleagueSection() throws Exception
	{
		String colleagueSectionName = retrieveRuntimeGlobalVariable("ColleagueSectionName1");
		clickObject(CourseAndSection.sectionLink(driver, colleagueSectionName), "Select section: "+colleagueSectionName);
	}
	//New changes
	public void waitForTitleSearch(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(CourseAndSection.titleSearch, "Title Search Textbox", intWaitTime);
	}
	
	public void typeISBN() throws Exception
	{
		String strISBN = CourseAndSectionData.strDTISBN;
		typeValueUsingJSExecutor(CourseAndSection.titleSearch, "ISBN ",strISBN);
	}
	
	public void clickSearch() throws Exception
	{
		clickObjectUsingJSExecutor(CourseAndSection.search, "Search");
	}
	
	public void verifySearchResultSubject() throws Exception
	{
		String strBundle = CourseAndSectionData.strDTComponent;
		checkObjectExists(CourseAndSection.search, "Search");
	}
	
	public void selectBook() throws Exception
	{
		String strISBN = CourseAndSectionData.strDTISBN;
		clickObjectUsingJSExecutor(CourseAndSection.bookTitle(driver, strISBN), "Book Title "+strISBN);
	}
	
	public void selectBundle() throws Exception
	{
		String strBundle = CourseAndSectionData.strDTComponent;
		if (strBundle.length()>0) {
			waiting(5);
			waitTillElementEnabled(CourseAndSection.bundle(driver, strBundle), "Bundle" + strBundle, 10);
			waiting(5);
			clickObjectUsingJSExecutor(CourseAndSection.bundle(driver, strBundle), "Bundle "+strBundle);
		}
			
	}
	
	public void selectBundleByName() throws Exception
	{
		String strBundleName = CourseAndSectionData.strDTComponent;
		if (strBundleName.length()>0)
			clickObjectUsingJSExecutor(CourseAndSection.bundleByName(driver, strBundleName), "Bundle "+strBundleName);
	}
	
	public void selectTimezone() throws Exception   //Mandatory to select Time zone while creating course
	{
		clickObjectUsingJSExecutor(CourseAndSection.timeZone, "Edit time zone");		
		List<WebElement> timeZoneValue = CourseAndSection.timeZoneValue;		
		for(Integer intLoop = 0; intLoop< timeZoneValue.size();intLoop++)
		{
			if(timeZoneValue.get(intLoop).getText().equalsIgnoreCase(CourseAndSectionData.strDTTimeZone))
			{
				clickObjectUsingJSExecutor(timeZoneValue.get(intLoop), timeZoneValue.get(intLoop).getText() + " timezone is selected");
				waiting(1);				
				break;
			}
		}
	}

	
	public void dummyMethod() throws Exception{
		
		System.out.println("this is for rebase checking");
	}

	public void Delete() throws Exception
	{
		try{
		waitTillElementDisplayed(CourseAndSection.addCourse, "Add Course", 25);
		List<WebElement> courses= driver.findElements(By.xpath(".//*[contains(text(),'CourseIC')]/../../../div[3]/span/span"));
		int CourseSize=courses.size();
		System.out.println(CourseSize + " Courses matching here for deletion!!! ");
		for(int i=1;i<=courses.size();i++)
		{
			waitTillElementDisplayed(CourseAndSection.addCourse, "Add Course", 25);
			clickObject(CourseAndSection.courseName(driver,i), "Course " +i+ " Selected");

			
			waiting(2);
			clickObjectUsingJSExecutor(CourseAndSection.delete, "Delete for Course " +i);
			/*Robot robot= new Robot();

			robot.keyPress(KeyEvent.VK_ENTER);

			waiting(1);
			robot.keyPress(KeyEvent.VK_ENTER);*/
			checkNAcceptAlerts(3);
			checkNAcceptAlerts(3);
			
			
			
			System.out.println("Delete Message for Course " +i+ " Done!!!YAY");
			
		}
		
	}catch(Exception e)
	{
		
	}
		
}
	
	public void selectSectionWithName(int sectionNumber) throws Exception
	{
		String strSectionName=CourseAndSectionData.strDTSectionNameFull;
		clickObjectUsingJSExecutor(CourseAndSection.sectionLinkNew(driver, strSectionName), "Select section: "+strSectionName);
	}

}