package com.Mohs10.Dashboard;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Mohs10.Base.StartBrowser;
import com.Mohs10.Base.XLUtils;

public class TablesTest extends StartBrowser{
	@Test
  public void Tables() throws IOException, SQLException {
	   List <String> failText = new ArrayList<>();
	   List <String> passText = new ArrayList<>();
	   List <String> skippedText = new ArrayList<>();

	  //Parametarization//             
	  String excelfile = "ExcelTestInputData\\DB.xlsx"; //give path of excel sheet used for parametarization
	  String excelsheet = "DB"; //give the sheet name
	  String sheet = "Sheet1";
	  String clientName, clientID, projectName, sprintName, uuid, path;
	  //path = XLUtils.getStringCellData(excelfile, sheet, 1, 0);
	  uuid = "UUID_SHORT()";
	  int projectId;
	  //clientID = '100190835705905000' ;// XLUtils.getNumericCellData(excelfile, excelsheet, 2,0);
	  clientName = XLUtils.getStringCellData(excelfile, excelsheet, 2, 1);
	  projectId = XLUtils.getNumericCellData(excelfile, excelsheet, 2, 2);
	  System.out.println(projectId);
	  projectName = XLUtils.getStringCellData(excelfile, excelsheet, 2,3);
	  sprintName = XLUtils.getStringCellData(excelfile, excelsheet, 2,4);

	  //Testcases Info//
	  //driver.get("C:/Users/91703/Downloads/Sample%20Test%20Case1.html");
	  //opening .html file
	  String htmlpath="test-output/Default suite/Default test.html"; //chnage this as per testng.hmtls
		File filee=new File(htmlpath);
		System.out.println("Absolute Path: " + filee.getAbsolutePath());
	    path = filee.getAbsolutePath();
	  driver.get(path);
	  //driver.get("C:/Users/91703/eclipse-workspace/pAInITe-master/test-output/Default%20suite/Default%20test.html");
	  //fetching passes testcases time and title
	  List<WebElement> rows = driver.findElements(By.xpath("/html/body/p//table[@class=\"invocation-passed\"]/tbody/tr"));
	   for(int i=2;i<rows.size();i++) {
	   List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));	//Breaking xpath
	   List<WebElement> cols1 = cols.get(0).findElements(By.tagName("b"));  //getting  O'th column value
	   String title = cols1.get(0).getText();
	   passText. add(title) ;
	  }
	  //fetching failed testcases time and title
	   List<WebElement> rowsF = driver.findElements(By.xpath("/html/body/p//table[@class=\"invocation-failed\"]/tbody/tr"));
	   for(int f=2;f<rowsF.size();f++){
	   List<WebElement> colsF = rowsF.get(f).findElements(By.tagName("td"));
	 List<WebElement> cols1F = colsF.get(0).findElements(By.tagName("b"));
	 String title = cols1F.get(0).getText();
	   failText. add(title) ;
	 }
	  ////fetching skipped testcases time and title
	 List<WebElement> rowsS = driver.findElements(By.xpath("/html/body/p//table[@class=\"invocation-skipped\"]/tbody/tr"));
	  for(int g=2;g<rowsS.size();g++){
	   List<WebElement> colsS = rowsS.get(g).findElements(By.tagName("td"));
	   List<WebElement> cols1S = colsS.get(0).findElements(By.tagName("b"));
	   String title = cols1S.get(0).getText();
	   skippedText. add(title) ;
	  }
	 driver.quit();
	  ////////////////////////////////////////////////////////inserting data////////////////////////////////////////////////////////////////////

	 //Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard","root","");
	 // Statement stmt = (Statement) conn.createStatement();
	   ///Counting testcases////
	  int Pass_testCase_count = passText.size();
	  int Fail_testcase_count = failText.size();
	  int Skip_testcase_count = skippedText.size();
      int Total_TCcount = Pass_testCase_count+Fail_testcase_count+Skip_testcase_count;	/////for project info table///
	  //String query1 = "INSERT INTO projectinfo (ClientID,ClientName,ProjectName) values" + "('" +clientID+"'"+ "," + "'" +clientName+ "'" + "," + "'" +projectName+ "');" ;
	//stmt.executeUpdate(query1);
	 String query1 = "INSERT INTO projectinfo (ClientID,ClientName,ProjectName) values" + "(" +uuid+ "," + "'" +clientName+ "'" + "," + "'" +projectName+ "');" ;
	   //stmt.executeUpdate(query1);
	  System.out.println(query1);
	  /////testcaseinfo table//////
	   String query2 = "INSERT INTO testcaseinfo (ProjectID,ProjectName,SprintName,PassedTestCaseCount,FailedTestCaseCount,SkippedTestCaseCount,TotalTestCaseCount) values" + "('" +projectId+ "'" + "," + "'" +projectName+ "'" +"," + "'" +sprintName+ "'" +"," + "'" +Pass_testCase_count+ "'" + "," + "'" +Fail_testcase_count+ "'" + "," + "'" +Skip_testcase_count+ "'" + ","+ "'" +Total_TCcount+ "');" ;
	 //stmt.executeUpdate(query2);
	   System.out.println(query2) ;
	  //select * from dashboard.projectinfo natural join dashboard.tccount;
	  }
}
