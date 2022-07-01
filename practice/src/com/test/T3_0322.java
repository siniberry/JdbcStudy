package com.test;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import com.util.DBConn;

public class T3_0322
{
	// 메인
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		
		
			// 연결객체 생성(구성)
			Connection conn = DBConn.getConnection();
			
			if (conn == null)
			{
				System.out.println("데이터베이스 연결 실패~!!!");
				System.exit(0); // 시스템 연결 종료
			}
			//System.out.println("데이터베이스 연결 성공~!!!");
			
			try
			{
				// 작업 객체 구성(준비)
				// Statement → DB와 자바프로그램 서로 전달 하는 역할의 객체
				Statement stmt = conn.createStatement();
				// ※ 데이터 입력 쿼리 실행 과정
				//	  한 번 실행하면 다시 실행하지 못하는 상황이다.
				//	  기본키 제약조건이 설정되어 있으므로
				//	  동일한 키 값이 중복될 수 없기 때문이다.
				
				// 쿼리문 구성(준비)
				String sql = "INSERT INTO PRACTICE_MEMBER0322(SID, NAME, TEL) VALUES (2, '아가현명', '010-2493-1902')";
				//-- 주의. 쿼리문 끝에 『;』붙이지 않는다.
				//-- 주의. 자바에서 실행한 DML 구문은 내부적으로 자동 COMMIT 된다.
				//-- 주의. 오라클에서 트랜잭션 처리가 이루어지지 않은으면
				//		   데이터 액션 처리가 이루어지지 않는다.
				
				// stmt.executeQuery()  → 쿼리를 실행 (select 를 보낼 때)
				// stmt.executeUpdate() → 오라클한테 전달 되었을 때 바뀌면 사용 (delete, insert ...등 을 보낼 때)
			
				//-- 적용된 행의 갯수 반환
				int result = stmt.executeUpdate(sql);
				
				if (result > 0)
				{
					System.out.println("데이터 입력 성공");
				}
				else 
				{
					System.out.println("데이터 입력 실패");
				}
				
			} catch (Exception e)
			{
				System.out.println(e.toString());
			}		
				
			//-- 리소스 반납(연결 종료)
			DBConn.close();
	}
}
