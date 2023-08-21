package com.orange;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.actiondriver.Action;


import Utility.DriverManager;
import io.qameta.allure.Step;

public class login_page extends BasePage{
	
	private static Logger logger = LoggerFactory.getLogger(login_page.class);
	
	@FindBy(xpath ="//div[@class='orangehrm-login-branding']")
	WebElement HRMLogo;
	
	@FindBy(xpath ="//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
	private static WebElement LogInBtn;
	
	@FindBy(xpath ="//input[@name='username']")
	private static WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	private static WebElement password;
	
	public login_page() {
		super();
		PageFactory.initElements(getDriver(), this);
	}
	
//	public boolean validateLogo() throws InterruptedException {
//		return Action.isDisplayed(DriverManager.getChromeDriver(), HRMLogo);
//	}
//	
//	public String getHRMTitle() {
//		String HRMTitle=DriverManager.getChromeDriver().getTitle();
//		return HRMTitle;
//	}
//	
//	public void login(String uname, String pswd) throws InterruptedException {
//		Action.type(username, uname);
//		Action.type(password, pswd);
//		
//	}
	
	@Step("Enter Username(Email)")
	public void enterUser(String user) {
		logger.info("Logging on with user {}", user);
		username.sendKeys(user);
	}
	
	@Step("Enter Password")
	public void enterPassword(String string) {
		logger.info("password {}", "****");
		password.sendKeys(string);
	}

	@Step("Click the Login Button")
	public void clickLoginButton() {
		waitUntilClickable(LogInBtn).click();
	}
}
