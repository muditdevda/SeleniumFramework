package com.pages;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class HomePage extends BasePage{

	Logger log = LogManager.getLogger(HomePage.class);
	private static final String Admin_Xpath = "//span[text()='Admin']";
	private static final String Dropdown_Xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
	private static final String Dashboard_Name = "//div[@class='orangehrm-dashboard-widget-name']";
	private static final String Navigation_Name = "//nav[@role='navigation']";
	
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutbtn;
	
	public HomePage() {
		super();
		PageFactory.initElements(getDriver(), this);
	}
	
	@Step("Clicking on the Admin")
	public void clickToAdmin() {
		waitUntilClickable(By.xpath(Admin_Xpath)).click();
	}
	
	@Step("Clicking on the Dropdown")
	public void clickToDropdown() {
		waitUntilClickable(By.xpath(Dropdown_Xpath)).click();
	}
	
	@Step("Counting Dashboard Name")
	public List<WebElement> countDashboardWeightName() {
		waitUntilPresence(By.xpath(Dashboard_Name));
		getJse().executeJS("window.scrollBy(0,-1000)");
		return findElements(By.xpath(Dashboard_Name));
	}
	
	@Step("Counting Navigaion Name")
	public List<WebElement> NabvigationName() {
		waitUntilPresence(By.xpath(Navigation_Name));
		getJse().executeJS("window.scrollBy(0,-1000)");
		return findElements(By.xpath(Navigation_Name));
	}
	
	@Step("Clicking on the Logout")
	public void ClickLogout() {
		clickToDropdown();
		waitUntilClickable(logoutbtn).click();
	}
}
