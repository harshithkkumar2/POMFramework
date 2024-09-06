package com.mystroe.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.mystroe.utility.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	public static Properties prop;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		this.initLogger();
		this.loadConfig();
		ExtentManager.setExtent();
	}
	
	public void loadConfig() {
		try {
			Baseclass.prop = new Properties();
			String configPath = System.getProperty("user.dir") + "\\Configuration\\Config.properties";
			FileInputStream fis = new FileInputStream(configPath);
			Baseclass.prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void initLogger() {
		DOMConfigurator.configure("log4j.xml");
	}
	
	public void launchBrowser(String browserName) {
		//String browserName = Baseclass.prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		}else if(browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		}else if (browserName.equalsIgnoreCase("ie")) {
			WebDriverManager.edgedriver().setup();
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		getDriver().navigate().to(prop.getProperty("url"));
	}
	
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	@AfterSuite(groups = {"Smoke","Sanity","Regression"})
	public void afterSuite() {
		ExtentManager.endReport();
	}

}
