package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class CourRecord implements Serializable
{
	private static final long serialVersionUID = -6372644550720328261L;
	
	private int idcourre;
	private String uname;
	private String courname;
	@JSONField (format="yyyy-MM-dd")
	private Date courdate;
	private float courprice;
	@JSONField (format="yyyy-MM-dd")
	private Date date;
	
	public int getIdcourre()
	{
		return idcourre;
	}
	public void setIdcourre(int idcourre)
	{
		this.idcourre = idcourre;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getCourname()
	{
		return courname;
	}
	public void setCourname(String courname)
	{
		this.courname = courname;
	}
	public Date getCourdate()
	{
		return courdate;
	}
	public void setCourdate(Date courdate)
	{
		this.courdate = courdate;
	}
	public float getCourprice()
	{
		return courprice;
	}
	public void setCourprice(float courprice)
	{
		this.courprice = courprice;
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
