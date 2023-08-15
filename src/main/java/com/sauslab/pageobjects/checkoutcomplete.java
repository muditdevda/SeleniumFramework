/**
 * 
 */
package com.sauslab.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sauslab.actiondriver.Action;
import com.sauslab.base.BaseClass;

/**
 * @author user
 *
 */
public class checkoutcomplete extends BaseClass{
	@FindBy (xpath="//button[@name='back-to-products']")
	WebElement Back;
	
	@FindBy (xpath="//a[@class='shopping_cart_link']")
	WebElement cart;
	
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")
	WebElement menu;
	
	public checkoutcomplete() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public inventoryPage back() throws InterruptedException {
		Action.click(getDriver(), Back);
		return new inventoryPage();
	}
	
	public CartPage Cart() throws InterruptedException {
		Action.click(getDriver(), cart);
		return new CartPage();
	}
}
