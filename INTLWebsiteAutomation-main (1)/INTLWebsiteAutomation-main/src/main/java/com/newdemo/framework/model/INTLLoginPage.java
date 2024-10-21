package com.newdemo.framework.model;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class INTLLoginPage {
	
	//COmmenting this as new heclr changes cam in
	/*@FindBy(xpath="//input[@name='userName']") public WebElement userName;
	@FindBy(xpath="//input[@name='password']") public WebElement password;
	@FindBy(xpath="//*[@type='submit']") public WebElement signIn;*/
	@FindBy(xpath="//button[@id='onetrust-accept-btn-handler']") public WebElement acceptAll;
	@FindBy(xpath="//a[@role='button']//span[@class='text']") public WebElement myCartRole;
	@FindBy(xpath="//a[@role='button' and @class='location-bar-close']") public WebElement closeButtonRole;
	@FindBy(xpath="//nav[@aria-label='main menu' and @class='support js-mhe-responsive-nav']") public WebElement ariaLabel;
	@FindBy(xpath="//a[@role='link' and @class='support__link']") public WebElement blogRole;
	@FindBy(xpath="//a[@aria-labelledby='40191']//span[@id='40191']") public WebElement ariaLabelledById;
	@FindBy(xpath="//a[@class='action delete']") public WebElement removeItemButton;
	@FindBy(xpath="//button[@class='action-primary action-accept']") public WebElement acceptButton;
	@FindBy(xpath="//button[@class='action close']") public WebElement closeButton;
	@FindBy(xpath="//input[@id='search']") public WebElement searchTextBox;
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") public WebElement amazonSearchTextBox;
	@FindBy(xpath="//input[@id='sp-cc-accept']") public WebElement amazonAcceptCookiesButton;
	@FindBy(xpath="//input[@id='code']") public WebElement codeTextBox;
	@FindBy(xpath="//li[@class='support__item']") public WebElement blogLink;
	@FindBy(xpath="//a[@class='amblog-read']") public WebElement readMoreButton;
	@FindBy(xpath="//form[@id='search_mini_form']//button[@class='action search']") public WebElement searchButton;
	@FindBy(xpath="//input[@id='nav-search-submit-button']") public WebElement amazonSearchButton;
	@FindBy(xpath="(//img[@class='s-image'])[1]") public WebElement selectImage;
	@FindBy(xpath="//span[@id='marketo-request-review-access-heading']") public WebElement marketoButton;
	@FindBy(xpath="//button[@class='mktoButton']") public WebElement mktoSubmitButton;
	//@FindBy(xpath="//a[@title='ISE EBook for Business Communication' and @class='action more']") public WebElement learnMoreLink;
	@FindBy(xpath="//button[@id='btn-cookie-message-close']") public WebElement cookieCloseButton;
	@FindBy(xpath="//span[@class='product-isbn__13']") public WebElement productISBN13;
	@FindBy(xpath="//span[@class='product-isbn__10']") public WebElement productISBN10;
	@FindBy(xpath="(//div//strong[@class='product name product-item-name'])[2]//a")public WebElement validateSecondLink;
	@FindBy(xpath="//div[@class='product-published-date']") public WebElement releaseDate;
	@FindBy(xpath="//span[@class='price']") public WebElement priceAtWebsite;
	@FindBy(xpath="//img[contains(@src,'media') and contains(@class,'fotorama__img')]") public WebElement productImage;
	@FindBy(xpath="//span[@class='price']") public WebElement priceList;
	@FindBy(xpath="//div[@class='isbn-info']") public WebElement isbnList;
	@FindBy(xpath="(//div[@class='isbn-info'])[5]") public WebElement isbnList5;
	@FindBy(xpath="(//div[@class='isbn-info'])[4]") public WebElement isbnList4;
	@FindBy(xpath="(//div[@class='isbn-info'])[3]") public WebElement isbnList3;
	@FindBy(xpath="(//div[@class='isbn-info'])[2]") public WebElement isbnList2;
	@FindBy(xpath="(//span[@class='price'])[5]") public WebElement priceList5;
	@FindBy(xpath="(//span[@class='price'])[2]") public WebElement priceList2;
	@FindBy(xpath="(//span[@class='price'])[3]") public WebElement priceList3;
	@FindBy(xpath="(//span[@class='price'])[4]") public WebElement priceList4;
	@FindBy(xpath="//button[@id='product-addtocart-button']") public WebElement addToCartButton;
	@FindBy(xpath="//button[@class='button action continue primary']") public WebElement guestCheckOutButton;
	@FindBy(xpath="//div[@id='shipping-method-buttons-container']//button[@class='button action continue primary']") public WebElement reviewAndPaymentsButton;
	@FindBy(xpath="//input[@id='customer-email']") public WebElement customerEmail;
	@FindBy(xpath="//input[@id='confirm-customer-email']") public WebElement confirmCustomerEmail;
	@FindBy(xpath="//input[@id='taxForm-checkbox']") public WebElement taxFormCheckBox;
	
	@FindBy(xpath="//div[@name='taxForm.invoice_tax_id']//input") public WebElement taxIDTextBox;
	@FindBy(xpath="//div[@name='taxForm.invoice_name']//input") public WebElement taxNameTextBox;
	@FindBy(xpath="//div[@name='taxForm.invoice_postal_code']//input") public WebElement invoicePostalCodeTextBox;
	@FindBy(xpath="//div[@name='taxForm.invoice_regime']") public WebElement invoiceRegimeDropDown;
	@FindBy(xpath="//option[@value='622']") public WebElement invoiceRegimeValue;
	@FindBy(xpath="//div[@name='taxForm.invoice_use_of_cfdi']") public WebElement invoiceUseOfCfdiDropDown;
	@FindBy(xpath="//option[@value='G01']") public WebElement invoiceUseOfCfdiValue;
	@FindBy(xpath="//input[@name='Número de Identificación']") public WebElement numeroDeIdentification;
	@FindBy(xpath="//select[@name='Tipo de persona']") public WebElement tipoDePersonaDropDown;
	@FindBy(xpath="//select[@name='Tipo de persona']//option[@value='5463']") public WebElement tipoDePersonaValue;
	@FindBy(xpath="//select[@name='Tipo de identificación']") public WebElement tipoDeIdentificationDropDown;
	@FindBy(xpath="//select[@name='Tipo de identificación']//option[@value='5466']") public WebElement tipoDeIdentificationValue;
	@FindBy(xpath="//select[@name='Régimen']") public WebElement regimenDropDown;
	@FindBy(xpath="//select[@name='Régimen']//option[@value='5473']") public WebElement regimenValue;
	
	
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.firstname']//input") public WebElement billingAddressFirstName;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.lastname']//input") public WebElement billingAddressSurName;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.street.0']//input") public WebElement billingAddressStreet;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.city']//input") public WebElement billingAddressCity;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.region_id']") public WebElement billingAddressRegionId;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.region_id']//option[@value='578']") public WebElement billingAddressRegionIdValue;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.region_id']//option[@value='654']") public WebElement billingAddressRegionIdValueCol;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.postcode']//input") public WebElement billingAddressPostCode;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.country_id']") public WebElement billingAddressCountryId;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.country_id']//option[@value='MX']") public WebElement billingAddressCountryIdValue;
	@FindBy(xpath="//div[@name='billingAddresspayu_latam.telephone']//input") public WebElement billingAddressTelephone;
	@FindBy(xpath="//input[@id='braintree']") public WebElement creditCardRadioButton;
	@FindBy(xpath="//input[@id='braintree_googlepay']") public WebElement googlePayButton;
	@FindBy(xpath="//input[@id='braintree_paypal']") public WebElement payPalButton;
	@FindBy(xpath="//div[@name='billingAddressbraintree.firstname']//input") public WebElement billingAddressBrainTreeFirstName;
	@FindBy(xpath="//div[@name='billingAddressbraintree.lastname']//input") public WebElement billingAddressBrainTreeSurName;
	@FindBy(xpath="//div[@name='billingAddressbraintree.street.0']//input") public WebElement billingAddressBrainTreeStreet;
	@FindBy(xpath="//div[@name='billingAddressbraintree.city']//input") public WebElement billingAddressBrainTreeCity;
	@FindBy(xpath="//div[@name='billingAddressbraintree.region_id']") public WebElement billingAddressBrainTreeRegionId;
	@FindBy(xpath="//div[@name='billingAddressbraintree.region_id']//option[@value='578']") public WebElement billingAddressBrainTreeRegionIdValue;
	@FindBy(xpath="//div[@name='billingAddressbraintree.postcode']//input") public WebElement billingAddressBrainTreePostCode;
	@FindBy(xpath="//div[@name='billingAddressbraintree.country_id']") public WebElement billingAddressBrainTreeCountryId;
	@FindBy(xpath="//div[@name='billingAddressbraintree.country_id']//option[@value='MX']") public WebElement billingAddressBrainTreeCountryIdValue;
	@FindBy(xpath="//div[@name='billingAddressbraintree.telephone']//input") public WebElement billingAddressBrainTreeTelephone;
	@FindBy(xpath="//div[@name='billingAddressbraintree.region_id']//option[@value='132']") public WebElement billingAddressBrainTreeRegionIdValueSpain;
	
	@FindBy(xpath="//div[@name='shippingAddress.firstname']//input") public WebElement shippingAddressFirstName;
	@FindBy(xpath="//div[@name='shippingAddress.lastname']//input") public WebElement shippingAddressSurName;
	@FindBy(xpath="//div[@name='shippingAddress.street.0']//input") public WebElement shippingAddressStreet;
	@FindBy(xpath="//input[@name='street[1]']") public WebElement shippingAddressLine2Street;
	@FindBy(xpath="//div[@name='shippingAddress.city']//input") public WebElement shippingAddressCity;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']") public WebElement shippingAddressRegionId;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='586']") public WebElement shippingAddressRegionIdValue;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='66']") public WebElement shippingAddressRegionIdValueCanada;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='570']") public WebElement shippingAddressRegionIdValueAustralia;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='33']") public WebElement shippingAddressRegionIdValueProfessional;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='654']") public WebElement shippingAddressRegionIdValueCol;
	@FindBy(xpath="//div[@name='shippingAddress.region_id']//option[@value='132']") public WebElement shippingAddressRegionIdValueSpain;
	
	@FindBy(xpath="//div[@name='shippingAddress.postcode']//input") public WebElement shippingAddressPostCode;
	@FindBy(xpath="//div[@name='shippingAddress.country_id']") public WebElement shippingAddressCountryId;
	@FindBy(xpath="//div[@name='shippingAddress.country_id']//option[@value='MX']") public WebElement shippingAddressCountryIdValue;
	@FindBy(xpath="//div[@name='shippingAddress.telephone']//input") public WebElement shippingAddressTelephone;
	
	@FindBy(xpath="(//input[@name='firstname'])[2]") public WebElement shippingAddressFirstNameAUS;
	@FindBy(xpath="(//input[@name='lastname'])[2]") public WebElement shippingAddressSurNameAUS;
	@FindBy(xpath="(//input[@name='street[0]'])[2]") public WebElement shippingAddressStreetAUS;
	@FindBy(xpath="(//input[@name='city'])[2]") public WebElement shippingAddressCityAUS;
	@FindBy(xpath="(//select[@name='region_id'])[2]") public WebElement shippingAddressRegionIdAUS;
	@FindBy(xpath="(//select[@name='region_id'])[2]//option[@value='570']") public WebElement shippingAddressRegionIdValueAUS;
	@FindBy(xpath="(//input[@name='postcode'])[2]") public WebElement shippingAddressPostCodeAUS;
	@FindBy(xpath="(//input[@name='telephone'])[2]") public WebElement shippingAddressTelephoneAUS;
	@FindBy(xpath="//input[@name='NIF/DNI']") public WebElement NIFDNI;
	@FindBy(xpath="//input[@id='agreement_braintree_1']") public WebElement agreementBraintree1;
	@FindBy(xpath="//input[@id='agreement_braintree_2']") public WebElement agreementBraintree2;
	@FindBy(xpath="//input[@name='deviceRegister']") public WebElement deviceRegisterCheckBox;
	@FindBy(xpath="//input[@id='tandc']") public WebElement tandcCheckBox;
	
	@FindBy(xpath="//button[@class='action action-update']") public WebElement actionUpdate;
	@FindBy(xpath="(//button[@class='action primary checkout'])[1]") public WebElement primaryCheckoutButton;
	@FindBy(xpath="(//div[@class='message message-error error'])[1]") public WebElement errorMessage;
	@FindBy(xpath="//a[@class='action primary tocart']") public WebElement actionPrimaryToCart;
	//@FindBy(xpath="(//button[@class='action primary tocart'])[2]") public WebElement actionPrintPrimaryToCart;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-798542']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartLATAM;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2791247']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartCol;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2867750']/..//button[@class='action primary tocart']") public WebElement actionDigitalPrimaryToCartCol;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2791847']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartCol_Prod;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2867780']/..//button[@class='action primary tocart']") public WebElement actionDigitalPrimaryToCartCol_Prod;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-1637166']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartEMEA;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-1637166']/..//button[@class='action primary tocart']") public WebElement actionPrintToCartEMEA;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-5777']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartCanada;
	//@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-606093']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartASIA;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-1507322']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartASIA;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-1093416']/..//button[@class='action primary tocart']") public WebElement actionDigitalPrimaryToCartSpain;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-1093415']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartSpain;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2977265']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartPhysicalCheckOutCanada;
	@FindBy(xpath="//div[@class='purchase-option mhe-pb-card mhe-pb-card--highlight']/h5[@id='option-title-2981253']/..//button[@class='action primary tocart']") public WebElement actionPrintPrimaryToCartPhysicalCheckOutCanada_Prod;
	@FindBy(xpath="//div[@class='message-text']/a") public WebElement shoppingCartLink;
	@FindBy(xpath="//tr//input") public WebElement selectShippingMethod;
	@FindBy(xpath="//ul[@class='checkout methods items checkout-methods-items']//button[@class='action primary checkout']") public WebElement actionPrimaryCheckoutButton;
	@FindBy(xpath="//button[@id='top-cart-btn-checkout']") public WebElement proceedToCheckout;
	@FindBy(xpath="//li[@class='minicart-container']") public WebElement actionShowCart;
	@FindBy(xpath="//button[@class='payment-method-button payment-method-button-card ico_pm_VISA']") public WebElement visaPaymentMethod;
	@FindBy(xpath="//input[@id='cc_fullName']") public WebElement ccFullName;
	@FindBy(xpath="//input[@id='ccNumber']") public WebElement ccNumber;
	@FindBy(xpath="//select[@id='select-banks-promos']") public WebElement selectBankDropDown;
	@FindBy(xpath="//input[@id='cc_dniNumber']") public WebElement ccDniNumber;
	@FindBy(xpath="//input[@id='credit-card-number']") public WebElement creditCardNumber;
	@FindBy(xpath="//input[@id='expiration']") public WebElement expirationMonthYear;
	@FindBy(xpath="//select[@id='expirationDateMonth']") public WebElement expirationDateMonth;
	@FindBy(xpath="//select[@id='expirationDateMonth']//option[@value='9']") public WebElement expirationDateMonthValue;
	@FindBy(xpath="//select[@id='expirationDateYear']") public WebElement expirationYear;
	@FindBy(xpath="//select[@id='expirationDateYear']//option[@value='30']") public WebElement expirationYearValue;
	@FindBy(xpath="//input[@id='securityCode']") public WebElement securityCode;
	@FindBy(xpath="//input[@id='securityCodeAux_']") public WebElement securityCodeCol;
	@FindBy(xpath="//input[@id='cvv']") public WebElement cvv;
	@FindBy(xpath="//input[@id='contactPhone']") public WebElement contactPhone;
	@FindBy(xpath="//button[@id='buyer_data_button_pay']") public WebElement payButton;
	@FindBy(xpath="//a[@id='response_button_continue']") public WebElement responseButtonContinue;
	@FindBy(xpath="//a[@class='action continue']") public WebElement continueButton;
	@FindBy(xpath="//input[@id='customer-email-login']") public WebElement customerEmailLogin;
	@FindBy(xpath="//input[@id='customer-password']") public WebElement customerPassword;
	@FindBy(xpath="//button[@class='action login primary']") public WebElement loginButton;
	@FindBy(xpath="//li[@class='link authorization-link']") public WebElement signInLink;
	@FindBy(xpath="//input[@id='email']") public WebElement customerEmailSpain;
	@FindBy(xpath="//input[@id='pass']") public WebElement customerPasswordSpain;
	@FindBy(xpath="//a[@class='customer-menu__link']") public WebElement customerMenuLink;
	@FindBy(xpath="//ul[@class='customer-menu__inner-list']//li[@class='link authorization-link']") public WebElement logoutButton;
	@FindBy(xpath="//a[@class='action primary tocart']") public WebElement purchaseOptionsButton;
	@FindBy(xpath="//input[@class='input-field']") public WebElement otpValue;
	@FindBy(xpath="//input[@class='button primary']") public WebElement submitButton;
	@FindBy(xpath="//button[@class='submit code button-base button-shout']") public WebElement submitCodeButton;
	
	@FindBy(xpath="//*[@id='mainCourseContainer']") public WebElement home_courseContainer;
	@FindBy(id="//span[@class='icon-home']") public WebElement homeIcon;
	@FindBy(xpath="//a[text() = 'OK']") public WebElement updatesNnoticesOKbutton;
	@FindBy(xpath="//*[@class='innerButton']/a") public WebElement updatesNnoticesNewOKbutton;
	@FindBy(xpath="//a[contains(text(),'Sign out')]") public WebElement signOutButton;
	public By stdusername = By.id("username");	
	//New HECLR changes for login page were made on 01-DEC-2021
	@FindBy(id="login-email") public WebElement userName;
	@FindBy(name="password") public WebElement password;
	@FindBy(id="login-submit-btn") public WebElement signIn;
	@FindBy(xpath="//u[normalize-space()='Remind me later']") public WebElement RemindMelater;
	
	public String waitExpression()
	{
		return "Accept All";
	}
}