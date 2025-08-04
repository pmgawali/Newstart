package com.qa.opencart.tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.opencart.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {

	@BeforeClass
	public void productInfoSetup() {
		accPage = loginPage.doLogin(prop.getProperty("Username"), prop.getProperty("password"));
	}
	@DataProvider
	public Object[][] getProductTestData() {
		return new Object[][] {
			{"macbook", "MacBook Pro"},
			{"macbook", "MacBook Air"},
			{"imac", "iMac"},
			{"samsung", "Samsung SyncMaster 941BW"},
			{"samsung", "Samsung Galaxy Tab 10.1"}
		};
	}	
	@Test(dataProvider = "getProductTestData")

	public void productHeaderTest(String searchKey, String productName) {
		SearchResultsPage = accPage.doSearch(searchKey);
		productInfoPage = SearchResultsPage.selectProduct(productName);
		String actHeader = productInfoPage.getProductHeader();
		Assert.assertEquals(actHeader, productName);
	}

	@DataProvider
	public Object[][] getProductImagesTestData() {
		return new Object[][] {
			{"macbook", "MacBook Pro", 4},
			{"macbook", "MacBook Air", 4},
			{"imac", "iMac", 3},
			{"samsung", "Samsung SyncMaster 941BW", 1},
			{"samsung", "Samsung Galaxy Tab 10.1", 7}
		};
	}
	@Test
	public void productImagesCount() {
		SearchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = SearchResultsPage.selectProduct("MacBook Pro");
		int actImageCount = productInfoPage.getProductImagesCount();
		Assert.assertEquals(actImageCount, 4);
	}
	@Test
	public void productInfoTest(){
		SearchResultsPage = accPage.doSearch("MacBook");
		productInfoPage = SearchResultsPage.selectProduct("MacBook Pro");
		
		Map<String,String> actProductDetailsMap = productInfoPage.getProductDetailsMap();
		
		SoftAssert softassert = new SoftAssert();
		
		softassert.assertEquals(actProductDetailsMap.get("Brand"), "Apple");
		softassert.assertEquals(actProductDetailsMap.get("Product Code"), "Product 18");
		softassert.assertEquals(actProductDetailsMap.get("Reward Points"), "800");
		softassert.assertEquals(actProductDetailsMap.get("Availability"), "Out Of Stock");
		
		softassert.assertAll();
	}
}
