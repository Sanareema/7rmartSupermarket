package utilities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

//helper class to help page class(to store repeated methods in page class)
//for storing complicated actions, not for simple ones like sendkeys and click
public class PageUtility {

	public void dropdownByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void dropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void dropdownByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void rightClick(WebElement element, WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	public void dragAndDrop(WebElement source, WebElement target, WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(source, target).perform();
	}
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element);
	}
	public void clicks(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.click(element);
	}
	public void doubleClicks(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
	}
	public void javascriptExecutorScroll(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
	}
	public void javaScriptClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public void javaScriptSendKeys(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Reema';", element);
	}
	//scroll hw
	public void javaScriptScrollUp(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)","");
	}
	public void javaScriptScrollToWindowHeight(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)","");
	}
	// alert
	public void simpleAlert(WebDriver driver, WebElement element, String text) {
		element.click();
		Alert alert = driver.switchTo().alert();
		text = alert.getText();
		System.out.println("Alert Message: " + text);
		alert.accept();
	}
	public void confirmationAlert(WebDriver driver,WebElement element) {
		element.click();
		Alert alert = driver.switchTo().alert();
		//alert.accept();
		alert.dismiss();
	}
	public void promptalert(WebDriver driver,WebElement element) {
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Reema");
		alert.accept();
	}

}
