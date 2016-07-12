package com.engsys.servlet.core;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.ConRecord;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.Product;
import com.engsys.pojo.Teacher;
@WebServlet("/hello")
public class HelloServlet extends ServletBase
{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		Admin admin=new Admin();
		this.getBean(req, admin);
		try
		{
			if(null!=as.adCheckLogin(admin.getAdname(), admin.getAdpwd()))
			out.println("<h1>success</h1>");
			else
				out.println("<h1>failed<h1>");
		} catch (SQLException e)
		{
			out.println("<h1>error</h1>");
		}
		out.close();
	}
	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		Admin admin=new Admin();
		this.getBean(req, admin);
		try
		{
			as.addAdmin(admin);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			out.println("<h1>failed<h1>");
			e.printStackTrace();
		}
		out.close();
		
	}
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		
		Admin admin=new Admin();
		this.getBean(req, admin);
		//admin.setIdadmin(1);
		try
		{
			if(as.updateAdmin(admin))
			out.println("<h1>success</h1>");
			else
				out.println("<h1>error<h1>");
		} catch (Exception e)
		{
			out.println("<h1>error<h1>");
		}
		out.close();
		
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println("<h1>delete</h1>");
		out.close();
	}
}