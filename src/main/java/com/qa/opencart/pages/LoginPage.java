package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.opencart.constants.AppConstants.*;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1. private By locators: 
	private final By email = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@value='Login']");
	private final By forgotPwdLink = By.linkText("Forgotten Password");
	private final By registerLink = By.linkText("Register");

	// 2.public page Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3.public page action/methods
	public String getLoginPageTittle() {
		String title = eleUtil.waitForTitleIs(LOGIN_PAGE_TITTLE,DEFAULT_TIMEOUT);
		System.out.println("Login Page Tittle is  " + title);
		return title;
	}

	public String getloginPageUrl() {
		//String Url = driver.getCurrentUrl();
		String Url = eleUtil.waitForURLContains(LOGIN_PAGE_FRACTION_URL ,DEFAULT_TIMEOUT );
		System.out.println("Login Page url is  " + Url);
		return Url;
	}

	public boolean isForPwdExist() {
		return eleUtil.isElementDisplayed(forgotPwdLink);
		
	}

	public AccountsPage doLogin(String Username, String pwd) {
		System.out.println("user credentials: " + Username + ":" + pwd);
		eleUtil.waitForElementVisible(email, MEDIUM_DEFAULT_TIMEOUT).sendKeys(Username);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		//after clicking on login button ---> landing on Accounts Page
		//responsible to return the AccountsPage class object
		return new AccountsPage(driver);
	}
	public RegisterPage navigateToRegisterPage() {
		eleUtil.clickWhenReady(registerLink, DEFAULT_TIMEOUT);
		return new RegisterPage(driver);
	}
	
}
