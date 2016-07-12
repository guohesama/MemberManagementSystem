package com.engsys.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
@WebFilter("/*")
public class EncoderFilter implements Filter
{
	
	@Override
	public void destroy(){}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
		   HttpServletRequest req=(HttpServletRequest)arg0;
		   HttpServletResponse resp=(HttpServletResponse)arg1;
		   MyRequest myreq=new MyRequest(req);
		   String basepath=myreq.getScheme()+"://"+myreq.getServerName()+":"+myreq.getServerPort()+myreq.getContextPath()+"/";
		   MyResponse myresp=new MyResponse(resp,basepath);
		   arg2.doFilter(myreq, myresp);         
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException{}
   
	class MyRequest extends HttpServletRequestWrapper
    {
		public MyRequest(HttpServletRequest request)
		{
			super(request);
		}

		@Override
		public String getParameter(String name)
		{
			String re=null;
			try
			{
			
			re=super.getParameter(name);
		     if(null!=re)
              re=new String(re.getBytes("iso-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e)
			{
				System.out.println("ERROR_222_请求编码出错...");
				e.printStackTrace();
			}
			return re;
		}
		
       	
    }
	class MyResponse extends HttpServletResponseWrapper
	{
		String basepath=null;
		public MyResponse(HttpServletResponse response,String basepath)
		{
			super(response);
			this.basepath=basepath;
		}

		@Override
		public void sendError(int sc, String msg) throws IOException
		{
			if(sc==404||sc==505||sc==500)
			{
				this.setStatus(200);
				super.sendRedirect(this.basepath+"error.html");
			}
		}

		@Override
		public void sendError(int sc) throws IOException
		{
			if(sc==404||sc==505||sc==500)
			{
				this.setStatus(200);
				super.sendRedirect(this.basepath+"error.html");
			}
		}
		
		
	}
}
