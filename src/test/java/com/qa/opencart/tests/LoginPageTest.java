package com.qa.opencart.tests;

import static com.qa.opencart.constants.AppConstants.HOME_PAGE_TITTLE;
import static com.qa.opencart.constants.AppConstants.LOGIN_PAGE_FRACTION_URL;
import static com.qa.opencart.constants.AppConstants.LOGIN_PAGE_TITTLE;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Feature("F:50")
@Epic("Epic 100:design Login page for open cart app")
@Story("US:100")
public class LoginPageTest extends BaseTest {

	@Description("Checking Login page tittle....")
	@Severity(SeverityLevel.MINOR)
	@Test(description="Checking Login page tittle")
	public void loginPageTittleTest() {
		String actTittle = loginPage.getLoginPageTittle();
		System.out.println(actTittle);
		Assert.assertEquals(actTittle,LOGIN_PAGE_TITTLE);
	}

	@Test
	public void loginPageUrlTest() {
		String actURL = loginPage.getloginPageUrl();
		System.out.println(actURL);
		Assert.assertTrue(actURL.contains(LOGIN_PAGE_FRACTION_URL));
	}
	@Test
	public void forgetPwdLinkExistTest() {
		//boolean fPwdLink = loginPage.isForPwdExist();
		Assert.assertTrue(loginPage.isForPwdExist());
	}
	
	@Test(priority = Short.MAX_VALUE, description = "login with valid credentials")
	public void doLoginTest() {
		accPage = loginPage.doLogin(prop.getProperty("Username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), HOME_PAGE_TITTLE);
	
	}
	
	
	
}
