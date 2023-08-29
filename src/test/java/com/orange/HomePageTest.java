package com.orange;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.selenium.DriverManager;

import Utility.Loginer;

public class HomePageTest {

	Logger logger = LoggerFactory.getLogger(HomePageTest.class);
	private static HomePage homepage = new HomePage();
	
	@BeforeMethod 
	public void setup() {
		logger.info("--------> Starting test (@BeforeAll) - PMPortalMenuTest <--------");
		DriverManager.createDriver("HomePageTest");
		new Loginer();
		homepage = Loginer.doLoginAsPM();
	}
	
	@Test
	public void clickToAdmin() {
		homepage.clickToAdmin();
	}
	
	@Test
	public void getNameOrangeDashboard() {
		List<WebElement> dashboardnames = homepage.countDashboardWeightName();
		for (WebElement Dashboardname: dashboardnames) {
			String DashboardLinkName = Dashboardname.getText();
			logger.info("DashboardNames {}",DashboardLinkName);
		}
	}
	
	@Test
	public void getNameNavigation() {
		List<WebElement> navigationnames = homepage.NabvigationName();
		for (WebElement Navigationname: navigationnames) {
			String NavigationLinkName = Navigationname.getText();
			logger.info("NavigationNames {}",NavigationLinkName);
		}
	}
	
	@AfterMethod
	public static void teardown() {
		homepage.ClickLogout();
		DriverManager.dismissDriver();
	}

}
