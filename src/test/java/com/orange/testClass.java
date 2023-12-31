package com.orange;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.DriverManager;
import com.selenium.screenshot;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class testClass {
	Logger log = LogManager.getLogger(testClass.class);
	private static screenshot SC = new screenshot();
	
	@BeforeTest 
	public void setup() {
		System.out.println("print");
		DriverManager.getChromeDriver();
	}

	@Test(description = "verify screenshot test")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description : verfiy Screenshot test")
	@Story("Story Name: check screenshot")
	public void firstTest() throws IOException {
		DriverManager.Url("https://amazon.in");
		log.info("Browser Start Successfully");
		log.debug("for debug");
		log.error("error message");
		log.warn("warning message");
		SC.TakeScreenshot("amazon");
		log.info("Browser Stop Successfully");
	}
	

}
