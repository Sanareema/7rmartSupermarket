package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;

public class ManageCategoryPage {
	
	WebDriver driver;
	public PageUtility pageutility=new PageUtility();
	public FileUploadUtility fileuploadutility = new FileUploadUtility();
	@FindBy(xpath="//a[contains(@href,'admin/list-category') and contains(text(),'More info')]") WebElement managecategorymoreinfo;
	@FindBy(css="a[onclick='click_button(1)']") WebElement editbutton;
	@FindBy(id="category") WebElement categoryfield;
	@FindBy(id="134-selectable") WebElement selectdiscount;
	@FindBy(id="main_img") WebElement choosefilebtn;
	@FindBy(css="button[type='submit']") WebElement savebutton;
	@FindBy(xpath="//div[contains(@class,'dismissible')]")WebElement alertview;
	
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void manageCategory() {
		pageutility.javaScriptClickElement(driver, managecategorymoreinfo);
	}
	public void editButton() {
		editbutton.click();
	}
	public void categoryField(String text) {
		categoryfield.sendKeys(text);
	}
	public void selectDiscount() {
		pageutility.javaScriptClickElement(driver, selectdiscount);
	}
	public void chooseFile(String path) {
		fileuploadutility.fileUploadUsingSendKeys(choosefilebtn,path);
	}
	public void saveButton() {
		pageutility.javaScriptClickElement(driver, savebutton);
	}
	public boolean alertView() {
		return alertview.isDisplayed();
	}
}
