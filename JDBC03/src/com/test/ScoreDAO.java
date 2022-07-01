/*
 - 데이터베이스에 연결
 → DBConn
 
 - 데이터 입력
 → insert
 
 - 전체 수
 → select
  
 - 전체 출력
 → select
 */

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class ScoreDAO
{
	// 주요 속성 구성
	Connection conn;
	
	// 사용자 정의 생성자
	public ScoreDAO()
	{
		conn = DBConn.getConnection();
	}
	
	//  메소드 정의 (데이터 입력) → insert
	public int add(ScoreDTO dto) throws SQLException
	{
		// 결과 값 담을 변수
		int result = 0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = String.format("INSERT INTO TBL_SCORE(SID, NAME, KOR, ENG, MAT)"
								+ " VALUES (SCORESEQ.NEXTVAL, '%s', %d, %d, %d)", dto.getName(), dto.getKor(), dto.getEng(), dto.getMat());
		
		// 쿼리문 실행
		result = stmt.executeUpdate(sql);
		
		// 리소스 반납
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
		String sql ="SELECT COUNT(*) AS COUNT FROM TBL_SCORE";
		
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
	}// end count
	
	// 메소드 정의 (전체 리스트 조회) → select
	public ArrayList<ScoreDTO> lists() throws SQLException
	{
		// 결과 값으로 반환 할 변수 및 초기화
		ArrayList<ScoreDTO> result = new ArrayList<ScoreDTO>();
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql ="SELECT SID, NAME, KOR, ENG, MAT,"
					+ " KOR+ENG+MAT AS TOT, (KOR+ENG+MAT)/3.0 AS AVG"
					+ " FROM TBL_SCORE ORDER BY SID";
		
		// 쿼리 실행
		ResultSet rs = stmt.executeQuery(sql);
		
		// ResultSet 처리
		while (rs.next())
		{
			// 틀 생성
			ScoreDTO dto = new ScoreDTO();
			
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
	}// end ArryList
	
	public void close()
	{
		DBConn.close();
	}// end close()
	
	
}// end ScoreDAO
