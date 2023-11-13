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

public class Register_Test extends StartBrowser
{
	Properties prop;
	String excelfile = "C:\\Users\\Dell\\Desktop\\Deepika\\painite_copy\\pAInITe\\ExcelTestInputData\\TestData.xlsx";
	String xlsheet = "Register";
	
	@Test(priority = 0 ,description="Register Test")
	@Severity(SeverityLevel.NORMAL)    
    @Description("Entering data into Textboxes........")
    @Epic("EP002")
    @Feature("Feature1: Register")
    @Story("Story:Register Presence")
    @Step("Verify Register Presence")
	public void UserregisterTestCase() throws Exception {
		ScreenRecorderUtil.startRecord("RegisterTestCase");
		Log.startTestCase("---------------------------------Register Test Case with positive values---------------------------------");
		Log.info("-----------This TC Will register with correct credentials-----------");
		CommonFuns hm1 = new CommonFuns();

		String Fname = XLUtils.getStringCellData(excelfile, xlsheet, 1, 0);//(rows, columns) 
		String Lname = XLUtils.getStringCellData(excelfile, xlsheet, 1, 1);
		String Email = XLUtils.getStringCellData(excelfile, xlsheet, 1, 2);
		String pwd = XLUtils.getStringCellData(excelfile, xlsheet, 1, 3);
		String Cpwd = XLUtils.getStringCellData(excelfile, xlsheet, 1, 4);
		
		hm1.Register(Fname, Lname, Email, pwd, Cpwd);
		Thread.sleep(5000);
		Log.endTestCase("---------------------------------End of Register Test Case with Positive values---------------------------------");
		ScreenRecorderUtil.stopRecord();
	}

}
