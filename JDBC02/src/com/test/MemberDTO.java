package com.test;

// getter(가져오기)/setter(보내기) 구성

public class MemberDTO
{
	// 주요 속성 구성
	private String sid, name, tel;
	//-- private 이기 때문에 getter / setter 가 필요
	// 우클릭 → Source → Generate Getter and Setters 로 
	// 한번에 만들 수 있음
	
	// getter / setter 구성
	public String getSid()
	{
		return sid;
	}

	public void setSid(String sid)
	{
		this.sid = sid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	
}
