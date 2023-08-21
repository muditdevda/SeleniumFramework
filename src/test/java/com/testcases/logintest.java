/**
 * 
 */
package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.dataprovider.DataProviders;
import com.pageobjects.inventoryPage;
import com.pageobjects.loginPage;
import com.utility.Log;

/**
 * @author user
 *
 */
public class logintest extends BaseClass {
	loginPage LoginPage;
	inventoryPage inventorypage;
	@Parameters("browser")
	@BeforeMethod(groups ={"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		launchApp(browser);
	}
	
	@AfterMethod(groups ={"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
//	@Test
//	public void verifyLogo() throws InterruptedException {
//		LoginPage = new loginPage();
//		boolean result=LoginPage.validateLogo();
//		Assert.assertTrue(result);
//	}
	@Test(groups = "Smoke")
	public void verifyTitle() {
		String actTitle=LoginPage.getSauslabTitle();
		Assert.assertEquals(actTitle, "Swag Labs");
	}
	
	@Test(dataProvider  = "credentials", dataProviderClass = DataProviders.class, groups = {"Smoke","Regression"})
	public void loginTest(String username , String password) throws InterruptedException {
		Log.startTestCase("loginTest");
		LoginPage = new loginPage();
		Log.info("Enter UserName and Password");
		Log.info("user is going to click on Login");
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		String actualURL=inventorypage.getCurrURL();
		String expectedURL="https://www.saucedemo.com/inventory.html";
		Log.info("Verifying if user is able to login");
		Assert.assertEquals(actualURL, expectedURL);
		Log.info("Login is Success");
		Log.endTestCase("loginTest");
	}

	
}
