package utility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {
	public static void takeScreenShot(WebDriver driver, String name) throws IOException {

		TakesScreenshot sc = ((TakesScreenshot) driver);

		File source = sc.getScreenshotAs(OutputType.FILE);

		File destination = new File("D:\\projects\\workspace\\KiteZerodha1\\ScreenShot.jpg");
		FileHandler.copy(source, destination);
	}

	 
		
	}

	
	

	
		
	


