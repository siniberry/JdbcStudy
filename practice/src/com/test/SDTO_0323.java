package com.test;

public class SDTO_0323
{
	// 주요 변수 선언
	private String name;
	private int sid, kor, eng, mat, tot;
	private double avg;
	
	
	// getter / setter
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getSid()
	{
		return sid;
	}
	public void setSid(int sid)
	{
		this.sid = sid;
	}
	public int getKor()
	{
		return kor;
	}
	public void setKor(int kor)
	{
		this.kor = kor;
	}
	public int getEng()
	{
		return eng;
	}
	public void setEng(int eng)
	{
		this.eng = eng;
	}
	public int getMat()
	{
		return mat;
	}
	public void setMat(int mat)
	{
		this.mat = mat;
	}
	public int getTot()
	{
		return tot;
	}
	public void setTot(int kor, int eng, int mat)
	{
		this.tot = kor + eng + mat;
	}
	public double getAvg()
	{
		return avg;
	}
	public void setAvg(int kor, int eng, int mat)
	{
		this.avg = (kor + eng + mat)/3.0;
	}
	

	
	
}
