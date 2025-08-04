package com.qa.opencart.pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.qa.opencart.constants.AppConstants.*;
import com.qa.opencart.utils.ElementUtil;

public class SearchResultsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	//private final By resultsProduct = By.cssSelector("div.product-thumb");
	private final By resultsProduct = By.xpath("//div[@class=\"product-thumb\"]");
	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public int getResultsProductCount() {
//		int searchCount =eleUtil.waitForAllElementsVisible(resultsProduct,AppConstant.MEDIUM_DEFAULT_TIMEOUT).size();
//		System.out.println("Total no.of search products "+searchCount);
		int searchCount = eleUtil.getElementsCount(resultsProduct);
		System.out.println("Total no.of search products "+searchCount);
		List<WebElement>productList =eleUtil.getElements(resultsProduct);
		for (WebElement e:productList) {
			System.out.println(e.getText());
			}
		eleUtil.doClick(resultsProduct);
		return searchCount;
	}
	public ProductInfoPage selectProduct(String productName) {
		System.out.println("Product Name is  "+ productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
}
