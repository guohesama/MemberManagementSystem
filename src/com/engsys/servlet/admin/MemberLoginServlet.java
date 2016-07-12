package com.engsys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.Member;
import com.engsys.servlet.core.ServletBase;
@WebServlet("/MemberLogin")
public class MemberLoginServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
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

	}

}
