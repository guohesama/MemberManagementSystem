package com.engsys.servlet.core;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.engsys.pojo.Member;
import com.engsys.service.core.AdminOperationService;
import com.engsys.service.core.AdminService;
import com.engsys.service.core.MemberOpreationService;
import com.engsys.service.core.RecordService;
import com.engsys.service.imp.AdminOperationServiceImp;
import com.engsys.service.imp.AdminServiceImp;
import com.engsys.service.imp.MemberOpreationServiceImp;
import com.engsys.service.imp.RecordServiceImp;

public abstract class ServletBase extends HttpServlet
{
	protected AdminService  as=new AdminServiceImp();
	protected RecordService rs=new RecordServiceImp();
	protected AdminOperationService aos=new AdminOperationServiceImp();
	protected MemberOpreationService mos=new MemberOpreationServiceImp();
	
	public abstract void execute(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, Exception;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		String action=null!=req.getParameter("action")?req.getParameter("action"):"execute";
	    Class clazz=this.getClass();
	    Class[]param=new Class[]{HttpServletRequest.class,HttpServletResponse.class};
	    try
		{
			Method method=clazz.getMethod(action, param);
			if(null!=method)
			{
				Object[] objs=new Object[]{req,resp};
				method.invoke(this, objs);				
			}
		} catch (Exception e)
		{
			System.out.println("ERROR_0000_ServletBase出错");
			e.printStackTrace();
		}	
	}
	
	
    /**
     * 用于获取用户请求参数
     * @param req
     * @param param
     * @return
     */
    public String getString(HttpServletRequest req,String param)
    {
    	String re=null;
    	re=null!=req.getParameter(param)?req.getParameter(param):"";
    	return re;
    }
     
    public String[] getStringArray(HttpServletRequest req,String param)
    {
    	String []re=null;
    	re=req.getParameterValues(param);
    	return re;
    }
   /**
    * 获取整数 
    * @param req
    * @param param
    * @return
    */
    public int getInt(HttpServletRequest req,String param)
    {
    	int re=0;
    	String sre=this.getString(req, param);
    	if(sre.matches("\\d+"))
    	{
    		re=Integer.parseInt(sre);
    	}
    	return re;
    }
    public float getFloat(HttpServletRequest req,String param)
    {
    	float re=0;
    	String sre=this.getString(req, param);
    	if(sre.matches("[\\d]+\\.[\\d]+"))
    	{
    		re=Float.parseFloat(sre);
    	}
    	return re;
    }
    /**
     * 将用户请求参数直接帮定到对象obj<jsp:usebean id="" class=''/?
     * @param req
     * @param obj
     */
    public void getBean(HttpServletRequest req,Object obj)
    {
    	Class clazz=obj.getClass();
    	Field[] allf=clazz.getDeclaredFields();
    	try
		{
			if(null!=allf)
			{
				for(Field field:allf)
				{
					field.setAccessible(true);
					Class classtype=field.getType();
					if(classtype==String.class)
					{
						field.set(obj, this.getString(req, field.getName()));
					}else if(classtype==int.class||classtype==Integer.class||classtype==Integer.TYPE)
					{
						field.set(obj, this.getInt(req, field.getName()));
					}else if(classtype==Date.class)
					{
						String svalue=this.getString(req,field.getName());
						//Date date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(svalue);
						Date date=new SimpleDateFormat("yyyy-MM-dd").parse(svalue);
						field.set(obj, date);
					}
					else if(classtype==float.class||classtype==Float.class||classtype==Float.TYPE)
					{
						field.set(obj, this.getFloat(req, field.getName()));
					}
				}
			}
		} catch (Exception e)
		{
			System.out.println("ERROR_111_ServletBase出错...");
			e.printStackTrace();
		}
    	
    }
    
    public void forward(HttpServletRequest req, HttpServletResponse resp,String path)throws ServletException, IOException
    {
    	RequestDispatcher rd=req.getRequestDispatcher("/WEB-INF/"+path);
    	rd.forward(req, resp);
    	
    }    
}
