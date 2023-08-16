/**
 * 
 */
package com.sauslab.testcases;

import org.testng.Assert;
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

/**
 * @author Lenovo
 *
 */
public class checkoutsecondtest extends BaseClass {
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
	
	
	@Test(dataProvider  = "email", dataProviderClass = DataProviders.class,groups = {"Smoke","Regression"})
	public void CH_1(String username , String password,String FirstName,String LastName,String PostalCode) throws InterruptedException {
		LoginPage = new loginPage();
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
		C2=CHECK.checkoutStep(FirstName, LastName, PostalCode);
		String actualText=C2.gettotal();
		String expectedText="Total: $8.63";
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	
	@Test(dataProvider  = "email", dataProviderClass = DataProviders.class, groups = {"Smoke","Regression"})
	public void CH_2(String username , String password,String FirstName,String LastName,String PostalCode) throws InterruptedException {
		LoginPage = new loginPage();
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
//		C2=CHECK.checkoutStep("FirstName", "LastName", "PostalCode");
		C2=CHECK.checkoutStep(FirstName, LastName, PostalCode);
		inventorypage=C2.cancel();
	}
	
	
	@Test(dataProvider  = "email", dataProviderClass = DataProviders.class, groups = {"Smoke","Regression"})
	public void CH_3(String username , String password,String FirstName,String LastName,String PostalCode) throws InterruptedException {
		LoginPage = new loginPage();
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
//		C2=CHECK.checkoutStep("FirstName", "LastName", "PostalCode");
		C2=CHECK.checkoutStep(FirstName, LastName, PostalCode);
		CC=C2.finish();
	}
}
