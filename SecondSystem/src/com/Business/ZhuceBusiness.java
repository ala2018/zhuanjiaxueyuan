package com.Business;

import java.util.List;

import com.Dao.SqlDao;

public class ZhuceBusiness {

	public ZhuceBusiness() {
		super();
		// TODO Auto-generated constructor stub
	}
    SqlDao sdao=new SqlDao();
    
    public <T>void  zhuce_zhuanjia(String table,List<T> object) {
    	String value="(?,?,?,?,?)";
    	sdao.insert(table, value, object);
    	
    }
    public <T>void  zhuce_xueyuan(String table,List<T> object) {
    	String value="(?,?,?,?,?)";
    	sdao.insert(table, value, object);
    	
    }
	
}
