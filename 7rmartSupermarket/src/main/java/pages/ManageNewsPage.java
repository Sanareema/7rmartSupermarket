package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	
	protected WebDriver driver;
	
	@FindBy(xpath="(//a[contains(@href,'list-news')])[1]") WebElement newsmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news' and @placeholder='Enter the news']") WebElement newsfield;
	@FindBy(xpath="//button[@type='submit' and text()='Save']") WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]") WebElement alertview;
		
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickManageNewsMoreInfo() {
		Actions action=new Actions(driver);
		action.click(newsmoreinfo).perform();
	}
	public void clickNewButton() {
		Actions action=new Actions(driver);
		action.click(newbutton).perform();
	}
	public void newsFieldEntry(String text) {
		Actions action=new Actions(driver);
		action.click(newsfield).sendKeys(text).perform();
	}
	public void clickSave() {
		Actions action=new Actions(driver);
		action.click(savebutton).perform();
	}
	public boolean isAlertDisplayed() {
		return alertview.isDisplayed();
	}
	
}
