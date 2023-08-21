package com.orange;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.orange.*;
import com.selenium.JSExecutor;

import Utility.DriverManager;
import Utility.PropertiesHelper;
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

	
	@Step("Navigate to login")
	public void navigateToLogin() {
		getDriver().manage().deleteAllCookies();
		String logInAddress = propertiesHelper.getURL() + "/login.jsp";
		getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
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

}
