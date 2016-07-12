package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ExamRecord implements Serializable
{
	private static final long serialVersionUID = -7439048911265638235L;

	private int idexam;
	private int idu;
	private String examname;
	private String uname;
	@JSONField (format="yyyy-MM-dd")
	private Date examdate;
	private int exammark;
	private int idexamre;
	private float examprice;
	@JSONField (format="yyyy-MM-dd")
	private Date date;
	
	public int getIdexam()
	{
		return idexam;
	}
	public void setIdexam(int idexam)
	{
		this.idexam = idexam;
	}
	public int getIdu()
	{
		return idu;
	}
	public void setIdu(int idu)
	{
		this.idu = idu;
	}
	public String getExamname()
	{
		return examname;
	}
	public void setExamname(String examname)
	{
		this.examname = examname;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public Date getExamdate()
	{
		return examdate;
	}
	public void setExamdate(Date examdate)
	{
		this.examdate = examdate;
	}
	public int getExammark()
	{
		return exammark;
	}
	public void setExammark(int exammark)
	{
		this.exammark = exammark;
	}
	public int getIdexamre()
	{
		return idexamre;
	}
	public void setIdexamre(int idexamre)
	{
		this.idexamre = idexamre;
	}
	public float getExamprice()
	{
		return examprice;
	}
	public void setExamprice(float examprice)
	{
		this.examprice = examprice;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	
}
