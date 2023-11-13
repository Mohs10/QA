package com.Mohs10.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {

	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static void setExtent() throws Throwable {
		htmlReporter= new ExtentSparkReporter(System.getProperty("user.dir")+"./Reports/ExtentReport.html");
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("DWS Test Automation Report");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("HostName", "Mohs10");
		extent.setSystemInfo("ProjectName", "Demo Web Shop Project");
		extent.setSystemInfo("Tester", "Deepika");
		extent.setSystemInfo("OS", "Win10");
		extent.setSystemInfo("Browser", "Multiple browser");
	}
	public static void endReport() {
		extent.flush();
	}
	
}
