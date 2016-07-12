package com.engsys.servlet.admin;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.Course;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.Subject;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/CourseSet")
public class CourseSetServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		List<Course> list=aos.showCourse();
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Course cour=new Course();
		JSONObject result= new JSONObject();
		this.getBean(req, cour);
		if(!as.addCourse(cour))
		{
			result.put("errorMsg", "fail");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Course cour=new Course();
		JSONObject result= new JSONObject();
		this.getBean(req, cour);
		if(null==as.queryCourse(cour.getIdcour()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			if(as.deleteCourse(cour.getIdcour()))
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
		Course cour=new Course();
		JSONObject result= new JSONObject();
		this.getBean(req, cour);
		if(!as.updateCourse(cour))
		{
			result.put("errorMsg", "fail");
		}
		ResponseUtil.write(resp, result.toString());
	}
	public void memCour(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Member mem=(Member)req.getSession().getAttribute("curMember");
		//System.out.println("1");
		List<Subject> slist=as.querySubjectu(mem.getIdu());
		List<Course> list=new LinkedList<Course>();
		for(Subject s:slist)
		{
			list.add(as.queryCourse(s.getIdcour()));
		}
		
		ResponseUtil.write(resp, JSON.toJSONString(mos.showSCourse(list)));
	}
}
