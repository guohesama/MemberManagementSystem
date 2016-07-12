package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Examination implements Serializable
{
	private static final long serialVersionUID = -5837730736849824762L;
	
	private int idexam;
	private String examname;
	private String examtime;
	private String examplace;
	private float examprice;
	@JSONField (format="yyyy-MM-dd")
	private Date examdate;
	
	public int getIdexam()
	{
		return idexam;
	}
	public void setIdexam(int idexam)
	{
		this.idexam = idexam;
	}
	public String getExamname()
	{
		return examname;
	}
	public void setExamname(String examname)
	{
		this.examname = examname;
	}
	public String getExamtime()
	{
		return examtime;
	}
	public void setExamtime(String examtime)
	{
		this.examtime = examtime;
	}
	public String getExamplace()
	{
		return examplace;
	}
	public void setExamplace(String examplace)
	{
		this.examplace = examplace;
	}
	public float getExamprice()
	{
		return examprice;
	}
	public void setExamprice(float examprice)
	{
		this.examprice = examprice;
	}
	public Date getExamdate()
	{
		return examdate;
	}
	public void setExamdate(Date examdate)
	{
		this.examdate = examdate;
	}
}
