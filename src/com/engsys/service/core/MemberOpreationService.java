package com.engsys.service.core;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.engsys.pojo.ConRecord;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.Course;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.SCourse;

public interface MemberOpreationService
{
	/**
	 * 检查会员登陆
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public Member memCheckLogin(Member member) throws SQLException;
	/**
	 * 会员查看信息
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public Member memShowInfo(Member member) throws SQLException;
	/**
	 * 会员修改信息
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean memUpdateInfo(Member member) throws SQLException;
	/**
	 * 会员修改密码
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean memChangePassword(Member member) throws SQLException;
	/**
	 * 购物
	 * @param member
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public boolean memShopping(Member member,Product product,ConRecord conre) throws SQLException;
	/**
	 * 选课
	 * @param member
	 * @param course
	 * @return
	 * @throws SQLException
	 */
	public boolean memCourseSelection(Member member,Course course) throws SQLException;
	/**
	 * 报名考试
	 * @param member
	 * @param exam
	 * @return
	 * @throws SQLException
	 */
	public boolean memExamRegister(Member member,Examination exam) throws SQLException;
	/**
	 * 查看课程记录
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public List<CourRecord> memShowCourRecord(Member member,Date startdate,Date enddate) throws SQLException;
	/**
	 * 查看消费记录
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public List<ConRecord> memShowConRecord(Member member,Date startdate,Date enddate)throws SQLException;
	/**
	 * 查看考试记录
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public List<ExamRecord> memShowExamRecord(Member member)throws SQLException;
	/**
	 * 课程表
	 */
	public List<Course> memTimeTable(Member member) throws SQLException;
	public List<SCourse> showSCourse(List<Course> cour)throws SQLException;
}
