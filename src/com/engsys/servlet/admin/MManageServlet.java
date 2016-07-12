package com.engsys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.MMrecord;
import com.engsys.pojo.Member;
import com.engsys.pojo.Subject;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;

import org.apache.commons.beanutils.BeanUtils;  
@WebServlet("/MMrecord")
public class MManageServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		List<MMrecord> list=null;
		list = rs.queryMMrecord();
		ResponseUtil.write(resp, JSON.toJSONString(list));
	}
	
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Date start=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
		Date end=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("enddate"));
		JSONObject result= new JSONObject();
		if(!rs.deleteMMrecord(start, end))
		{
			result.put("errorMsg", "fail");
		}
		else
		{
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}
		/*resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		CourRecord courre=new CourRecord();
		Course cour=new Course();
		Member mem=new Member();
		this.getBean(req, courre);
		try
		{
			mem=as.queryMember(courre.getUname());
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Subject> sub=null;
		if(null!=mem)
		{
			try
			{
				sub=as.querySubjectu(mem.getIdu());
			} catch (SQLException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(null!=sub)
		{
			for(Subject subject:sub)
			{
				try
				{
					cour=as.queryCourse(subject.getIdcour());
					Date date=new Date();
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					if(date.after(cour.getCourstartdate()) && date.before(cour.getCourenddate()) && as.getWeektoInt(cour.getDayofweek(), calendar.get(Calendar.DAY_OF_WEEK)))
					{
						try
						{
							BeanUtils.copyProperties(courre, cour);
							
						} catch (IllegalAccessException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (InvocationTargetException e)
						{
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						rs.addCourRecord(courre);
					}
					else
					{
						out.println("<h1>failed<h1>");
					}
				} catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		out.close();*/
}
