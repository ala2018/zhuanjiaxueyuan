package com.Business;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import com.Bean.ArticleBean;
import com.Dao.SqlDao;


public class FileBusiness {

	public boolean savefile(String filename,InputStream filesource) {
		File newf =new File("F:/Eclipse for Java EE/eclipse-workspace/SecondSystem/WebContent/Data/"+filename);
		
		
		if(!newf.exists()) {
			try {
				if(!newf.createNewFile()) {
					System.out.println("文件创建失败");
					return false;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		try {
			FileOutputStream outfile=new FileOutputStream(newf);
			
			byte nef[]=new byte[1024];
			int n;
			while ((n=filesource.read(nef))!=-1) {
				
				outfile.write(nef, 0, n);
			}
			outfile.close();
			filesource.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public boolean downloadArticle(String filename,OutputStream filesource) {
		SqlDao sqldao =new SqlDao();
		ArticleBean art=new ArticleBean();
		String sql="select * from Article_table where [id]="+filename.trim();
		     art=sqldao.getAllmessage(sql,art).get(0);
				if(art==null) {
					System.out.println("资源不存在!");
			        return false;
		}
		try {		
                filesource.write(art.getContents().getBytes());
			filesource.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
	public boolean downloadfile(String filename,OutputStream filesource) {
		File newf =new File("F:/Eclipse for Java EE/eclipse-workspace/SecondSystem/WebContent/Data/"+filename);
		if(!newf.exists()) {
					System.out.println("资源不存在!");
			        return false;
		}
		try {
			FileInputStream infile=new FileInputStream(newf);
			
			byte nef[]=new byte[1024];
			int n;
			while ((n=infile.read(nef))!=-1) {
				
				filesource.write(nef, 0, n);
			}
			infile.close();
			filesource.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		
	}
	
//浏览器上传文件会连同文件名上传，所以使用这个上传功能
	
	public boolean uploadfile(InputStream filesource) {
		String temp="temp";
		if(savefile(temp,filesource))
		{
			try {
				File tem=new File("F:/Eclipse for Java EE/eclipse-workspace/SecondSystem/WebContent/Data/temp");
				RandomAccessFile randfile=new RandomAccessFile(tem,"r");
			    randfile.readLine();
			    String str=randfile.readLine();
			    int start=str.lastIndexOf("=")+2;
			    int end=str.lastIndexOf("\"");
			    String filename=str.substring(start, end);//找到文件名称
			    		
			    randfile.seek(0);
			    long starindex=0;   //获得文件内容开始区域
			    int i=1;
			    int n=0;
			    while((n=randfile.readByte())!=-1 &&i<=4)
			    {
			    	if(n=='\n') {
			    		starindex=randfile.getFilePointer();
			    		i++;
			    	}
			    }
			    starindex--;
			    
			    randfile.seek(randfile.length());
			    long endindex=randfile.getFilePointer();   //获得文件内容结束区域
			    int j=1;
			    while((endindex>=0&&j<=2))
			    {
			    	endindex--;
			    	randfile.seek(endindex);
			    	if(randfile.readByte()=='\n') {
			    		j++;
			    	}
			    }
			    
			    
			    File newf=new File("F:/Eclipse for Java EE/eclipse-workspace/SecondSystem/WebContent/Data/"+filename);
			    if(!newf.exists()) {
			    	if(!newf.createNewFile()) {
			    	randfile.close();
			    	tem.delete();
			    	return false;
			    	}
			    	}
			    RandomAccessFile randnewfile=new  RandomAccessFile(newf,"rw");
			    randfile.seek(starindex);
			    while(starindex<endindex) {
			    	randnewfile.write(randfile.readByte());
			    	starindex=randfile.getFilePointer();
			    }
			    randnewfile.close();
		    	randfile.close();
		    	tem.delete();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else
		return false;
		
	  return true;	
	}
	
}
