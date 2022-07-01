package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class MDAO_0323
{
	// 주요 속성 구성 → DB 연결 객체
	private Connection conn;
	
	// 생성자 정의(사용자 정의 생성자) → 클래스와 이름이 같음
	public MDAO_0323() throws ClassNotFoundException, SQLException
	{
		// 클래스에서 그냥 못만듬
		conn = DBConn.getConnection();
	}
		
	// 메소드 정의 → 데이터 입력하는 기능 → insert
	public int add(MDTO_0323 dto) throws SQLException
	{
		// 반환할 결과값을 담아낼 변수(적용된 행의 갯수)
		int result = 0;
			
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
			
		// 쿼리문 준비 (insert)
		String sql = String.format("INSERT INTO PRACTICE_MEMBER0322(SID, NAME, TEL)"
				+ " VALUES(MEMBER0323SEQ.NEXTVAL, '%s', '%s')", dto.getName() , dto.getTel());
			
		// 작업 객체를 활용하여 쿼리문 실행(전달)
		result = stmt.executeUpdate(sql);
			
		// 사용한 리소스 반납
		stmt.close();
			
		// 최종 결과값 반환
		return result;
	}// end add
	
	// 메소드 정의 → 전체 인원수 확인하는 기능 → select
	// 조건 없이 전체인원수를 조회하기 때문에 넘길 값이 없다
	public int count() throws SQLException
	{
		// 결과 값으로 반환하게 될 변수 선언 및 초기화
		int result = 0;
		
		// 작업 객체 생성 
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = "SELECT COUNT(*) AS COUNT FROM PRACTICE_MEMBER0322";
		
		// 생성된 작업 객체를 활용하여 쿼리문 실행 → select → executeQuery() → ResultSet 반환 → 일반적으로 반복문 구성을 통한 ResultSet 처리
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리 → 반복문 구성 → 결과값 수신
		while (rs.next())
		{
			result = rs.getInt("COUNT");
		}
			
			
		// 리소스 반납 
		// (반납 순서는 가장 마지막에 open한것 부터 ( a b c → c b a ) )
		rs.close();
		stmt.close();		
		
		// 최종 결과값 반환
		return result;	
		
	} // end count()
	
	// 메소드 정의 → 전체 리스트를 조회하는 기능 → select
	//      상자 생성
	public ArrayList<MDTO_0323> lists() throws SQLException
	{
	
		// 결과값으로 반환할 변수 선언 및 초기화
		ArrayList<MDTO_0323> result = new ArrayList<MDTO_0323>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = String.format("SELECT SID, NAME, TEL"
				+ " FROM PRACTICE_MEMBER0322"
				+ " ORDER BY SID");
		
		// 생성된 객체를 활용하여 쿼리문 실행 → select → executeQuery() → ResultSet 반환 → 일반적으로 반복 처리
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리 → 일반적 반복문 활용
		// 상자 반복으로 늘리기
		while (rs.next())
		{
			// 틀생성
			MDTO_0323 dto = new MDTO_0323();
				
			// 틀담기
			dto.setSid(rs.getString("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setTel(rs.getString("TEL"));
				
			// 상자에 담기
			result.add(dto);
		}						
			
		// 리소스 반납
		rs.close();
		stmt.close();		
			
		// 최종 결과값 반환
		return result;	
			
	}// end lists()
	
	public void close() throws SQLException
	{
		DBConn.close();
	}
}
