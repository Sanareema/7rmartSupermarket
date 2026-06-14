package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	
	@Test(retryAnalyzer=retry.Retry.class)
	public void verifyValidUserNameValidPwd() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.getStringData(1,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(1,1,"supermarketlogin");

		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean homepage=loginpage.isDashboardDisplayed(); //boolean result will be stored in variable 'homepage'
		Assert.assertTrue(homepage);
	}
	@Test
	public void verifyinvalidUserNameValidPwd() throws IOException {
		
		String username = ExcelUtility.getStringData(2,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(2,1,"supermarketlogin");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
		boolean alertmessage=loginpage.isAlertDisplayed();
		Assert.assertTrue(alertmessage);
	}
	@Test
	public void verifyValidUserNameInValidPwd() throws IOException {
		
		String username = ExcelUtility.getStringData(3,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(3,1,"supermarketlogin");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
	}
	@Test
	public void verifyinvalidUserNameInValidPwd() throws IOException {
		
		String username = ExcelUtility.getStringData(4,0,"supermarketlogin");
		String password = ExcelUtility.getStringData(4,1,"supermarketlogin");
		
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
		loginpage.signIn();
	}
}
