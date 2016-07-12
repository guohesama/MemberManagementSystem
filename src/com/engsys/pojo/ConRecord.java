package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class ConRecord implements Serializable
{
	private static final long serialVersionUID = 8742895942221243533L;
	
	private int idcon;
	private int idprod;
	@JSONField (format="yyyy-MM-dd")
	private Date condate;
	private int idu;
	private String uname;
	private String prodname;
	private float prodprice;
	private int number;
	private float totalprice;
	
	public int getIdcon()
	{
		return idcon;
	}
	public void setIdcon(int idcon)
	{
		this.idcon = idcon;
	}
	public int getIdprod()
	{
		return idprod;
	}
	public void setIdprod(int idprod)
	{
		this.idprod = idprod;
	}
	public Date getCondate()
	{
		return condate;
	}
	public void setCondate(Date condate)
	{
		this.condate = condate;
	}
	public int getIdu()
	{
		return idu;
	}
	public void setIdu(int idu)
	{
		this.idu = idu;
	}
	public String getUname()
	{
		return uname;
	}
	public void setUname(String uname)
	{
		this.uname = uname;
	}
	public String getProdname()
	{
		return prodname;
	}
	public void setProdname(String prodname)
	{
		this.prodname = prodname;
	}
	public float getProdprice()
	{
		return prodprice;
	}
	public void setProdprice(float prodprice)
	{
		this.prodprice = prodprice;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public float getTotalprice()
	{
		return totalprice;
	}
	public void setTotalprice(float totalprice)
	{
		this.totalprice = totalprice;
	}
}
