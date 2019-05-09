package com.test.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.driver.DriverInstance;
import com.pages.LandingPage;
import com.pages.LoginPage;
import com.utilities.Utilities;

public class Landing extends DriverInstance{
	
	
	private LoginPage loginPage;
	private LandingPage landigPage;
	private String resultText = "";
	private WebDriverWait wait;
	private Utilities util;
	
	
	@BeforeMethod
	public void beforeMethod(){
		driver.get("https://www.flipkart.com/");
		loginPage = new LoginPage();
		landigPage = new LandingPage();
		util = new Utilities();
		wait = new WebDriverWait(driver, 15); //exlicit wait
	}
	
	@Test
	public void searchObject(){
		log = test.createTest("========== searchObject ========");
		loginPage.loginApp();
		log.log(Status.INFO, "==== logging is successful");
		wait.until(ExpectedConditions.visibilityOf(landigPage.nameField));
		landigPage.searchField.sendKeys("samsung");
		util.click(By.xpath("//button[@type='submit']")); //customized
//		landigPage.searchButton.click();
		resultText = landigPage.firstOption.getText();
		log.log(Status.PASS, " test execution is complete");
		System.out.println("=============== search result first option is ===========" + resultText);
	}
	
	@AfterMethod
	public void afterMethod(){
		
		driver.close();
	}

}
