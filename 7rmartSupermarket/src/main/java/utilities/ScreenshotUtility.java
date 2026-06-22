package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public void getScreenShot(WebDriver driver, String failedtestcasename) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot is an interface. Its used to capture
															// screenshot. scrShot - ref. variable of the interface.
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //getScreenshotAs() belongs to TakesSceenshot interface,used to capture screenshot. Here, we store screenshot in temp file.
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//adds date and time to screenshot, using DateFormat class and Date class																							screenshot
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot");//creating a folder to store the captured screenshot. Foldername://outputScreenShot. 
		if (!f1.exists()) { //creates a folder if it does not exist
			f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedtestcasename + timeStamp
				+ ".png"; //decides final screenshot path, with all details required
		File finalDestination = new File(destination); // creating a final destination file to move the screenshot
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class to copy the screenshot from one location to other
	}
}
