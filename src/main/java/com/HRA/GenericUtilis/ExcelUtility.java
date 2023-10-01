package com.HRA.GenericUtilis;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.s;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {

	/**
	 * This method is used to read the data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromExcelSheet(String sheetName,int rowNo,int cellNo) throws Throwable{
	{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String data = cell.toString();
		return data;		
	}
	}
	
	/**
	 * This method is used to Write the data from excel file
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws Throwable
	 */
	public void writeDataFromExcelSheet(String sheetName,int rowNo,int cellNo,String value)throws Throwable{
		{
			Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelpath));
			Sheet sheet = workbook.getSheet(sheetName);
			Row row = sheet.createRow(rowNo);
			Cell cell = row.createCell(cellNo);
			cell.setCellValue(value);
			FileOutputStream fos=new FileOutputStream(IPathConstants.excelpath);
			workbook.write(fos);
			workbook.close();			
		}
	
	}
	/**
	 * This method is used to get the Last row Num
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName)throws Throwable{
		Workbook workbook = WorkbookFactory.create(new FileInputStream(IPathConstants.excelpath));
		Sheet sheet = workbook.getSheet(sheetName);
		int RowCount = sheet.getLastRowNum();
		return RowCount;
	}
	/**
	 * 
	 * This method is used to getMultiple data from Excel
	 * @param sheetName
	 * @param keyColumn
	 * @param valueColumn
	 * @param driver
	 * @param jlib
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getMultipleDataFromExcel(String sheetName,int keyColumn,int valueColumn,WebDriver driver) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathConstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		
		HashMap<String,String> map=new HashMap<String,String>();
		for(int i=1;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();	
			map.put(key, value);
		}
		
		
		return map;
		
		
			
		}
				
		
	}
	
	


