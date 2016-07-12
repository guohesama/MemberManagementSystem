package com.engsys.service.core;

import java.util.Date;
import java.sql.SQLException;
import java.util.List;

import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.Course;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.Teacher;

public interface AdminOperationService
{
	/**
	 * 管理员登陆
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	public Admin adminCheckLogin(Admin admin)throws SQLException;
	/**
	 * 管理员修改密码
	 * @param admin
	 * @return
	 * @throws SQLException
	 */
	public boolean adminChangePassword(Admin admin)throws SQLException;
	/**
	 * 查看会员信息
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public Member ShowMemberInfo(Member member)throws SQLException;
	/**
	 * 修改会员等级
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean updateMemberLevel(Member member)throws SQLException;
	/**
	 * 充值
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean payMember(Member member)throws SQLException;
	/**
	 * 增加会员
	 * @param member
	 * @return
	 * @throws SQLException
	 */
	public boolean addMember(Member member)throws SQLException;
	/**
	 * 查看已有考试
	 * @return
	 * @throws SQLException
	 */
	public List<Examination> showExamnation()throws SQLException;
	/**
	 * 查看已有课程
	 * @return
	 * @throws SQLException
	 */
	public List<Course> showCourse()throws SQLException;
	/**
	 * 查看已有商品
	 * @return
	 * @throws SQLException
	 */
	public List<Product> showProduct()throws SQLException;
	/**
	 * 查看已有教室
	 * @return
	 * @throws SQLException
	 */
	public List<ClassRoom> showClassRoom()throws SQLException;
	/**
	 * 查看已有教师
	 * @return
	 * @throws SQLException
	 */
	public List<Teacher> showTeacher()throws SQLException;
	public List<Course> showTodayCourse(Date date)throws SQLException;
	public boolean rightday(String weekday,Date date)throws SQLException;
}
