package com.qa.HFT.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.HFT.base.BaseTest;
import com.qa.HFT.utils.AppConstants;
import com.qa.HFT.utils.AppErrors;

import io.qameta.allure.Epic;
import io.qameta.allure.Story;

@Epic(" Design Accounts page for HARBORFREIGHT TOOLS application")
@Story(" Testing Account page functionality for HARBORFREIGHT TOOLS Accounts page")
public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void accPageTitleTest() {
		String actTitle = accPage.getAccPageTitle();
		System.out.println("AccountPageTest --- Acc page title : " + actTitle);
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}

	@Test
	public void accPageURLTest() {
		String actURL = accPage.getAccPageURL();
		System.out.println("AccountPageTest --- Acc page url : " + actURL);
		Assert.assertTrue(actURL.contains(AppConstants.ACC_PAGE_FRACTION_URL), AppErrors.NO_URL_MATCHED);
	}

	@Test
	public void searchExistTest() {
		Assert.assertTrue(accPage.isSearchExist());
	}

	@Test
	public void logoutExistTest() {
		Assert.assertTrue(accPage.isLogoutExist());
	}
	
	@Test
	public void accPageHeaderTest() {
		String actHeader = accPage.getAccPageHeader();
		System.out.println("AccountPage Header : " + actHeader);
		Assert.assertTrue(actHeader.contains(AppConstants.ACC_PAGE_HEADER),AppErrors.NO_URL_MATCHED);
	}

	@Test
	public void accPageHeadersTest() {
		List<String> actHeadersList = accPage.getAccountsPageSectionsHeaders();
		Assert.assertEquals(actHeadersList, AppConstants.EXPECTED_ACC_HEADERS_LIST);
	}

	@DataProvider
	 public Object[][] getProductName() { 
		  return new Object[][] {
		  {"amazon.com", "Sorry, No Items Were Found."},
		  {"lowes.com","Sorry, No Items Were Found."},
		  {"harborfreight.com" , "Sorry, No Items Were Found."},
		  {"Air co.presdor", "Sorry, No Items Were Found."},
		  {"Online apotheek", "Sorry, No Items Found For \"Online Apotheek\""},
		  {"&", "Sorry, No Items Found For \"&\""}
	
			};
		  
	  }
	 
	

	
	
	}
	
	

	
	
	
	
	
	

