package Utility;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.stqa.selenium.factory.WebDriverPool;

public class DriverManager {
	private static WebDriver driver;
	private static PropertiesHelper ph = new PropertiesHelper();
	private static final String DRIVER_PATH = "src/resources/chromedriver_win32";
	
	public static WebDriver getChromeDriver() {
		if (ph.getBrowserName().equals("chrome")) {
			String fulldriverPath = "C:\\Users\\HP\\Downloads\\chromedriver_win32\\chromedriver.exe";
			if(System.getProperty("os.name").equalsIgnoreCase("linux")) {
				fulldriverPath = DRIVER_PATH + "linux/chromedriver.exe";
			}
			else if (System.getProperty("os.name").equalsIgnoreCase("windows")){
				fulldriverPath = DRIVER_PATH + "chromedriver_win32/chromedriver.exe";
			}
			System.setProperty("webdriver.chrome.driver", fulldriverPath);
		}
		return getDriverFromPool(getChromeOptions());
	}
	
	
	
	public static WebDriver getDriverFromPool(MutableCapabilities chromeOptions) {
		driver = WebDriverPool.DEFAULT.getDriver(chromeOptions);
		return driver;
	}
	
	public static void Url() {
		driver.get("https://amazon.in");
	}

	public static ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		options.addArguments("--remote-allow-origins=*");
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
