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

	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; //TakesScreenshot capture the current situation of the browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE); //takes screenshot and stores it temporarily as a file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date()); //adds date and time to screenshot
		File f1 = new File(System.getProperty("user.dir") + "//outputScreenShot"); //Folder creation - foldername: outputScreenShot
		if (!f1.exists()) { // create a folder if it does not exist
			f1.mkdirs(); 
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
				+ ".png"; // decides final screenshot path, with all details required
		File finalDestination = new File(destination); //creating a final destination to move the screenshot
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class to copy the screenshot fromone location to other
	}
}
}