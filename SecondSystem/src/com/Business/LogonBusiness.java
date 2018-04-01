package com.Business;
import java.util.ArrayList;
import com.Bean.ZhuanjiaBean;
import com.Dao.SqlDao;


public class LogonBusiness {
	SqlDao sqldao;
	ZhuanjiaBean zjb;
	public LogonBusiness() {
		super();
			 sqldao    = new SqlDao();

	}

   
	
	public ArrayList<ZhuanjiaBean> getAllmessage(String where){
		ArrayList<ZhuanjiaBean> zjlist =new ArrayList<ZhuanjiaBean>();
		ZhuanjiaBean             zjb;
        
		String t="zhuanjia_user zhuanjia_name zhuanjia_sex zhuanjia_logindate";
		String sql=" select * from Zhuanjia_table "+where;
	
			ArrayList<ArrayList<String>> rs= sqldao.getAllmessage(sql, t);
			for(int i=0;i<rs.size();i++) {
				zjb=new ZhuanjiaBean();
				zjb.setZhuanjia_user(rs.get(i).get(0));
				zjb.setZhuanjia_name(rs.get(i).get(1));
				zjb.setZhuanjia_sex(rs.get(i).get(2));
				zjb.setZhuanjia_logindate(rs.get(i).get(3)); 
				zjlist.add(zjb);
			}
			 sqldao.closeAll();
		return zjlist;
		
	}
	//登录检查
	public boolean Login(String user,String pwd) {
		          user=user.trim();
		          pwd=pwd.trim();
		           
		      String sql="select * from Zhuanjia_table where zhuanjia_user ='"+user+"' and zhuanjia_pwd='"+pwd+"'";
		     String t="zhuanjia_user zhuanjia_name";
		      ArrayList<ArrayList<String>> rs  =sqldao.getAllmessage(sql, t);
		              sqldao.closeAll();
				 if(rs.size()==1) 
				       return true;
				 
		return false;
	}
	
	

	
	
	
}
