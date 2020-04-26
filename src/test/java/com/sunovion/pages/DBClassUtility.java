package com.sunovion.pages;


	
	import java.sql.Connection;
		import java.sql.DriverManager;
		import java.sql.PreparedStatement;
		import java.sql.ResultSet;
		import java.sql.SQLException;
import java.sql.Statement;
		 
	/**
	08	 * Database object to load drivers and perform queries
	09	 * @author Abdulsalam Umar blog.salamtura.com
	10	 */
		public class DBClassUtility {
			
			
			static String query_DisbursementCount_Q3_2019 = "SELECT  Count(*) as Count  FROM Call_Sample_Header\r\n" + 
					" where DATEPART(quarter,Call_Date)in (1) and YEAR(Call_Date)= 2019\r\n" + 
					" Group By DATEPART(quarter,Call_Date), DATEPART(YYYY,Call_Date)";
 
	   private static Connection con;
	   private static final String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		    private static final String ConnectionString = "jdbc:sqlserver://ohw-simssql-tst;\" + \"databaseName=PilotSunovion_UAT; integratedSecurity=true;";
		   // private static final String user = "username";
		    //private static final String pwd = "password";
		 
	    /**
	     * create Database object
	     */
	    public DBClassUtility() {
		    }
		 
		    /**
		     * to load the database base driver
		     * @return a database connection
		     * @throws SQLException throws an exception if an error occurs
		     */
		    public static Connection loadDriver() throws SQLException {
		        try {
		            Class.forName(Driver);
		        } catch (ClassNotFoundException ex) {
		            System.out.println(ex.getMessage());
		        }
		        con = DriverManager.getConnection(ConnectionString);
		        return con;
		    }
		 
		    /**
		     * to get a result set of a query
		     * @param query custom query
		     * @return a result set of custom query
		     * @throws SQLException throws an exception if an error occurs
		     */
		    public static void getResultSet(String query) throws SQLException {
		        Connection con = loadDriver();
		        ResultSet rs;
		        Statement stmt = con.createStatement();
		       // PreparedStatement st = con.prepareStatement(query);
		        rs = stmt.executeQuery(query_DisbursementCount_Q3_2019);
		       System.out.println("Count : "+rs.getString(1)); 
		        
		 
		       // return rs;
		    }
		 
		    /**
		     * to run an update query such as update, delete
		     * @param query custom query
		     * @throws SQLException throws an exception if an error occurs
		     *//*
		    public static void runQuery(String query) throws SQLException {
		        Connection con = loadDriver();
		        ResultSet rs;
		        PreparedStatement st = con.prepareStatement(query);
		        st.executeUpdate();
		    }*/
		

		public static void main(String[] args) throws SQLException {
			
			DBClassUtility.loadDriver();
			DBClassUtility.getResultSet(query_DisbursementCount_Q3_2019);
		}}
		


