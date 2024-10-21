package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class ASIADigitalCheckOut_Prod extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the Asia URL in browser for ASIADigitalCheckOut_Prod";
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
        Thread.sleep(10000);
        
        connect().INTLLoginPage().getCSPHeaders(driver.getCurrentUrl());
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickBlogLink();
		connect().INTLLoginPage().validateBlog();

		connect().INTLLoginPage().clickSearchTextBox();
		connect().INTLLoginPage().typeTheTextInSearchBox();
		connect().INTLLoginPage().clickSearchButton();

		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickCookieCloseButton();
		connect().INTLLoginPage().clickAddToCartButton();
		connect().INTLLoginPage().clickGuestCheckOutButton();
		connect().INTLLoginPage().clickEmailAddressTextBox();
		connect().INTLLoginPage().typeEmailAddress();
		connect().INTLLoginPage().clickConfirmEmailAddressTextBox();
		connect().INTLLoginPage().typeConfirmEmailAddress();
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
		connect().INTLLoginPage().verifyGooglePayRadioButton();
		connect().INTLLoginPage().verifyPayPalRadioButton();
		connect().INTLLoginPage().clickCreditCardRadioButton();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickBillingAddressBrainTreeFirstNameTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreeFirstName();
		connect().INTLLoginPage().clickBillingAddressBrainTreeSurNameTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreeSurName();
		connect().INTLLoginPage().clickBillingAddressBrainTreeStreetTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreeStreet();
		connect().INTLLoginPage().clickBillingAddressBrainTreeCityTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreeCity();

		connect().INTLLoginPage().clickBillingAddressBrainTreePostCodeTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreePostCode();

		connect().INTLLoginPage().clickBillingAddressBrainTreeTelephoneTextBox();
		connect().INTLLoginPage().typeBillingAddressBrainTreeTelephone();
		connect().INTLLoginPage().clickActionUpdateButton();

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
		Thread.sleep(10000);
		connect().INTLLoginPage().switchiFrameUsingFrameName("braintree-hosted-field-number");
		connect().INTLLoginPage().clickCreditCardNumberTextBox();
		connect().INTLLoginPage().typeCreditCardNumber();
		connect().INTLLoginPage().switchToParentFrame();
		connect().INTLLoginPage().switchiFrameUsingFrameName("braintree-hosted-field-expirationDate");
		connect().INTLLoginPage().clickExpirationTextBox();
		connect().INTLLoginPage().typeExpirationMonthYear();
		connect().INTLLoginPage().switchToParentFrame();
		connect().INTLLoginPage().switchiFrameUsingFrameName("braintree-hosted-field-cvv");
		connect().INTLLoginPage().clickcvvTextBox();
		connect().INTLLoginPage().typecvv();
		connect().INTLLoginPage().switchToParentFrame();
		connect().INTLLoginPage().clickPrimaryCheckoutButton();
		Thread.sleep(10000);

		connect().INTLLoginPage().clickContinueButton();

	}
}