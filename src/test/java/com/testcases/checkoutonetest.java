/**
 * 
 */
package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.dataprovider.DataProviders;
import com.pageobjects.CartPage;
import com.pageobjects.checkoutstepone;
import com.pageobjects.checkoutstepsecond;
import com.pageobjects.inventoryPage;
import com.pageobjects.loginPage;

/**
 * @author Lenovo
 *
 */
public class checkoutonetest extends BaseClass{
	loginPage LoginPage;
	inventoryPage inventorypage;
	CartPage cartPage;
	checkoutstepone CHECK;
	checkoutstepsecond C2;
	
	@Parameters("browser")
	@BeforeMethod(groups ={"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		launchApp(browser);
	}
	
	@AfterMethod(groups ={"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider  = "credentials", dataProviderClass = DataProviders.class, groups = "Regression")
	public void CO1(String username , String password) throws InterruptedException {
		LoginPage = new loginPage();
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
	}
	
	@Test(dataProvider  = "email", dataProviderClass = DataProviders.class, groups = {"Smoke","Regression"})
	public void CO2(String username , String password,String FirstName,String LastName,String PostalCode) throws InterruptedException {
		LoginPage = new loginPage();
//		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage=LoginPage.login(username,password);
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
//		C2=CHECK.checkoutStep("FirstName", "LastName", "PostalCode");
		C2=CHECK.checkoutStep(FirstName, LastName, PostalCode);
		
	}
}
