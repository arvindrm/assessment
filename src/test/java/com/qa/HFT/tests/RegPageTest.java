package com.qa.HFT.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.pages.RegPage;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.ExcelUtil;

public class RegPageTest extends  BaseTest{
	
	@BeforeClass
	public void regPageSetup() {
		regPage = loginPage.navigateToRegisterPage();
	}

	public String getRandomEmail() {
		Random random = new Random();
		String email = "HFTautomationD" + random.nextInt(5000) + "@mailinator.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegTestData")
	public void registerUserTest(String firstName, String lastName, String telephone, String password) {

		boolean flag = regPage.registerUser(firstName, lastName, getRandomEmail(), telephone, password);

		Assert.assertTrue(flag);
	}


}
