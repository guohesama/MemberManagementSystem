package com.engsys.pojo;

import java.io.Serializable;

public class Admin implements Serializable 
{
	private static final long serialVersionUID = -2634170502335673038L;
	
	private String adname;
	private String adpwd;
	private int idadmin;
	
	public String getAdname() 
	{
		return adname;
	}
	public void setAdname(String adname) 
	{
		this.adname = adname;
	}
	public String getAdpwd() 
	{
		return adpwd;
	}
	public void setAdpwd(String adpwd) 
	{
		this.adpwd = adpwd;
	}
	public int getIdadmin() 
	{
		return idadmin;
	}
	public void setIdadmin(int idadmin) 
	{
		this.idadmin = idadmin;
	}
	
}
