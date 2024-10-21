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

public class DBTest_Amazon_Italy_ProductValidation extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the products are available at amazon";
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

		Connection con = DriverManager.getConnection("jdbc:mysql://172.26.50.12:3307/magentofeed_product_prod", dbUser,
				dbPassword);
		Statement stmt = con.createStatement();

		System.out.println("Going to execute the Query");

		String slectQuery = "SELECT ISBN10, HUB_COUNTRY_CODE, CAN_SELL_FLAG FROM MAGENTO_PRODUCT_PRICE WHERE HUB_COUNTRY_CODE='IT' AND CAN_SELL_FLAG='Y' LIMIT 153 OFFSET 459";

		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);

		System.out.println("---- Results ----");

		first: while (dbResult.next()) {
			waiting(2);
			String isbn10 = dbResult.getString("ISBN10");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			System.out.println(isbn10);

			if (countryCode.equals("IT")) {
				strDTParametersNValues = "InputDataRow=>62";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			}
			Thread.sleep(1000);

			connect().INTLLoginPage().clickAmazonAcceptCookiesButton();
			connect().INTLLoginPage().clickAmazonSearchTextBox();

			connect().INTLLoginPage().getIsbnValue(isbn10);

			connect().INTLLoginPage().clickAmazonSearchButton();
			Thread.sleep(1000);
			connect().INTLLoginPage().selectFirstBook();
			String url = driver.getCurrentUrl();
			System.out.println(url);

			if (url.contains("/" + isbn10 + "/"))
				connect().INTLLoginPage().productAvailable();
			else
				connect().INTLLoginPage().productNotAvailable();

			continue first;

		}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}