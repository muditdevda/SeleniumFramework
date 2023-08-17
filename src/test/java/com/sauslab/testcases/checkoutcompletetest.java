/**
 * 
 */
package com.sauslab.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sauslab.base.BaseClass;
import com.sauslab.dataprovider.DataProviders;
import com.sauslab.pageobjects.CartPage;
import com.sauslab.pageobjects.checkoutcomplete;
import com.sauslab.pageobjects.checkoutstepone;
import com.sauslab.pageobjects.checkoutstepsecond;
import com.sauslab.pageobjects.inventoryPage;
import com.sauslab.pageobjects.loginPage;
import com.sauslab.utility.Log;

/**
 * @author Lenovo
 *
 */
public class checkoutcompletetest extends BaseClass {
	loginPage LoginPage;
	inventoryPage inventorypage;
	CartPage cartPage;
	checkoutstepone CHECK;
	checkoutstepsecond C2;
	checkoutcomplete CC;

	
	@Parameters("browser")
	@BeforeMethod(groups ={"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		launchApp(browser);
	}
	
	@AfterMethod(groups ={"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider  = "email", dataProviderClass = DataProviders.class, groups = "Sanity")
	public void CH_1(String username , String password,String FirstName,String LastName,String PostalCode) throws InterruptedException {
		Log.startTestCase("loginTest");
		LoginPage = new loginPage();
		Log.info("Enter UserName and Password");
		Log.info("user is going to click on Login");
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		Log.info("Login is Success");
		Log.endTestCase("loginTest");
		Log.startTestCase("addtocart");
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		Log.info("addtocart is Success");
		Log.endTestCase("addtocart");
		Log.startTestCase("CH_1");
		CHECK=cartPage.clickOnCheckOut();
		C2=CHECK.checkoutStep(FirstName, LastName, PostalCode);
		CC=C2.finish();
		inventorypage=CC.back();
		cartPage=CC.Cart();
		Log.info("CH_1 is Success");
		Log.endTestCase("CH_1");
		
	}
	
	
	
	
	
	
	
}
