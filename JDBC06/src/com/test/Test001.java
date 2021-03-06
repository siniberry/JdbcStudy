/*==============================
   Test001.java
   - 쿼리문 전송 실습
==============================*/


package com.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.Statement;

import com.util.DBConn;

public class Test001
{
	public static void main(String[] args)
	{
		try
		{
			Connection conn = DBConn.getConnection();
			
			if (conn != null)
			{
				System.out.println("데이터베이스 연결 성공~!!!");
				try
				{
					/*
					Statement stmt = conn.createStatement();
					
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, '한충희','010-5555-5555')";
					
					int result = stmt.executeUpdate(sql);
					
					if (result > 0)
						System.out.println("데이터 입력 성공~!!!");
					
					stmt.close();
					DBConn.close();
					*/
					
					// 쿼리문 준비
					String sql = "INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
							+ " VALUES(MEMBERSEQ.NEXTVAL, ?, ?)";
					// 주의 + " VALUES(MEMBERSEQ.NEXTVAL, '?', '?')"; 하면 안된다.
					// 왜냐하면 IN 매개변수 넘겨주는 곳에서 결정 되기 때문 !!
					
					
					// 작업객체 생성
					PreparedStatement pstmt = conn.prepareStatement(sql);
					// PreparedStatement 는 쿼리문이 먼저 준비 되어 있어야함
					// 즉, 순서가 쿼리문 준비 -> 작업객체 생성
					
					
					// IN 매개변수 넘겨주기
					pstmt.setString(1, "박현수");
					pstmt.setString(2, "010-6666-6666");
					
					// 쿼리문 실행 → IN 매개변수에서 전달했기 때문에 여기서는 전달 Ⅹ
					int result = pstmt.executeUpdate();
					if (result >0)
						System.out.println("데이터 입력 성공 ~!!!");
					
					
					// 리소스 반납
					pstmt.close();
					DBConn.close();
					
					
				} catch (Exception e)
				{
					System.out.println(e.toString());
				}
			}
		} catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
