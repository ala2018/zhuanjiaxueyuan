package com.Servlet;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.Business.ArticleBusiness;

public class ZhuanjiaAllmessageAction extends HttpServlet {
    public ZhuanjiaAllmessageAction() {
    	super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session=req.getSession();
		String whe=req.getParameter("zixunsousuo");
		
		 ArticleBusiness zjd=new ArticleBusiness();
               //SqlDao zjd=new SqlDao();
              // String sql="select *from Zhuanjia_table ";
              // String T="zhuanjia_user zhuanjia_name zhuanjia_sex zhuanjia_logindate";
			session.setAttribute("list", zjd.readallarticle());
			resp.sendRedirect("show.jsp");
	}

}
