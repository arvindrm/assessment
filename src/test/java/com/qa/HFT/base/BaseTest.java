package com.qa.HFT.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.HFT.factory.DriverFactory;
import com.qa.HFT.pages.AccountsPage;
import com.qa.HFT.pages.LoginPage;
import com.qa.HFT.pages.RegPage;


public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	//protected ResultsPage resultsPage;
	//protected ProductInfoPage prodInfoPage;
	//protected MyCartPage myCartPage;
	//protected CheckOutPage checkOutPage;
	protected RegPage regPage;
	//protected HomePage homePage;
	//protected ITCDedicatedPurchase ITCDedPage;
	//protected DigitalGiftCards giftcards;
	
	protected SoftAssert softAssert;
	
	protected Properties prop;
	protected DriverFactory dfactory;
	
	
	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
		
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		//ITCDedPage = new ITCDedicatedPurchase(driver);
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
