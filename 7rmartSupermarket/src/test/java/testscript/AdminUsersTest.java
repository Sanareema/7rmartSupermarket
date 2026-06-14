package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base{
	@Test
	public void adminUsersTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");

		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
			
		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickAdminUsersMoreInfo();
		adminusers.clickNewButton();
		adminusers.adminUserInfo("starlight1", "starbright1", "Staff");
		adminusers.clickSaveButton();
		
		
		}
}