package com.Mohs10.utility;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class TestallureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object driverAttribute = result.getTestContext().getAttribute("driver");

        if (driverAttribute instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driverAttribute;
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);

            String screenshotPath = "./failed_screenshots/" + result.getName() + ".png";

            try {
                Files.move(screenshot.toPath(), new File(screenshotPath).toPath());
                attachScreenshotToAllure(screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Driver attribute is null or not an instance of TakesScreenshot.");
        }
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] attachScreenshotToAllure(String screenshotPath) {
        try {
            return Files.readAllBytes(new File(screenshotPath).toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}

