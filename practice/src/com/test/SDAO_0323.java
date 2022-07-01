/*
 데이터베이스 연결
 --==>
 
 입력
 
 인원 수 
 
 전체 출력
 */

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class SDAO_0323
{
	// 주요속성 구성
	Connection conn;
	
	// 사용자 정의 생성자
	public SDAO_0323() throws ClassNotFoundException, SQLException 
	{
		conn = DBConn.getConnection();
	}
	
	// 메소드 정의 → 입력 insert
	public  int add(SDTO_0323 dto) throws SQLException
	{
		// 결과 값 담을 변수
		int result = 0;		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
				
		// 쿼리문 준비
		String sql = String.format("INSERT INTO PRACTICE_SCORE0323(SID, NAME, KOR, ENG, MAT)"
				+ " VALUES (SCORE0323SEQ.NEXTVAL, '%s', %d, %d, %d)", dto.getName(), dto.getKor(), dto.getEng(), dto.getMat() );
		
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);		
		
		// 리소스 반납
		rs.close();
		stmt.close();
		
		// 결과값 반환
		return result;
	}// end add
			
	// 메소드 정의 (전체 인원수 조회) → select
	public int count() throws SQLException
	{
		// 결과 값 담을 변수
		int result = 0;
				
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = "SELECT COUNT(*) AS COUNT FROM PRACTICE_SCORE0323";
		
		// 쿼리문 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리
		while (rs.next())
		{
			result = rs.getInt("COUNT");
		}		
		// 리소스 반납
		rs.close();
		stmt.close();
		
		// 결과 값 반환
		return result;
		
	} // end count
			
	// 메소드 정의 (전체 리스트 조회) → select
	public ArrayList<SDTO_0323> lists() throws SQLException
	{
		// 결과 값으로 반환 할 변수 및 초기화
		ArrayList<SDTO_0323> result = new ArrayList<SDTO_0323>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = "SELECT SID, NAME, KOR, ENG, MAT"
				+ ", KOR+ENG+MAT AS TOT"
				+ ", (KOR+ENG+MAT)/3.0 AS AVG"
				+ " FROM PRACTICE_SCORE0323"
				+ " ORDER BY SID";
		
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리
		while (rs.next())
		{
			// 틀 생성
			SDTO_0323 dto = new SDTO_0323();
			
			// 틀 넣기
			dto.setSid(rs.getInt("SID"));
			dto.setName(rs.getString("NAME"));
			dto.setKor(rs.getInt("KOR"));
			dto.setEng(rs.getInt("ENG"));
			dto.setMat(rs.getInt("MAT"));
			dto.setTot(rs.getInt("KOR"), rs.getInt("ENG"), rs.getInt("MAT"));
			dto.setAvg(rs.getInt("KOR"), rs.getInt("ENG"), rs.getInt("MAT"));
		
			// 상자에 틀 넣기
			result.add(dto);
			
		}

		// 리소스 반납
		rs.close();
		stmt.close();		
				
		// 결과 반환
		return result;
	}//  end lists
	
	public void close() throws SQLException
	{
		DBConn.close();
	}// end close
	
}// end SDAO0323
