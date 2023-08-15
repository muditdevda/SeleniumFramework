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
public class checkoutstepsecond extends BaseClass {
	@FindBy(xpath="//button[@name='finish']")
	WebElement Finish;
	
	@FindBy(xpath="//button[@name='cancel']")
	WebElement Cancel;
	
	@FindBy(xpath="//div[text()='Sauce Labs Onesie']")
	WebElement itemName;
	
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	WebElement total;
	
	public checkoutstepsecond() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public checkoutcomplete finish() throws InterruptedException {
		Action.click(getDriver(), Finish);
		return new checkoutcomplete();
	}
	
	public inventoryPage cancel() throws InterruptedException {
		Action.click(getDriver(), Cancel);
		return new inventoryPage();
	}
	
	public String gettext() throws InterruptedException {
		Action.click(getDriver(), itemName);
		String GetText=itemName.getText();
		return GetText;
	}
	
	public String gettotal() throws InterruptedException {
		Action.click(getDriver(), total);
		String GetText=total.getText();
		return GetText;
	}
	
}
