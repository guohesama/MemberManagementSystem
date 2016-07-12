package com.engsys.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.ConRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.Member;
import com.engsys.pojo.Subject;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/ConInfo")
public class ConInfoServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		String sstart=(String)req.getParameter("startdate");
		String send=(String)req.getParameter("enddate");
		List<ConRecord> list=null;
		if(sstart==null)
		{
			list=rs.QueryConRecord();
		}
		else
		{
			Date start=new SimpleDateFormat("yyyy-MM-dd").parse(sstart);
			Date end=new SimpleDateFormat("yyyy-MM-dd").parse(send);
			list=rs.QueryConRecord(start, end);
			//System.out.println(list);
		}
		ResponseUtil.write(resp, JSON.toJSONString(list));

	}

	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Date start=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
		Date end=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("enddate"));
		JSONObject result= new JSONObject();
		if(!rs.deleteConRecord(start, end))
		{
			result.put("errorMsg", "fail");
		}
		else
		{
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void memCon(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member mem=(Member)req.getSession().getAttribute("curMember");
		String sstart=(String)req.getParameter("startdate");
		String send=(String)req.getParameter("enddate");
		
		List<ConRecord> list=null;
		//System.out.println(sstart);
		//System.out.println("1");
		if(sstart==null)
		{
			list=rs.QueryConRecord(mem.getUname());			
		}
		else
		{
			Date start=new SimpleDateFormat("yyyy-MM-dd").parse(sstart);
			Date end=new SimpleDateFormat("yyyy-MM-dd").parse(send);
			list=rs.QueryConRecord(start, end);
			//System.out.println(list);
		}
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
}
