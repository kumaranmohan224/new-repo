package com.newdemo.test.EZTPart1;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.newdemo.framework.base.ScriptBase;

import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class ColDigitalCheckOut_Prod extends ScriptBase {
	@Parameters({ "ParameterNValue", "env" })
	@Test(description = "Launching LATAM URL", priority = 1, enabled = true)
	public void IntructorArea(String ParameterNValue, String env) throws Exception {
		try {
			ATUReports.indexPageDescription = "Connect application automation - Create Assignments and Instructor Area scenarios";
			ATUReports.setAuthorInfo("Kumaran M", Utils.getCurrentTime(), "2.2");
			String strDescription = "Launch the Colombia URL in browser for ColDigitalCheckOut_Prod";
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
		connect().INTLLoginPage().clickActionPrimaryToCart();
		connect().INTLLoginPage().clickActionDigitalPrimaryToCartCol_Prod();

		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickGuestCheckOutButton();
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickEmailAddressTextBox();
		connect().INTLLoginPage().typeEmailAddress();
		connect().INTLLoginPage().clickConfirmEmailAddressTextBox();
		connect().INTLLoginPage().typeConfirmEmailAddress();
		connect().INTLLoginPage().clickNumeroDeIdentificationTextBox();
		connect().INTLLoginPage().typeNumeroDeIdentificationValue();
		connect().INTLLoginPage().selectTipoDePersonaDropDown();
		connect().INTLLoginPage().selectTipoDePersonaDropDownValue();
		connect().INTLLoginPage().selectTipoDeIdentificationDropDown();
		connect().INTLLoginPage().selectTipoDeIdentificationValue();
		connect().INTLLoginPage().selectRegimenDropDown();
		connect().INTLLoginPage().selectRegimenValue();
		connect().INTLLoginPage().clickBillingAddressFirstNameTextBox();
		connect().INTLLoginPage().typeBillingAddressFirstName();
		connect().INTLLoginPage().clickBillingAddressSurNameTextBox();
		connect().INTLLoginPage().typeBillingAddressSurName();
		connect().INTLLoginPage().clickBillingAddressStreetTextBox();
		connect().INTLLoginPage().typeBillingAddressStreet();
		connect().INTLLoginPage().clickBillingAddressCityTextBox();
		connect().INTLLoginPage().typeBillingAddressCity();
		connect().INTLLoginPage().clickBillingAddressRegionIdDropDown();
		connect().INTLLoginPage().selectBillingAddressRegionIdValueCol();
		connect().INTLLoginPage().clickBillingAddressPostCodeTextBox();
		connect().INTLLoginPage().typeBillingAddressPostCode();

		connect().INTLLoginPage().clickBillingAddressTelephoneTextBox();
		connect().INTLLoginPage().typeBillingAddressTelephone();

		connect().INTLLoginPage().clickActionUpdateButton();
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
		Thread.sleep(10000);

		connect().INTLLoginPage().clickPrimaryCheckoutButton();
		connect().INTLLoginPage().clickVisaPaymentMethodButton();
		connect().INTLLoginPage().clickCCFullNameTextBox();
		connect().INTLLoginPage().typeCCFullName();
		connect().INTLLoginPage().clickCCDniNumberTextBox();
		connect().INTLLoginPage().typeCCDniNumber();
		connect().INTLLoginPage().clickCCNumberTextBox();
		connect().INTLLoginPage().typeCCNumber();
		connect().INTLLoginPage().clickExpirationDateMonthDropDown();
		connect().INTLLoginPage().selectExpirationDateMonthValue();
		connect().INTLLoginPage().clickExpirationYearDropDown();
		connect().INTLLoginPage().selectExpirationYearValue();
		connect().INTLLoginPage().clickSecurityCodeTextBoxCol();
		connect().INTLLoginPage().typeSecurityCodeCol();
		connect().INTLLoginPage().clickContactPhoneTextBox();
		connect().INTLLoginPage().typeContactPhone();
		connect().INTLLoginPage().clickDeviceRegisterCheckBox();
		connect().INTLLoginPage().clickTandcCheckBox();
		connect().INTLLoginPage().clickPayButton();
		connect().INTLLoginPage().clickResponseButtonContinue();
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickContinueButton();
		connect().INTLLoginPage().clickAcceptAllButton();
		connect().INTLLoginPage().clickLogoutButton();

	}
}