package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageFooterTextPage {
	
	protected WebDriver driver;
	PageUtility pageutility= new PageUtility();
	@FindBy(xpath="//div[@class='icon']//following-sibling::a[contains(@href,'list-footertext')]") WebElement footertextmoreinfo;
	@FindBy(xpath="//a[contains(@href,'edit=1')]//child::i") WebElement action1;
	@FindBy(css="textarea#content") WebElement address;
	@FindBy(css="input#email") WebElement email;
	@FindBy(css="input#phone") WebElement phone;
	@FindBy(css="button[name='Update']") WebElement updatebutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]") WebElement alertview;
	
	public ManageFooterTextPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void footerTextMoreInfo() {
		footertextmoreinfo.click();
	}
	public void actionButton1() {
		action1.click();
	}
	public void footerTextInfoEntry(String add, String mail, String phonenum) {
		address.clear();
		address.sendKeys(add);
		email.clear();
		email.sendKeys(mail);
		phone.clear();
		phone.sendKeys(phonenum);
	}
	public void clickUpdateButton() {
		pageutility.javaScriptClickElement(driver, updatebutton);
	}
	public boolean alertView() {
		return alertview.isDisplayed();
	}
}
