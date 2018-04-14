package com.Business;

import java.util.List;

import com.Bean.ArticleBean;
import com.Dao.SqlDao;


public class ArticleBusiness {

	public ArticleBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void publish(List<ArticleBean> list){
		SqlDao sqldao=new SqlDao();
		String table="Article_table";
		String value="(?,?,?,?,?,?)";
		sqldao.insert(table, value, list);
	}
	public List<ArticleBean> readallarticle(){
		SqlDao sqldao =new SqlDao();
		String sql="select * from Article_table ";
		return sqldao.getAllmessage(sql,new ArticleBean());
	}
}
