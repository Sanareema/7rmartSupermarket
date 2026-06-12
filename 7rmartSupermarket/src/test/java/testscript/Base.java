package testscript;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.WaitUtility;

public class Base {

	WebDriver driver;

	@BeforeMethod
	public void browserInitialization() {
		driver = new EdgeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT)); //5 sec given in wait utility class 
		driver.manage().window().maximize();
	}
	//@AfterMethod
	/*public void browserQuitAndclose() {
		driver.quit();
	}*/
}
