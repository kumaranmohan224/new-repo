package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class SpainDigitalCheckOutUsingExistingUser extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the Spain URL in browser for SpainDigitalCheckOutUsingExistingUser";
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
		connect().INTLLoginPage().getCSPHeaders(driver.getCurrentUrl());
		connect().INTLLoginPage().clickAcceptAllButton();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickActionShowCartButton();
		if (connect().INTLLoginPage().verifyRemoveItemButton()) {
			connect().INTLLoginPage().clickRemoveItemButton();
			connect().INTLLoginPage().clickAcceptButton();
		}
		Thread.sleep(10000);
		connect().INTLLoginPage().refreshPage();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		if (connect().INTLLoginPage().verifyCustomerMenuLink()) {
			connect().INTLLoginPage().clickLogoutButton();
		}
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickSignInLink();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickCustomerEmailLoginTextBox();
		connect().INTLLoginPage().typeCustomerEmailSpain();
		connect().INTLLoginPage().clickCustomerPasswordSpainTextBox();
		connect().INTLLoginPage().typeCustomerPasswordSpain();
		connect().INTLLoginPage().clickLoginButton();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickActionShowCartButton();
		if (connect().INTLLoginPage().verifyRemoveItemButton()) {
			connect().INTLLoginPage().clickRemoveItemButton();
			connect().INTLLoginPage().clickAcceptButton();
		}
		Thread.sleep(10000);
		connect().INTLLoginPage().refreshPage();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		if (connect().INTLLoginPage().verifyCustomerMenuLink()) {
			connect().INTLLoginPage().clickLogoutButton();
		}
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickSearchTextBox();
		connect().INTLLoginPage().typeTheTextInSearchBox();
		connect().INTLLoginPage().clickSearchButton();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickSignInLink();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickCustomerEmailLoginTextBox();
		connect().INTLLoginPage().typeCustomerEmailSpain();
		connect().INTLLoginPage().clickCustomerPasswordSpainTextBox();
		connect().INTLLoginPage().typeCustomerPasswordSpain();
		connect().INTLLoginPage().clickLoginButton();
		Thread.sleep(10000);

		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickCookieCloseButton();
		connect().INTLLoginPage().clickActionPrimaryToCart();
		connect().INTLLoginPage().clickActionDigitalPrimaryToCartSpain();
		Thread.sleep(10000);
		connect().INTLLoginPage().clickAcceptAllButton();
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
		connect().INTLLoginPage().clickNIFDNITextBox();
		connect().INTLLoginPage().typeNIFDNIValue();
		connect().INTLLoginPage().verifyPayPalRadioButton();
		connect().INTLLoginPage().clickCreditCardRadioButton();
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
		connect().INTLLoginPage().clickAgreement1CheckBox();
		connect().INTLLoginPage().clickAgreement2CheckBox();
		connect().INTLLoginPage().clickPrimaryCheckoutButton();
		Thread.sleep(10000);

		connect().INTLLoginPage().clickOTPTextBox();
		connect().INTLLoginPage().typeOTPValue();
		connect().INTLLoginPage().clickSubmitButton();
		Thread.sleep(1000);
		connect().INTLLoginPage().switchToParentFrame();
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickContinueButton();
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickLogoutButton();
		driver.get("https://cti:mHEM2Pr3L1ve@spain.pre-prod.mhem2.ctidigital.com/blog");
		connect().INTLLoginPage().validateReadMoreButton();

	}
}