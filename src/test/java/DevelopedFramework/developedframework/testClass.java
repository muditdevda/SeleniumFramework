package DevelopedFramework.developedframework;
import java.io.File;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;
import Utility.DriverManager;

public class testClass {
	Logger log = LogManager.getLogger(testClass.class);
	private static WebDriver driver;
	@BeforeTest 
	public void setup() {
		System.out.println("print");
		driver = DriverManager.getChromeDriver();
		DriverManager.Url();
		log.info("Browser Start Successfully");
		log.debug("for debug");
		log.error("error message");
		log.warn("warning message");
	}

	@Test
	public void firstTest() throws IOException {
		File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Files.copy(f,new File("D:\\NIkhlesh_Ruby\\SeleniumFramework\\src\\ScreensShotImage\\amazonscreenshot.jpg"));
		log.info("Browser Stop Successfully");
	}
	

}
