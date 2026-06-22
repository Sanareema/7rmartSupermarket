package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utilities.ExcelUtility;

public class ManageFooterTextTest extends Base{
	@Test(retryAnalyzer=retry.Retry.class, description= "validating manage footer")
	public void manageFooterText() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");

		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
				
		ManageFooterTextPage managefootertext = new ManageFooterTextPage(driver);
		managefootertext.footerTextMoreInfo();
		managefootertext.actionButton1();
		managefootertext.footerTextInfoEntry("123 Test St", "test@mail.com", "9010803010");
		managefootertext.clickUpdateButton();
		boolean alertview=managefootertext.alertView();
		Assert.assertTrue(alertview);
	}
}
