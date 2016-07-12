package com.engsys.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.ClassRoom;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/RoomSet")
public class SetRoomServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		List<ClassRoom> list=aos.showClassRoom();
		ResponseUtil.write(resp, JSON.toJSONString(list));
		
	}
	public void add(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		ClassRoom room=new ClassRoom();
		JSONObject result= new JSONObject();
		this.getBean(req, room);
		if(null!=as.queryClassRoom(room.getIdroom()))
		{
			result.put("errorMsg", "existed");
		}
		else
		{
			as.addClassRoom(room);
		}
		ResponseUtil.write(resp, result.toString());
	}
	
	public void update(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		ClassRoom room=new ClassRoom();
		JSONObject result= new JSONObject();
		this.getBean(req, room);
		if(null==as.queryClassRoom(room.getIdroom()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			if(as.updateClassRoom(room))
			{
				result.put("success", "true");
			}
			else
			{
				result.put("errorMsg", "add fail");
			}
				
		}
		ResponseUtil.write(resp, result.toString());
	}
	public void delete(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		ClassRoom room=new ClassRoom();
		JSONObject result= new JSONObject();
		this.getBean(req, room);
		if(null==as.queryClassRoom(room.getIdroom()))
		{
			result.put("errorMsg", "no this id");
		}
		else
		{
			if(as.deleteClassRoom(room.getIdroom()))
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
}
