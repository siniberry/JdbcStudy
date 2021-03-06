/*
데이터베이스 연결
-> DBConn 
직원 정보 입력
-> insert
직원 전체 출력
-> 전체 직원 수 조회 
-> select
-> ArrayList
-> switch
직원 검색 출력
-> select
->
직원 정보 수정
-> update
직원 정보 삭제
-> delete
 */

package com.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.util.DBConn;

public class MemberDAO
{
	// 주요 변수 선언 → DB 연결 객체
	private Connection conn;
	
	// 데이터 베이스 연결 담당 메소드
	public Connection connection()
	{
		// 데이터베이스연결할꺼거든~
		conn = DBConn.getConnection();
		// 사용할 수 있게 밖으로 숑 ~
		return conn;
	}
	
	// 직원 데이터 입력
	public int add(MemberDTO dto) throws SQLException
	{
		// 결과 값 담을 변수
		int result =0;
		
		// 작업 객체 생성
		Statement stmt = conn.createStatement();
		
		// 쿼리문 준비
		String sql = String.format("INSERT INTO TBL_EMP(EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_ID, TEL, BUSEO_ID, JIKWI_ID, BASICPAY, SUDANG)"
				+ " VALUES(EMPSEQ.NEXTVAL, '%s', '%s', TO_DATE('%s', 'YYYY-MM-DD'), (SELECT CITY_ID FROM TBL_CITY WHERE CITY_NAME = '%s'), '%s', (SELECT BUSEO_ID FROM TBL_BUSEO WHERE BUSEO_NAME = '%s'), (SELECT JIKWI_ID FROM TBL_JIKWI WHERE JIKWI_NAME = '%s'), %d, %d)"
				, dto.getEmpName(), dto.getSsn(), dto.getIbsadate(), dto.getCityName(), dto.getBuseoName(), dto.getJikwiName(), dto.getBasicPay(), dto.getSudang()); 
		
		result = stmt.executeUpdate(sql);
		
		stmt.close();
				
		return result;
	}
	
	
	// 전체 직원 수
	public int count() throws SQLException
	{
		int result = 0;
		
		Statement stmt = conn.createStatement();
		
		String sql = "SELECT COUNT(*) AS COUNT FROM TBL_EMP";
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			rs.getInt("COUNT");
			
		}
		
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 선택 직원 수
	public int searchCount(String key, String value) throws SQLException
	{
		int result = 0;
		
		Statement stmt = conn.createStatement();
		
		String sql = String.format("SELECT COUNT(*) AS COUNT"
							+ " FROM VIEW_EMP"
							+ " WHERE %s = '%s'"
							, key, value);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			rs.getInt("COUNT");
			
		}
		
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 전체 직원 출력
	public ArrayList<MemberDTO>lists(String key) throws SQLException
	{
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = String.format("SELECT E.EMP_ID, E.EMP_NAME, E.SSN"
				+ ", E.IBSADATE, C.CITY_NAME, E.TEL, B.BUSEO_NAME"
				+ ", J.JIKWI_NAME, E.BASICPAY,E.SUDANG,(NVL(E.BASICPAY, 0)*12)+E.SUDANG AS SALARY"
				+ " FROM TBL_EMP E LEFT JOIN TBL_CITY C ON E.CITY_ID = C.CITY_ID"
				+ " JOIN TBL_BUSEO B ON E.BUSEO_ID = B.BUSEO_ID"
				+ " JOIN TBL_JIKWI J ON E.JIKWI_ID = J.JIKWI_ID"
				+ " ORDER BY %s"
				, key);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsadate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSalary(rs.getInt("SALARY"));
			
			result.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 선택 출력
	public ArrayList<MemberDTO>searchLists(String key, String value) throws SQLException
	{
		ArrayList<MemberDTO> result = new ArrayList<MemberDTO>();
		
		Statement stmt = conn.createStatement();
		
		String sql = "";
		
		if (key.equals("EMP_ID"))
		{
			sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME, BASICPAY, SUDANG, SALARY"
					+ " FROM VIEW_EMP"
					+ " WHERE %s = %s", key, value);
		}
		else 
		{
			sql = String.format("SELECT EMP_ID, EMP_NAME, SSN, IBSADATE, CITY_NAME, TEL, BUSEO_NAME, JIKWI_NAME, BASICPAY, SUDANG, SALARY"
					+ " FROM VIEW_EMP"
					+ " WHERE %s ='%s'", key, value);
		}
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while (rs.next())
		{
			MemberDTO dto = new MemberDTO();
			
			dto.setEmpId(rs.getString("EMP_ID"));
			dto.setEmpName(rs.getString("EMP_NAME"));
			dto.setSsn(rs.getString("SSN"));
			dto.setIbsadate(rs.getString("IBSADATE"));
			dto.setCityName(rs.getString("CITY_NAME"));
			dto.setTel(rs.getString("TEL"));
			dto.setBuseoName(rs.getString("BUSEO_NAME"));
			dto.setJikwiName(rs.getString("JIKWI_NAME"));
			dto.setBasicPay(rs.getInt("BASICPAY"));
			dto.setSalary(rs.getInt("SALARY"));
			
			result.add(dto);
			
		}
		
		rs.close();
		stmt.close();
		
		return result;
	}
	
