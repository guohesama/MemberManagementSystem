package com.engsys.service.imp;

import java.util.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.Course;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.Subject;
import com.engsys.pojo.Teacher;
import com.engsys.service.core.AdminOperationService;
import com.engsys.service.core.AdminService;
import com.engsys.service.core.RecordService;

public class AdminOperationServiceImp implements AdminOperationService
{
	AdminService as=new AdminServiceImp();
	RecordService rs=new RecordServiceImp();
	@Override
	public Admin adminCheckLogin(Admin admin) throws SQLException
	{
		Admin ad=new Admin();
		ad=as.adCheckLogin(admin.getAdname(), admin.getAdpwd());
		return ad;
	}

	@Override
	public boolean adminChangePassword(Admin admin) throws SQLException
	{
		return as.updateAdmin(admin);
	}

	@Override
	public Member ShowMemberInfo(Member member) throws SQLException
	{
		return as.queryMember(member.getIdu());
	}

	@Override
	public boolean updateMemberLevel(Member member) throws SQLException
	{
		return as.updateMember(member);
	}

	@Override
	public boolean payMember(Member member) throws SQLException
	{
		return as.updateMember(member.getUbalance(), member.getIdu());
	}

	
	@Override
	public boolean addMember(Member member) throws SQLException
	{
			return as.addMember(member);
	}

	@Override
	public List<Examination> showExamnation() throws SQLException
	{
		List<Examination> list=null;
		list=as.queryExamination();
		return list;
	}

	@Override
	public List<Course> showCourse() throws SQLException
	{
		List<Course> list=null;
		list=as.queryCourse();
		return list;
	}

	@Override
	public List<Product> showProduct() throws SQLException
	{
		List<Product> list=null;
		list=as.queryProduct();
		return list;
	}

	@Override
	public List<ClassRoom> showClassRoom() throws SQLException
	{
		List<ClassRoom> list=null;
		list=as.queryClassRoom();
		return list;
	}

	@Override
	public List<Teacher> showTeacher() throws SQLException
	{
		List<Teacher> list=null;
		list=as.queryTeacher();
		return list;
	}

	@Override
	public List<Course> showTodayCourse(Date date) throws SQLException
	{
		List<Course> clist=null;
		List<Course> list=new ArrayList<Course>();
		clist=as.queryCourse();
		for(Course c:clist)
		{
			Date startdate=c.getCourstartdate();
			if(startdate.before(date))
			{			
				Date enddate=c.getCourenddate();
				if(enddate.after(date))
					if(rightday(c.getDayofweek(), date))
						list.add(c);
			}
		}
		return list;
	}

	@Override
	public boolean rightday(String weekday, Date date) throws SQLException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dt=calendar.get(Calendar.DAY_OF_WEEK) - 1;
	/* 
		if(dt < 0)
		{
			dt = 6;
		}
	 */
		String[] weekdays={"7","1","2","3","4","5","6"};
		String day=weekdays[dt];
		String[] courday=weekday.split(",");
		for(String str:courday)
		{
			if(str.equals(day))
			{
				return true;
			}
		}
		return false;
	}

}
