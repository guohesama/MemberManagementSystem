package com.engsys.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.Product;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/ProductSet")
public class SetProduct extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		// TODO Auto-generated method stub
		List<Product> list=aos.showProduct();
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}

	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Product product=new Product();
		JSONObject result= new JSONObject();
		this.getBean(req, product);
		if(!as.addProduct(product))
		{
			result.put("errorMsg", "fail");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Product product=new Product();
		JSONObject result= new JSONObject();
		this.getBean(req, product);
		if(null==as.queryProduct(product.getIdprod()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			if(as.deleteProduct(product.getIdprod()))
			{
				result.put("success", "true");
			}
			else
			{
				result.put("errorMsg", "delete fail");
			}
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Product product=new Product();
		JSONObject result= new JSONObject();
		this.getBean(req, product);
		if(!as.updateProduct(product))
		{
			result.put("errorMsg", "fail");
		}
		ResponseUtil.write(resp, result.toString());
	}
}
