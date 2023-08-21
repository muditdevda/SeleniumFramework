package com.testcases;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.orange.login_page;

import Utility.DriverManager;

public class hrm_login_test{
	private static login_page logpage = new login_page();
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(hrm_login_test.class);
	
	
//	@BeforeTest
//	public void setup() throws InterruptedException{
////		System.out.println("print");
////		DriverManager.getChromeDriver();
////		DriverManager.Url("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		LOGGER.info("--------> Starting test (@BeforeAll) - AdminPortalTest<--------");
//		DriverManager.createDriver("hrm_login_test");
//	}
	
//	@Test
//	public void verifyTitle() {
//		String actTitle= logpage.getHRMTitle();
//		Assert.assertEquals(actTitle, "OrangeHRM");
//	}
//	
//	@Test
//	public void signup() throws InterruptedException {
//		logpage.login("Admin", "admin123");
//	}
	
	@BeforeAll
	public static void setup() {
		logger.info("--------> Starting test (@BeforeAll) - LoginTest <--------");
		DriverManager.createDriver("LoginTest");
	}

	@BeforeEach
	public void before(TestInfo testInfo) {
		logger.info("************ Starting test" + testInfo.getDisplayName() + "************");
	}
	
	@Test
	public void url() {
		DriverManager.Url("https://amazon.in");
	}
	
	@AfterTest
	public void tearDown() {
		DriverManager.getChromeDriver().quit();
	}
}
