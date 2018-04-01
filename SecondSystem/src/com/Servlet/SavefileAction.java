package com.Servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Business.FileBusiness;

public class SavefileAction extends HttpServlet{

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
		InputStream inp=req.getInputStream();
		FileBusiness ft=new FileBusiness();
		if(ft.uploadfile(inp)) {
		req.setAttribute("result", "文件上传成功");
		}
		RequestDispatcher dis=req.getRequestDispatcher("logo.jsp");
		dis.forward(req, resp);
		
		
	}

}
