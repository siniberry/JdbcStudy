/*================
   MemberDAO.java
==================*/

// 데이터베이스에 액세스 하는 기능
// → DBConn 활용(전담 계층)

// 데이터를 입력하는 기능 → insert ( stmt.executeUpdate()  )

// 인원 수 확인하는 기능
// 즉, 대상테이블(TBL_MEMBER)의 레코드 카운팅 기능 → select ( executeQuery() )

// 전체 리스트를 조회하는 기능
// 즉, 대상테이블(TBL_MEMBER)의 데이터를 조회하는 기능 → select ( executeQuery() )


package com.test;

import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.util.DBConn;


public class MemberDAO
{
	// 주요 속성 구성 → DB 연결 객체
 	private Connection conn;
	
 	// getter / setter 구성
 	/*
	public Connection getConn()
	{
		return conn;
	}

	public void setConn(Connection conn)
	{
		this.conn = conn;
	}
	*/
 	// → DBConn 에서 전담하니까 필요 Ⅹ

 	// 생성자 정의(사용자 정의 생성자) → 클래스와 이름이 같음
	public MemberDAO() throws ClassNotFoundException, SQLException
	{
		// 클래스에서 그냥 못만듬
		conn = DBConn.getConnection();
	}
	
	// 메소드 정의 → 데이터 입력하는 기능 → insert
	public int add(MemberDTO dto) throws SQLException
	{
		// 반환할 결과값을 담아낼 변수(적용된 행의 갯수)
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비 (insert)
		String sql = String.format("INSERT INTO TBL_MEMBER(SID, NAME, TEL)"
								+ " VALUES(MEMBERSEQ.NEXTVAL, '%s', '%s')", dto.getName(), dto.getTel());
		
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
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_MEMBER";
		
		// 생성된 작업 객체를 활용하여 쿼리문 실행 → select → executeQuery() → ResultSet 반환 → 일반적으로 반복문 구성을 통한 ResultSet 처리
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리 → 반복문 구성 → 결과값 수신
		while (rs.next())					// 1번만 처리해서 if 문으로 처리해도 됨 but ResultSet은 기본적으로 while 씀
		{
			result = rs.getInt("COUNT");	// rs.getInt(1); → 컬럼의 인덱스 값 (※ 컬럼 인덱스는 1 부터...) 
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
	public ArrayList<MemberDTO> lists() throws SQLException
	{
		// 결과값으로 반환할 변수 선언 및 초기화
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = "SELECT SID, NAME, TEL FROM TBL_MEMBER ORDER BY SID";
		
		// 생성된 객체를 활용하여 쿼리문 실행 → select → executeQuery() → ResultSet 반환 → 일반적으로 반복 처리
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리 → 일반적 반복문 활용
		// 상자 반복으로 늘리기
		while (rs.next())
		{
			// 틀생성
			MemberDTO dto = new MemberDTO();
			
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
		// 주의 conn.close();
		
		DBConn.close();
	}
	
} // end class Member DAO
