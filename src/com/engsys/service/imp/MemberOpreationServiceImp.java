package com.engsys.service.imp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.ConRecord;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.SCourse;
import com.engsys.pojo.Subject;
import com.engsys.pojo.Teacher;
import com.engsys.service.core.AdminService;
import com.engsys.service.core.MemberOpreationService;
import com.engsys.service.core.RecordService;

public class MemberOpreationServiceImp implements MemberOpreationService
{
	AdminService as=new AdminServiceImp();
	RecordService rs=new RecordServiceImp();
	@Override
	public Member memCheckLogin(Member member) throws SQLException
	{
		Member mem=new Member();
		mem=as.memCheckLogin(member.getUname(), member.getUpwd());
		return mem; 
	}

	@Override
	public Member memShowInfo(Member member) throws SQLException
	{
		Member mem=new Member();
		mem=as.queryMember(member.getIdu());
		return mem;
	}

	@Override
	public boolean memUpdateInfo(Member member) throws SQLException
	{
		return as.updateMember(member);
	}

	@Override
	public boolean memChangePassword(Member member) throws SQLException
	{
		// TODO Auto-generated method stub
		return as.updateMember(member.getUpwd(), member.getIdu());
	}

	@Override
	public boolean memShopping(Member member, Product product,ConRecord conre)
			throws SQLException
	{
		boolean flag=true;
		flag=as.updateProduct(product);	
		flag=rs.addConRecord(conre);
		return flag;
	}

	@Override
	public boolean memCourseSelection(Member member, Course course)
			throws SQLException
	{
		boolean flag=true;
		Subject subject=new Subject();
		subject.setIdcour(course.getIdcour());
		subject.setIdu(member.getIdu());
		flag=as.addSubject(subject);
		return flag;
	}

	@Override
	public boolean memExamRegister(Member member, Examination exam)
			throws SQLException
	{
		ExamRecord examre=new ExamRecord();
		Date day=new Date();
		examre.setDate(exam.getExamdate());
		examre.setExamname(exam.getExamname());
		examre.setExamprice(exam.getExamprice());
		examre.setIdexam(exam.getIdexam());
		examre.setIdu(member.getIdu());
		examre.setUname(member.getUname());
		examre.setExamdate(day);
		return rs.addExamRecord(examre);
	}

	@Override
	public List<CourRecord> memShowCourRecord(Member member,Date startdate,Date enddate)
			throws SQLException
	{
		List<CourRecord> courlist=null;
		courlist=rs.QueryCourRecordu(member.getUname(), startdate, enddate);
		return courlist;
	}

	@Override
	public List<ConRecord> memShowConRecord(Member member,Date startdate,Date enddate) throws SQLException
	{
		List<ConRecord> conlist=null;
		conlist=rs.QueryConRecord();
		return conlist;
	}

	@Override
	public List<ExamRecord> memShowExamRecord(Member member)
			throws SQLException
	{
		List<ExamRecord> examlist=null;
		examlist=rs.queryExamRecord(member.getUname());
		return examlist;
	}

	@Override
	public List<Course> memTimeTable(Member member) throws SQLException
	{
		List<Course> courlist=new ArrayList<Course>();
		List<Subject> sub=null;
		sub=as.querySubjectu(member.getIdu());
		for(Subject nsub:sub)
		{
			courlist.add(as.queryCourse(nsub.getIdcour()));
		}
		return courlist;
	}

	@Override
	public List<SCourse> showSCourse(List<Course> cour) throws SQLException
	{
		List<SCourse> lscour=new ArrayList<SCourse>();
		/**
		 * 同一对象多次插入list时，只保留最后的值
		 */
		for(Course c:cour)
		{	
			SCourse scour=new SCourse();
			scour.setCourenddate(c.getCourenddate());
			scour.setCourname(c.getCourname());
			scour.setCourprice(c.getCourprice());
			scour.setCourstartdate(c.getCourstartdate());
			scour.setCourtime(c.getCourtime());
			scour.setCourtotaltimes(c.getCourtotaltimes());
			scour.setCurnum(c.getCurnum());
			String[] week={"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
			String[] tmpday=c.getDayofweek().split(",");
			String weeks=" ";
			for(String t:tmpday)
			{
				weeks=weeks+week[Integer.parseInt(t)-1]+" ";
			}
			scour.setDayofweek(weeks);
			scour.setIdcour(c.getIdcour());
			scour.setMaxnum(c.getMaxnum());
			ClassRoom room=as.queryClassRoom(c.getIdroom());
			scour.setRoomname(room.getRoomname());
			scour.setTime(c.getTime());
			Teacher teach=as.queryTeacher(c.getIdteach());
			scour.setTeachname(teach.getTeachname());
			lscour.add(scour);			
		}
		return lscour;
	}
	
	
}
