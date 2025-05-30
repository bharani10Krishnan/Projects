package com.BK.Myntra.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BK.Myntra.Classes.UtitlyClass;

public class ProductPage {
	
	private WebDriver driver;
	
	private UtitlyClass uc;
	
	
	public ProductPage(WebDriver driver) {
		this.driver=driver;
		this.uc= new UtitlyClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//h1[@class=\"pdp-title\"]")
	public WebElement productTitle;
	
	
	
	@FindBy(xpath = "//h1[@class=\"pdp-name\"]")
	public WebElement productName;
	
	
	
	@FindBy(xpath = "//span[@class=\"pdp-price\"]")
	public  WebElement productPrice;
	
	
	public List<WebElement> sizeSelect;
	
	
	@FindBy(xpath = "//div[contains(@class,\"pdp-add-to-bag\")]")
	public WebElement addToBag;
	
	
	@FindBy(xpath = "//a[@class=\"desktop-cart\"]")
	public WebElement bag;
	
	
	
	public static String textProductTitle;
	
	public static String textProductName;
	
	public static String textProductPrice;

	
	public static String numericValue;
	
	public static String sizeText;
	
	 private Set<String> previouslySelectedSizes = new HashSet<>();
	
	
	
	public void capturingProductDetails() throws InterruptedException {
		
		//title
		uc.elementVisiblity(productTitle, 20000);
		
		uc.mouseOver(productTitle);
		
		textProductTitle=productTitle.getText();
		
		System.out.println(textProductTitle);
		
		
		
		//Name
		uc.elementVisiblity(productName, 10000);
		
		uc.mouseOver(productName);
		
		
		textProductName=productName.getText();
		
		System.out.println(textProductName);
		
		
		//Price
		uc.elementVisiblity(productPrice, 10000);
		
		uc.mouseOver(productPrice);
		
		String textProductPrice = productPrice.getText();
		
		System.out.println(textProductPrice);
		
		
		String currencySymbol=textProductPrice.substring(0, 1);
		
		System.out.println(currencySymbol);
		
		numericValue = textProductPrice.substring(1);
		
		System.out.println(numericValue);
		
		
		
		Thread.sleep(5000);
		
		
		try {
			uc.takeScreenshot("Product Details");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
	}
	
	

	public void selectSize() {
		sizeSelect = driver.findElements(By.xpath("//button[contains(@class,\"size-buttons-size-button\")]"));

		List<WebElement> availableSizes = new ArrayList<>();

		for (WebElement sizes : sizeSelect) {
			if (sizes.isDisplayed() && sizes.isEnabled() && !sizes.getAttribute("class").contains("disabled")) {
				availableSizes.add(sizes);
			}
		}

		// Filter out previously selected sizes
		availableSizes.removeIf(size -> previouslySelectedSizes.contains(size.getText()));

		if (!availableSizes.isEmpty()) {
			WebElement getRandomSize = availableSizes.get(new Random().nextInt(availableSizes.size()));

			sizeText = getRandomSize.getText();
			previouslySelectedSizes.add(sizeText);

			System.out.println("Randomly selected Size: " + sizeText);

			uc.mouseOver(getRandomSize);
			
			
			uc.clickElementUsingJS(getRandomSize);
		} else {
			System.out.println("No new sizes available to select.");
		}
	}
	
	
	
	

	public void selectDifferentSize() {
		sizeSelect = driver.findElements(By.xpath("//button[contains(@class,\"size-buttons-size-button\")]"));

		List<WebElement> availableSizes = new ArrayList<>();

		for (WebElement sizes : sizeSelect) {
			if (sizes.isDisplayed() && sizes.isEnabled() && !sizes.getAttribute("class").contains("disabled")) {
				availableSizes.add(sizes);
			}
		}

		// Filter out previously selected sizes
		availableSizes.removeIf(size -> previouslySelectedSizes.contains(size.getText()));

		if (!availableSizes.isEmpty()) {
			WebElement getRandomSize = availableSizes.get(new Random().nextInt(availableSizes.size()));

			sizeText = getRandomSize.getText();
			previouslySelectedSizes.add(sizeText);

			System.out.println("Randomly selected Size: " + sizeText);

			uc.mouseOver(getRandomSize);
			
			
			uc.clickElementUsingJS(getRandomSize);
		} else {
			System.out.println("No new sizes available to select.");
		}
	}


	
	
	
	public void addToBagButton() {
		
		uc.scrollIntoView(addToBag);
		
		
		uc.elementVisiblity(addToBag, 10000);
		
		uc.clickElementUsingJS(addToBag);
	
	}
	
	
	public void navigateToCart() {
		
		uc.scrollIntoView(bag);
		
		
		uc.elementVisiblity(bag, 10000);
		
		uc.clickElementUsingJS(bag);
		
	}

}
