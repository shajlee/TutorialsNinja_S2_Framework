package com.qa.tutorialsninjaS2.tesdata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class S2_TestDataSupply {
	
	public static FileInputStream ip;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;

	@DataProvider(name = "TutorialsNinja_S2_DataProvider_DataSupply")
	public static Object [][] dataSupplyFromTwoDimentionalArray(){
		Object [][] data = {{"shajlee@yahoo.com", "Potter1@"},
                            {"rifi_luver@hotmail.com", "Aniqa1@"},
                            {"chowdhurygs@rediffmail.com", "Shajlee1@"},
                            {"chowdhurygsa@gmail.com", "Shajlee123"},
                            {"nawshinaniqa@gmail.com", "Kiyaan123"},
                            {"gkcmono@yahoo.com", "poultry13"},
                            {"chowdhurygs@gmail.com", "Shajlee1234"},
                            {"golamchodhury@gmail.com", "Shajlee123!"}};
		return data;
	}
		
		@DataProvider(name = "TutorialsNinja_S1_ExcelSheet_DataSupply")
		public static Object [][] dataSupplyFromExcelSheet() throws Exception{
			Object [][] data = S2_TestDataSupply.getTutorialsNinjaTestDataFromExcelSheet("LoginData");
			return data;
		}
		public static Object [][] getTutorialsNinjaTestDataFromExcelSheet(String sheetName) throws Exception{
			ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\tutorialsninjaS2\\tesdata\\TutorialsNinja_S2_TestData.xlsx");
			workbook = new XSSFWorkbook(ip);
			sheet = workbook.getSheet(sheetName);
			int rows = sheet.getLastRowNum();
			int cols = sheet.getRow(0).getLastCellNum();
			
	Object[][] data = new Object[rows][cols];
			
			for(int i=0; i<rows; i++) {
				XSSFRow row = sheet.getRow(i+1);
				 
				for(int j=0; j<cols; j++) {
					XSSFCell cell = row.getCell(j);
					CellType celltype = cell.getCellType();
					
					switch(celltype) {
					
					case STRING:
						data[i][j] = cell.getStringCellValue();
						break;
						
					case NUMERIC:
						data[i][j] = Integer.toString((int)cell.getNumericCellValue());
						break;
						
					case BOOLEAN:
						data[i][j] = cell.getBooleanCellValue();
						break;
						
					
					}
				}
			
			}
			  return data;                  		
					            		
		
		
		
						
					
			              		
					            		
			
		}
		
		
	}

