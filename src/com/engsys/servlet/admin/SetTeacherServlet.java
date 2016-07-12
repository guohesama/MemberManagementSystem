package com.engsys.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.Teacher;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/TeachSet")
public class SetTeacherServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		List<Teacher> list=aos.showTeacher();
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
	
	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Teacher teach=new Teacher();
		JSONObject result= new JSONObject();
		this.getBean(req, teach);
		if(null!=as.queryTeacher(teach.getIdteach()))
		{
			result.put("errorMsg", "exsited");
		}
		else
		{
			as.addTeacher(teach);
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Teacher teach=new Teacher();
		JSONObject result= new JSONObject();
		this.getBean(req, teach);
		if(null==as.queryTeacher(teach.getIdteach()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			as.deleteTeacher(teach.getIdteach());
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());

	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Teacher teach=new Teacher();
		JSONObject result= new JSONObject();
		this.getBean(req, teach);
		if(null==as.queryTeacher(teach.getIdteach()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			as.updateTeacher(teach);
		}
		ResponseUtil.write(resp, result.toString());

	}
}
