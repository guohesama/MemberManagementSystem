package com.engsys.servlet.admin;

import java.io.IOException;
import java.util.Date;
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
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.SCourse;
import com.engsys.pojo.Subject;
import com.engsys.servlet.core.ServletBase;
import com.engsys.util.ResponseUtil;
@WebServlet("/Buy")
public class MemberBuy extends ServletBase
{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		ExamRecord examre=new ExamRecord();
		Examination exam=new Examination();
		JSONObject result= new JSONObject();
		Member mem=(Member)req.getSession().getAttribute("curMember");
		int idexam=Integer.parseInt(req.getParameter("idexam"));
		exam=as.queryExamination(idexam);
		Date date=new Date();
		examre.setDate(exam.getExamdate());
		examre.setExamdate(date);
		examre.setExamname(exam.getExamname());
		examre.setExamprice(exam.getExamprice());
		examre.setIdexam(idexam);
		examre.setIdu(mem.getIdu());
		examre.setUname(mem.getUname());
		float balance=mem.getUbalance()-exam.getExamprice();
		if(balance<0)
		{
			result.put("errorMsg", "余额不足");
		}	
		else
		{
			if(rs.addExamRecord(examre))
			{
				as.updateMember(balance, mem.getIdu());
				result.put("success", "true");
			}
			else
			{
				result.put("errorMsg", "error");
			}
		}
		ResponseUtil.write(resp, result.toJSONString());
	}

	public void product(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception
	{
		int idprod=Integer.parseInt(req.getParameter("idprod"));
		Product pro=as.queryProduct(idprod);
		ConRecord con=new ConRecord();
		JSONObject result= new JSONObject();
		Member mem=(Member)req.getSession().getAttribute("curMember");
		float balance=mem.getUbalance()-pro.getProdprice();
		if(pro.getProdmargin()<1)
		{
			result.put("errorMsg", "余量不足");
		}
		else
		{
			if(balance<0)
			{
				result.put("errorMsg", "余额不足");
			}
			else
			{
				Date date=new Date();
				con.setCondate(date);
				con.setIdprod(idprod);
				con.setIdu(mem.getIdu());
				con.setProdname(pro.getProdname());
				con.setProdprice(pro.getProdprice());
				con.setNumber(1);
				con.setTotalprice(pro.getProdprice());
				con.setUname(mem.getUname());
				pro.setProdmargin(pro.getProdmargin()-1);
				as.updateProduct(pro);
				rs.addConRecord(con);
				result.put("success", "true");
			}
		}
		ResponseUtil.write(resp, result.toJSONString());
	}

	public void membercourse(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception	
	{
		List<Course> list=aos.showCourse();
		List<SCourse> slist=mos.showSCourse(list);
		//System.out.println(JSON.toJSONString(slist));
		ResponseUtil.write(resp, JSON.toJSONString(slist));
	}
	
	public void memberselect(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception	
	{
		int idcour=Integer.parseInt(req.getParameter("idcour"));
		Member mem=(Member)req.getSession().getAttribute("curMember");
		Course cour=as.queryCourse(idcour);
		Subject sub=new Subject();
		sub.setIdcour(idcour);
		sub.setIdu(mem.getIdu());
		JSONObject result= new JSONObject();
		Date date=new Date();
		if(null!=as.querySubject(idcour, mem.getIdu()))
		{
			result.put("errorMsg", "请不要重复选课");
		}
		else if((cour.getCurnum() + 1) > cour.getMaxnum())
		{
			result.put("errorMsg", "人数已满");
		}
		else if(cour.getCourenddate().before(date))
		{
			result.put("errorMsg", "本课程已结束");
		}
		else if(as.addSubject(sub))
		{
			cour.setCurnum(cour.getCurnum()+1);
			as.updateCourse(cour);
			result.put("success", "true");
		}
		ResponseUtil.write(resp, result.toJSONString());
	}
}
