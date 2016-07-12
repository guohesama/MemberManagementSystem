package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class MMrecord implements Serializable
{
	private static final long serialVersionUID = -1636228514746081470L;
	
	private int idmmre;
	private int idadmin;
	private int idu;
	@JSONField (format="yyyy-MM-dd")
	private Date date;
	private int opertype;
	private String uname;
	
	public int getIdmmre()
	{
		return idmmre;
	}
	public void setIdmmre(int idmmre)
	{
		this.idmmre = idmmre;
	}
	public int getIdadmin()
	{
		return idadmin;
	}
	public void setIdadmin(int idadmin)
	{
		this.idadmin = idadmin;
	}
	public int getIdu()
	{
		return idu;
	}
	public void setIdu(int idu)
	{
		this.idu = idu;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}
	public int getOpertype()
	{
		return opertype;
	}
	public void setOpertype(int opertype)
	{
		this.opertype = opertype;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
}
