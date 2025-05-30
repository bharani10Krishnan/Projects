package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Bk.ReusePackage.UtilityClass;

public class ResultsPage {

	private WebDriver driver;


	UtilityClass uc;


	public WebElement prdSelect;


	public ResultsPage(WebDriver driver) {
		this.driver=driver;
		this.uc=new UtilityClass(driver);

		PageFactory.initElements(driver, this);
	}





	public void productSelectFromResultPage(String productName) {

		List<WebElement> resultsName=driver.findElements(By.xpath("//div[@class=\"KzDlHZ\"]"));

		if(resultsName.isEmpty()) {
			System.out.println("No elements are there in the list");
		}else {
			for(WebElement result: resultsName) {
				String resultText = result.getText();
				System.out.println(resultText);

				if(resultText.equalsIgnoreCase(productName)) {

					try {
						uc.scrollIntoView(result);

						System.out.println("System scrolled to Product : " + resultText);

						uc.elementVisiblity(result, 10000);
						System.out.println("Product is Visible : " + resultText);

						uc.mouseOver(result);

						uc.elementClickablity(result, 15000);

						System.out.println("Product Name is clickable : " + resultText);

						uc.clickElementUsingJS(result);

						System.out.println("Product Name is clicked : " + resultText);

						break;
					}catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}

			}

		}

	}


}
