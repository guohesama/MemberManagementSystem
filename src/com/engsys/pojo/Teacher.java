package com.engsys.pojo;

import java.io.Serializable;

public class Teacher implements Serializable
{
	private static final long serialVersionUID = 3098354765189876891L;
	
	private int idteach;
	private String teachname;
	private int teachsex;
	private String teachtelephone;
	
	public int getIdteach()
	{
		return idteach;
	}
	public void setIdteach(int idteach)
	{
		this.idteach = idteach;
	}
	public String getTeachname()
	{
		return teachname;
	}
	public void setTeachname(String teachname)
	{
		this.teachname = teachname;
	}
	public int getTeachsex()
	{
		return teachsex;
	}
	public void setTeachsex(int teachsex)
	{
		this.teachsex = teachsex;
	}
	public String getTeachtelephone()
	{
		return teachtelephone;
	}
	public void setTeachtelephone(String teachtelephone)
	{
		this.teachtelephone = teachtelephone;
	}
}
