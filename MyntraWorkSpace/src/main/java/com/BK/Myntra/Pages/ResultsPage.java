package com.BK.Myntra.Pages;




import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BK.Myntra.Classes.UtitlyClass;

public class ResultsPage {


	private WebDriver driver;
	private UtitlyClass uc;

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		this.uc=new UtitlyClass(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css = "li.product-base:nth-child(1) a")
	private WebElement firstProduct;


	public void selectTheFirstProduct() {

		uc.elementVisiblity(firstProduct, 10000);

		uc.scrollIntoView(firstProduct);
		
		//uc.mouseOver(firstProduct);
		
		uc.elementClickablity(firstProduct, 10000);

		uc.clickElementUsingJS(firstProduct);
	}
	
}




