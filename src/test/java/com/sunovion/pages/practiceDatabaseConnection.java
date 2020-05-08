package com.sunovion.pages;


	import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;

	public class practiceDatabaseConnection extends WebDriverBaseTestPage<WebDriverTestPage> {
		
		
		
		//String query = "select top 10 Territory_ID, Territory_Code, Territory_Desc from Territory";
		
		public String query_Adjustments_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'MA'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//-----------------------------------------------------------------------------------------------------------------------------
		public String query_Transfer_Out_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'TO'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//------------------------------------------------------------------------------------------------------------------------------
		public String query_Transfer_In_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'TI'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//------------------------------------------------------------------------------------------------------------------------------
		public String query_Thefts_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'TH'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//-----------------------------------------------------------------------------------------------------------------------------
		public String query_Shipment_Ack_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'SA'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//------------------------------------------------------------------------------------------------------------------------------
		public String query_Shipment_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'SH'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//---------------------------------------------------------------------------------------------------------------------------
		public String query_Returns_Ack_Q1_2019 = "SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'RA'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//----------------------------------------------------------------------------------------------------------------------------
		public String query_Returns_Q1_2019 = " SELECT  Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'RE'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		//-------------------------------------------------------------------------------------------------------------------
		public String query_Losses_Q1_2019 ="SELECT   Count(*) as Count  FROM Inventory_Event_Header  \r\n" + 
				" where Inventory_Event_Type = 'LO'  and DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		
		public String query_Inventory_Q1_2019 = "\r\n" + 
				"SELECT Count(*) as Count  FROM Inventory_Header  \r\n" + 
				" where DATEPART(quarter,Transaction_Date)in (1) and YEAR(Transaction_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Transaction_Date), DATEPART(YYYY,Transaction_Date)";
		
		//-------------------------------------------------------------------------------------------------------------------
		public String query_DisbursementCount_Q1_2019 = "SELECT  Count(*) as Count  FROM Call_Sample_Header\r\n" + 
				" where DATEPART(quarter,Call_Date)in (1) and YEAR(Call_Date)= 2019\r\n" + 
				" Group By DATEPART(quarter,Call_Date), DATEPART(YYYY,Call_Date)";
		public String DBConfig(String query)
		{
			String Count ="";
			try
			{
				
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				String connString = "jdbc:sqlserver://ohw-simssql-tst;" + "databaseName=PilotSunovion_UAT; integratedSecurity=true;";
				Connection conn = DriverManager.getConnection(connString);
				Statement stmt = conn.createStatement();
				//System.out.println("COnnection doen");
				ResultSet rs = stmt.executeQuery(query);
				if(rs.next())
				{
					
					//System.out.println("true");
					rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					//System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3));
					//System.out.println(rs.getString(1));
					Count =  rs.getString(1);
					
				}}
				else {
					
						//System.out.println("false");
						Count = "0";
						//System.out.println("row :"+Count);
					
				}
				
			}
			
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return Count;
		}
		
	@QAFTestStep (description = "Database Connection Testing")
	public void DatabaseConnectionTest() {
		
		practiceDatabaseConnection d = new practiceDatabaseConnection();
		System.out.println("Count :"+d.DBConfig(query_DisbursementCount_Q1_2019));
		System.out.println("Count :"+d.DBConfig(d.query_Losses_Q1_2019));

	}

	

	@Override
	protected void openPage(PageLocator arg0, Object... arg1) {
		// TODO Auto-generated method stub
		
	}

		

	}


