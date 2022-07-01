/* =============================
  DBCoon.java
  -예외 처리 throws 
==============================*/

package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn
{
	// 변수 선언
	private static Connection dbConn;
	
	// 메소드 정의 → 연결
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		if(dbConn == null)
		{
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "scott";
			String pwd = "tiger";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			dbConn = DriverManager.getConnection(url, user, pwd);
			
		}
		// 구성된 연결 객체 반환
		return dbConn;		
	}
	
		// getConnection() 메소드의 오버로딩 → 연결
		public static Connection getConnection(String url, String user, String pwd) throws ClassNotFoundException, SQLException
		{
			if (dbConn == null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				dbConn = DriverManager.getConnection(url, user, pwd);
			}
			return dbConn;
		
		}
		
		public static void close() throws SQLException
		{
			if (dbConn != null)
			{
				if (!dbConn.isClosed())
				{
					dbConn.close();
				}
			}
			
			// 연결 객체 초기화
			dbConn = null;
		}

		
}





