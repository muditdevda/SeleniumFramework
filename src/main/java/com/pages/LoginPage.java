package com.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.qameta.allure.Step;

public class LoginPage extends BasePage{
	
	private static Logger logger = LoggerFactory.getLogger(LoginPage.class);
	
	private static String HRMLogo ="//div[@class='oxd-brand-banner']";
	
	@FindBy(xpath ="//button[@type='submit']")
	private static WebElement LogInBtn;
	
	@FindBy(xpath ="//input[@name='username']")
	private static WebElement username;
	
	@FindBy(xpath ="//input[@name='password']")
	private static WebElement password;
	
	public LoginPage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}
	
	
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
	
	@Step("")
	public void doLogin(String user, String password) {
		logger.info("please enter username");
		enterUser(user);
		logger.info("please enter password");
		enterPassword(password);
		logger.info("click to login button");
		clickLoginButton();
		if(logVerify()==true) {
			logger.info("logging Successfully");
		}
		else {
			logger.info("Please enter vaild credentials");
		}
	}
	
	@Step("Logo Verify")
	public boolean logVerify() {
		return elementExists(HRMLogo);
	}
	
	public void waitForPageToLoad() {
		waitUntilClickable(username);
	}
}
