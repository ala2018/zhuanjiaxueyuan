package com.Business;

import java.util.ArrayList;
import java.util.List;

import com.Bean.ForumBean;
import com.Dao.SqlDao;

public class ForumBusiness {
	
	
	public ForumBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
		/*
	 * 
	 * 发表文章
	 */
		public void publish(List<ForumBean> list){
			SqlDao sqldao=new SqlDao();
			String table="Forum_table";
			String value="(?,?,?,?,?,?)";
			sqldao.insert(table, value, list);
		}
		/*
		 * 搜索所有用户文章
		 */
		public List<ForumBean> readallarticle(String size,String page){
			SqlDao sqldao =new SqlDao();
			String sql="select top "+size+" * from "+
			"(select ROW_NUMBER() OVER (order by sendtime desc) as rownumber ,* from Article_table ) "+
					" as tableA where rownumber>"+Integer.valueOf(size)*(Integer.valueOf(page)-1);
			return sqldao.getAllmessage(sql,new ForumBean());
		}
		/*
		 * 搜索用户发表的文章
		 */
		public String getmyarticle(String author,String size,String page){
			SqlDao sqldao =new SqlDao();
			String sql="select top "+size+" * from "+
			"(select ROW_NUMBER() OVER (order by date desc) as rownumber ,* from Article_table where author='"+author+"') "+
					" as tableA where rownumber>"+Integer.valueOf(size)*(Integer.valueOf(page)-1);
		 
		
		List<ForumBean> list=new ArrayList<ForumBean>();
		String xml="没有文章";
		StringBuffer builder = new StringBuffer();
		    list=sqldao.getAllmessage(sql,new ForumBean());
		  if((list.size()==0)&&(page.equals("1"))) {
			  return xml;
		  } 
		     String id="";
			  for(int i=0;i<list.size();i++) {
				  builder.append("<fieldset class=\"showcontent\">");
				  builder.append("<legend>").append(list.get(i).getClassification()).append("</legend>");
			  builder.append(" <div class=\"contentcolor\">");
			  builder.append("<a href=\"\" onclick=\"pupmuen(this);return false\"><img  src=\"./Image/xiala.jpg\"></a>");
			  id="d"+list.get(i).getId();
			  builder.append("<h4 align=\"center\">").append(list.get(i).getTitle()).append("</h4>"); 
			  builder.append("<div style=\"width:1100px;\">").append(transformhtml(list.get(i).getContents().substring(0, 100))).append("</div>");
			  builder.append("<a style=\"float:right;margin-right:5px\" href=\"\" id=\""+id+"\" onclick=\"showall(this);return false\">").append("显示全文</a>");
			  builder.append("<div style=\"width:1100px;display:none\" id=\""+id+"d\">").append(transformhtml(list.get(i).getContents().substring(100))).append("</div>");
			  builder.append("<a style=\"display:none;float:right;margin-right:5px\" href=\"\" id=\""+id.toUpperCase()+"\" onclick=\"rebackall(this);return false\">").append("收回全文</a>");
			  builder.append("<div><p>时间:").append(list.get(i).getSendtime()).append("</p></div>");
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
		/*
		 * 将空格换行转为html标签
		 * 
		 */
		public String transformhtml(String art){
			String c=art.replaceAll(" ","&nbsp");
			  c=c.replaceAll("\r\n","<br>");
			  return c;
		}
		
		/*
		 * 根据id删除对应文章
		 * 
		 */
		public int delarticle(String id) {
			SqlDao sqldao =new SqlDao();
			  String sql="delete from Forum_table where id='"+id+"'";
			  return  sqldao.Sql(sql,null);
			 
		}
}
