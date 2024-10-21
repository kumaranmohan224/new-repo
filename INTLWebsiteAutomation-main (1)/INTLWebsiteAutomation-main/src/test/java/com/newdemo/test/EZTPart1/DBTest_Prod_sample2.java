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

public class DBTest_Prod_sample2 extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the product and prices";
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

		String slectQuery = "SELECT * FROM MAGENTO_PRODUCT_REGION where ATTRIBUTE2='Y' AND HUB_COUNTRY_CODE='SG' AND ISBN13 IN ('9781259011535','9781260288766','9781260136630','9781260547641','9789813157873','9789813157880','9789813157897','9781260547863','9781260548112','9781260547887','9789814821247','9781260289824','9789814821599','9789814821575','9781260933000','9781264357680','9781264009701','9781260575897','9781265799731','9781260597561','9781265588076','9781264370597','9781264647415','9781260597639','9781264364459','9781260597899','9781260597912','9781265917050','9781264370818','9781264363636','9781260597981','9781260786095','9781264009763','9789814821629','9781260597707','9781265598716','9780335249619','9781264339600','9780335250134','9780335250141','9781266369049','9781760427108','9780335250097','9781265010133','9780335249138','9781266084010','9781266118678','9781265678111','9781265951344','9781265487799','9781265426613','9781266138010','9781264339587','9781265822064','9781266153617','9780335251186','9780335251193','9780335251582','9781266224058','9781266269189','9780335249930','9781260376494','9781743767863','9781265958114','9781265958824','9789813319059','9781265790448','9781265614775','9781265043698','9781265615697','9781265057473','9781265074654','9781265079246','9781265986575','9781265125998','9781265236748','9781265133351','9781265138462','9781265681708','9781265186241','9780335249893','9780335249909','9781264360512','9781264360550','9781266807312','9781266807961','9781266808869','9781266813016','9781266813351','9781266820069','9781266820649','9781266821684','9781266824791','9781266825811','9781266826177','9781266834028','9781266834691','9781266834981','9781266838613','9781266841804','9781266844621','9781266848957','9781266849466','9781266849794','9781266851759','9781266853388','9781266856983','9781266857669','9781266859199','9781266867040','9781266867552','9781266870286','9781266873492','9781266874741','9781266878275','9781266878916','9781266883767','9781266885389','9781266885624','9781266886201','9781266887390','9781266887741','9781266889134','9781266889394','9781266893407','9781266896781','9781266898440','9781266898822','9781266898952','9781266899799','9781266899904','9781266910159','9781266912481','9781266913396','9781266914713','9781266914768','9781266914829','9781266917394','9781266919312','9781266928086','9781266929892','9781266930607','9781266931628','9781266932595','9781266933226','9781266934094','9781266934711','9781266937736','9781266940026','9781526850171','9781526850188','9781526850201','9781526850331','9781526850348','9781526850355','9781526850379','9781526850386','9781266942914','9781266943676','9781266950018','9781266950506','9781266956256','9781266956287','9781266958502','9781266960604','9781266962714','9781266963582','9781266963735','9781266968365','9781266968938','9781266970818','9781266133077','9781266960871','9781266207839','9781264390199','9781266238079','9781266797996','9781266798641','9781266800597','9781266801426','9781266802508','9781266802942','9781266804519','9781266804724','9781266805141','9781266806841','9781266838842','9781266914959','9781266940361','9781266955587','9781526850362','9781266966958','9781265560072','9789813311350','9781266905643','9789813319684','9789813319912','9781265342579','9781266861321','9781266798627','9781266956911','9781266971082','9781264498949','9781264553228','9781266910807','9781266186431','9781266862953','9781266867026','9781266940514','9781266937644','9781266224119','9781266816871','9781266803048','9781265200657','9781265201494','9781264676859') LIMIT 116 OFFSET 100";
		//String slectQuery = "SELECT ISBN13,LIST_PRICE, HUB_COUNTRY_CODE, COUNTRY_CODE, TAX_AMOUNT, LIST_PRICE+TAX_AMOUNT, DATE_MODIFIED,DATE_ADDED FROM MAGENTO_PRODUCT_PRICE WHERE COUNTRY_CODE IN ('MX','GB','CA','SG','AU','CO','ES','US','IN','IT') AND (DATE_MODIFIED='2024-05-14' OR DATE_ADDED='2024-05-14') AND CAN_SELL_FLAG='Y' ORDER BY COUNTRY_CODE";
		//String slectQuery = "select ISBN13,LIST_PRICE, HUB_COUNTRY_CODE, COUNTRY_CODE, TAX_AMOUNT, LIST_PRICE+TAX_AMOUNT, DATE_MODIFIED,DATE_ADDED FROM MAGENTO_PRODUCT_PRICE from MAGENTO_PRODUCT_PRICE WHERE COUNTRY_CODE='CA' AND CAN_SELL_FLAG='Y'";
		System.out.println("The query going to be executed is : " + slectQuery);

		System.out.println("Preparing Result Set");
		ResultSet dbResult = stmt.executeQuery(slectQuery);

		System.out.println("---- Results ----");

		first: while (dbResult.next()) {
			waiting(2);
			String isbn13 = dbResult.getString("ISBN13");
			String countryCode = dbResult.getString("HUB_COUNTRY_CODE");
			//float priceList = dbResult.getFloat("LIST_PRICE");

			//float taxAmount = dbResult.getFloat("TAX_AMOUNT");
			//float totalPrice = dbResult.getFloat("LIST_PRICE+TAX_AMOUNT");
			System.out.println(isbn13);
			System.out.println(countryCode);
			//System.out.println(priceList);
			//System.out.println(taxAmount);
			//System.out.println(priceList + taxAmount);
			//final DecimalFormat df = new DecimalFormat("0.00");
			//double input = priceList + taxAmount;
			//System.out.println(df.format(input));
			if (countryCode.equals("ME")) {

				strDTParametersNValues = "InputDataRow=>60";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("ES")) {
				strDTParametersNValues = "InputDataRow=>11";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("SG")) {
				strDTParametersNValues = "InputDataRow=>15";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("MX")) {
				strDTParametersNValues = "InputDataRow=>2";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("GB")) {
				strDTParametersNValues = "InputDataRow=>6";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("US")) {
				strDTParametersNValues = "InputDataRow=>10";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("AU")) {
				strDTParametersNValues = "InputDataRow=>13";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("CA")) {
				strDTParametersNValues = "InputDataRow=>8";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("CO")) {
				strDTParametersNValues = "InputDataRow=>17";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("IT")) {
				strDTParametersNValues = "InputDataRow=>20";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			} else if (countryCode.equals("IN")) {
				strDTParametersNValues = "InputDataRow=>21";
				final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
				connect().INTLLoginPage().launchINTLURL();
			}


			/*
			 * if (countryCode.equals("ME")) {
			 * 
			 * strDTParametersNValues = "InputDataRow=>59"; final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("ES")) { strDTParametersNValues = "InputDataRow=>33";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("SG")) { strDTParametersNValues = "InputDataRow=>27";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("MX")) { strDTParametersNValues = "InputDataRow=>4";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("GB")) { strDTParametersNValues = "InputDataRow=>22";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("US")) { strDTParametersNValues = "InputDataRow=>26";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("AU")) { strDTParametersNValues = "InputDataRow=>29";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("CA")) { strDTParametersNValues = "InputDataRow=>24";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("CO")) { strDTParametersNValues = "InputDataRow=>31";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("IT")) { strDTParametersNValues = "InputDataRow=>36";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); } else if
			 * (countryCode.equals("IN")) { strDTParametersNValues = "InputDataRow=>35";
			 * final int defaultDataRow =
			 * Integer.parseInt(strDTParametersNValues.split("=>")[1]);
			 * connect().INTLLoginPage().launchINTLURL(); }
			 */
			Thread.sleep(10000);
			connect().INTLLoginPage().clickAcceptAllButton();
			Thread.sleep(2500);
			connect().INTLLoginPage().clickSearchTextBox();
			connect().INTLLoginPage().getValue(isbn13);

			connect().INTLLoginPage().clickSearchButton();
			connect().INTLLoginPage().clickAcceptAllButton();

			connect().INTLLoginPage().clickCookieCloseButton();

			if ((connect().INTLLoginPage().validateProductIsbn13()) == true)

				{connect().INTLLoginPage().isbnDisplayed();
			if ((connect().INTLLoginPage().validatePriceAtWebsite())== true)
				connect().INTLLoginPage().priceAtWebsiteDisplayed();
			
			else
				connect().INTLLoginPage().priceAtWebsiteNotDisplayed();}
			else {

				continue first;

			}
			
			
			

			Thread.sleep(2500);
			if (countryCode.equals("ES") || countryCode.equals("IT")) {
				List<Integer> price_App = connect().INTLLoginPage().validatePriceListES();
				if (price_App.size() == 0) {
					connect().INTLLoginPage().priceNotFound();
					continue first;
				}
				/*
				 * if (taxAmount == 0) { float price_DB =
				 * connect().INTLLoginPage().getFloatValue(priceList); String dbPrice =
				 * Float.toString(price_DB).replaceAll("[^0-9]", ""); if
				 * (price_App.contains(dbPrice)) connect().INTLLoginPage().correctPrice(); else
				 * connect().INTLLoginPage().incorrectPrice(); } else { String price_DB =
				 * connect().INTLLoginPage().getFloatDecValue(df.format(input)).replaceAll(
				 * "[^0-9]", "");
				 * 
				 * int dbPrice = Integer.parseInt(price_DB); if (price_App.contains(dbPrice))
				 * connect().INTLLoginPage().correctPrice(); else
				 * connect().INTLLoginPage().incorrectPrice(); } } else { List<Float> price_App
				 * = connect().INTLLoginPage().validatePriceList(); if (price_App.size() == 0) {
				 * connect().INTLLoginPage().priceNotFound(); continue first; } if (taxAmount ==
				 * 0) { float price_DB = connect().INTLLoginPage().getFloatValue(priceList); if
				 * (price_App.contains(price_DB)) connect().INTLLoginPage().correctPrice(); else
				 * connect().INTLLoginPage().incorrectPrice(); } else { String price_DB =
				 * connect().INTLLoginPage().getFloatDecValue(df.format(input)); float dbPrice =
				 * Float.parseFloat(price_DB); if (price_App.contains(dbPrice))
				 * connect().INTLLoginPage().correctPrice(); else
				 * connect().INTLLoginPage().incorrectPrice(); }
				 */
			}

		}

		System.out.println("Going to close the Connection with database");
		con.close();
	}

}