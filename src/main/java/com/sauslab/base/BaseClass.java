/**
 * 
 */
package com.sauslab.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.sauslab.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author user
 *
 */
public class BaseClass {
	public static Properties prop;
	// Declare ThreadLocal Driver
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups ={"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		DOMConfigurator.configure("Logs/log4j.xml");
	}
	
	public static WebDriver getDriver() {
	// Get Driver from threadLocalmap
	return driver.get();
	}
	@BeforeTest(groups ={"Smoke","Sanity","Regression"})
	public void loadConfig() {
		
		try {
			prop = new Properties();
			System.out.println("super constructor invoked");
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);
			System.out.println("driver: "+driver);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void launchApp(String browserName) throws InterruptedException{
//		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			Set Browser To ThreadLocalMap
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		getDriver().manage().window().maximize();
		Action.implicitWait(getDriver(), 30);
		Action.pageLoadTimeOut(getDriver(),30);
		getDriver().get(prop.getProperty("url"));
	}
}
