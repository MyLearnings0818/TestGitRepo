package dataProvider;

import java.io.FileInputStream;
import java.util.Properties;


public class ConfigDataProvider {
	 Properties prop;
	
	public ConfigDataProvider(){
		try {
			FileInputStream configFile = new FileInputStream("./Configurations/config.properties");
			prop = new Properties();
			prop.load(configFile);
		} 
		catch (Exception e) {
			System.out.println("Error details: "+e.getMessage());
		}		
	}
	
	public  String getApplicationUrl() {
		String url=prop.getProperty("url");
		return url;
	}
	
	public  String getChromePath() {
		String chromePath = prop.getProperty("chromePath");
		return chromePath;
	}
	
	public  String getFirefoxPath() {
		String firefoxPath = prop.getProperty("firefoxPath");
		return firefoxPath;
	}
	
	public  String getChromeDriver() {
		String chromeProperty = prop.getProperty("chromeProperty");
		return chromeProperty;
	}
	
	public  String getFirefoxDriver() {
		String firefoxProperty = prop.getProperty("firefoxProperty");
		return firefoxProperty;
	}
	
	public  String getUsername() {
		String username=prop.getProperty("username");
		return username;
	}
	
	public  String getPassword() {
		String password=prop.getProperty("password");
		return password;
	}
			
}
