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
@WebServlet("/PayMember")
public class PayMemberServlet extends ServletBase
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
			member.setUbalance(mem.getUbalance()+member.getUbalance());
			member.setUlevel(mem.getUlevel()+member.getUlevel());
			member.setUpoints(mem.getUpoints()+member.getUpoints()+(int)member.getUbalance());
			aos.payMember(member);
			as.upadeMember(member.getUlevel(), member.getUpoints(), member.getIdu());
			result.put("success", "pay successful");
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
