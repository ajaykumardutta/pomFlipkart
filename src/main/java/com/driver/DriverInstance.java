package com.driver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class DriverInstance {
	
	public static WebDriver driver;
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static ExtentHtmlReporter html;
	public static ExtentReports test;
	public static ExtentTest log;
	public File file;
	
	@BeforeTest
	public void beforeTestConfig(){
		System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		//reports initialization
		file = new File("AutomationReports.html");
		html = new ExtentHtmlReporter(new File(PROJECT_PATH + "//testreport//" + file));
		test = new ExtentReports();
		test.attachReporter(html);
		test.setSystemInfo("username", "testuser");
		test.setSystemInfo("OS", "windows");
		test.setSystemInfo("Environment", "test env");
		test.setSystemInfo("url", "flipkart url");
		
		//customize the report
		html.config().setDocumentTitle("Automation Title");
		html.config().setReportName("Regression Report");
		html.config().setTestViewChartLocation(ChartLocation.TOP);
		html.config().setTheme(Theme.STANDARD);		
	}
	
	
	@AfterTest
	public void afterTestConfig(){
		test.flush();
		driver.quit();
	}

}
