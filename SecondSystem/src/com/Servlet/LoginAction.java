package com.Servlet;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.Business.LogonBusiness;
public class LoginAction extends HttpServlet {

	public LoginAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置页面编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");//更改响应编码格式
		String             user=req.getParameter("user");
		
		String pwd         =req.getParameter("pwd");
		LogonBusiness lgd=new LogonBusiness();
		if(req.getParameter("xuanze").equals("专家用户")) { 
	    if(lgd.zhuanjia_Login(user,pwd))
	    		{
	    	String page="personHome.jsp";
	    	req.getSession().setAttribute("user",lgd.getUser_info());
	    	resp.sendRedirect(page);
	    	//req.getRequestDispatcher(page).forward(req, resp);
		}
		else {
			resp.sendRedirect("fail.jsp");	
			}
		}else { 
		    if(lgd.xueyuan_Login(user, pwd))
    		{
		    	String page="personHome.jsp";
		    	req.getSession().setAttribute("user", lgd.getUser_info());
		    	req.getSession().setMaxInactiveInterval(-1);
		    	resp.sendRedirect(page);
	}
	else {
		resp.sendRedirect("fail.jsp");	
		}
	}
			
			
		
	}
     
}
