package com.BK.Myntra.Pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BK.Myntra.Classes.UtitlyClass;

public class ShoppingBag {
	
	
	private WebDriver driver;
	
	private UtitlyClass uc;
	
	
	
	
	public ShoppingBag(WebDriver driver) {
		this.driver=driver;
		this.uc=new UtitlyClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css=".itemContainer-base-brand")
	public WebElement getProductTitle;
	
	
	@FindBy(xpath="//a[@class=\"itemContainer-base-itemLink\"]")
	public WebElement getProductName;
	
	
	@FindBy(css=".itemContainer-base-price div:nth-child(1) div")
	public WebElement getProductPrice;
	
	
	@FindBy(css=".itemContainer-base-price div:nth-child(1) div")
	public WebElement priceAfterQuantityChange;
	
	
	public static String textGetProductName;
	
	public static String textGetProductTitle;
	
	public  String textGetProductPrice;
	
	public static String sizeValue;
	
	public static String textFinalPrice;
	
	public String quantityList;
	
	public static String textPriceOfEachQuantity;
	
	public String textFinalPriceAfterQuantityChange;
	
	public int totalPriceInt;
	
	public int numericPFValue;
	
	public String finalAmount;
	
	public String textFinalCartValue;
	
	public String textCV;
	
	
	@FindBy(css=".desktop-base-cartLayout")
	public WebElement cartContainer;
	
	
	
	@FindBy(css=".itemComponents-base-size span")
	public WebElement cartSize;
	
	

	
	
	@FindBy(css=".itemComponents-base-quantity span")
	public WebElement cartQuantity;
	
	
	
	@FindBy(css="div .itemComponents-base-quantity")
	public WebElement quantityBase;
	
	
	
	@FindBy(css = ".dialogs-base-item")
	public List<WebElement> quantityChange;
	
	
	@FindBy(xpath="//div[text()=\"DONE\"]//ancestor::button")
	public WebElement doneBtn;
	
	
	@FindBy(css=" div.priceDetail-base-row:nth-child(4) span:nth-child(2)")
	public WebElement platFormValue;
	
	
	
	@FindBy(css="div.priceDetail-base-total :nth-child(2)")
	public WebElement totalCartValue;
	
	public void shoppingBag() {
		
		textGetProductName=getProductName.getText();
		System.out.println(textGetProductName);
		
		
		uc.elementVisiblity(getProductTitle, 10000);
		
		textGetProductTitle = getProductTitle.getText();
		System.out.println(getProductTitle);
		
	
		
	}
	
	
	public void cartValue() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		uc.elementVisiblity(getProductPrice, 10000);

		uc.mouseOver(getProductPrice);
		
		textGetProductPrice=getProductPrice.getText();
		System.out.println(getProductPrice);
		
		textFinalPrice=textGetProductPrice.replace(",", "");
		
		System.out.println(textFinalPrice);
	}
	
	
	public void cartProductSizeValue() {
		
		uc.elementVisiblity(cartSize, 10000);
		
		String cartTextSize=cartSize.getText();
		
		sizeValue=cartTextSize.split(":")[1].trim();
		
		System.out.println(sizeValue);
	}
	
	
	public void cartQuantityValue() {
		
		String cartQuantityText=cartQuantity.getText().split(":")[1].trim();
		
		System.out.println("Quantity  of Item :" + cartQuantityText);
		
		
		
		//uc.switchToDefaultContent();
		
	}
	
	
	
	public void quantityChange() {
		
		
		uc.elementVisiblity(quantityBase, 10000);
		
		uc.clickElementUsingJS(quantityBase);
		
		
	}
	
	
	
	public void selectNewQuantity() {
		
		
		List<WebElement> availableQuantities = new ArrayList<>();
		
		
		for(WebElement quan :quantityChange ) {
			
			if(quan.isDisplayed() && quan.isEnabled() && quan.getAttribute("class").contains("dialogs-base-item null null")) {
				availableQuantities.add(quan);
			}
		}
		
		if(!availableQuantities.isEmpty()) {
			WebElement getRandomQuantities = availableQuantities.get(new Random().nextInt(availableQuantities.size()));
			
			quantityList=getRandomQuantities.getText();
			

			System.out.println("Randomly selected Quantity: " + quantityList);
			
			uc.mouseOver(getRandomQuantities);
			
			getRandomQuantities.click();
		}
		
		
		
		uc.elementVisiblity(doneBtn, 10000);
		
		uc.clickElementUsingJS(doneBtn);
		
	}
	
	
	
	public void checkCartValue() {
		
		
		
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		uc.elementVisiblity(priceAfterQuantityChange, 10000);
		
		uc.mouseOver(getProductPrice);
		
		String textPriceAfterQuantityChange=priceAfterQuantityChange.getText();
		
		
		System.out.println(textPriceAfterQuantityChange);
		
		textFinalPriceAfterQuantityChange=textPriceAfterQuantityChange.replace(",", "");
		
		System.out.println(textFinalPriceAfterQuantityChange);
		
		
		totalPriceInt=Integer.parseInt(textFinalPriceAfterQuantityChange);
		
		System.out.println("Final Price after Changing the Quantity" + totalPriceInt);
		
		int quantityInt = Integer.parseInt(quantityList);
		
		System.out.println("Converted number :" + totalPriceInt);
		
		int priceOfEachQuantity=totalPriceInt/quantityInt;
		
		System.out.println(priceOfEachQuantity);
		
		textPriceOfEachQuantity = String.valueOf(priceOfEachQuantity);
		
		
		
	}
	
	
	
	public void Platform() {
		
		uc.elementVisiblity(platFormValue, 7000);
		
		uc.mouseOver(platFormValue);
		
		
		String textPF=platFormValue.getText();
		
		System.out.println("String Value of Platform" + textPF);
		
		
		char rupeeSymbol = textPF.charAt(0);			//Extracts "₹" Symbol from the Amount
		
		System.out.println("Rupee Symbol " + rupeeSymbol);
		
		String trimmedPFValue = textPF.substring(1);	//Extracts the Numeric part.
		
		System.out.println("Trimmed Platform Value" + trimmedPFValue);
		
		
		numericPFValue=Integer.parseInt(trimmedPFValue);
		
		System.out.println("Converted Platform Value" + numericPFValue);
		
		
		
		
		//totalPriceInt
	}
	
	
	
	public void finalCartValue() {
		
		
		int finalCartValue=totalPriceInt+numericPFValue;
		
		System.out.println("Final Cart Value" + finalCartValue);
		
		
		textFinalCartValue=String.valueOf(finalCartValue);
		
		System.out.println("Converted to String Calculated Final Amount" + textFinalCartValue);
		
		
		uc.scrollIntoView(cartContainer);
		
		textCV=totalCartValue.getText();
		
		System.out.println("Extracted Cart Value" + textCV);
		
		
		finalAmount=textCV.replaceAll("[₹,]", "");	//Removes rupee symbol and comma from the amount
	
		System.out.println("Final Cart Price" + finalAmount);
	}
	
	
	
	
	
	
	
	
	
	

}
