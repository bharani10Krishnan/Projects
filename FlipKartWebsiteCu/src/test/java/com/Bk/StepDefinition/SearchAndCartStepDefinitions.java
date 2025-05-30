package com.Bk.StepDefinition;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.logging.log4j.LogManager;

import com.Bk.ReusePackage.UtilityClass;

import pages.*;

import org.apache.logging.log4j.Logger;
import io.cucumber.java.en.*;

public class SearchAndCartStepDefinitions {
	
	private WebDriver driver;
	
	public Logger logger;
	UtilityClass uc;
	
	@Given("User launches the Flipkart website in respective {string} environment")
	public void user_launches_the_flipkart_website_in_respective_environment(String string) throws IOException {
		
		uc = new UtilityClass(driver);
		
		
		if(string.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if(string.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}else {
			driver = new FirefoxDriver();
		}
		
		
		//FlipKart URL
		driver.get(uc.getProperty("baseURL"));
		
		
		driver.manage().window().maximize();
		
		logger = LogManager.getLogger(this.getClass());

	}

	
	@When("User searches for the {string} in the Search bar.")
	public void user_searches_for_the_in_the_search_bar(String item) {
		HomPage hp = new HomPage(driver);
	
		
		logger.info("user searches for the item in the search bar");
		hp.searchBarMethod();
		
		
		hp.searchBar.sendKeys(item);
		
		
		hp.searchBar.sendKeys(Keys.ENTER);
		
		
		try {
			hp.retryPhase();
		}catch(Exception e) {
			System.out.println("this page is not found");
		}
		
		
		logger.info("User successfully searched the product and retrieved the results");
		
		
	}
	@Then("User select the {string} from the search results.")
	public void user_select_the_from_the_search_results(String string) {
		HomPage hp = new HomPage(driver);
		
		ResultsPage rp = new ResultsPage(driver);
	
		logger.info("User has to select the product from the item results");
		
		rp.productSelectFromResultPage(string);
		
		
		logger.info("User successfully selected the particular product");
		
		
	}
	@Then("User switches the tab for the product detail page.")
	public void user_switches_the_tab_for_the_product_detail_page() {
		uc = new UtilityClass(driver);
		HomPage hp = new HomPage(driver);
	
		
		logger.info("User has switched the window for the Product details page");
		uc.switchWindow();
		
		try {
			hp.retryPhase();
		}catch(Exception e) {
			System.out.println("this page is not found");
		}
		
		
		logger.info("User successfully switched the window");
	}
	
	
	@Then("User click on Add to Bag")
	public void user_click_on_add_to_bag() {
	   ProductDetailPage pdp = new ProductDetailPage(driver);
	   
	   logger.info("User has extracting the product name from the page");
	   
	   pdp.getProductName();
	   
	   
	   String textProductName = pdp.prdName.getText();
	   
	   System.out.println(textProductName);
	   
	   String[] a=textProductName.split(" ");
	   System.out.println("Index 0 of the Product"+a[0]);
	   
	   
	   
	   pdp.addToCartButton();
	   
	   logger.info("User successfully clicked on Add to cart button");
	   
		
		
	}
	@Then("User verifies that {string} displayed in the cart.")
	public void user_verifies_that_displayed_in_the_cart(String string) {
	    
		CartPage cp = new CartPage(driver);
		
		logger.info("User has landed into the Cart Page");
		
		cp.cartContainer();
		
		
		uc.takeScreenshotWebElement(cp.productContainer, "ProductInTheCart");
		
		
		cp.getDetails();
		
		
		String cartProductName=cp.getProductNameInCart.getText();
		
		System.out.println("Product Name in the Cart : " + cartProductName);
		
		
		
		Assert.assertEquals(cartProductName, string);
		
		
		logger.info("User successfully verify the product in the cart which matches with the product which we have selected");
	}
	
	
	@And("User returns back and Searched for {string} and added the product {string} in the cart.")
	public void user_returns_back_and_searched_for_and_added_the_product_in_the_cart(String item2, String productName2) throws InterruptedException {
		uc = new UtilityClass(driver);
		HomPage hp = new HomPage(driver);
		
		CartPage cp = new CartPage(driver);
		
		
		logger.info("Adding different product into the cart");
		
		uc.closeCurrentWindow();
		
		try {
			hp.searchFieldRemove();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		user_searches_for_the_in_the_search_bar(item2);
		
		user_select_the_from_the_search_results(productName2);
		
		
		user_switches_the_tab_for_the_product_detail_page();
		
		user_click_on_add_to_bag();
		
		
		
		Thread.sleep(6000);
		
		cp.calculateTheCartValue();
		
		
		
		uc.scrollIntoView(cp.getFinalValue);
		
		String finalValueText=cp.getFinalValue.getText();
		
		String convertedFinalValue=finalValueText.replaceAll("[₹,]", "");
		
		System.out.println("The converted final value in Text : "+convertedFinalValue);
		
		Assert.assertEquals(convertedFinalValue, cp.convertedValue);
		
		
		logger.info("Successfully added and verified the cart value.");
		
	}


}
