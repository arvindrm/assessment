package com.qa.HFT.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.HFT.utils.ElementUtil;
import com.qa.HFT.utils.TimeUtil;
import com.qa.HFT.utils.AppConstants;

public class RegPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators:
	private By createAcctlbl = By.xpath("//div[contains(@class,'myaccount-register')]/h2");
	private By firstName = By.id("register-firstname");
	private By lastName = By.id("register-lastname");
	private By email = By.id("register-email");
	private By itcmemberpopup = By.xpath("//div[contains(@class,'explainer')]/div[2]");
	private By password = By.id("register-password");
	private By confirmpassword = By.id("register-confirmation");
	private By telephone = By.id("register-telephone");
	private By createAcctButton = By.xpath("//div[contains(@class,'myaccount-register')]/form/button");

	private By registerSuccessMesg = By.xpath("//div[contains(@class,'orders')]/h3");
	private By logoutLink = By.linkText("Logout");

	public RegPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public boolean registerUser(String firstName, String lastName, String email, String telephone, String password) {
		eleUtil.waitForElementVisible(this.firstName, TimeUtil.DEFAULT_TIME_OUT).sendKeys(firstName);
		eleUtil.doSendKeys(this.lastName, lastName);
		eleUtil.doSendKeys(this.email, email);
		eleUtil.doSendKeys(this.password, password);
		eleUtil.doSendKeys(this.confirmpassword, password);
		eleUtil.doActionsSendKeys(this.telephone,telephone);
		eleUtil.doClick(createAcctButton);

		//System.out.println("Landed on Accounts page after registration");

		String successMesg = eleUtil.waitForElementVisible(registerSuccessMesg, TimeUtil.DEFAULT_TIME_OUT).getText();
		System.out.println(successMesg);

		if (successMesg.contains(AppConstants.ACCOUNT_REGISTER_SUCCESS_MESSG)) {
			// eleUtil.doClick(logoutLink);
			// eleUtil.doClick(registerLink);
			return true;
		}
		// else { eleUtil.doClick(registerLink);
		// }

		return false;
	}

}
