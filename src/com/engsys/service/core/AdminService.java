package com.engsys.service.core;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.Course;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.Subject;
import com.engsys.pojo.Teacher;
/**
 * 用于管理员操作的相关功能
 * @author Guohe
 *
 */
public interface AdminService 
{
	/**
	 * 增加管理员
	 * @param admin
	 * @throws SQLException
	 */
	public boolean addAdmin(Admin admin)throws SQLException;
	/**
	 * 修改管理员
	 * @param admin 其中id不能为0，要修改的寻条记录
	 * @throws SQLException
	 */
	public boolean updateAdmin(Admin admin)throws SQLException;
	/**
	 * 检查管理员登陆
	 * @param adname
	 * @param adpwd
	 * @return
	 * @throws SQLException
	 */
	public Admin adCheckLogin(String adname, String adpwd) throws SQLException;
	
	public Admin queryAdmin(String adname)throws SQLException;
	/**
	 * 添加会员
	 * @param member
	 * @throws SQLException
	 */
	public boolean addMember(Member member)throws SQLException;
	/**
	 * 删除会员
	 * @param menber
	 * @throws SQLException
	 */
	public boolean deleteMember(int idu)throws SQLException;
	/**
	 * 修改会员信息
	 * @param member
	 * @throws SQLException
	 */
	public boolean updateMember(Member member)throws SQLException;
	/**
	 * 修改会员密码
	 * @param upwd
	 * @return 操作成功返回true
	 * @throws SQLException
	 */
	public boolean updateMember(String upwd,int idu)throws SQLException;
	/**
	 * 修改余额
	 * @param ubalance
	 * @return
	 * @throws SQLException
	 */
	public boolean updateMember(float ubalance,int idu)throws SQLException;
	/**
	 * 修改会员等级
	 * @param ulevel
	 * @param upoints
	 * @return
	 * @throws SQLException
	 */
	public boolean upadeMember(int ulevel,int upoints,int idu)throws SQLException;
	/**
	 * 查询所有会员
	 * @return 返回当前会员结果集
	 * @throws SQLException
	 */
	public List<Member> queryMember()throws SQLException;
	/**
	 * 按用户名查询
	 * @param uname
	 * @return 返回要查询的用户名对应的信息
	 * @throws SQLException
	 */
	public Member queryMember(String uname)throws SQLException;
	/**
	 * 按用户id查询
	 * @param idu
	 * @return
	 * @throws SQLException
	 */
	public Member queryMember(int idu)throws SQLException;
	
	/**
	 * 检查用户登录
	 * @param uname
	 * @param upwd
	 * @return null没有成功，admin登陆成功
	 * @throws SQLException
	 */
	public Member memCheckLogin(String uname,String upwd)throws SQLException;
	
	/**
	 * 增加一门课程
	 * @param course
	 * @throws SQLException
	 */
	public boolean addCourse(Course course)throws SQLException;
	/**
	 * 修改一门课程
	 * @param course
	 * @throws SQLException
	 */
	public boolean updateCourse(Course course)throws SQLException;
	/**
	 * 删除一门课程
	 * @param course
	 * @throws SQLException
	 */
	public boolean deleteCourse(int idcour)throws SQLException;
	/**
	 * 查询全部课程信息
	 * @return 封装成Course对象存入List中返回
	 * @throws SQLException
	 */
	public List<Course> queryCourse()throws SQLException;
	/**
	 * 按课程名称查询课程信息
	 * @param courname
	 * @return 封装成Course对象存入List中返回
	 * @throws SQLException
	 */
	public List<Course> queryCourse(String courname)throws SQLException;
	/**
	 * 按课程id查询课程
	 * @param idcour
	 * @return 封装成Course对象返回
	 * @throws SQLException
	 */
	public Course queryCourse(int idcour)throws SQLException;
	
