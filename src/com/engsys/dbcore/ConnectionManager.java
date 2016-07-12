package com.engsys.dbcore;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
public class ConnectionManager 
{
	public static ComboPooledDataSource ds=new ComboPooledDataSource();
	
	public static Connection getConnection()
	{
		Connection con=null;
		try {
			con=ds.getConnection();
		} catch (SQLException e) {
			System.out.println("ERROR_001_得到连接出错");
			e.printStackTrace();
		}
		return con;
	}
}
