package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;
import com.qa.HFT.pages.RegPage;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators:
	private By popup = By.xpath("//div[contains(@class,'dy-lb-close')]");
	private By emailId = By.id("login-email");
	private By password = By.id("login-password");
	private By loginBtn = By.xpath("//div[contains(@class,'button')]/button");
	private By forgotPwdLink = By.xpath("//button[contains(@class,'link')]");
	private By registernow = By.linkText("Register Now");
	private By hftlogo = By.xpath("//img[contains(@class,'cms-logo-image')]");

	// 2. page constructor:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. page actions:
	@Step("getting login page title...")
	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_TIME_OUT);
	}

	@Step("get Login Page Url")
	public String getLoginPageUrl() {
		return eleUtil.waitForUrlContains(AppConstants.LOGIN_PAGE_FRACTION_URL, TimeUtil.DEFAULT_TIME_OUT);
	}

	@Step("checking forgot pwd link exist")
	public boolean isforgotPWdLinkExist() {
		return eleUtil.doIsDisplayed(forgotPwdLink);
	}

	public boolean popupExist() {
		return eleUtil.waitForElementVisible(popup, TimeUtil.DEFAULT_TIME_OUT).isDisplayed();
	}

	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String pwd) {
		eleUtil.waitForElementVisible(emailId, TimeUtil.DEFAULT_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);

		return new AccountsPage(driver);
	}
	
	@Step("navigating to register page")
	public RegPage navigateToRegisterPage() {
		// eleUtil.waitForElementVisible(popup,TimeUtil.DEFAULT_TIME_OUT).click();
		eleUtil.doClick(registernow);
		return new RegPage(driver);
	}
	
	
}
