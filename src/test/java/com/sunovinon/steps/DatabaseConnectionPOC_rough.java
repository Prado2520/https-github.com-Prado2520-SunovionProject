package com.sunovinon.steps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.TestPage;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebDriver;

public class DatabaseConnectionPOC_rough   {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// PilotSunovion_UAT , PilotSunovion_QA
		
		String quarter = "1";
		String year = "2019";
		String query_DisbursementCount_Q3_2019 = "\r\n" + 
				"SELECT  DATEPART(YYYY,Call_Date)  as Year,DATEPART(quarter,Call_Date) as Quarter, Count(*) as Count  FROM Call_Sample_Header\r\n" + 
				" where DATEPART(quarter,Call_Date)in ("+quarter+") and YEAR(Call_Date)= "+year+"\r\n" + 
				" Group By DATEPART(quarter,Call_Date), DATEPART(YYYY,Call_Date) Order by Quarter, Year";
		
		String query_Transfer_Out_Q3_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'TO'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		
		 String query_Returns_Q3_2019 = " SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'RE'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		String query_Transfer_In_Q3_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
					" where Inventory_Event_Type = 'TI'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
					" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
			//------------------------------------------------------------------------------------------------------------------------------
		 String query_Thefts_Q3_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
					" where Inventory_Event_Type = 'TH'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
					" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		try
		{
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connString = "jdbc:sqlserver://ohw-simssql-tst;" + "databaseName=PilotSunovion_UAT; integratedSecurity=true;";
			Connection conn = DriverManager.getConnection(connString);
			Statement stmt = conn.createStatement();
		    //ResultSet rs = stmt.executeQuery(query_Returns_Q3_2019);
			//ResultSet rs = stmt.executeQuery(query_Transfer_Out_Q3_2019);
		    ResultSet rs = stmt.executeQuery(query_Transfer_In_Q3_2019);
		   //ResultSet rs = stmt.executeQuery(query_Thefts_Q3_2019);
		   String row;	
		    
		     
			
			if(rs.next())
			{
				
				System.out.println("true");
				rs = stmt.executeQuery(query_Transfer_In_Q3_2019);
				while(rs.next()) {
					//System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3));
					 row = rs.getString("Count");
					System.out.println("row :"+row);
					System.out.println(rs.getString(1)+"string");
				}
			}
			else {
				System.out.println("false");
				row = "0";
				System.out.println("row :"+row);
			}
			
		
		//}
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(query_DisbursementCount_Q3_2019);

	}

	

	


}