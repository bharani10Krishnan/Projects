package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Bk.ReusePackage.*;

public class HomPage {
	
	
	private WebDriver driver;
	
	private UtilityClass uc;
	
	
	
	public HomPage(WebDriver driver) {
		this.driver=driver;
		this.uc= new UtilityClass(driver);
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name = "q")
	public WebElement searchBar;
	
	
	@FindBy(xpath="//button[@id=\"retry_btn\"]")
	public WebElement tryButton;
	
	
	
	
	
	public void searchBarMethod() {
		uc.elementVisiblity(searchBar, 10000);
		
		uc.scrollIntoView(searchBar);
	}
	
	
	
	public void searchFieldRemove() throws InterruptedException {
		uc.elementVisiblity(searchBar, 20000);
		
		uc.scrollIntoView(searchBar);
		
		
		searchBar.click();
		
		
		Thread.sleep(3000);
		
		searchBar.clear();
	}
	
	
	public void retryPhase() {
		
		uc.elementVisiblity(tryButton, 10000);
		
		uc.mouseOver(tryButton);
		
		
		uc.clickElementUsingJS(tryButton);
	}
	
	
	

}
