package com.qa.opencart.tests;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import static com.qa.opencart.constants.AppConstants.*;

public class AccountPageTest extends BaseTest {
	// BeforeTest-->BeforeClass

	// BT --> BC

	@BeforeClass
	public void accPageSetup() {
		accPage = loginPage.doLogin(prop.getProperty("Username"), prop.getProperty("password"));
	}

	@Test 
	public void accPageTitleTest() {
		Assert.assertEquals(accPage.getAccPageTitle(),HOME_PAGE_TITTLE);
	}
	@Test 
	public void accPageUrlTest() {
	Assert.assertTrue(accPage.getAccPageUrl().contains(HOME_PAGE_FRACTION_URL));
	}
	@Test 
	public void accPageHeadersTest() throws InterruptedException {
		Thread.sleep(DEFAULT_TIMEOUT);
		List<String> actHeaderList =accPage.getAccPageHeaders();
	Assert.assertEquals(actHeaderList,AppConstants.expectedAccPageHeadList);
	}
	
}
