package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.driver.DriverInstance;

public class LandingPage extends DriverInstance{
	
	@FindBy (name = "q")
	public WebElement searchField;
	
	@FindBy (xpath = "//button[@type='submit']")
	public WebElement searchButton;
	
	@FindBy(xpath = "(//div[contains(text(), 'Samsung')])[2]")
	public WebElement firstOption;
	
	@FindBy(xpath = "//div[contains(text(), 'saravana')]")
	public WebElement nameField;

	public LandingPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	

}
