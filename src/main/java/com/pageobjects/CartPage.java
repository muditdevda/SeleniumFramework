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
public class CartPage extends BaseClass {
	@FindBy(xpath="//div[@class='inventory_item_price']")
	WebElement unitPrice;
	
	@FindBy(xpath="//button[@class='btn btn_action btn_medium checkout_button']")
	WebElement checkOut;
	
	@FindBy(xpath="//button[@class='btn btn_secondary back btn_medium']")
	WebElement contineShipping;
	
	@FindBy(xpath="//button[@class='btn btn_secondary btn_small cart_button']")
	WebElement reMove;
	
	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	WebElement itemName;
	
	public CartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getunitPrice() {
		String unitPrice1=unitPrice.getText();
		String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public checkoutstepone clickOnCheckOut() throws InterruptedException {
		Action.click(getDriver(), checkOut);
		return new checkoutstepone();
	}
	
	public void remove() throws InterruptedException {
		Action.click(getDriver(), reMove);
	}
	
	public inventoryPage ContinueShipping() throws InterruptedException {
		Action.click(getDriver(), contineShipping);
		return new inventoryPage();
	}
	
	public String gettext() throws InterruptedException {
		Action.click(getDriver(), itemName);
		String GetText=itemName.getText();
		return GetText;
	}
	

	public String gettext1() throws InterruptedException {
		Action.click(getDriver(), unitPrice);
		String GetText1=unitPrice.getText();
		return GetText1;
	}
}
