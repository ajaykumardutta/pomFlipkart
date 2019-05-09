package com.test.scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.driver.DriverInstance;
import com.pages.LoginPage;

public class Login extends DriverInstance{
	
	//declare variables
	LoginPage loginObject;
	
	@BeforeMethod
	public void beforeMethod(){
		driver.get("https://www.flipkart.com/");
		loginObject = new LoginPage();
	}
	
/*	@Test
	public void loginApp(){
		loginObject.username.sendKeys("9489134116");
		loginObject.password.sendKeys("9489134116");
		loginObject.login.click();
	}*/
	
	@AfterMethod
	public void afterMethod(){
		driver.close();
	}

}
