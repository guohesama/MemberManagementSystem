package com.engsys.service.core;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.engsys.pojo.ConRecord;
import com.engsys.pojo.CourRecord;
import com.engsys.pojo.ExamRecord;
import com.engsys.pojo.MMrecord;
import com.engsys.pojo.Member;

public interface RecordService
{
	/**
	 * 增加一条消费记录
	 * @param conrecord
	 * @throws SQLException
	 */
	public boolean addConRecord(ConRecord conrecord)throws SQLException;
	
	/**
	 * 删除从startdate到enddate的消费记录
	 * @param startdate
	 * @param endate
	 * @throws SQLException
	 */
	public boolean deleteConRecord(Date startdate,Date enddate)throws SQLException;
	/**
	 * 查看从startdate到enddate的消费记录
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws SQLException
	 */
	public List<ConRecord> QueryConRecord()throws SQLException;
	/**
	 * 按用户名查询从startdate到enddate的消费记录
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public List<ConRecord> QueryConRecord(String uname)throws SQLException;
	/**
	 * 按商品名查询从startdate到enddate的消费记录
	 * @param prodname
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws SQLException
	 */
	public List<ConRecord> pQueryConRecord(String prodname,Date startdate,Date enddate)throws SQLException;
	public List<ConRecord> QueryConRecord(Date startdate,Date enddate)throws SQLException;
	/**
	 * 增加一条课程记录
	 * @param courrecord
	 * @throws SQLException
	 */
	public boolean addCourRecord(CourRecord courrecord)throws SQLException;
	
	/**
	 * 删除从startdate到enddate的课程记录
	 * @param startdate
	 * @param enddate
	 * @throws SQLException
	 */
	public boolean deleteCourRecord(Date startdate,Date enddate)throws SQLException;
	
	/**
	 * 查询从startdate到enddate之间的课程记录
	 * @param startdate
	 * @param enddate
	 * @return
	 * @throws SQLException
	 */
	public List<CourRecord> QueryCourRecord(Date startdate,Date enddate)throws SQLException;
	public List<CourRecord> QueryCourRecord()throws SQLException;
	/**
	 * 按课程名查询课程记录
	 * @param courname
	 * @return
	 * @throws SQLException
	 */
	public List<CourRecord> QueryCourRecordc(String courname,Date startdate,Date enddate)throws SQLException;
	/**
	 * 按用户名查询课程记录
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public List<CourRecord> QueryCourRecordu(String uname,Date startdate,Date enddate)throws SQLException;
	
	public CourRecord QueryCourRecord(String uname,String date,String courname)throws SQLException;
	/**
	 * 增加考试记录
	 * @param exam
	 * @return
	 * @throws SQLException
	 */
	public boolean addExamRecord(ExamRecord exam)throws SQLException;
	public boolean updateExamRecord(int idexamre,int exammark)throws SQLException;
	/**
	 * 删除startdate到enddate的考试记录
	 * @param startdate
	 * @param enddate
	 * @return
	 */
	public boolean deleteExamRecord(Date startdate,Date enddate)throws SQLException;
	public List<ExamRecord> queryExamRecord()throws SQLException;
	public List<ExamRecord> queryExamRecord(String uname)throws SQLException;
	public List<ExamRecord> equeryExamRecord(String examname,int exammark)throws SQLException;
	
	public boolean addMMrecord(MMrecord mmre)throws SQLException;
	public boolean deleteMMrecord(Date startdate,Date enddate)throws SQLException;
	public List<MMrecord> queryMMrecord(String uname)throws SQLException;
	public List<MMrecord> queryMMrecord()throws SQLException;
}
