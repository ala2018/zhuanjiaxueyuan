package com.Bean;

public class ZhuanjiaBean {
     private String accout=null;
     private String pwd=null;
     private String sex=null;
     private String name=null;
     private String email=null;
     
     public ZhuanjiaBean() {
 		super();
 	
 	}
	public ZhuanjiaBean(String accout, String pwd, String sex, String name, String email) {
		this.accout = accout;
		this.pwd = pwd;
		this.sex = sex;
		this.name = name;
		this.email = email;
	}
	public String getAccout() {
		return accout;
	}
	public void setAccout(String accout) {
		this.accout = accout;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
     

}
