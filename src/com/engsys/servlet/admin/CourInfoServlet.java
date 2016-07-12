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
import com.engsys.pojo.CourRecord;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/CourInfo")
public class CourInfoServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		List<CourRecord> list=rs.QueryCourRecord();
		ResponseUtil.write(resp, JSON.toJSONString(list));

	}

	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		Date start=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("startdate"));
		Date end=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("enddate"));
		JSONObject result= new JSONObject();
		if(!rs.deleteCourRecord(start, end))
		{
			result.put("errorMsg", "fail");
		}
		else
		{
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toString());
	}

}
