package com.utilities;

import org.openqa.selenium.By;
import com.driver.DriverInstance;

public class Utilities extends DriverInstance{
	
	public boolean click(By locator){
		if(driver.findElements(locator).size() > 0 && driver.findElement(locator).isEnabled()){
			driver.findElement(locator).click();
			return true;
		}
		else
			return false;
	}
}
