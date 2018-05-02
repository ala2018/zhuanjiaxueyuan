package com.Servlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.Bean.ArticleBean;
import com.Business.ArticleBusiness;

public class getAllarticleAction extends HttpServlet {
    public getAllarticleAction() {
    	super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/xml;charset=UTF-8");
		  resp.setCharacterEncoding("utf-8");
	        resp.setHeader("Cache-control", "no-cache");
		HttpSession session=req.getSession();
		String page= req.getParameter("page");
		 ArticleBusiness zjd=new ArticleBusiness();
		 List<ArticleBean> list =new ArrayList<ArticleBean>();
		 list=zjd.readallarticle("5",page);
			session.setAttribute("list", list);
			if(page.equals("1"))
			resp.sendRedirect("show.jsp");
			else
			 {  StringBuffer xml = new StringBuffer();
			        String hre="";
			        int i=0;
			    for(ArticleBean art:list){
			    	hre="showwenzhang.jsp?tindex="+i;
			    	          i++;
				 xml.append("<fieldset style='border:3px solid blue;'><legend>文章</legend><div style='border:1px solid red;'>");
			       xml.append("<h4><a class='wenzhangbiaoti' href='"+hre+"'>"+art.getTitle()+"</a></h4>");
			        xml.append("<p><a class='zuozhe' href='' >作者:"+art.getAuthor()+"</a></p>");
			        xml.append("<p><a class='fenlei' href=''>文章分类:"+art.getClassification()+"</a></p><div>");
			          xml.append("<p>简介</p>"+art.getContents().substring(0,100)+"..."+"</div></div>");
			     xml.append("<div><p>时间:"+art.getDate()+"</p></div></fieldset>");
				}
				resp.getWriter().println(xml.toString());
			 }
	}

}
