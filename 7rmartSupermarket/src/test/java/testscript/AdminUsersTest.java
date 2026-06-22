package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base{
	@Test(retryAnalyzer= retry.Retry.class)
	public void adminUsersTest() throws IOException {
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		
		FakerUtility fakerutility=new FakerUtility(); //apply retry to all faker utility using tests
		String adminusername=fakerutility.createARandomFirstName();
		//loginpage.enterUsername(username);
		//String adminuser = ExcelUtility.getStringData(1,0,"adminuserlogin");
		String adminpassword = ExcelUtility.getStringData(1,1,"adminuserlogin");	
		
		AdminUsersPage adminusers = new AdminUsersPage(driver);
				
		adminusers.clickAdminUsersMoreInfo();
		adminusers.clickNewButton();
		adminusers.adminUserInfo(adminusername, adminpassword);
		adminusers.selectUserType();
		adminusers.clickSaveButton();
		Assert.assertTrue(adminusers.alertMessage());
		}
}