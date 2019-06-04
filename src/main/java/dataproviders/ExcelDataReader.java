package dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import managers.FileReaderManager;
import testDataTypes.Customer;

public class ExcelDataReader {
	
private final String customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "TestData.xlsx";
private final String sheetName = "LoginPage";	
public Customer readExcel(int rowIndex) throws IOException{
		
		//Create an object of File  class to open xlsx file
		
		File file = new File(customerFilePath);
		
		//Create an object of FileInputStream class to read Excel file
		
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook wb = new XSSFWorkbook(inputStream);
		
		//Read sheet inside the workbook by its name
		
		Sheet sheet = wb.getSheet(sheetName);
		
		//Find number of rows in excel file
		
		//int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		
		
		Row row = sheet.getRow(rowIndex);
		
		
		Customer customer = new Customer();
		
		customer.setUserName(row.getCell(0).getStringCellValue());
		
		customer.setPassword(row.getCell(1).getStringCellValue());
		
		return customer;
		
			
		}
	}
	


