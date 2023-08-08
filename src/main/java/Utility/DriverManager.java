package Utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.stqa.selenium.factory.WebDriverPool;

public class DriverManager {
	private static WebDriver driver;
//	private static PropertiesHelper ph = new PropertiesHelper();
	private static final String DRIVER_PATH = "src/resources/driver/win";
	
	public static WebDriver getChromeDriver() {
		
		if (new PropertiesHelper().getBrowserName()=="chrome") {
			String fulldriverPath = null;
			if(System.getProperty("os.name").equalsIgnoreCase("linux")) {
				fulldriverPath = DRIVER_PATH + "linux/chromedriver.exe";
			}
			else if (System.getProperty("os.name").equalsIgnoreCase("windows")){
				fulldriverPath = DRIVER_PATH + "win/chromedriver.exe";
			}
			System.setProperty("webdriver.chrome.driver", fulldriverPath);
		}
		return getDriverFromPool(getChromeOptions());
	}
	
	private static WebDriver getDriverFromPool(MutableCapabilities chromeOptions) {
		driver = WebDriverPool.DEFAULT.getDriver(chromeOptions);
		return driver;
	}

	private static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--start-maximized");
		options.addArguments("--disable-extensions");
		options.addArguments("--disable-gpu");
		Map<String, Object> prefrence = new HashMap<>();
		prefrence.put("download.default_directory", "/home/selenium/Downloads");
		prefrence.put("download.prompt_for_download", false);
		prefrence.put("safebrowsing.enabled", false);
		options.setExperimentalOption("prefs", prefrence);
		
		return options;
		
	}
	
	
}
