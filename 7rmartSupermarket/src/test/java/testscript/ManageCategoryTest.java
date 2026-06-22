package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constant;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;

public class ManageCategoryTest extends Base {
	@Test(retryAnalyzer=retry.Retry.class, description= "validating manage category")
	public void manageCategoryTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
			
		ManageCategoryPage managecategory = new ManageCategoryPage(driver);
		managecategory.manageCategory();
		managecategory.editButton();
		managecategory.categoryField("Martial Arts Club");
		managecategory.selectDiscount();
		managecategory.chooseFile(Constant.TESTIMAGEFILE);
		managecategory.saveButton();
		boolean alert= managecategory.alertView();
		Assert.assertTrue(alert);
	}	
	
}
