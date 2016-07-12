package com.engsys.pojo;

import java.io.Serializable;

public class Member implements Serializable 
{
	private static final long serialVersionUID = -6876892471454737842L;
	
	private String uname;
	private String upwd;
	private String urealname;
	private int idu;
	private int usex;
	private int uage;
	private String utelephone;
	private int ulevel;
	private int upoints;
	private float ubalance;
	
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getUpwd()
	{
		return upwd;
	}
	public void setUpwd(String upwd)
	{
		this.upwd = upwd;
	}
	public String getUrealname()
	{
		return urealname;
	}
	public void setUrealname(String urealname)
	{
		this.urealname = urealname;
	}
	public int getIdu()
	{
		return idu;
	}
	public void setIdu(int idu)
	{
		this.idu = idu;
	}
	public int getUsex()
	{
		return usex;
	}
	public void setUsex(int usex)
	{
		this.usex = usex;
	}
	public int getUage()
	{
		return uage;
	}
	public void setUage(int uage)
	{
		this.uage = uage;
	}
	public String getUtelephone()
	{
		return utelephone;
	}
	public void setUtelephone(String utelephone)
	{
		this.utelephone = utelephone;
	}
	public int getUlevel()
	{
		return ulevel;
	}
	public void setUlevel(int ulevel)
	{
		this.ulevel = ulevel;
	}
	public int getUpoints()
	{
		return upoints;
	}
	public void setUpoints(int upoints)
	{
		this.upoints = upoints;
	}
	public float getUbalance()
	{
		return ubalance;
	}
	public void setUbalance(float ubalance)
	{
		this.ubalance = ubalance;
	}

}