package com.qa.opencart.tests;

//import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.qa.opencart.constants.AppConstants.*;
import com.qa.opencart.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
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
