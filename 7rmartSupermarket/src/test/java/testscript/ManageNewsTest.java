package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class)
	public void manageNewsTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		ManageNewsPage managenews = new ManageNewsPage(driver);
		managenews.clickManageNewsMoreInfo();
		managenews.clickNewButton();
		managenews.newsFieldEntry("Soccer Fever 2026");
		managenews.clickSave();
		boolean alertview=managenews.isAlertDisplayed();
		Assert.assertTrue(alertview);
	}

}
