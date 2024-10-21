package com.newdemo.test.EZTPart1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.List;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class DBTest_EnhancedSearchTest extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the ISBN redirection at preprod";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail(strDescription, "ModuleName", "ModuleName");
			delToolsInDB();

		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");

		}

	}

	public void loginLATAMURL() throws Exception {

		connect().INTLLoginPage().launchINTLURL();
		connect().INTLLoginPage().waitForHomePage(20);

		connect().INTLLoginPage().clickSearchTextBox();
		connect().INTLLoginPage().typeTheTextInSearchBox();
		connect().INTLLoginPage().clickSearchButton();

		connect().INTLLoginPage().clickCookieCloseButton();

	}

	public void connectDB() throws Exception {
		connect().INTLDB().delToolsInDB();
	}

	public void delToolsInDB() throws Exception {
		String dbHost = "172.26.50.12";
		String dbUser = "magentofeed_product_prod";

		String dbPassword = "jjLTm1M9i1Ui";
		Class.forName("com.mysql.cj.jdbc.Driver");

		System.out.println("Going to establish connection with Database");

		Connection con = DriverManager.getConnection(
				"jdbc:mysql://172.26.50.12:3307/magentofeed_product_prod",
				dbUser, dbPassword);
		Statement stmt = con.createStatement();

		System.out.println("Going to execute the Query");

		String slectQuery = "SELECT * FROM MAGENTO_PRODUCT_REGION WHERE ISBN13 IN ('9780076965250','9789355321299','9788838675096','9781456270803','9780071821568','9781266727030') AND ATTRIBUTE2='Y' AND DATE_ADDED!='2022-12-01'";

		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);

		System.out.println("---- Results ----");

		first: while (dbResult.next()) {
			waiting(2);
			String isbn13 = dbResult.getString("ISBN13");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			//float priceList = dbResult.getFloat("LIST_PRICE");
			String groupName = dbResult.getString("GROUP_NAME");
			//float taxAmount = dbResult.getFloat("TAX_AMOUNT");

			System.out.println(isbn13);
			System.out.println(countryCode);
			//System.out.println(priceList);
			//System.out.println(taxAmount);
			//System.out.println(priceList + taxAmount);
			//final DecimalFormat df = new DecimalFormat("0.00");
			//double input = priceList + taxAmount;
			//System.out.println(df.format(input));

			if (countryCode.equals("ME")) {

				strDTParametersNValues = "InputDataRow=>59";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("ES")) {
				strDTParametersNValues = "InputDataRow=>33";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("SG")) {
				strDTParametersNValues = "InputDataRow=>27";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("MX")) {
				strDTParametersNValues = "InputDataRow=>4";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("GB")) {
				strDTParametersNValues = "InputDataRow=>22";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("US")) {
				strDTParametersNValues = "InputDataRow=>26";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("AU")) {
				strDTParametersNValues = "InputDataRow=>29";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("CA")) {
				strDTParametersNValues = "InputDataRow=>24";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("CO")) {
				strDTParametersNValues = "InputDataRow=>31";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("IT")) {
				strDTParametersNValues = "InputDataRow=>36";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("IN")) {
				strDTParametersNValues = "InputDataRow=>35";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			}

			Thread.sleep(10000);
			connect().INTLLoginPage().clickAcceptAllButton();
			Thread.sleep(2500);
			connect().INTLLoginPage().clickSearchTextBox();
			connect().INTLLoginPage().typeValueUsingActionBuilder("Marketing");
			connect().INTLLoginPage().clickSearchButton();
	
			connect().INTLLoginPage().clickAcceptAllButton();
			continue first;
			
			/*
			 * if ((connect().INTLLoginPage().validateProductImage()) == true)
			 * connect().INTLLoginPage().imageDisplayed(); else
			 * connect().INTLLoginPage().imageNotDisplayed(); if
			 * ((connect().INTLLoginPage().validateProductIsbn13()) == true)
			 * 
			 * connect().INTLLoginPage().isbnDisplayed();
			 * 
			 * else {
			 * 
			 * connect().INTLLoginPage().getValue(isbn13); continue first;
			 * 
			 * }
			 */	}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}