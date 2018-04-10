package com.Business;
import java.util.ArrayList;
import java.util.List;

import com.Bean.ZhuanjiaBean;
import com.Dao.SqlDao;


public class LogonBusiness {
	SqlDao sqldao;
	ZhuanjiaBean zjb;
	public LogonBusiness() {
		super();
			 sqldao    = new SqlDao();

	}

   
	
	public List<ZhuanjiaBean> getAllmessage(String where){
		List<ZhuanjiaBean> zjlist =new ArrayList<ZhuanjiaBean>();
		ZhuanjiaBean             zjb;
        
		String t="zhuanjia_user zhuanjia_name zhuanjia_sex zhuanjia_logindate";
		String sql=" select * from Zhuanjia_table "+where;
	        ZhuanjiaBean zhuanjia=new ZhuanjiaBean();
	        zjlist=sqldao.getAllmessage(sql, zhuanjia);
			/*ArrayList<ArrayList<String>> rs= sqldao.getAllmessage(sql, t);
			for(int i=0;i<rs.size();i++) {
				zjb=new ZhuanjiaBean();
				zjb.setZhuanjia_user(rs.get(i).get(0));
				zjb.setZhuanjia_name(rs.get(i).get(1));
				zjb.setZhuanjia_sex(rs.get(i).get(2));
				zjb.setZhuanjia_logindate(rs.get(i).get(3)); 
				zjlist.add(zjb);
			}*/
			 sqldao.closeAll();
		return zjlist;
		
	}
	//专家登录检查
	public boolean zhuanjia_Login(String user,String pwd) {
		          user=user.trim();
		          pwd=pwd.trim();
		           
		      String sql="select * from Zhuanjia_table where accout ='"+user+"' and pwd='"+pwd+"'";
		     String t="accout pwd";
		      ArrayList<ArrayList<String>> rs  =sqldao.getAllmessage(sql, t);
		    	  
		              sqldao.closeAll();
				 if(rs.size()==1) 
				       return true;
				 
		return false;
	}
	
	//学员登录检查
	public boolean xueyuan_Login(String user,String pwd) {
		          user=user.trim();
		          pwd=pwd.trim();
		           
		      String sql="select * from Xuesheng_table where accout ='"+user+"' and pwd='"+pwd+"'";
		     String t="accout pwd";
		      ArrayList<ArrayList<String>> rs  =sqldao.getAllmessage(sql, t);
		    	  
		              sqldao.closeAll();
				 if(rs.size()==1) 
				       return true;
				 
		return false;
	}

	
	
	
}
