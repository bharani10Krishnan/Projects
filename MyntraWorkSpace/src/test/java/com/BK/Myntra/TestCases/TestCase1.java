package com.BK.Myntra.TestCases;



import java.io.IOException;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.BK.Myntra.Classes.UtitlyClass;
import com.BK.Myntra.Pages.HomePage;
import com.BK.Myntra.Pages.ProductPage;
import com.BK.Myntra.Pages.ResultsPage;
import com.BK.Myntra.Pages.ShoppingBag;

public class TestCase1 {
	
	
	private WebDriver driver;
	UtitlyClass uc;
	
	public String textSize;
	
	

	public WebDriver getDriver() {
		return driver;
	}

	
	
	
	@Test(priority=0)
	public void setUpDriver() {
		
		
		ChromeOptions options = new ChromeOptions();		//set the browser preference & Browser Settings.
		options.addArguments("--disable-notifications");	//Disable Notifications.
		options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		
		
		driver=new ChromeDriver(options);
		driver.get("https://www.myntra.com/");
		
		
		
		
		driver.manage().window().maximize();
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		Assert.assertEquals(title, "Online Shopping for Women, Men, Kids Fashion & Lifestyle - Myntra");
	}
	
	
	@Test(priority = 1)
	public void step1() throws IOException, InterruptedException {
		
		HomePage hc = new HomePage(driver);
		uc = new UtitlyClass(driver);
		ResultsPage rp = new ResultsPage(driver);
		
		
		hc.mouseHoverMen();
		hc.extractCategoryName();
		
		hc.categoryLinks(uc.getProperty("link"));
		
		
		rp.selectTheFirstProduct();
		
		uc.switchWindow();
		
	}
	
	
	@Test(priority = 2)
	public void step2() throws InterruptedException {
		
		ProductPage pc = new ProductPage(driver);
		
		pc.capturingProductDetails();
		
		pc.selectSize();
		
		pc.addToBagButton();
		
		pc.navigateToCart();
			
	}
	
	
	
	@Test(priority = 3)
	public void step3() {
		
		ShoppingBag shp = new ShoppingBag(driver);
		
		driver.navigate().refresh();
		
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(driver.getTitle());
		
		
		shp.shoppingBag();
		
		shp.cartValue();
		
		shp.cartProductSizeValue();
		
		shp.cartQuantityValue();
		
		Assert.assertEquals(ShoppingBag.textGetProductName, ProductPage.textProductName);
		
		
		Assert.assertEquals(ShoppingBag.textGetProductTitle, ProductPage.textProductTitle);
		
		Assert.assertEquals(ShoppingBag.textFinalPrice, ProductPage.numericValue );
		
		//Assert.assertEquals(ShoppingBag.sizeValue, ProductPage.sizeText);
		
		uc.scrollIntoView(shp.cartContainer);
		
		
		uc.takeScreenshotWebElement(shp.cartContainer, "Cart Image");
			
		
		
	}

}
