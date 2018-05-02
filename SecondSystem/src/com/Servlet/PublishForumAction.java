package com.Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.ForumBean;
import com.Business.ForumBusiness;

public class PublishForumAction extends HttpServlet {
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp){
			// TODO Auto-generated method stub
			doPost(req, resp);
		}

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				 {
			// TODO Auto-generated method stub
			//设置页面编码格式
			try { 
				//System.out.println("文字编码");
				req.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resp.setCharacterEncoding("utf-8");
			resp.setContentType("text/html;charset=utf-8");//更改响应编码格式
		    ForumBusiness article =new ForumBusiness();
		    ForumBean artbean=new ForumBean();
		     Date date=new Date();
		     artbean.setSendtime(date);
		     artbean.setTitle(req.getParameter("title").trim());
		     artbean.setId((int)((Math.random()*9+1)*10000));
		     artbean.setContents(req.getParameter("contents").trim());
		     artbean.setsender(req.getParameter("author"));
		     artbean.setClassification(req.getParameter("Classification"));
		     List<ForumBean> list=new ArrayList<ForumBean>();
		     list.add(artbean);
		     article.publish(list);	     
		     try {
				resp.sendRedirect("personHome.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     
		}


}
