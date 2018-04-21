package com.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.FileBusiness;

public class DownArticleAction extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String filename=req.getParameter("filename");
		resp.setContentType("application/x-msdownload");
		filename=filename+".txt";
		resp.setHeader("Content-disposition","attachment;filename="+new String(filename.getBytes("utf-8"),"iso8859-1"));
		ServletOutputStream op=resp.getOutputStream();
		FileBusiness ft =new FileBusiness();
		if(!ft.downloadArticle(req.getParameter("filename"),op))
		{
			req.setAttribute("errorResult","资源不存在!");
		}
		//RequestDispatcher dis=req.getRequestDispatcher("showwenzhang.jsp");
		//dis.forward(req, resp);
	}
}
