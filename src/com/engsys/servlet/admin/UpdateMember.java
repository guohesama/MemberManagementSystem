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
import com.engsys.util.ResponseUtil;

@WebServlet("/UpdateMember")
public class UpdateMember extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member member=new Member();
		this.getBean(req, member);
		System.out.print(member);
		JSONObject result= new JSONObject();
		if(null!=as.queryMember(member.getUname()))
		{
			as.updateMember(member);
			result.put("success", "update successful");
		}
		else
		{
			result.put("errorMsg", "no this user");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(result.toString());
		out.flush();
		out.close();
	}
	
	public void member(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member member=new Member();
		this.getBean(req, member);
		Member mem=(Member)req.getSession().getAttribute("curMember");
		member.setUname(mem.getUname());
		member.setIdu(mem.getIdu());
		JSONObject result= new JSONObject();
		if(null!=as.queryMember(member.getUname()))
		{
			as.updateMember(member);
			result.put("success", "update successful");
		}
		else
		{
			result.put("errorMsg", "no this user");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(result.toString());
		out.flush();
		out.close();
	}
}
