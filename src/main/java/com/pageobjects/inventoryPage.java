/**
 * 
 */
package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;
import com.base.BaseClass;

/**
 * @author user
 *
 */
public class inventoryPage extends BaseClass {
	@FindBy(xpath="//button[@name='add-to-cart-sauce-labs-onesie']")
	WebElement AddToCart;
	
	@FindBy(xpath="//select[@class='product_sort_container']")
	WebElement filter;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	WebElement shipping;
	
	
	
	public inventoryPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void selectFilter(String filter1) throws InterruptedException {
		Action.selectByVisibleText(filter1, filter);
	}
	
	public void clickOnAddToCart() throws InterruptedException {
		Action.click(getDriver(), AddToCart);
	}
	
	public CartPage ShippingBtn() throws InterruptedException {
		Action.click(getDriver(), shipping);
		return new CartPage();
	}
	
	public String getCurrURL() {
		String inventorypageURL=getDriver().getCurrentUrl();
		return inventorypageURL;
	}
	
	
}
