package testscript;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import constant.Constant;
import utilities.ScreenshotUtility;
import utilities.WaitUtility;

public class Base {
	public WebDriver driver;
	public Properties properties;
	public FileInputStream fileinput;

	@BeforeMethod(alwaysRun=true)//executes regardless of grouping in XML
	@Parameters("browser")
	public void browserInitialization(@Optional("Chrome") String browser) throws Exception {
		if (browser.equalsIgnoreCase("Chrome")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else {
			throw new Exception("invalid");
		}
		try {
			properties = new Properties();
			fileinput = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fileinput);
		} catch (Exception e) {
			System.out.println(e);
		}
		//driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url")); // url given in config.properties
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICITWAIT));
		driver.manage().window().maximize();
	}
	//@AfterMethod(alwaysRun=true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenshotUtility scrShot = new ScreenshotUtility(); // creating obj
			scrShot.getScreenShot(driver, iTestResult.getName());
		}
		if (driver!=null) {
			driver.quit();
		}
	}

}