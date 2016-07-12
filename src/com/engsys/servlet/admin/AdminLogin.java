package com.engsys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.Admin;
import com.engsys.pojo.Member;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/AdminLogin")
public class AdminLogin extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
			Admin admin=new Admin();
			this.getBean(req, admin);
			JSONObject result= new JSONObject();
			Admin loginadmin=null;
			loginadmin=aos.adminCheckLogin(admin);
			if(null!=loginadmin)
			{
				req.getSession().setAttribute("userloged",loginadmin);
			}
			else
			{
				result.put("errorMsg", "用户名密码错误");
			}
			resp.setContentType("text/html;charset=utf-8");
			PrintWriter out=resp.getWriter();
			out.println(result.toString());
			out.flush();
			out.close();

			//ResponseUtil.write(resp, result.toString());
	}
	
	/*public void member(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Member mem=new Member();
		//System.out.println("1");
		this.getBean(req,mem);
		JSONObject result= new JSONObject();
		Member loginmem=null;
		loginmem=as.memCheckLogin(mem.getUname(), mem.getUpwd());
		if(null!=loginmem)
		{
			req.getSession().setAttribute("curMember",loginmem);
		}
		else
		{
			result.put("errorMsg", "用户名密码错误");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(result.toString());
		out.flush();
		out.close();
	}*/
}
