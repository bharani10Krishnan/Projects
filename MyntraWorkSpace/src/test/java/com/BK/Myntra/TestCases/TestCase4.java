package com.BK.Myntra.TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;

import com.BK.Myntra.Classes.UtitlyClass;
import com.BK.Myntra.Pages.AddAnotherProduct;
import com.BK.Myntra.Pages.ProductPage;
import com.BK.Myntra.Pages.ShoppingBag;


//Adding different products in the 


public class TestCase4 {
	
	private WebDriver driver;
	UtitlyClass uc;
	
	TestCase1 testCase = new TestCase1();
	ShoppingBag shp;
	
	ProductPage pc;
	
	
	@Test(priority = 0)
	public void step1() throws IOException, InterruptedException {
		
		testCase.setUpDriver();
		
		driver=testCase.getDriver();
		
		shp = new ShoppingBag(driver);
		
		pc = new ProductPage(driver);
		
		uc = new UtitlyClass(driver);
		
		testCase.step1();
		
		testCase.step2();
		
		testCase.step3();
	}
	
	
	@Test(priority=1)
	public void step2() throws InterruptedException {
		
		AddAnotherProduct ap = new AddAnotherProduct(driver);
		
		uc.closeCurrentWindow();
		
		
		ap.secondProductSelect();
		
		uc.switchWindow();
		
		pc.capturingProductDetails();
		
		pc.selectSize();
		
		pc.addToBagButton();
		
		pc.navigateToCart();
		
		ap.shoppingCart();
		
	}
	
	
	

}
