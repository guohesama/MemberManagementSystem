package com.engsys.service.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.engsys.pojo.Admin;
import com.engsys.pojo.ClassRoom;
import com.engsys.pojo.Course;
import com.engsys.pojo.Examination;
import com.engsys.pojo.Member;
import com.engsys.pojo.Product;
import com.engsys.pojo.Subject;
import com.engsys.pojo.Teacher;
import com.engsys.service.core.AdminService;
import com.engsys.service.core.ServiceBase;
import com.engsys.util.Md5Encrypt;

public class AdminServiceImp extends ServiceBase implements AdminService
{

	@Override
	public boolean addAdmin(Admin admin) throws SQLException
	{
		String sql="insert into admin(adname,adpwd) values(?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,admin.getAdname(),Md5Encrypt.md5(admin.getAdpwd()));
		} catch (Exception e)
		{
			System.out.println("ERROR_002_增加管理员出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateAdmin(Admin admin) throws SQLException
	{
		String sql="update admin set adname=?,adpwd=? where idadmin=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,admin.getAdname(),Md5Encrypt.md5(admin.getAdpwd()),admin.getIdadmin());
		} catch (Exception e)
		{
			System.out.println("ERROR_004_修改管理员出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public Admin adCheckLogin(String adname, String adpwd) throws SQLException
	{
		String sql="select * from admin where adname=? and adpwd=?";
		Connection con=null;
		Admin admin=null;
		try
		{
			con=this.getConnection();
			admin=run.query(con,sql,new BeanHandler<Admin>(Admin.class),adname,Md5Encrypt.md5(adpwd));
		} catch (Exception e)
		{
			System.out.println("ERROR_003_验证用户名密码错误");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return admin;
	}
	
	@Override
	public Admin queryAdmin(String adname) throws SQLException
	{
		String sql="select * from admin where adname=?";
		Connection con=null;
		Admin admin=null;
		try
		{
			con=this.getConnection();
			admin=run.query(con,sql,new BeanHandler<Admin>(Admin.class),adname);
		} catch (Exception e)
		{
			System.out.println("ERROR_0002_用户名已存在");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return admin;
	}

	@Override
	public boolean addMember(Member member) throws SQLException
	{
		String sql="insert into member(uname,upwd,urealname,usex,uage,utelephone) values(?,?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,member.getUname(),Md5Encrypt.md5(member.getUpwd()),member.getUrealname(),member.getUsex(),member.getUage(),member.getUtelephone());
		} catch (Exception e)
		{
			System.out.println("ERROR_005_增加会员出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteMember(int idu) throws SQLException
	{
		String sql="delete from member where idu=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_006_删除会员出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateMember(Member member) throws SQLException
	{
		String sql="update member set urealname=?,usex=?,uage=?,utelephone=? where uname=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,member.getUrealname(),member.getUsex(),member.getUage(),member.getUtelephone(),member.getUname());
		} catch (Exception e)
		{
			System.out.println("ERROR_007_更新会员信息出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}
	
	@Override
	public boolean updateMember(String upwd,int idu) throws SQLException
	{
		String sql="update member set upwd=? where idu=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,Md5Encrypt.md5(upwd),idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_016_修改会员密码出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateMember(float ubalance,int idu) throws SQLException
	{
		String sql="update member set ubalance=? where idu=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,ubalance,idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_017_修改会员余额出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean upadeMember(int ulevel, int upoints,int idu) throws SQLException
	{
		String sql="update member set ulevel=?,upoints=? where idu=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,ulevel,upoints,idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_018_修改会员等级出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Member> queryMember() throws SQLException
	{
		String sql="select * from member";
		Connection con=null;
		List<Member> mem=null;
		try
		{
			con=this.getConnection();
			mem=run.query(con,sql,new BeanListHandler<Member>(Member.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_008_查找会员信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return mem;
	}

	@Override
	public Member queryMember(String uname) throws SQLException
	{
		String sql="select * from member where uname=?";
		Connection con=null;
		Member mem=null;
		try
		{
			con=this.getConnection();
			mem=run.query(con,sql,new BeanHandler<Member>(Member.class),uname);
		} catch (Exception e)
		{
			System.out.println("ERROR_009_uname查找会员信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return mem;
	}

	@Override
	public Member queryMember(int idu) throws SQLException
	{
		String sql="select * from member where idu=?";
		Connection con=null;
		Member mem=null;
		try
		{
			con=this.getConnection();
			mem=run.query(con,sql,new BeanHandler<Member>(Member.class),idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_010_idu查找会员信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return mem;
	}

	
	@Override
	public Member memCheckLogin(String uname, String upwd) throws SQLException
	{
		String sql="select * from member where uname=? and upwd=?";
		Connection con=null;
		Member member=null;
		try
		{
			con=this.getConnection();
			member=run.query(con,sql,new BeanHandler<Member>(Member.class),uname,Md5Encrypt.md5(upwd));
		} catch (Exception e)
		{
			System.out.println("ERROR_0003_验证会员用户名密码错误");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return member;
	}

	@Override
	public boolean addCourse(Course course) throws SQLException
	{
		String sql="insert into course(courname,courtime,courprice,idteach,idroom,courtotaltimes,courstartdate,courenddate,maxnum,curnum,dayofweek,time) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,course.getCourname(),course.getCourtime(),course.getCourprice(),course.getIdteach(),course.getIdroom(),course.getCourtotaltimes(),course.getCourstartdate(),course.getCourenddate(),course.getMaxnum(),course.getCurnum(),course.getDayofweek(),course.getTime());
		} catch (Exception e)
		{
			System.out.println("ERROR_011_增加课程出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateCourse(Course course) throws SQLException
	{
		String sql="update course set courname=?,courtime=?,courprice=?,idteach=?,idroom=?,courtotaltimes=?,courstartdate=?,courenddate=?,maxnum=?,curnum=?,dayofweek=?,time=? where idcour=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,course.getCourname(),course.getCourtime(),course.getCourprice(),course.getIdteach(),course.getIdroom(),course.getCourtotaltimes(),course.getCourstartdate(),course.getCourenddate(),course.getMaxnum(),course.getCurnum(),course.getDayofweek(),course.getTime(),course.getIdcour());
		} catch (Exception e)
		{
			System.out.println("ERROR_012_修改课程出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteCourse(int idcour) throws SQLException
	{
		String sql="delete from course where idcour=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idcour);
		} catch (Exception e)
		{
			System.out.println("ERROR_013_删除会员出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Course> queryCourse() throws SQLException
	{
		String sql="select * from course";
		Connection con=null;
		List<Course> cour=null;
		try
		{
			con=this.getConnection();
			cour=run.query(con,sql,new BeanListHandler<Course>(Course.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_0014_查找课程信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return cour;
	}

	@Override
	public List<Course> queryCourse(String courname) throws SQLException
	{
		String sql="select * from course where courname=?";
		Connection con=null;
		List<Course> cour=null;
		try
		{
			con=this.getConnection();
			cour=run.query(con,sql,new BeanListHandler<Course>(Course.class),courname);
		} catch (Exception e)
		{
			System.out.println("ERROR_015_查找课程信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return cour;
	}

	@Override
	public Course queryCourse(int idcour) throws SQLException
	{
		String sql="select * from course where idcour=?";
		Connection con=null;
		Course course=null;
		try
		{
			con=this.getConnection();
			course=run.query(con,sql,new BeanHandler<Course>(Course.class),idcour);
		} catch (Exception e)
		{
			System.out.println("ERROR_019_idcour查找课程信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return course;
	}

	@Override
	public boolean addExamination(Examination examination) throws SQLException
	{
		String sql="insert into examination(examname,examtime,examplace,examprice,examdate) values(?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,examination.getExamname(),examination.getExamtime(),examination.getExamplace(),examination.getExamprice(),examination.getExamdate());
		} catch (Exception e)
		{
			System.out.println("ERROR_020_增加考试出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateExamination(Examination examination)
			throws SQLException
	{
		String sql="update examination set examname=?,examtime=?,examplace=?,examprice=?,examdate=? where idexam=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,examination.getExamname(),examination.getExamtime(),examination.getExamplace(),examination.getExamprice(),examination.getExamdate(),examination.getIdexam());
		} catch (Exception e)
		{
			System.out.println("ERROR_021_修改考试出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteExamination(int idexam) throws SQLException
	{
		String sql="delete from examination where idexam=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idexam);
		} catch (Exception e)
		{
			System.out.println("ERROR_022_删除考试出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Examination> queryExamination() throws SQLException
	{
		String sql="select * from examination";
		Connection con=null;
		List<Examination> exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanListHandler<Examination>(Examination.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_023_查找考试信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return exam;
	}

	@Override
	public List<Examination> queryExamination(Date examdate)
			throws SQLException
	{
		String sql="select * from examination where examdate=?";
		Connection con=null;
		List<Examination> exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanListHandler<Examination>(Examination.class),examdate);
		} catch (Exception e)
		{
			System.out.println("ERROR_024_examdate查找考试信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return exam;
	}

	@Override
	public Examination queryExamination(int idexam) throws SQLException
	{
		String sql="select * from examination where idexam=?";
		Connection con=null;
		Examination exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanHandler<Examination>(Examination.class),idexam);
		} catch (Exception e)
		{
			System.out.println("ERROR_023_查找考试信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		
		return exam;
	}

	@Override
	public boolean addProduct(Product product) throws SQLException
	{
		String sql="insert into product(prodname,prodprice,prodmargin,prodtype) values(?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,product.getProdname(),product.getProdprice(),product.getProdmargin(),product.getProdtype());
		} catch (Exception e)
		{
			System.out.println("ERROR_024_增加商品出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateProduct(Product product) throws SQLException
	{
		String sql="update product set prodname=?,prodprice=?,prodmargin=?,prodtype=? where idprod=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,product.getProdname(),product.getProdprice(),product.getProdmargin(),product.getProdtype(),product.getIdprod());
		} catch (Exception e)
		{
			System.out.println("ERROR_025_修改商品出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteProduct(int idprod) throws SQLException
	{
		String sql="delete from product where idprod=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idprod);
		} catch (Exception e)
		{
			System.out.println("ERROR_026_删除商品出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Product> queryProduct() throws SQLException
	{
		String sql="select * from product";
		Connection con=null;
		List<Product> product=null;
		try
		{
			con=this.getConnection();
			product=run.query(con,sql,new BeanListHandler<Product>(Product.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_027_proddate查找商品信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return product;
	}

	@Override
	public Product queryProduct(int idprod) throws SQLException
	{
		String sql="select * from product where idprod=?";
		Connection con=null;
		Product product=null;
		try
		{
			con=this.getConnection();
			product=run.query(con,sql,new BeanHandler<Product>(Product.class),idprod);
		} catch (Exception e)
		{
			System.out.println("ERROR_028_idprod查找商品信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return product;
	}

	@Override
	public boolean addTeacher(Teacher teacher) throws SQLException
	{
		String sql="insert into teacher(idteach,teachname,teachsex,teachtelephone) values(?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,teacher.getIdteach(),teacher.getTeachname(),teacher.getTeachsex(),teacher.getTeachtelephone());
		} catch (Exception e)
		{
			System.out.println("ERROR_030_增加教师出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateTeacher(Teacher teacher) throws SQLException
	{
		String sql="update teacher set teachname=?,teachsex=?,teachtelephone=? where idteach=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,teacher.getTeachname(),teacher.getTeachsex(),teacher.getTeachtelephone(),teacher.getIdteach());
		} catch (Exception e)
		{
			System.out.println("ERROR_031_修改教师出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteTeacher(int idteach) throws SQLException
	{
		String sql="delete from teacher where idteach=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idteach);
		} catch (Exception e)
		{
			System.out.println("ERROR_032_删除教师出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Teacher> queryTeacher() throws SQLException
	{
		String sql="select * from teacher";
		Connection con=null;
		List<Teacher> teach=null;
		try
		{
			con=this.getConnection();
			teach=run.query(con,sql,new BeanListHandler<Teacher>(Teacher.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_033_查找教师信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return teach;
	}

	@Override
	public Teacher queryTeacher(int idteach) throws SQLException
	{
		String sql="select * from teacher where idteach=?";
		Connection con=null;
		Teacher teach=null;
		try
		{
			con=this.getConnection();
			teach=run.query(con,sql,new BeanHandler<Teacher>(Teacher.class),idteach);
		} catch (Exception e)
		{
			System.out.println("ERROR_034_idteach查找教师信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return teach;
	}

	@Override
	public boolean addClassRoom(ClassRoom classroom) throws SQLException
	{
		String sql="insert into classroom(idroom,roomname,roomseatings,roombooked) values(?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,classroom.getIdroom(),classroom.getRoomname(),classroom.getRoomseatings(),classroom.getRoombooked());
		} catch (Exception e)
		{
			System.out.println("ERROR_035_增加教室出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateClassRoom(ClassRoom classroom) throws SQLException
	{
		String sql="update classroom set roomname=?,roomseatings=?,roombooked=? where idroom=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,classroom.getRoomname(),classroom.getRoomseatings(),classroom.getRoombooked(),classroom.getIdroom());
		} catch (Exception e)
		{
			System.out.println("ERROR_036_修改教室出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteClassRoom(int idroom) throws SQLException
	{
		String sql="delete from classroom where idroom=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idroom);
		} catch (Exception e)
		{
			System.out.println("ERROR_037_删除教室出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<ClassRoom> queryClassRoom() throws SQLException
	{
		String sql="select * from classroom";
		Connection con=null;
		List<ClassRoom> room=null;
		try
		{
			con=this.getConnection();
			room=run.query(con,sql,new BeanListHandler<ClassRoom>(ClassRoom.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_038_查找教室信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return room;
	}

	@Override
	public ClassRoom queryClassRoom(int idroom) throws SQLException
	{
		String sql="select * from classroom where idroom=?";
		Connection con=null;
		ClassRoom room=null;
		try
		{
			con=this.getConnection();
			room=run.query(con,sql,new BeanHandler<ClassRoom>(ClassRoom.class),idroom);
		} catch (Exception e)
		{
			System.out.println("ERROR_039_idroom查找教室信息出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return room;
	}

	@Override
	public boolean addSubject(Subject subject) throws SQLException
	{
		String sql="insert into subject(idu,idcour) values(?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,subject.getIdu(),subject.getIdcour());
		} catch (Exception e)
		{
			System.out.println("ERROR_040_增加选课记录出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean updateSubject(Subject subject) throws SQLException
	{
		String sql="update subject set idu=?,idcour=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,subject.getIdu(),subject.getIdcour());
		} catch (Exception e)
		{
			System.out.println("ERROR_041_修改选课记录出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public boolean deleteSubject(int idcour, int idu) throws SQLException
	{
		String sql="delete from subject where idu=? and idcour=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,idcour,idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_042_删除选课记录出错");
			flag=false;
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return flag;
	}

	@Override
	public List<Subject> querySubjectu(int idu) throws SQLException
	{
		String sql="select * from subject where idu=?";
		Connection con=null;
		List<Subject> sub=null;
		try
		{
			con=this.getConnection();
			sub=run.query(con,sql,new BeanListHandler<Subject>(Subject.class),idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_043_idu查询选课记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return sub;
	}

	@Override
	public List<Subject> querySubject(int idcour) throws SQLException
	{
		String sql="select * from subject where idcour=?";
		Connection con=null;
		List<Subject> sub=null;
		try
		{
			con=this.getConnection();
			sub=run.query(con,sql,new BeanListHandler<Subject>(Subject.class),idcour);
		} catch (Exception e)
		{
			System.out.println("ERROR_044_idcour查询选课记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return sub;
	}

	@Override
	public Subject querySubject(int idcour, int idu) throws SQLException
	{
		String sql="select * from subject where idcour=? and idu=?";
		Connection con=null;
		Subject sub=null;
		try
		{
			con=this.getConnection();
			sub=run.query(con,sql,new BeanHandler<Subject>(Subject.class),idcour,idu);
		} catch (Exception e)
		{
			System.out.println("ERROR_044_idcour查询选课记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return sub;
	}
}