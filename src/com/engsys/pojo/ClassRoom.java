package com.engsys.pojo;

import java.io.Serializable;

public class ClassRoom implements Serializable
{
	private static final long serialVersionUID = 9187897877140641483L;
	
	private int idroom;
	private String roomname;
	private int roomseatings;
	private int roombooked;
	
	public int getIdroom()
	{
		return idroom;
	}
	public void setIdroom(int idroom)
	{
		this.idroom = idroom;
	}
	public String getRoomname()
	{
		return roomname;
	}
	public void setRoomname(String roomname)
	{
		this.roomname = roomname;
	}
	public int getRoomseatings()
	{
		return roomseatings;
	}
	public void setRoomseatings(int roomseatings)
	{
		this.roomseatings = roomseatings;
	}
	public int getRoombooked()
	{
		return roombooked;
	}
	public void setRoombooked(int roombooked)
	{
		this.roombooked = roombooked;
	}
}
