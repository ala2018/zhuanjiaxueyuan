package com.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.Dao.Datapool;
import java.lang.reflect.*;

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
	
	//将数据库查询的数据封装在javaBean中
	private <T>List<T> getBean(ResultSet rs,T object){
	       
		Class classType=object.getClass();
		List<T> objlist=new ArrayList<T>();
		Field[] fields=classType.getDeclaredFields();
		try {
			while(rs.next()) {
				T objectcopy=(T)classType.getConstructor(new Class[] {}).newInstance(new Object[] {});
				for(int i=0;i<fields.length;i++) {
					Field field=fields[i];
					String fieldName=field.getName();
					Object value=null;
					
					if(field.getType().equals(String.class)) {
						value=rs.getString(fieldName);
						if(value==null) {
							value="";
						}
					}
					
					if(field.getType().equals(int.class)) {
						value=rs.getInt(fieldName);
					}
					
					
					if(field.getType().equals(java.util.Date.class)) {
						value=rs.getDate(fieldName);
					}
					
					//属性首字母转为大写。。。。。
					String fristletter=fieldName.substring(0, 1).toUpperCase();
					String setMethodName="set"+fristletter+fieldName.substring(1);//获得方法名称
					Method setMethod=classType.getMethod(setMethodName, new Class[] {field.getType()});
					setMethod.invoke(objectcopy, new Object[] {value});	
					
				}
				
				objlist.add(objectcopy);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return objlist;	
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
			col=key.trim().split(" ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return col;
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
		
		
		//查询方法   sql写查询某个表，T中存放想要查询的字段名,以空格分割
		public <T>List<T> getAllmessage(String sql ,T obj){
			List<T> tablelist=new ArrayList<T>();
			try {
				stmt        =conn.createStatement();
				rs        =stmt.executeQuery(sql);
	               tablelist=getBean(rs,obj);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return tablelist;
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
		
		
		public <T> void insert(String table,String value,List<T> object) {
			 String[] colname=getcolmName(table);   //获取这个表的所有属性名
			String getMethodName="";
			for(int i=0;i<colname.length;i++) {
			//属性首字母转为大写。。。。。
				System.out.println(colname[i]);
			String fristletter=colname[i].substring(0, 1).toUpperCase();
			 getMethodName=getMethodName+"get"+fristletter+colname[i].substring(1)+" ";//获得方法名称
			}
			String[] getMethodNames=getMethodName.trim().split(" ");//获得所有方法名称数组
		       String sql=" insert into "+table+" values"+value;
		       for(int i=1;i<object.size();i++) {
		    	   sql=sql+","+value;
		       }
		  	  try {
		            if (conn == null || conn.isClosed()) {
		               getConnection();
		            }
		            ps=conn.prepareStatement(sql);
		            Method setMethod=null;
		            Object val=null;
		           
	                 for(T t:object) {
	                	 for(int i=0;i<getMethodNames.length;i++) {
	                setMethod=t.getClass().getMethod(getMethodNames[i], new Class[] {});// 获得方法
	                val=setMethod.invoke(t, new Object[] {});//使用方法
	                System.out.println(val);
	                if(setMethod.getReturnType().equals(String.class)) {
	                	if(val==null)
	                		val="";
	                	ps.setString(i+1, (String)val); 
	                }
	                else
	                if(setMethod.getReturnType().equals(int.class)) {
	                
	                	ps.setInt(i+1, (int) val); 
	                }
	                else
	                if(setMethod.getReturnType().equals(java.util.Date.class)) {
	                	java.util.Date da=(java.util.Date) setMethod.invoke(t, new Object[] {});
	         
	                	ps.setDate(i+1,new java.sql.Date(da.getTime()));
	                }else
	                	
	                {
	         
	                	ps.setString(i+1, (String) val);}
	                	 }
	                	 
	                 }
		            
		            ps.executeUpdate();
			  }
			  catch (SQLException e) {
		             e.printStackTrace();
		         } catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
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
		
	    public  int Sql(String sql,List<String> params){     //支持sql删改
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


			

}

