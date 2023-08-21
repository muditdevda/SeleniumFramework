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

public class loginPage extends BaseClass{
	@FindBy(xpath ="//input[@name='user-name']")
	WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath ="//input[@name='login-button']")
	WebElement LogInBtn;
	
	@FindBy(xpath ="//div[@class='bot_column']")
	WebElement SausLogo;
	
	public loginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateLogo() throws InterruptedException {
		return Action.isDisplayed(getDriver(), SausLogo);
	}
	
	public String getSauslabTitle() {
		String sauslabTitle=getDriver().getTitle();
		return sauslabTitle;
	}
	
	public inventoryPage login(String uname, String pswd) throws InterruptedException {
		Action.type(username, uname);
		Action.type(password, pswd);
		Action.click(getDriver(), LogInBtn);
		return new inventoryPage();
	}
	
	
}
