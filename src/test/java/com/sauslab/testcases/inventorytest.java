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
import com.sauslab.pageobjects.CartPage;
import com.sauslab.pageobjects.inventoryPage;
import com.sauslab.pageobjects.loginPage;

/**
 * @author Lenovo
 *
 */
public class inventorytest extends BaseClass {
	loginPage LoginPage;
	inventoryPage inventorypage;
	CartPage cartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups ={"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		launchApp(browser);
	}
	
	
	@AfterMethod(groups ={"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void addtocart() throws InterruptedException {
		LoginPage = new loginPage();
		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		String actualText=cartPage.gettext();
		String expectedText="Sauce Labs Onesie";
		Assert.assertEquals(actualText, expectedText);
		
	}
}
