package com.qa.opencart.tests;

import static com.qa.opencart.constants.AppConstants.HOME_PAGE_FRACTION_URL;
import static com.qa.opencart.constants.AppConstants.HOME_PAGE_TITTLE ;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;


public class AccountPageTest extends BaseTest{
	
	
	//BT --> BC
	
	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("Username"), prop.getProperty("password"));
		
	}
	
	@Test
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(),AppConstants.HOME_PAGE_TITTLE) ;
	}
	
	@Test
	public void accPageURLTest() {
		Assert.assertTrue(accPage.getAccPageUrl().contains(HOME_PAGE_FRACTION_URL));
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actHeaderList = accPage.getAccPageHeaders();
		Assert.assertEquals(actHeaderList, AppConstants.expectedAccPageHeadList);
	}
	
	
	

}
