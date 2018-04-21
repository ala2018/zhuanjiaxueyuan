package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.ArticleBean;
import com.Business.ArticleBusiness;

public class PublishArticleAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置页面编码格式
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");//更改响应编码格式
	     ArticleBusiness article =new ArticleBusiness();
	     ArticleBean artbean=new ArticleBean();
	     Date date=new Date();
	     artbean.setDate(date);
	     artbean.setTitle(req.getParameter("title"));
	     artbean.setId((int)((Math.random()*9+1)*10000));
	     artbean.setContents(req.getParameter("contents"));
	     artbean.setClassification(req.getParameter("Classification"));
	     artbean.setAuthor(req.getParameter("author"));
	     List<ArticleBean> list=new ArrayList<ArticleBean>();
	     list.add(artbean);
	     article.publish(list);
	     resp.sendRedirect("personHome.jsp");
	     
	}

}
