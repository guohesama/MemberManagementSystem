package com.engsys.pojo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class SCourse  implements Serializable
{

	private static final long serialVersionUID = -897852871583398197L;
	private int idcour;
	private String courname;
	private int courtime;
	private float courprice;
	private int courtotaltimes;
	@JSONField (format="yyyy-MM-dd")
	private Date courstartdate;
	@JSONField (format="yyyy-MM-dd")
	private Date courenddate;
	private int maxnum;
	private int  curnum;
	private String dayofweek;
	private String time;
	private String roomname;
	private String teachname;
	
	public int getIdcour()
	{
		return idcour;
	}
	public void setIdcour(int idcour)
	{
		this.idcour = idcour;
	}
	public String getCourname()
	{
		return courname;
	}
	public void setCourname(String courname)
	{
		this.courname = courname;
	}
	public int getCourtime()
	{
		return courtime;
	}
	public void setCourtime(int courtime)
	{
		this.courtime = courtime;
	}
	public float getCourprice()
	{
		return courprice;
	}
	public void setCourprice(float courprice)
	{
		this.courprice = courprice;
	}
	public int getCourtotaltimes()
	{
		return courtotaltimes;
	}
	public void setCourtotaltimes(int courtotaltimes)
	{
		this.courtotaltimes = courtotaltimes;
	}
	public Date getCourstartdate()
	{
		return courstartdate;
	}
	public void setCourstartdate(Date courstartdate)
	{
		this.courstartdate = courstartdate;
	}
	public Date getCourenddate()
	{
		return courenddate;
	}
	public void setCourenddate(Date courenddate)
	{
		this.courenddate = courenddate;
	}
	public int getMaxnum()
	{
		return maxnum;
	}
	public void setMaxnum(int maxnum)
	{
		this.maxnum = maxnum;
	}
	public int getCurnum()
	{
		return curnum;
	}
	public void setCurnum(int curnum)
	{
		this.curnum = curnum;
	}
	public String getDayofweek()
	{
		return dayofweek;
	}
	public void setDayofweek(String dayofweek)
	{
		this.dayofweek = dayofweek;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getRoomname()
	{
		return roomname;
	}
	public void setRoomname(String roomname)
	{
		this.roomname = roomname;
	}
	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	public String getTeachname()
	{
		return teachname;
	}
	public void setTeachname(String teachname)
	{
		this.teachname = teachname;
	}
	
	
	
}
