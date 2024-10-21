package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class LATAMDigitalCheckOutUsingExistingUser_upgradestage extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the LATAM URL in browser";
			ATUReports.currentRunDescription = strDescription;
			objHTMLFunctions.ReportPassFail(strDescription, "ModuleName", "ModuleName");
			strDTParametersNValues = ParameterNValue;

			final int defaultDataRow = Integer.parseInt(strDTParametersNValues.split("=>")[1]);

			loginLATAMURL();
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
		connect().INTLLoginPage().clickAddToCartButton();

		connect().INTLLoginPage().clickCustomerEmailLoginTextBox();
		connect().INTLLoginPage().typeCustomerEmailLogin();
		connect().INTLLoginPage().clickCustomerPasswordTextBox();
		connect().INTLLoginPage().typeCustomerPassword();
		connect().INTLLoginPage().clickLoginButton();
		connect().INTLLoginPage().clickPrimaryCheckoutButton();
		connect().INTLLoginPage().clickVisaPaymentMethodButton();
		connect().INTLLoginPage().clickCCFullNameTextBox();
		connect().INTLLoginPage().typeCCFullName();
		connect().INTLLoginPage().clickCCNumberTextBox();
		connect().INTLLoginPage().typeCCNumber();
		connect().INTLLoginPage().clickExpirationDateMonthDropDown();
		connect().INTLLoginPage().selectExpirationDateMonthValue();
		connect().INTLLoginPage().clickExpirationYearDropDown();
		connect().INTLLoginPage().selectExpirationYearValue();
		connect().INTLLoginPage().clickSecurityCodeTextBox();
		connect().INTLLoginPage().typeSecurityCode();
		connect().INTLLoginPage().clickContactPhoneTextBox();
		connect().INTLLoginPage().typeContactPhone();
		connect().INTLLoginPage().clickPayButton();
		connect().INTLLoginPage().clickResponseButtonContinue();

		connect().INTLLoginPage().clickContinueButton();

	}
}