package com.sunovinon.steps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class ImportExcelData extends WebDriverBaseTestPage<WebDriverTestPage> {
	protected String filepath = "C:\\Users\\pjalapur\\Downloads";
	protected String fileName = "Transaction search results.xlsx";
	protected String sheetName = "Transaction search results";
	
	public void readExcel(String filePath,String fileName,String sheetName) throws IOException{
		DataFormatter formatter = new DataFormatter();
	    List<String> data = new ArrayList<String>();
		//String val = formatter.formatCellValue(sheet.getRow(row).getCell(col));
	    //Create an object of File class to open xlsx file
	    File file =    new File(filePath+"\\"+fileName);
	    //Create an object of FileInputStream class to read excel file
	    FileInputStream inputStream = new FileInputStream(file);
	    Workbook Workbook = null;
	    //Find the file extension by splitting file name in substring  and getting only extension name
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    //Check condition if the file is xlsx file
	    if(fileExtensionName.equals(".xlsx")){
	    //If it is xlsx file then create object of XSSFWorkbook class
	    Workbook = new XSSFWorkbook(inputStream);
	    }
	    //Check condition if the file is xls file
	    else if(fileExtensionName.equals(".xls")){
	        //If it is xls file then create object of HSSFWorkbook class
	        Workbook = new HSSFWorkbook(inputStream);
	    }
	    //Read sheet inside the workbook by its name
	    Sheet Sheet = Workbook.getSheet(sheetName);
	    //Find number of rows in excel file
	    int rowCount = Sheet.getLastRowNum()-Sheet.getFirstRowNum()-6;
	    Row row = Sheet.getRow(6);
	    int colCount = row.getLastCellNum();
	    System.out.println("colCount :"+colCount);
	    
	    if (colCount==43) {
	    	System.out.println("All columns are displayed");
	    	Reporter.log("All columns are displayed");
	    }
	    	
	    System.out.println("rowCount :"+rowCount);
	    //Create a loop over all the rows of excel file to read it
	    /*for (int i = 6; i < rowCount+1; i++) {
	         row = Sheet.getRow(i);
	        //Create a loop to print cell values in a row
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            //Print Excel data in console
	        	System.out.print(formatter.formatCellValue(row.getCell(j))+"|| ");
	            //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        }
	        System.out.println();
	    }*/ 
	    
	    for (int i = 6; i <=6; i++) {
	         row = Sheet.getRow(i);
	        //Create a loop to print cell values in a row
	        for (int j = 0; j <row.getLastCellNum(); j++) {
	            //Print Excel data in console
	        	data.add(formatter.formatCellValue(row.getCell(j)));
	        	
	        	System.out.println(j+1+") "+formatter.formatCellValue(row.getCell(j))+"   column is present");
	        	//Reporter.log(j+1+") "+formatter.formatCellValue(row.getCell(j))+"   column is present");
	            //System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        	//Account IDPractitioner First NamePractitioner Middle NamePractitioner Last Name
	        	//Designation	Specialty	Address 1	Address 2	Address 3	City	State	Zip	License	Create Date	Inventory Type	
	        	//Linking Status	SFA Linking Status	Paper Linking Status	Linking Date	Packing Slip Received Date	Packing Slip#	
	        	//Exception Code	Product Group	Scan Date	Source	Transfer Emp	Product	Product Code	NDC	Lot	Qty
                
	        	/*if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("Designation"))
        		{
        			System.out.println("Designation column is present");
        			Reporter.log("Designation column is present");
        		}
	        	
	        	if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("Practitioner Last Name"))
        		{
        			System.out.println("Practitioner Last Name column is present");
        			Reporter.log("Practitioner Last Name column is present");
        		}
	        	
	        	if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("Practitioner Middle Name"))
        		{
        			System.out.println("Practitioner Middle Name column is present");
        			Reporter.log("Practitioner Middle Name column is present");
        		}
	        	
	        	if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("Practitioner First Name"))
        		{
        			System.out.println("Practitioner First Name column is present");
        			Reporter.log("Practitioner First Name column is present");
        		}
	        	
	        	if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("Account ID"))
        		{
        			System.out.println("Account ID column is present");
        			Reporter.log("Account ID column is present");
        		}
	        	
	        		if (formatter.formatCellValue(row.getCell(j)).equalsIgnoreCase("ID"))
	        		{
	        			System.out.println("ID column is present");
	        			Reporter.log("ID column is present");
	        		}
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Type"))
	        		{
	        			System.out.println("Type column is present");
	        			Reporter.log("Type column is present");
	        		}
	        		
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Date"))
	        		{
	        			System.out.println("Date column is present");
	        			Reporter.log("Date column is present");
	        		}
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Employee ID"))
	        		{
	        			System.out.println("Employee ID column is present");
	        			Reporter.log("Employee ID column is present");
	        		}
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Employee Last Name"))
	        		{
	        			System.out.println("Employee Last Name column is present");
	        			Reporter.log("Employee Last Name column is present");
	        		}
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Employee First Name"))
	        		{
	        			System.out.println("Employee First Name column is present");
	        			Reporter.log("Employee First Name column is present");
	        		}
	        		
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Valid for Recon"))
	        		{
	        			System.out.println("Valid for Recon column is present");
	        			Reporter.log("Valid for Recon column is present");
	        		}
	        		
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Status"))
	        		{
	        			System.out.println("Status column is present");
	        			Reporter.log("Status column is present");
	        		}
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Territory"))
	        		{
	        			System.out.println("Territory column is present");
	        			Reporter.log("Territory column is present");
	        		}
	        		
	        		if (formatter.formatCellValue(row.getCell(j)).contains("Paper Reference #"))
	        		{
	        			System.out.println("Paper Reference # column is present");
	        			Reporter.log("Paper Reference # column is present");
	        		}
	        		
	        		if (formatter.formatCellValue(row.getCell(j)).contains("PAC Form(s)"))
	        		{
	        			System.out.println("PAC Form(s) column is present");
	        			Reporter.log("PAC Form(s) column is present");
	        		}*/
	        	}
	        
	        }
	    Validator.verifyTrue(data.contains("ID"), "ID column is missing", "ID column is present");
	    Validator.verifyTrue(data.contains("Type"), "Type column is missing", "Type column is present");
	    Validator.verifyTrue(data.contains("Doc/Ref #"), "Doc/Ref # column is missing", "Doc/Ref # column is present");
	    Validator.verifyTrue(data.contains("Date"), "Date column is missing", "Date column is present");
	    Validator.verifyTrue(data.contains("Employee ID"), "Employee ID column is missing", "Employee ID column is present");
	    Validator.verifyTrue(data.contains("Employee Last Name"), "Employee Last Name column is missing", "Employee Last Name column is present");
	    Validator.verifyTrue(data.contains("Employee First Name"), "Employee First Name column is missing", "Employee First Name column is present");
	    Validator.verifyTrue(data.contains("Valid for Recon"), "Valid for Recon column is missing", "Valid for Recon column is present");
	    Validator.verifyTrue(data.contains("Status"), "Status column is missing", "Status column is present");
	    Validator.verifyTrue(data.contains("Territory"), "Territory column is missing", "Territory column is present");
	    Validator.verifyTrue(data.contains("Paper Reference #"), "Paper Reference # column is missing", "Paper Reference # column is present");
	    Validator.verifyTrue(data.contains("PAC Form(s)"), "PAC Form(s) column is missing", "PAC Form(s) column is present");
	    Validator.verifyTrue(data.contains("Account ID"), "Account ID column is missing", "Account ID column is present");
	    Validator.verifyTrue(data.contains("Practitioner First Name"), "Practitioner First Name column is missing", "Practitioner First Name column is present");
	    Validator.verifyTrue(data.contains("Practitioner Middle Name"), "Practitioner Middle Name column is missing", "Practitioner Middle Name column is present");
	    Validator.verifyTrue(data.contains("Practitioner Last Name"), "Practitioner Last Name column is missing", "Practitioner Last Name column is present");
	    Validator.verifyTrue(data.contains("Designation"), "Designation column is missing", "Designation column is present");
	    Validator.verifyTrue(data.contains("Specialty"), "Specialty column is missing", "Specialty column is present");
	    Validator.verifyTrue(data.contains("Address 1"), "Address 1 column is missing", "Address 1 column is present");
	    Validator.verifyTrue(data.contains("Address 2"), "Address 2 column is missing", "Address 2 column is present");
	    Validator.verifyTrue(data.contains("Address 3"), "Address 3 column is missing", "Address 3 column is present");
	    Validator.verifyTrue(data.contains("City"), "City column is missing", "City column is present");
	    Validator.verifyTrue(data.contains("State"), "State column is missing", "State column is present");
	    Validator.verifyTrue(data.contains("Zip"), "Zip column is missing", "Zip column is present");
	    Validator.verifyTrue(data.contains("License"), "License column is missing", "License column is present");
	    Validator.verifyTrue(data.contains("Create Date"), "Create Date column is missing", "Create Date column is present");
	    Validator.verifyTrue(data.contains("Inventory Type"), "Inventory Type column is missing", "Inventory Type column is present");
	    Validator.verifyTrue(data.contains("Linking Status"), "Linking Status column is missing", "Linking Status column is present");
	    Validator.verifyTrue(data.contains("SFA Linking Status"), "SFA Linking Status column is missing", "SFA Linking Status column is present");
	    Validator.verifyTrue(data.contains("Paper Linking Status"), "Paper Linking Status column is missing", "Paper Linking Status column is present");
	    Validator.verifyTrue(data.contains("Linking Date"), "Linking Date column is missing", "Linking Date column is present");
	    Validator.verifyTrue(data.contains("Packing Slip Received Date"), "Packing Slip Received Date column is missing", "Packing Slip Received Date column is present");
	    Validator.verifyTrue(data.contains("Packing Slip#"), "Packing Slip# column is missing", "Packing Slip# column is present");
	    Validator.verifyTrue(data.contains("Exception Code"), "Exception Code column is missing", "Exception Code column is present");
	    Validator.verifyTrue(data.contains("Product Group"), "Product Group column is missing", "Product Group column is present");
	    Validator.verifyTrue(data.contains("Scan Date"), "Scan Date column is missing", "Scan Date column is present");
	    Validator.verifyTrue(data.contains("Source"), "Source column is missing", "Source column is present");
	    Validator.verifyTrue(data.contains("Transfer Emp"), "Transfer Emp column is missing", "Transfer Emp column is present");
	    Validator.verifyTrue(data.contains("Product Code"), "Product Code column is missing", "Product Code column is present");
	    Validator.verifyTrue(data.contains("Product"), "Product column is missing", "Product column is present");
	    Validator.verifyTrue(data.contains("NDC"), "NDC column is missing", "NDC column is present");
	    Validator.verifyTrue(data.contains("Lot"), "Lot column is missing", "Lot column is present");
	    Validator.verifyTrue(data.contains("Qty"), "Qty column is missing", "Qty column is present");
	  
	    
	    
	    
	        System.out.println();
	        if (colCount==43) {
		    	System.out.println("All columns are displayed");
		    	Reporter.log("All columns are displayed");
		    }
	        
	        if (colCount<43) {
		    	System.out.println("Some columns are not displayed");
		    	Reporter.log("Some columns are not displayed");
		    }
	        
	    } 
	    
	    
	    
	    
	    
 

	public static void main(String[] args) throws IOException  {
		ImportExcelData ed = new ImportExcelData();
		String filepath = "C:\\Users\\pjalapur\\Downloads";
		String fileName = "Transaction search results.xlsx";
		String sheetName = "Transaction search results";
		
		ed.readExcel(filepath, fileName, sheetName);
		
		
	}







	




	@Override
	protected void openPage(PageLocator locator, Object... args) {
		// TODO Auto-generated method stub
		
	}

}
