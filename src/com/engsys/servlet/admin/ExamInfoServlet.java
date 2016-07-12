package com.engsys.servlet.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.ConRecord;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.Member;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/ExamInfo")
public class ExamInfoServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		List<ExamRecord> list=rs.queryExamRecord();
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Date start=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
		Date end=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("enddate"));
		JSONObject result= new JSONObject();
		if(!rs.deleteExamRecord(start, end))
		{
			result.put("errorMsg", "fail");
		}
		else
		{
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		JSONObject result= new JSONObject();
	//	ExamRecord exam=new ExamRecord();
		int exammark=Integer.parseInt(req.getParameter("exammark"));
		int idexamre=Integer.parseInt(req.getParameter("idexamre"));
	//	System.out.println(exam.getIdexamre());
	//	System.out.println(req.getParameter("exammark"));
	//	System.out.println(req.getParameter("idexamre"));
		if(!rs.updateExamRecord(idexamre,exammark))
		{
			result.put("errorMsg", "fail");
		}
		else
		{
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void memExam(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member mem=(Member)req.getSession().getAttribute("curMember");
		List<ExamRecord> list=rs.queryExamRecord(mem.getUname());
		
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
}
