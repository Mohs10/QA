package com.Mohs10.Base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils
{
	public static String path = System.getProperty("user.dir") + "\\ExcelTestInputData\\TestData.xlsx";

	public static FileInputStream fi = null;
	public static FileOutputStream fo = null;
	public static Workbook wb = null;
	public static Sheet ws = null;
	public static Row row = null;
	public static Cell cell = null;
	public static CellStyle style = null;

	public XLUtils()
	{
		this.path=path;
		try {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheetAt(0);
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//constructor for reading excel path
	public XLUtils(String excelpath)
	{
		this.path=path;
		try {
			fi = new FileInputStream(path);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheetAt(0);
			fi.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//method for counting no of rows
	public static int rowCount(String sheetName)
	{
		return wb.getSheet(sheetName).getLastRowNum();
	}

	// returns the row count in a sheet
			public int getRowCount(String sheetName)
			{
				int index = wb.getSheetIndex(sheetName);
				if(index==-1)
					return 0;
				else{
				ws = wb.getSheetAt(index);
				int number=ws.getLastRowNum()+1;
				return number;
				}
				
			}
	//To get the Count of the Rows
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	//To get the Count of the columns
	public static short getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
	{

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		short colcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
	}

	////To get the String Data
	public static String getStringCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		String data;
		try
		{
			cell = row.getCell(colnum);
			data = cell.getStringCellValue();
		} catch (Exception e)
		{
			data = "";
		}
		wb.close();
		fi.close();
		return data;
	}

	//To Fetch the Numeric data
	public static int getNumericCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int data;
		try
		{
			cell = row.getCell(colnum);
			data = (int) cell.getNumericCellValue();
		} catch (Exception e)
		{
			data = 0;
		}
		wb.close();
		fi.close();
		return data;
	}

	//To get the Boolean values
	public static boolean getBooleanCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		boolean data;
		try
		{
			cell = row.getCell(colnum);
			data = cell.getBooleanCellValue();
		} catch (Exception e)
		{
			data = false;
		}
		wb.close();
		fi.close();
		return data;
	}

	//To Set the cell Data
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{

		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	//To fill the colors in the cells
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);

		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}
	
	public String getCellData(String sheetName,String colName,int rowNum){
		try{
			if(rowNum <=0)
				return "";
		
		int index = wb.getSheetIndex(sheetName);
		int col_Num=-1;
		if(index==-1)
			return "";
		
		ws = wb.getSheetAt(index);
		row=ws.getRow(0);
		for(int i=0;i<row.getLastCellNum();i++){
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
				col_Num=i;
		}
		if(col_Num==-1)
			return "";
		
		ws = wb.getSheetAt(index);
		row = ws.getRow(rowNum-1);
		if(row==null)
			return "";
		cell = row.getCell(col_Num);
		
		if(cell==null)
			return "";
		//System.out.println(cell.getCellType());
		if(cell.getCellType().name().equals("STRING"))
			  return cell.getStringCellValue();
		else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){
			  
			  String cellText  = String.valueOf(cell.getNumericCellValue());
			  if (HSSFDateUtil.isCellDateFormatted(cell)) {
		           // format in form of M/D/YY
				  double d = cell.getNumericCellValue();

				  Calendar cal =Calendar.getInstance();
				  cal.setTime(HSSFDateUtil.getJavaDate(d));
		            cellText =
		             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
		           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
		                      cal.get(Calendar.MONTH)+1 + "/" + 
		                      cellText;
		           
		           //System.out.println(cellText);

		         }
		  
			  return cellText;
		  }else if(cell.getCellType().name().equals("BLANK"))
		      return ""; 
		  else 
			  return String.valueOf(cell.getBooleanCellValue());
		
		}
		catch(Exception e){
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colName +" does not exist in xls";
		}
	}
	
	// returns the data from a cell
			public String getCellData(String sheetName,int colNum,int rowNum){
				try{
					if(rowNum <=0)
						return "";
				
				int index = wb.getSheetIndex(sheetName);

				if(index==-1)
					return "";
				
			
				ws = wb.getSheetAt(index);
				row = ws.getRow(rowNum-1);
				if(row==null)
					return "";
				cell = row.getCell(colNum);
				if(cell==null)
					return "";
				
			  if(cell.getCellType().name().equals("STRING"))
				  return cell.getStringCellValue();
			  else if(cell.getCellType().name().equals("NUMERIC") || cell.getCellType().name().equals("FORMULA") ){
				  
				  String cellText  = String.valueOf(cell.getNumericCellValue());
				  if (HSSFDateUtil.isCellDateFormatted(cell)) {
			           // format in form of M/D/YY
					  double d = cell.getNumericCellValue();

					  Calendar cal =Calendar.getInstance();
					  cal.setTime(HSSFDateUtil.getJavaDate(d));
			            cellText =
			             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
			           cellText = cal.get(Calendar.MONTH)+1 + "/" +
			                      cal.get(Calendar.DAY_OF_MONTH) + "/" +
			                      cellText;
			           
			          // System.out.println(cellText);

			         }

				  
				  
				  return cellText;
			  }else if(cell.getCellType().name().equals("BLANK"))
			      return "";
			  else 
				  return String.valueOf(cell.getBooleanCellValue());
				}
				catch(Exception e){
					
					e.printStackTrace();
					return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
				}
			}
	
	// returns true if data is set successfully else false
			public boolean setCellData(String sheetName,String colName,int rowNum, String data){
				try{
				fi = new FileInputStream(path); 
				wb = new XSSFWorkbook(fi);

				if(rowNum<=0)
					return false;
				
				int index = wb.getSheetIndex(sheetName);
				int colNum=-1;
				if(index==-1)
					return false;
				
				
				ws = wb.getSheetAt(index);
				

				row=ws.getRow(0);
				for(int i=0;i<row.getLastCellNum();i++){
					//System.out.println(row.getCell(i).getStringCellValue().trim());
					if(row.getCell(i).getStringCellValue().trim().equals(colName))
						colNum=i;
				}
				if(colNum==-1)
					return false;

				ws.autoSizeColumn(colNum); 
				row = ws.getRow(rowNum-1);
				if (row == null)
					row = ws.createRow(rowNum-1);
				
				cell = row.getCell(colNum);	
				if (cell == null)
			        cell = row.createCell(colNum);

			    // cell style
			    //CellStyle cs = workbook.createCellStyle();
			    //cs.setWrapText(true);
			    //cell.setCellStyle(cs);
			    cell.setCellValue(data);

			    fo = new FileOutputStream(path);

				wb.write(fo);

			    fo.close();	

				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
			}
		
			// returns true if sheet is created successfully else false
			public boolean addSheet(String  sheetname){		
				
				FileOutputStream fileOut;
				try {
					 wb.createSheet(sheetname);	
					 fileOut = new FileOutputStream(path);
					 wb.write(fileOut);
				     fileOut.close();		    
				} catch (Exception e) {			
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			// returns true if sheet is removed successfully else false if sheet does not exist
			public boolean removeSheet(String sheetName){		
				int index = wb.getSheetIndex(sheetName);
				if(index==-1)
					return false;
				
				FileOutputStream fileOut;
				try {
					wb.removeSheetAt(index);
					fileOut = new FileOutputStream(path);
					wb.write(fileOut);
				    fileOut.close();		    
				} catch (Exception e) {			
					e.printStackTrace();
					return false;
				}
				return true;
			}
			
			// returns true if column is created successfully
			public boolean addColumn(String sheetName,String colName){
				//System.out.println("**************addColumn*********************");
				
				try{				
					fi = new FileInputStream(path); 
					wb = new XSSFWorkbook(fi);
					int index = wb.getSheetIndex(sheetName);
					if(index==-1)
						return false;
					
				CellStyle style = wb.createCellStyle();
				//style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				//style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				
				ws=wb.getSheetAt(index);
				
				row = ws.getRow(0);
				if (row == null)
					row = ws.createRow(0);
				
				//cell = row.getCell();	
				//if (cell == null)
				//System.out.println(row.getLastCellNum());
				if(row.getLastCellNum() == -1)
					cell = row.createCell(0);
				else
					cell = row.createCell(row.getLastCellNum());
			        
			        cell.setCellValue(colName);
			        cell.setCellStyle(style);
			        
			        fo = new FileOutputStream(path);
					wb.write(fo);
					fo.close();		    

				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
				
				return true;
				
				
			}
			
			// removes a column and all the contents
			public boolean removeColumn(String sheetName, int colNum) {
				try{
				if(!isSheetExist(sheetName))
					return false;
				fi = new FileInputStream(path); 
				wb = new XSSFWorkbook(fi);
				ws=wb.getSheet(sheetName);
				CellStyle style = wb.createCellStyle();
				//style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
				//XSSFCreationHelper createHelper = workbook.getCreationHelper();
				//style.setFillPattern(HSSFCellStyle.NO_FILL);
				
			    
			
				for(int i =0;i<getRowCount(sheetName);i++){
					row=ws.getRow(i);	
					if(row!=null){
						cell=row.getCell(colNum);
						if(cell!=null){
							cell.setCellStyle(style);
							row.removeCell(cell);
						}
					}
				}
				fo = new FileOutputStream(path);
				wb.write(fo);
				fo.close();
				}
				catch(Exception e){
					e.printStackTrace();
					return false;
				}
				return true;
				
			}
		  // find whether sheets exists	
			public boolean isSheetExist(String sheetName){
				int index = wb.getSheetIndex(sheetName);
				if(index==-1){
					index=wb.getSheetIndex(sheetName.toUpperCase());
						if(index==-1)
							return false;
						else
							return true;
				}
				else
					return true;
			}
			
			// returns number of columns in a sheet	
			public int getColumnCount(String sheetName){
				// check if sheet exists
				if(!isSheetExist(sheetName))
				 return -1;
				
				ws = wb.getSheet(sheetName);
				row = ws.getRow(0);
				
				if(row==null)
					return -1;
				
				return row.getLastCellNum();
				
			}
			
			public int getCellRowNum(String sheetName,String colName,String cellValue){
				
				for(int i=2;i<=getRowCount(sheetName);i++){
			    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
			    		return i;
			    	}
			    }
				return -1;
				
			}		
	
}
