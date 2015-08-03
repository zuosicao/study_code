package com.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class TestProcedured {
	public static void main(String[] args) {
		Connection conn = getConnection();
		String callSql = "{call pro7(?)}";
		try
		{
			
	
		if (conn != null)
		{
			CallableStatement callStmt = conn.prepareCall(callSql);
			callStmt.registerOutParameter(1, Types.INTEGER);
			callStmt.execute();
			
			System.out.println(callStmt.getInt(1));
		}
		}catch(SQLException e)
		{
			
		}finally
		
		{
			try {
				if (conn != null)
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection()
	{
		Connection resultConnection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			resultConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1111");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultConnection;
	}
}
