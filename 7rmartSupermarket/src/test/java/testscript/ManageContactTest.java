package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test
	public void manageContactTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		ManageContactPage managecontact = new ManageContactPage(driver);
		managecontact.manageContact();
		managecontact.editButton();
		managecontact.phoneField("(813)813-8134");
		managecontact.emailField("starlight@earth.com");
		managecontact.addressField("123 Test Ave");
		managecontact.deliveryTimeField("30");
		managecontact.deliveryChargeLimitField("500");
		managecontact.updateButton();
		Assert.assertTrue(managecontact.isAlertDisplayed());
	}
}
