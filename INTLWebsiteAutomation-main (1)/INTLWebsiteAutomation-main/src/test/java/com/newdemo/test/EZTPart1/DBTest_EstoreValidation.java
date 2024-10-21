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

public class DBTest_EstoreValidation extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea() throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the URL in browser and verify the product and prices";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail(strDescription, "ModuleName", "ModuleName");
			// strDTParametersNValues = ParameterNValue;

			// final int defaultDataRow =
			// Integer.parseInt(strDTParametersNValues.split("=>")[1]);

			delToolsInDB();
			// connectDB();
			// loginLATAMURL();
		} catch (Exception e) {
			objHTMLFunctions.reportPassFailToATU(e.getMessage(), "Exception", "MESSAGE");
			// System.out.println("An exception occurred: " + e.getMessage());
		}

	}

	public void loginLATAMURL() throws Exception {
		// connect().INTLLoginPage().launchINTLURL();
		connect().INTLLoginPage().launchINTLURL();
		connect().INTLLoginPage().waitForHomePage(20);
		// connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickSearchTextBox();
		connect().INTLLoginPage().typeTheTextInSearchBox();
		connect().INTLLoginPage().clickSearchButton();
		// connect().INTLLoginPage().clickAcceptAllButton();
		// connect().INTLLoginPage().clickLearnMoreLink();
		// connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickCookieCloseButton();

	}

	public void connectDB() throws Exception {
		connect().INTLDB().delToolsInDB();
	}

	public void delToolsInDB() throws Exception
			{
					//String title;
					//String regURL;
					//String dbHost=intlDBData.dbHost;
					//String dbUser=intlDBData.dbUser;
					//String dbPassword=intlDBData.dbPassword;
					/*
					 * String dbHost="172.26.50.13"; String dbUser="mhes01_qa"; //String
					 * dbPassword="magent0f@@d"; String dbPassword="Welcome#mhe01";
					 */
					
					String dbHost="172.26.50.12";
					String dbUser="magentofeed_product_prod";
					//String dbPassword="magent0f@@d";
					String dbPassword="jjLTm1M9i1Ui";
					//int toolID=0;
					
					//Class.forName("oracle.jdbc.driver.OracleDriver");
					//Class.forName("DriverManager");
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Class.forName("org.mariadb.jdbc.Driver");
					System.out.println("Going to establish connection with Database");
					//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//10.227.75.114:1521/sprkqalv_ash", "cmsrep", "CMSREPQALV62$");			
					//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@//"+dbHost, dbUser, dbPassword);
					//Connection con=DriverManager.getConnection("jdbc:mysql://172.26.50.13:3307/mhes01_qa", dbUser, dbPassword);
					Connection con=DriverManager.getConnection("jdbc:mysql://172.26.50.12:3307/magentofeed_product_prod", dbUser, dbPassword);
					Statement stmt=con.createStatement();
					
					System.out.println("Going to execute the Query");
					
					//String slectQuery="SELECT * FROM MAGENTO_PRODUCT_REGION WHERE ATTRIBUTE2='Y' AND MASTER_ISBN IS NOT NULL";
					//String slectQuery="SELECT * FROM MAGENTO_PRODUCT_REGION WHERE DATE_ADDED='2023-03-14' OR DATE_MODIFIED='2023-03-14' AND ATTRIBUTE2='Y'";
					//String slectQuery="SELECT MPR.ISBN13, MPR.GROUP_NAME, MPR.DATE_ADDED, MPR.DATE_MODIFIED, MPR.ATTRIBUTE2, MPP.LIST_PRICE, MPP.TAX_AMOUNT, ROUND((MPP.LIST_PRICE+MPP.TAX_AMOUNT),2), MPR.HUB_COUNTRY_CODE, MPP.CAN_SELL_FLAG, MPP.COUNTRY_CODE, MPR.`FORMAT`, MPS.STOCK_ON_HAND, MPS.STOCK_AVAILABLE_FLAG FROM MAGENTO_PRODUCT_REGION MPR INNER JOIN MAGENTO_PRODUCT_PRICE MPP ON MPR.ISBN13=MPP.ISBN13 INNER JOIN MAGENTO_PRODUCT_STOCK MPS ON MPR.ISBN13=MPS.ISBN13 WHERE ((MPR.DATE_MODIFIED='2023-03-16' OR MPR.DATE_ADDED='2023-03-16') AND MPR.ATTRIBUTE2='Y') AND MPR.HUB_COUNTRY_CODE=MPP.COUNTRY_CODE AND (MPP.CAN_SELL_FLAG='Y') AND MPR.HUB_COUNTRY_CODE=MPS.HUB_COUNTRY_CODE AND MPR.HUB_COUNTRY_CODE NOT IN ('ME')";
					String slectQuery="SELECT OPPORTUNITYID, ISBN13, DIGITAL_SUPPLIER_GROUP, INSTITUTION_NAME, COUNTRY, ENROLLMENT, DATE_ADDED, DATE_MODIFIED, OPP_CLOSEDATE, CURRENT_DATE FROM MAGENTO_ADOPTION_ECOMMERCE WHERE HUB_COUNTRY_CODE='SG'AND (DATE_ADDED>=CURRENT_DATE-INTERVAL 1 MONTH OR DATE_MODIFIED>CURRENT_DATE-INTERVAL 1 MONTH)";
					//SELECT MPC.ISBN13, MPR.HUB_COUNTRY_CODE, MPC.DATE_MODIFIED FROM MAGENTO_PRODUCT_COVERS MPC INNER JOIN MAGENTO_PRODUCT_REGION MPR ON MPR.ISBN13=MPC.ISBN13 WHERE MPC.DATE_MODIFIED='2023-04-29';
					//String delToolQuery="delete from lti_external_tool_info where TITLE ='"+intlDBData.runTimeToolTitle+"'";
					System.out.println("The query going to be executed is : "+slectQuery);
					
					
					System.out.println("Preparing Result Set");
					ResultSet dbResult=stmt.executeQuery(slectQuery);
								
					System.out.println("---- Results ----");
					//dbResult.getString("ISBN13");
					first:
					while(dbResult.next()) { waiting(2);
					String isbn13=dbResult.getString("ISBN13");
					String opportunityId=dbResult.getString("OPPORTUNITYID");
					String digitalSupplierGroup=dbResult.getString("DIGITAL_SUPPLIER_GROUP");
					String institutionName=dbResult.getString("INSTITUTION_NAME");
					String country=dbResult.getString("COUNTRY");
					String enrollment=dbResult.getString("ENROLLMENT");
					String dateAdded=dbResult.getString("DATE_ADDED");
					String dateModified=dbResult.getString("DATE_MODIFIED");
					String currentDate=dbResult.getString("CURRENT_DATE");
					String oppCloseDate=dbResult.getString("OPP_CLOSEDATE");
					//float totalPrice=dbResult.getFloat("MPP.LIST_PRICE+MPP.TAX_AMOUNT");
					 System.out.println(isbn13);
					 System.out.println(opportunityId);
					 System.out.println(dateAdded);
					 System.out.println(dateModified);
					 System.out.println(oppCloseDate);
					 System.out.println(currentDate);
					 
					 strDTParametersNValues = "InputDataRow=>61"; 
					 final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);
					 connect().INTLLoginPage().launchINTLURL();
					 
					 Thread.sleep(10000);
					 //driver.get("https://estore.mheducation.com.sg/redeem/code/");
					 //Thread.sleep(10000);
					 connect().INTLLoginPage().clickCodeTextBox();
					 connect().INTLLoginPage().typeCodeValue(opportunityId);
					 connect().INTLLoginPage().clickSubmitCodeButton();
					 continue first;}
						/*connect().INTLLoginPage().clickAcceptAllButton();
						Thread.sleep(2500);
						connect().INTLLoginPage().clickSearchTextBox();
						connect().INTLLoginPage().getValue(isbn13);
						//connect().INTLLoginPage().typeTheTextInSearchBox();
						connect().INTLLoginPage().clickSearchButton();
						connect().INTLLoginPage().clickAcceptAllButton();
						//connect().INTLLoginPage().clickLearnMoreLink();
						//connect().INTLLoginPage().clickAcceptAllButton();
						connect().INTLLoginPage().clickCookieCloseButton();
						if((connect().INTLLoginPage().validateProductImage())==true)
							connect().INTLLoginPage().imageDisplayed();
						else
							connect().INTLLoginPage().imageNotDisplayed();
						if((connect().INTLLoginPage().validateProductIsbn13())==true)
						
						  connect().INTLLoginPage().isbnDisplayed(); 
						  else {
							  //while(dbResult.next())
							  //driver.close();
							  continue first;
						  //connect().INTLLoginPage().isbnNotDisplayed();
						  
						  }
						 
						Thread.sleep(2500);
					    if(countryCode.equals("ES") || countryCode.equals("IT")) {
					    List<Integer> price_App = connect().INTLLoginPage().validatePriceListES();
					    if(price_App.size()==0) {
					    	connect().INTLLoginPage().priceNotFound();
					    	continue first;}
					    if(taxAmount==0) {
							float price_DB = connect().INTLLoginPage().getFloatValue(priceList);
							String dbPrice = Float.toString(price_DB).replaceAll("[^0-9]","");
							if(price_App.contains(dbPrice))
								connect().INTLLoginPage().correctPrice();
							else
								connect().INTLLoginPage().incorrectPrice();
							}
							else {
							String price_DB = connect().INTLLoginPage().getFloatDecValue(df.format(input)).replaceAll("[^0-9]","");
							
							int dbPrice=Integer.parseInt(price_DB);
							if(price_App.contains(dbPrice))
								connect().INTLLoginPage().correctPrice();
							else
								connect().INTLLoginPage().incorrectPrice();
							}}
					    else {
					    List<Float> price_App = connect().INTLLoginPage().validatePriceList();
					    if(price_App.size()==0) {
					    	connect().INTLLoginPage().priceNotFound();
					    	continue first;}
						if(taxAmount==0) {
						float price_DB = connect().INTLLoginPage().getFloatValue(priceList);
						if(price_App.contains(price_DB))
							connect().INTLLoginPage().correctPrice();
						else
							connect().INTLLoginPage().incorrectPrice();
						}
						else {
						String price_DB = connect().INTLLoginPage().getFloatDecValue(df.format(input));
						float dbPrice=Float.parseFloat(price_DB);
						if(price_App.contains(dbPrice))
							connect().INTLLoginPage().correctPrice();
						else
							connect().INTLLoginPage().incorrectPrice();
						}
					    
					    }
						//String group_Name = connect().INTLLoginPage().getValue(groupName);
						//if(group_Name.equals("NULL")) {
						if((connect().INTLLoginPage().verifyPurchaseOptionsButton()).TRUE) {
							connect().INTLLoginPage().clickPurchaseOptionsButton();
							
						}
						
						 * //if(price_DB.contains(price_App)) if(price_App.contains(price_DB))
						 * connect().INTLLoginPage().correctPrice(); else
						 * connect().INTLLoginPage().incorrectPrice();
						 
					 
					 
					 //System.out.println("Title ID : "+toolID);
					}
					
			
				
						
					
					 * while(dbResult.next()) { waiting(2); title=dbResult.getString("TITLE");
					 * regURL=dbResult.getString("REGISTRATION_LAUNCH");
					 * toolID=dbResult.getInt("ID");
					 * 
					 * System.out.println("Title ID : "+toolID);
					 * System.out.println("Title : "+title);
					 * System.out.println("Registration URL : "+regURL); waiting(2); }
					 * System.out.println("---- END ----");
					 * 
					 * String
					 * delToolPoliciesQuery="delete from LTI_EXTERNAL_TOOL_POLICIES where TOOL_ID = "
					 * +toolID; System.out.
					 * println("Going to delete the record in Data Base using the query >>>>"
					 * +delToolPoliciesQuery); stmt.executeQuery(delToolPoliciesQuery);
					 * //System.out.
					 * println("Going to delete the record in Data Base using the query >>>>"
					 * +delToolQuery); //stmt.executeQuery(delToolQuery);
					 * System.out.println("Record is deleted");
					 
*/					
					System.out.println("Going to close the Connection with database");
					con.close();
				}
				/*
				 * catch(Exception objException) {
				 * objHTMLFunctions.ReportPassFail("Failed deleting tools from DB" +
				 * CMNFunctions.GetExceptionNDisplay(objException, true), "True", "False"); }
				 */
}