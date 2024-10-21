package com.newdemo.framework.controller;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;


import org.openqa.selenium.support.PageFactory;

import com.newdemo.framework.base.CommonFunctions;
import com.newdemo.framework.base.ComponentFunctions;
import com.newdemo.framework.base.HTMLFunctions;
import com.newdemo.framework.data.INTLLoginData;
import com.newdemo.framework.data.StudentRegistrationData;
import com.newdemo.framework.model.INTLLoginPage;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class INTLLoginController extends ComponentFunctions {

	INTLLoginPage intlloginPage = null;
	INTLLoginData intlloginData = null;
	StudentRegistrationData StudentRegData = null;
	HTMLFunctions objHTMLFunctions = null;
	WebDriver driver = null;
	CommonFunctions CMNFunctions = null;
	
	public INTLLoginController(WebDriver driver, String strParametersNValues) throws Exception 
	{
		super(driver);
		this.driver = driver;
		objHTMLFunctions = new HTMLFunctions(this.driver);
		CMNFunctions = new CommonFunctions();
		intlloginPage = PageFactory.initElements(driver, INTLLoginPage.class);		
	}
	
	public void launchINTLURL() throws Exception
	{
		launchURL(intlloginData.strDTURL);
	}
	
	public void typeEmail() throws Exception
	{
		typeValue(intlloginPage.userName, "userName", intlloginData.strDTUserName);
	}
	
	public void typePassword() throws Exception
	{
		typeValue(intlloginPage.password, "password", intlloginData.strDTPassword);
	}
	
	public void waitForUserName(int intWaitTime) throws Exception
	{
		waitTillElementEnabled(intlloginPage.userName, "userName", intWaitTime);
		deleteAllCookies();
	}
	
	public void waitForStdUserName(int intWaitTime) throws Exception
	{
		waitTillElementDisplayed(intlloginPage.stdusername, "Student sign in page", intWaitTime);
	}
	
	public void clickSignin() throws Exception
	{
		clickObject(intlloginPage.signIn, "SignIn");
		
	}
	
	public void clickRemindMeLater() throws Exception
	{
		clickObject(intlloginPage.RemindMelater, "RemindMelater");
		
	}
	public boolean acceptAlerts() throws Exception {
		try {
			Alert objAlert = this.driver.switchTo().alert();
			String strAlertText = objAlert.getText();
			objAlert.accept();

			this.objHTMLFunctions.reportPassFailToATU("Alert with text <i>" + strAlertText + "</i> accepted", "true",
					"true");
			return true;
		} catch (Exception objException) {
			this.strErrorMsg = this.objCMNFunctions.GetExceptionNDisplay(objException, true);
			this.objHTMLFunctions.reportPassFailToATU(
					"Error while accepting the alert.<br> Error message=>" + this.strErrorMsg, "true", "false");
		}
		return false;
	}
	
	public void waitForHomeScreen(int intWaitTime) throws Exception
	{
		try
		{
			for(Integer intLoop = 0; intLoop < intWaitTime; intLoop++)
			{
				if(intlloginPage.acceptAll.getAttribute("id").toLowerCase().contains(intlloginPage.waitExpression().toLowerCase()))
				{
					Thread.sleep(1000);
				}
			}
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing waitForHomeScreen method in SmokeTestController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing waitForHomeScreen method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void waitForHomePage(int intWaitTime) throws Exception
	{
		try
		{
			for(Integer intLoop = 0; intLoop < intWaitTime; intLoop++)
			{
				if(intlloginPage.searchTextBox.getAttribute("id").toLowerCase().contains(intlloginPage.waitExpression().toLowerCase()))
				{
					Thread.sleep(1000);
				}
			}
		}
		catch(Exception objException)
		{
			ATUReports.add("Failed in executing waitForHomeScreen method in SmokeTestController", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			objHTMLFunctions.ReportPassFail("Failed in executing waitForHomeScreen method in SmokeTestController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	
	public void waitForSectionHomePage(int waitTime)throws Exception
	{
		waitTillElementDisplayed(intlloginPage.homeIcon, "Home Icon", waitTime);		
	}
	
	
	public void dismissUpdatesNnoticesPopup() throws Exception
	{
		try
		{
			
			if(waitTillElementEnabled(intlloginPage.updatesNnoticesOKbutton, "Updates and Notices Popup", 10)){
				waiting(1.5);
				clickObjectUsingJSExecutor(intlloginPage.updatesNnoticesOKbutton, "Updates and Notices Pop Up");				
			}
			else{
				objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
			}
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed in executing dismissUpdatesNnoticesPopup method in ClassicConnectController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	public void dismissNewUpdatesNnoticesPopup() throws Exception
	{
		try
		{
			
			if(waitTillElementEnabled(intlloginPage.updatesNnoticesNewOKbutton, "Updates and Notices Popup", 5)){
				waiting(1.5);
				clickObjectUsingJSExecutor(intlloginPage.updatesNnoticesNewOKbutton, "Updates and Notices Pop Up");				
			}
			else{
				objHTMLFunctions.ReportPassFail("There is no Updates and Notices Pop up", "True","True");
			}
		}
		catch(Exception objException)
		{
			objHTMLFunctions.ReportPassFail("Failed in executing dismissUpdatesNnoticesPopup method in ClassicConnectController" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
		}
	}
	public void clickSignOutButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.signOutButton, "SignOut button",10)) {
			waiting(1.5);
			clickObject(intlloginPage.signOutButton, "SignOut button");
		} 
	}
	
	public void launchConnectStudentURL() throws Exception
	{
		launchURL(StudentRegData.strDTStudentURL);
	}
	
	public void typeStudentEmail() throws Exception
	{
		typeValue(intlloginPage.userName, "userName", StudentRegData.strDTStudentEmail);
	}
	
	public void typeStudentPassword() throws Exception
	{
		waitTillElementEnabled(intlloginPage.password, "password", 10);
		typeValue(intlloginPage.password, "password", StudentRegData.strDTPassword);
	}
	
	public void clickAcceptAllButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.acceptAll, "Accept All button in cookie banner",10)) {
			waiting(1.5);
			clickObject(intlloginPage.acceptAll, "Accept All button in cookie banner");
		} 
	}
	
	public void myCartRoleAccessibility() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.myCartRole, "My cart role validation",10)) {
			waiting(1.5);
			checkObjectExists(intlloginPage.myCartRole, "My cart role validation");
		}
	}
	
	public void closeButtonRoleAccessibility() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.closeButtonRole, "Close Button validation",10)) {
			waiting(1.5);
			checkObjectExists(intlloginPage.closeButtonRole, "Close Button validation");
		}
	}
	
	public void ariaLabelAccessibility() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.ariaLabel, "Aria label under nav tag validation",10)) {
			waiting(1.5);
			checkObjectExists(intlloginPage.ariaLabel, "Aria label under nav tag validation");
		}
	}
	
	public void blogRoleAccessibility() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.blogRole, "Blog role as link validation",10)) {
			waiting(1.5);
			checkObjectExists(intlloginPage.blogRole, "Blog role as link validation");
		}
	}
	
	public void ariaLabelledByIdAccessibility() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.ariaLabelledById, "aria-labelledby and Id validation",10)) {
			waiting(1.5);
			checkObjectExists(intlloginPage.ariaLabelledById, "aria-labelledby and Id validation");
		}
	}
	
	
	
	public void clickSearchTextBox() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.searchTextBox, "Search Text Box button",10)) {
			waiting(1.5);
			clickObject(intlloginPage.searchTextBox, "Search Text Box button");
		} 
	}
	
	public void clickAmazonSearchTextBox() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.amazonSearchTextBox, "Amazon Search Text Box",10)) {
			waiting(1.5);
			clickObject(intlloginPage.amazonSearchTextBox, "Amazon Search Text Box");
		} 
	}
	
	public void clickAmazonAcceptCookiesButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.amazonAcceptCookiesButton, "Amazon Accept cookies button",10)) {
			waiting(1.5);
			clickObject(intlloginPage.amazonAcceptCookiesButton, "Amazon Accept cookies button");
		} 
	}
	
	public void clickCodeTextBox() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.codeTextBox, "Code Text Box",10)) {
			waiting(1.5);
			clickObject(intlloginPage.codeTextBox, "Code Text Box");
		}
	}
	
	public void validateBlog() throws Exception
	{
	      ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	      //switch to new tab
	      driver.switchTo().window(newTb.get(1));
	      System.out.println("Page title of new tab: " + driver.getTitle());
	      validateReadMoreButton();
	      //switch to parent window
	      driver.switchTo().window(newTb.get(0));
	      System.out.println("Page title of parent window: " + driver.getTitle());

	}
	
	public void clickBlogLink() throws Exception
	{
		clickObject(intlloginPage.blogLink, "Blog Link");
	}
	
	public void validateReadMoreButton() throws Exception
	{
		checkObjectExists(intlloginPage.readMoreButton, "Read More button");
	}
	
	public void typeTheTextInSearchBox() throws Exception
	{
		typeValue(intlloginPage.searchTextBox, "Type the text in search bar", intlloginData.strDTSearchText);
	}
	
	public String getValue(String ISBN) throws Exception
	{
		typeValue(intlloginPage.searchTextBox, "Type the text in search bar", ISBN);
		return ISBN;
	}
	
	public String getIsbnValue(String ISBN) throws Exception
	{
		typeValue(intlloginPage.amazonSearchTextBox, "Type the text in search bar", ISBN);
		return ISBN;
	}
	
	public String typeCodeValue(String OpportunityID) throws Exception
	{
		typeValue(intlloginPage.codeTextBox, "Type the text in search bar", OpportunityID);
		return OpportunityID;
	}
	
	public Float getFloatValue(Float priceList) throws Exception
	{
		return priceList;
	}
	
	public String getFloatDecValue(String priceList) throws Exception
	{
		return priceList;
	}
	
	public void clickSearchButton() throws Exception
	{
		clickObject(intlloginPage.searchButton, "Search button");
		
	}
	
	public void clickAmazonSearchButton() throws Exception
	{
		clickObject(intlloginPage.amazonSearchButton, "Search button");
		
	}
	
	public void selectFirstBook() throws Exception
	{
		clickObject(intlloginPage.selectImage, "select image button");
		
	}
	
	public void clickMarketoButton() throws Exception
	{
		clickObject(intlloginPage.marketoButton, "Marketo button");
	}
	
	public void validateMktoSubmitButton() throws Exception
	{
		checkObjectExists(intlloginPage.mktoSubmitButton, "mkto submit button");
	}
	
	/*
	 * public void clickLearnMoreLink() throws Exception {
	 * clickObjectUsingJSExecutor(intlloginPage.learnMoreLink, "Learn More link"); }
	 */
	
	public void clickCookieCloseButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.cookieCloseButton, "Cookie close button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.cookieCloseButton, "Cookie close button");
		}		
	}

	    public void ResponseCodeCheck(String isbn13) throws Exception
	    {

	        URL url1 = new URL("https://covers.eppg.com/Jpeg_400-wide/"+isbn13+".jpeg");
	        HttpURLConnection connection = (HttpURLConnection)url1.openConnection();
	        connection.setRequestMethod("GET");
	        //connection.connect();

	        int code = connection.getResponseCode();
	        System.out.println("Response code of the object is "+code);
	        if (code==200)
	        {
	            System.out.println("OK");
	            imageDisplayed();
	        }
	        else {
	        	System.out.println("FILE NOT FOUND");
	            imageNotDisplayed();
	        }
	    }
	
	
	/*
	 * public Boolean validateProductIsbn13() throws Exception {
	 * if(checkObjectExists(intlloginPage.productISBN13, "ISBN 13 digits")) return
	 * true; else return false; }
	 */
	public Boolean validateProductIsbn13() throws Exception
	{
		if(checkObjectExists(intlloginPage.productISBN13, "ISBN 13 digits"))
			return true;
		else
			return false;
		
	}
	
	public Boolean validateIsbn10() throws Exception
	{
		if(checkObjectExists(intlloginPage.productISBN10, "ISBN 10 digits"))
			return true;
		else
			return false;
		
	}
	
	public void clickSecondLink() throws Exception
	{
		waiting(3);
	if(waitTillElementEnabled(intlloginPage.validateSecondLink, "click on second link",10)) {
		waiting(1.5);
		clickObjectUsingJSExecutor(intlloginPage.validateSecondLink, "click on second link");
	}
		
		
	}
	
	public String validateProductIsbn10() throws Exception
	{
		return intlloginPage.productISBN10.getText();
		
		
	}
	
	public String validateReleaseDate() throws Exception
	{
		return intlloginPage.releaseDate.getText();
		
		
	}
	
    public static boolean compareDates(String dateStr1, String dateStr2) {
        // Parse dates using DateTimeFormatter
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date1 = LocalDate.parse(dateStr1, formatter1);
        LocalDate date2 = LocalDate.parse(dateStr2, formatter2);

        // Compare dates
        return date1.isEqual(date2);
    }

	
	public Boolean validatePriceAtWebsite() throws Exception
	{
		if(checkObjectExists(intlloginPage.priceAtWebsite, "Price At Website"))
			return true;
		else
			return false;
		
	}
	
	public Boolean validateProductImage() throws Exception
	{
		if(checkObjectExists(intlloginPage.productImage, "Product image"))
			return true;
		else
			return false;
		
	}
	
	public List<String> validateIsbnList() throws Exception
	{
		//String txt=intlloginPage.priceList.getText();
		List<String> txt=new ArrayList<String>();
		//int txt[]= new int[] {1,2,3,4};
		
		//String x = intlloginPage.priceList1.getText().replaceAll("[^.0-9]","");
	
	
		List<WebElement> isbn10 = driver.findElements(By.className("isbn-info"));
		System.out.println(isbn10.size());
		if(isbn10.size()==0) {
			return txt;
		}
		txt.add(intlloginPage.isbnList.getText().substring(8,18));
		System.out.println(txt.size());
		
		if(isbn10.size()==2) {
		 //txt.add(Float.parseFloat(intlloginPage.priceList1.getText().replaceAll("[^.0-9]","")));
		 
			
			txt.add(intlloginPage.isbnList2.getText().substring(8,18));
			
		System.out.println(txt.size());}
		else if(isbn10.size()==3) {
			txt.add(intlloginPage.isbnList2.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList3.getText().substring(8,18));
			
		System.out.println(txt.size());}
		else if(isbn10.size()==4) {
			txt.add(intlloginPage.isbnList2.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList3.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList4.getText().substring(8,18));
			
		System.out.println(txt.size());}
		else if(isbn10.size()==5) {
			txt.add(intlloginPage.isbnList2.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList3.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList4.getText().substring(8,18));
			
			txt.add(intlloginPage.isbnList5.getText().substring(8,18));
			
		System.out.println(txt.size());
		;}
		else
			System.out.println("Its not group product");
			 
	     //txt[1]=Integer.parseInt(intlloginPage.priceList2.toString().replaceAll("[^0-9]",""));
		 //txt[2]=Integer.parseInt(intlloginPage.priceList3.toString().replaceAll("[^0-9]",""));
		 //txt[3]=Integer.parseInt(intlloginPage.priceList4.toString().replaceAll("[^0-9]",""));
		 return txt;
		//return txt[0].replaceAll("[^0-9]","");
		/*
		 * String txt[1]=intlloginPage.priceList2.getText(); return
		 * txt[1].replaceAll("[^0-9]",""); String
		 * txt[2]=intlloginPage.priceList3.getText(); return
		 * txt[2].replaceAll("[^0-9]",""); String
		 * txt4=intlloginPage.priceList4.getText(); return txt4.replaceAll("[^0-9]","");
		 */
	}

	
	public List<Float> validatePriceList() throws Exception
	{
		//String txt=intlloginPage.priceList.getText();
		List<Float> txt=new ArrayList<Float>();
		//int txt[]= new int[] {1,2,3,4};
		
		//String x = intlloginPage.priceList1.getText().replaceAll("[^.0-9]","");
	
	
		List<WebElement> price = driver.findElements(By.className("price"));
		System.out.println(price.size());
		if(price.size()==0) {
			return txt;
		}
		txt.add(Float.parseFloat(intlloginPage.priceList.getText().replaceAll("[^.0-9]","")));
		System.out.println(txt.size());
		
		if(price.size()==2) {
		 //txt.add(Float.parseFloat(intlloginPage.priceList1.getText().replaceAll("[^.0-9]","")));
		 
			
			txt.add(Float.parseFloat(intlloginPage.priceList2.getText().replaceAll("[^.0-9]","")));
			
		System.out.println(txt.size());}
		else if(price.size()==3) {
			txt.add(Float.parseFloat(intlloginPage.priceList2.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList3.getText().replaceAll("[^.0-9]","")));
			
		System.out.println(txt.size());}
		else if(price.size()==4) {
			txt.add(Float.parseFloat(intlloginPage.priceList2.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList3.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList4.getText().replaceAll("[^.0-9]","")));
			
		System.out.println(txt.size());}
		else if(price.size()==5) {
			txt.add(Float.parseFloat(intlloginPage.priceList2.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList3.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList4.getText().replaceAll("[^.0-9]","")));
			
			txt.add(Float.parseFloat(intlloginPage.priceList5.getText().replaceAll("[^.0-9]","")));
			
		System.out.println(txt.size());
		;}
		else
			System.out.println("Its not group product");
			 
	     //txt[1]=Integer.parseInt(intlloginPage.priceList2.toString().replaceAll("[^0-9]",""));
		 //txt[2]=Integer.parseInt(intlloginPage.priceList3.toString().replaceAll("[^0-9]",""));
		 //txt[3]=Integer.parseInt(intlloginPage.priceList4.toString().replaceAll("[^0-9]",""));
		 return txt;
		//return txt[0].replaceAll("[^0-9]","");
		/*
		 * String txt[1]=intlloginPage.priceList2.getText(); return
		 * txt[1].replaceAll("[^0-9]",""); String
		 * txt[2]=intlloginPage.priceList3.getText(); return
		 * txt[2].replaceAll("[^0-9]",""); String
		 * txt4=intlloginPage.priceList4.getText(); return txt4.replaceAll("[^0-9]","");
		 */
	}
	
	public List<Integer> validatePriceListES() throws Exception
	{
		
		List<Integer> txt=new ArrayList<Integer>();
		
		
		
	
	
		List<WebElement> price = driver.findElements(By.className("price"));
		System.out.println(price.size());
		
		txt.add(Integer.parseInt(intlloginPage.priceList.getText().replaceAll("[^0-9]","")));
		System.out.println(txt.size());
		
		if(price.size()==2) {
		 
		 
			
			txt.add(Integer.parseInt(intlloginPage.priceList2.getText().replaceAll("[^0-9]","")));
		System.out.println(txt.size());}
		else if(price.size()==3) {
			
			txt.add(Integer.parseInt(intlloginPage.priceList2.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList3.getText().replaceAll("[^0-9]",""))); 
		System.out.println(txt.size());}
		else if(price.size()==4) {
			
			txt.add(Integer.parseInt(intlloginPage.priceList2.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList3.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList4.getText().replaceAll("[^0-9]","")));
		System.out.println(txt.size());}
		else if(price.size()==5) {
			
			txt.add(Integer.parseInt(intlloginPage.priceList2.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList3.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList4.getText().replaceAll("[^0-9]","")));
			
			txt.add(Integer.parseInt(intlloginPage.priceList5.getText().replaceAll("[^0-9]","")));
		System.out.println(txt.size());
		}
		else
			System.out.println("Its not group product");
		return txt;
		}
		
			//ATUReports.add("Failed in executing price validation", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			//objHTMLFunctions.ReportPassFail("Failed in executing price validation" + CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False");
			//System.out.println("list not found");
		
	
	
	public void correctPrice() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Price is correct", "True","True");
	}
	
	public void incorrectPrice() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Price is incorrect", "True","False");
	}
	
	public void childProductAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Child product is available", "True","True");
	}
	
	public void childProductNotAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Child product is not available", "True","False");
	}
	
	public void productAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Product is available", "True", "True");
	}
	
	public void productNotAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Product is not available", "True", "False");
	}
	
	public void priceNotFound() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Price not found", "True","False");
	}
	
	public void isbnDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("ISBN is displayed", "True","True");
	}
	
	public void isbnNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("ISBN is not displayed", "True","False");
		
	}
	
	public void masterEVGIsbnDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Master EVG ISBN is displayed", "True","True");
	}
	
	public void masterEVGIsbnNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Master EVG ISBN is not displayed", "True","False");
	}
	
	public void priceAtWebsiteDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Price at website is displayed"+intlloginPage.priceAtWebsite.getText(), "True","True");
		
	}
	
	public void priceAtWebsiteNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Price at website not displayed", "True","False");
		
	}
	
	public void tocDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("TOC is displayed", "True","True");
	}
	
	public void tocNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("TOC is not displayed", "True","False");
		
	}
	
	public void descriptionDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Description is displayed", "True","True");
	}
	
	public void descriptionNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Description is not displayed", "True","False");
		
	}
	
	public void stockAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Stock is available", "True","True");
	}
	
	public void stockAvailableInFuture() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Stock Available in Future", "True","True");
	}
	
	public void stockNotAvailable() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Stock is not available", "True","False");
		
	}
	
	public void imageDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Image is displayed", "True", "True");
	}
	
	public void imageNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("Image is not displayed", "True","False");
		
	}
	
	public void textDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("CSP is in Report Only mode", "True", "False");
	}
	
	public void textNotDisplayed() throws Exception
	{
		objHTMLFunctions.ReportPassFail("CSP is Enabled", "True","True");
		
	}
	
	
	public void clickAddToCartButton() throws Exception
	{
		clickObject(intlloginPage.addToCartButton, "Add To Cart Button");
		
	}
	
	public void clickGuestCheckOutButton() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.guestCheckOutButton, "Search Text Box button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.guestCheckOutButton, "Guest Checkout Button");
		}
	}
	
	public void clickEmailAddressTextBox() throws Exception
	{
		clickObject(intlloginPage.customerEmail, "Customer Email address");
		
	}
	
	public void clickConfirmEmailAddressTextBox() throws Exception
	{
		clickObject(intlloginPage.confirmCustomerEmail, "Confirm Email address");
		
	}
	
	public void clickReviewAndPaymentsButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.reviewAndPaymentsButton, "Review and Payments button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.reviewAndPaymentsButton, "Review and Payments button");
		}
	}
	
	public void typeEmailAddress() throws Exception
	{
		typeValue(intlloginPage.customerEmail, "Customer Email Address", intlloginData.strDTUserName);
	}
	
	public void typeConfirmEmailAddress() throws Exception
	{
		typeValue(intlloginPage.confirmCustomerEmail, "Confirm Customer Email Address", intlloginData.strDTUserName);
	}
	
	public int clickTaxFormCheckBox() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.taxFormCheckBox, "Tax Form Checkbox",10)) {
			waiting(1.5);
		clickObjectUsingJSExecutor(intlloginPage.taxFormCheckBox, "Tax Form Checkbox");
		return 1;
		}
		return 0;
		
	}
	
	 public void getCSPHeaders(String currentURL) throws Exception
	 {
		 ChromeOptions options = new ChromeOptions();
	        //options.setCapability("goog:loggingPrefs", "{browser: 'ALL'}");

	        // Launch the browser
	       // WebDriver driver = new ChromeDriver(options);

	        // Navigate to the web page
	       // driver.get("https://cti:mHEM2Pr3L1ve@asia.pre-prod.mhem2.ctidigital.com/");
	        driver.get(currentURL);

	        // Validate text in the browser console
	        validateConsoleText(driver, "Report Only");
	        
		
	 }
	 
	    public void validateConsoleText(WebDriver driver, String expectedText) throws Exception{
	        // Get browser console logs
	        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);

	        // Iterate over the log entries to find the expected text
	        boolean textFound = false;
	        for (LogEntry entry : logs) {
	            if (entry.getMessage().contains(expectedText)) {
	                textFound = true;
	                break;
	            }
	        }

	        // Check if the expected text was found in the console logs
	        if (textFound) {
	            System.out.println("Report Only found in the browser console.");
	            textDisplayed();
	            // Add your further validation logic here
	        } else {
	            System.out.println("Report Only not found in the browser console.");
	            textNotDisplayed();
	            // Handle case where expected text is not found
	        }
	    }

	 
	 	
	private boolean waitTillElementDisplayed(Boolean taxCheckBox, String string, int i) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clickTaxIDTextBox() throws Exception
	{
		clickObject(intlloginPage.taxIDTextBox, "Tax ID Textbox");
		
	}
	
	public void typeTaxID() throws Exception
	{
		typeValue(intlloginPage.taxIDTextBox, "Tax ID", intlloginData.strDTTaxID);
	}
	
	public void clickNumeroDeIdentificationTextBox() throws Exception
	{
		clickObject(intlloginPage.numeroDeIdentification, "Numero De Identification Textbox");
		
	}
	
	public void typeNumeroDeIdentificationValue() throws Exception
	{
		typeValue(intlloginPage.numeroDeIdentification, "Numero De Identification", intlloginData.strDTNumeroDeIdentification);
	}
	
	public void clickTaxNameTextBox() throws Exception
	{
		clickObject(intlloginPage.taxNameTextBox, "Tax Name Textbox");
		
	}
	
	public void typeTaxName() throws Exception
	{
		typeValue(intlloginPage.taxNameTextBox, "Tax Name", intlloginData.strDTTaxName);
	}
	
	public void clickInvoicePostalCodeTextBox() throws Exception
	{
		clickObject(intlloginPage.invoicePostalCodeTextBox, "Invoice Postal Code Textbox");
		
	}
	
	public void typeInvoicePostalCode() throws Exception
	{
		typeValue(intlloginPage.invoicePostalCodeTextBox, "Invoice Postal Code", intlloginData.strDTInvoicePostalCode);
	}
	
	public void clickInvoiceRegimeDropDown() throws Exception
	{
		clickObject(intlloginPage.invoiceRegimeDropDown, "Invoice Regime Dropdown");
		
	}
	
	public void selectInvoiceRegimeValue() throws Exception
	{
		clickObject(intlloginPage.invoiceRegimeValue, "Invoice Regime Value");
	}
	
	public void clickInvoiceUseOfCfdiDropDown() throws Exception
	{
		clickObject(intlloginPage.invoiceUseOfCfdiDropDown, "Invoice Use Of Cfdi Dropdown");
		
	}
	
	public void selectInvoiceUseOfCfdiValue() throws Exception
	{
		clickObject(intlloginPage.invoiceUseOfCfdiValue, "Invoice Use Of Cfdi Value");
	}
	
	public void clickBillingAddressFirstNameTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressFirstName, "Billing Address First Name Textbox");
		
	}
	
	public void typeBillingAddressFirstName() throws Exception
	{
		typeValue(intlloginPage.billingAddressFirstName, "Billing Address First Name", intlloginData.strDTTaxName);
	}
	
	public void clickBillingAddressSurNameTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressSurName, "Billing Address Sur Name Textbox");
		
	}
	
	public void typeBillingAddressSurName() throws Exception
	{
		typeValue(intlloginPage.billingAddressSurName, "Billing Address Sur Name", intlloginData.strDTSurName);
	}
	
	public void clickBillingAddressStreetTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.billingAddressStreet, "Billing Address Street Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.billingAddressStreet, "Billing Address Street Textbox");
		}
		
	}
	
	public void typeBillingAddressStreet() throws Exception
	{
		typeValue(intlloginPage.billingAddressStreet, "Billing Address Street", intlloginData.strDTStreet);
	}
	
	public void clickBillingAddressCityTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressCity, "Billing Address City Textbox");
		
	}
	
	public void typeBillingAddressCity() throws Exception
	{
		typeValue(intlloginPage.billingAddressCity, "Billing Address City", intlloginData.strDTCity);
	}
	
	public void clickBillingAddressPostCodeTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressPostCode, "Billing Address PostCode Textbox");
		
	}
	
	public void typeBillingAddressPostCode() throws Exception
	{
		typeValue(intlloginPage.billingAddressPostCode, "Billing Address PostCode", intlloginData.strDTBillingPostCode);
	}
	
	public void clickBillingAddressTelephoneTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressTelephone, "Billing Address Telephone Textbox");
		
	}
	
	public void typeBillingAddressTelephone() throws Exception
	{
		typeValue(intlloginPage.billingAddressTelephone, "Billing Address Telephone", intlloginData.strDTTelephone);
	}
	
	public void clickBillingAddressRegionIdDropDown() throws Exception
	{
		clickObject(intlloginPage.billingAddressRegionId, "Billing Address Region Id Dropdown");
		
	}
	
	public void selectBillingAddressRegionIdValue() throws Exception
	{
		clickObject(intlloginPage.billingAddressRegionIdValue, "Billing Address Region Id Value");
	}
	
	public void selectBillingAddressRegionIdValueCol() throws Exception
	{
		clickObject(intlloginPage.billingAddressRegionIdValueCol, "Billing Address Region Id Value");
	}
	
	public void clickBillingAddressCountryIdDropDown() throws Exception
	{
		clickObject(intlloginPage.billingAddressCountryId, "Billing Address Country Id Dropdown");
		
	}
	
	public void selectBillingAddressCountryIdValue() throws Exception
	{
		clickObject(intlloginPage.billingAddressCountryIdValue, "Billing Address Country Id Value");
	}
	
	public void clickBillingAddressBrainTreeFirstNameTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeFirstName, "Billing Address First Name Textbox");
		
	}
	
	public void clickCreditCardRadioButton() throws Exception
	{
		clickObject(intlloginPage.creditCardRadioButton, "Credit card radio button");
		
	}
	
	public void verifyGooglePayRadioButton() throws Exception
	{
				if(waitTillElementEnabled(intlloginPage.googlePayButton, "GooglePay radio button", 5)){
				waiting(1.5);	
				objHTMLFunctions.ReportPassFail("Google pay radio button is displayed", "True","True");
				}
				else
					objHTMLFunctions.ReportPassFail("Google pay radio button is not displayed displayed", "True","False");

		}
		
	
	public void verifyPayPalRadioButton() throws Exception
	{			
			if(waitTillElementEnabled(intlloginPage.payPalButton, "PayPal radio button", 5)){
				waiting(1.5);	
				objHTMLFunctions.ReportPassFail("Paypal radio button is displayed", "True","True");
			}
			else
				objHTMLFunctions.ReportPassFail("Paypal radio button is not displayed", "True","False");
		}
		
	
	public void typeBillingAddressBrainTreeFirstName() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreeFirstName, "Billing Address First Name", intlloginData.strDTTaxName);
	}
	
	public void clickBillingAddressBrainTreeSurNameTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeSurName, "Billing Address Sur Name Textbox");
		
	}
	
	public void typeBillingAddressBrainTreeSurName() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreeSurName, "Billing Address Sur Name", intlloginData.strDTSurName);
	}
	
	public void clickBillingAddressBrainTreeStreetTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.billingAddressBrainTreeStreet, "Billing Address Street Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.billingAddressBrainTreeStreet, "Billing Address Street Textbox");
		}
		
	}
	
	public void typeBillingAddressBrainTreeStreet() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreeStreet, "Billing Address Street", intlloginData.strDTStreet);
	}
	
	public void clickBillingAddressBrainTreeCityTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeCity, "Billing Address City Textbox");
		
	}
	
	public void typeBillingAddressBrainTreeCity() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreeCity, "Billing Address City", intlloginData.strDTCity);
	}
	
	public void clickBillingAddressBrainTreePostCodeTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreePostCode, "Billing Address PostCode Textbox");
		
	}
	
	public void typeBillingAddressBrainTreePostCode() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreePostCode, "Billing Address PostCode", intlloginData.strDTBillingPostCode);
	}
	
	public void clickBillingAddressBrainTreeTelephoneTextBox() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeTelephone, "Billing Address Telephone Textbox");
		
	}
	
	public void typeBillingAddressBrainTreeTelephone() throws Exception
	{
		typeValue(intlloginPage.billingAddressBrainTreeTelephone, "Billing Address Telephone", intlloginData.strDTTelephone);
	}
	
	public void clickBillingAddressBrainTreeRegionIdDropDown() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeRegionId, "Billing Address Region Id Dropdown");
		
	}
	
	public void selectBillingAddressBrainTreeRegionIdValue() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeRegionIdValue, "Billing Address Region Id Value");
	}
	
	public void selectBillingAddressBrainTreeRegionIdValueSpain() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeRegionIdValueSpain, "Billing Address Region Id Value");
	}
	
	public void clickBillingAddressBrainTreeCountryIdDropDown() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeCountryId, "Billing Address Country Id Dropdown");
		
	}
	
	public void selectBillingAddressBrainTreeCountryIdValue() throws Exception
	{
		clickObject(intlloginPage.billingAddressBrainTreeCountryIdValue, "Billing Address Country Id Value");
	}
	
	public void clickShippingAddressFirstNameTextBox() throws Exception
	{
		clickObject(intlloginPage.shippingAddressFirstName, "Shipping Address First Name Textbox");
		
	}
	
	public void typeShippingAddressFirstName() throws Exception
	{
		typeValue(intlloginPage.shippingAddressFirstName, "Shipping Address First Name", intlloginData.strDTTaxName);
	}
	
	public void clickShippingAddressSurNameTextBox() throws Exception
	{
		clickObject(intlloginPage.shippingAddressSurName, "Shipping Address Sur Name Textbox");
		
	}
	
	public void typeShippingAddressSurName() throws Exception
	{
		typeValue(intlloginPage.shippingAddressSurName, "Shipping Address Sur Name", intlloginData.strDTSurName);
	}
	
	public void clickShippingAddressStreetTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.shippingAddressStreet, "Shipping Address Street Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.shippingAddressStreet, "Shipping Address Street Textbox");
		}
		
	}
	
	public void clickShippingAddressLine2StreetTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.shippingAddressLine2Street, "Shipping Address Line 2 Street Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.shippingAddressLine2Street, "Shipping Address Line 2 Street Textbox");
		}
		
	}
	
	public void typeShippingAddressStreet() throws Exception
	{
		typeValue(intlloginPage.shippingAddressStreet, "Shipping Address Street", intlloginData.strDTStreet);
	}
	
	public void typeShippingAddressLine2Street() throws Exception
	{
		typeValue(intlloginPage.shippingAddressLine2Street, "Shipping Address Line 2 Street", intlloginData.strDTStreet2);
	}
	
	public void clickShippingAddressCityTextBox() throws Exception
	{
		clickObject(intlloginPage.shippingAddressCity, "Shipping Address City Textbox");
		
	}
	
	public void typeShippingAddressCity() throws Exception
	{
		typeValue(intlloginPage.shippingAddressCity, "Shipping Address City", intlloginData.strDTCity);
	}
	
	public void clickShippingAddressPostCodeTextBox() throws Exception
	{
		clickObject(intlloginPage.shippingAddressPostCode, "Shipping Address PostCode Textbox");
		
	}
	
	public void typeShippingAddressPostCode() throws Exception
	{
		typeValue(intlloginPage.shippingAddressPostCode, "Shipping Address PostCode", intlloginData.strDTBillingPostCode);
	}
	
	public void clickShippingAddressTelephoneTextBox() throws Exception
	{
		clickObject(intlloginPage.shippingAddressTelephone, "Shipping Address Telephone Textbox");
		
	}
	
	public void typeShippingAddressTelephone() throws Exception
	{
		typeValue(intlloginPage.shippingAddressTelephone, "Shipping Address Telephone", intlloginData.strDTTelephone);
	}
	
	public void clickShippingAddressRegionIdDropDown() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionId, "Shipping Address Region Id Dropdown");
		
	}
	
	public void selectShippingAddressRegionIdValue() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValue, "Shipping Address Region Id Value");
	}
	
	public void selectShippingAddressRegionIdValueSpain() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueSpain, "Shipping Address Region Id Value");
	}
	
	public void selectShippingAddressRegionIdValueProfessional() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueProfessional, "Shipping Address Region Id Value");
	}
	
	public void selectShippingAddressRegionIdValueCol() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueCol, "Shipping Address Region Id Value");
	}
	
	public void selectShippingAddressRegionIdValueCanada() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueCanada, "Shipping Address Region Id Value");
	}
	
	public void clickShippingAddressCountryIdDropDown() throws Exception
	{
		clickObject(intlloginPage.shippingAddressCountryId, "Shipping Address Country Id Dropdown");
		
	}
	
	public void selectShippingAddressCountryIdValue() throws Exception
	{
		clickObject(intlloginPage.shippingAddressCountryIdValue, "Shipping Address Country Id Value");
	}
	
	public void clickActionUpdateButton() throws Exception
	{
		clickObject(intlloginPage.actionUpdate, "Action update Button");
	}
	
	public void clickPrimaryCheckoutButton() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.primaryCheckoutButton, "Primary Checkout button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.primaryCheckoutButton, "Primary Checkout Button");
		}
	}
	
	public void verifyErrorMessage() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.errorMessage, "Error Message",10)) {
			waiting(1.5);
		checkObjectExists(intlloginPage.errorMessage, "Error Message");
		}
	}
	
	public void clickVisaPaymentMethodButton() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.visaPaymentMethod, "Visa Payment Method button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.visaPaymentMethod, "Visa Payment Method Button");
		}
	}
	
	public void clickCCFullNameTextBox() throws Exception
	{
		clickObject(intlloginPage.ccFullName, "CC FullName Textbox");
		
	}
	
	public void typeCCFullName() throws Exception
	{
		typeValue(intlloginPage.ccFullName, "CC FullName", intlloginData.strDTCCFullName);
	}
	
	public void clickCCDniNumberTextBox() throws Exception
	{
		clickObject(intlloginPage.ccDniNumber, "CC Dni Number Textbox");
		
	}
	
	public void typeCCDniNumber() throws Exception
	{
		typeValue(intlloginPage.ccDniNumber, "CC Dni Number", intlloginData.strDTCCNumber);
	}
	
	public void clickCCNumberTextBox() throws Exception
	{
		clickObject(intlloginPage.ccNumber, "CC Number Textbox");
		
	}
	
	public void typeCCNumber() throws Exception
	{
		typeValue(intlloginPage.ccNumber, "CC Number", intlloginData.strDTCCNumber);
	}
	
	public void clickSelectBankDropDown() throws Exception
	{
		clickObject(intlloginPage.selectBankDropDown, "Select bank dropdown");
	}
	
	public void selectBankDropDownValue() throws Exception
	{
		typeValue(intlloginPage.selectBankDropDown, "Select bank Dropdown value", intlloginData.strDTSelectBank);
	}
	
	public void clickCreditCardNumberTextBox() throws Exception
	{
		waiting(15);
		if(waitTillElementEnabled(intlloginPage.creditCardNumber, "CC Number Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.creditCardNumber, "CC Number Textbox");
		}
		
	}
	
	public void typeCreditCardNumber() throws Exception
	{
		typeValue(intlloginPage.creditCardNumber, "CC Number", intlloginData.strDTCCNumber);
	}
	
	public void clickSecurityCodeTextBox() throws Exception
	{
		clickObject(intlloginPage.securityCode, "Security Code Textbox");
		
	}
	
	public void typeSecurityCode() throws Exception
	{
		typeValue(intlloginPage.securityCode, "Security Code", intlloginData.strDTSecurityCode);
	}
	
	public void clickSecurityCodeTextBoxCol() throws Exception
	{
		clickObject(intlloginPage.securityCodeCol, "Security Code Textbox");
		
	}
	
	public void typeSecurityCodeCol() throws Exception
	{
		typeValue(intlloginPage.securityCodeCol, "Security Code", intlloginData.strDTSecurityCode);
	}
	
	public void clickcvvTextBox() throws Exception
	{
		clickObject(intlloginPage.cvv, "CVV Textbox");
		
	}
	
	public void typecvv() throws Exception
	{
		typeValue(intlloginPage.cvv, "CVV", intlloginData.strDTSecurityCode);
	}
	
	public void clickExpirationTextBox() throws Exception
	{
		clickObject(intlloginPage.expirationMonthYear, "Expiration Textbox");
		
	}
	
	public void typeExpirationMonthYear() throws Exception
	{
		typeValue(intlloginPage.expirationMonthYear, "Expiration", intlloginData.strDTExpiration);
	}
	
	public void clickExpirationDateMonthDropDown() throws Exception
	{
		clickObject(intlloginPage.expirationDateMonth, "Expiration Date Month Dropdown");
		
	}
	
	public void selectExpirationDateMonthValue() throws Exception
	{
		clickObject(intlloginPage.expirationDateMonthValue, "Expiration Date Month Value");
	}
	
	public void clickExpirationYearDropDown() throws Exception
	{
		clickObject(intlloginPage.expirationYear, "Expiration Year Dropdown");
		
	}
	
	public void selectExpirationYearValue() throws Exception
	{
		clickObject(intlloginPage.expirationYearValue, "Expiration Year Value");
	}
	
	public void clickContactPhoneTextBox() throws Exception
	{
		clickObject(intlloginPage.contactPhone, "Contact Phone Textbox");
		
	}
	
	public void typeContactPhone() throws Exception
	{
		typeValue(intlloginPage.contactPhone, "Contact Phone", intlloginData.strDTTelephone);
	}
	
	public void clickPayButton() throws Exception
	{
		clickObject(intlloginPage.payButton, "Pay Button");
		
	}
	
	public void clickResponseButtonContinue() throws Exception
	{
		waiting(15);
		if(waitTillElementEnabled(intlloginPage.responseButtonContinue, "Response Button Continue",10)) {
			waiting(1.5);
		clickObject(intlloginPage.responseButtonContinue, "Response Button continue");
		}
	}
	
	public void clickContinueButton() throws Exception
	{
		waiting(15);
		if(waitTillElementEnabled(intlloginPage.continueButton, "Continue Button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.continueButton, "Continue Button");
		}
	}
	
	public void clickCustomerEmailLoginTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.customerEmailLogin, "Customer Email Login",10)) {
			waiting(1.5);
		clickObject(intlloginPage.customerEmailLogin, "Customer Email Login");
		}
	}
	
	public void typeCustomerEmailLogin() throws Exception
	{
		typeValue(intlloginPage.customerEmailLogin, "Customer Email Login", intlloginData.strDTCustomerEmailLogin);
		
	}
	
	public void clickCustomerPasswordTextBox() throws Exception
	{
		clickObject(intlloginPage.customerPassword, "Customer Password Text Box");
		
	}
	
	public void typeCustomerPassword() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.customerPassword, "Customer Password",10)) {
			waiting(1.5);
		typeValue(intlloginPage.customerPassword, "Customer Password", intlloginData.strDTCustomerPassword);
		}
		
	}
	
	public void clickCustomerEmailSpainTextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.customerEmailSpain, "Customer Email Login for Spain",10)) {
			waiting(1.5);
		clickObject(intlloginPage.customerEmailSpain, "Customer Email Login for Spain");
		}
	}
	
	public void typeCustomerEmailSpain() throws Exception
	{
		typeValue(intlloginPage.customerEmailSpain, "Customer Email Login for Spain", intlloginData.strDTCustomerEmailLogin);
		
	}
	
	public void clickCustomerPasswordSpainTextBox() throws Exception
	{
		clickObject(intlloginPage.customerPasswordSpain, "Customer Password for Spain Text Box");
		
	}
	
	public void typeCustomerPasswordSpain() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.customerPasswordSpain, "Customer Password for Spain",10)) {
			waiting(1.5);
		typeValue(intlloginPage.customerPasswordSpain, "Customer Password for Spain", intlloginData.strDTCustomerPassword);
		}
		
	}
	
	public void clickLoginButton() throws Exception
	{
		clickObject(intlloginPage.loginButton, "Login Button");
		
	}
	
	public void clickActionPrimaryToCart() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrimaryToCart, "Action Primary To Cart",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrimaryToCart, "Action Primary To Cart");
		}
		
	}
	
	public void clickActionPrintPrimaryToCartLATAM() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartLATAM, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartLATAM, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartCol() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartCol, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartCol, "Print Primary to cart button");
		}
	}
	
	public void clickActionDigitalPrimaryToCartCol() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionDigitalPrimaryToCartCol, "Digital Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionDigitalPrimaryToCartCol, "Digital Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartCol_Prod() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartCol_Prod, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartCol_Prod, "Print Primary to cart button");
		}
	}
	
	public void clickActionDigitalPrimaryToCartCol_Prod() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionDigitalPrimaryToCartCol_Prod, "Digital Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionDigitalPrimaryToCartCol_Prod, "Digital Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartEMEA() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartEMEA, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartEMEA, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintToCartEMEA() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintToCartEMEA, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintToCartEMEA, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartCanada() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartCanada, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartCanada, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartASIA() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartASIA, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartASIA, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartPhysicalCheckOutCanada() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartPhysicalCheckOutCanada, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartPhysicalCheckOutCanada, "Print Primary to cart button");
		}
	}
	
	public void clickActionPrintPrimaryToCartPhysicalCheckOutCanada_Prod() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartPhysicalCheckOutCanada_Prod, "Print Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartPhysicalCheckOutCanada_Prod, "Print Primary to cart button");
		}
	}
	
	public void clickActionDigitalPrimaryToCartSpain() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionDigitalPrimaryToCartSpain, "Digital Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionDigitalPrimaryToCartSpain, "Digital Primary to cart button");
		}	
	}
	
	public void clickActionPrintPrimaryToCartSpain() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.actionPrintPrimaryToCartSpain, "Digital Primary To Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionPrintPrimaryToCartSpain, "Digital Primary to cart button");
		}	
	}
	
	public void clickShoppingCartLink() throws Exception
	{
		clickObject(intlloginPage.shoppingCartLink, "Shopping Cart Link");
	}
	
	public void clickActionPrimaryCheckoutButton() throws Exception
	{
		clickObject(intlloginPage.actionPrimaryCheckoutButton, "Action Primary Checkout button");
	}
	
	public void clickActionShowCartButton() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.actionShowCart, "Action Show Cart button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.actionShowCart, "Action Show Cart button");
		}
	}
	
	public Boolean verifyRemoveItemButton() throws Exception
	{
		if(waitTillElementDisplayed(intlloginPage.removeItemButton, "Remove Item button",10))
		return true;
		else
			return false;
	}
	
	public void clickRemoveItemButton() throws Exception
	{
		clickObject(intlloginPage.removeItemButton, "Remove Item Button");
	}
	
	public void clickAcceptButton() throws Exception
	{
		clickObject(intlloginPage.acceptButton, "Accept button");
	}
	
	public void clickProceedToCheckoutButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.proceedToCheckout, "Proceed to Checkout button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.proceedToCheckout, "Proceed to Checkout button");
		}
	}
	
	public void clickLogoutButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.customerMenuLink, "Customer Menu Link",10)) {
			waiting(1.5);
		clickObject(intlloginPage.customerMenuLink, "Customer Menu Link");
		clickObject(intlloginPage.logoutButton, "Logout Button");
		}
	}
	
	public boolean verifyCustomerMenuLink() throws Exception
	{
		if(waitTillElementDisplayed(intlloginPage.customerMenuLink, "Customer Menu link",10))
		return true;
		else
		return false;
	}
	
	public void clickSignInLink() throws Exception
	{
		clickObject(intlloginPage.signInLink, "Click SignIn Link");
	}
	
	public void clickPurchaseOptionsButton() throws Exception
	{
		waiting(3);
		if(waitTillElementEnabled(intlloginPage.purchaseOptionsButton, "Purchase Options button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.purchaseOptionsButton, "Purchase Options button");
		}
	}
	
	public Boolean verifyPurchaseOptionsButton() throws Exception
	{
		waitTillElementEnabled(intlloginPage.purchaseOptionsButton, "Purchase Options button",10);
		return true;
			
	}
	
	public void clickOTPTextBox() throws Exception
	{
		waiting(3);
		driver.switchTo().frame("Cardinal-CCA-IFrame");
		if(waitTillElementEnabled(intlloginPage.otpValue, "OTP Textbox",10)) {
			waiting(1.5);
		//clickObject(intlloginPage.cardinalIFrame, "frame");
		clickObject(intlloginPage.otpValue, "OTP Texbox");
		}	
	}
	
	public void typeOTPValue() throws Exception
	{
		typeValue(intlloginPage.otpValue, "OTP Value", intlloginData.strDTOTPValue);
	}
	
	public void clickSubmitButton() throws Exception
	{
		clickObject(intlloginPage.submitButton, "Submit Button");
	}
	
	public void clickSubmitCodeButton() throws Exception
	{
		clickObject(intlloginPage.submitCodeButton, "Submit Code Button");
	}
	
	public void clickShippingAddressFirstNameTextBoxAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressFirstNameAUS, "Shipping Address First Name Textbox");
		
	}
	
	public void typeShippingAddressFirstNameAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressFirstNameAUS, "Shipping Address First Name", intlloginData.strDTTaxName);
	}
	
	public void clickShippingAddressSurNameTextBoxAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressSurNameAUS, "Shipping Address Sur Name Textbox");
		
	}
	
	public void typeShippingAddressSurNameAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressSurNameAUS, "Shipping Address Sur Name", intlloginData.strDTSurName);
	}
	
	public void clickShippingAddressStreetTextBoxAUS() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.shippingAddressStreetAUS, "Shipping Address Street Textbox",10)) {
			waiting(1.5);
		clickObject(intlloginPage.shippingAddressStreetAUS, "Shipping Address Street Textbox");
		}
		
	}
	
	public void typeShippingAddressStreetAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressStreetAUS, "Shipping Address Street", intlloginData.strDTStreet);
	}
	
	public void clickShippingAddressCityTextBoxAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressCityAUS, "Shipping Address City Textbox");
		
	}
	
	public void typeShippingAddressCityAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressCityAUS, "Shipping Address City", intlloginData.strDTCity);
	}
	
	public void clickShippingAddressPostCodeTextBoxAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressPostCodeAUS, "Shipping Address PostCode Textbox");
		
	}
	
	public void typeShippingAddressPostCodeAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressPostCodeAUS, "Shipping Address PostCode", intlloginData.strDTBillingPostCode);
	}
	
	public void clickShippingAddressTelephoneTextBoxAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressTelephoneAUS, "Shipping Address Telephone Textbox");
		
	}
	
	public void typeShippingAddressTelephoneAUS() throws Exception
	{
		typeValue(intlloginPage.shippingAddressTelephoneAUS, "Shipping Address Telephone", intlloginData.strDTTelephone);
	}
	
	public void clickShippingAddressRegionIdDropDownAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdAUS, "Shipping Address Region Id Dropdown");
		
	}
	
	public void selectShippingAddressRegionIdValueAUS() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueAUS, "Shipping Address Region Id Value");
	}
	
	public void selectShippingAddressRegionIdValueAustralia() throws Exception
	{
		clickObject(intlloginPage.shippingAddressRegionIdValueAustralia, "Shipping Address Region Id Value");
	}
	
	public void clickShippingMethodRadioButton() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.selectShippingMethod, "Select Shipping Method Radio button",10)) {
			waiting(1.5);
		clickObject(intlloginPage.selectShippingMethod, "Select Shipping Method");
		}
	}

	public void clickNIFDNITextBox() throws Exception
	{
		waiting(30);
		if(waitTillElementEnabled(intlloginPage.NIFDNI, "Select NIF/DNI Text Box",10)) {
			waiting(1.5);
		clickObject(intlloginPage.NIFDNI, "Select NIF/DNI Text Box");
		}
	}
	
	public void typeNIFDNIValue() throws Exception
	{
		typeValue(intlloginPage.NIFDNI, "NIF/DNI Value", intlloginData.strDTNIFDNI);
	}
	
	public void clickAgreement1CheckBox() throws Exception
	{
		clickObject(intlloginPage.agreementBraintree1, "Agreement1 checkbox");
		
	}
	
	public void clickAgreement2CheckBox() throws Exception
	{
		clickObject(intlloginPage.agreementBraintree2, "Agreement2 checkbox");
		
	}
	
	public void clickDeviceRegisterCheckBox() throws Exception
	{
		clickObject(intlloginPage.deviceRegisterCheckBox, "Device Register checkbox");
		
	}
	
	public void clickTandcCheckBox() throws Exception
	{
		clickObject(intlloginPage.tandcCheckBox, "T anc C checkbox");
		
	}
	
	public void selectTipoDePersonaDropDown() throws Exception
	{
		clickObject(intlloginPage.tipoDePersonaDropDown, "Tipo De Persona DropDown");
	}
	
	public void selectTipoDePersonaDropDownValue() throws Exception
	{
		clickObject(intlloginPage.tipoDePersonaValue, "Tipo De Persona Value");
	}
	
	public void selectTipoDeIdentificationDropDown() throws Exception
	{
		clickObject(intlloginPage.tipoDeIdentificationDropDown, "Tipo De Identification DropDown");
	}
	
	public void selectTipoDeIdentificationValue() throws Exception
	{
		clickObject(intlloginPage.tipoDeIdentificationValue, "Tipo De Identification Value");
	}
	
	public void selectRegimenDropDown() throws Exception
	{
		clickObject(intlloginPage.regimenDropDown, "Regimen DropDown");
	}
	
	public void selectRegimenValue() throws Exception
	{
		clickObject(intlloginPage.regimenValue, "Regimen Value");
	}
}
