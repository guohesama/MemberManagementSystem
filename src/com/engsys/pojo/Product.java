package com.engsys.pojo;

import java.io.Serializable;

public class Product implements Serializable
{
	private static final long serialVersionUID = 5221872897052289118L;
	
	private int idprod;
	private String prodname;
	private int prodprice;
	private int prodmargin;
	private int prodtype;
	
	public int getIdprod()
	{
		return idprod;
	}
	public void setIdprod(int idprod)
	{
		this.idprod = idprod;
	}
	public String getProdname()
	{
		return prodname;
	}
	public void setProdname(String prodname)
	{
		this.prodname = prodname;
	}
	public int getProdprice()
	{
		return prodprice;
	}
	public void setProdprice(int prodprice)
	{
		this.prodprice = prodprice;
	}
	public int getProdmargin()
	{
		return prodmargin;
	}
	public void setProdmargin(int prodmargin)
	{
		this.prodmargin = prodmargin;
	}
	public int getProdtype()
	{
		return prodtype;
	}
	public void setProdtype(int prodtype)
	{
		this.prodtype = prodtype;
	}
}
