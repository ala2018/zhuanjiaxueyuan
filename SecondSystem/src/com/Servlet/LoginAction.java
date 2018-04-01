package com.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.Business.LogonBusiness;;
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
		 LogonBusiness zjd=new LogonBusiness();
		String             user=req.getParameter("zhuanjia_user");
		String pwd         =req.getParameter("pwd");
		if(zjd.Login(user, pwd)) {
		
			resp.sendRedirect("Home/logo.jsp");
			
		}
		else {
			resp.sendRedirect("fail.jsp");	
			}
		
		
	}
     
}
