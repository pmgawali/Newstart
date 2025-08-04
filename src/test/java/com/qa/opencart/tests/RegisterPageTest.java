package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtils;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	@DataProvider
	public Object getUserRegistrationData() {
		return new Object[][] { { "vishu", "jauav","9823456598", "vis5l@123", "yes" },
				{ "eknath", "bivar","9823456711", "emb@123", "no" },
				{ "raghu", "kent","9823456712", "raghu@123", "yes" } };

	}
	@DataProvider
	public Object[][] getUserData() {
		Object regData[][] = ExcelUtils.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getUserData")
	public void userRegisterTest(String firstName, String lastName,String telephone, String password, String subscribe) {
		Assert.assertTrue(registerPage.userRegisteration(firstName,lastName,telephone,password,subscribe));
	}
	
}
