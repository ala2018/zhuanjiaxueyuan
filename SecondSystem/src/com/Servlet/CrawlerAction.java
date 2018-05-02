package com.Servlet;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Tool.CrawlerTool;

import edu.uci.ics.crawler4j.crawler.CrawlController;

public class CrawlerAction extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//设置页面编码格式
		//req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");//更改响应编码格式
		
		String key=new String(req.getParameter("key").getBytes("iso-8859-1"),"utf-8");
		System.out.println(key);
		     //key="开启中国新时代政治道路";
		Vector<String> htmlBuffer=new Vector<String>();
		CrawlerTool ct=new CrawlerTool();
		ct.setKey(key);
		ct.setHtmlBuffer(htmlBuffer);
		try {
			CrawlController ccl=ct.configController(-1);
			Thread myth=new myThread(ccl,htmlBuffer,resp);
			myth.start();
			ct.startController(ccl, 10);
			myth.interrupt();
			//resp.getWriter().println(htmlBuffer.get(0));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(req, resp);
		
		
	}
	  private class myThread extends Thread {
		   
		   CrawlController con;
	          int i=0;
		   Vector<String> buffer;
		   HttpServletResponse resp;
	  		    public myThread(CrawlController controller,Vector<String> buffer,HttpServletResponse resp){
	  		    	con=controller;
	  		    	this.buffer=buffer;
	  		    	this.resp=resp;
	  		    }
			public void run() {
				while (i<200){
					   i++;
					try {   
						    System.out.println(i);
 		                     if(i>198)
		                    	 con.shutdown();
		                     if(buffer.size()!=0)
		                     {  try {
								resp.getWriter().println(buffer.get(0));
								buffer.remove(0);
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		                     }
							sleep(100);
					} catch (InterruptedException  e) {
						e.printStackTrace();
					}
				}
			}
			}
}
