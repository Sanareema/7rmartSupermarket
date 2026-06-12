package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.LogoutPage;
import utilities.ExcelUtility;

public class LogoutTest extends Base {
	@Test
	public void verifyLogout() throws IOException {
		String username = ExcelUtility.getStringData(1, 0, "supermarketlogin");
		String password = ExcelUtility.getStringData(1, 1, "supermarketlogin");

		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();

		// logout
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdminDropDown();
		logoutpage.logout7rmart();
		boolean signin=logoutpage.isSigninBtnDisplayed();
		Assert.assertTrue(signin);
	}
}
