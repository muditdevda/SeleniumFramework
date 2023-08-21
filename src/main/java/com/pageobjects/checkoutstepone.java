package com.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actiondriver.Action;
import com.base.BaseClass;

public class checkoutstepone extends BaseClass {
	@FindBy(xpath="//input[@name='firstName']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@name='lastName']")
	WebElement LastName;
	
	@FindBy(xpath="//input[@name='postalCode']")
	WebElement PostalCode;
	
	@FindBy(xpath="//input[@name='continue']")
	WebElement Continue;
	
	@FindBy(xpath="//button[@name='cancel']")
	WebElement Cancel;
	
	public checkoutstepone() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public checkoutstepsecond checkoutStep(String Fname,String Lname, String Pcode) throws InterruptedException {
		Action.type(FirstName,Fname);
		Action.type(LastName,Lname);
		Action.type(PostalCode,Pcode);
		Action.click(getDriver(), Continue);
		return new checkoutstepsecond();
	}
}
