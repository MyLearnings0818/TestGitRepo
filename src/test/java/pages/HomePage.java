package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProvider.ExcelDataProvider;
import factory.BuildFactory;


public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	@FindBy(id="user_login") WebElement username;
	@FindBy(id="user_pass") WebElement password;
	@FindBy(xpath="//input[@id='wp-submit']") WebElement login;	
	@FindBy(xpath="//a[text()='Lost your password?']") WebElement forgotPassword;
	
	public void loginViaConfig() {
		username.sendKeys(BuildFactory.ConfigObject().getUsername());
		password.sendKeys(BuildFactory.ConfigObject().getPassword());
		login.click();
	}
	
	public void loginViaExcel() {
		username.sendKeys(BuildFactory.ExcelObject().getSheetData(0, 0, 0));
		password.sendKeys(BuildFactory.ExcelObject().getSheetData(0, 0, 1));
		login.click();
	}
	public String getApplicationTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public void forgotPassword() {
		forgotPassword.click();
	}
}
