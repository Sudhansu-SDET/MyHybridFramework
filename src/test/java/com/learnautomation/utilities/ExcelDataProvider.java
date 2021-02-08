package com.learnautomation.utilities;

import java.io.*;

import org.openqa.selenium.WebDriver;
import org.apache.poi.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	//constructor to load excel file
	public  ExcelDataProvider() 
	{
		File src = new File("./TestData/Data.xlsx"); // to load excel file
		
		try {
			FileInputStream fis = new FileInputStream(src); // to convert excel data to raw
			wb = new XSSFWorkbook(fis);	//to read write excel
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());		
		}
	}
	
	
	public String getStringData(String sheetName,int row, int column) {
		
		return wb.getSheet("Login").getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName,int row, int column) {
		
		return wb.getSheet("Login").getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	
}
