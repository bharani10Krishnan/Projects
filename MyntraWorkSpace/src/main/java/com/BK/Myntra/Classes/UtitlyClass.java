package com.BK.Myntra.Classes;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UtitlyClass {

	private  WebDriver driver;
	private  WebDriverWait wait;


	public UtitlyClass(WebDriver driver) {
		this.driver=driver;

	}
	
	
	
	public void refresh() {
		driver.navigate().refresh();
	}


	private void intializeWait(int timeout) {
		this.wait = new WebDriverWait(driver, Duration.ofMillis(timeout));

	}
	
	


	//Explicit Wait

	public void elementVisiblity(WebElement element, int timeout) {

		intializeWait(timeout);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void elementClickablity(WebElement element, int timeout) {

		intializeWait(timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public  void presenceOfElement(By element, int timeout) {

		intializeWait(timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}
	
	public void waitForFramePresence(int timeout, String frameLocator) {
		intializeWait(timeout);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}


	//*************************************JavaScriptExecutor*************************************************\\

	
	public JavascriptExecutor getJavascriptExecutor() {
		return (JavascriptExecutor) driver;
	}
	
	
	//Moving to the element
	
	public void scrollIntoView(WebElement element) {
		getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	
	//Click an element using JavaScript
	
	public void clickElementUsingJS(WebElement element) {
		getJavascriptExecutor().executeScript("arguments[0].click();", element);
	}
	
	//Set value of an input field using javaScript
	
	public void setInputValueJS(WebElement element, String value) {
		getJavascriptExecutor().executeScript("arguments[0].value='"+value+"';", element);
	}

	//*****************************************Frames********************************************************\\

	// Method to switch to a frame by name or ID
	public void switchToFrame(String frameNameAndID) {
		driver.switchTo().frame(frameNameAndID);
	}


	// Method to switch to a frame by WebElement
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}


	// Method to switch back to the default content

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}
	
	//****************************************Screenshots******************************************************\\
	public String takeScreenshot(String fileName) throws IOException{

		TakesScreenshot takeScreenshot=(TakesScreenshot) driver;

		//Source file for the screenshot.
		
		File sourcefile=takeScreenshot.getScreenshotAs(OutputType.FILE);

		//Destination to place the screenshot.
		
		File destFile=new File("./MyntraProjectScreenshots/"+fileName+".png");
		
		sourcefile.renameTo(destFile);
		
		return fileName;

	}
	
	
	
	
	public String takeScreenshotWebElement(WebElement element, String fileName) {
		
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		
		File sourceFile=element.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File("./MyntraProjectScreenshots/"+fileName+".png");
		
		sourceFile.renameTo(destFile);
		
		return fileName;
	}
	
	
	//**************************************Properties********************************************************\\
	
	
	
	public String getProperty(String key) throws IOException {
		
		FileInputStream fis = new FileInputStream("C:\\Users\\2261164\\eclipse-workspace\\MyntraWorkSpace\\src\\test\\resources\\config.properties");
		Properties pr = new Properties();
		pr.load(fis);
		return pr.getProperty(key);
	}
	
	
	
	
	
	//**************************************Actions*******************************************************************\\
	
	
	public Actions getAction() {
		return new Actions(driver);
		
	}
	
	
	public void mouseOver(WebElement element) {
		getAction().moveToElement(element).perform();
	}
	
	
	public void dragAndDrop(WebElement source, WebElement target) {
		getAction().dragAndDrop(source, target);
	}
	
	
	
	
	//*************************************Window Handles***********************************************************\\
	
	
	public void switchWindow() {
		
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		for(String window: allWindows) {
			
			if(!window.equals(currentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}
	
	
	
	
	public void closeCurrentWindow() {
		driver.close();
		
		driver.switchTo().window(driver.getWindowHandles().iterator().next());
	}
	
	
	
	//***************************************Select********************************************************\\
	
	
	
	public void selectByVisibleText(WebElement element, String text) {
		
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	
	
	public void selectByValue(WebElement element, String value) {
		
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	

}
