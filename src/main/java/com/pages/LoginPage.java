package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.DriverInstance;

public class LoginPage extends DriverInstance{
	
	//declaration and definition
	@FindBy (xpath = "(//input[@type='text'])[2]")
	public WebElement username;
	
	@FindBy (xpath = "//input[@type='password']")
	public WebElement password;
	
	@FindBy(xpath = "(//span[contains(text(), 'Login')])[last()]")
	public WebElement login;

	//initializing the weblements
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//login page method login into flipkart
	public void loginApp(){
		username.sendKeys("9489134116");
		password.sendKeys("9489134116");
		login.click();
	}
	
}
