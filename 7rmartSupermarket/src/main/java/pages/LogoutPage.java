package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LogoutPage {
	
	public WebDriver driver;
	public PageUtility pageutility=new PageUtility();
	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//a[@class='dropdown-item'][normalize-space()='Logout']")WebElement logoutbutton;
	@FindBy(xpath="//button[@type='submit']")WebElement signinbtn;
	
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickAdminDropDown() {
		admin.click();
	}
	public void logout7rmart() {
		pageutility.javaScriptClick(driver, logoutbutton);
	}
	public boolean isSigninBtnDisplayed() {
		return signinbtn.isDisplayed();
	}
}
