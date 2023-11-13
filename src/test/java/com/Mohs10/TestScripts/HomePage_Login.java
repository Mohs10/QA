package com.Mohs10.TestScripts;

import java.util.Properties;

import org.testng.annotations.Test;

import com.Mohs10.Base.ScreenRecorderUtil;
import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;
import com.Mohs10.Functions.CommonFuns;
import com.Mohs10.utility.Log;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class HomePage_Login extends StartBrowser {
	Properties prop;
	String excelfile = "C:\\Users\\Dell\\Desktop\\Deepika\\Grid\\pAInITe\\ExcelTestInputData\\TestData.xlsx";
	String excelsheet = "Login";
	String exsheet2 = "NegativeLogin";

	@Test(priority = 0 ,description="Login Test")
	@Severity(SeverityLevel.NORMAL)    
    @Description("Clicking on news button........")
    @Epic("EP001")
    @Feature("Feature1: Login")
    @Story("Story:Login Presence")
    @Step("Verify Login Presence")
	public void LoginTestCase() throws Exception {
		ScreenRecorderUtil.startRecord("LoginTestCase");
		Log.startTestCase("---------------------------------Positive Login Test Case---------------------------------");
		Log.info("-----------This TC Will login with correct credentials-----------");
		CommonFuns hm1 = new CommonFuns();

		String Email = XLUtils.getStringCellData(excelfile, excelsheet, 1, 0);
		String Pwd = XLUtils.getStringCellData(excelfile, excelsheet, 1, 1);

		hm1.logIn(Email, Pwd);
		Thread.sleep(5000);
		Log.endTestCase("---------------------------------End of Positive Login Test Case---------------------------------");
		ScreenRecorderUtil.stopRecord();
	}

	@Test(priority = 1 ,description="Negative Login Test")
	@Severity(SeverityLevel.NORMAL)    
    @Description("Clicking on news button........")
    @Epic("EP002")
    @Feature("Feature1: Neg Login")
    @Story("Story:Neg Login Presence")
    @Step("Verify Neg Login Presence")
	public void NegativeLoginTest() throws Throwable {
		ScreenRecorderUtil.startRecord("NegativeLoginTest");
		CommonFuns hm2 = new CommonFuns();

		int rowcount = XLUtils.getRowCount(excelfile, exsheet2);
		for (int i = 1; i < rowcount; i++) {
			String Email = XLUtils.getStringCellData(excelfile, exsheet2, i, 0);
			String Pwd = XLUtils.getStringCellData(excelfile, exsheet2, i, 1);

			hm2.invalidLogIn(Email, Pwd);
			Thread.sleep(5000);
			ScreenRecorderUtil.stopRecord();
		}

	}
}