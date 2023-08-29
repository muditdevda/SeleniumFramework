package com.orange;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.HomePage;
import com.selenium.DriverManager;

import Utility.Loginer;

public class LoginTest {

	Logger log = LogManager.getLogger(LoginTest.class);
	private static final Loginer loginer = new Loginer();
	
	@BeforeTest 
	public void setup() {
		DriverManager.createDriver("LoginTest");
	}

	@Test
	public void firstTest() throws IOException {
		HomePage homePage = loginer.doLoginAsPM();
//		new LoginPage().doLogin("Admin", "admin123");
		System.out.println("hello");
	}
	
	@AfterTest
	public static void teardown() {
		loginer.forceLogout();
		DriverManager.dismissDriver();
	}
}