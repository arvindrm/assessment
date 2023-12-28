package com.qa.HFT.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.AppErrors;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic(" Design Login page for HARBORFREIGHT TOOLS application")
@Story(" Create login page functionality for HARBORFREIGHT TOOLS login page")
public class LoginPageTest extends BaseTest {

	
	
	@Description("login page title test")
	@Severity(SeverityLevel.TRIVIAL)
	@Test()
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		System.out.println("login page title 1: " + actTitle);
		Assert.assertTrue(actTitle.contains(AppConstants.LOGIN_PAGE_TITLE), AppErrors.NO_TITLE_MATCHED);
	}

	@Description("login page url test")
	@Severity(SeverityLevel.NORMAL)
	@Test()
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageUrl();
		System.out.println("login page url1 : " + actURL);
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
	}

	@Description("forgot password link on login page test")
	@Severity(SeverityLevel.CRITICAL)
	@Test()
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isforgotPWdLinkExist());
	}

	@Description("user is able to login on login page test")
	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(accPage.isLogoutExist(), AppErrors.LOGIN_UNSUCCESSFUL);
	}

}
