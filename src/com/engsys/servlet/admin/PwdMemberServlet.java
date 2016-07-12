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
import com.engsys.util.Md5Encrypt;
@WebServlet("/PwdMember")
public class PwdMemberServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member member=new Member();
		this.getBean(req, member);
		JSONObject result= new JSONObject();
		Member mem=null;
		mem=as.queryMember(member.getUname());
		if(null!=mem)
		{
			member.setIdu(mem.getIdu());
			mos.memChangePassword(member);
			result.put("success", "change successful");
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
		Member mem=(Member)req.getSession().getAttribute("curMember");
		String upwd=req.getParameter("upwd");
		String passpwd=req.getParameter("passpwd");
		JSONObject result= new JSONObject();
		//System.out.println(mem.getUpwd());
		if(Md5Encrypt.md5(passpwd).equals(mem.getUpwd()))
		{	
			if(as.updateMember(upwd, mem.getIdu()))
			{
				result.put("success", "true");
				mem.setUpwd(Md5Encrypt.md5(upwd));
				req.getSession().setAttribute("curMember", mem);
			}
			else
			{
				result.put("errorMsg", "error");
			}
		}
		else
		{
			result.put("errorMsg", "error");
		}
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(result.toString());
		out.flush();
		out.close();
	}
}
