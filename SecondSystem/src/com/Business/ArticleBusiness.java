package com.Business;

import java.util.ArrayList;
import java.util.List;

import com.Bean.ArticleBean;
import com.Dao.SqlDao;


public class ArticleBusiness {

	public ArticleBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
/*
 * 
 * 发表文章
 */
	public void publish(List<ArticleBean> list){
		SqlDao sqldao=new SqlDao();
		String table="Article_table";
		String value="(?,?,?,?,?,?)";
		sqldao.insert(table, value, list);
	}
	/*
	 * 搜索所有用户文章
	 */
	public List<ArticleBean> readallarticle(){
		SqlDao sqldao =new SqlDao();
		String sql="select * from Article_table ";
		return sqldao.getAllmessage(sql,new ArticleBean());
	}
	/*
	 * 搜索用户发表的文章
	 */
	public String getmyarticle(String author,String size,String page){
		SqlDao sqldao =new SqlDao();
		String sql="select top "+size+" * from "+
		"(select ROW_NUMBER() OVER (order by date desc) as rownumber ,* from Article_table where author='"+author+"') "+
				" as tableA where rownumber>"+Integer.valueOf(size)*(Integer.valueOf(page)-1);
	 
	
	List<ArticleBean> list=new ArrayList<ArticleBean>();
	String xml="没有文章";
	StringBuffer builder = new StringBuffer();
	    list=sqldao.getAllmessage(sql,new ArticleBean());
	  if((list.size()==0)&&(page.equals("1"))) {
		  return xml;
	  } 
	     String id="";
		  for(int i=0;i<list.size();i++) {
			  builder.append("<fieldset class=\"showcontent\">");
			  builder.append("<legend>").append(list.get(i).getClassification()).append("</legend>");
		  builder.append("<div class=\"contentcolor\">");
		  id="d"+list.get(i).getId();
		  builder.append("<h4 align=\"center\">").append(list.get(i).getTitle()).append("</h4>"); 
		  builder.append("<div style=\"width:1100px;\">").append(transformhtml(list.get(i).getContents().substring(0, 100))).append("</div>");
		  builder.append("<a style=\"float:right;margin-right:5px\" href=\"\" id=\""+id+"\" onclick=\"showall(this);return false\">").append("显示全文</a>");
		  builder.append("<div style=\"width:1100px;display:none\" id=\""+id+"d\">").append(transformhtml(list.get(i).getContents().substring(100))).append("</div>");
		  builder.append("<a style=\"display:none;float:right;margin-right:5px\" href=\"\" id=\""+id.toUpperCase()+"\" onclick=\"rebackall(this);return false\">").append("收回全文</a>");
		  builder.append("<div><p>时间:").append(list.get(i).getDate()).append("</p></div>");
		  builder.append("</div>");
		  builder.append("</fieldset>");
	  }   
		  if(page.equals("1")&&(list.size()<Integer.valueOf(size)))
		      return builder.toString();
		  else
		    if(page.equals("1"))
		    	 builder.append("<div class=\"showpage\"><p><span id=\"nextpage\"><a href=\"\" class=\"yang\" onclick=\"addpage();return false\">下一页</a></span></p></div>");
		           else
		        	   if((list.size()<Integer.valueOf(size))) {
		        			  builder.append("<div class=\"showpage\" ><p><span id=\"uppage\"><a href=\"\" class=\"yang\" onclick=\"subpage();return false\">上一页</a></span ></p></div>");
		        		  }
		        	   else
		                 builder.append("<div class=\"showpage\"><p><span id=\"uppage\"><a href=\"\" class=\"yang\" onclick=\"subpage();return false\">上一页</a></span ><span id=\"nextpage\"><a href=\"\" class=\"yang\" onclick=\"addpage();return false\">下一页</a></span></p></div>");
		 
		  return builder.toString();
	}
	
	public String transformhtml(String art){
		String c=art.replaceAll(" ","&nbsp");
		  c=c.replaceAll("\r\n","<br>");
		  return c;
	}
	
}
