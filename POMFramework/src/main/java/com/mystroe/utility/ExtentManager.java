package com.mystroe.utility;

import java.time.LocalDateTime;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.mystroe.base.Baseclass;

public class ExtentManager {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	
	public static void setExtent() {
		try {
			htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport_"+LocalDateTime.now().getNano()+".html").viewConfigurer()
				    .viewOrder()
				    .as(new ViewName[] {  ViewName.DASHBOARD, 
				    		   ViewName.TEST,
				    		   ViewName.LOG,
				    		   ViewName.AUTHOR, 
				    		   ViewName.DEVICE, 
				    		   ViewName.EXCEPTION, 
				    		   ViewName.CATEGORY  })
				  .apply();;
			//htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
			htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
			//htmlReporter.config().setDocumentTitle("Automation Test Report");
			//htmlReporter.config().setReportName("OrangeHRM Test Automation Report");
			//htmlReporter.config().setTheme(Theme.DARK);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "MyHost");
		extent.setSystemInfo("ProjectName", "MyStoreProject");
		extent.setSystemInfo("Tester", "Harshit");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Chrome");
	}
	public static void endReport() {
		extent.flush();
	}
	
}
