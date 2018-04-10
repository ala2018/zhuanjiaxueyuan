package com.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.XueyuanBean;
import com.Bean.ZhuanjiaBean;
import com.Business.ZhuceBusiness;

public class ZhuceAction extends HttpServlet {

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
				if(req.getParameter("xuanze").equals("专家用户")) {
		ZhuanjiaBean zjb=new ZhuanjiaBean();
	   zjb.setAccout(req.getParameter("accout1").trim());
	    zjb.setPwd(req.getParameter("pwd11").trim());
	    zjb.setName(req.getParameter("name1").trim());
	   zjb.setEmail(req.getParameter("email1"));
	   
	    zjb.setSex(req.getParameter("sex1").trim());
	    
	    List<ZhuanjiaBean> list=new ArrayList<ZhuanjiaBean>();
	    list.add(zjb);
	    ZhuceBusiness zcb=new ZhuceBusiness();
	    zcb.zhuce_zhuanjia("Zhuanjia_table", list); 
				}
				
				else{
					XueyuanBean zjb=new XueyuanBean();
				   zjb.setAccout(req.getParameter("accout1").trim());
				    zjb.setPwd(req.getParameter("pwd11").trim());
				    zjb.setName(req.getParameter("name1").trim());
				   zjb.setEmail(req.getParameter("email1"));
				   
				    zjb.setSex(req.getParameter("sex1").trim());
				    
				    List<XueyuanBean> list=new ArrayList<XueyuanBean>();
				    list.add(zjb);
				    ZhuceBusiness zcb=new ZhuceBusiness();
				    zcb.zhuce_xueyuan("Xuesheng_table", list); 
							}
					
	    
	}

}
