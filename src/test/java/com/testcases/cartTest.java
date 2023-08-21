package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageobjects.CartPage;
import com.pageobjects.checkoutstepone;
import com.pageobjects.inventoryPage;
import com.pageobjects.loginPage;

public class cartTest extends BaseClass {
	loginPage LoginPage;
	inventoryPage inventorypage;
	CartPage cartPage;
	checkoutstepone CHECK;
	
	@Parameters("browser")
	@BeforeMethod(groups ={"Smoke","Sanity","Regression"})
	public void setup(String browser) throws InterruptedException{
		launchApp(browser);
	}
	
	@AfterMethod(groups ={"Smoke","Sanity","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = "Sanity")
	public void carttest() throws InterruptedException {
		LoginPage = new loginPage();
		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		cartPage.getunitPrice();
		String actualText=cartPage.gettext1();
		String expectedText="$7.99";
		Assert.assertEquals(actualText, expectedText);
		
	}
	
	@Test(groups = "Sanity")
	public void carttest1() throws InterruptedException {
		LoginPage = new loginPage();
		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		cartPage.remove();	
		
	}
	
	@Test(groups = "Sanity")
	public void carttest2() throws InterruptedException {
		LoginPage = new loginPage();
		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		inventorypage=cartPage.ContinueShipping();
	}
	
	@Test(groups = "Smoke")
	public void carttest3() throws InterruptedException {
		LoginPage = new loginPage();
		inventorypage=LoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		inventorypage.selectFilter("Price (low to high)");
		inventorypage.clickOnAddToCart();
		cartPage=inventorypage.ShippingBtn();
		CHECK=cartPage.clickOnCheckOut();
	}
}
