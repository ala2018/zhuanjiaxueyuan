package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.ArticleBusiness;


public class getMyArticleAction extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 resp.setContentType("text/xml;charset=UTF-8");
		  resp.setCharacterEncoding("utf-8");
	        resp.setHeader("Cache-control", "no-cache");
		String user=req.getParameter("user"); 
		String page=req.getParameter("page");
		ArticleBusiness artb=new ArticleBusiness();
		String xml=artb.getmyarticle(user,"3",page);
	   resp.getWriter().println(xml);
	}
}
