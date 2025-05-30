package com.BK.Myntra.Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BK.Myntra.Classes.UtitlyClass;

public class HomePage {
	
	
	private WebDriver driver;
	private UtitlyClass uc;
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		
		this.uc = new UtitlyClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//a[@data-group='men']")
	private WebElement navMen;
	
	
	
	@FindBy(xpath = "//li//a[@class=\"desktop-categoryName\" and contains(@href,\"/men\") and text()=\"Topwear\"]")
	private WebElement categoryName;
	
	
	public void mouseHoverMen() {
		
		uc.mouseOver(navMen);
	}
	
	
	
	public String extractCategoryName() {
		
		uc.scrollIntoView(categoryName);
		
		uc.elementVisiblity(categoryName, 5000);
		
		String categoryNameText=categoryName.getText();
		
		System.out.println(categoryNameText);
		
		return categoryNameText;
	}
	
	
	
	public void categoryLinks(String desiredLink) {
		
		WebElement selectLink=driver.findElement(By.xpath("//a[text()=\""+desiredLink+"\"]"));
		
		uc.elementVisiblity(selectLink, 10000);
		
		uc.clickElementUsingJS(selectLink);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
