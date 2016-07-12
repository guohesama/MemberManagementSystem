package com.engsys.service.core;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;

import com.engsys.dbcore.ConnectionManager;

public class ServiceBase 
{
	protected QueryRunner run=new QueryRunner();
	protected Connection getConnection()
	{
		return ConnectionManager.getConnection();
	}
}
