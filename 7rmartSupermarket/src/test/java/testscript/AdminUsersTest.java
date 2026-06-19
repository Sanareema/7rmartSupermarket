package testscript;

import java.io.IOException;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test
	public void adminUsersTest() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");

		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		FakerUtility fakerutility=new FakerUtility(); //apply retry to all faker utility using tests
		String adminusername=fakerutility.creatARandomFirstName();
			
		AdminUsersPage adminusers = new AdminUsersPage(driver);
		adminusers.clickAdminUsersMoreInfo();
		adminusers.clickNewButton();
		adminusers.adminUserInfo("reem", "reemstar", "Admin");
		adminusers.clickSaveButton();
		}
}