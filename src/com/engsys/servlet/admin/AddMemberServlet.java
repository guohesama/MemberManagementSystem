package com.engsys.servlet.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.engsys.pojo.Admin;
import com.engsys.pojo.MMrecord;
import com.engsys.pojo.Member;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;

@WebServlet("/AddMember")
public class AddMemberServlet extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws Exception
	{
		Member member=new Member();
		this.getBean(req, member);
		JSONObject result= new JSONObject();
		
		try
		{
			if(null==as.queryMember(member.getUname()))
			{
				try
				{
					if(aos.addMember(member))
					{
						result.put("success", "add member successful");
						MMrecord mmre=new MMrecord();
						mmre.setIdu(member.getIdu());
						mmre.setUname(member.getUname());
						Date date=new Date();
						mmre.setDate(date);
						Admin ad=(Admin)req.getSession().getAttribute("userloged");
						System.out.println(ad.getIdadmin());
						mmre.setIdadmin(ad.getIdadmin());
						rs.addMMrecord(mmre);						
					}
				} catch (SQLException e)
				{
					result.put("errorMsg", "add member error");
					e.printStackTrace();
				}
			}
			else
			{
				result.put("errorMsg", "add member existed");
			}
		} catch (SQLException e1)
		{
			result.put("errorMsg", "add member error");
			e1.printStackTrace();
		}
		ResponseUtil.write(resp, result.toString());
	/*	try
		{
			ResponseUtil.write(resp, result.toString());
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
