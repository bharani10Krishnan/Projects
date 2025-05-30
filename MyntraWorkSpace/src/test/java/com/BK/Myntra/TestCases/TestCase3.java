package com.BK.Myntra.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BK.Myntra.Classes.UtitlyClass;
import com.BK.Myntra.Pages.ShoppingBag;

public class TestCase3 {
	
	private WebDriver driver;
	UtitlyClass uc;

	TestCase1 testCase = new TestCase1();
	ShoppingBag shp;

	
	
	
	
	@BeforeMethod
	public void step1() throws IOException, InterruptedException {
		
		
		
		testCase.setUpDriver();
		
		driver=testCase.getDriver();
		
		shp = new ShoppingBag(driver);
		
		uc = new UtitlyClass(driver);
		
		testCase.step1();
		
		testCase.step2();
		
		testCase.step3();
	}
	
	
	
	
	@Test
	public void step2() {
		
		shp.quantityChange();
		
		shp.selectNewQuantity();
		
		//shp.cartValue();
		
		shp.checkCartValue();
		
		
		Assert.assertEquals(ShoppingBag.textPriceOfEachQuantity, ShoppingBag.textFinalPrice);
		
		shp.Platform();
		
		shp.finalCartValue();
		
		
		uc.takeScreenshotWebElement(shp.totalCartValue, "total Amount");
		
		
		Assert.assertEquals(shp.finalAmount, shp.textFinalCartValue);
		
	}


}
