package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;
import static com.qa.opencart.constants.AppConstants.*;

import java.util.ArrayList;
import java.util.List;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private final By headers = By.xpath("//h2");
	private final By search = By.name("search");
	private final By searchIcon = By.cssSelector("div#search button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getAccPageTitle() {
		String title = eleUtil.waitForTitleIs(HOME_PAGE_TITTLE, DEFAULT_TIMEOUT);
		System.out.println("Home Page Tittle is  " + title);
		return title;
	}

	public String getAccPageUrl() {
		String URL = eleUtil.waitForURLContains(HOME_PAGE_FRACTION_URL, DEFAULT_TIMEOUT);
		System.out.println("Home Page URL  " + URL);
		return URL;
	}

	public List<String> getAccPageHeaders() {
		List<WebElement> headersList = eleUtil.getElements(headers);
		List<String> headerValList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String Text = e.getText();
			headerValList.add(Text);
		}
		System.out.println("Acc page headers are " + headerValList);
		return headerValList;
	}

	public SearchResultsPage doSearch(String searchKey) {
		eleUtil.doSendKeys(search, searchKey);
		eleUtil.doClick(searchIcon);

		return new SearchResultsPage(driver);

	}
}
