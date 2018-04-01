package com.Dao;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.*;
import javax.sql.DataSource;
public class Datapool {
	Connection conn;
	DataSource ds;
	Context    ctx;
	public Datapool() {
		try {
			ctx        =new InitialContext();
			ctx        =(Context)ctx.lookup("java:comp/env");
			 ds        =(DataSource)ctx.lookup("jdbc/Second");
			conn       = ds.getConnection();
			
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//获得一个数据库连接
	public Connection getConn() {
		
		return this.conn;
	}

    	
public void close() {
	
	try {
		this.conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

    
}

