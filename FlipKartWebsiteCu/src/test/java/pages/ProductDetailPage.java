package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bk.ReusePackage.UtilityClass;

public class ProductDetailPage {
	
	private WebDriver driver;
	private UtilityClass uc;
	
	
	public ProductDetailPage(WebDriver driver) {
		this.driver=driver;
		this.uc = new UtilityClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[@class=\"VU-ZEz\"]")
	public WebElement prdName;
	
	
	
	@FindBy(xpath="//button[text()=\"Add to cart\"]")
	public WebElement cartButton;
	
	
	
	
	public void getProductName() {
		
		uc.elementVisiblity(prdName, 10000);
		
		uc.mouseOver(prdName);
	}
	
	
	public void addToCartButton() {
		
		uc.mouseOver(cartButton);
		
		uc.elementVisiblity(cartButton, 10000);
		
		
		uc.doubleClick(cartButton);
	}

}
