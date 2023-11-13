package com.Mohs10.OR;

import org.openqa.selenium.By;

public class HomePage {


	//DemoQA Tools Website
	public static By elements = By.xpath("//div[@class='category-cards']//div[1]//div[1]//div[1]");
	public static By textbox = By.xpath("//div[@class='element-list collapse show']//li[@id='item-0']");
	public static By fullname = By.xpath("//input[@id='userName']");
	public static By email = By.xpath("//input[@id='userEmail']");
	public static By currentaddress = By.xpath("//textarea[@id='currentAddress']");
	public static By permanentaddress = By.xpath("//textarea[@id='permanentAddress']");
	public static By submit = By.xpath("//button[@id='submit']");
	
	//Mohs10 website
	public static By aboutus = By.xpath("//a[normalize-space()='About ']");

	//Categories
	public static By lnkComputer = By.xpath("//li[@class='inactive']//a[normalize-space()='Computers']");
	public static By lnkDigitaldownloads = By.xpath("//li[@class='inactive']//a[normalize-space()='Digital downloads']");
	public static By lnkElectronics = By.xpath("//li[@class='inactive']//a[normalize-space()='Electronics']");
	public static By lnkApparelandShoes = By.xpath("//li[@class='inactive']//a[normalize-space()='Apparel & Shoes']");
	public static By lnkJewelry = By.xpath("//li[@class='inactive']//a[normalize-space()='Jewelry']");
	public static By lnkBooks = By.xpath("//li[@class='inactive']//a[normalize-space()='Books']");
	public static By lnkGiftCards =By.xpath("//li[@class='inactive']//a[normalize-space()='Gift Cards']");

	//To Register
	public static By lnkRegister = By.xpath("//a[@href=\"/register\"]");
	public static By rbGender = By.id("gender-female");
	public static By txtFirstname = By.id("FirstName");
	public static By txtLastname = By.id("LastName");
	public static By txtEmail = By.id("Email");
	public static By txtPassword = By.id("Password");
	public static By txtConfirmpassword = By.id("ConfirmPassword");
	public static By btnRegister = By.id("register-button");
	public static By btnContinue = By.xpath("//input[@value='Continue']");

	//To login
	public static By lnkLogin = By.linkText("Log in");
	public static By txtemail = By.xpath("//input[@id='Email']");
	public static By txtpwd = By.xpath("//input[@id='Password']");
	public static By btnlogin = By.xpath("//input[@value='Log in']");
	public static By lnkLogout = By.xpath("//a[@class='ico-logout']");

	//Customer Service
	public static By btnNews = By.xpath("//a[@href=\"/news\"]");
	public static By btnBlog = By.xpath("//a[@href=\"/blog\"]");
	public static By btnComparelist = By.xpath("//a[@href=\"/compareproducts\"]");
	public static By btnRecentlyviewed = By.xpath("//a[@href=\"/recentlyviewedproducts\"]");

	//To subscribe
	public static By lnkYoutube = By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]");
	public static By btnSubscribe = By.xpath("//a[@href=\"http://www.youtube.com/user/nopCommerce\"]");

	//To goto sitemap
	public static By lnkSitemap = By.xpath("//a[normalize-space()='Sitemap']");
	public static By lnkSearch = By.xpath("//div[@class='entity-body']//a[normalize-space()='Search']");
	public static By txtSearchKeyword = By.xpath("//input[@id='Q']");
	public static By btnsearch = By.xpath("//input[@class='button-1 search-button']");

	//to goto shipping&returns
	public static By lnkShippingandReturns = By.xpath("//a[normalize-space()='Shipping & Returns']");
	public static By lnkShpng = By.xpath("//h1[normalize-space()='Shipping & Returns']");

	//Goto Contactus
	public static By lnkContactUs = By.xpath("//a[normalize-space()='Contact us']");
	public static By txtName = By.xpath("//input[@id='FullName']");
	public static By txtEmaill = By.xpath("//input[@id='Email']");
	public static By txtEnquiry = By.xpath("//textarea[@id='Enquiry']");
	public static By btnSubmit = By.xpath("//input[@name='send-email']");
	public static By txtcontactus = By.xpath("//div[@class='result']");

	//goto new products
	public static By lnkNewProducts = By.xpath("//a[normalize-space()='New products']");
	public static By txtphCvr = By.xpath("//h1[@itemprop='name']");

	//go to shpng cart
	public static By lnkShoppingCart = By.xpath("//span[normalize-space()='Shopping cart']");
	public static By txtemptyshpngcart = By.xpath("//div[@class='order-summary-content']");

	//-------login and order--------
	public static By lnkApparelAndShoes = By.xpath("//a[@href=\"/apparel-shoes\"]");
	public static By frokitem = By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[1]/a/img");
	public static By btnAddtoCart = By.xpath("//input[@id='add-to-cart-button-5']");
	public static By acceptterms = By.xpath("//input[@id='termsofservice']");
	public static By btnCheckout = By.xpath("//button[@id='checkout']");
	public static By selectcountry = By.xpath("select[@id='BillingNewAddress_CountryId']");
	public static By selectstate = By.xpath("//select[@id='BillingNewAddress_StateProvinceId']");
	public static By cityname = By.xpath("//input[@id='BillingNewAddress_City']");
	public static By address1 = By.xpath("//input[@id='BillingNewAddress_Address1']");
	public static By zipcode = By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']");
	public static By phonenumber = By.xpath("//input[@id='BillingNewAddress_PhoneNumber']");
	public static By btnCntnue1 = By.xpath("//input[@onclick='Billing.save()']");
	//public static By  = By.xpath("");

	public static By btnBillingContinue = By.xpath("//input[@onclick='Billing.save()']");
	public static By btnShippingContinue = By.xpath("//input[@onclick='Shipping.save()']");
	public static By btnShpngMthdContinue = By.xpath("//input[@class='button-1 shipping-method-next-step-button']");
	public static By btnPaymentMthdContinue = By.xpath("//input[@class='button-1 payment-method-next-step-button']");
	public static By btnPaymentInfoContinue = By.xpath("//input[@class='button-1 payment-info-next-step-button']");
	public static By Confirmorder = By.xpath("//input[@value='Confirm']");

	//public static By lnkOrderDetails = By.xpath("//a[normalize-space()='Click here for order details.']");
	public static By ordercomplete = By.xpath("//strong[normalize-space()='Your order has been successfully processed!']");
}



