package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

public class SearchTest extends BaseTest {

	@BeforeClass
	public void searchSetup() {
		accPage = loginPage.doLogin(prop.getProperty("Username"), prop.getProperty("password"));
	}

	@Test
	public void searchTest() { 
		SearchResultsPage= 	accPage.doSearch("macbook");
		int actResultProuctCount =SearchResultsPage.getResultsProductCount();
		Assert.assertEquals(actResultProuctCount,3);
	}
}
