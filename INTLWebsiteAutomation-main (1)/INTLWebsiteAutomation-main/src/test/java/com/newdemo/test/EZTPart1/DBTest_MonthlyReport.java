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

public class DBTest_MonthlyReport extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "GTS application automation - Validating the UK isbns on monthly basis";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Verifying Product Image, TOC, Description & Stocks for September month";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail(strDescription, "ModuleName", "ModuleName");
			delToolsInDB();

		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");

		}

	}

	/*
	 * public void loginLATAMURL() throws Exception {
	 * 
	 * connect().INTLLoginPage().launchINTLURL();
	 * connect().INTLLoginPage().waitForHomePage(20);
	 * 
	 * connect().INTLLoginPage().clickSearchTextBox();
	 * connect().INTLLoginPage().typeTheTextInSearchBox();
	 * connect().INTLLoginPage().clickSearchButton();
	 * 
	 * connect().INTLLoginPage().clickCookieCloseButton();
	 * 
	 * }
	 */

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
		Statement stmt1=con.createStatement();
		Statement stmt2=con.createStatement();
		Statement stmt3=con.createStatement();

		System.out.println("Going to execute the Query");

		//String slectQuery = "SELECT * FROM MAGENTO_PRODUCT_REGION WHERE ATTRIBUTE2='Y' AND HUB_COUNTRY_CODE='GB' AND ((MONTH(date_added)= '09' AND YEAR(date_added) = '2023') OR (MONTH(date_modified)= '09' AND YEAR(date_modified) = '2023'))";
		String slectQuery = "SELECT * FROM MAGENTO_PRODUCT_REGION WHERE ATTRIBUTE2='Y' AND HUB_COUNTRY_CODE='GB' AND ((MONTH(date_added)= '09' AND YEAR(date_added) = '2023') OR (MONTH(date_modified)= '09' AND YEAR(date_modified) = '2023')) LIMIT 220 OFFSET 408";

		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);
		

		System.out.println("---- Results ----");
		
		
		first: while (dbResult.next()) {
		
			waiting(2);
			String isbn13 = dbResult.getString("ISBN13");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			//float priceList = dbResult.getFloat("LIST_PRICE");
			//String groupName = dbResult.getString("GROUP_NAME");
			//float taxAmount = dbResult.getFloat("TAX_AMOUNT");

			System.out.println(isbn13);
			System.out.println(countryCode);
			//System.out.println(priceList);
			//System.out.println(taxAmount);
			//System.out.println(priceList + taxAmount);
			//final DecimalFormat df = new DecimalFormat("0.00");
			//double input = priceList + taxAmount;
			//System.out.println(df.format(input));
			
			String selectQueryPrice = "SELECT * FROM MAGENTO_PRODUCT_PRICE WHERE ISBN13='"+isbn13+"' AND COUNTRY_CODE='GB'";
			ResultSet rsp= stmt1.executeQuery(selectQueryPrice);
			if(rsp.next()) {
			System.out.println("ISBN is displayed at price table");
			
			

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
			connect().INTLLoginPage().getValue(isbn13);

			connect().INTLLoginPage().clickSearchButton();
			connect().INTLLoginPage().clickAcceptAllButton();

			connect().INTLLoginPage().clickCookieCloseButton();

			String selectQueryCovers = "SELECT * FROM MAGENTO_PRODUCT_COVERS WHERE ISBN13='"+isbn13+"'";
			ResultSet rsc= stmt1.executeQuery(selectQueryCovers);
			if(rsc.next()) {
			System.out.println(rsc.getString("ISBN13"));
	if((rsc.getString("ISBN13")).equals(""+isbn13+"")) {
		System.out.println("Validating product covers");
			if ((connect().INTLLoginPage().validateProductImage()) == true)
				connect().INTLLoginPage().imageDisplayed();
			else
				connect().INTLLoginPage().imageNotDisplayed();
			}
			}
			
			if ((connect().INTLLoginPage().validateProductIsbn13()) == true)

				connect().INTLLoginPage().isbnDisplayed();

			else 

				connect().INTLLoginPage().getValue(isbn13);
			
			String selectQuery1 = "SELECT * FROM MAGENTO_PRODUCT_TOC WHERE ISBN13='"+isbn13+"' AND HUB_COUNTRY_CODE='GB'";
			ResultSet rs1= stmt1.executeQuery(selectQuery1);
			if(rs1.next()) {
			System.out.println(rs1.getString("TOC"));
			connect().INTLLoginPage().tocDisplayed();
			}else 
				connect().INTLLoginPage().tocNotDisplayed();
			
			String selectQuery2 = "SELECT * FROM MAGENTO_PRODUCT_TEXT WHERE ISBN13='"+isbn13+"' AND HUB_COUNTRY_CODE='GB'";
			ResultSet rs2= stmt2.executeQuery(selectQuery2);
			if(rs2.next()) {
			System.out.println(rs2.getString("TEXT"));
			connect().INTLLoginPage().descriptionDisplayed();
			}else 
				connect().INTLLoginPage().descriptionNotDisplayed();
			
			if(dbResult.getString("FORMAT").equals("PRINT")) {
			String selectQuery3 = "SELECT * FROM MAGENTO_PRODUCT_STOCK WHERE ISBN13='"+isbn13+"' AND HUB_COUNTRY_CODE='GB'";
			ResultSet rs3= stmt3.executeQuery(selectQuery3);
			if(rs3.next()) {
			System.out.println(rs3.getString("STOCK_AVAILABLE_FLAG"));
			System.out.println(rs3.getDouble("STOCK_ON_HAND"));
			if(((rs3.getString("STOCK_AVAILABLE_FLAG")).equals("Y")) && (rs3.getDouble("STOCK_ON_HAND"))!=0)
			connect().INTLLoginPage().stockAvailable();
			else if((rs3.getString("STOCK_AVAILABLE_FLAG")).equals("P"))
				connect().INTLLoginPage().stockAvailableInFuture();
			else 
				connect().INTLLoginPage().stockNotAvailable();
			}
			}
			
			
			}

			continue first;
			
			
	}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}
