package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
	public WebDriver driver;
	//WaitUtility wait=new WaitUtility();
	
	@FindBy(xpath="//input[@placeholder='Username']")WebElement usernamefield;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passwordfield;
	@FindBy(xpath="//button[@type='submit']")WebElement signinbtn;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement alert; //locating alert
	

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void enterUsername(String username) {
		usernamefield.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordfield.sendKeys(password);
	}
	/*public void signInButton() {
		WaitUtility wait=new WaitUtility();
		wait.waitForElementToBeClickable(driver, signinbtn);
		signinbtn.click();
	}*/
	public void signIn() {
		signinbtn.click();
	}
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}
	public boolean isAlertDisplayed() {//only one method is enough if all invalid cases show same alert
		return alert.isDisplayed();
	}
}
