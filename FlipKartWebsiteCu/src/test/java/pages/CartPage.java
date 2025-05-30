package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bk.ReusePackage.UtilityClass;

public class CartPage {
	
	
	
	private WebDriver driver;
	
	private UtilityClass uc;
	
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
		this.uc= new UtilityClass(driver);
		
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//div[@class=\"_8X-K8p\"]")
	public WebElement productContainer;
	
	
	
	@FindBy(xpath = "//div[@class=\"gE4Hlh\"]//a")
	public WebElement getProductNameInCart;
	
	
	
	@FindBy(xpath="//span[@class=\"LAlF6k re6bBo\"]")
	public List<WebElement> getCartValues;
	
	
	@FindBy(xpath="//div[@class=\"_1Y9Lgu\"][1]//child::span")
	public WebElement getFinalValue;
	
	
	
	public String convertedValue;
	
	public void cartContainer() {
		
		
		uc.elementVisiblity(productContainer, 10000);
		
		uc.scrollIntoView(productContainer);
		
		
		uc.mouseOver(productContainer);
	}
	
	
	
	public void getDetails() {
		
		uc.elementVisiblity(getProductNameInCart, 10000);
		
		uc.mouseOver(getProductNameInCart);
		
		
		
	}
	
	
	
	
	public void calculateTheCartValue() {
		
		int count=0;
		
		if(getCartValues.isEmpty()) {
			
			System.out.println("The cart is empty. So, the value is null");
			
			count=0;
		}else {
			for(WebElement productValue : getCartValues) {
				
				uc.scrollIntoView(productValue);
				
				String productTextValue=productValue.getText();
				
				String replaceText=productTextValue.replaceAll("[₹,]", "");
				
				int convertedValue=Integer.parseInt(replaceText);
				
				count+=convertedValue;
			}
		}
		
		System.out.println("Total value from the products : " + count);
		
		convertedValue=String.valueOf(count);
		
		System.out.println("The converted String value : " + convertedValue) ;
		
		
	}

}
