package com.newdemo.test.EZTPart1;

import java.net.HttpURLConnection;
import java.net.URL;
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

public class DBTest_ProductCoverValidation extends ScriptBase {
	private Object url;

	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the product cover image validation";
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

		String slectQuery = "SELECT ISBN13, HUB_COUNTRY_CODE, ATTRIBUTE2, DATE_MODIFIED, DATE_ADDED FROM MAGENTO_PRODUCT_REGION WHERE attribute2='Y' AND ISBN13 IN ('9788448640040','9788448640484','9788448637859','9788448639211','9788448639563','9788448639754','9788448639907','9788448640019','9788448640071','9788448640101','9788448640309','9788448640439','9788448640781','9788448637576','9788448637682','9788448638030','9788448638122','9788448638269','9788448639044','9788448639297','9788448639327','9788448639631','9788448639662','9788448625603','9788448640989','9788448639150','9788448640514','9788448637545','9788448638092','9788448638153','9788448639600','9788448639235','9788448639402','9788448641177','9788448640361','9788448640385','9788448637514','9788448637736','9788448638184','9788448638306','9788448639082','9788448639266','9788448641207','9788448639983','9788448640132','9788448639372','9788448638504','9788448639815','9788448639938','9788448640682','9788448638412','9788448639846','9788448639877','9788448640194','9788448640330','9788448637606','9788448637637','9788448638061','9788448638771','9788448639785','9788448638764','9780077339586','9788448640675')";

		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);

		System.out.println("---- Results ----");

		first: while (dbResult.next()) {
			waiting(2);
			String isbn13 = dbResult.getString("ISBN13");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			System.out.println(isbn13);
			System.out.println(countryCode);

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
			if ((connect().INTLLoginPage().validateProductImage()) == true)
				connect().INTLLoginPage().imageDisplayed();
			else
				connect().INTLLoginPage().imageNotDisplayed();
			driver.get("https://covers.eppg.com/Jpeg_400-wide/" + isbn13 + ".jpeg");

			connect().INTLLoginPage().ResponseCodeCheck(isbn13);
		}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}