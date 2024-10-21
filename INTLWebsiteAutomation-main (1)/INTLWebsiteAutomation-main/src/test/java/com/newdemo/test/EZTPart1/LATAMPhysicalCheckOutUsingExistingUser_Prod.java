package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class LATAMPhysicalCheckOutUsingExistingUser_Prod extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the LATAM URL in browser for LATAMPhysicalCheckOutUsingExistingUser_Prod";
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

		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickActionShowCartButton();
		if (connect().INTLLoginPage().verifyRemoveItemButton()) {
			connect().INTLLoginPage().clickRemoveItemButton();
			connect().INTLLoginPage().clickAcceptButton();
		}
		Thread.sleep(1000);
		connect().INTLLoginPage().refreshPage();
		if (connect().INTLLoginPage().verifyCustomerMenuLink()) {
			connect().INTLLoginPage().clickLogoutButton();
		}
		Thread.sleep(1000);
		connect().INTLLoginPage().clickSignInLink();
		connect().INTLLoginPage().clickCustomerEmailLoginTextBox();
		connect().INTLLoginPage().typeCustomerEmailSpain();
		connect().INTLLoginPage().clickCustomerPasswordSpainTextBox();
		connect().INTLLoginPage().typeCustomerPasswordSpain();
		connect().INTLLoginPage().clickLoginButton();
		connect().INTLLoginPage().clickActionShowCartButton();
		if (connect().INTLLoginPage().verifyRemoveItemButton()) {
			connect().INTLLoginPage().clickRemoveItemButton();
			connect().INTLLoginPage().clickAcceptButton();
		}
		Thread.sleep(1000);
		connect().INTLLoginPage().refreshPage();
		if (connect().INTLLoginPage().verifyCustomerMenuLink()) {
			connect().INTLLoginPage().clickLogoutButton();
		}
		Thread.sleep(10000);
		connect().INTLLoginPage().clickSearchTextBox();
		connect().INTLLoginPage().typeTheTextInSearchBox();
		connect().INTLLoginPage().clickSearchButton();
		connect().INTLLoginPage().clickCookieCloseButton();
		connect().INTLLoginPage().clickActionPrimaryToCart();
		connect().INTLLoginPage().clickActionPrintPrimaryToCartLATAM();
		connect().INTLLoginPage().clickActionShowCartButton();
		connect().INTLLoginPage().clickProceedToCheckoutButton();
		connect().INTLLoginPage().clickCustomerEmailLoginTextBox();
		connect().INTLLoginPage().typeCustomerEmailLogin();
		connect().INTLLoginPage().clickCustomerPasswordTextBox();
		connect().INTLLoginPage().typeCustomerPassword();
		connect().INTLLoginPage().clickLoginButton();

		Thread.sleep(10000);
		connect().INTLLoginPage().clickReviewAndPaymentsButton();
		if ((connect().INTLLoginPage().clickTaxFormCheckBox()) == 1) {

			connect().INTLLoginPage().clickTaxIDTextBox();
			connect().INTLLoginPage().typeTaxID();
			connect().INTLLoginPage().clickTaxNameTextBox();
			connect().INTLLoginPage().typeTaxName();
			connect().INTLLoginPage().clickInvoicePostalCodeTextBox();
			connect().INTLLoginPage().typeInvoicePostalCode();
			connect().INTLLoginPage().clickInvoiceRegimeDropDown();
			connect().INTLLoginPage().selectInvoiceRegimeValue();
			connect().INTLLoginPage().clickInvoiceUseOfCfdiDropDown();
			connect().INTLLoginPage().selectInvoiceUseOfCfdiValue();
		}

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
		connect().INTLLoginPage().clickLogoutButton();

	}
}