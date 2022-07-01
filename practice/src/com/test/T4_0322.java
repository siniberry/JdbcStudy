package com.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.util.DBConn;

public class T4_0322
{
	// 메인
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		// 스캐너
		Scanner sc = new Scanner(System.in);
		
		// 연결 객체 생성(구성)
		Connection conn = DBConn.getConnection();	
		
		do
		{
			System.out.print("번호를 입력 하세요(-1 종료) : ");
			String sid = sc.next();
			
			// 반복문의 조건을 무너뜨리는 코드 구성
			if (sid.equals("-1"))
				break;

			// 입력 및 담기
			System.out.print("이름을 입력하세요 : ");
			String name = sc.next();
			
			System.out.print("전화번호를 입력하세요 : ");
			String tel = sc.next();
			
			if (conn != null)
			{
				
				System.out.println("데이터베이스 연결 성공~!!!");
				
				try
				{
					// 작업 객체 준비
					Statement stmt = conn.createStatement();
					
					// 쿼리문 준비
					String sql = String.format("INSERT INTO PRACTICE_MEMBER0322(SID, NAME, TEL) VALUES (%s, '%s', '%s')", sid, name, tel);
					
					// 데이터베이스로부터 질의 결과를 가져와야하는 경우
					// → 『executeQuery()』 메소드 사용.
					// 특정 내용을 데이터베이스에 적용해야 하는 경우
					// → 『executeUpdate()』 메소드 사용.
					
					//-- executeUpdate() 메소드는 적용된 행의 갯수를 반환
					int result = stmt.executeUpdate(sql);
					
					if (result >0)
					{
						System.out.println("회원정보가 입력되었습니다.");
					}
					
				} catch (Exception e)
				{
					System.out.println(e.toString());
				}
				
			} else
			{
				System.out.println("데이터베이스 연결 실패~!!!");
				break;
			}
					
		} while (true);
		
		sc.close();
		DBConn.close();
		
		System.out.println("데이터베이스 연결 닫힘");
		System.out.println("프로그램 종료 됨");
		
	}
			
}

// 실행 결과
/*
번호를 입력 하세요(-1 종료) : 3
이름을 입력하세요 : 신가은
전화번호를 입력하세요 : 010-2050-0734
데이터베이스 연결 성공~!!!
회원정보가 입력되었습니다.
번호를 입력 하세요(-1 종료) : 4
이름을 입력하세요 : 베리
전화번호를 입력하세요 : 010-1223-0108
데이터베이스 연결 성공~!!!
회원정보가 입력되었습니다.
번호를 입력 하세요(-1 종료) : -1
데이터베이스 연결 닫힘
프로그램 종료 됨
*/
