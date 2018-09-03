package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.BuildFactory;

import pages.HomePage;
import utility.Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class TestHomePage {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	

	@BeforeMethod
	public void setUp() {
		report = new ExtentReports("./Reports/NewReport.html", true);
		logger=report.startTest("Driver to launch browser");
		driver = BrowserFactory.getBrowser("firefox");		
		driver.get(BuildFactory.ConfigObject().getApplicationUrl());
		logger.log(LogStatus.PASS, "Browser launched");
	}
	
	@Test
	public void testClicks() {
		HomePage hp=PageFactory.initElements(driver, HomePage.class);
		hp.loginViaConfig();	
		logger.log(LogStatus.PASS, "Excel data retrived and signIN successful");
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captuteScreenshot(driver, "validation")));
		
	}
	
	@AfterMethod
	public void exit(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			String path=Helper.captuteScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}
	
}
