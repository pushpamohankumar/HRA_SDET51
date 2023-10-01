
package com.HRA.GenericUtilis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	/**
	 * This method is used to Connect Database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable 
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbusername,IPathConstants.dbpassword);
	}
	
	/**
	 * This method is used to executeQuery and GetData
	 * @param query
	 * @param ColumnNo
	 * @param Expdata
	 * @return
	 * @throws SQLException
	 */
	public String executeQueryAndGetData(String query,int ColumnNo,String Expdata) throws SQLException
		{	
			ResultSet result = con.createStatement().executeQuery(query);
			boolean flag=false;
			while(result.next())
			{
				String data = result.getString(ColumnNo);
				if(data.equalsIgnoreCase(Expdata))
				{
					flag=true;
					break;
				}
			}
			if(flag==true)
			{
				System.out.println("Data is Verified");
				return Expdata;
			}
			else {
				System.out.println("Data is not verified");
				return " ";
			}
			
		}
		
	/**
	 * This method is used to Close the DataBase
	 * @throws SQLException
	 */
		public void closeDB()  throws SQLException{
			{
				con.close();
			}
	
	}
	
}
