package com.engsys.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.engsys.pojo.Member;
import com.engsys.service.core.AdminOperationService;
import com.engsys.service.core.AdminService;
import com.engsys.service.core.RecordService;
import com.engsys.service.imp.AdminOperationServiceImp;
import com.engsys.service.imp.AdminServiceImp;
import com.engsys.service.imp.RecordServiceImp;
import com.engsys.pojo.Course;

public class TeatAdminService
{
	AdminService as=new AdminServiceImp();
	RecordService rs=new RecordServiceImp();
	AdminOperationService aos= new AdminOperationServiceImp();
	
	
	public boolean rightday(String weekday, Date date) throws SQLException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dt=calendar.get(Calendar.DAY_OF_WEEK) - 1 - 1;
		String[] weekdays={"1","2","3","4","5","6","7"};
		String day=weekdays[dt];
		String[] courday=weekday.split(",");
		for(String str:courday)
		{
			if(str.equals(day))
			{
				System.out.println("right");
				return true;
			}
		}
		System.out.println("wrong");
		return false;
	}
	@Test
	public void test()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		int dt=calendar.get(Calendar.DAY_OF_WEEK) - 1 - 1;
		System.out.println(dt);
	}
	/*public void test()
	{
		try
		{
			if(rightday("1,4,7",new Date()))
			{
				System.out.println("dayright");
			}
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	/*public  void testService() throws ParseException
	{
		
		Date date=new Date();

		List<Course> list=null;
		try
		{
			list=aos.showTodayCourse(date);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list);
			Date date = (new SimpleDateFormat("yyyy-MM-dd")).parse("2016-4-7");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		System.out.println((new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime()));
		CourRecord courre=new CourRecord();
		courre.setCourname("math");
		courre.setUname("guest");
		courre.setCourprice(0);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		Date courstartdate = sdf.parse("2016-4-7 18:47:10");
		Date courenddate=sdf.parse("2016-4-9 18:47:10");
		Date date=sdf.parse("2016-4-8 18:47:10");
		courre.setCourdate(date);
		try
		{
			System.out.println(rs.addCourRecord(courre));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			System.out.println(rs.QueryCourRecordc("math",courstartdate, courenddate));
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try
			rs.deleteCourRecord(courstartdate, courenddate);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
