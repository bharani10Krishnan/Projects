package com.BK.Myntra.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BK.Myntra.Classes.UtitlyClass;

public class AddAnotherProduct {
	
	
	private WebDriver driver;
	
	private UtitlyClass uc;
	
	
	public AddAnotherProduct(WebDriver driver) {
		this.driver=driver;
		this.uc = new UtitlyClass(driver);
		
		PageFactory.initElements(driver, this);
	}

	
	
	@FindBy(css="li.product-base:nth-child(2) a")
	public WebElement secondProduct;
	
	
	public List<WebElement> getTitles;
	
	
	public List<WebElement> getProductNames;
	
	
	public List<WebElement> getProductPrices;
	
	
	
	
	public void secondProductSelect() {
		
		uc.elementVisiblity(secondProduct, 10000);
		
		uc.mouseOver(secondProduct);
		
		
		uc.clickElementUsingJS(secondProduct);
	}
	
	
	
	public void shoppingCart() {
		
		
	    List<WebElement> getTitles = driver.findElements(By.cssSelector(".itemContainer-base-brand"));
	    
	    
	    List<WebElement> getProductNames = driver.findElements(By.xpath("//a[@class=\"itemContainer-base-itemLink\"]"));
	    
	    
	    List<WebElement> getProductPrices = driver.findElements(By.cssSelector(".itemContainer-base-price div:nth-child(1) div"));

	    for (int i = 0; i < getTitles.size(); i++) {
	    	
	        WebElement title = getTitles.get(i);
	        
	        WebElement productName = getProductNames.get(i);
	        
	        WebElement price = getProductPrices.get(i);

	        uc.scrollIntoView(title);
	        
	        uc.scrollIntoView(productName);
	        
	        uc.scrollIntoView(price);

	        String titleText = title.getText();
	        
	        String nameText = productName.getText();
	        
	        String priceText = price.getText();

	        System.out.println("Title: " + titleText + ", Name: " + nameText + ", Price: " + priceText);
	    }
	}

	
	
	
	
}
