package com.mystroe.utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.mystore.actiondriver.ActionDriver;
import com.mystroe.base.Baseclass;

public class ListenerClass  extends ExtentManager implements ITestListener {

	ActionDriver action= new ActionDriver();
	public ExtentTest test;
	public ExtentTest node;
	private static ThreadLocal<ExtentTest> extentText = new ThreadLocal<ExtentTest>();
	private static ThreadLocal<ExtentTest> extentNode = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		System.out.println("Result name is :"+result.getStatus());
		test = extent.createTest(result.getName());
		extentText.set(test);
		node = test.createNode("Node");
		extentNode.set(node);
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Result status is :"+result.getStatus());
		if (result.getStatus() == ITestResult.SUCCESS) {
			extentText.get().log(Status.PASS, 
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			extentNode.get().log(Status.PASS, 
					MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
			String imgPath = action.screenShot(Baseclass.getDriver(), result.getName());
			extentText.get().pass("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			extentNode.get().pass("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
		
		}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Result status is :"+result.getStatus());
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				extentText.get().log(Status.FAIL,
						MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
				extentText.get().log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = action.screenShot(Baseclass.getDriver(), result.getName());
				extentText.get().fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			extentText.get().log(Status.SKIP, "Skipped Test case is: " + result.getName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
