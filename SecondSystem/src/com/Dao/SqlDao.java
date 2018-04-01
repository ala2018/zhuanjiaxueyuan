package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Dao.Datapool;

public class SqlDao {

	
    private  Connection   conn= null;
    private  Statement    stmt= null;
    private  PreparedStatement ps = null;
    private  ResultSet    rs= null;
    private  Datapool     dp= null;
    
    
    
	public SqlDao() {
		super();
		 dp         = new Datapool();
		 conn        = dp.getConn();
	}
  

    public  Connection getCon() {
        return conn;
    }
 
    public  PreparedStatement getPs() {
        return ps;
    }
 
    public  ResultSet getRs() {
        return rs;
    }
    
    
	private  Connection getConnection() {
		// TODO Auto-generated method stub
		conn        = dp.getConn();
		return conn;
	}
	  /**
     * 关闭连接
     * 
     * @param rs
     *            结果集对象
     * @param ps
     *            会话对象
     * @param conn
     *            连接对象
     */
    public  void closeAll() {
        try {
            if (null != rs) {
                rs.close();
            }
            if (null != ps) {
                ps.close();
            }
            if (null != conn) {
                conn.close();
            }
            if (null != dp) {
                dp.close();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	//查询方法   sql写查询某个表，T中存放想要查询的字段名,以空格分割
		public ArrayList<ArrayList<String>> getAllmessage(String sql ,String T){
			ArrayList<ArrayList<String>> tablelist =new ArrayList<ArrayList<String>>();
			ArrayList<String>           t;
			String[] Ta=T.split(" ");
			try {
				stmt        =conn.createStatement();
				rs        =stmt.executeQuery(sql);
				while(rs.next()) {
					t=new ArrayList<String>();
					for(int i=0;i<Ta.length;i++) {
					t.add(rs.getString(Ta[i]));
					}
					tablelist.add(t);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tablelist;
		}
		
		//字段名查询方法
		
		public String[] getcolmName(String table) {
			 String[] col=null;
			 String sql=" select * from "+table+" where 1=2";
			try {
				stmt        =conn.createStatement();
				rs        =stmt.executeQuery(sql);
				ResultSetMetaData rsd = rs.getMetaData(); 
				String key="";
				for(int i=0;i<rsd.getColumnCount();i++) {
					key=key+rsd.getColumnName(i+1)+" ";
				}
				rs.close();
				col=key.split(" ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return col;
		}
		//插入方法   需要表，T中存放插入值,以空格分割
		public void insrt(String table ,String T){
		
			String[] t=T.split(" ");
	String sql=" insert into "+table+ " value(";
		for(int i=0;i<t.length-1;i++) {
			sql=sql+"'"+t[i]+"',";
		}	
              sql=sql+"'"+t[t.length-1]+"') ";
		
              try {
            	  stmt=conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
		
		   public static void setParams(List<String> params, PreparedStatement ps) {
		        if (params != null) {
		            for (int i = 0; i < params.size(); i++) {
		                try {
		                    ps.setString(i + 1, params.get(i)); //将指定的参数设置为给定的Java String值。
		                } catch (SQLException e) {
		                    // TODO Auto-generated catch block
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
		
	    public  int Sql(String sql,List<String> params){     //支持sql增删改查
	    	int rs=0;
	  	  try {
	            if (conn == null || conn.isClosed()) {
	               getConnection();
	            }
	            ps=conn.prepareStatement(sql);
	            setParams(params,ps);	
	            rs =ps.executeUpdate();
		  }
		  catch (SQLException e) {
	             e.printStackTrace();
	         }
	         return rs;
	    }


	/*    public static void main(String[] args) {
	    	int rs=0;
	    	String sql="insert into Zhuanjia_table  values(?,?,?,?)";
	    	List<String> parms = new ArrayList<String>();
	    	SqlDao test =new SqlDao();
	    	
	    	parms.add("0631104");
	    	parms.add("郭翔");
	    	parms.add("男");
	    	parms.add("2018-02-01");
	    	parms.add("123456");
	    	                                          //使用例子
	    	rs =test.Sql(sql,parms);
	    	
	    	if(rs!= 0)
	    		System.out.println("成功");
	    	else
	    		System.out.println("失败");
	    	
	    		
	    	
	    }
		
		*/
		
		

}

