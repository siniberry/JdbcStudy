// -- 사번 이름 주민번호 입사일 지역 전화번호 부서 직위 기본급 수당 급여

package com.test;

public class MemberDTO
{
	// 주요 속성 구성
	private String empId, empName, ssn, ibsadate, cityName, tel, buseoName, jikwiName;
	private int basicPay, sudang, salary;

	// getter / setter
	public String getEmpId()
	{
		return empId;
	}

	public void setEmpId(String empId)
	{
		this.empId = empId;
	}

	public String getEmpName()
	{
		return empName;
	}

	public void setEmpName(String empName)
	{
		this.empName = empName;
	}

	public String getSsn()
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getIbsadate()
	{
		return ibsadate;
	}

	public void setIbsadate(String ibsadate)
	{
		this.ibsadate = ibsadate;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getBuseoName()
	{
		return buseoName;
	}

	public void setBuseoName(String buseoName)
	{
		this.buseoName = buseoName;
	}

	public String getJikwiName()
	{
		return jikwiName;
	}

	public void setJikwiName(String jikwiName)
	{
		this.jikwiName = jikwiName;
	}

	public int getBasicPay()
	{
		return basicPay;
	}

	public void setBasicPay(int basicPay)
	{
		this.basicPay = basicPay;
	}

	public int getSudang()
	{
		return sudang;
	}

	public void setSudang(int sudang)
	{
		this.sudang = sudang;
	}

	public int getSalary()
	{
		return salary;
	}

	public void setSalary(int salary)
	{
		this.salary = salary;
	}

	
	
	
	
}
