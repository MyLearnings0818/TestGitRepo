package factory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class BrowserFactory {		
		
public static WebDriver driver;
		
		public static WebDriver getBrowser(String browser) {
			
			if(browser.equalsIgnoreCase("Chrome")) {		
				System.setProperty("webdriver.chrome.driver", "./lib/chromedriver");
				driver = new ChromeDriver();
			}			
			else if(browser.equalsIgnoreCase("Firefox")) {			
				System.setProperty(BuildFactory.ConfigObject().getFirefoxDriver(), BuildFactory.ConfigObject().getFirefoxPath());
				driver=new FirefoxDriver();
			}			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;	
		}
		
		
		public static void closeBrowser(WebDriver ldriver) {
			ldriver.quit();
		}
				
	}
