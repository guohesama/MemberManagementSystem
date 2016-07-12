package com.engsys.service.imp;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.engsys.pojo.ConRecord;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.MMrecord;
import com.engsys.service.core.RecordService;
import com.engsys.service.core.ServiceBase;

public class RecordServiceImp extends ServiceBase implements RecordService
{

	@Override
	public boolean addConRecord(ConRecord conrecord) throws SQLException
	{
		String sql="insert into conrecord(idprod,condate,idu,uname,prodname,prodprice,number,totalprice) values(?,?,?,?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,conrecord.getIdprod(),conrecord.getCondate(),conrecord.getIdu(),conrecord.getUname(),conrecord.getProdname(),conrecord.getProdprice(),conrecord.getNumber(),conrecord.getTotalprice());
		} catch (Exception e)
		{
			System.out.println("ERROR_040_增加消费记录出错");
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
	public boolean deleteConRecord(Date startdate, Date enddate)throws SQLException
	{
		String sql="delete from conrecord where condate between ? and ?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_041_删除消费记录出错");
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
	public List<ConRecord> QueryConRecord()
			throws SQLException
	{
		String sql="select * from conrecord";
		Connection con=null;
		List<ConRecord> conre=null;
		try
		{
			con=this.getConnection();
			conre=run.query(con,sql,new BeanListHandler<ConRecord>(ConRecord.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_042_查询消费记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return conre;
	}

	@Override
	public List<ConRecord> QueryConRecord(String uname) throws SQLException
	{
		String sql="select * from conrecord where uname=?";
		Connection con=null;
		List<ConRecord> conre=null;
		try
		{
			con=this.getConnection();
			conre=run.query(con,sql,new BeanListHandler<ConRecord>(ConRecord.class),uname);
		} catch (Exception e)
		{
			System.out.println("ERROR_042_查询消费记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return conre;
	}

	@Override
	public List<ConRecord> QueryConRecord(Date startdate, Date enddate)
			throws SQLException
	{
		String sql="select * from conrecord where condate between ? and ?";
		Connection con=null;
		List<ConRecord> conre=null;
		try
		{
			con=this.getConnection();
			conre=run.query(con,sql,new BeanListHandler<ConRecord>(ConRecord.class),startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_042_查询消费记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return conre;
	}

	@Override
	public List<ConRecord> pQueryConRecord(String prodname, Date startdate,
			Date enddate) throws SQLException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addCourRecord(CourRecord courrecord) throws SQLException
	{
		String sql="insert into courrecord(uname,courname,courdate,courprice,date) value(?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,courrecord.getUname(),courrecord.getCourname(),courrecord.getCourdate(),courrecord.getCourprice(),courrecord.getDate());
		} catch (Exception e)
		{
			System.out.println("ERROR_042_增加课程记录出错");
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
	public boolean deleteCourRecord(Date startdate, Date enddate)
			throws SQLException
	{
		String sql="delete from courrecord where courdate between ? and ?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_041_删除课程记录出错");
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
	public List<CourRecord> QueryCourRecordc(String courname, Date startdate,
			Date enddate) throws SQLException
	{
		String sql="select * from courrecord where courname=? and courdate>=? and courdate<=?";
		Connection con=null;
		List<CourRecord> courre=null;
		try
		{
			con=this.getConnection();
			courre=run.query(con,sql,new BeanListHandler<CourRecord>(CourRecord.class),courname,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_042_courname查询课程记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return courre;
	}

	@Override
	public List<CourRecord> QueryCourRecordu(String uname, Date startdate,
			Date enddate) throws SQLException
	{
		String sql="select * from courrecord where uname=? and courdate>=? and courdate<=?";
		Connection con=null;
		List<CourRecord> courre=null;
		try
		{
			con=this.getConnection();
			courre=run.query(con,sql,new BeanListHandler<CourRecord>(CourRecord.class),uname,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_044_uname查询课程记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return courre;
	}

	
	@Override
	public CourRecord QueryCourRecord(String uname, String date,String courname)
			throws SQLException
	{
		String sql="select * from courrecord where uname=? and courdate=? and courname=?";
		Connection con=null;
		CourRecord courre=null;
		
		try
		{
			con=this.getConnection();
			courre=run.query(con,sql,new BeanHandler<CourRecord>(CourRecord.class),uname,date,courname);
		} catch (Exception e)
		{
			System.out.println("ERROR_044_uname查询课程记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return courre;
	}

	@Override
	public boolean addExamRecord(ExamRecord exam) throws SQLException
	{
		String sql="insert into examrecord(idu,examname,uname,examdate,exammark,idexam,examprice,date) values(?,?,?,?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,exam.getIdu(),exam.getExamname(),exam.getUname(),exam.getExamdate(),exam.getExammark(),exam.getIdexam(),exam.getExamprice(),exam.getDate());
		} catch (Exception e)
		{
			System.out.println("ERROR_045_增加考试记录出错");
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
	public boolean updateExamRecord(int idexamre,int exammark) throws SQLException
	{
		String sql="update examrecord set exammark=? where idexamre=?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,exammark,idexamre);
		} catch (Exception e)
		{
			System.out.println("ERROR_046_录入成绩出错");
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
	public boolean deleteExamRecord(Date startdate, Date enddate) throws SQLException
	{
		String sql="delete from examrecord where examdate between ? and ?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_046_删除考试记录出错");
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
	public List<ExamRecord> queryExamRecord()
			throws SQLException
	{
		String sql="select * from examrecord";
		Connection con=null;
		List<ExamRecord> exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanListHandler<ExamRecord>(ExamRecord.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_047_查询考试记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return exam;
	}

	@Override
	public List<ExamRecord> queryExamRecord(String uname)
			throws SQLException
	{
		String sql="select * from examrecord where uname=?";
		Connection con=null;
		List<ExamRecord> exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanListHandler<ExamRecord>(ExamRecord.class),uname);
		} catch (Exception e)
		{
			System.out.println("ERROR_048_查询考试记录成绩出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return exam;
	}

	@Override
	public List<ExamRecord> equeryExamRecord(String examname, int exammark)
			throws SQLException
	{
		String sql="select * from examrecord where examname=? and exammark=?";
		Connection con=null;
		List<ExamRecord> exam=null;
		try
		{
			con=this.getConnection();
			exam=run.query(con,sql,new BeanListHandler<ExamRecord>(ExamRecord.class),examname,exammark);
		} catch (Exception e)
		{
			System.out.println("ERROR_049_按课程查询考试记录成绩出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return exam;
	}

	@Override
	public boolean addMMrecord(MMrecord mmre) throws SQLException
	{
		String sql="insert into mmrecord(idadmin,idu,date,opertype,uname) values(?,?,?,?,?)";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,mmre.getIdadmin(),mmre.getIdu(),mmre.getDate(),mmre.getOpertype(),mmre.getUname());
		} catch (Exception e)
		{
			System.out.println("ERROR_050_增加管理记录出错");
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
	public boolean deleteMMrecord(Date startdate, Date enddate)
			throws SQLException
	{
		String sql="delete from mmrecord where date between ? and ?";
		Connection con=null;
		boolean flag=true;
		try
		{
			con=this.getConnection();
			run.update(con,sql,startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_051_删除考试记录出错");
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
	public List<MMrecord> queryMMrecord(String uname) throws SQLException
	{
		String sql="select * from mmrecord where uname";
		Connection con=null;
		List<MMrecord> mmre=null;
		try
		{
			con=this.getConnection();
			mmre=run.query(con,sql,new BeanListHandler<MMrecord>(MMrecord.class),uname);
		} catch (Exception e)
		{
			System.out.println("ERROR_052_按课程查询管理记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return mmre;
	}

	@Override
	public List<CourRecord> QueryCourRecord(Date startdate, Date enddate)
			throws SQLException
	{
		String sql="select * from courrecord where courdate>=? and courdate<=?";
		Connection con=null;
		List<CourRecord> courre=null;
		try
		{
			con=this.getConnection();
			courre=run.query(con,sql,new BeanListHandler<CourRecord>(CourRecord.class),startdate,enddate);
		} catch (Exception e)
		{
			System.out.println("ERROR_042_查询课程记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return courre;
	}

	@Override
	public List<CourRecord> QueryCourRecord() throws SQLException
	{
		String sql="select * from courrecord";
		Connection con=null;
		List<CourRecord> courre=null;
		try
		{
			con=this.getConnection();
			courre=run.query(con,sql,new BeanListHandler<CourRecord>(CourRecord.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_042_查询课程记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return courre;
	}

	@Override
	public List<MMrecord> queryMMrecord() throws SQLException
	{
		String sql="select * from mmrecord";
		Connection con=null;
		List<MMrecord> mmre=null;
		try
		{
			con=this.getConnection();
			mmre=run.query(con,sql,new BeanListHandler<MMrecord>(MMrecord.class));
		} catch (Exception e)
		{
			System.out.println("ERROR_052_按课程查询管理记录出错");
			e.printStackTrace();
			throw e;
		}finally
		{
			if(con!=null) con.close();
		}
		return mmre;
	}

	
}


