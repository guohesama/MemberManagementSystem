package com.engsys.pojo;

import java.io.Serializable;

public class Subject implements Serializable
{
	private static final long serialVersionUID = 6841273817162921205L;
	private int idsubject;
	private int idu;
	private int idcour;
	public int getIdsubject()
	{
		return idsubject;
	}
	public void setIdsubject(int idsubject)
	{
		this.idsubject = idsubject;
	}
	public int getIdu()
	{
		return idu;
	}
	public void setIdu(int idu)
	{
		this.idu = idu;
	}
	public int getIdcour()
	{
		return idcour;
	}
	public void setIdcour(int idcour)
	{
		this.idcour = idcour;
	}
	 
}