	// 지역 리스트
	//SELECT CITY_NAME FROM TBL_CITY
	public ArrayList<String>cityList() throws SQLException
	{
		ArrayList<String> result = new ArrayList<String>();
		Statement stmt = conn.createStatement();
		String sql = "SELECT CITY_NAME FROM TBL_CITY";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
			result.add(rs.getString("CITY_NAME"));
		rs.close();
		stmt.close();
		
		return result;
	}
	
	// 부서 리스트
	//SELECT BUSEO_NAME FROM TBL_BUSEO
	public ArrayList<String>buseoList() throws SQLException
	{
		ArrayList<String> result = new ArrayList<String>();
		Statement stmt = conn.createStatement();
		String sql = "SELECT BUSEO_NAME FROM TBL_BUSEO";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
			result.add(rs.getString("BUSEO_NAME"));
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 직위 리스트
	//SELECT JIKWI_NAME FROM TBL_JIKWI
	public ArrayList<String>jikwiList() throws SQLException
	{
		ArrayList<String> result = new ArrayList<String>();
		Statement stmt = conn.createStatement();
		String sql = "SELECT JIKWI_NAME FROM TBL_JIKWI";
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
			result.add(rs.getString("JIKWI_NAME"));
		
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 최소 수당
	//SELECT MIN_BASICPAY FROM TBL_JIKWI WHERE JIKWI_NAME = '사장'
	public int minBasicPayList(String jikwi) throws SQLException
	{
		int result = 0;
		Statement stmt = conn.createStatement();
		String sql = String.format("SELECT MIN_BASICPAY FROM TBL_JIKWI WHERE JIKWI_NAME = '%s'", jikwi);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next())
			result = rs.getInt("MIN_BASICPAY");
		rs.close();
		stmt.close();
		
		return result;
	}
	
	
	// 수정
	public int modify(MemberDTO dto) throws SQLException
	{
		int result = 0;
		
		Statement stmt = conn.createStatement();
		
		String sql = String.format("UPDATE TBL_EMP"
				+ " SET EMP_NAME = '%s', SSN = '%s', IBSADATE = TO_DATE('%s','YYYY-MM-DD') "
				+ ", CITY_ID = (SELECT CITY_ID FROM TBL_CITY WHERE CITY_NAME = '%s'), TEL = '%s'"
				+ ", BUSEO_ID = (SELECT BUSEO_ID FROM TBL_BUSEO WHERE BUSEO_NAME = '%s')"
				+ ", JIKWI_ID = (SELECT JIKWI_ID FROM TBL_JIKWI WHERE JIKWI_NAME ='%s')"
				+ ", BASICPAY = %d, SUDANG = %d WHERE EMP_ID = %s"
				, dto.getEmpName(), dto.getSsn(), dto.getIbsadate()
				, dto.getCityName(), dto.getTel(), dto.getBuseoName()
				, dto.getJikwiName(), dto.getBasicPay(),dto.getSudang(), dto.getEmpId());
		
		result = stmt.executeUpdate(sql);
		stmt.close();
		
		return result;
	}
	
	// 삭제
	public int remove(String empId) throws SQLException
	{
		int result = 0;
		Statement stmt = conn.createStatement();
		String sql = String.format("DELETE FROM TBL_EMP WHERE EMP_ID = %s", empId);
		result = stmt.executeUpdate(sql);
		
		stmt.close();		
		return result;
	}
	
	
}