	/**
	 * 增加一条选课信息
	 * @param course
	 * @throws SQLException
	 */
	public boolean addSubject(Subject subject)throws SQLException;
	/**
	 * 修改一条选课信息
	 * @param course
	 * @throws SQLException
	 */
	public boolean updateSubject(Subject subject)throws SQLException;
	/**
	 * 删除一条选课信息
	 * @param course
	 * @throws SQLException
	 */
	public boolean deleteSubject(int idcour,int idu)throws SQLException;
	/**
	 * idu查询选课信息
	 * @return 封装成Course对象存入List中返回
	 * @throws SQLException
	 */
	public List<Subject> querySubjectu(int idu)throws SQLException;
	/**
	 * idcour查询选课信息
	 * @param idcour
	 * @return
	 * @throws SQLException
	 */
	public List<Subject> querySubject(int idcour)throws SQLException;
	/**
	 * idcour,idu查询选课信息
	 * @param idcour
	 * @param idu
	 * @return
	 * @throws SQLException
	 */
	public Subject querySubject(int idcour,int idu)throws SQLException;
	/**
	 * 增加考试
	 * @param examination
	 * @throws SQLException
	 */
	public boolean addExamination(Examination examination)throws SQLException;
	/**
	 * 修改考试
	 * @param examination
	 * @throws SQLException
	 */
	public boolean updateExamination(Examination examination)throws SQLException;
	/**
	 * 删除考试
	 * @param examination
	 * @throws SQLException
	 */
	public boolean deleteExamination(int idexam)throws SQLException;
	/**
	 * 显示所有考试信息
	 * @return
	 * @throws SQLException
	 */
	public List<Examination> queryExamination()throws SQLException;
	/**
	 * 按考试日期查询考试信息
	 * @param examdate
	 * @return 封装成Examination对象存入List中返回
	 * @throws SQLException
	 */
	public List<Examination> queryExamination(Date examdate)throws SQLException;
	/**
	 * 按考试id查询考试信息
	 * @param idexam
	 * @return 封装成Examination对象返回
	 * @throws SQLException
	 */
	public Examination queryExamination(int idexam)throws SQLException;
	
	/**
	 * 增加商品
	 * @param product
	 * @throws SQLException
	 */
	public boolean addProduct(Product product)throws SQLException;
	/**
	 * 修改商品
	 * @param product
	 * @throws SQLException
	 */
	public boolean updateProduct(Product product)throws SQLException;
	/**
	 * 删除商品
	 * @param idprod
	 * @throws SQLException
	 */
	public boolean deleteProduct(int idprod)throws SQLException;
	/**
	 * 查询
	 * @param prodname
	 * @return 封装成Product对象存入List中返回
	 */
	public List<Product> queryProduct()throws SQLException;
	/**
	 * 按商品id查询
	 * @param idprod
	 * @return
	 * @throws SQLException
	 */
	public Product queryProduct(int idprod)throws SQLException;
	
	/**
	 * 增加教师
	 * @param teacher
	 * @throws SQLException
	 */
	public boolean addTeacher(Teacher teacher)throws SQLException;
	/**
	 * 修改教师
	 * @param teacher
	 * @throws SQLException
	 */
	public boolean updateTeacher(Teacher teacher)throws SQLException;
	/**
	 * 删除教师
	 * @param idteach
	 * @throws SQLException
	 */
	public boolean deleteTeacher(int idteach)throws SQLException;
	/**
	 * 显示所有教师
	 * @return 封装成Teacher对象存入List中返回
	 * @throws SQLException
	 */
	public List<Teacher> queryTeacher()throws SQLException;
	/**
	 * 按id查询教师
	 * @param idteach
	 * @return 封装成Teacher对象返回
	 * @throws SQLException
	 */
	public Teacher queryTeacher(int idteach)throws SQLException;
	
	/**
	 * 增加一间教室
	 * @param classroom
	 * @throws SQLException
	 */
	public boolean addClassRoom(ClassRoom classroom)throws SQLException;
	/**
	 * 修改教室信息
	 * @param classroom
	 * @throws SQLException
	 */
	public boolean updateClassRoom(ClassRoom classroom)throws SQLException;
	/**
	 * 删除教室
	 * @param idroom
	 * @throws SQLException
	 */
	public boolean deleteClassRoom(int idroom)throws SQLException;
	/**
	 * 查询所有教室信息
	 * @return 封装成ClassRoom对象存入List中返回
	 * @throws SQLException
	 */
	public List<ClassRoom> queryClassRoom()throws SQLException;
	/**
	 * 按id查询教室
	 * @param idroom
	 * @return
	 * @throws SQLException
	 */
	public ClassRoom queryClassRoom(int idroom)throws SQLException;
}