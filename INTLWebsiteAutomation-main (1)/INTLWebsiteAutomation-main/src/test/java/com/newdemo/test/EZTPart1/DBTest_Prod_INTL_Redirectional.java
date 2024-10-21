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

public class DBTest_Prod_INTL_Redirectional extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the ISBN redirection at prod";
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
				"jdbc:mysql://afq-intl-pbg-ryerson-prod.cluster-cyd1gczom61q.us-east-1.rds.amazonaws.com:3306/magentofeed_product_prod",
				dbUser, dbPassword);
		Statement stmt = con.createStatement();

		System.out.println("Going to execute the Query");

		String slectQuery = "SELECT MPR.ISBN13, MPR.GROUP_NAME, MPR.DATE_ADDED, MPR.DATE_MODIFIED, MPR.ATTRIBUTE2, MPP.LIST_PRICE, MPP.TAX_AMOUNT, MPP.LIST_PRICE+MPP.TAX_AMOUNT, MPR.HUB_COUNTRY_CODE, MPP.CAN_SELL_FLAG, MPP.COUNTRY_CODE, MPR.`FORMAT`, MPS.STOCK_ON_HAND, MPS.STOCK_AVAILABLE_FLAG FROM MAGENTO_PRODUCT_REGION MPR INNER JOIN MAGENTO_PRODUCT_PRICE MPP ON MPR.ISBN13=MPP.ISBN13 INNER JOIN MAGENTO_PRODUCT_STOCK MPS ON MPR.ISBN13=MPS.ISBN13 WHERE ((MPR.DATE_MODIFIED='2024-06-02' OR MPR.DATE_ADDED='2024-06-02') AND MPR.ATTRIBUTE2='Y') AND MPR.HUB_COUNTRY_CODE=MPP.COUNTRY_CODE AND (MPP.CAN_SELL_FLAG='Y') AND MPR.HUB_COUNTRY_CODE=MPS.HUB_COUNTRY_CODE ORDER BY HUB_COUNTRY_CODE";
		//String slectQuery = "SELECT ISBN13 FROM MAGENTO_PRODUCT WHERE DIVISION!='PBG' AND ISBN13 IN ('9788448631291','9788448631314','9788448631345','9788448635008','9788448635015','9788448635091','9788448635114','9788448635121','9788448635138','9788448637170')";

		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);

		System.out.println("---- Results ----");

		first: while (dbResult.next()) {
			waiting(2);
			String isbn13 = dbResult.getString("ISBN13");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			float priceList = dbResult.getFloat("LIST_PRICE");
			String groupName = dbResult.getString("GROUP_NAME");
			float taxAmount = dbResult.getFloat("TAX_AMOUNT");

			System.out.println(isbn13);
			System.out.println(countryCode);
			System.out.println(priceList);
			System.out.println(taxAmount);
			System.out.println(priceList + taxAmount);
			final DecimalFormat df = new DecimalFormat("0.00");
			double input = priceList + taxAmount;
			System.out.println(df.format(input));

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
			String url = driver.getCurrentUrl();
			if (countryCode.equals("CA"))
				driver.get(url + "highereducation/products/" + isbn13 + ".html");
			else
				driver.get(url + isbn13 + ".html");
			Thread.sleep(10000);
			connect().INTLLoginPage().clickAcceptAllButton();

			if ((connect().INTLLoginPage().validateProductImage()) == true)
				connect().INTLLoginPage().imageDisplayed();
			else
				connect().INTLLoginPage().imageNotDisplayed();
			if ((connect().INTLLoginPage().validateProductIsbn13()) == true)

				connect().INTLLoginPage().isbnDisplayed();

			else {

				connect().INTLLoginPage().getValue(isbn13);
				continue first;

			}

			Thread.sleep(2500);
			if (countryCode.equals("ES") || countryCode.equals("IT")) {
				List<Integer> price_App = connect().INTLLoginPage().validatePriceListES();
				if (price_App.size() == 0) {
					connect().INTLLoginPage().priceNotFound();
					continue first;
				}
				if (taxAmount == 0) {
					float price_DB = connect().INTLLoginPage().getFloatValue(priceList);
					String dbPrice = Float.toString(price_DB).replaceAll("[^0-9]", "");
					if (price_App.contains(dbPrice))
						connect().INTLLoginPage().correctPrice();
					else
						connect().INTLLoginPage().incorrectPrice();
				} else {
					String price_DB = connect().INTLLoginPage().getFloatDecValue(df.format(input)).replaceAll("[^0-9]",
							"");

					int dbPrice = Integer.parseInt(price_DB);
					if (price_App.contains(dbPrice))
						connect().INTLLoginPage().correctPrice();
					else
						connect().INTLLoginPage().incorrectPrice();
				}
			} else {
				List<Float> price_App = connect().INTLLoginPage().validatePriceList();
				if (price_App.size() == 0) {
					connect().INTLLoginPage().priceNotFound();
					continue first;
				}
				if (taxAmount == 0) {
					float price_DB = connect().INTLLoginPage().getFloatValue(priceList);
					if (price_App.contains(price_DB))
						connect().INTLLoginPage().correctPrice();
					else
						connect().INTLLoginPage().incorrectPrice();
				} else {
					String price_DB = connect().INTLLoginPage().getFloatDecValue(df.format(input));
					float dbPrice = Float.parseFloat(price_DB);
					if (price_App.contains(dbPrice))
						connect().INTLLoginPage().correctPrice();
					else
						connect().INTLLoginPage().incorrectPrice();
				}

			}
		}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}