package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utilities.PageUtility;

public class ManageContactPage {

	WebDriver driver;
	public PageUtility pageutility=new PageUtility();
	@FindBy(xpath="(//a[contains(@href,'admin/list-contact')])[2]") WebElement managecontactmoreinfo;
	@FindBy(xpath="//a[contains(@href,'edit_contact?edit=1')]//child::i") WebElement editbutton;
	@FindBy(id="phone") WebElement phone;
	@FindBy(id="email") WebElement email;
	@FindBy(name="address") WebElement address;
	@FindBy(name="del_time") WebElement deliverytime;
	@FindBy(name="del_limit") WebElement delchargelimit;
	@FindBy(name="Update") WebElement updatebtn;
	@FindBy(xpath="//div[contains(@class,'dismissible')]") WebElement alertview;
	
	public ManageContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void manageContact() {
		managecontactmoreinfo.click();
	}
	public void editButton() {
		pageutility.javaScriptClick(driver, editbutton);
	}
	public void phoneField(String phoneno) {
		phone.clear();
		phone.sendKeys(phoneno);
	}
	public void emailField(String mail) {
		email.clear();
		email.sendKeys(mail);
	}
	public void addressField(String adrs) {
		address.clear();
		address.sendKeys(adrs);
	}
	public void deliveryTimeField(String time) {
		deliverytime.clear();
		deliverytime.sendKeys(time);
	}
	public void deliveryChargeLimitField(String chargelimit) {
		delchargelimit.clear();
		delchargelimit.sendKeys(chargelimit);
	}
	public void updateButton() {
		updatebtn.click();
	}
	public boolean isAlertDisplayed() {
		return alertview.isDisplayed();
	}
}
