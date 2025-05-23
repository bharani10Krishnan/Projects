package com.BK.Myntra.TestCases;

import java.io.IOException;


import org.openqa.selenium.WebDriver;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BK.Myntra.Classes.UtitlyClass;

import com.BK.Myntra.Pages.ProductPage;

import com.BK.Myntra.Pages.ShoppingBag;

public class TestCase2 {
	
	private WebDriver driver;
	UtitlyClass uc;
	
	TestCase1 testCase = new TestCase1();
	ShoppingBag shp;
	
	ProductPage pc;
	
	public String textSize;
	
	
	@BeforeMethod
	public void step1() throws IOException, InterruptedException {
		
		testCase.setUpDriver();

		driver=testCase.getDriver();

		pc = new ProductPage(driver);

		uc = new UtitlyClass(driver);


		testCase.step1();

		testCase.step2();




		testCase.step3();

		
	}
	
	
	@Test
	public void step2() throws IOException, InterruptedException {
		
		
		driver.navigate().back();
		
		pc.capturingProductDetails();
		
		pc.selectDifferentSize();
		
		pc.addToBagButton();
		
		pc.navigateToCart();
		
		
		Thread.sleep(5000);
		
		
		uc.takeScreenshot("Cart after selecting different SIZE");
		
		
		//step3();
	}

}
