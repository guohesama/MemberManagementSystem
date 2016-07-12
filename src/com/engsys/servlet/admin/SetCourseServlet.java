package com.engsys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONToken;
import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/AdminSet")
public class SetCourseServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Course course=new Course();
		this.getBean(req, course);
		JSONObject result= new JSONObject();
		if(null==as.queryClassRoom(course.getIdroom()))
		{
			result.put("errorMsg", "教室不存在");
		}
		else if(null==as.queryTeacher(course.getIdteach()))
		{
			result.put("errorMsg", "不存在");
		}
		else if(!as.addCourse(course))
		{
			result.put("errorMsg", "Add course fail");
		}
		ResponseUtil.write(resp, result.toString());
	}

	public void setexam(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Examination exam=new Examination();
		this.getBean(req, exam);
		JSONObject result= new JSONObject();
		try
		{
			if(!as.addExamination(exam))
			{
				result.put("errorMsg", "Add exam fail");
			}
		} catch (SQLException e)
		{
			result.put("errorMsg", "Add exam fail");
			e.printStackTrace();
		}
		ResponseUtil.write(resp, result.toString());
	}
	public void updateExam(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Examination exam=new Examination();
		this.getBean(req, exam);
		System.out.println(exam.getIdexam());
		JSONObject result= new JSONObject();
		try
		{
			if(!as.updateExamination(exam))
			{
				result.put("errorMsg", "Add exam fail");
			}
		} catch (SQLException e)
		{
			result.put("errorMsg", "Add exam fail");
			e.printStackTrace();
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void showExam(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		List<Examination> list = aos.showExamnation();
		out.println(JSON.toJSONString(list));
		out.flush();
		out.close();
	}
	
	public void deleteExam(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Examination exam=new Examination();
		this.getBean(req, exam);
		JSONObject result= new JSONObject();
		if(null==as.queryExamination(exam.getIdexam()))
		{
			result.put("errorMsg", "无此考试");
		}
		else{
			as.deleteExamination(exam.getIdexam());
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void changeAdminPwd(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		String adpwd=req.getParameter("adpwd");
		String newpwd=req.getParameter("newpwd");
		JSONObject result= new JSONObject();
		System.out.println(newpwd);
		Admin ad=(Admin)req.getSession().getAttribute("userloged");
		Admin admin=as.adCheckLogin(ad.getAdname(), adpwd);
		if(null!=admin)
		{
			admin.setAdpwd(newpwd);
			aos.adminChangePassword(admin);
		}
		else
		{
			result.put("errorMsg", "密码错误");
		}
		ResponseUtil.write(resp, result.toString());
	}
	public void todaycourse(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Date date=new Date();
		List<Course> list=aos.showTodayCourse(date);
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
	public void signin(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		CourRecord courre= new CourRecord();
		int idcour=Integer.parseInt(req.getParameter("idcour"));
		String uname=req.getParameter("uname");
		Member mem=as.queryMember(uname);
		JSONObject result= new JSONObject();
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dt=sdf.format(date);
		Course cour=as.queryCourse(idcour);
		/*
		 * 有bug date查询失败
		 * 
		 */
		if(null!=rs.QueryCourRecord(uname,dt,cour.getCourname()))
		{
			result.put("errorMsg","请不要重复签到");
		}
		else
		{
			if(null!=as.querySubject(idcour, mem.getIdu()))
			{
				
				courre.setCourdate(date);
				courre.setCourname(cour.getCourname());
				courre.setCourprice(cour.getCourprice());
				courre.setDate(date);
				courre.setUname(uname);
				rs.addCourRecord(courre);
				ClassRoom room=as.queryClassRoom(cour.getIdroom());
				int roombooked=room.getRoombooked()+1;
				if(room.getRoomseatings()>=roombooked)
				{
					room.setRoombooked(roombooked);
				
					as.updateClassRoom(room);
					float balance=(mem.getUbalance() - cour.getCourprice());
					if(balance<0)
					{
						result.put("errorMsg","余额不足");
					}
					else
					{
						//System.out.println(balance);
						as.updateMember(balance, mem.getIdu());
						result.put("success", "true");
					}
				}
				else
				{
					result.put("errorMsg","没有座位了");
				}
			}
			else
			{
				result.put("errorMsg","你没选这门课");
			}
		}
		ResponseUtil.write(resp, result.toString());
	}
}
