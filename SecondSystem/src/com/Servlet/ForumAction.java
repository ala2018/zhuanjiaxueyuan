package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.ForumBean;

public class ForumAction extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
				//设置页面编码格式
						req.setCharacterEncoding("UTF-8");
						resp.setCharacterEncoding("utf-8");
						resp.setContentType("text/html;charset=utf-8");//更改响应编码格式
						
						ForumBean fb = new ForumBean();
						fb.setclassification(req.getParameter("classification").trim());
						fb.settitle(req.getParameter("title").trim());
						fb.setcontents(req.getParameter("contents").trim());
						fb.setsender(req.getParameter("sender").trim());
						
						
						
	
	}

}
