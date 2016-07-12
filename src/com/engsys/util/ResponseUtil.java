package com.engsys.util;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class ResponseUtil
{
	public static void write(HttpServletResponse resp,String json)throws Exception
	{
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out=resp.getWriter();
		out.println(json);
		out.flush();
		out.close();
	}	
}
