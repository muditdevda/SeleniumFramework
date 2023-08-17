package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class screenshot {
	private static WebDriver driver = DriverManager.getChromeDriver();
	private static Logger log = LogManager.getLogger(screenshot.class);
	private static String Screeshot_path = "src\\ScreensShotImage\\";
	
	
	public void TakeScreenshot(String fileName) throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File(Screeshot_path + fileName + ".jpg"));
		log.info("Take Screenshot Successfully");	
	}
	
}
