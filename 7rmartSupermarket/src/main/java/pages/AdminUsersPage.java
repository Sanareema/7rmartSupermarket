package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminUsersPage {
	
	protected WebDriver driver;
	PageUtility pageutility = new PageUtility();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	@FindBy(xpath="(//section[@class='content']//child::a)[1]")	WebElement adminusersmoreinfo;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newbutton;
	@FindBy(xpath="//input[@name='username']") WebElement username;
	@FindBy(xpath="//input[@id='password']") WebElement password;
	@FindBy(css="select#user_type") WebElement usertypedropdownfield;
	@FindBy(xpath="(//button[@type='submit'])[2]") WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]") WebElement alertview;
	
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAdminUsersMoreInfo() {
		pageutility.javaScriptClickElement(driver, adminusersmoreinfo);
	}
	public void clickNewButton() {
		pageutility.javaScriptClickElement(driver, newbutton);
	}
	public void adminUserInfo(String user, String pwd, String text) {
		username.sendKeys(user);
		password.sendKeys(pwd);
		Select usertype=new Select(usertypedropdownfield);
		usertype.selectByVisibleText(text);
	}
	public void clickSaveButton() {
		pageutility.javaScriptClickElement(driver, savebutton);
	}
}
