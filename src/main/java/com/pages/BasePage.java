package com.pages;
import static com.selenium.FlowNavigateToHelper.navigateTo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.pages.LoginPage;
import com.selenium.DriverManager;
import com.selenium.JSExecutor;
import com.selenium.NoStaleWait;
import com.selenium.PropertiesHelper;
import com.selenium.WaitBuilder;

import io.qameta.allure.Step;


public class BasePage extends DriverManager {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BasePage.class);
	private static final JSExecutor jse = new JSExecutor();
	protected static PropertiesHelper propertiesHelper = new PropertiesHelper();
	private static NoStaleWait noStaleWait ;
	
	public JSExecutor getJse() {
		return jse;
	}
	
	
	protected static NoStaleWait getDriverWait() {
		noStaleWait = WaitBuilder.buildNoStaleWait();
		return noStaleWait;
	}
	
	@Step("Wait until Clickable")
	public WebElement waitUntilClickable(WebElement ele) {
		return getDriverWait().waitUntilClickable(ele);
	}
	
	@Step("Wait until Clickable")
	protected WebElement waitUntilClickable(By by) {
		LOGGER.info("***** waitUntilClickable *****");
		LOGGER.info(by.toString());
		return getDriverWait().waitUntilClickable(by);
	}
	
	@Step("Wait until presence")
	protected WebElement waitUntilPresence(By by) {
		return getDriverWait().until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public List<WebElement> findElements(By by) {
		try {
			return getDriver().findElements(by);
		} catch (TimeoutException e) {
			return getDriver().findElements(by);
		}
	}

	
	@Step("Navigate to login")
	public void navigateToLogin() {
		getDriver().manage().deleteAllCookies();
		String logInAddress = propertiesHelper.getURL();
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		navigateTo(logInAddress);
	}
	
	
	
	public static boolean waitException(int miliSecs) {
		try {
			// see https://bugs.chromium.org/p/chromedriver/issues/detail?id=2198
			Thread.sleep(miliSecs);
		} catch (InterruptedException e) {
			// Restore interrupted state...
			Thread.currentThread().interrupt();
			return false;
		}
		return true;
	}
	
	@Step("returns true if the element exist (Xpath)")
	public boolean elementExists(String xpath) {
		return elementExists(xpath, 0);
	}
	
	
	public boolean elementExists(String xpath, int time) {
		WebDriver driver = DriverManager.getDriver();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		boolean exists = !driver.findElements(By.xpath(xpath)).isEmpty();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(propertiesHelper.getWaitTimeout()));
		return exists;
	}
	
	@Step("Navigate to dashboard")
	public void navigateToDashBoard() {
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		navigateTo(propertiesHelper.getURL());
	}
	
	@Step("Force log out")
	public void forceLogout() {
		String logOutAddress = propertiesHelper.logoutURL();
		LOGGER.info("logging out using address {} ", logOutAddress);
		navigateTo(logOutAddress);
		LoginPage lp = new LoginPage();
		lp.waitForPageToLoad();
		LOGGER.info("logging out successful");
	}


}
