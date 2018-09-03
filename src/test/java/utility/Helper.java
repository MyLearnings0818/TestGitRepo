package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {
	
	public static String captuteScreenshot(WebDriver driver, String screenshotname) {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String destFile = "/Users/my_appie_pie/Documents/Selenium/workspaceNew/selenium.hybrid.framework/Screenshots/"+screenshotname+System.currentTimeMillis()+".png";
		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			System.out.println("Error during capturing screenshot"+e.getMessage());
		}
		return destFile;
	}
}
